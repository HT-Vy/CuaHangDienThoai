package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import bean.LoaiBean;

public class LoaiDao {
	public ArrayList<LoaiBean> getLoai() throws Exception{
		ArrayList<LoaiBean> ds = new ArrayList<LoaiBean>();
		//b1: goi ket noi csdl
		KetNoi kn = new KetNoi();
		kn.ketNoi();
		//b2: tao cau lenh sql
		String sql= "select * from loai";
		//b3: tao cau lenh
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		//b4: thuc hien cau lenh
		ResultSet rs= cmd.executeQuery();
		//b5: duyet rs de dua vao mang ds
		while(rs.next()) {
			String MaLoai=rs.getString("MaLoai");
			String TenLoai=rs.getString("TenLoai");
			String AnhLoai=rs.getString("AnhLoai");
			ds.add(new LoaiBean(MaLoai, TenLoai,AnhLoai));
		}
		rs.close();
		kn.cn.close();
		return ds;
	}
	public LoaiBean timLoai(String ml)throws Exception{
		LoaiBean l = null;
		KetNoi kn = new KetNoi();
		kn.ketNoi();
		//b2: tao cau lenh sql
		String sql= "select * from loai where MaLoai = ?";
		//b3: tao cau lenh
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		cmd.setString(1, ml);
		ResultSet rs= cmd.executeQuery();
		if(rs.next()) {
			String MaLoai=rs.getString("MaLoai");
			String TenLoai=rs.getString("TenLoai");
			String AnhLoai=rs.getString("AnhLoai");
			l = new LoaiBean(MaLoai, TenLoai, AnhLoai);
		}
		return l;
	}
}


