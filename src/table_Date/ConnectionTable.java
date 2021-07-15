package table_Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;

public class ConnectionTable {
    private final static String URL = "jdbc:mysql://localhost:3310/exercise";
    private final static String LOGIN = "root";
    private final static String PASSWORD = "11111";
    private static Connection conn;
    private static Statement statement;
    private static ObservableList<TableClass> listBase = FXCollections.observableArrayList();

    public static void connection(){
        try {
            conn = DriverManager.getConnection(URL,LOGIN,PASSWORD);
            statement = conn.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void insert(String name, LocalDate birthday){
        String query = String.format("insert into human_birthday(human,birthday) values('%s','%tF');",
                     name,birthday);
        try {
            statement.executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static ObservableList<TableClass> getData(){
        try {
            ResultSet resultSet = statement.executeQuery("select * from human_birthday;");
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("human");
                Date date = resultSet.getDate("birthday");

                TableClass theHuman = new TableClass(id,name,date);
                listBase.add(theHuman);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listBase;
    }
}
