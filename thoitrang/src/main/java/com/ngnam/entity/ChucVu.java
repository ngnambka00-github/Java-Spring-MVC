package com.ngnam.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name="CHUCVU")
public class ChucVu {
	@Id
	@Column(name="machucvu")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maChucVu;
	
	@Column(name="tenchucvu")
	private String tenChucVu;
	
	// Tạo liên kết 1 nhiều với Class NhanVien
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="machucvu")
	Set<NhanVien> danhSachNhanVien;
	
	// Hàm khởi tạo 
	public ChucVu() { }
	
	// Các hàm getter và setter
	public int getMaChucVu() {
		return maChucVu;
	}

	public void setMaChucVu(int maChucVu) {
		this.maChucVu = maChucVu;
	}

	public String getTenChucVu() {
		return tenChucVu;
	}

	public void setTenChucVu(String tenChucVu) {
		this.tenChucVu = tenChucVu;
	}

	public Set<NhanVien> getDanhSachNhanVien() {
		return danhSachNhanVien;
	}
	public void setDanhSachNhanVien(Set<NhanVien> danhSachNhanVien) {
		this.danhSachNhanVien = danhSachNhanVien;
	}
}
