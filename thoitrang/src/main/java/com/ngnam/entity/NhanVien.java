package com.ngnam.entity;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class NhanVien {
	String tenNhanVien;
	String diaChi;
	int tuoi;
	GiamDoc doc;
	

	public GiamDoc getDoc() {
		return doc;
	}

	public void setDoc(GiamDoc doc) {
		this.doc = doc;
	}

	public NhanVien() { }
	
	public NhanVien(GiamDoc doc) {
		this.doc = doc;
	}
	
	public NhanVien(String tenNhanVien, String diaChi) {
		this.tenNhanVien = tenNhanVien;
		this.diaChi = diaChi;
	}
	
	public NhanVien(String tenNhanVien, String diaChi, int tuoi) {
		this.tenNhanVien = tenNhanVien;
		this.diaChi = diaChi;
		this.tuoi = tuoi;
	}
	
	
	public void getThongBao() {
		System.out.println("Hello " + this.tenNhanVien);
	}
	
	public String getTenNhanVien() {
		return this.tenNhanVien;
	}
	
	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}
	
	public String getDiaChi() {
		return this.diaChi;
	}
	
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
		
	public int getTuoi() {
		return this.tuoi;
	}
	
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
}
