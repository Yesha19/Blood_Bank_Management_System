package BloodBankManagment;

public class MyArrayList<E extends Object> 
{

    private static int initialCapacity = 5;
    int currentSize;
    Object[] myArrayList ;
	private Object[] temp;

    int currentIndex = 0;

    public MyArrayList() 
    {  //creates default sized Array of Objects
    	
        myArrayList = new Object[initialCapacity]; //generic expression

        /* everytime I cross my capacity, 
    I make double size of Object Array, copy all the elements from past myObject Array Object
         */
    }

    public MyArrayList(int size) 
    { 
    	//creates custom sized Array of Objects
        myArrayList = new Object[size];
    }

    public void add(Object anyObj)
    {
        //add element directy
        myArrayList[currentIndex] = anyObj;
        currentSize = myArrayList.length;
        currentIndex++;
        
        if (currentIndex == currentSize) 
        {
            createDoubleSizedObjectArray(currentSize);
        }
    }

    //print all elements
    public void printAllElements() 
    {
        System.out.println("Displaying list : ");
        for (int i = 0; i < currentIndex; i++) 
        {
            System.out.println(myArrayList[i].toString()); 
        }
    }

    private void createDoubleSizedObjectArray(int currentSize) 
    {
    	temp = new Object[currentSize];
        temp = myArrayList;
        myArrayList = new Object[2 * currentSize];  //myObject pointer big size data structure

//         myObject = temp.clone(); //probably I can do this here as well. Need to check this
        //System.arraycopy(temp, 0, myArrayList, 0, currentSize);
        
        for(int i=0;i<currentSize;i++)
        {
        	myArrayList[i] = temp[i];
        }

    }

    void delete(Object object)
    {
        //if already empty 
        if (currentIndex == 0) 
        {
            System.out.println("Already empty!");
            return;
        }
        //you don't need to delete anything. I can simply override the storage
        currentIndex--;
    }
    
    
}