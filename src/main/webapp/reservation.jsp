<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>予約 | 予約ナビ</title>
    <link rel="stylesheet" href="style.css">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@400;700&display=swap" rel="stylesheet">
    <style>
        /* 予約ページ専用のスタイル調整 */
        .reservation-form-container {
            max-width: 600px;
            margin: 40px auto;
            background-color: white;
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0 6px 12px rgba(0, 0, 0, 0.1);
        }
        .form-group {
            margin-bottom: 20px;
        }
        .form-group label {
            display: block;
            font-weight: 700;
            margin-bottom: 5px;
            color: #e91e63;
        }
        .form-group input, .form-group select, .form-group textarea {
            width: 100%;
            padding: 10px;
            border: 1px solid #ffcdd2;
            border-radius: 8px;
            box-sizing: border-box;
        }
        .form-group textarea {
            resize: vertical;
            min-height: 100px;
        }
    </style>
</head>
<body>

    <header class="pop-header">
        <h1>🍣 日野ナビ</h1>
        <nav class="nav-bar">
            <a href="index.html">ホーム</a>
            <a href="#">ランキング</a>
            <a href="mypage.html">マイページ</a>
        </nav>
    </header>

    <main class="container">

        <h2>予約確認・入力</h2>

        <div class="reservation-form-container">
            <h3>🍽️ わくわく食堂を予約する</h3>
            <p style="color: #ff80ab;">ご希望の日時と人数を入力してください。</p>

            <form action="confirm.html" method="POST">
                <div class="form-group">
                    <label for="date">予約希望日</label>
                    <input type="date" id="date" name="reservation_date" required>
                </div>

                <div class="form-group">
                    <label for="time">予約希望時間</label>
                    <select id="time" name="reservation_time" required>
                        <option value="">--選択してください--</option>
                        <option value="18:00">18:00</option>
                        <option value="18:30">18:30</option>
                        <option value="19:00">19:00</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="people">人数</label>
                    <input type="number" id="people" name="num_people" min="1" max="10" value="2" required>
                </div>
                
                <div class="form-group">
                    <label for="memo">備考・連絡事項</label>
                    <textarea id="memo" name="memo" placeholder="アレルギー情報や特別な要望があればご記入ください。"></textarea>
                </div>

                <button type="submit" class="reserve-btn" style="width: 100%; padding: 15px; font-size: 1.1em;">予約内容を確認する</button>
            </form>
        </div>

    </main>

    <footer class="pop-footer">
        <p>&copy; 2025 日野ナビ予約システム</p>
    </footer>

</body>
</html>