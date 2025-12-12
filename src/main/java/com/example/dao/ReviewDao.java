package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.dto.ReviewDto;

public class ReviewDao extends BaseDao {

	public List<ReviewDto> selectReviewsByShopId(String shopId) {

		// 抽出結果格納用DTOリスト
		List<ReviewDto> dtoList = new ArrayList<>();

		// 発行するSQL文の生成（SELECT）
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT \n");
		sql.append("R.REVIEW_ID, \n");
		sql.append("R.USER_ID, \n");
		sql.append("U.USER_NAME, \n");
		sql.append("R.RATING, \n");
		sql.append("R.COMMENT, \n");
		sql.append("R.CREATED_AT \n");
		sql.append("FROM T_REVIEW R \n");
		sql.append("LEFT JOIN T_USER U ON R.USER_ID = U.USER_ID \n");
		sql.append("WHERE R.SHOP_ID = ? \n");
		sql.append("ORDER BY R.CREATED_AT DESC");
		String sqlStr = sql.toString();

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sqlStr)) {
			ps.setString(1, shopId);

			// SQL実行
			try (ResultSet rs = ps.executeQuery()) {
				// ResultSetオブジェクトからDTOリストに格納
				while (rs.next()) {
					ReviewDto dto = new ReviewDto();
					dto.setReviewId(rs.getString("REVIEW_ID"));
					dto.setUserId(rs.getString("USER_ID"));
					dto.setUserName(rs.getString("USER_NAME"));
					dto.setRating(rs.getInt("RATING"));
					dto.setComment(rs.getString("COMMENT"));
					dto.setCreatedAt(rs.getString("CREATED_AT"));
					dtoList.add(dto);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}
}
