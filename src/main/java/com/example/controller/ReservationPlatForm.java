package com.example.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import com.example.dao.ShopListDao;
import com.example.dto.ShopListDto;

/**
 * Servlet implementation class ReservationPlatForm
 */

public class ReservationPlatForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ShopListDao shopListDao;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationPlatForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	// DAO のインスタンス化
	@Override
	public void init() throws ServletException {
		super.init();
		shopListDao = new ShopListDao();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String forwardPath = "index.jsp";

		// SQL結果格納用DTOリスト
		List<ShopListDto> shopListDto;

		// ソート設定値の取得
		String sort = request.getParameter("sort");

		// DAOを呼び出し、データ取得
		if (sort == null || sort.equals("blank")) {
			// ソートが設定値がnull、もしくは空の場合
			shopListDto = shopListDao.selectShopList(null, false);
		} else {
			// ソート設定値がnull、か空でない場合
			shopListDto = shopListDao.selectShopList(sort, false);
		}

		// 取得結果をリクエストに格納
		request.setAttribute("sort", sort);
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
