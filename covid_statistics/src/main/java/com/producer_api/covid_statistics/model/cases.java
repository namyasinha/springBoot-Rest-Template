package com.producer_api.covid_statistics.model;


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

	public List<State> getState() {
		return state;
	}

	public void setState(List<State> state) {
		this.state = state;
	}
}

