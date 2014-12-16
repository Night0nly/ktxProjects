import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;


public class editsv {
	Connection c=new getconect().getcon();
public editsv(String mssvc,String name,String lop,String mssv,String que,String ngaysinh,int dt,String khoa,int gt ,String maph){
	String gioitinh;
	if(gt==0)gioitinh="nam";
	else gioitinh="nu";
	String doituong="0"+dt;
	try {
	Statement stmt =c.createStatement();
	String sql="update sinhvien set mssv='"+mssv+"',ten='"+name+"',quequan='"+que+"',lop='"+lop+"',ngaysinh='"+ngaysinh+"',gioitinh='"+gioitinh+"',maph='"+maph+"',khoa='"+khoa+"',doituong='"+doituong+"'where mssv='"+mssvc+"';";				
	stmt.executeUpdate(sql);
	JOptionPane.showMessageDialog(null, "successful");
    stmt.close();
    c.close();
	//stmt.executeQuery(sql);
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}	
	
}
}
