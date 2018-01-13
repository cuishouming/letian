package org.tensoft.gaoxiao.dao;

import java.util.Map;

import org.tensoft.gaoxiao.dao.base.CrudRepository;
import org.tensoft.gaoxiao.model.TbRoleUser;

public interface TbRoleUserMapper extends CrudRepository<TbRoleUser>{

	int deleteByMap(Map<String, Object> map);

}
