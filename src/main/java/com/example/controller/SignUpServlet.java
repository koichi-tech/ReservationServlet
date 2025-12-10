package com.example.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

import com.example.dao.SignUpDao;
import com.example.dto.SignUpDto;
import com.example.service.SignUpService;
import com.example.strategy.SignUpStrategy;
import com.example.strategy.SignUpUser;

/**
 * Servlet implementation class SignUpServlet
 */

public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Serviceを保持するように変更（StrategyはServiceの内部で保持される）
		private SignUpService signUpService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    /**
     * サーブレットの初期化処理。ここで依存オブジェクトを初期化する（ベストプラクティス）。
     */
    @Override
    public void init() throws ServletException {
        // 1. DAOの初期化（具体的な実装クラスを使用）
        SignUpDao signUpDao = new SignUpDao(); // 仮にSignUpDaoImplとします

        // 2. Strategyの初期化（DAOを注入）
        SignUpStrategy strategy = new SignUpUser(signUpDao);

        // 3. Serviceの初期化（Strategyを注入）
        this.signUpService = new SignUpService(strategy); 
        
        // 注: SignUpServiceのコンストラクタが Strategy を受け取る形になっている必要があります
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		request.setCharacterEncoding("UTF-8");
		String forwardPath = "signup.jsp";
		// index.jspにフォワード（結果を渡しながら遷移）
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
		
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		// --- 1. リクエストパラメータの取得 ---
        // (型変換前のデータは StringStr のように区別します)
		String userName = request.getParameter("userName");
		String genderStr = request.getParameter("gender");    // ★Stringとして保持
		String birthdayStr = request.getParameter("birthday"); // ★Stringとして保持
		String mailAddress= request.getParameter("mailAddress");
		String userPassword= request.getParameter("userPassword");
		String phoneNumber = request.getParameter("phoneNumber");
		
		// 外部メソッドを呼び出し、型変換後の値を変数に代入
        // 戻り値の型に合わせて、新しい変数（Integer型、LocalDate型）を宣言
        Integer gender = parseGender(request, response, genderStr);
        LocalDate birthday = parseBirthday(request, response, birthdayStr);
		
        // DTOのコンストラクタに、正しい型の変数を渡す
		SignUpDto signupDto = new SignUpDto(userName, gender, birthday, mailAddress, userPassword, phoneNumber);
		
		// --- 2. サービス層の実行 ---
		boolean isSuccess = this.signUpService.executeUserCreation(signupDto);

        // ... (後続の成功/失敗の処理はそのまま) ...
		if (isSuccess) {
			String forwardPath = "login_index.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
			dispatcher.forward(request, response);
		} else {
	       request.setAttribute("errorMessage", "ユーザー登録に失敗しました。入力内容を確認してください。");
	       this.doGet(request, response);
		}
	}


	private Integer parseGender(HttpServletRequest request, HttpServletResponse response, String genderStr)throws ServletException, IOException {

    if (genderStr == null || genderStr.isEmpty()) {
       return null;
    }

    try {
       return Integer.valueOf(genderStr);
    } catch (NumberFormatException e) {
       request.setAttribute("errorMessage", "性別の入力形式が不正です。");
       this.doGet(request, response);
     // 例外を投げることで、doPostの実行を即座に中断させます
       throw new ServletException("Invalid gender format", e);	
    }
   }
	
   
	
	/**
	 * String型の生年月日パラメータをLocalDateに安全に変換する。
	 * 変換失敗時はエラーを設定し、処理を中断する。
	 */
	private LocalDate parseBirthday(HttpServletRequest request, HttpServletResponse response, String birthdayStr)throws ServletException, IOException {
	   if (birthdayStr == null || birthdayStr.isEmpty()) {
	  return null;
	   }

	   try {
	  return LocalDate.parse(birthdayStr);
	   } catch (java.time.format.DateTimeParseException e) {
	  request.setAttribute("errorMessage", "生年月日の入力形式が不正です。YYYY-MM-DD形式で入力してください。");
	  this.doGet(request, response);
	  // 例外を投げることで、doPostの実行を即座に中断させます
	  throw new ServletException("Invalid birthday format", e); 
	   }
	}

}
