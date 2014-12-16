import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JOptionPane;


public class thuhoiphong {
	Connection c=new getconect().getcon();
	public thuhoiphong(int khui,String phong) {
		String khu;
		if(khui==0)khu="b5";
		else{
			if(khui==1)khu="b6";else khu="b7";
		}
		String maph=khu+"-"+phong;
		Statement stmt;
		try {
			stmt=c.createStatement();
			String sql="delete from sinhvien where maph='"+maph+"';";
			stmt.executeUpdate(sql);
			sql="update phong set songuoi=0 where maph='"+maph+"';";
			stmt.executeUpdate(sql);
			sql="update diennuoc set dtt =0 ,dts =0 ,ntt =0 ,nts =0 ,sum_sd =0 ,sum_nc =0 ,tiendien =0 ,tnuoc =0 "
					+"where maph = '"+maph+"';";
			stmt.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "successful");
			stmt.close();
			c.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
