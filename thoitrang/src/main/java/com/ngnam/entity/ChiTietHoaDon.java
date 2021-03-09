package com.ngnam.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity(name="CHITIETHOADON")
public class ChiTietHoaDon {
	@EmbeddedId 
	private ChiTietHoaDonId chiTietHoaDonId;
	
	@Column(name="soluong")
	private int soLuong;
	
	@Column(name="giatien")
	private String giaTien;
	
	// Các hàm khởi tạo
	public ChiTietHoaDon() { }
	

	// Các hàm getter và setter
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public String getGiaTien() {
		return giaTien;
	}
	public void setGiaTien(String giaTien) {
		this.giaTien = giaTien;
	}
	public ChiTietHoaDonId getChiTietHoaDonId() {
		return chiTietHoaDonId;
	}
	public void setChiTietHoaDonId(ChiTietHoaDonId chiTietHoaDonId) {
		this.chiTietHoaDonId = chiTietHoaDonId;
	} 
}
