package com.cyzy.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cyzy.bean.Role;
import com.cyzy.bean.User;
import com.cyzy.dao.RoleDao;
import com.cyzy.dao.RoleDaoImpl;
import com.cyzy.dao.UserDao;
import com.cyzy.dao.UserDaoImpl;


/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String userAction = request.getParameter("userAction");
		if (userAction != null && userAction.equals("login")) {
			login(request, response);
		} else if (userAction != null && userAction.equals("register")) {
			register(request, response);
		} else if (userAction != null && userAction.equals("addBefore")) {
			addBefore(request, response);
		} else if (userAction != null && userAction.equals("add")) {
			addUser(request, response);
		} else if (userAction != null && userAction.equals("delete")) {
			deleteUser(request, response);
		} else if (userAction != null && userAction.equals("updateBefore")) {
			updateBefore(request, response);
		} else if (userAction != null && userAction.equals("update")) {
			updateUser(request, response);
		} else if (userAction != null && userAction.equals("list")) {
			queryUserList(request, response);
		} else if (userAction != null && userAction.equals("detail")) {
			userDetail(request, response);
		}
	}

	private void userDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 防止乱码
		response.setContentType("text/html");

		String userId = request.getParameter("userId");
		UserDao userDao = new UserDaoImpl();
		User user = (User) userDao.getUserById(Integer.parseInt(userId));

		request.setAttribute("user", user);
		request.getRequestDispatcher("/user/user_detail.jsp").forward(request, response);
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 防止乱码
		response.setContentType("text/html");

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		request.setAttribute("userName", userName);
		request.setAttribute("password", password);
		request.getRequestDispatcher("/admin/adminMain.jsp").forward(request, response);

	}

	private void register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	private void addBefore(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 防乱码
		response.setContentType("text/html");
		RoleDao roleDao = new RoleDaoImpl();
		Role role = new Role();
		List<Role> roleList = roleDao.queryRole(role);
		request.setAttribute("roleList", roleList);
		request.getRequestDispatcher("/user/user_add.jsp").forward(request, response);
	}

	private void addUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		response.setContentType("text/html");

		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String realName = request.getParameter("realName");
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birthday");
		String roleId = request.getParameter("roleId");
		User user = new User(1, userName, password, realName, Integer.parseInt(sex), birthday,
				Integer.parseInt(roleId));

		UserDao userDao = new UserDaoImpl();
		int result = userDao.addUser(user);
        //提示成功,使用输出流
		UserDao queryuserDao = new UserDaoImpl();
		List<User> userList = queryuserDao.queryUsers(user);
		request.setAttribute("userList", userList);
		request.getRequestDispatcher("/user/user_list.jsp").forward(request, response);

	}

	// 执行修改操作前
	private void updateBefore(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String userId = request.getParameter("userId");
		UserDao userDao = new UserDaoImpl();
		User user = (User) userDao.getUserById(Integer.parseInt(userId));
	    
		request.setAttribute("user", user);
		request.getRequestDispatcher("/user/user_update.jsp").forward(request, response);
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		// String userId=request.getParameter("userId");
		// UserService
		// userService=(UserService)ServiceFactory.getServiceImpl(UserService.class.getName());
		// User user=userService.getUserById(Integer.parseInt("userId"));
		// User user=new User(0,"zengkeer","123456","曾可儿",0,"2020-02-16");
		// request.setAttribute("user", user);
		UserDao userdao = new UserDaoImpl();
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String realName = request.getParameter("realName");
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birthday");
		String roleId = request.getParameter("roleId");
		User user = new User(Integer.parseInt(userId), userName, password, realName, Integer.parseInt(sex), birthday, 2);
		System.out.println(user);
		int result = userdao.updateUser(user);	
		if(result>0) {
			User users = new User();
			List<User> userList = userdao.queryUsers(users);
			request.setAttribute("userList", userList);
			request.getRequestDispatcher("user/user_list.jsp").forward(request, response);
		}
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		String userId = request.getParameter("userId");
		UserDao userdao = new UserDaoImpl();
		int result = userdao.deleteUser(Integer.parseInt(userId));
		if (result > 0) {
			User user = new User();
			List<User> userList = userdao.queryUsers(user);
			request.setAttribute("userList", userList);
			request.getRequestDispatcher("user/user_list.jsp").forward(request, response);
		}

	}

	private void queryUserList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		// UserService
		// userService=(UserService)ServiceFactory.getServiceImpl(UserService.class.getName());
		// List<User> users=userService.queryUser(userId);
		UserDao userdao = new UserDaoImpl();
		User user = new User();
		List<User> userList = userdao.queryUsers(user);
		request.setAttribute("userList", userList);
		request.getRequestDispatcher("/user/user_list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
