package com.example.entiy;

public class DecorateViotation {

	private int viotation_id;
	private String viotation_detail;
	private int fine;
	private int deduct;
	private String punish_id;
	private String viotation_date;
	private String car_no;
	private String viotation_place;
	private String punish_flag;

	public int getViotation_id() {
		return viotation_id;
	}

	public void setViotation_id(int viotation_id) {
		this.viotation_id = viotation_id;
	}

	public String getViotation_detail() {
		return viotation_detail;
	}

	public void setViotation_detail(String viotation_detail) {
		this.viotation_detail = viotation_detail;
	}

	public int getFine() {
		return fine;
	}

	public void setFine(int fine) {
		this.fine = fine;
	}

	public int getDeduct() {
		return deduct;
	}

	public void setDeduct(int deduct) {
		this.deduct = deduct;
	}

	public String getPunish_id() {
		return punish_id;
	}

	public void setPunish_id(String punish_id) {
		this.punish_id = punish_id;
	}

	public String getViotation_date() {
		return viotation_date;
	}

	public void setViotation_date(String viotation_date) {
		this.viotation_date = viotation_date;
	}

	public String getCar_no() {
		return car_no;
	}

	public void setCar_no(String car_no) {
		this.car_no = car_no;
	}

	public String getViotation_place() {
		return viotation_place;
	}

	public void setViotation_place(String viotation_place) {
		this.viotation_place = viotation_place;
	}

	public String getPunish_flag() {
		return punish_flag;
	}

	public void setPunish_flag(String punish_flag) {
		this.punish_flag = punish_flag;
	}

	@Override
	public String toString() {
		return "DecorateViotation [viotation_id=" + viotation_id + ", viotation_detail=" + viotation_detail + ", fine="
				+ fine + ", deduct=" + deduct + ", punish_id=" + punish_id + ", viotation_date=" + viotation_date
				+ ", car_no=" + car_no + ", viotation_place=" + viotation_place + ", punish_flag=" + punish_flag + "]";
	}
	
	

}
