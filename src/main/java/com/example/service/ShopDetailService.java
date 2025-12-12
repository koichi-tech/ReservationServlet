package com.example.service;

import java.util.Collections;
import java.util.List;

import com.example.dao.ReviewDao;
import com.example.dao.ShopDetailDao;
import com.example.dto.ReviewDto;
import com.example.dto.ShopDetailDto;
import com.example.dto.ShopDetailPageDto;

/**
 * ----------------------------------------------------------------------
 * ShopDetail画面用データの取得
 * ----------------------------------------------------------------------
 **/
public class ShopDetailService {

	private ShopDetailDao shopDetailDao = new ShopDetailDao();
	private ReviewDao reviewDao = new ReviewDao();

	public ShopDetailPageDto getShopDetailPage(String shopId) {

		// 格納用DTO
		ShopDetailPageDto pageDto = new ShopDetailPageDto();

		// 店舗関連情報取得
		ShopDetailDto shopDetail = shopDetailDao.selectShopDetail(shopId);

		// レビュー情報取得
		List<ReviewDto> reviewList = reviewDao.selectReviewsByShopId(shopId);

		// 取得したレビュー情報から画面表示用にランダムで2件取得
		List<ReviewDto> displayReviewList;
		if (reviewList.size() <= 2) {
			displayReviewList = reviewList; 
		} else {
			// 3件以上の場合、シャッフルして先頭2件を抽出
			Collections.shuffle(reviewList);
			displayReviewList = reviewList.subList(0, 2);
		}

		// 取得情報を格納
		pageDto.setShopDetail(shopDetail);
		pageDto.setReviewList(reviewList);
		if (reviewList == null) {
			pageDto.setReviewListCount(0);
		} else {
			pageDto.setReviewListCount(reviewList.size());
		}
		pageDto.setDisplayReviewList(displayReviewList);

		return pageDto;
	}
}
