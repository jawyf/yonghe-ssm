package com.tedu.dao;

import java.util.List;

import com.tedu.pojo.Order;

/** ����ģ���mapper�ӿ� */
public interface OrderMapper {
	
	/** 1.��ѯ���ж�����Ϣ */
	public List<Order> findAll();
	
	/** 2.����idɾ��������Ϣ */
	public void deleteById(Integer id);
	
	/** 3.����������Ϣ */
	public void add( Order order );
	
	/** 4.����id��ѯ������Ϣ */
	public Order findById( Integer id );
	
	/** 5.����id�޸Ķ�����Ϣ */
	public void updateById( Order order );
	
	
	
	
	
	
	
	
	
}
