<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%-- JSTL (JSP Standard Tag Library) のコアタグライブラリをインポート --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- JSTLのフォーマットタグライブラリをインポート (日付表示に使用) --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>マイページ | 予約ナビ</title>
    <link rel="stylesheet" href="./css/style.css">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@400;700&display=swap" rel="stylesheet">
    <style>
        /* マイページ専用のスタイル調整 */
        .profile-card {
            background-color: white;
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            margin-bottom: 40px;
        }
        .profile-card dl {
            display: grid;
            grid-template-columns: 1fr 3fr;
            gap: 15px;
        }
        .profile-card dt {
            font-weight: 700;
            color: #e91e63; /* マゼンタカラー */
        }
        .history-list .table-row {
            /* 履歴に合わせてグリッドレイアウトを調整 */
            grid-template-columns: 2fr 3fr 2fr 1fr; 
        }
        .status-confirmed { color: #4CAF50; font-weight: 700; } /* 確定 */
        .status-completed { color: #9E9E9E; } /* 完了 */
        .status-canceled { color: #F44336; font-weight: 700; } /* キャンセル */
    </style>
</head>
<body>

    <header class="pop-header">
        <h1>🍣 日野ナビ</h1>
        <nav class="nav-bar">
            <%-- ContextPathは環境によって変わるため、JSP側で${pageContext.request.contextPath}を使用するのが安全です --%>
            <a href="${pageContext.request.contextPath}/ReservationPlatForm">ホーム</a>
            <a href="#">ランキング</a>
            <a href="${pageContext.request.contextPath}/MyPageServlet">マイページ</a>
        </nav>
    </header>

    <main class="container">

        <h2>マイページ</h2>
        
        <%-- LOGIN_USER セッション属性が存在する場合のみ情報を表示 --%>
      <%-- 【修正】sessionScope.LOGIN_INFO の代わりに、リクエストスコープの userList をチェック --%>
        <c:if test="${not empty userList[0]}"> 
            <section class="profile-card">
                <h3>🏠 会員情報</h3>
                <dl>
                    <dt>ユーザーID</dt>
                    <%-- 【修正】${userList.userId} に変更 --%>
                    <dd>${userList[0].userId}</dd> 
                    
                    <dt>ユーザー名</dt>
                    <%-- 【修正】${userList.userName} に変更 --%>
                    <dd>${userList[0].userName}</dd>
                    
                    <dt>メールアドレス</dt>
                    <%-- 【修正】${userList.mailAddress} に変更 --%>
                    <dd>${userList[0].mailAddress}</dd>
                    
                    <dt>電話番号</dt>
                    <%-- 【修正】${userList.phoneNumber} に変更 --%>
                    <dd>${userList[0].phoneNumber}</dd>
                    
                    <dt>生年月日</dt>
                    <dd>
                        <%-- 【修正】${userList.birthday} に変更 --%>
                        <fmt:formatDate value="${userList[0].birthday}" pattern="yyyy年MM月dd日" />
                    </dd>
                    
                    <dt>登録日</dt>
                    <dd>
                        <%-- 【修正】${userList.createTime} に変更 --%>
                        <fmt:formatDate value="${userList[0].createTime}" pattern="yyyy/MM/dd" />
                    </dd>
                </dl>
                <%-- 編集機能を持つサーブレットへのリンクは変更なし --%>
                <button class="reserve-btn" onclick="location.href='${pageContext.request.contextPath}/UserInfoEditServlet'" style="margin-top: 20px;">
                    会員情報を編集する
                </button>
            </section>
        </c:if>
        
        <%-- ユーザー情報がない場合の対応 (例: ログイン要求など) --%>
        <c:if test="${empty sessionScope.LOGIN_INFO}">
            <p class="profile-card" style="text-align: center; color: #F44336;">
                会員情報を表示するにはログインが必要です。
            </p>
        </c:if>

        <hr>

        <section class="history-list">
            <h3>📅 予約履歴</h3>
            <div class="restaurant-table">
                <div class="table-row header-row">
                    <div>予約日時</div>
                    <div>店舗名</div>
                    <div>人数</div>
                    <div>ステータス</div>
                </div>
                
                <%-- 予約履歴リストが存在し、空でない場合にループ処理を行う --%>
                <c:choose>
                    <c:when test="${not empty requestScope.RESERVATION_HISTORY}">
                        <c:forEach var="res" items="${requestScope.RESERVATION_HISTORY}">
                            <div class="table-row">
                                <%-- reservationTimeがDate/Timestamp型の場合のフォーマット --%>
                                <div><fmt:formatDate value="${res.reservationTime}" pattern="yyyy/MM/dd HH:mm" /></div>
                                <div>${res.shopName}</div>
                                <div>${res.numberOfPeople}名</div>
                                
                                <%-- ステータスに応じてクラスを動的に変更して色を付ける --%>
                                <div class="status-${res.statusClass}">
                                    ${res.statusDisplay}
                                </div>
                            </div>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <div class="table-row" style="grid-template-columns: 1fr;">
                            <div style="text-align: center; padding: 10px;">
                                現在、予約履歴はありません。
                            </div>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </section>

    </main>

    <footer class="pop-footer">
        <p>&copy; 2025 日野ナビ予約システム</p>
    </footer>

</body>
</html>