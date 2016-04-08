import java.rmi.Naming;			//Import the rmi naming - so you can lookup remote object
import java.rmi.RemoteException;	//Import the RemoteException class so you can catch it
import java.net.MalformedURLException;	//Import the MalformedURLException class so you can catch it
import java.rmi.NotBoundException;	//Import the NotBoundException class so you can catch it
import java.util.Scanner;

public class CustomerClient {

  

    public static void main(String[] args) {
        
	try {

	    // Create the reference to the remote object through the remiregistry			
            AuctionSystem auction = (AuctionSystem)
                           Naming.lookup("rmi://localhost/AuctionService");
            
	    // Now use the reference c to call remote methods
            String id;
            String itemName;
            float currentPrice = 0;
            String customerName = "";
            String customerPhone = "";

            float startPrice = 0;
            float reservePrice = 0;

        	Seller s = new Seller();
            Scanner input = new Scanner(System.in);
            int select = 0;
            for(;;) {
                System.out.println("-----------------------");
                System.out.println("[1]Bid Price");
                System.out.println("[2]Show Detials");
                System.out.println("[3]Show All Item");
                System.out.println("[0]Back");
                System.out.print("Select : ");
                select = input.nextInt();
                System.out.println("-----------------------");
                if(select == 0) {
                    //return true;
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
                    System.out.println(auction.bidPrice(id, currentPrice, customerName, customerPhone));
                } else if(select == 2) {
                    //System.out.println("-----------------------");
                    System.out.print("Enter ItemID: ");
                    id = input.next();
                    Item item = auction.showDetailCustomer(id);
                    if(item != null) {
                        System.out.println("id: " + item.getId());
                        System.out.println("Item Name: " + item.getItemName());
                        System.out.println("Current Price: " + item.getCurrentPrice());
                        System.out.println("Start Price: " + item.getStartPrice());
                        System.out.println("Reserve Price: " + item.getReservePrice());
                        System.out.println("Is Reserve: " + item.getIsReserve());
                        System.out.println("Customer Name: " + item.getCustomerName());
                        System.out.println("Customer Phone: " + item.getCustomerPhone());     
                    } else {
                        System.out.println("Item is empty");
                    }
                } else if(select == 3) {
                    int size = auction.getSize();
                    for(int i = 0; i < size; ++i) {
                        System.out.println(auction.showAllItem(i));    
                    }
                    
                } else {
                    System.out.println("-----------------------");
                    System.out.print("Item Name: ");
                    itemName = input.next();
                    System.out.print("Start Price: ");
                    startPrice = input.nextFloat();
                    System.out.print("Reserve Price: ");
                    reservePrice = input.nextFloat();
                    System.out.println("-----------------------");
                    auction.addItem(itemName, startPrice, reservePrice);
                }
            }
            
        }
        // Catch the exceptions that may occur - rubbish URL, Remote exception
	// Not bound exception or the arithmetic exception that may occur in 
	// one of the methods creates an arithmetic error (e.g. divide by zero)
	catch (MalformedURLException murle) {
            System.out.println();
            System.out.println("MalformedURLException");
            System.out.println(murle);
        }
        catch (RemoteException re) {
            System.out.println();
            System.out.println("RemoteException");
            System.out.println(re);
        }
        catch (NotBoundException nbe) {
            System.out.println();
            System.out.println("NotBoundException");
            System.out.println(nbe);
        }
        catch (java.lang.ArithmeticException ae) {
            System.out.println();
            System.out.println("java.lang.ArithmeticException");
            System.out.println(ae);
        }
    }
}