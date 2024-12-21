package iuh.fit.se.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iuh.fit.se.entities.DonHang;
import iuh.fit.se.repositories.DonHangRepository;
import iuh.fit.se.services.DonHangService;

@Service
public class DonHangServiceImpl implements DonHangService {
	@Autowired
	private DonHangRepository donHangRepository;

	@Override
	public List<DonHang> findAll() {
		// TODO Auto-generated method stub
		return donHangRepository.findAll();
	}

	@Override
	public List<DonHang> findByMaDHorTenCH(String maDH, String TenCH) {
		return donHangRepository.findByMaDHorTenCH(maDH, "%" + TenCH + "%");
	}

	@Override
	public DonHang save(DonHang donHang) {
		return donHangRepository.save(donHang);
	}

	@Override
	public void delete(int id) {
		if (findByID(id) != null && findByID(id).isTrangThai() == false)
			donHangRepository.deleteById(id);
	}

	@Override
	public DonHang update(int id, DonHang donHang) {
		return donHangRepository.save(donHang);
	}

	@Override
	public DonHang findByID(int id) {
		// TODO Auto-generated method stub
		return donHangRepository.findById(id).orElseThrow(null);
	}

}
