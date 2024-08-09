package bo;

import java.util.ArrayList;

import bean.LichSuMuaHangBean;
import dao.LichSuMuaHangDao;

public class LichSuMuaHangBo {
	LichSuMuaHangDao lsdao = new LichSuMuaHangDao();
	public ArrayList<LichSuMuaHangBean> getLichSu(long mkh)throws Exception{
		return lsdao.getLichSu(mkh);
	}
	public ArrayList<LichSuMuaHangBean> PhanTrangLSMuaHang (int sotrang, long mkh)throws Exception {
		return lsdao.PhanTrangLSMuaHang(sotrang, mkh);
	}
}
