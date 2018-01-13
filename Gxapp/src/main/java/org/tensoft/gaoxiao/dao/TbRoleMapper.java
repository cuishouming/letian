package org.tensoft.gaoxiao.dao;

import java.util.List;
import java.util.Map;

import org.tensoft.gaoxiao.dao.base.CrudRepository;
import org.tensoft.gaoxiao.model.TbRole;

public interface TbRoleMapper extends CrudRepository<TbRole> {

	public List<TbRole> selectRoleList(Integer rDeptId);
	
	public List<TbRole> getlist(Map<String, Object> parameters);
}
