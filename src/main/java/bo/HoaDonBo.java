package bo;

import dao.HoaDonDao;

public class HoaDonBo {
	HoaDonDao hddao = new HoaDonDao();
	public int Them(long makh) throws Exception{
		return hddao.Them(makh);
	}
	public long maxHD() throws Exception{
		return hddao.maxHD();
	}
}
