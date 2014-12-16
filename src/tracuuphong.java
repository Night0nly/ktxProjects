/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author My PC
 */
public class tracuuphong {

    Connection c = new getconect().getcon();
    String loai,quanly,khui;
    Vector row,column;
    int numbercolumn;
	public DefaultTableModel tb=new DefaultTableModel();
    public tracuuphong(int khu, String phong, String loai, String quanly,DefaultTableModel tb) {
        if(khu==0)khui="b5";
        if(khu==1)khui="b6";
        if(khu==3)khui="b7";
        String maphong;
        maphong= khui+"-"+phong;
    	if (phong.length() == 0) {
            JOptionPane.showMessageDialog(null, "Bạn cần nhập từ khóa để tìm", "Thông báo", 1);
            
        } else {
            try {
                Statement stmt = c.createStatement();
                String sql="select loaiphong,quanlynha from nha,phong where nha.tennha=phong.nha and maph='"+maphong+"';";
                ResultSet rs1=stmt.executeQuery(sql);
                while(rs1.next()){
                this.quanly=rs1.getString(2);
                this.loai=rs1.getString(1);
                }

                column = new Vector();
                String sql1="select mssv,ten,khoa,ngayvao from sinhvien where maph = '"+maphong+"';";
                ResultSet rs2=stmt.executeQuery(sql1);
                ResultSetMetaData metaData=rs2.getMetaData();
                numbercolumn=metaData.getColumnCount();
                for(int i=1;i<=numbercolumn;i++){
                	column.add(metaData.getColumnName(i));
                }
                this.tb.setColumnIdentifiers(column);
                while(rs2.next()){
                	row=new Vector();
                	for(int i=1;i<=numbercolumn;i++){
                		row.add(rs2.getString(i));
                	}
                	this.tb.addRow(row);
                }
                
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }



}
