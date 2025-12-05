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

	public List<ShopListDto> SelectShopList() {

		// 抽出結果格納用DTOリスト
		List<ShopListDto> dtoList = new ArrayList<ShopListDto>();

		// 発行するSQL文の生成（SELECT）
		String sql = "SELECT A.SHOP_NAME AS SHOP_NAME, " + "B.GENRE_NAME AS GENRE_NAME, "
				+ "COALESCE(AVG(C.RATING), 0) AS AVG_RATING " + "FROM t_shop AS A "
				+ "LEFT JOIN T_SHOP_GENRE_MAP AS MP ON A.SHOP_ID = MP.SHOP_ID "
				+ "LEFT JOIN T_SHOP_GENRE AS B ON MP.GENRE_ID = B.GENRE_ID "
				+ "LEFT JOIN t_review AS C ON A.SHOP_ID = C.SHOP_ID " + "GROUP BY A.SHOP_NAME, B.GENRE_NAME";

		try (Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
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
