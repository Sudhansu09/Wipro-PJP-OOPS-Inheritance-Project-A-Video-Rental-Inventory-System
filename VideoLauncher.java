import java.util.Scanner;
class Video 
{
	String[] videoName = new String[100];
	boolean[] checkout = new boolean[100]; // by default all values of the array is false
	int[] rating = new int[100];
	
	Video(String name)
	{

	}
	
	public void setVideoName(int i, String name ) 		//set video name
	{
		videoName[i] = name;
	}
	public String getName(int i) 						// return Video name
	{
		return videoName[i];
	}
	
	public void doCheckout(int i) 						// set checkout
	{
		if(checkout[i] == false)
		{
			checkout[i] = true;
		}
	}
	
	public void doReturn(int i ) 						//set return
	{
		if(checkout[i] == true) 
		{
			checkout[i] = false;
		}
	}
	
	public void recieveRating(int i, int rate) 			//set rating 
	{
		rating[i] = rate;
	}
	
	public int getRating(int i) 						// return rating
	{
		return rating[i];
	}
	
	public boolean getCheckout(int i) 					// return checkout status
	{
		return checkout[i];
	}
}
class VideoStore extends Video 
{
	
	Video[] store;
	int i = 0;
	
	VideoStore(String name)
	{
		super(name);
	}
	
	void addVideo(String name) 									// to add video
	{
		setVideoName(i, name);
		++i;
	}
	
	void doCheckout(String name) 								// to do checkout
	{		
		int j,index=0;
		for(j = 0 ;j < i; j++)
		{
			if(videoName[j].equals(name))
			{
				index=j;
				break;
			}
		}
		
		if (i != j) 
		{
			doCheckout(index);
			System.out.println("Video "+'"'+name+'"'+" checked out successfuly.\n");
		}
		
		else
		{
			System.out.println("\nSorry this video is not present in the inventory \n");
		}
	}
	
	void doReturn(String name) 									// to do return
	{
		int j,index = 0;
		for(j = 0; j < i; j++)
		{
			if(videoName[j].equals(name))
			{
				index=j;
				break;
			}
		}
		if (i != j) 
		{
			doReturn(index);
			System.out.println("Video "+'"'+name+'"'+" returned successfuly\n");
		}
		else 
		{
			System.out.println("\nSorry this video is not present in the inventory \n");
		}
		
	}	
	
	void recieveRating(String name, int rating) 				// to recieve rating
	{
		int j, index = 0;
		for(j = 0; j < i; ++j) 
		{
			if(videoName[j].equals(name)) 
			{
				index = j;
				break;
			}
		}
		if (i != j) 
		{
			recieveRating(index, rating);
			System.out.println("Rating "+'"'+rating+'"'+" has been mapped to the Video "+'"'+name+'"'+".\n");
		}
		else 
		{
			System.out.println("\nSorry this video is not present in the inventory \n");
		}
	}
	
	void listInventory() 										// to display inventory
	{
		for (int j = 0; j < i ; j++) 
		{
			System.out.print(videoName[j] + "\t\t|");
			System.out.print("\t" + getCheckout(j) + "\t\t|");
			System.out.println("\t" + getRating(j));
			System.out.println();
		}
	}
}
public class VideoLauncher
{
	public static void main(String[] args)
	{
		VideoStore obj = new VideoStore("");
		boolean flag = true;
		int choice ;
		Scanner sc = new Scanner(System.in);
		
		while(flag)
		{
			System.out.println("MAIN MENU");
			System.out.println("=========");
			System.out.println("1. Add Videos: ");
			System.out.println("2. Check Out Video: ");
			System.out.println("3. Return Video: ");
			System.out.println("4. Recieve Rating: ");
			System.out.println("5. List Inventory: ");
			System.out.println("6. Exit: ");
			System.out.print("Enter your choice (1..6): ");
			choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice)
			{
				case 1:
					System.out.print("Enter the name of video you want to add: ");
					String str = sc.nextLine();
					obj.addVideo(str);
					System.out.println("Video "+'"' + str + '"'+" added successfuly.\n");
					break;
					
				case 2:
					System.out.print("Enter the name of the video you want to check out: ");
					String str2 = sc.nextLine();
					obj.doCheckout(str2);
					break;
					
				case 3:
					System.out.print("Enter the name of the video you want to return: ");
					String str3 = sc.nextLine();
					obj.doReturn(str3);
					break;
					
				case 4:
					System.out.print("Enter the name of the video you want to rate: ");
					String str4 = sc.nextLine();
					System.out.print("Enter the rating of this video: ");
					int rating = sc.nextInt();
					sc.nextLine();
					obj.recieveRating(str4, rating);
					break;
			
				case 5:
					System.out.println("------------------------------------------------------------------");
					System.out.print("Video Name\t|");
					System.out.print("\tCheckout Status\t|");
					System.out.println("\t Rating");
					System.out.println("");
					obj.listInventory();
					break;
					
				case 6:
					System.out.println("Exiting...!! Thanks for using the application.");
					System.exit(0);
					break;
					
				default:
					System.out.println("Wrong choice");		
			}
		}
	}
}