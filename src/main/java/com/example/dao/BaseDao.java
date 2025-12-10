package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BaseDao {


	// -------------------------------------------
    // JNDIリソース名のみを定義 (機密情報は context.xml に移動)
    // -------------------------------------------
    private static final String JNDI_RESOURCE_NAME = "java:comp/env/jdbc/webservletDataSource";
    
    /**
     * JNDIデータソースからコネクションを取得します。
     * @return データベースコネクション
     * @throws SQLException 接続失敗時、またはJNDIルックアップ失敗時
     */
    public Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            // 1. InitialContextを取得
            Context initialContext = new InitialContext();
            
            // 2. JNDI名を使ってDataSourceをルックアップ（参照）する
            //    ここで context.xml で定義したデータソースが取得されます。
            DataSource dataSource = (DataSource) initialContext.lookup(JNDI_RESOURCE_NAME);
            
            // 3. DataSourceからコネクションプール経由で接続を取得
            connection = dataSource.getConnection();
            
        } catch (Exception e) {
            // JNDI関連のエラー（NamingExceptionなど）をSQLExceptionとしてラップして再スロー
            throw new SQLException("JNDIリソース「" + JNDI_RESOURCE_NAME + "」からコネクションを取得できませんでした。", e);
        }
        return connection;
    }
    
    /**
     * コネクションを閉じます。コネクションプールに接続を返却します。
     * @param conn 閉じる対象のコネクション
     */
    public void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                // コネクションプールに戻されます
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
