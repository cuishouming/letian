package org.tensoft.gaoxiao.service;

import java.util.Date;
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
			roleUser.setRId(user.getRole().getId());
			roleUser.setUId(user.getId());
			roleUser.setTCreateTime(new Date(System.currentTimeMillis()));
			if(roleUserMapper.add(roleUser)>0){
				return true;
			}
		}
		return false;
	}


}
