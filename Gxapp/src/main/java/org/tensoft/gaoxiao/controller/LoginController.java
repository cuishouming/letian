package org.tensoft.gaoxiao.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.tensoft.gaoxiao.model.TbResource;
import org.tensoft.gaoxiao.model.TbUser;
import org.tensoft.gaoxiao.service.TbResourceService;
/**
 * 用户登录 登出的操作
 * @author Administrator
 *
 */
@Controller
public class LoginController {

	
	@Autowired
	TbResourceService resourceService;
	
	
	@RequestMapping("/login")
	public String dologin(HttpServletRequest request,Map<String, Object> map){
		
		if (request.getMethod().equals(HttpMethod.POST.toString())) {
			String msg = "";
			String uAccountName = request.getParameter("AccountName");
            String password = request.getParameter("password");
            String rememberMe = request.getParameter("rememberMe");
            UsernamePasswordToken token = new UsernamePasswordToken(uAccountName, password);
    		token.setRememberMe(rememberMe==null?false:true);
            Subject subject = SecurityUtils.getSubject();
            subject.getSession().setAttribute("account", uAccountName);
            try{
            	subject.login(token); //开始登录验证
            	subject.getSession().removeAttribute("msg");
            	return "redirect:/index";
            }catch(UnknownAccountException e){
    			msg = "账户不存在！";
            }catch(IncorrectCredentialsException e){
    			msg = "密码错误！";
            }catch (LockedAccountException e) {
            	msg = "您的账户已被锁定,请与管理员联系！";
            }catch(ExcessiveAttemptsException e){
            	msg = "登录失败次数过多,请稍后再试！";
            }catch(Exception e){
            	 msg="系统发生错误，请联系管理员！";
            }
    		map.put("msg", msg);
    		// 此方法不处理登录成功,由shiro进行处理.
    		subject.getSession().setAttribute("msg", msg);
    		return "login";
		}else {
			 return "login";
		}
	}
	
	
	@RequestMapping("/index")
	public String index(Map<String, Object> map) {
		TbUser userEntity = (TbUser)SecurityUtils.getSubject().getPrincipal(); //返回当前的用户
		//判断登录用户的权限资源
		List<TbResource> treeMenuList = resourceService.findResourcesMenuByUserId(userEntity.getuId());
		if (treeMenuList.size()>0) {
			List<TbResource> childMenu = new ArrayList<TbResource>();  //子类菜单
			for (TbResource menu : treeMenuList) {
				if (menu.getParentId()==0) {
					childMenu = resourceService.getChildMeunsByParid(menu.getId());
					menu.setChildren(childMenu);
				}
			}
		}
		map.put("menus", treeMenuList);
		map.put("user", userEntity);
		return "index";
	}
	
	// 退出登录的操作
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		// 注销登录
		SecurityUtils.getSubject().logout();
		return "redirect:/login";
	}
	
}
