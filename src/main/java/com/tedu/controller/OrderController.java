package com.tedu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tedu.dao.DoorMapper;
import com.tedu.dao.OrderMapper;
import com.tedu.pojo.Door;
import com.tedu.pojo.Order;

/** ����ģ���controller */
@Controller
public class OrderController {
	//��ȡOrderMapper�ӿڵ�����ʵ��
	@Autowired
	OrderMapper orderMapper;
	//��ȡDoorMapper�ӿڵ�����ʵ��
	@Autowired
	DoorMapper doorMapper;
	
	/** 1.��ѯ���ж�����Ϣ */
	@RequestMapping("/orderList")
	public String orderList( Model model ) {
		//��ѯ���еĶ�����Ϣ,����������Ϣ����model��
		List<Order> orderList = orderMapper.findAll();
		model.addAttribute( "oList", orderList );
		//ͬʱ��ѯ���е��ŵ���Ϣ,�����ŵ���Ϣ����model��
		List<Door> doorList = doorMapper.findAll();
		model.addAttribute( "dList", doorList );
		//��ת�������б�ҳ��,��ʾ���ж�����Ϣ
		return "order_list";
	}
	/** 2.����idɾ��������Ϣ */
	@RequestMapping("/orderDelete")
	public String orderDelete(Integer id) {
		orderMapper.deleteById( id );
		//ת������ѯ���ж����ķ���,��ѯ���µĶ�����Ϣ����ʾ
		return "forward:/orderList";
	}
	/** 3.��ѯ�����ŵ���Ϣ,���ŵ���Ϣ���뵽Model��
	 * ������ת����������ҳ��(order_add.jsp) */
	@RequestMapping("/toOrderAdd")
	public String toOrderAdd( Model model ) {
		//��ѯ�����ŵ���Ϣ,�������ŵ���뵽Model��
		List<Door> doorList = doorMapper.findAll();
		model.addAttribute( "dList", doorList );
		//ת���� ��������ҳ��, ������ѡ������ʾ���е��ŵ��б�
		return "order_add";
	}
	
	/** 4.�����������ҳ���е�"�ύ"��,���ʵ�ǰ�������,��������������� */
	@RequestMapping("/orderAdd")
	public String orderAdd( Order order ) {
		orderMapper.add( order ); //����������Ϣ
		//ת������ѯ���ж����ķ���,��ѯ���µĶ�����Ϣ����ʾ
		return "forward:/orderList";
	}
	
	/** 5.����id��ѯ������Ϣ,��������Ϣ����Model��,
	 * 	���������޸�ҳ��(order_update.jsp)���л��� */
	@RequestMapping("/orderInfo")
	public String orderInfo( Integer id, Model model ) {
		//����id��ѯ������Ϣ,��������Ϣ����Model��
		Order order = orderMapper.findById( id );
		model.addAttribute("order", order);
		//��ѯ�����ŵ���Ϣ,�������ŵ���뵽Model��
		List<Door> doorList = doorMapper.findAll();
		model.addAttribute( "dList", doorList );
		
		//ת�����������޸�ҳ����л���
		return "order_update";
	}
	
	/** 6.����id�޸Ķ�����Ϣ */
	@RequestMapping("/orderUpdate")
	public String orderUpdate( Order order ) {
		orderMapper.updateById( order );
		//ת������ѯ���ж�����Ϣ�ķ���,��ѯ���µĶ�����Ϣ����ʾ
		return "forward:/orderList";
	}
	
}



