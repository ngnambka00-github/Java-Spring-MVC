package com.ngnam.entity;

public class SinhVien {
	int MSSV;
	String tenSinhVien;
	double diemTT;
	
	public SinhVien() { }
	
	public SinhVien(int MSSV, String tenSinhVien) {
		this.MSSV = MSSV;
		this.tenSinhVien = tenSinhVien;
	}
	
	public SinhVien(int MSSV, String tenSinhVien, double diemTT) {
		this.MSSV = MSSV;
		this.tenSinhVien = tenSinhVien;
		this.diemTT = diemTT;
	}
	
	public String getInfor() {
		return String.valueOf(this.MSSV) + " " + 
				this.tenSinhVien + " " + 
				String.valueOf(this.diemTT);
	}
	
	public SinhVien createSinhVien() {
		SinhVien sv = new SinhVien();
		sv.MSSV = 12;
		sv.tenSinhVien = "Nguyen Van Nam";
		sv.diemTT = 3.12;
		return sv;
	}
	
	public int getMSSV() {
		return MSSV;
	}

	public void setMSSV(int mSSV) {
		MSSV = mSSV;
	}

	public String getTenSinhVien() {
		return tenSinhVien;
	}

	public void setTenSinhVien(String tenSinhVien) {
		this.tenSinhVien = tenSinhVien;
	}

	public double getDiemTT() {
		return diemTT;
	}

	public void setDiemTT(double diemTT) {
		this.diemTT = diemTT;
	}
	
	public void start() {
		System.out.println("Hàm start");
	}
	
	public void end() {
		System.out.println("Hàm end");
	}
}
