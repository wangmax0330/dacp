/**
 * 
 */
package com.pikai.data;


/**
 * 用户内外部标识
 * @author Andy
 *
 */
public enum ActiveType{
	DISABLE("DISABLE","失效的"),
	ENABLE("ENABLE","有效的");

	private String key;
	private String description;
	private ActiveType(String key,String description){
		this.key = key;
		this.description = description;
	}
	public String getKey(){
		return key;
	}
	public String getDescription() {
		return description;
	}
	
}
