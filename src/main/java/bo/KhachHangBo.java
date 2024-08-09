package bo;

import java.util.ArrayList;

import bean.KhachHangBean;
import bean.SanPhamBean;
import dao.KhachHangDao;

public class KhachHangBo {
	KhachHangDao khdao = new KhachHangDao();
	ArrayList<KhachHangBean> dskh;
	public KhachHangBean kiemTraDangNhap(String tendn, String pass) throws Exception{
		return khdao.kiemTraDangNhap(tendn, pass);
	}
	
	public ArrayList<KhachHangBean> getKhachHang() throws Exception{
		return khdao.getKhachHang();
	}
	//Đăng ký
	public KhachHangBean kiemTraDangKy(String tendn) throws Exception{
		return khdao.kiemTraDangKy(tendn);
	}
	
	public int Them(String hoten, String diachi, String sodt, String tendn, String pass) throws Exception{
		return khdao.Them(hoten, diachi, sodt, tendn, pass);
	}
}
