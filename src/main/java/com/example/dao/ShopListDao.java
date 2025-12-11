package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.dto.ShopListDto;

public class ShopListDao extends BaseDao {

	public ShopListDao() {
		super();
	}

	public List<ShopListDto> selectShopList(String sort, boolean order) {

		// SQL結果格納用DTOリスト
		List<ShopListDto> dtoList = new ArrayList<ShopListDto>();

		// 発行するSQL文の生成（SELECT）
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT \n");
		sql.append("A.SHOP_ID AS SHOP_ID, \n");
		sql.append("A.SHOP_NAME AS SHOP_NAME, \n");
		sql.append("B.GENRE_NAME AS GENRE_NAME, \n");
		sql.append("COALESCE(AVG(C.RATING), 0) AS AVG_RATING \n");
		sql.append("FROM t_shop AS A \n");
		sql.append("LEFT JOIN T_SHOP_GENRE_MAP AS MP ON A.SHOP_ID = MP.SHOP_ID \n");
		sql.append("LEFT JOIN T_SHOP_GENRE AS B ON MP.GENRE_ID = B.GENRE_ID \n");
		sql.append("LEFT JOIN t_review AS C ON A.SHOP_ID = C.SHOP_ID \n");
		sql.append("GROUP BY A.SHOP_NAME, B.GENRE_NAME");
		String sqlStr = sql.toString();

		// ソート条件を追加
		if (sort != null) {
			sqlStr += " ORDER BY AVG_RATING DESC";
		}

		// SQL実行
		try (Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(sqlStr);
				ResultSet rs = ps.executeQuery()) {

			// ResultSetオブジェクトからDTOリストに格納
			while (rs.next()) {
				ShopListDto dto = new ShopListDto();
				dto.setShopId(rs.getString("SHOP_ID"));
				dto.setShopName(rs.getString("SHOP_NAME"));
				dto.setGenreName(rs.getString("GENRE_NAME"));
				dto.setAvgRating(rs.getDouble("AVG_RATING"));
				dtoList.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return dtoList;
	}

	public List<ShopListDto> selectRecommendShopList() {

		// SQL結果格納用DTOリスト
		List<ShopListDto> dtoList = new ArrayList<ShopListDto>();

		// 発行するSQL文の生成（SELECT）
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT \n");
		sql.append("A.SHOP_NAME AS SHOP_NAME, \n");
		sql.append("B.GENRE_NAME AS GENRE_NAME, \n");
		sql.append("COALESCE(AVG(C.RATING), 0) AS AVG_RATING \n");
		sql.append("FROM t_shop AS A \n");
		sql.append("LEFT JOIN T_SHOP_GENRE_MAP AS MP ON A.SHOP_ID = MP.SHOP_ID \n");
		sql.append("LEFT JOIN T_SHOP_GENRE AS B ON MP.GENRE_ID = B.GENRE_ID \n");
		sql.append("LEFT JOIN t_review AS C ON A.SHOP_ID = C.SHOP_ID \n");
		sql.append("GROUP BY A.SHOP_NAME, B.GENRE_NAME \n");
		sql.append("HAVING COALESCE(AVG(C.RATING), 0) >= 4 \n");
		sql.append("ORDER BY RAND() \n");
		sql.append("LIMIT 3");
		String sqlStr = sql.toString();

		// SQL実行
		try (Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(sqlStr);
				ResultSet rs = ps.executeQuery()) {

			// ResultSetオブジェクトからDTOリストに格納
			while (rs.next()) {
				ShopListDto dto = new ShopListDto();
				dto.setShopName(rs.getString("SHOP_NAME"));
				dto.setGenreName(rs.getString("GENRE_NAME"));
				dto.setAvgRating(rs.getDouble("AVG_RATING"));
				dtoList.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return dtoList;
	}

}
