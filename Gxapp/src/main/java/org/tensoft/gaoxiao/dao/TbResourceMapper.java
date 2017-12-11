package org.tensoft.gaoxiao.dao;

import java.util.List;

import org.tensoft.gaoxiao.dao.base.CrudRepository;
import org.tensoft.gaoxiao.model.TbResource;

public interface TbResourceMapper extends CrudRepository<TbResource>{

	public List<TbResource> findResourcesByUserId(Integer uId);
	
	public List<TbResource> findResourcesMenuByUserId(Integer uid);
	
	public List<TbResource> getChildMeunsByParid(Integer id);
}
