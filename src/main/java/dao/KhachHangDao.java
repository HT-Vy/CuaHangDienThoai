package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.KhachHangBean;


public class KhachHangDao {
	MD5 md5 = new MD5(); 
	public KhachHangBean kiemTraDangNhap(String tendn, String pass) throws Exception{
		//b1: goi ket noi csdl
		KetNoi kn = new KetNoi();
		kn.ketNoi();
		//b2: tao cau lenh sql
		String sql= "select * from KhachHang where Username=? and Password=?";
		//b3: tao cau lenh
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		cmd.setString(1, tendn);
		cmd.setString(2, md5.ecrypt(pass));
		//b4: thuc hien cau lenh
		ResultSet rs= cmd.executeQuery();
		KhachHangBean kh = null;
		//b5: duyet rs de dua vao mang ds
		if(rs.next()) {
			Long MaKH=rs.getLong("MaKH");
			String HoTen=rs.getString("HoTen");
			String DiaChi=rs.getString("DiaChi");
			String Username=rs.getString("Username");
			String Password=rs.getString("Password");
			kh = new KhachHangBean(MaKH, HoTen, DiaChi, DiaChi, Username, Password);
		}
		rs.close();
		kn.cn.close();
		return kh;
	}
	public ArrayList<KhachHangBean> getKhachHang() throws Exception{
	ArrayList<KhachHangBean> ds = new ArrayList<KhachHangBean>();
	//b1: goi ket noi csdl
	KetNoi kn = new KetNoi();
	kn.ketNoi();
	//b2: tao cau lenh sql
	String sql= "select * from KhachHang";
	//b3: tao cau lenh
	PreparedStatement cmd= kn.cn.prepareStatement(sql);
	//b4: thuc hien cau lenh
	ResultSet rs= cmd.executeQuery();
	//b5: duyet rs de dua vao mang ds
	while(rs.next()) {
		Long MaKH=rs.getLong("MaKH");
		String HoTen=rs.getString("HoTen");
		String DiaChi=rs.getString("DiaChi");
		String Username=rs.getString("Username");
		String Password=md5.ecrypt(rs.getString("Password"));
		ds.add(new KhachHangBean(MaKH, HoTen, DiaChi, DiaChi, Username, Password));
	}
	rs.close();
	kn.cn.close();
	return ds;
}

public KhachHangBean kiemTraDangKy(String tendn) throws Exception{
	KhachHangBean kh = null;
	KetNoi kn = new KetNoi();
	kn.ketNoi();
	String sql = "select * from KhachHang where Username=?";
	PreparedStatement cmd = kn.cn.prepareStatement(sql);
	cmd.setString(1,tendn);
    ResultSet rs = cmd.executeQuery();
	if (rs.next()) {
		Long MaKH=rs.getLong("MaKH");
		String HoTen=rs.getString("HoTen");
		String DiaChi=rs.getString("DiaChi");
		String Username=rs.getString("Username");
		String Password=md5.ecrypt(rs.getString("Password"));
		kh = new KhachHangBean(MaKH, HoTen, DiaChi, DiaChi, Username, Password);
	}
	return kh;
}

public int Them(String hoten, String diachi, String sodt, String tendn, String pass) throws Exception{
	//B1: Ket noi vao csdl
 	KetNoi kn= new KetNoi();
 	kn.ketNoi();
     //B2: tao cau lenh sql
     String sql="insert into KhachHang(HoTen,DiaChi,SDT,Username,Password) values(?,?,?,?,?)";
     //b3: Tao cau lenh PreparedStatement
     PreparedStatement cmd= kn.cn.prepareStatement(sql);
     //b4: Truyen tham so
     cmd.setString(1,hoten);
     cmd.setString(2,diachi);
     cmd.setString(3, sodt);
     cmd.setString(4, tendn);
     cmd.setString(5, md5.ecrypt(pass));
     int kq=cmd.executeUpdate();//b5: Thuc hien cau lenh
     kn.cn.close();
     return kq;
}
}
