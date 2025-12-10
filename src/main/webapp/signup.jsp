<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>新規会員登録 | 予約ナビ</title>
    <link rel="stylesheet" href="./css/style.css">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@400;700&display=swap" rel="stylesheet">
    <style>
        /* 新規登録画面専用のスタイル調整 */
        .signup-container {
            max-width: 550px;
            margin: 40px auto;
            background-color: white;
            padding: 40px;
            border-radius: 15px;
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.2);
            text-align: center;
        }
        .signup-container h2 {
            margin-bottom: 30px;
            color: #e91e63;
        }
        .form-group {
            margin-bottom: 20px;
            text-align: left;
        }
        .form-group label {
            display: block;
            font-weight: 700;
            margin-bottom: 5px;
            color: #333;
        }
        .form-group input, .form-group select {
            width: 100%;
            padding: 12px;
            border: 1px solid #ffcdd2;
            border-radius: 8px;
            box-sizing: border-box;
            font-size: 1em;
        }
        .register-btn {
            width: 100%;
            padding: 15px;
            margin-top: 30px;
            background-color: #4caf50; /* 登録ボタンは緑色で目立たせる */
            color: white;
            border: none;
            border-radius: 8px;
            font-size: 1.1em;
            font-weight: 700;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        .register-btn:hover {
            background-color: #388e3c;
        }
        .login-link {
            margin-top: 25px;
            font-size: 0.95em;
        }
        .login-link a {
            color: #00bcd4; /* ポップな水色 */
            text-decoration: none;
            font-weight: 700;
        }
        .name-group {
            display: flex;
            gap: 10px;
        }
        .name-group div {
            flex: 1;
        }
    </style>
</head>
<body>

    <header class="pop-header">
        <h1>🍣 日野ナビ</h1>
        <nav class="nav-bar">
            <a href="index.html">ホーム</a>
            <a href="#">ランキング</a>
        </nav>
    </header>

    <main class="container">

        <div class="signup-container">
            <h2>📝 新規会員登録</h2>

            <form action="SignUpServlet" method="POST">
                
                <div class="form-group">
                    <label for="name">氏名 <span style="color:red;">*</span></label>
                    <input type="text" id="userName" name="userName" required placeholder="山田 太郎">
                </div>

                <div class="form-group">
                    <label for="email">メールアドレス <span style="color:red;">*</span></label>
                    <input type="email" id="mailAddress" name="mailAddress" required placeholder="ログインIDとして使用します">
                </div>

                <div class="form-group">
                    <label for="password">パスワード <span style="color:red;">*</span></label>
                    <input type="password" id="userPassword" name="userPassword" required placeholder="8文字以上">
                </div>
                
                <div class="form-group">
                    <label for="phone">電話番号 <span style="color:red;">*</span></label>
                    <input type="tel" id="phoneNumber" name="phoneNumber" required placeholder="090-xxxx-xxxx (ハイフン可)">
                </div>

                <div class="form-group">
                    <label for="birthdate">誕生日</label>
                    <input type="date" id="birthdate" name="birthday">
                </div>
                
                <div class="form-group">
                    <label for="gender">性別</label>
                    <select id="gender" name="gender">
                        <option value="">--選択してください (任意)--</option>
                        <option value="1">男性</option>
                        <option value="2">女性</option>
                        <option value="3">その他/回答しない</option>
                    </select>
                </div>

                <button type="submit" class="register-btn">アカウントを登録する</button>
            </form>

            <div class="login-link">
                <p>すでにアカウントをお持ちの方へ</p>
                <a href="/LoginServlet">ログインはこちら</a>
            </div>
            
        </div>

    </main>

    <footer class="pop-footer">
        <p>&copy; 2025 日野ナビ予約システム</p>
    </footer>

</body>
</html>