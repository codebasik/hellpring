package com.helljava.helpring.repository;

/**
 * Created by yongjunjung on 2016. 7. 21..
 */
public class JoinRepository {

//    public void addUser(String id, String name, String password, String email) {
//
//        Connection conn = DBConnection.getConnection();
//
//        try {
//
//            String query = "INSERT INTO USER (ID, NAME, PASSWORD, EMAIL) VALUES (?,?,?,?)";
//
//            PreparedStatement pstmt = null;
//            pstmt = conn.prepareStatement(query);
//            pstmt.setString(1, id);
//            pstmt.setString(2, name);
//            pstmt.setString(3, password);
//            pstmt.setString(4, email);
//            pstmt.execute();
//
//            DBConnection.close(conn, pstmt);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            DBConnection.close(conn);
//        }
//    }
}
