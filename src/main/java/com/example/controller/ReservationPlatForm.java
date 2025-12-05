package com.example.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.example.dao.ShopListDao;
import com.example.dto.ShopListDto;

/**
 * Servlet implementation class ReservationPlatForm
 */

public class ReservationPlatForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
=======
	private ShopListDao shopListDao;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationPlatForm() {
        super();
        // TODO Auto-generated constructor stub
    }
>>>>>>> 96f41026c2596e343c48eb90f0886491aa8467dd

 // DAO のインスタンス化
 	@Override
 	public void init() throws ServletException {
 		super.init();
 		shopListDao = new ShopListDao();
 	}
	/**
	 * @see HttpServlet#HttpServlet()
	 */
=======
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String forwardPath = "index.jsp";
		
		
		// DAOを呼び出し、データ取得
		List<ShopListDto> shopListDto = shopListDao.SelectShopList();
		
		// 取得結果をリクエストに格納
		request.setAttribute("shopList", shopListDto);
		
		// index.jspにフォワード（結果を渡しながら遷移）
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
>>>>>>> 96f41026c2596e343c48eb90f0886491aa8467dd

	// DAO のインスタンス化
	@Override
	public void init() throws ServletException {
		super.init();
		shopListDao = new ShopListDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String forwardPath = "index.jsp";

		// DAOを呼び出し、データ取得
		List<ShopListDto> shopListDto = shopListDao.SelectShopList();

		// 取得結果をリクエストに格納
		request.setAttribute("shopList", shopListDto);

		// index.jspにフォワード（結果を渡しながら遷移）
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
