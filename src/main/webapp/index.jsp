<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>🍽️ ポップなレストラン予約ナビ</title>
<link rel="stylesheet" href="./css/style.css">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@400;700&display=swap"
	rel="stylesheet">
</head>
<body>

	<header class="pop-header">
		<h1>🍣 日野ナビ</h1>
		<nav class="nav-bar">
			<a href="${pageContext.request.contextPath}/ReservationPlatForm">ホーム</a>
			<a href="">ランキング</a> <a href="/mypage" id="UserName" name="UserName">${sessionScope.LOGIN_INFO.userName}</a>
			<a href="${pageContext.request.contextPath}/LogoutServlet"
				id="Logout" name="Logout">ログアウト</a>
		</nav>
	</header>

	<main class="container">

		<section class="recommendations">
			<h2>✨ おすすめのレストラン</h2>
			<div class="card-grid">
				<c:forEach var="shop" items="${recommendShopList}">
					<div class="restaurant-card">
						<div class="card-image-placeholder"></div>
						<a href="${pageContext.request.contextPath}/ShopDetailServlet">${shop.shopName}</a>
					</div>
				</c:forEach>
			</div>
		</section>

		<hr>

		<section class="restaurant-list-section">
			<div class="list-header">
				<h2>🔍 レストラン一覧</h2>
				<div class="sort-controls">
					<form
						action="${pageContext.request.contextPath}/ReservationPlatForm"
						method="POST">
						<label for="sort">ソート機能:</label> <select name="sort" id="sort">
							<option value="blank"
								<c:if test="${sort == 'blank' || sort == null}">selected</c:if>>なし</option>
							<option value="rating"
								<c:if test="${sort == 'rating'}">selected</c:if>>評価順</option>
						</select> <input type="hidden" name="scrollY" id="scrollY">
						<button type="submit" class="search-btn">検索</button>
					</form>
				</div>
			</div>

			<div class="restaurant-table">
				<div class="table-row header-row">
					<div>店舗名</div>
					<div>ジャンル</div>
					<div>評価</div>
					<div>予約</div>
				</div>
				<!-- DAO から渡されたshopList をループ -->
				<c:forEach var="shop" items="${shopList}">
					<div class="table-row">
						<a href="${pageContext.request.contextPath}/ShopDetailServlet">${shop.shopName}
						</a>
						<div>${shop.genreName}</div>
						<div>⭐${shop.avgRating}</div>
						<form action="ReservationServlet" method="POST">
							<button type="submit" class="reserve-btn">予約する</button>
						</form>
					</div>
				</c:forEach>
			</div>
		</section>

	</main>

	<footer class="pop-footer">
		<p>&copy; 2025 日野ナビ予約システム</p>
	</footer>

	<script>
	document.querySelector('.sort-controls form').addEventListener('submit', function () {
      document.getElementById('scrollY').value = window.scrollY;
  	});
	</script>
	<c:if test="${not empty param.scrollY}">
		<script>
		window.scrollTo(0, ${param.scrollY});
		</script>
	</c:if>
</body>
</html>