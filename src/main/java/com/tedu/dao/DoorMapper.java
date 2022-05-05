package com.tedu.dao;

import java.util.List;

import com.tedu.pojo.Door;

/* 接口由我们开发人员负责提供,但接口的实现类(子类)由框架负责提供
 * 如果不整合mybatis和spring框架，接口的子类实例也是由mybatis负责创建
 * 如果整合了mybatis和spring框架，接口的子类实例将会由spring容器负责创建 */
public interface DoorMapper {
	/** 1.查询所有门店信息 */
	public List<Door> findAll();
	
	/** 2.根据id删除门店信息 */
	public void deleteById( Integer id );
	
	/** 3.新增门店信息 */
	public void add( Door door );
	
	/** 4.根据id查询门店信息 */
	public Door findById( Integer id );
	
	/** 5.根据id修改门店信息 */
	public void updateById( Door door );
	
}
















