package com.example.dto;

public class ShopDetailDto {

	private String shopId;
	private String shopName;
	private String phoneNumber;
	private String city;
	private String address;
	private String genreName;
	private double avgRating;

	private String fullAddress;
	
	// ----------------------------------------------------------------
	// getter/setter
	// ----------------------------------------------------------------
	// --- ゲッター (Getter: フィールドの値を取得) ----------------------------
	public String getShopId() {
		return shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getCity() {
		return city;
	}

	public String getAddress() {
		return address;
	}

	public String getGenreName() {
		return genreName;
	}

	public double getAvgRating() {
		return avgRating;
	}
	
	public String getFullAddress() {
		return fullAddress;
	}

	// --- セッター (Setter: フィールドに値を設定) ----------------------------
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
	}

	public void setFullAddress(String city, String address) {
	    this.fullAddress = city + address;
	}
	
}