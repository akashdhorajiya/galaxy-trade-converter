package com.akash.merchant.guide.core;

import java.util.HashMap;
import java.util.Map;

public class InfoMaps {
	
	private Map<String, GalacticDigit> galacticDigitMap;
	
	private Map<String, Commodity> commodityMap;
	
	private static InfoMaps maps;
	
	private InfoMaps() {
		galacticDigitMap = new HashMap<>();
		commodityMap = new HashMap<>();
	}
	
	public static InfoMaps getInstance() {
		if(maps != null) {
			return maps;
		} else {
			return new InfoMaps();
		}
	}

	public Map<String, GalacticDigit> getGalacticDigitMap() {
		return galacticDigitMap;
	}

	public Map<String, Commodity> getCommodityMap() {
		return commodityMap;
	}
	
}
