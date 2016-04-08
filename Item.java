//package ActionSystemHashMap;


public class Item implements java.io.Serializable {
	
	String id = "";
	String itemName;
	float currentPrice = 0;
	float startPrice = 0;
	float reservePrice = 0;
	boolean isReserve  = false;
	String customerName = "null";
	String customerPhone = "null";
	
	public Item() {
		
	}
	
	public Item(String id, String name, float startPrice, float reservePrice) {
		this.id = id;
		this.itemName = name;
		this.currentPrice = startPrice;
		this.startPrice = startPrice;
		this.reservePrice = reservePrice;
		this.isReserve = isReserve;
	}
	
	public String getId() {
		return id;
	}
	
	
	public void setItemName(String name) {
		this.itemName = name;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public void setCurrentPrice(float currentPrice) {
		this.currentPrice = currentPrice;
	}
	
	public float getCurrentPrice() {
		return currentPrice;
	}
	
	public void setStartPrice(float startPrice) {
		this.startPrice = startPrice;
	}
	
	public float getStartPrice() {
		return startPrice;
	}
	
	public void setReservePrice(float reservePrice) {
		this.reservePrice = reservePrice;
	}
	
	public float getReservePrice() {
		return reservePrice;
	}
	
	public boolean getIsReserve() {
		if(currentPrice >= reservePrice) {
			return true;
		}
		return false;
	}
	
	public void setCustomerName(String cus) {
		this.customerName = cus;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerPhone(String phone) {
		this.customerPhone = phone;
	}
	
	public String getCustomerPhone() {
		return customerPhone;
	}
	
	
}
