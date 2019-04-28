package main.connectionPool;


import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

public class Test {

    public void maintask() throws IOException, SQLException {
        BufferedReader bufferedReader = null;
        Connection connection = null;
        try {
            //读取文件
            File file = new File("C:\\Users\\Administrator\\Desktop\\connectionPool.txt");
            FileInputStream in = new FileInputStream(file);
            bufferedReader = new BufferedReader(new InputStreamReader(in,"GBK"));
            Map<Integer,String> map = new HashMap<Integer,String>();
            String temp = null;
            int i = 1;
            while((temp = bufferedReader.readLine()) != null){
                System.out.println(temp);
                map.put(i,temp);
                i++;
            }
            //插入数据库与
            connection = new JdbcPool().getConnection();
            String str = "insert into myprofile(name,age,phone,birthday)values(?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(str);
            pst.setString(1,map.get(1));
            pst.setString(2,map.get(2));
            pst.setString(3,map.get(3));
            pst.setString(4,map.get(4));
            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            bufferedReader.close();
            connection.close();
        }


    }


    public void testbyc3p0(){
        Connection conn = null;
        try {
            InputStream  is = new FileInputStream("dbcp.properties");
            Properties pp = new Properties();
            pp.load(is);
            BasicDataSource dataSource = (BasicDataSource) BasicDataSourceFactory.createDataSource(pp);

            conn = dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(conn);
    }


    public static void main(String[] args) {
        new Test();
    }

}
