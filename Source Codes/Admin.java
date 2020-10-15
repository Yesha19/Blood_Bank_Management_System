package BloodBankManagment;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Scanner;

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ADMIN CLASS ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`
/*
 * Contains Attributes: NAME, ADMIN ID, PASSWORD, CONTACT, ALIST (Admin Linked List)
 * 
 * Contains Functions: 
 * 1. CONSTRUCTORS - initialize Alist with the objects stored in the file 'AdminDetails.txt'
 * 2. inputAdmin() - Inputting the details of Admin and storing it into alist and txt file
 * 3. adminCheck() - To check whether the admin's id and password matches or not
 * 4. sortDonor() - Sorting the list of donor and placing it back to file
 * 5. sortPurchaser() - Sorting the list of purchaser and placing it back to file
 * 6. changeContact() and changePassword() - updating the 3 lists- ulist, dlist and plist and placing them back into their respective files
 * 7. searchDonor() and searchPurchaser() - searching the donor and purchaser list by different attributes
 * 8. deleteUser() - deleting the records of the user when requested, from all the lists and placing the lists into the file
 * 
 *///~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


public class Admin implements Serializable
{
	String name;
	String admin_id; 
	String password;
	long contactno;
	LinkedList<Admin> alist;
	private static final long serialVersionUID= -5213779209317179023L;
	
	//DEFAULT  CONSTRUCTOR
	public Admin() throws IOException, ClassNotFoundException
	{
		alist = new LinkedList<>();
		
		//checking whether file exists or not
		File f1 = new File("C:\\Users\\Dell\\eclipse-workspace\\DSA LAB\\bin\\code2\\AdminDetails.txt");
		if(f1.exists())
		{
			//opening the file in reading mode
			
		   FileInputStream f = new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\DSA LAB\\bin\\code2\\AdminDetails.txt");
		   BufferedInputStream bis = new BufferedInputStream(f);
		   bis.mark(0);
		   bis.reset();
		   ObjectInputStream o = new ObjectInputStream(bis);
	       
		   
		   //reading each object from the file and inserting it in the linked list
		   
	       Admin c1 = null;
	       while(bis.available()>0)
	       {
	    	   c1=(Admin) o.readObject();
	    	   alist.insert(c1);
	       }
	       
	       o.close();
	       bis.close();
		}    
	}
	
	//PARAMETERIZED  CONSTRUCTOR
	public Admin(String name , long contactno, String admin_id,String password)
	{
	    this.name = name;
	    this.contactno = contactno;
	    this.admin_id = admin_id;
	    this.password = password;
	}
	
	
	//TAKING INPUT OF  ADMIN DETAILS
	
	public void inputAdmin() throws IOException
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Name:");
		name = sc.next();
		System.out.println("Enter contactno:");
		contactno = sc.nextLong();
		System.out.println("Enter user ID:");
		admin_id = sc.next();
		System.out.println("Enter password:");
		password = sc.next();
		
		alist.insert(new Admin(name,contactno,admin_id,password));
		
		//Opening the file in writing mode and inserting new Admin object in the file
		
		FileOutputStream f = new FileOutputStream("C:\\Users\\Dell\\eclipse-workspace\\DSA LAB\\bin\\code2\\AdminDetails.txt");
		ObjectOutputStream o = new ObjectOutputStream(f);
		
		Node<Admin> pos = alist.getFirst();
		while(pos!=null)
		{
			o.writeObject(pos.getData());
			pos = pos.getNext();
		}
		
		o.close();
	    f.close();
		
		FileWriter fw = new FileWriter("C:\\Users\\Dell\\eclipse-workspace\\DSA LAB\\bin\\code2\\Admin.txt",true);
		PrintWriter w = new PrintWriter(fw);
		
		w.write(admin_id + " " + password);
		w.println();
		
		w.close();
		fw.close();
	}
	
	
	
	//CHECKING WHETHER ID AND PASSWORD MATCHES WITH THE INPUT FIELDS
	
	public int adminCheck(String id,String pass) throws IOException
	{
		String h;
		String[] w;
		int temp = 0;
		
		FileInputStream f = new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\DSA LAB\\bin\\code2\\Admin.txt");
		InputStreamReader fin = new InputStreamReader(f);
		BufferedReader din  = new BufferedReader(fin);
		
		//Reading each line from the file and checking whether id and password matches or not
		while((h=din.readLine())!=null)
		{
			w = h.split("\\s");
			if(w[0].equals(id) && w[1].equals(pass))
			{
				System.out.println("\n \n~~~~~~~~~~~~~  You are logged in! ~~~~~~~~~~~~~~~~");
				System.out.println("Hello " + id + "\n\n");
				temp = 1;
				break;
			}
		}
		
		din.close();
		fin.close();
		f.close();
		
		return temp;
	}
	
	
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  SORTING OPERATIONS ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	//Sorting Donor list
	
	public void sortDonor(Donor d) throws IOException
	{
		MyArrayList<String> al = new MyArrayList<>();
		
		//storing first node of dlist in pos and adding names of donors in the arraylist
		
		Node<Donor> pos = d.dlist.getFirst();
		while(pos!=null)
		{
			al.add(pos.getData().name);
			pos = pos.getNext();
		}
		 	
		//calling merge sort on arraylist
		
    	mergeSort(al.myArrayList,al.currentIndex);
    	
    	//Adding the objects of donor in dlist in sequence of the sorted names (i.e. arraylist)
    	
    	LinkedList<Donor> list = d.dlist;
		d.dlist = new LinkedList<>();
    	
    	for(int i=0;i<al.currentIndex;i++)
    	{
	    	Node<Donor> pos1 = list.getFirst();
			while(pos1!=null)
			{
				if(al.myArrayList[i].equals(pos1.getData().name))
					d.dlist.insert(pos1.getData());
				pos1 = pos1.getNext();
			}
    	}
	    
    	//storing contents of list into file
    	d.dlistToFile();
	}
	
	public void sortPurchaser(Purchaser p) throws ClassNotFoundException, IOException
	{
		MyArrayList<String> al = new MyArrayList<>();
		
		//storing first node of dlist in pos and adding names of donors in the arraylist
		
		Node<Purchaser> pos = p.plist.getFirst();
		while(pos!=null)
		{
			al.add(pos.getData().name);
			pos = pos.getNext();
		}
		
		//calling merge sort on arraylist
		
		mergeSort(al.myArrayList,al.currentIndex);
		
		
		//Adding the objects of donor in dlist in sequence of the sorted names (i.e. arraylist)
		
		LinkedList<Purchaser> list = p.plist;
		p.plist = new LinkedList<>();
		
		for(int i=0;i<al.currentIndex;i++)
		{
	    	Node<Purchaser> pos1 = list.getFirst();
			while(pos1!=null)
			{
				if(al.myArrayList[i].equals(pos1.getData().name))
					p.plist.insert(pos1.getData());
				pos1 = pos1.getNext();
			}
		}
		
		p.plistToFile();
	}
	
	public static void mergeSort(Object[] myArrayList, int n) 
	{
        if (n >= 2) 
        {
            String[] left = new String[n / 2];
            String[] right = new String[n - n / 2];

            for (int i = 0; i < left.length; i++) 
            {
                left[i] = (String) myArrayList[i];
            }

            for (int i = 0; i < right.length; i++) 
            {
                right[i] = (String) myArrayList[i + n / 2];
            }

            mergeSort(left, left.length);
            mergeSort(right, right.length);
            merge(myArrayList, left, right,n);
        }
    }

    public static void merge(Object[] myArrayList, String[] left, String[] right,int n) 
    {
        int a = 0;
        int b = 0;
        for (int i = 0; i < n; i++)
        {
            if (b >= right.length || (a < left.length && left[a].compareToIgnoreCase(right[b]) < 0)) 
            {
                myArrayList[i] = left[a];
                a++;
            }
            else
            {
                myArrayList[i] = right[b];
                b++;
            }
        }
    }
	
    
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ UPDATION   OPERATION ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`
    
	public void changeContact(String id,String pass,long newno,User u,Donor d,Purchaser p) throws IOException, ClassNotFoundException
	{
		//change in Users Linked List - ulist
		
		Node<User> pos = u.ulist.getFirst();
		while(pos!=null)
		{
			if(pos.getData().user_id.equals(id) && pos.getData().password.equals(pass))
			{
				pos.getData().contactno = newno;
			}
			pos = pos.getNext();
		}
		u.ulistToFile();
		
		
		//change in Donors Liked list - dlist
		
		Node<Donor> pos1 = d.dlist.getFirst();
		while(pos1!=null)
		{
			if(pos1.getData().user_id.equals(id) && pos1.getData().password.equals(pass))
			{
				pos1.getData().contactno = newno;
			}
			pos1 = pos1.getNext();
		}
		d.dlistToFile();
		
		
		//change in Purchasers Linked List - plist
		
		Node<Purchaser> pos11 = p.plist.getFirst();
		while(pos11!=null)
		{
			if(pos11.getData().user_id.equals(id) && pos11.getData().password.equals(pass))
			{
				pos11.getData().contactno = newno;
			}
			pos11 = pos11.getNext();
		}
		p.plistToFile();
		
		System.out.println("\nCONTACT CHANGED SUCCESSFULLY!");
	}
	
	public void changePassword(String id,String pass,String newpass,User u,Donor d,Purchaser p) throws IOException, ClassNotFoundException
	{
		//change in Donors Liked list - dlist
		
	    Node<Donor> pos = d.dlist.getFirst();
		while(pos!=null)
		{
			if(pos.getData().user_id.equals(id) && pos.getData().password.equals(pass))
			{
				pos.getData().password = newpass;
			}
			
			pos = pos.getNext();
		}
		d.dlistToFile();
			
		//change in Purchasers Linked List - plist
		
		Node<Purchaser> pos1 = p.plist.getFirst();
		while(pos1!=null)
		{
			if(pos1.getData().user_id.equals(id) && pos1.getData().password.equals(pass))
			{
				pos1.getData().password = newpass;
			}
			
			pos1 = pos1.getNext();
		}
		p.plistToFile();
		
		//change in Users Linked List - ulist
		
		Node<User> pos11 = u.ulist.getFirst();
		while(pos11!=null)
		{
			if(pos11.getData().user_id.equals(id) && pos11.getData().password.equals(pass))
			{
				pos11.getData().password = newpass;
			}
			
			pos11 = pos11.getNext();
		}
		u.ulistToFile();
		
		
		//Change of password field in Users.txt file
		
		String h,oldtext="",aftertext="";
		String[] w = new String[10];
		
		//opening file in reading mode
		
		FileInputStream f = new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\DSA LAB\\bin\\code2\\Users.txt");
		InputStreamReader fin = new InputStreamReader(f);
		BufferedReader din  = new BufferedReader(fin);
		
		//storing the content of the file which appears before that id and password, in oldtext
		
		while((h=din.readLine())!=null)
		{
			w = h.split("\\s");
			if(w[0].equals(id) && w[1].equals(pass))
				break;
			
			else
				oldtext = oldtext + h + "\n";
		}
		
		
		//storing the content of the file which appears after that id and password, in aftertext
		
		while((h=din.readLine())!=null)
		{
			aftertext = aftertext + h + "\n";
		}
		
		//closing the file
		din.close();
		fin.close();
		f.close();
		
		//opening file in writing mode
		
		FileWriter fw2 = new FileWriter("C:\\Users\\Dell\\eclipse-workspace\\DSA LAB\\bin\\code2\\Users.txt");
		PrintWriter w2 = new PrintWriter(fw2);
		
		//writing the oldtext, then writing the id and new password and then writing the aftertext
		
		w2.write(oldtext);
		w2.write(id + " " + newpass);
		w2.println();
		w2.write(aftertext);
		
		//closing the file
		w2.close();
		fw2.close();
		
		//d.changePassword(id, pass, newpass);
		//p.changePassword(id, pass, newpass);
		
		System.out.println("\nPASSWORD CHANGED SUCCESSFULLY!");
	}
	
	
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  DELETION  OPERATION  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//Deleting Users Account (Done on request of User)
	
	public void deleteUser(String id,String pass,Donor d,Purchaser p,User u) throws IOException, ClassNotFoundException
	{
		//Deleting from Users Linked List
		
		Node<User> pos = u.ulist.getFirst();
		while(pos!=null)
		{
			if(pos.getData().user_id.equals(id) && pos.getData().password.equals(pass))
			{
				u.ulist.remove(pos);
				break;
			}
			pos = pos.getNext();
		}
		
		//storing contents of list into file
		u.ulistToFile();
		
		
		//Deleting from Donors Linked List
		
		Node<Donor> pos1 = d.dlist.getFirst();
		while(pos1!=null)
		{
			if(pos1.getData().user_id.equals(id) && pos1.getData().password.equals(pass))
			{
				d.dlist.remove(pos1);
				break;
			}
			pos1 = pos1.getNext();
		}
		
		//storing contents of list into file
		d.dlistToFile();
		
		
		//Deleting from Purchasers Linked List
		
		Node<Purchaser> pos2 = p.plist.getFirst();
		while(pos2!=null)
		{
			if(pos2.getData().user_id.equals(id) && pos2.getData().password.equals(pass))
			{
				p.plist.remove(pos2);
				break;
			}
			pos2 = pos2.getNext();
		}
		
		//storing contents of list into file
		p.plistToFile();
		
		
		//Deleting the id and password from Users.txt
		
		String h,oldtext="",aftertext="";
		String[] w = new String[10];
		
		//opening the file in reading mode
		
		FileInputStream f = new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\DSA LAB\\bin\\code2\\Users.txt");
		InputStreamReader fin = new InputStreamReader(f);
		BufferedReader din  = new BufferedReader(fin);
		
		//storing the content of the file which appears before that id and password, in oldtext
		
		while((h=din.readLine())!=null)
		{
			w = h.split("\\s");
			if(w[0].equals(id) && w[1].equals(pass))
				break;
			else
				oldtext = oldtext + h + "\n";
		}
		
		
		//storing the contents of file that appears after that id and password, into aftertext
		
		while((h=din.readLine())!=null)
		{
			aftertext = aftertext + h + "\n";
		}
		
		din.close();
		fin.close();
		f.close();
		
		//opening the file in writing mode
		
		FileWriter fw2 = new FileWriter("C:\\Users\\Dell\\eclipse-workspace\\DSA LAB\\bin\\code2\\Users.txt");
		PrintWriter w2 = new PrintWriter(fw2);
		
		//writing only oldtext and aftertext in file
		
		w2.write(oldtext);
		w2.write(aftertext);
		
		//closing the file
		w2.close();
		fw2.close();
	}
	
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ SEARCHING  OPERATIONS  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public void searchDonor(Donor d,int ch,String h)
	{
		Scanner sc = new Scanner(System.in);
		int age;
		String name,bg,id;

		switch(ch)
		{
			case 1:
			{
				int temp = 0;
				name = h;

				//search for that particular name in the list and add that object in a new list
				
				Node<Donor> pos = d.dlist.getFirst();
				LinkedList<Donor> list = new LinkedList<>();
				while(pos!=null)
				{
					if(pos.getData().name.equals(name))
					{
						temp = 1;
						list.insert(pos.getData());
					}
					
					pos = pos.getNext();
				}
				
				if(temp == 0)
				{
					System.out.println("No Donor with the name '" + name + "' found");
				}
				else
				{
					//displaying the contents of the new list
					
					ADonDetails ad = new ADonDetails(list);
					ad.setVisible(true);
				}
				break;
			}
			
			case 2:
			{
				int temp = 0;
				//System.out.println("\nEnter age to be searched for:");
				age = Integer.valueOf(h);
				
				//search for that particular age in the list and add that object in a new list
				
				Node<Donor> pos = d.dlist.getFirst();
				LinkedList<Donor> list = new LinkedList<>();
				while(pos!=null)
				{
					if(pos.getData().age == age)
					{
						temp = 1;
						list.insert(pos.getData());
					}
					
					pos = pos.getNext();
				}
				
				if(temp == 0)
				{
					System.out.println("No Donor with the age '" + age + "' found");
				}
				else
				{
					//displaying the contents of the new list
					
					ADonDetails ad = new ADonDetails(list);
					ad.setVisible(true);
				}
				break;
			}
			
			case 3:
			{
				int temp = 0;
				bg = h;
				
				//search for that particular blood group in the list and add that object in a new list
				
				Node<Donor> pos = d.dlist.getFirst();
				LinkedList<Donor> list = new LinkedList<>();
				while(pos!=null)
				{
					if(pos.getData().bloodgroup.equals(bg))
					{
						temp = 1;
						list.insert(pos.getData());
					}
					
					pos = pos.getNext();
				}
				
				if(temp == 0)
				{
					System.out.println("No Donor with the BloodGroup '" + bg + "' found");
				}
				else
				{
					//displaying the contents of the new list
					
					ADonDetails ad = new ADonDetails(list);
					ad.setVisible(true);
				}
				break;
			}
			
	
		}
				
	}
	
	public void searchPurchaser(Purchaser p,int ch,String h)
	{
		Scanner sc = new Scanner(System.in);
		int age;
		String name,bg,id;
		
		switch(ch)
		{
			case 1:
			{
				int temp = 0;
				name = h;
				
				//search for that particular name in the list and add that object in a new list
				
				Node<Purchaser> pos = p.plist.getFirst();
				LinkedList<Purchaser> list = new LinkedList<>();
				while(pos!=null)
				{
					if(pos.getData().name.equals(name))
					{
						temp = 1;					
						list.insert(pos.getData());
					}
					pos = pos.getNext();
				}
				
				if(temp == 0)
				{
					System.out.println("No Purchaser with the name '" + name + "' found");
				}
				else
				{
					//displaying the contents of the new list
					
					APurDetails ap = new APurDetails(list);
					ap.setVisible(true);
				}
				
				break;
			}
			
			case 2:
			{
				int temp = 0;
				age = Integer.valueOf(h);
				
				//search for that particular age in the list and add that object in a new list
				
				Node<Purchaser> pos = p.plist.getFirst();
				LinkedList<Purchaser> list = new LinkedList<>();
				while(pos!=null)
				{
					if(pos.getData().age == age)
					{
						temp = 1;
						list.insert(pos.getData());
					}
					
					pos = pos.getNext();
				}
				
				if(temp == 0)
				{
					System.out.println("No Purchaser with the age '" + age + "' found");
				}
				else
				{
					//displaying the contents of the new list
					
					APurDetails ap = new APurDetails(list);
					ap.setVisible(true);
				}
				
				break;
			}
			
			case 3:
			{
				int temp = 0;
				bg = h;
				
				//search for that particular blood group in the list and add that object in a new list
				
				Node<Purchaser> pos = p.plist.getFirst();
				LinkedList<Purchaser> list = new LinkedList<>();
				while(pos!=null)
				{
					if(pos.getData().getWantedBloodGroup().equals(bg))
					{
						temp = 1;
						list.insert(pos.getData());
					}
					
					pos = pos.getNext();
				}
				
				if(temp == 0)
				{
					System.out.println("No Purchaser with the BloodGroup '" + bg + "' found");
				}
				else
				{
					//displaying the contents of the new list
					
					APurDetails ap = new APurDetails(list);
					ap.setVisible(true);
				}
				break;
			}
		}
			
	}
}
