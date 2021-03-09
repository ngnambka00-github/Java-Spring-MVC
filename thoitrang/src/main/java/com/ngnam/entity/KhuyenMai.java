package com.ngnam.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name="MAKHUYENMAI")
public class KhuyenMai {
	@Id
	@Column(name="makhuyenmai")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maKhuyenMai;
	
	@Column(name="tenkhuyenmai")
	private String tenKhuyenMai;
	
	@Column(name="thoigianbatdau")
	private String thoiGianBatDau;
	
	@Column(name="thoigianketthuc")
	private String thoiGianKetThuc;
	
	@Column(name="mota")
	private String moTa;
	
	@Column(name="giagiam")
	private String giaGiam;
	
	@Column(name="hinhkhuyenmai")
	private String hinhKhuyenMai;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="CHITIETKHUYENMAI", 
		joinColumns = {
			@JoinColumn(name="makhuyenmai", referencedColumnName="makhuyenmai")
		}, 
		inverseJoinColumns = {
			@JoinColumn(name="masanpham", referencedColumnName="masanpham")
		}
	)
	Set<SanPham> danhSachSanPham;
	
	// Các hàm khởi tạo 
	public KhuyenMai() { }

	// Các hàm getter và setter 
	public int getMaKhuyenMai() {
		return maKhuyenMai;
	}
	public void setMaKhuyenMai(int maKhuyenMai) {
		this.maKhuyenMai = maKhuyenMai;
	}
	public String getTenKhuyenMai() {
		return tenKhuyenMai;
	}
	public void setTenKhuyenMai(String tenKhuyenMai) {
		this.tenKhuyenMai = tenKhuyenMai;
	}
	public String getThoiGianBatDau() {
		return thoiGianBatDau;
	}
	public void setThoiGianBatDau(String thoiGianBatDau) {
		this.thoiGianBatDau = thoiGianBatDau;
	}
	public String getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}
	public void setThoiGianKetThuc(String thoiGianKetThuc) {
		this.thoiGianKetThuc = thoiGianKetThuc;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public String getHinhKhuyenMai() {
		return hinhKhuyenMai;
	}
	public void setHinhKhuyenMai(String hinhKhuyenMai) {
		this.hinhKhuyenMai = hinhKhuyenMai;
	}
	public String getGiaGiam() {
		return giaGiam;
	}
	public void setGiaGiam(String giaGiam) {
		this.giaGiam = giaGiam;
	}
	public Set<SanPham> getDanhSachSanPham() {
		return danhSachSanPham;
	}
	public void setDanhSachSanPham(Set<SanPham> danhSachSanPham) {
		this.danhSachSanPham = danhSachSanPham;
	} 
}
