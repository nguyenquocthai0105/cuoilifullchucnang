package iuh.fit.se.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import iuh.fit.se.entities.DonHang;

@Repository
public interface DonHangRepository extends JpaRepository<DonHang, Integer> {
	@Query(value = "SELECT * FROM donhang WHERE machf IN (SELECT id FROM cuahang WHERE ten LIKE :tenCH) and ma_don_hang like :maDH", nativeQuery = true)
	List<DonHang> findByMaDHorTenCH(@Param("maDH") String maDH, @Param("tenCH") String tenCH);
}
