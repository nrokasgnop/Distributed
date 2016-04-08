//package ActionSystemHashMap;

import java.util.HashMap;
import java.util.Scanner;

public class Seller extends java.rmi.server.UnicastRemoteObject implements AuctionSystem {
	
	Scanner input = new Scanner(System.in);
	public HashMap<String, Object> allItem = new HashMap<String, Object>();
	static int i = 0;

	String id;
	String itemName;
	float currentPrice = 0;
	float startPrice = 0;
	float reservePrice = 0;
	boolean isReserve  = false;
	String customerName = "";
	String customerPhone = "";
	int size = 0;

	public Seller() throws java.rmi.RemoteException {
		super();
	}
	
	public Object addItem(String itemName, float startPrice, float reservePrice) throws java.rmi.RemoteException {
		i++;
		size++;
		String id = "ItemID" + Integer.valueOf(i); 
		allItem.put(id, new Item(id, itemName, startPrice, reservePrice));
		Item item = (Item) allItem.get(id);
		//System.out.println("Add Item Success, Your ItemID: " + item.getId());
		//showDetail(id);
		return item.getId();
		

		//sellerMode();
	}
	
	public String auctionClose(String id) throws java.rmi.RemoteException {
		Item item = (Item) allItem.remove(id);
		if(item == null) {
			//System.out.println(id + " is empty");
			return id + " is empty";
		} else {
			//System.out.println("Remove " + id  + " Success");
			return "Remove " + id  + " Success"; 	
		}
		//sellerMode();
	}
	
	public Item showDetailSeller(String id) throws java.rmi.RemoteException {
		Item item = (Item) allItem.get(id);
		if(item != null) {
			//System.out.println(id + " is empty");
			return item;
		} /*else {
			return item;
			/*System.out.println("id: " + item.getId());
			System.out.println("Item Name: " + item.getItemName());
			System.out.println("Current Price: " + item.getCurrentPrice());
			System.out.println("Start Price: " + item.getStartPrice());
			System.out.println("Reserve Price: " + item.getReservePrice());
			System.out.println("Is Reserve: " + item.getIsReserve());
			System.out.println("Customer Name: " + item.getCustomerName());
			System.out.println("Customer Phone: " + item.getCustomerPhone());
		}*/
		return null;
		//sellerMode();	
	}

	public String bidPrice(String id, float currentPrice, String cus, String phone) throws java.rmi.RemoteException {
		Item item = (Item) allItem.get(id);
		if(item == null) {
			//System.out.println(id + " is empty");
			return id + " is empty";
		} else {
			item.setCurrentPrice(currentPrice);
			item.setCustomerName(cus);
			item.setCustomerPhone(phone);
			//System.out.println("Bid Success");
			return "Bid Success";
		}
		//customerMode();
	}

	public Item showDetailCustomer(String id) throws java.rmi.RemoteException {
		Item item = (Item) allItem.get(id);
		if(item != null) {
			return item;
			//System.out.println("-----------------------");
			//System.out.println(id + " is empty");
		} /*else {
			System.out.println("id: " + item.getId());
			System.out.println("Item Name: " + item.getItemName());
			System.out.println("Current Price: " + item.getCurrentPrice());
			System.out.println("Start Price: " + item.getStartPrice());
		}*/
		return null;
		//customerMode();
	}

	public String showAllItem(int i) throws java.rmi.RemoteException {
		//for(int i = 0; i < size; ++i) {
		Item item = (Item) allItem.get("ItemID" + (i + 1));
		if(item != null) {
				//System.out.println("id: " + item.getId());
				//System.out.println("Item Name: " + item.getItemName());
			return "id: " + item.getId() + " | Item Name: " + item.getItemName();
				//System.out.println("Current Price: " + item.getCurrentPrice());
				//System.out.println("Start Price: " + item.getStartPrice());
				//System.out.println("-----------------------");
				//System.out.println();
		}
		//}
		return null;	
		//customerMode();
			
	}

	public int getSize() {
		return size;
	}
	
	/*public void getSizeHashMap() throws java.rmi.RemoteException {
		System.out.println(seller.size());
	}*/

	/*public boolean sellerMode() throws java.rmi.RemoteException {
		int select = 0;
		System.out.println("-----------------------");
		System.out.println("[1]Add Item");
		System.out.println("[2]Auction Close Item");
		System.out.println("[3]Show Detials");
		System.out.println("[0]Back");
		System.out.print("Select: ");
		select = input.nextInt();
		if(select == 0) {
			//System.exit(0);
			return true;
			//System.out.println("-----------------------");
		}
		else if(select == 1) {
			System.out.println("-----------------------");
			System.out.print("Item Name: ");
			itemName = input.next();
			System.out.print("Start Price: ");
			startPrice = input.nextFloat();
			System.out.print("Reserve Price: ");
			reservePrice = input.nextFloat();
			System.out.println("-----------------------");
			addItem(itemName, startPrice, reservePrice);
		} else if(select == 2) {
			System.out.println("-----------------------");
			System.out.print("Enter ItemID: ");
			id = input.next();
			System.out.println("-----------------------");
			auctionClose(id);
		} else if(select == 3) {
			System.out.println("-----------------------");
			System.out.print("Enter ItemID: ");
			id = input.next();
			System.out.println("-----------------------");
			showDetailSeller(id);
		}
		return false;
	}

	public boolean customerMode() throws java.rmi.RemoteException {
		int select = 0;
		System.out.println("-----------------------");
		System.out.println("[1]Bid Price");
		System.out.println("[2]Show Detials");
		System.out.println("[3]Show All Item");
		System.out.println("[0]Back");
		System.out.print("Select : ");
		select = input.nextInt();
		System.out.println("-----------------------");
		if(select == 0) {
			return true;
		}
		else if(select == 1) {
			//System.out.println("-----------------------");
			System.out.print("Enter ItemID: ");
			id = input.next();
			System.out.print("Bid Price: ");
			currentPrice = input.nextInt();
			System.out.print("Your Name: ");
			customerName = input.next();
			System.out.print("Your Phone: ");
			customerPhone = input.next();
			bidPrice(id, currentPrice, customerName, customerPhone);
		} else if(select == 2) {
			//System.out.println("-----------------------");
			System.out.print("Enter ItemID: ");
			id = input.next();
			showDetailCustomer(id);
		} else if(select == 3) {
			showAllItem();
		}
		return false;
	}*/

}
