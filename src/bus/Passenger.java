package bus;

import java.math.BigInteger;

public class Passenger {
	
	private Integer _id;
	private String _name;
	private BigInteger _mobile;
	
	public void setId(Integer id){
		_id = id;
	}
	
	public void setName(String name){
		_name = name;
	}
	
	public void setMobile(BigInteger mobile){
		_mobile = mobile;
	}
	
	
	public Integer getId(){
		return _id;
	}
	
	public String getName(){
		return _name;
	}
	
	public BigInteger getMobile(){
		return _mobile;
	}
	
}
