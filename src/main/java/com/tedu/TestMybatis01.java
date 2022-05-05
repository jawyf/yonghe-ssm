package com.tedu;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.tedu.dao.DoorMapper;
import com.tedu.pojo.Door;

/**
 * mybatis的入门案例: 查询yonghedb.emp表中的所有员工信息
 */
public class TestMybatis01 {
	
	/* 练习1: 查询emp中的所有员工信息 */
	@Test
	public void testFindAll01() throws Exception {
		//1.读取mybatis核心配置文件(mybatis-config.xml),Resources是mybatis提供的工具类
		InputStream in = Resources.getResourceAsStream("mybatis/mybatis-config2.xml");
		//2.通过配置信息获取SqlSession工厂对象
		SqlSessionFactory fac = new SqlSessionFactoryBuilder().build( in );
		//3.获取SQLSession对象(打开与数据库的连接)
		SqlSession session = fac.openSession();
		//4.获取DoorMapper接口的子类实例(mybatis提供子类,并创建子类实例)
		DoorMapper doorMapper = session.getMapper( DoorMapper.class );
		List<Door> list = doorMapper.findAll();
		//5.输出结果
		for (Door door : list) {
			System.out.println( door );
		}
	}
}









