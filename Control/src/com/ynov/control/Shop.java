package com.ynov.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shop {
	
	private Map<String,Integer> items;
	
	public Shop()
	{
		items=new HashMap<>();
	}
	
	public void addItemToShop(String name, Integer prix)
	{
		this.items.put(name, prix);
	}
	
	public List<String> getItemsCheaperThan(int maxPrice)
	{
		List<String> ret=new ArrayList<>();
		
		for(String name: items.keySet())
		{
			if(items.get(name)<maxPrice)
				ret.add(name);
		}
		
		return ret;
	}

}
