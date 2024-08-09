package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.NSXBean;

public class NSXDao {
	public ArrayList<NSXBean> getNSX() throws Exception{
		ArrayList<NSXBean> ds = new ArrayList<NSXBean>();
		//b1: goi ket noi csdl
		KetNoi kn = new KetNoi();
		kn.ketNoi();
		//b2: tao cau lenh sql
		String sql= "select * from NSX";
		//b3: tao cau lenh
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		//b4: thuc hien cau lenh
		ResultSet rs= cmd.executeQuery();
		//b5: duyet rs de dua vao mang ds
		while(rs.next()) {
			String MaNSX=rs.getString("MaNSX");
			String TenNSX=rs.getString("TenNSX");
			ds.add(new NSXBean(MaNSX, TenNSX));
		}
		rs.close();
		kn.cn.close();
		return ds;
	}
	
	public NSXBean timNSX(String ma) throws Exception{
		NSXBean n = null;
		//b1: goi ket noi csdl
		KetNoi kn = new KetNoi();
		kn.ketNoi();
		//b2: tao cau lenh sql
		String sql= "select * from NSX where MaNSX = ?";
		//b3: tao cau lenh
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		cmd.setString(1, ma);
		//b4: thuc hien cau lenh
		ResultSet rs= cmd.executeQuery();
		//b5: duyet rs de dua vao mang ds
		if(rs.next()) {
			String MaNSX=rs.getString("MaNSX");
			String TenNSX=rs.getString("TenNSX");
			n = new NSXBean(MaNSX, TenNSX);
		}
		rs.close();
		kn.cn.close();
		return n;
	}
	
	public ArrayList<NSXBean> getNSXTheoLoai(String mloai) throws Exception{
		ArrayList<NSXBean> ds = new ArrayList<NSXBean>();
		//b1: goi ket noi csdl
		KetNoi kn = new KetNoi();
		kn.ketNoi();
		//b2: tao cau lenh sql
		String sql= "select * from dbo.func_GetNSXTheoLoai(?)";
		//b3: tao cau lenh
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		cmd.setString(1, mloai);
		//b4: thuc hien cau lenh
		ResultSet rs= cmd.executeQuery();
		//b5: duyet rs de dua vao mang ds
		while(rs.next()) {
			String MaNSX=rs.getString("MaNSX");
			String TenNSX=rs.getString("TenNSX");
			ds.add(new NSXBean(MaNSX, TenNSX));
		}
		rs.close();
		kn.cn.close();
		return ds;
	}
	
}
