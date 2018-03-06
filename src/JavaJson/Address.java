package JavaJson;

/**   
 * @Title: 创建Address实体类的POJO
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Potter   
 * @date 2013-2-18 上午10:16:03
 * @version V1.0   
 */

public class Address {
	private String street;//街道
	private String city;//城市
	private int zip;//邮编
	private String tel;//第一个电话号码
	private String telTwo;//第二个电话号码

	public Address() {
	}

	public Address(String street, String city, int zip, String tel, String telTwo){
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.tel = tel;
		this.telTwo = telTwo;
	}
	
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getTelTwo() {
		return telTwo;
	}

	public void setTelTwo(String telTwo) {
		this.telTwo = telTwo;
	}
}

