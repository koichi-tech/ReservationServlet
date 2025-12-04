package com.example.dto;

public class ShopListDto {

	private String shopName;
	private String genreName;
	private double avgRating;

	// ----------------------------------------------------------------
	// getter/setter
	// ----------------------------------------------------------------
	// --- ゲッター (Getter: フィールドの値を取得) ----------------------------
	public String getShopName() {
		return shopName;
	}

	public String getGenreName() {
		return genreName;
	}

	public double getAvgRating() {
		return avgRating;
	}

	// --- セッター (Setter: フィールドに値を設定) ----------------------------
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
	}

}
