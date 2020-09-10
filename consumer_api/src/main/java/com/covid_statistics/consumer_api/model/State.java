package com.covid_statistics.consumer_api.model;

public class State {
	public String _id;
    public int active;
    public int cured;
    public int death;
    public int total;
    public String name;
    
    //constructor
    State(){}
    
	public State(String _id, int active, int cured, int death, int total, String name) {
		super();
		this._id = _id;
		this.active = active;
		this.cured = cured;
		this.death = death;
		this.total = total;
		this.name = name;
	}

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
