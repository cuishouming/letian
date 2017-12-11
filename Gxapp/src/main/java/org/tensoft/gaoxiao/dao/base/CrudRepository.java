package org.tensoft.gaoxiao.dao.base;


import java.util.List;


public interface CrudRepository<T> extends BaseRepository {


    public T get(Integer id);
    /**
     * 添加数据
     * @param t
     * @return
     */
    public int add(T t);

    /**
     * 修改数据
     * @param entity
     * @return
     */
    public int update(T entity);

    /**
     * 删除数据
     * @param id
     * @return
     */
    public int delete(String id);
    
    public int delete(Integer id);
    
    /**
     * 批量删除数据
     * 
     * 1 前台过来的是一个 用逗号分隔的字符串
     * 2 通过截取 截成对应的 数组
     * @param list
     */
    public int deletes(String[] ids);

    /**
     * 获取全部
     * @return
     */
    public List<T> getAll();

    /**
     * 获取总数
     * @param vo
     * @return
     */
    public int count();

    /**
     * 自身的查询 作为基类
     * @param po
     * @return
     */
    public List<T> queryPage(T po);
}
