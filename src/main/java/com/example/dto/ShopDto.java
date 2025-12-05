package com.example.dto;

public class ShopDto {

	private Long shopId;
	private String shopName;
	private String phoneNumber;
	private String address;
	private String city;

	// ----------------------------------------------------------------
	// getter/setter
	// ----------------------------------------------------------------

	// --- ゲッター (Getter: フィールドの値を取得) ---

	public Long getShopId() {
		return shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	// --- セッター (Setter: フィールドの値を設定) ---
	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
