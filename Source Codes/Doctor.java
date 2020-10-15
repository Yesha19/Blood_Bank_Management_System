package BloodBankManagment;

import java.util.Scanner;

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ CLASS DOCTOR ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

public class Doctor extends Staff 
{
    String name;
    private int Id;
    Scanner sc = new Scanner(System.in);
    
    public Doctor()
    {
    	
    }

    public Doctor(String name , int Id)
    {
        this.name=name;
        this.Id=Id; 
    }
    
    //GETTERS AND SETTERS
    public int getid()
    {
        return Id;
    }
    
    public void setid(int Id)
    {
        this.Id = Id;   
    }

    //CALLING OF CHECKDONOR FRAME TO ASK QUESTIONS
    
    public void checkDonor(Node<User> pos,String id,String pass,Main1 mp)
    {
    	CheckDonor cd = new CheckDonor(mp,pos.getData().name , pos.getData().age , pos.getData().sex , pos.getData().contactno , pos.getData().city , id , pass);
		cd.setVisible(true);
    }
    
}
