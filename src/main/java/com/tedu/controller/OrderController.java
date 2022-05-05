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

/** 订单模块的controller */
@Controller
public class OrderController {
	//获取OrderMapper接口的子类实例
	@Autowired
	OrderMapper orderMapper;
	//获取DoorMapper接口的子类实例
	@Autowired
	DoorMapper doorMapper;
	
	/** 1.查询所有订单信息 */
	@RequestMapping("/orderList")
	public String orderList( Model model ) {
		//查询所有的订单信息,并将订单信息存入model中
		List<Order> orderList = orderMapper.findAll();
		model.addAttribute( "oList", orderList );
		//同时查询所有的门店信息,并将门店信息存入model中
		List<Door> doorList = doorMapper.findAll();
		model.addAttribute( "dList", doorList );
		//跳转到订单列表页面,显示所有订单信息
		return "order_list";
	}
	/** 2.根据id删除订单信息 */
	@RequestMapping("/orderDelete")
	public String orderDelete(Integer id) {
		orderMapper.deleteById( id );
		//转发到查询所有订单的方法,查询最新的订单信息并显示
		return "forward:/orderList";
	}
	/** 3.查询所有门店信息,将门店信息存入到Model中
	 * 最终跳转到订单新增页面(order_add.jsp) */
	@RequestMapping("/toOrderAdd")
	public String toOrderAdd( Model model ) {
		//查询所有门店信息,将所有门店存入到Model中
		List<Door> doorList = doorMapper.findAll();
		model.addAttribute( "dList", doorList );
		//转发到 订单新增页面, 在下拉选框中显示所有的门店列表
		return "order_add";
	}
	
	/** 4.点击新增订单页面中的"提交"后,访问当前这个方法,完成新增订单功能 */
	@RequestMapping("/orderAdd")
	public String orderAdd( Order order ) {
		orderMapper.add( order ); //新增订单信息
		//转发到查询所有订单的方法,查询最新的订单信息并显示
		return "forward:/orderList";
	}
	
	/** 5.根据id查询订单信息,将订单信息存入Model中,
	 * 	带到订单修改页面(order_update.jsp)进行回显 */
	@RequestMapping("/orderInfo")
	public String orderInfo( Integer id, Model model ) {
		//根据id查询订单信息,将订单信息存入Model中
		Order order = orderMapper.findById( id );
		model.addAttribute("order", order);
		//查询所有门店信息,将所有门店存入到Model中
		List<Door> doorList = doorMapper.findAll();
		model.addAttribute( "dList", doorList );
		
		//转发带到订单修改页面进行回显
		return "order_update";
	}
	
	/** 6.根据id修改订单信息 */
	@RequestMapping("/orderUpdate")
	public String orderUpdate( Order order ) {
		orderMapper.updateById( order );
		//转发到查询所有订单信息的方法,查询最新的订单信息并显示
		return "forward:/orderList";
	}
	
}



