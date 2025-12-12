package com.example.dto;

import java.util.List;

public class ShopDetailPageDto {

	// 店舗情報用DTO
	private ShopDetailDto shopDetail;

	// レビュー用DTOリスト
	private List<ReviewDto> reviewList;

	// レビュー件数用変数
	private int reviewListCount;

	// レビュー（画面表示）用DTOリスト
	private List<ReviewDto> displayReviewList;

	// ----------------------------------------------------------------
	// getter/setter
	// ----------------------------------------------------------------
	// --- ゲッター (Getter: フィールドの値を取得) ----------------------------
	public ShopDetailDto getShopDetail() {
		return shopDetail;
	}

	public List<ReviewDto> getReviewList() {
		return reviewList;
	}

	public int getReviewListCount() {
		return reviewListCount;
	}

	public List<ReviewDto> getDisplayReviewList() {
		return displayReviewList;
	}

	// --- セッター (Setter: フィールドに値を設定) ----------------------------
	public void setShopDetail(ShopDetailDto shopDetail) {
		this.shopDetail = shopDetail;
	}

	public void setReviewList(List<ReviewDto> reviewList) {
		this.reviewList = reviewList;
	}

	public void setReviewListCount(int reviewListCount) {
		this.reviewListCount = reviewListCount;
	}

	public void setDisplayReviewList(List<ReviewDto> displayReviewList) {
		this.displayReviewList = displayReviewList;
	}

}
