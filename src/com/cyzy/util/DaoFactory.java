package com.cyzy.util;

import java.util.HashMap;
import java.util.Map;

import com.cyzy.dao.GoodsDao;
import com.cyzy.dao.GoodsDaoImpl;
import com.cyzy.dao.MenuDao;
import com.cyzy.dao.MenuDaoImpl;
import com.cyzy.dao.RoleDao;
import com.cyzy.dao.RoleDaoImpl;
import com.cyzy.dao.UserDao;
import com.cyzy.dao.UserDaoImpl;

public class DaoFactory {
	 //声明私有变量
		private static Map<String,Object> config=new HashMap<String,Object>();
		//静态块,只有一个实例
		static {
			config.put(UserDao.class.getName(),new UserDaoImpl());//用户dao
			config.put(RoleDao.class.getName(), new RoleDaoImpl());//角色dao
			config.put(GoodsDao.class.getName(), new GoodsDaoImpl());//商品dao
			config.put(MenuDao.class.getName(),new MenuDaoImpl());//菜单dao
		}
		//静态方法获取实例
		public static Object getDaoImpl(String name) {
			return config.get(name);
		}
}
