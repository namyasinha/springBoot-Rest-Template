package com.covid_statistics.consumer_api.model;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class cases{
    public List<State> state;
    
    cases(){}
    public cases(List<State> state) {
    	this.state=state;
    }

	public List<State> getState() {
		return state;
	}

	public void setState(List<State> state) {
		this.state = state;
	}
	
	
}

