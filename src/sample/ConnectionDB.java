package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class ConnectionDB {
    private final static String URL = "jdbc:mysql://localhost:3307/example";
    private final static String LOGIN = "root";
    private final static String PASSWORD = "mysql";
    private static Connection conn;
    private static Statement statement;
    private static ObservableList<User> listBase = FXCollections.observableArrayList();

    public static void connection(){
        try {
            conn = DriverManager.getConnection(URL,LOGIN,PASSWORD);
            statement = conn.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void insert(String login, String password){
        String query = String.format("insert into usersfx(login, passwords) values ('%s','%s');",login,password);
        try {
            statement.executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static ObservableList<User> getData(){
        listBase.clear();
        try {
            ResultSet resultSet = statement.executeQuery("select * from usersfx;");
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String login = resultSet.getString("login");
                String password = resultSet.getString("passwords");
                User user = new User(id,login,password);
                listBase.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return listBase;
    }

    public static void delete(int id){
        String query = String.format("delete from usersfx where id=%d",id);
        try {
            statement.addBatch(query);statement.addBatch("SET @num := 0;");statement.addBatch("UPDATE usersfx SET id = @num := (@num+1);");statement.addBatch("ALTER TABLE usersfx AUTO_INCREMENT = 1;");statement.executeBatch();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
