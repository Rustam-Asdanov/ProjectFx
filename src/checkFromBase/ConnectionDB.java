package checkFromBase;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.User;

import java.sql.*;

public class ConnectionDB {
    private final static String URL = "jdbc:mysql://localhost:3310/exercise";
    private final static String LOGIN = "root";
    private final static String PASSWORD = "11111";
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
        String query = String.format("insert into users(login,password) values('%s','%s');",login,password);
        try {
            statement.executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static boolean check(String login, String password){
        try {
            ResultSet resultSet = statement.executeQuery("select * from users;");

            while(resultSet.next()){
                if(
                        resultSet.getString("login").equals(login) &&
                                resultSet.getString("password").equals(password)
                ){
                    return true;
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }
}
