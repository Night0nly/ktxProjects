import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


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
		String sql="delete from sinhvien where maph like '"+khu+"';";
		stmt.executeUpdate(sql);
		sql="update phong set songuoi=0 where khu='"+khu+"';";
		stmt.executeUpdate(sql);
		stmt.close();
		c.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	}
}
