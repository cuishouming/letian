package org.tensoft.gaoxiao.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.tensoft.gaoxiao.dao.TbUserMapper;
import org.tensoft.gaoxiao.model.TbUser;
import org.tensoft.gaoxiao.service.base.BaseService;

@Service
public class TbUserService extends BaseService<TbUserMapper, TbUser>{

	public List<TbUser> selectUser(Map<String,Object> map) {
		return dao.selectUser(map);
	}


}
