package dao;

import java.sql.Connection;
import java.sql.DriverManager;



public class KetNoi {
	public Connection cn;
    public void ketNoi()  throws Exception{
	//nạp database drivers để xác định HQTCSDL
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	System.out.println("\nda xac dinh hqtcsdl");
	//kết nối: 
	String url="jdbc:sqlserver://localhost:1433;databaseName=CuaHangDienTu;user=sa;password=123";
	cn= DriverManager.getConnection(url);
	System.out.println("\nda ket noi");
    }
    public static void main(String[] args) {
        try {
            KetNoi kn = new KetNoi();
            kn.ketNoi();
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}
