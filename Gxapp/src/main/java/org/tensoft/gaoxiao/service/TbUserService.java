package org.tensoft.gaoxiao.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tensoft.gaoxiao.dao.TbRoleUserMapper;
import org.tensoft.gaoxiao.dao.TbUserMapper;
import org.tensoft.gaoxiao.model.TbRoleUser;
import org.tensoft.gaoxiao.model.TbUser;
import org.tensoft.gaoxiao.service.base.BaseService;


@Service
public class TbUserService extends BaseService<TbUserMapper, TbUser>{
	@Autowired
	private TbRoleUserMapper roleUserMapper;
	
	public List<TbUser> selectUser(Map<String,Object> map) {
		return dao.selectUser(map);
	}
	
	
	
	@Transactional
	public boolean instertAll(TbUser user) {
		if (dao.add(user)>0) {
			TbRoleUser roleUser = new TbRoleUser();
			roleUser.setrId(user.getRoleId());
			roleUser.setuId(user.getuId());
			roleUser.settCreateTime(new Date(System.currentTimeMillis()));
			if(roleUserMapper.add(roleUser)>0){
				return true;
			}
		}
		return false;
	}


	@Transactional(readOnly=false)
	public boolean updateAll(TbUser user) {
		if (dao.update(user)>0) {
			TbRoleUser roleUser = new TbRoleUser();
			roleUser.setrId(user.getRole().getrId());
			roleUser.setuId(user.getuId());
			roleUser.settCreateTime(new Date(System.currentTimeMillis()));
			return roleUserMapper.update(roleUser)>0;
		};
		
		return false;
	
		
	}


	@Transactional
	public boolean delUser(Integer uId) {
		Map<String, Object> map = new HashMap<>();
		map.put("uId", uId);
		if(roleUserMapper.deleteByMap(map)>0){
			return dao.delete(uId)>0;
		}
		return false;
	}


}
