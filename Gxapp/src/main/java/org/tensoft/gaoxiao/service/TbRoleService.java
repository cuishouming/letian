package org.tensoft.gaoxiao.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.tensoft.gaoxiao.dao.TbRoleMapper;
import org.tensoft.gaoxiao.model.TbRole;
import org.tensoft.gaoxiao.service.base.BaseService;
@Service
public class TbRoleService extends BaseService<TbRoleMapper,TbRole>{

	public List<TbRole> selectRoleList(Integer rDeptId) {
		return dao.selectRoleList(rDeptId);
	}

	public List<TbRole> getlist(Map<String, Object> parameters) {
		
		return dao.getlist(parameters);
	}

	

}
