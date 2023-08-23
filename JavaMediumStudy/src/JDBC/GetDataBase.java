package JDBC;

import java.io.BufferedReader;
import java.sql.*;
import java.util.LinkedList;


public class GetDataBase {
    //返回一个数据库对象
    public static Connection connection=null;
    public static Connection GetConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:3306/android?characterEncoding=UTF-8",
                        "root", "123456");

                System.out.println("连接成功，获取连接对象： " + connection);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return connection;
        }
        else return connection;
    }

    public static String GetAnswer(String ReceiveContent) throws SQLException {
        LinkedList<String> SuitList= new LinkedList<>();
        Connection connection = GetConnection();
        String sql="select response from dictionary where receive = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,ReceiveContent);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            SuitList.add(resultSet.getString("response"));
        }
        String Returnstr=null;
        if(SuitList.size()==0) return "请说人话";
        else if(SuitList.size()==1) return SuitList.get(0);
        else return SuitList.get((int)(Math.random()*(SuitList.size())));
    }
}
