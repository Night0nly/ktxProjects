import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;


public class doicho2sv {
	Connection c=new getconect().getcon();
	public doicho2sv(String mssv1,String mssv2){
		Statement stmt;
		try {
			stmt=c.createStatement();
			ResultSet rs=stmt.executeQuery( "SELECT * FROM sinhvien,phong where mssv='"+mssv1+"'and phong.maph=sinhvien.maph;" );
			rs.next();
			String khu1=rs.getString("nha");
			String gtsv1=rs.getString("gioitinh");
			String maph1=rs.getString("maph");
			rs=stmt.executeQuery( "SELECT * FROM sinhvien,phong where mssv='"+mssv2+"'and phong.maph=sinhvien.maph;" );
			rs.next();
			String khu2=rs.getString("nha");
			String gtsv2=rs.getString("gioitinh");
			String maph2=rs.getString("maph");
			if(khu1.compareTo(khu2)==0){
			if(gtsv1.compareTo(gtsv2)==0)
			{
				String sql="update sinhvien set maph='"+maph2+"' where mssv='"+mssv1+"';";
				stmt.executeUpdate(sql);
				sql="update sinhvien set maph='"+maph1+"' where mssv='"+mssv2+"';";
				stmt.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "successful");
				stmt.close();
				c.close();
			}else JOptionPane.showMessageDialog(null, "khac gioi tinh khong the doi phong");
			}else JOptionPane.showMessageDialog(null, "khac khu ky tuc khong the doi");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
