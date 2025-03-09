package jp.co.kiramex.dbSample.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    private static Connection con;

    //データベース接続のためのメソッド定義
    public static Connection getConnection() throws SQLException, ClassNotFoundException{
        //ドライバのクラスをJava上で読み込む
        Class.forName("com.mysql.cj.jdbc.Driver");
        //DBと接続
        con = DriverManager.getConnection(
            "jdbc:mysql://localhost/world?useSSL=false&allowPublicKeyRetrieval=true",
            "root",
            "password"
        );
        return con;
    }

    //ドDB接続を閉じるメソッド
    public static void close() {
        if(con!=null) {
            try{
                con.close();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
