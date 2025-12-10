package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.dto.SignUpDto;

public class SignUpDao extends BaseDao{
	
	
	
	
	public SignUpDao() {
		super();
	}
	
	
	public boolean createUser(SignUpDto signupDto) {
		
		//-------------------------------------------
		//SQL発行
		//-------------------------------------------

		//JDBCの接続に使用するオブジェクトを宣言
		//※finallyブロックでも扱うためtryブロック内で宣言してはいけないことに注意
		Connection        con = null ;   // Connection（DB接続情報）格納用変数
		PreparedStatement ps  = null ;   // PreparedStatement（SQL発行用オブジェクト）格納用変数

		//実行結果（真：成功、偽：例外発生）格納用変数
		//※最終的にreturnするため、tryブロック内で宣言してはいけないことに注意
		boolean isSuccess = true ;
		

		
		try {

			con = super.getConnection();
			// ★★★ IMPORTANT: 接続取得に失敗した場合のガード ★★★
            if (con == null) {
                // ログ出力などでDB接続失敗を記録
                System.err.println("DB接続の取得に失敗しました。SignUpDao.createUser()を中断します。");
                return false;
            }
			
            //-------------------------------------------
			//トランザクションの開始
			//-------------------------------------------
			//オートコミットをオフにする（トランザクション開始）
			con.setAutoCommit(false);

			//-------------------------------------------
			//SQL文の送信 ＆ 結果の取得
			//-------------------------------------------

			List<SignUpDto> signUplist = new ArrayList<>();
			
			StringBuilder sqlBuilder = new StringBuilder();
			sqlBuilder.append("INSERT INTO T_USER (");
			sqlBuilder.append("USER_NAME," );
			sqlBuilder.append("GENDER," );
			sqlBuilder.append("BIRTHDAY," );
			sqlBuilder.append("MAIL_ADDRESS," );
			sqlBuilder.append("USER_PASSWORD," );
			sqlBuilder.append("PHONE_NUMBER " );
			sqlBuilder.append(") VALUES (" );
			sqlBuilder.append("?, " );
			sqlBuilder.append("?, " );
			sqlBuilder.append("?, " );
			sqlBuilder.append("?, " );
			sqlBuilder.append("?, " );
			sqlBuilder.append("?)" );
			String sql = sqlBuilder.toString();

			//PreparedStatementオブジェクトを生成＆発行するSQLをセット
			ps = con.prepareStatement(sql.toString());

			//パラメータをセット
			ps.setString(    1, signupDto.getUserName()              ); //第1パラメータ：更新データ（名前）
			ps.setInt(       2, signupDto.getGender()               ); //第2パラメータ：更新データ（年齢）
			ps.setDate(      3, java.sql.Date.valueOf(signupDto.getBirthDay())              ); //第3パラメータ：更新データ（性別）
			ps.setString(    4, signupDto.getMailAddress() ); //第4パラメータ：更新データ（満足度）
			ps.setString(    5, signupDto.getUserPassword()           ); //第5パラメータ：更新データ（メッセージ）
			ps.setString(    6, signupDto.getPhoneNumber()              ); //第6パラメータ：更新データ（電話番号）

			//SQL文の実行
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

			//実行結果を例外発生として更新
			isSuccess = false ;

		} finally {
			//-------------------------------------------
			//トランザクションの終了
			//-------------------------------------------
			if(isSuccess){
				//明示的にコミットを実施
				try {
					con.commit();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}else{
				//明示的にロールバックを実施
				try {
					con.rollback();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			//-------------------------------------------
			//接続の解除
			//-------------------------------------------

			//PreparedStatementオブジェクトの接続解除
			if (ps != null) {    //接続が確認できている場合のみ実施
				try {
					ps.close();  //接続の解除
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			//Connectionオブジェクトの接続解除
			if (con != null) {    //接続が確認できている場合のみ実施
				try {
					con.close();  //接続の解除
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		//実行結果を返す
		return isSuccess;
	}
	

}
