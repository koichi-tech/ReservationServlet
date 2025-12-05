package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.dto.ShopDto;

public class ShopDao extends BaseDao {

	public ShopDao() {
		super();
	}

	public List<ShopDto> SelectShopList() {

		// 抽出結果格納用DTOリスト
		List<ShopDto> dtoList = new ArrayList<ShopDto>();

		// 発行するSQL文の生成（SELECT）
		String sql = "SELECT SHOP_ID, SHOP_NAME　FROM t_shop";

		try (Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			// ResultSetオブジェクトからDTOリストに格納
			while (rs.next()) {
				ShopDto dto = new ShopDto();
				dto.setShopId(rs.getLong("SHOP_ID"));
				dto.setShopName(rs.getString("SHOP_NAME"));
				dtoList.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return dtoList;
	}

}
