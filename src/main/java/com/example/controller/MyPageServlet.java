package com.example.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import com.example.dao.BaseDao;
import com.example.dao.UserDao;
import com.example.model.User;
import com.example.service.AuthService;
import com.example.service.UserInfoService;
import com.example.strategy.DatabaseAuthentication;
import com.example.strategy.UserInfoCheckUser;

/**
 * Servlet implementation class MyPageServlet
 */

public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BaseDao basedao;
	private UserDao userDao;
	private UserInfoService userInfoService;
	private UserInfoCheckUser userInfo;
	private User user;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// 1. 最も基礎となる依存オブジェクト（BaseDao）を初期化
	    this.basedao = new BaseDao();
	    this.user = new User();

	    // 2. BaseDaoに依存するオブジェクト（UserDao）を初期化
	    this.userDao = new UserDao(this.basedao); // ★ UserDaoを先に初期化する

	    // 3. UserDaoに依存するオブジェクト（UserInfoCheckUser）を初期化
	    this.userInfo = new com.example.strategy.UserInfoCheckUser(this.userDao); // ★ 初期化済みのuserDaoを使う

	    // 4. UserInfoCheckUserに依存するオブジェクト（UserInfoService）を初期化
	    this.userInfoService = new com.example.service.UserInfoService(this.userInfo);
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mailAddress = null;
		List<User> userList = null;
		String forwardPath = "mypage.jsp";
		try {
			// 1. 既存セッションの有無を確認 (セッションがなければ null を返す)
			User userInfoOnSession = null;
			HttpSession existingSession = request.getSession(false);
			userInfoOnSession = (User) existingSession.getAttribute("LOGIN_INFO");
			mailAddress = userInfoOnSession.getMailAddress();
			//その引数を元にdaoから情報を格納するようなメソッドを呼び出して格納する
			userList = userInfoService.checkUser(mailAddress);
			
			//格納された情報をjspに受け渡すための処理が必要
			request.setAttribute("userList", userList);
			
			// index.jspにフォワード（結果を渡しながら遷移）
			RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
			dispatcher.forward(request, response);
			
		} catch(Exception e) {
			
		}
			
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
