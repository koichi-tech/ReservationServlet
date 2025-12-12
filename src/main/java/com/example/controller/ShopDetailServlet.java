package com.example.controller;

import java.io.IOException;
import java.util.List;

import com.example.dao.ShopDetailDao;
import com.example.dto.ShopDetailDto;
import com.example.dto.ShopDetailPageDto;
import com.example.dto.ShopListDto;
import com.example.service.ShopDetailService;

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

	private ShopDetailService service;

	@Override
	public void init() {
		service = new ShopDetailService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String forwardPath = "shopdetail.jsp";

		// Shop_IDの取得
		String shopId = request.getParameter("shopId");

		// Serviceを呼び出し、データ取得
		ShopDetailPageDto pageDto = service.getShopDetailPage(shopId);

		// 取得結果をリクエストに格納
		request.setAttribute("pageDto", pageDto);

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
