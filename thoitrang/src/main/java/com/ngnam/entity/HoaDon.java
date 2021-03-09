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

@Entity(name="HOADON")
public class HoaDon {
	@Id
	@Column(name="mahoadon")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maHoaDon;
	
	@Column(name="tenkhachhang")
	private String tenKhachHang;
	
	@Column(name="sodienthoai")
	private String soDienThoai;
	
	@Column(name="diachigiaohang")
	private String diaChiGiaoHang;
	
	@Column(name="trangthai")
	private int trangThai;
	
	@Column(name="ngaylap")
	private String ngayLap;
	
	// Tạo liên kết 1-Nhiều với class ChiTietHoaDon
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="mahoadon")
	Set<ChiTietHoaDon> danhSachChiTietHoaDon;
	
	@Column(name="hinhthucgiaohang")
	private String hinhThucGiaoHang;
	
	@Column(name="ghichu")
	private String ghiChu;
	
	// Các hàm khởi tạo  
	public HoaDon() { }

	// Các hàm getter và setter
	public int getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(int maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public String getTenKhachHang() {
		return tenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getDiaChiGiaoHang() {
		return diaChiGiaoHang;
	}
	public void setDiaChiGiaoHang(String diaChiGiaoHang) {
		this.diaChiGiaoHang = diaChiGiaoHang;
	}
	public int getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}
	public String getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(String ngayLap) {
		this.ngayLap = ngayLap;
	}
	public Set<ChiTietHoaDon> getDanhSachChiTietHoaDon() {
		return danhSachChiTietHoaDon;
	}
	public void setDanhSachChiTietHoaDon(Set<ChiTietHoaDon> danhSachChiTietHoaDon) {
		this.danhSachChiTietHoaDon = danhSachChiTietHoaDon;
	}
	public String getHinhThucGiaoHang() {
		return hinhThucGiaoHang;
	}
	public void setHinhThucGiaoHang(String hinhThucGiaoHang) {
		this.hinhThucGiaoHang = hinhThucGiaoHang;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	} 
}
