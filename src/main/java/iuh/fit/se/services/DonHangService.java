package iuh.fit.se.services;

import java.util.List;

import iuh.fit.se.entities.DonHang;

public interface DonHangService {
	List<DonHang> findAll();

	List<DonHang> findByMaDHorTenCH(String maDH, String TenCH);

	DonHang save(DonHang donHang);

	void delete(int id);

	DonHang update(int id, DonHang donHang);
	
	DonHang findByID(int id);
}
