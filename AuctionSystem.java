public interface AuctionSystem extends java.rmi.Remote {

	public Object addItem(String name, float startPrice, float reservePrice) 
		throws java.rmi.RemoteException;

	public String auctionClose(String id) 
		throws java.rmi.RemoteException;

	public Item showDetailSeller(String id)	
		throws java.rmi.RemoteException;

	public String bidPrice(String id, float currentPrice, String cus, String phone)
		throws java.rmi.RemoteException;

	public Item showDetailCustomer(String id)	
		throws java.rmi.RemoteException;

	public String showAllItem(int i)
		throws java.rmi.RemoteException;

	public int getSize() 
		throws java.rmi.RemoteException;		

	/*public void getSizeHashMap() 
		throws java.rmi.RemoteException;

	public boolean sellerMode()
		throws java.rmi.RemoteException;

	public boolean customerMode()
		throws java.rmi.RemoteException;*/
}