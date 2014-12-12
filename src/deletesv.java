package ktx;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class deletesv {
	Connection c=new getconect().getcon();
	public deletesv(String mssv){
		Statement stmt;
		try {
			String maphong;
			stmt=c.createStatement();		
			ResultSet rs1=stmt.executeQuery("select maph from sinhvien where mssv='"+mssv+"';");
			rs1.next();
			maphong=rs1.getString("maph");
			
			
			String sql="delete from sinhvien where mssv='"+mssv+"';";
			//String sql1="update phong ";
			stmt.executeUpdate(sql);
			sql="update phong set songuoi=songuoi-1 where maph='"+maphong+"';";
			stmt.executeUpdate(sql);
			ResultSet rs=stmt.executeQuery("select songuoi from phong");
			rs.next();
			int songuoi=rs.getInt("songuoi");
			if(songuoi==0)
			{
				sql="update diennuoc set dtt =0 ,dts =0 ,ntt =0 ,nts =0 ,sum_sd =0 ,sum_nc =0 ,tiendien =0 ,tnuoc =0 "
						+"where maph = '"+maphong+"';";
				stmt.executeUpdate(sql);
			}
			stmt.close();
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
