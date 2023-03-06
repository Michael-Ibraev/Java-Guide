package com.example.javaguide;
import java.sql.*;
import java.util.ArrayList;
public class DB {
    public static final String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/java_guide?useSSL=false";
    public static final String DATABASE_USERNAME = "root";
    public static final String DATABASE_PASSWORD = "481516";
    public static final String CHAPTERS_SELECT = "SELECT chapter_name FROM java_guide.chapters";
    public static final String CHAPTERS_ID_SELECT = "SELECT chapter_id FROM java_guide.chapters";
    public static final String SELECT_QUERY = "SELECT * FROM java_guide.users WHERE login = ? and password = ?;";

    public boolean validate(String login, String password) throws SQLException {
        Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);
        preparedStatement.setString(1, login);
        preparedStatement.setString(2, password);
        System.out.println(preparedStatement);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            connection.close();
            return true;
        }
        else { connection.close();
            return false;
        }
    }

    //Метод для выборки названий разделов учебника из БД
    public ArrayList<String> getChapters() throws SQLException {
        Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement(CHAPTERS_SELECT);
        ResultSet res = preparedStatement.executeQuery();
        ArrayList<String> info = new ArrayList<>();
        while(res.next()){
            info.add(res.getString(1));
        }
        connection.close();
        return info;
    }
    //Метод для выборки id разделов учебника из БД
    public ArrayList<String> getChapterId() throws SQLException {
        Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement(CHAPTERS_ID_SELECT);
        ResultSet res = preparedStatement.executeQuery();
        ArrayList<String> info = new ArrayList<>();
        while(res.next()){
            info.add(res.getString(1));
        }
        connection.close();
        return info;
    }
    //Метод для осуществления поиска разделов учебника путем выборки данных из БД с использованием оператора LIKE
    public ArrayList<String> searchChapters(String expression) throws SQLException {
        Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM java_guide.chapters WHERE chapter_name like '%"+expression+"%'");
        System.out.println(preparedStatement);
        ResultSet res = preparedStatement.executeQuery();
        ArrayList<String> info = new ArrayList<>();
        while(res.next()){
            info.add(res.getString(2));
        }
        connection.close();
        return info;
    }
}
