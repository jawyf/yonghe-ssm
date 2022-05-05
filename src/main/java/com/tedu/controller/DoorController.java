package com.tedu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tedu.dao.DoorMapper;
import com.tedu.pojo.Door;
/**
 * 门店模块的controller
 */
@Controller
public class DoorController {
	//获取DoorMapper接口的子类实例
	@Autowired //自动装配
	DoorMapper doorMapper;
	
	/** 1.查询所有门店信息
	 * 	点击 "门店管理" 后,访问/doorList,执行当前方法,查询所有门店信息 */
	@RequestMapping("/doorList")
	public String doorList( Model model ) {
		List<Door> list = doorMapper.findAll();
		//将门店信息集合存入Model中,转发带到门店列表页面显示
		model.addAttribute("doorList", list);
		//转发到 door_list.jsp, 显示所有门店信息
		return "door_list";
	}
	/**
	 * 2.根据id删除门店信息
	 * @param id 所要删除门店的id值
	 * @return  */
	@RequestMapping("/doorDelete")
	public String doorDelete(Integer id) {
		doorMapper.deleteById( id );
		//更新成功后,转发到查询所有门店信息的方法,显示最新门店信息
		return "forward:/doorList";
	}
	
	/**
	 * 3.新增门店信息
	 * @param door 接收浏览器提交过来的门店信息(name、tel、addr)
	 * @return */
	@RequestMapping("/doorAdd")
	public String doorAdd( Door door ) {
		doorMapper.add( door );
		//更新成功后,转发到查询所有门店信息的方法,显示最新门店信息
		return "forward:/doorList";
	}
	/**
	 * 4.根据id查询门店信息,将查询到的门店信息转发带到门店修改页面,进行数据的回显
	 * @param id 门店的id值
	 * @return 门店修改页面的jsp的名字
	 */
	@RequestMapping("/doorInfo")
	public String doorInfo( Integer id, Model model ) {
		//根据id查询门店信息,将门店对象存入Model中,转发带到门店修改页面
		Door door = doorMapper.findById( id );
		model.addAttribute( "door", door );
		//转发到门店修改页面
		return "door_update";
	}
	
	/**
	 * 5.根据id修改门店信息
	 * @param door 其中封装了门店的id以及修改后的门店信息
	 * @return "forward:/doorList" 转发到查询所有门店信息的方法
	 */
	@RequestMapping("/doorUpdate")
	public String doorUpdate( Door door ) {
		doorMapper.updateById( door );
		//更新成功后,转发到查询所有门店信息的方法,显示最新门店信息
		return "forward:/doorList";
	}
	
}









