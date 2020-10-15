package BloodBankManagment;

import java.io.Serializable;

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ LINKED LIST CLASS ~~~~~~~~~~~~~~~~~~~~~~~~~~~~`
/*
 * contains
 * 1. NODE CLASS
 * 2. LINKED LIST CLASS
 */

//Generic Node class
class Node<T> implements Serializable
{
	private T data;
	private Node<T> next;
	
	//PARAMETERIZED CONSTRUCTOR
	
	public Node(T x)
	{
		data = x;
		next = null;
	}

	//GETTERS AND SETTERS
	
	public T getData()
	{
		return data;
	}

	public void setData(T data) 
	{
		this.data = data;
	}

	public Node<T> getNext() 
	{
		return next;
	}

	public void setNext(Node<T> next) 
	{
		this.next = next;
	}
}

//Generic LinkedList class 
class LinkedList<T> implements Serializable
{
	private Node<T> first;
	int size;
	
	public LinkedList()
	{
		first = null;	
		size = 0;
	}
	
	public Node<T> getFirst()
	{
		return first;
	}
	
	public boolean isEmpty()
	{
		return first==null;
	}
	
	public String toString()
	{
		String str="";
		Node<T> pos = first;
		
		while(pos!=null)
		{
			str = str + pos.getData();
			if(pos.getNext()!=null)
				str = str + "\n\n***************************\n\n";
			pos = pos.getNext();
		}
		
		return str;
	}
	
	//FUNCTION FOR INSERTING THE NODE AT THE END OF THE LIST
	public void insert(T x)
	{
		Node<T> q = new Node<T>(x);
		
		//if the linked list is empty, inserting q as the head of the linked list
		if(first == null)
			first = q;
		else
		{
			Node<T> pos = first;
			
			//traversing to the end of the linked list
			while(pos.getNext()!=null)
			{
				pos = pos.getNext();
			}
			
			pos.setNext(q);
		}
		size++;
	}
	
	//FUNCTION TO REMOVE A NODE AT THE SPECIFIED POSITION
	public void remove(Node<T> pos)
	{
		if(first == pos)
		{
			first = pos.getNext();
		}
		else
		{
			Node<T> prev = first;
			while(prev.getNext()!=pos)
			{
				prev = prev.getNext();
			}
			prev.setNext(pos.getNext());
		}
	}
	
}
