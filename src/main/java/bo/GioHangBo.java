package bo;

import java.util.ArrayList;

import bean.GioHangBean;

public class GioHangBo {
	//Viết hàm Them: thêm vào giỏ 1 mặt hàng: ds
		public ArrayList<GioHangBean> ds = new ArrayList<GioHangBean>();
		public void Them(String masp, String tensp, Long soluongmua, String gia, String anh, String giagoc,Long SoLuong) {
			int n=ds.size();
			//Nếu đã có trong giỏ hàng thì cập nhật lại số lượng mua
			for(int i=0; i<n; i++) {
				if(ds.get(i).getMaSP().toLowerCase().trim().equals(masp.toLowerCase().trim())) {
					//Cập nhật lại số lượng hàng
					long slm = ds.get(i).getSoLuongMua() + soluongmua;
					ds.get(i).setSoLuongMua(slm);
					String replacedStr = ds.get(i).getGia().replace(",","");
			        long g = Long.parseLong(replacedStr);
					long tt= slm*g;
					ds.get(i).setThanhTien(tt);
					return;
				}
			}
			// Ngược lại thêm mới vào giỏ hàng
			GioHangBean h = new GioHangBean(masp, tensp, soluongmua, gia, anh, giagoc,SoLuong);
			ds.add(h);
		}
		
		//Sửa số lượng mua
		public void SuaSLM(String ms, Long slm) {
			int n=ds.size();
			//Nếu đã có trong giỏ hàng thì cập nhật lại số lượng mua
			for(int i=0; i<n; i++) {
				if(ds.get(i).getMaSP().toLowerCase().trim().equals(ms.toLowerCase().trim())) {
					//Cập nhật lại số lượng hàng
					ds.get(i).setSoLuongMua(slm);
				}
			}
		}
		
		//viết hàm xóa 1 mặt hàng ra khỏi giỏ: xóa 1 phần tử trong ds, dựa vào mã sách
		public void Xoa(String ms) {
			int n=ds.size();
			for(int i=0; i<n; i++) {
				if(ds.get(i).getMaSP().toLowerCase().trim().equals(ms.toLowerCase().trim())) {
					ds.remove(i);
					return;
				}
			}
		}
		//tổng tiền
		public long Tongtien(){
			int n=ds.size();
			long s=0;
			for(int i=0;i<n;i++){
				s=s+ds.get(i).getThanhTien();
			}
			return s;
		}
}
