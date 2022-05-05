package com.tedu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tedu.dao.DoorMapper;
import com.tedu.pojo.Door;
/**
 * �ŵ�ģ���controller
 */
@Controller
public class DoorController {
	//��ȡDoorMapper�ӿڵ�����ʵ��
	@Autowired //�Զ�װ��
	DoorMapper doorMapper;
	
	/** 1.��ѯ�����ŵ���Ϣ
	 * 	��� "�ŵ����" ��,����/doorList,ִ�е�ǰ����,��ѯ�����ŵ���Ϣ */
	@RequestMapping("/doorList")
	public String doorList( Model model ) {
		List<Door> list = doorMapper.findAll();
		//���ŵ���Ϣ���ϴ���Model��,ת�������ŵ��б�ҳ����ʾ
		model.addAttribute("doorList", list);
		//ת���� door_list.jsp, ��ʾ�����ŵ���Ϣ
		return "door_list";
	}
	/**
	 * 2.����idɾ���ŵ���Ϣ
	 * @param id ��Ҫɾ���ŵ��idֵ
	 * @return  */
	@RequestMapping("/doorDelete")
	public String doorDelete(Integer id) {
		doorMapper.deleteById( id );
		//���³ɹ���,ת������ѯ�����ŵ���Ϣ�ķ���,��ʾ�����ŵ���Ϣ
		return "forward:/doorList";
	}
	
	/**
	 * 3.�����ŵ���Ϣ
	 * @param door ����������ύ�������ŵ���Ϣ(name��tel��addr)
	 * @return */
	@RequestMapping("/doorAdd")
	public String doorAdd( Door door ) {
		doorMapper.add( door );
		//���³ɹ���,ת������ѯ�����ŵ���Ϣ�ķ���,��ʾ�����ŵ���Ϣ
		return "forward:/doorList";
	}
	/**
	 * 4.����id��ѯ�ŵ���Ϣ,����ѯ�����ŵ���Ϣת�������ŵ��޸�ҳ��,�������ݵĻ���
	 * @param id �ŵ��idֵ
	 * @return �ŵ��޸�ҳ���jsp������
	 */
	@RequestMapping("/doorInfo")
	public String doorInfo( Integer id, Model model ) {
		//����id��ѯ�ŵ���Ϣ,���ŵ�������Model��,ת�������ŵ��޸�ҳ��
		Door door = doorMapper.findById( id );
		model.addAttribute( "door", door );
		//ת�����ŵ��޸�ҳ��
		return "door_update";
	}
	
	/**
	 * 5.����id�޸��ŵ���Ϣ
	 * @param door ���з�װ���ŵ��id�Լ��޸ĺ���ŵ���Ϣ
	 * @return "forward:/doorList" ת������ѯ�����ŵ���Ϣ�ķ���
	 */
	@RequestMapping("/doorUpdate")
	public String doorUpdate( Door door ) {
		doorMapper.updateById( door );
		//���³ɹ���,ת������ѯ�����ŵ���Ϣ�ķ���,��ʾ�����ŵ���Ϣ
		return "forward:/doorList";
	}
	
}









