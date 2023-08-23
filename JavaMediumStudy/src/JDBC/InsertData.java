package JDBC;

import java.sql.*;

public class InsertData {
    public static void execute(String sql) throws SQLException {
        try( Connection connection=GetDataBase.GetConnection();Statement s=connection.createStatement()) {
            s.execute(sql);
        }
    }

    public static void main(String[] args) {
        try( Connection connection=GetDataBase.GetConnection();Statement s=connection.createStatement()) {
            for (int i = 4; i < 100; i++) {
               /* //增加数据
                String sql = "insert into hero values(" + i + "," + "'英雄" + i + "'," + 313 + "," + 50 + ")";*/

               /* //删除数据
                String sql = "delete from hero where "+"id="+i;
                */

                //更新数据
//                String sql = "update hero set name='盖伦' where id = 1";
//                s.execute(sql);

                //使用预编译PreparedStatement
                String sql = "insert into hero values(null,?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1,"英雄三");
                preparedStatement.setFloat(2, 313.0f);
                preparedStatement.setInt(3, 50);
                preparedStatement.execute();

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
