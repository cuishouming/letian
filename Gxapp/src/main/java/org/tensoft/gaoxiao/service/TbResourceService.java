package org.tensoft.gaoxiao.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.tensoft.gaoxiao.dao.TbResourceMapper;
import org.tensoft.gaoxiao.model.TbResource;
import org.tensoft.gaoxiao.service.base.BaseService;

@Service
public class TbResourceService extends BaseService<TbResourceMapper, TbResource> {

	/**
	 * 通过 用户id 查询他的 所有资源 信息
	 * 
	 * @param getuId
	 * @return
	 */
	public List<TbResource> findResourcesByUserId(Integer uId) {
		return dao.findResourcesByUserId(uId);
	}

	/**
	 * 通过 用户id 查询他的 资源 type 不等于 2 的 即 不查按钮 用于index 左侧的导航
	 * value缓存名、 key缓存键值、 condition满足缓存条件、unless否决缓存条件
	 * @param id
	 * @return
	 */
	@Cacheable(cacheNames="books", key = "77")
	public List<TbResource> findResourcesMenuByUserId(Integer uid) {
		System.out.println(66666666);
		return dao.findResourcesMenuByUserId(uid);
	}

	/**
	 * 通过 父类id 查询他的 子集 父类id 不等于0
	 * 
	 * @param id
	 * @return
	 */
	public List<TbResource> getChildMeunsByParid(Integer id) {
		System.out.println(444);
		return dao.getChildMeunsByParid(id);
	}

}
