package com.example.controller;

import java.io.IOException;
import java.util.List;

import com.example.dao.ShopDetailDao;
import com.example.dto.ShopDetailDto;
import com.example.dto.ShopListDto;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShopDetailServlet
 */

public class ShopDetailServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
<<<<<<< HEAD
		//String forwardPath = "shopdetail.jsp";
=======
>>>>>>> 76922496d7acb3d958a4f43b86c4cda4b902a76d
		String forwardPath = "shopdetail.jsp";

		// Shop_IDの取得
		String shopId = request.getParameter("shopId");

		// DAOを呼び出し、データ取得
		ShopDetailDao dao = new ShopDetailDao();
		ShopDetailDto shopDetailDto = dao.selectShopDetail(shopId);

		// 取得結果をリクエストに格納
		request.setAttribute("shopDetail", shopDetailDto);

		// shopdetail.jspにフォワード（結果を渡しながら遷移）
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
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
