package bo;

import java.util.ArrayList;
import java.util.Date;

import bean.NSXBean;
import bean.SanPhamBean;
import dao.NSXDao;
import dao.SanPhamDao;

public class SanPhamBo {
	SanPhamDao spdao = new SanPhamDao();
	NSXDao sxdao = new NSXDao();
	ArrayList<SanPhamBean> ds;
	public ArrayList<SanPhamBean> getSanPham()throws Exception{
		ds = spdao.getSanPham();
		return ds;
	}
	
	public void CapNhatSoLuong(String msp, long sl)throws Exception{
		spdao.CapNhatSoLuong(msp, sl);
	}
	public void CapNhatSanPham(String msp, long sl, long gia)throws Exception{
		spdao.CapNhatSanPham(msp, sl, gia);
	}
	public int XoaSanPham(String msp) throws Exception {
		return spdao.XoaSanPham(msp);
	}
	
	public ArrayList<SanPhamBean> getSanPhamSLKhong()throws Exception{
		return spdao.getSanPhamSLKhong();
	}
	
	public ArrayList<SanPhamBean> getSanPhamNoiBat()throws Exception{
		return spdao.getSanPhamNoiBat();
	}
	
	public ArrayList<SanPhamBean> getSanPhamTheoLoai(String mloai)throws Exception{
		return spdao.getSanPhamTheoLoai(mloai);
	}
	
	public ArrayList<SanPhamBean> getSanPhamTheoNSX(String mnsx)throws Exception{
		return spdao.getSanPhamTheoNSX(mnsx);
	}
	
	
	public ArrayList<SanPhamBean> getSanPhamTimKiem(String key)throws Exception{
		return spdao.getSanPhamTimKiem(key);
	}
	
	//Phân trang
	public ArrayList<SanPhamBean> PhanTrang (int sotrang) throws Exception {
		return spdao.PhanTrang(sotrang);
	}
	
	public ArrayList<SanPhamBean> PhanTrangTheoLoai (int sotrang, String mloai) throws Exception {
		return spdao.PhanTrangTheoLoai(sotrang, mloai);
	}
	
	public ArrayList<SanPhamBean> PhanTrangTheoKey (int sotrang, String key) throws Exception {
		return spdao.PhanTrangTheoKey(sotrang, key);
	}
	
	public ArrayList<SanPhamBean> PhanTrangTheoNSX (int sotrang, String mnsx) throws Exception {
		return spdao.PhanTrangTheoNSX(sotrang, mnsx);
	}
	
	
	public ArrayList<NSXBean> getNSXTheoLoai(String mloai) throws Exception{
		return sxdao.getNSXTheoLoai(mloai);
	}
	
	public SanPhamBean kiemTraSanPhamBean(String masp) throws Exception {
		return spdao.kiemTraSanPhamBean(masp);
	}
	
	public int ThemSanPham(String masp, String ten, long gia, long soluong, String anh, String maloai, String mansx,
			long giagoc) throws Exception {
		return spdao.ThemSanPham(masp, ten, gia, soluong, anh, maloai, mansx, giagoc);
	}
	
}





	//Lấy ds theo mã loại
//	public ArrayList<SanPhamBean> getSanPhamTheoLoai(String mloai)throws Exception{
//		ArrayList<SanPhamBean> dsmloai = new ArrayList<SanPhamBean>();
//		for(SanPhamBean sp:ds) 
//			if(sp.getMaLoai().toLowerCase().equals(mloai.toLowerCase().trim()))
//				dsmloai.add(sp);
//		return dsmloai;
//	}
	
	//Tìm kiếm sản phẩm
//	public ArrayList<SanPhamBean> getSanPhamTimKiem(String key, ArrayList<SanPhamBean> ds)throws Exception{
//		ArrayList<SanPhamBean> dstim = new ArrayList<SanPhamBean>();
//		for(SanPhamBean sp:ds) 
//			if(sp.getTenSP().toLowerCase().contains(key.toLowerCase().trim()))
//				dstim.add(sp);
//		return dstim;
//	}


