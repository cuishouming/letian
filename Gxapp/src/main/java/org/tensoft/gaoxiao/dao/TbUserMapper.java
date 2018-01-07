package org.tensoft.gaoxiao.dao;

import java.util.List;
import java.util.Map;

import org.tensoft.gaoxiao.dao.base.CrudRepository;
import org.tensoft.gaoxiao.model.TbUser;

public interface TbUserMapper extends CrudRepository< TbUser>{

	public List<TbUser> selectUser(Map<String,Object> map);
	
}
