import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;


public class giaitankhu {
Connection c= new getconect().getcon();
public giaitankhu(int khugt)
{
	String khu;
	if(khugt==0)khu="b5";
	else{
		if(khugt==1)khu="b6";else khu="b7";
	}
	Statement stmt;
	try {
		stmt=c.createStatement();
		String sql="delete from sinhvien where maph like '"+khu+"%';";
		stmt.executeUpdate(sql);
		sql="update phong set songuoi=0 where nha='"+khu+"';";
		stmt.executeUpdate(sql);
		sql="update diennuoc set dtt =0 ,dts =0 ,ntt =0 ,nts =0 ,sum_sd =0 ,sum_nc =0 ,tiendien =0 ,tnuoc =0 "+"where maph like '"+khu+"%';";
		stmt.executeUpdate(sql);
		JOptionPane.showMessageDialog(null, "successful");
		stmt.close();
		c.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
