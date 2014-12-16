import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;


public class addsv {
	Connection c=new getconect().getcon();
public addsv(String name,String lop,String mssv,String que,String ngaysinh,int dt,String khoa,int gt ,String maph){
	Date today=new Date(System.currentTimeMillis());
	SimpleDateFormat dinhDangThoiGian = new SimpleDateFormat("dd/MM/yyyy ");
	String ngayvao = dinhDangThoiGian.format(today.getTime());
	String gioitinh;
	if(gt==0)gioitinh="nam";
	else gioitinh="nu";
	String doituong="0"+dt;
	try {
	Statement stmt =c.createStatement();
	String sql="insert into sinhvien(mssv,ten,quequan,lop,ngaysinh,gioitinh,maph,khoa,ngayvao,doituong)"
				+"values "+"('"+mssv+"','"+name+"','"+que+"','"+lop+"','"+ngaysinh+"','"+gioitinh+"','"+maph+"','"+khoa+"','"+ngayvao+"','"+doituong+"');";
	stmt.executeUpdate(sql);
    sql="update phong set songuoi=songuoi+1 where maph ='"+maph+"';";
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
