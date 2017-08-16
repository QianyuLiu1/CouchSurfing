
/*This class describes several attributes of house.
*
* @author Qianyu.liu
* @XJTLUID 1201502
* @version 1.0 2nd March 2015
 */

public class Houseinfor {

	public int housenumber;
	public String room_type;
	public String address;
	public int telephone;
	public int picturenumber;
	
    public Houseinfor(int housenumber, String room_type, String address, int telephone, int picturenumber){
    	this.housenumber=housenumber;
    	this.room_type=room_type;
    	this.address=address;
    	this.telephone=telephone;
    	this.picturenumber=picturenumber;
    	
    }
    public Houseinfor(){
    	this.housenumber=0;
    	this.room_type="";
    	this.address="";
    	this.telephone=0;
    	this.picturenumber=0;
    	
    }
    public int getHousenumber() {
		return housenumber;
	}

	public void setHousenumber(int housenumber) {
		this.housenumber = housenumber;
	}

	public String getRoom_type() {
		return room_type;
	}

	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public int getPicturenumber() {
		return picturenumber;
	}

	public void setPicturenumber(int picturenumber) {
		this.picturenumber = picturenumber;
	}

}
