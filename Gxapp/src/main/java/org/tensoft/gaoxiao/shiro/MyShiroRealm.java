package org.tensoft.gaoxiao.shiro;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.tensoft.gaoxiao.model.TbResource;
import org.tensoft.gaoxiao.model.TbUser;
import org.tensoft.gaoxiao.service.TbDeptService;
import org.tensoft.gaoxiao.service.TbResourceService;
import org.tensoft.gaoxiao.service.TbUserService;


//import com.feilong.core.bean.ConvertUtil;

/**
 *  身份校验核心类;
 */
public class MyShiroRealm extends AuthorizingRealm{
	
	@Resource
	private TbUserService userService;
	
	@Resource
	private TbResourceService resourceService;
	
	@Resource
	private TbDeptService deptService;

	/**
	 * 认证信息,认证回调函数,登录时调用
	 * 首先根据传入的用户名获取User信息；然后如果user为空，那么抛出没找到帐号异常UnknownAccountException；
	 * 如果user找到但锁定了抛出锁定异常LockedAccountException；最后生成AuthenticationInfo信息，
	 * 交给间接父类AuthenticatingRealm使用CredentialsMatcher进行判断密码是否匹配，
	 * 如果不匹配将抛出密码错误异常IncorrectCredentialsException；
	 * 另外如果密码重试次数太多将抛出超出重试次数异常ExcessiveAttemptsException；
	 * 在组装SimpleAuthenticationInfo信息时， 需要传入：身份信息（用户名）、凭据（密文密码）、加密盐（username+salt），
	 * CredentialsMatcher使用盐加密传入的明文密码和此处的密文密码进行匹配。
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		//获取用户的输入的账号.
	       String uAccountName = (String)token.getPrincipal();
	      Map<String, Object> map = new HashMap<String, Object>(); 
	      map.put("accountName", uAccountName);
	       //ConvertUtil.toMap 返回的是一个Map（accountName，用户名）
	      // TbUser userInfo = userService.selectUser(ConvertUtil.toMap("accountName",(Object)userName));
	      List<TbUser> userlist = userService.selectUser(map);
	      TbUser  userInfo = new TbUser();
	      if (userlist.size()<0) {
	    	  throw new UnknownAccountException();// 没找到帐号
	      }else{
			userInfo = userlist.get(0);
	      }
	       if (userInfo.getuLocked()==2) {
				throw new LockedAccountException(); // 帐号被锁定
			}
			// 从数据库查询出来的账号名和密码,与用户输入的账号和密码对比
			// 当用户执行登录时,在方法处理上要实现subject.login(token);
			// 然后会自动进入这个类进行认证
			// 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得shiro自带的不好可以自定义实现
	       SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
	    		   userInfo, // 用户对象
	    		   userInfo.getuPassword(), // 密码
				   ByteSource.Util.bytes(uAccountName + userInfo.getuCredentialsSalt()),// salt=username+salt
				   getName() // realm name
			);
		    // 当验证都通过后，把用户信息放在session里
			Session session = SecurityUtils.getSubject().getSession();
			//com.baomidou.mybatisplus.service.impl selectById 根据 ID 查询 
			userInfo.setDept(deptService.get(userInfo.getuDeptId())); //组治信息
			// 用户对象
			session.setAttribute("userSession", userInfo);
	       return authenticationInfo;
	}

	/**
     * 此方法调用  hasRole,hasPermission的时候才会进行回调.
     *
     * 权限信息.(授权):
     * 1、如果用户正常退出，缓存自动清空；
     * 2、如果用户非正常退出，缓存自动清空；
     * 3、如果我们修改了用户的权限，而用户不退出系统，修改的权限无法立即生效。
     * （需要手动编程进行实现；放在service进行调用）
     * 在权限修改后调用realm中的方法，realm已经由spring管理，所以从spring中获取realm实例，
     * 调用clearCached方法；
     * :Authorization 是授权访问控制，用于对用户进行的操作授权，证明该用户是否允许进行当前操作，如访问某个链接，某个资源文件等。
     * @param principals
     * @return
     */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		 /*
	        * 当没有使用缓存的时候，不断刷新页面的话，这个代码会不断执行，
	        * 当其实没有必要每次都重新设置权限信息，所以我们需要放到缓存中进行管理；
	        * 当放到缓存中时，这样的话，doGetAuthorizationInfo就只会执行一次了，
	        * 缓存过期之后会再次执行。
	        */
	       TbUser user  = (TbUser)principals.getPrimaryPrincipal();
	       if (user != null) {
	    	   //根据用户信息 获取他的权限
	    	   List<TbResource> resourceList = resourceService.findResourcesByUserId(user.getuId());
	    	   SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
	    	   info.addRole(user.getRole().getrName());
	    	   for (TbResource resourceEntity : resourceList) {
					info.addStringPermission(resourceEntity.getSourceKey());
				}
	    	   return info;
	       }
	       return null;
	    }
}
