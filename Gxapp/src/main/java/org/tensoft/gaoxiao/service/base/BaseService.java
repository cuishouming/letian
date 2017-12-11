package org.tensoft.gaoxiao.service.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.tensoft.gaoxiao.dao.base.CrudRepository;


@SuppressWarnings({ "unchecked",  "rawtypes" })
@Transactional(readOnly = true)
public abstract class BaseService<T extends CrudRepository, D> {

    @Autowired
    protected T dao;

   
	public List<D> getAll() {
        return dao.getAll();
    }

    public D get(Integer id) {
        return (D) dao.get(id);
    }

    @Transactional(readOnly = false)
    public int add(D xtYhcp) {
        return dao.add(xtYhcp);
    }

    @Transactional(readOnly = false)
    public int delete(String id) {
        return dao.delete(id);
    }

    @Transactional(readOnly = false)
    public int delete(Integer id) {
        return dao.delete(id);
    }
    
    public int deletes(String ids){
    	 String[] str = ids.split(",");
		return dao.deletes(str);
    	
    };
    
    @Transactional(readOnly = false)
    public int update(D et) {
        return dao.update(et);
    }

    public int count() {
        return dao.count();
    }
    
    public List<D> queryPage(D po) {

        return dao.queryPage(po);
    }
}
