package com.buddystore.test;

import com.buddystore.model.DBConnect;
import com.buddystore.model.MariaDBCon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DoaTest5 {
    static Connection conn = null;
    static PreparedStatement pstmt = null;

    public static void main(String[] args) {
        DBConnect con = new MariaDBCon();
        conn = con.connect();
        if(conn!=null){
            System.out.println("PostgreSQL 연결 성공");
        }

        String sql = "delete from notice where no=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 5);
            int cnt = pstmt.executeUpdate();
            if(cnt>0){
                System.out.println("1건의 레코드가 삭제되었습니다.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(pstmt, conn);
        }
    }
}
