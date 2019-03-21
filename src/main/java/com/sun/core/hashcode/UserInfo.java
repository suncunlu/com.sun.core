package com.sun.core.hashcode;

public class UserInfo {
	private int id;
	private String nickName;
	private String adress;
	
	public UserInfo(int id, String nickName, String adress) {
		super();
		this.id = id;
		this.nickName = nickName;
		this.adress = adress;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the nickName
	 */
	public String getNickName() {
		return nickName;
	}
	/**
	 * @param nickName the nickName to set
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	/**
	 * @return the adress
	 */
	public String getAdress() {
		return adress;
	}
	/**
	 * @param adress the adress to set
	 */
	public void setAdress(String adress) {
		this.adress = adress;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(getClass()!=obj.getClass()) {
			return false;
		}
		
		//接下来是业务判断
		UserInfo  user = (UserInfo)obj;
		//id相等即可
		if(this.id==user.id) {
			return true;
		}
		return false;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return id;
	}
}
