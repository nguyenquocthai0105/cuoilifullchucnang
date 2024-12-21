package iuh.fit.se.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "donhang")
@Data
public class DonHang {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String maDonHang;
	
	@NotEmpty(message = "Tên khách hàng không được để trống!!")
	@Size(max = 50, min = 5, message = "Tên khách hàng không được quá 50 kí tự!!")
	private String tenKhachHang;
	
	@Email(message = "Email phải đúng định dạng!!")
	@NotEmpty(message = "Email không được để trống!!")
	private String email;
	
	@Future(message = "Ngày phải lớn hơn ngày hiện tại!!")
	private LocalDate ngayDatHang;
	
	@NotEmpty(message = "Tên sản phẩm không được để trống!!")
	private String tenSp;
	
	private boolean trangThai;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "maCHF")
	private CuaHang cuaHang;

	@PrePersist
	private void genMDH() {
		if (this.maDonHang == null || this.maDonHang.isEmpty()) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
			this.maDonHang = LocalDateTime.now().format(formatter);
		}
	}
}
