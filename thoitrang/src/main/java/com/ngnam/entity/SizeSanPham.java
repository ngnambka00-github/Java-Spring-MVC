package com.ngnam.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="SIZESANPHAM")
public class SizeSanPham {
	@Id
	@Column(name="masize")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maSize;
	
	@Column(name="tensize")
	private String tenSize;
	
	@Column(name="kyhieu")
	private String kyHieu;
	
	// Các hàm khởi tạo
	public SizeSanPham() { }

	// Các hàm getter và setter 
	public int getMaSize() {
		return maSize;
	}
	public void setMaSize(int maSize) {
		this.maSize = maSize;
	}
	public String getTenSize() {
		return tenSize;
	}
	public void setTenSize(String tenSize) {
		this.tenSize = tenSize;
	}
	public String getKyHieu() {
		return this.kyHieu;
	}
	public void setKyHieu(String kyHieu) {
		this.kyHieu = kyHieu;
	}
}
