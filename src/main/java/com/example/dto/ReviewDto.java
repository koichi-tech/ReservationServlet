package com.example.dto;

public class ReviewDto {

	private String reviewId;
	private String userId;
	private String userName;
	private int rating;
	private String comment;
	private String createdAt;

	// ----------------------------------------------------------------
	// getter/setter
	// ----------------------------------------------------------------
	// --- ゲッター (Getter: フィールドの値を取得) ----------------------------
	public String getReviewId() {
		return reviewId;
	}

	public String getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public int getRating() {
		return rating;
	}

	public String getComment() {
		return comment;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	// --- セッター (Setter: フィールドに値を設定) ----------------------------
	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

}
