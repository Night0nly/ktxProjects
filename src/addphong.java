package ktx;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class addphong {
Connection c=new getconect().getcon();
public addphong(String phong,int khu,int loaiphong){
	String addp_khu,addp_loai;
	if(khu==0)addp_khu="b5";
	else if(khu==1)addp_khu="b6";
	else addp_khu="b7";
	if(loaiphong==0)addp_loai="nam";
	else addp_loai="nu";
	int songuoi=0;
	Statement stmt;
	String maph=addp_khu+"-"+phong;
	try {
		stmt =c.createStatement();
	String sql="insert into phong(maph,nha,songuoi,loaiphong)"+"values "+"('"+maph+"','"+addp_khu+"',"+songuoi+",'"+addp_loai+"');";
	stmt.executeUpdate(sql);
	sql ="insert into diennuoc(maph,dtt,dts,ntt,nts,sum_sd,sum_nc,tiendien,tnuoc)"
			+"values ('"+maph+"',0,0,0,0,0,0,0,0);";
	stmt.executeUpdate(sql);
	stmt.close();

	c.close();
} catch (SQLException e) {
	JOptionPane.showMessageDialog(null, "co loi phat sinh ( da ton tai phong hoac vuot qua so phong cua khu ) ", null,
            JOptionPane.INFORMATION_MESSAGE);
	e.printStackTrace();
}	
	
}
}
