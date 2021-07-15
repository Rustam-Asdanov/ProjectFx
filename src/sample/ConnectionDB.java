package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sampleTwo.Friends;

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

//    public static void insert(String login, String password){
//        String query = String.format("insert into usersfx(login, passwords) values ('%s','%s');",login,password);
//        try {
//            statement.executeUpdate(query);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }
//
//    public static ObservableList<User> getData(){
//        listBase.clear();
//        try {
//            ResultSet resultSet = statement.executeQuery("select * from usersfx;");
//            while(resultSet.next()){
//                int id = resultSet.getInt("id");
//                String login = resultSet.getString("login");
//                String password = resultSet.getString("passwords");
//                User user = new User(id,login,password);
//                listBase.add(user);
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//        return listBase;
//    }
//
//    public static void delete(int id){
//        String query = String.format("delete from usersfx where id=%d",id);
//        try {
//            statement.addBatch(query);statement.addBatch("SET @num := 0;");statement.addBatch("UPDATE usersfx SET id = @num := (@num+1);");statement.addBatch("ALTER TABLE usersfx AUTO_INCREMENT = 1;");statement.executeBatch();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }


    public static void insert(Friends friend){
        // insert into friend_list() values ('sdd',
        // String query = "insert " + intA +
        String querry = String.format("insert into friend_list(fl_name,surname,friend_boy,friend_girl) " +
                "values ('%s','%s','%s','%s');",
                friend.getName(),friend.getSurname(),friend.getFriend_boy(),friend.getFriend_girl());

        try {
            statement.executeUpdate(querry);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static ObservableList<Friends> getHumans(){
        ObservableList<Friends> friendsList = FXCollections.observableArrayList();
        try {
            ResultSet resultSet = statement.executeQuery("select * from friend_list;");
            while (resultSet.next()){
                String name = resultSet.getString("fl_name");
                String surname = resultSet.getString("surname");
                String boyName = resultSet.getString("friend_boy");
                String girlName = resultSet.getString("friend_girl");
                friendsList.add(new Friends(name,surname,boyName,girlName));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return friendsList;
    }

    public static String getGirls(int id){
        try {
            ResultSet resultSet = statement.executeQuery("select friend_girl from friend_list where id="+id+";");
            while (resultSet.next()){
                return resultSet.getString("friend_girl");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "null";
    }

    public static void update(Friends friends, String importantName){
        String querry = String.format("update friend_list set fl_name = '%s', surname = '%s', " +
                "friend_boy = '%s', friend_girl='%s' where fl_name='%s';", friends.getName(), friends.getSurname(),
                friends.getFriend_boy(), friends.getFriend_girl(), importantName );
        try {
            statement.executeUpdate(querry);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
