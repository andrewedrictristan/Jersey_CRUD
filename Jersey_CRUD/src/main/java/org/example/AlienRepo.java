package org.example;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class AlienRepo {
    //List<Alien> aliens;

    Connection conn = null;

    public AlienRepo()  {
        String url = "jdbc:mysql://localhost:3306/restdb";
        String username = "root";
        String pass = "Chop2014M4rlboro!";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,username,pass);
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        /*aliens = new ArrayList<>();

        Alien a1 = new Alien();
        a1.setName("Navin");
        a1.setPoints(60);
        a1.setId(101);

        Alien a2 = new Alien();
        a2.setName("Andrew");
        a2.setPoints(70);
        a2.setId(102);

        aliens.add(a1);
        aliens.add(a2);*/
    }

    public List<Alien> getAliens(){
        List<Alien> aliens = new ArrayList<>();
        String sql= "select * from alien";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                Alien a = new Alien();
                a.setId(rs.getInt(1));
                a.setName(rs.getString(2));
                a.setPoints(rs.getInt(3));

                aliens.add(a);

            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return aliens;
    }

    public Alien getAlien(int id){

        String sql= "select * from alien where  id =" +id;
        Alien a = new Alien();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()){

                a.setId(rs.getInt(1));
                a.setName(rs.getString(2));
                a.setPoints(rs.getInt(3));



            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return a;
/*
        for (Alien a: aliens){
            if (a.getId() == id){
                return a;
            }
        }
        return null;*/
    }


    public void create(Alien a1) {
        //aliens.add(a1);
        String sql = "INSERT INTO alien VALUES (?,?,?)";

        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,a1.getId());
            st.setString(2, a1.getName());
            st.setInt(3,a1.getPoints());
            st.executeUpdate();


        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void update(Alien a1) {
        //aliens.add(a1);
        String sql = "UPDATE alien SET name=? , points=? where id =?";

        try {
            PreparedStatement st = conn.prepareStatement(sql);

            st.setString(1, a1.getName());
            st.setInt(2,a1.getPoints());
            st.setInt(3,a1.getId());

            st.executeUpdate();


        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void deleteAlien(int id){
        String sql = "DELETE FROM alien where id =?";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,id);

            st.executeUpdate();


        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
