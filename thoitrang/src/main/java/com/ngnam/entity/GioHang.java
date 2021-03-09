package com.ngnam.entity;

public class GioHang {
	
	private int maChiTietSanPham;
	private int maSanPham;
	private int maMau;
	private int maSize;
	private String tenSanPham;
	private String tenSize;
	private String tenMau;
	private String hinhSanPham;
	private String giaTien;
	private int soLuong;
	
	
	// Các hàm khởi tạo mặc định
	public GioHang() { }
	
	
	// Các hàm getter và setter
	public int getMaSanPham() {
		return maSanPham;
	}
	public void setMaSanPham(int maSanPham) {
		this.maSanPham = maSanPham;
	}
	public int getMaMau() {
		return maMau;
	}
	public void setMaMau(int maMau) {
		this.maMau = maMau;
	}
	public int getMaSize() {
		return maSize;
	}
	public void setMaSize(int maSize) {
		this.maSize = maSize;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}
	public String getGiaTien() {
		return giaTien;
	}
	public void setGiaTien(String giaTien) {
		this.giaTien = giaTien;
	}
	public String getTenSize() {
		return tenSize;
	}
	public void setTenSize(String tenSize) {
		this.tenSize = tenSize;
	}
	public String getTenMau() {
		return tenMau;
	}
	public void setTenMau(String tenMau) {
		this.tenMau = tenMau;
	}
	public String getHinhSanPham() {
		return hinhSanPham;
	}
	public void setHinhSanPham(String hinhSanPham) {
		this.hinhSanPham = hinhSanPham;
	}
	public int getMaChiTietSanPham() {
		return maChiTietSanPham;
	}
	public void setMaChiTietSanPham(int maChiTietSanPham) {
		this.maChiTietSanPham = maChiTietSanPham;
	}
}
