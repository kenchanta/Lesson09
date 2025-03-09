package jp.co.kiramex.dbSample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.kiramex.dbSample.entity.Country;
import jp.co.kiramex.dbSample.util.DatabaseManager;

public class CountryDAO {

    //DB接続と結果取得のための変数
    private PreparedStatement pstmt;
    private ResultSet rs;

    //検索結果に合致するCountryオブジェクトリストを取得するメソッド
    public List<Country> getCountryFromName(String Name){
        //メソッドの結果として返すリスト
        List<Country>results = new ArrayList<Country>();

        try {
            Connection con = DatabaseManager.getConnection();
            //命令とそれをDB上で実行するメソッド
            String sql = "SELECT * FROM coutry where name = ?";
            pstmt = con.prepareStatement(sql);

            //SELECT文の実行と結果格納
            pstmt.setString(1, sql);
            rs = pstmt.executeQuery();

            //結果表示
        while(rs.next()) {
            Country country = new Country();
            country.setName(rs.getString("Name"));
            country.setPopulation(rs.getInt("Population"));

            results.add(country);
            }

        }catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally{
                if( rs != null ){
                    try {
                        rs.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if( pstmt != null ){
                    try {
                        pstmt.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                DatabaseManager.close();
            }
            return results;
            }
    }

