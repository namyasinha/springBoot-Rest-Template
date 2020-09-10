package com.producer_api.covid_statistics.model;

public class State {
	public String _id;
    public int active;
    public int cured;
    public int death;
    public int total;
    public String name;
    
    //constructor
    State(){}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public int getCured() {
		return cured;
	}
	public void setCured(int cured) {
		this.cured = cured;
	}
	public int getDeath() {
		return death;
	}
	public void setDeath(int death) {
		this.death = death;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
