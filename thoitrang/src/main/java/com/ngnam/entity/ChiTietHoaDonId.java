package com.ngnam.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ChiTietHoaDonId implements Serializable{
	
	@Column(name="mahoadon")
	private int maHoaDon;
	
	@Column(name="machitietsanpham")
	private int maChiTietSanPham;
	
	// Các hàm khởi tạo 
	public ChiTietHoaDonId() { }

	// Các hàm getter và setter 
	public int getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(int maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public int getMaChiTietSanPham() {
		return maChiTietSanPham;
	}
	public void setMaChiTietSanPham(int maChiTietSanPham) {
		this.maChiTietSanPham = maChiTietSanPham;
	}
}
