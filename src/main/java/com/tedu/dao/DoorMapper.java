package com.tedu.dao;

import java.util.List;

import com.tedu.pojo.Door;

/* �ӿ������ǿ�����Ա�����ṩ,���ӿڵ�ʵ����(����)�ɿ�ܸ����ṩ
 * ���������mybatis��spring��ܣ��ӿڵ�����ʵ��Ҳ����mybatis���𴴽�
 * ���������mybatis��spring��ܣ��ӿڵ�����ʵ��������spring�������𴴽� */
public interface DoorMapper {
	/** 1.��ѯ�����ŵ���Ϣ */
	public List<Door> findAll();
	
	/** 2.����idɾ���ŵ���Ϣ */
	public void deleteById( Integer id );
	
	/** 3.�����ŵ���Ϣ */
	public void add( Door door );
	
	/** 4.����id��ѯ�ŵ���Ϣ */
	public Door findById( Integer id );
	
	/** 5.����id�޸��ŵ���Ϣ */
	public void updateById( Door door );
	
}
















