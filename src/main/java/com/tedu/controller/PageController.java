package com.tedu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tedu.dao.DoorMapper;
import com.tedu.pojo.Door;

/* @Controller (1)��ʶ��ǰ������Controller��
 * 	(2)spring������ɨ�赱ǰ���µ�������,���������@Controllerע��
 * 	������spring�������������ʵ��
 */
@Controller
public class PageController {
	
	/* 1������springmvc�����л��� */
	@RequestMapping("/testmvc")
	public String testmvc() {
		System.out.println("PageController.testmvc()...");
		return "test";
	}
	
	/* ��ȡDoorMapper�ӿڵ�����ʵ�� 
	 * ����ǰ��������applicationContext.xml��������ɨ��dao���µ����нӿ�,��
	 * 	spring���Ϊ�ӿڵĴ�������ʵ��,�����ӿڵ�����ʵ���浽spring��map��
	 * @Autowired������,��������(DoorMapper)��spring��map��������ӿڶ�Ӧ
	 * 	������ʵ��,�ҵ�֮��Ὣ�ӿڵ�����ʵ����ֵ����ǰ�����Ա����. */
	@Autowired
	DoorMapper doorMapper;
	/* 2������ssm�����л��� */
	@RequestMapping("/testssm")
	public String testssm() {
		//��ѯ���е��ŵ���Ϣ
		List<Door> doorList = doorMapper.findAll();
		for (Door door : doorList) {
			System.out.println( door );
		}
		return "test";
	}
	
	/* 3.�ṩͨ�õ�ҳ����ת���� 
	 * 	/{}�е�jspName���ڻ�ȡ(����)���ʵ�·����
	 * 	�������·��Ϊ:../_top,��ôjspName��ֵ���� "_top"
	 * 	@PathVariableע��,���ڽ�  /{}��jspName��ֵ ��Ϊʵ�δ��ݸ�
	 * 	�����ϵ��β� jspName, ��ʱ�β�jspName��ֵҲΪ "_top", ���ս�
	 * 	"_top"ֱ��return������ת�� _top.jsp
	 * 	�ܽ�: �����ʵ�·����Ϊ xxx, �Ϳ�����ת�� xxx.jsp
	 */
	@RequestMapping("/{jspName}")
	public String toJspPage( @PathVariable String jspName ) {
		System.out.println("-----ִ��ͨ�õ�ҳ����ת����,��ת�� ["+jspName+".jsp]...");
		return jspName;
	}
	
	
}






