/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ktx;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author My PC
 */
public class tracuuphong {

    Connection c = new getconect().getcon();
    String loai;
    String quanly;

    public tracuuphong(int khu, String phong, String loai, String quanly) {
        if (phong.length() == 0) {
            JOptionPane.showMessageDialog(null, "Bạn cần nhập từ khóa để tìm", "Thông báo", 1);
        } else {
            try {
                Statement stmt = c.createStatement();
                String sql = "select loaiphong from phong where maph='" + phong + "';";
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    this.loai = rs.getString(1);
                }
                String sql1="select quanlynha from nha,phong where nha.tennha=phong.nha and maph='"+phong+"';";
                ResultSet rs1=stmt.executeQuery(sql1);
                while(rs1.next()){
                this.quanly=rs1.getString(1);
                }
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

}
