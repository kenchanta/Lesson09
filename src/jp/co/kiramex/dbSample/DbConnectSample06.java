package jp.co.kiramex.dbSample;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import jp.co.kiramex.dbSample.dao.CountryDAO;
import jp.co.kiramex.dbSample.entity.Country;

public class DbConnectSample06 {

    public static void main(String[] args) {
        //インスタンス化しないとそのクラスのメソッドはつかえない（ここではgetCountryFromname）ので、インスタンス化している。
        CountryDAO dao = new CountryDAO();

        System.out.println("検索ワードを入力してください");
        String name = keyIn();

        List<Country> list = dao.getCountryFromName(name);

        /*
         for (Country item : list) の item は、拡張 for 文（for-each loop） におけるループ変数です。これは、リスト list の各要素を順番に取り出し、その要素を item に代入して、ループ内の処理を実行します。
         具体的には、以下のように動作します：
         リストの取得: list は Country 型のオブジェクトを格納するリストです。
         ループの開始: for (Country item : list) により、list 内の各 Country オブジェクトが順番に item に代入されます。
         処理の実行: item を使用して、ループ内で各 Country オブジェクトに対する処理を行います。
         */

        for (Country item : list) {
            System.out.println(item.getName());
            System.out.println(item.getPopulation());
        }
    }


        private static String keyIn() {
            String line = null;
            try {
                BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
                line = key.readLine();
            }catch(IOException e) {
            }
            return line;
        }
}
