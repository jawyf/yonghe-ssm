package com.tedu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tedu.dao.DoorMapper;
import com.tedu.pojo.Door;

/* @Controller (1)标识当前类属于Controller层
 * 	(2)spring容器会扫描当前包下的所有类,如果类上有@Controller注解
 * 	将会由spring容器创建该类的实例
 */
@Controller
public class PageController {
	
	/* 1、测试springmvc的运行环境 */
	@RequestMapping("/testmvc")
	public String testmvc() {
		System.out.println("PageController.testmvc()...");
		return "test";
	}
	
	/* 获取DoorMapper接口的子类实例 
	 * 由于前面我们在applicationContext.xml中配置了扫描dao包下的所有接口,由
	 * 	spring框架为接口的创建子类实例,并将接口的子类实例存到spring的map中
	 * @Autowired作用是,根据类型(DoorMapper)到spring的map中找这个接口对应
	 * 	的子类实例,找到之后会将接口的子类实例赋值给当前这个成员变量. */
	@Autowired
	DoorMapper doorMapper;
	/* 2、测试ssm的运行环境 */
	@RequestMapping("/testssm")
	public String testssm() {
		//查询所有的门店信息
		List<Door> doorList = doorMapper.findAll();
		for (Door door : doorList) {
			System.out.println( door );
		}
		return "test";
	}
	
	/* 3.提供通用的页面跳转方法 
	 * 	/{}中的jspName用于获取(接收)访问的路径名
	 * 	例如访问路径为:../_top,那么jspName的值就是 "_top"
	 * 	@PathVariable注解,用于将  /{}中jspName的值 作为实参传递给
	 * 	方法上的形参 jspName, 此时形参jspName的值也为 "_top", 最终将
	 * 	"_top"直接return。即跳转到 _top.jsp
	 * 	总结: 当访问的路径名为 xxx, 就可以跳转到 xxx.jsp
	 */
	@RequestMapping("/{jspName}")
	public String toJspPage( @PathVariable String jspName ) {
		System.out.println("-----执行通用的页面跳转方法,跳转到 ["+jspName+".jsp]...");
		return jspName;
	}
	
	
}






