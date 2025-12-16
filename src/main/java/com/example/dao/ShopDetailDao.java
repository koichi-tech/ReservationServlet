package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.example.dto.ShopDetailDto;

public class ShopDetailDao extends BaseDao {

	public ShopDetailDao() {
		super();
	}

	public ShopDetailDto selectShopDetail(String shopId) {

		// 抽出結果格納用DTO
		ShopDetailDto dto = new ShopDetailDto();

		// 発行するSQL文の生成（SELECT）
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT \n");
		sql.append("A.SHOP_ID AS SHOP_ID, \n");
		sql.append("A.SHOP_NAME AS SHOP_NAME, \n");
		sql.append("A.PHONE_NUMBER AS PHONE_NUMBER, \n");
		sql.append("A.PREF_ID AS PREF_ID, \n");
		sql.append("D.PREF_NAME AS PREF_NAME, \n");
		sql.append("A.CITY AS CITY, \n");
		sql.append("A.ADDRESS AS ADDRESS, \n");
		sql.append("B.GENRE_NAME AS GENRE_NAME, \n");
		sql.append("COALESCE(AVG(C.RATING), 0) AS AVG_RATING \n");
		sql.append("FROM t_shop AS A \n");
		sql.append("LEFT JOIN T_SHOP_GENRE_MAP AS MP ON A.SHOP_ID = MP.SHOP_ID \n");
		sql.append("LEFT JOIN T_SHOP_GENRE AS B ON MP.GENRE_ID = B.GENRE_ID \n");
		sql.append("LEFT JOIN t_review AS C ON A.SHOP_ID = C.SHOP_ID \n");
		sql.append("LEFT JOIN T_PREFECTURE AS D ON A.PREF_ID = D.PREF_ID \n");
		// sql.append("LEFT JOIN T_TIME_SLOTS AS D ON A.SHOP_ID = D.SHOP_ID \n");
		sql.append("WHERE A.SHOP_ID = ? \n");
		sql.append("GROUP BY A.SHOP_ID, A.SHOP_NAME, A.PHONE_NUMBER, A.PREF_ID, D.PREF_NAME, A.CITY, A.ADDRESS, B.GENRE_NAME");
		String sqlStr = sql.toString();

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sqlStr);) {
			ps.setString(1, shopId);

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					// 取得結果をdtoにセット
					dto.setShopId(rs.getString("SHOP_ID"));
					dto.setShopName(rs.getString("SHOP_NAME"));
					dto.setPhoneNumber(rs.getString("PHONE_NUMBER"));
					dto.setPrefName(rs.getString("PREF_NAME"));
					dto.setCity(rs.getString("CITY"));
					dto.setAddress(rs.getString("ADDRESS"));
					dto.setGenreName(rs.getString("GENRE_NAME"));
					dto.setAvgRating(rs.getDouble("AVG_RATING"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}

}
