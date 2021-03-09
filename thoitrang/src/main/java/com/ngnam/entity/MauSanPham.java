package com.ngnam.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="MAUSANPHAM")
public class MauSanPham {
	@Id
	@Column(name="mamau")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maMau;
	
	@Column(name="tenmau")
	private String tenMau;
	
	// Các hàm khởi tạo
	public MauSanPham() { }

	// Các hàm khởi tạo mặc định 
	public int getMaMau() {
		return maMau;
	}
	public void setMaMau(int maMau) {
		this.maMau = maMau;
	}
	public String getTenMau() {
		return tenMau;
	}
	public void setTenMau(String tenMau) {
		this.tenMau = tenMau;
	} 
}
