<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>わくわく食堂 | 予約ナビ</title>
<link rel="stylesheet" href="./css/style.css">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@400;700&display=swap"
	rel="stylesheet">
<style>
/* 店舗詳細ページ専用のスタイル調整 */
.shop-header {
	background-color: white;
	padding: 30px;
	border-radius: 15px;
	box-shadow: 0 6px 12px rgba(0, 0, 0, 0.1);
	margin-bottom: 30px;
	text-align: center;
}

.shop-header h2 {
	font-size: 2.5em;
	margin-bottom: 5px;
}

.rating-display {
	font-size: 1.5em;
	color: #ffc107; /* 星の色 */
	margin-bottom: 15px;
}

.shop-info-grid {
	display: grid;
	grid-template-columns: 2fr 1fr;
	gap: 30px;
}

.shop-info-box, .review-card, .time-table {
	background-color: white;
	padding: 25px;
	border-radius: 15px;
	box-shadow: 0 2px 4px rgba(0, 0, 0, 0.05);
	margin-bottom: 20px;
}

.time-table th, .time-table td {
	padding: 8px;
	border-bottom: 1px dashed #ffcdd2;
}

.review-card h4 {
	color: #00bcd4;
	margin-top: 0;
}
</style>
</head>
<body>

	<header class="pop-header">
		<h1>🍣 日野ナビ</h1>
		<nav class="nav-bar">
			<a href="index.jsp">ホーム</a> <a href="#">ランキング</a> <a
				href="mypage.jsp">マイページ</a>
		</nav>
	</header>

	<main class="container">

		<div class="shop-header">
			<h2>${shopDetail.shopName}</h2>
			<div class="rating-display">⭐⭐⭐⭐⭐ ${shopDetail.avgRating}</div>
			<button class="reserve-btn"
				onclick="location.href='reservation.html'">この店を予約する</button>
		</div>

		<div class="shop-info-grid">
			<div>
				<section class="shop-info-box">
					<h3>店舗情報</h3>
					<p>
						<strong>住所:</strong> ${shopDetail.fullAddress}
					</p>
					<p>
						<strong>電話番号:</strong> ${shopDetail.phoneNumber}
					</p>
					<p>
						<strong>ジャンル:</strong> ${shopDetail.genreName}
					</p>
					<p>
						<strong>紹介:</strong> 地元野菜を使った美味しい定食が人気です！
					</p>
				</section>

				<hr>

				<section>
					<h3>✨ みんなのレビュー (35件)</h3>
					<div class="review-card">
						<h4>
							山田 太郎 さん <span style="float: right; color: #ffc107;">⭐⭐⭐⭐⭐</span>
						</h4>
						<p>料理が美味しく、接客も丁寧でした！また利用させていただきます。</p>
						<span style="font-size: 0.8em; color: #aaa;">投稿日:
							2025/11/25</span>
					</div>
					<div class="review-card">
						<h4>
							佐藤 花子 さん <span style="float: right; color: #ffc107;">⭐⭐⭐⭐</span>
						</h4>
						<p>雰囲気が良かったです。週末は少し混みますね。</p>
						<span style="font-size: 0.8em; color: #aaa;">投稿日:
							2025/11/18</span>
					</div>
					<button class="search-btn">全てのレビューを見る</button>
				</section>
			</div>

			<aside>
				<section class="shop-info-box">
					<h3>🕒 営業時間</h3>
					<table class="time-table" style="width: 100%;">
						<tr>
							<th>曜日</th>
							<th>時間</th>
						</tr>
						<tr>
							<td>月〜金</td>
							<td>11:30 - 14:00<br>17:00 - 22:00
							</td>
						</tr>
						<tr>
							<td>土・日</td>
							<td>11:00 - 22:00 (通し営業)</td>
						</tr>
						<tr>
							<td>定休日</td>
							<td>火曜日</td>
						</tr>
					</table>
				</section>

				<section class="shop-info-box">
					<h3>📍 アクセス</h3>
					<div class="card-image-placeholder"
						style="height: 150px; background-color: #ddd;">[Image of map
						showing a restaurant location]</div>
					<p style="margin-top: 10px; font-size: 0.9em;">JR日野駅から徒歩5分</p>
				</section>
			</aside>
		</div>

	</main>

	<footer class="pop-footer">
		<p>&copy; 2025 日野ナビ予約システム</p>
	</footer>

</body>
</html>