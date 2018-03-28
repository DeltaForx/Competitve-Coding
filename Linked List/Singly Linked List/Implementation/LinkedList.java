import java.util.Scanner;
class Node{
	int data;
	Node next;
	Node(int x)
	{
		data = x;
		next = null;
	}
}
public class LinkedList{
	static Node head = null;
	static Node head2 = null;
	public Node insertAtBeginning(Node head, int x){
		Node newNode = new Node(x);
		if(head==null)
			head = newNode;
		else
		{
			newNode.next = head;
			head = newNode;
		}
		return head;
	}
	public Node insertAtEnd(Node head, int x)
	{
		Node newNode = new Node(x);
		if(head==null)
		{
			head = newNode;
		}
		else
		{
			Node temp = head;
			while(temp.next!=null)
			{
				temp = temp.next;
			}
			temp.next = newNode;
		}
		return head;
	}
	public int lengthOFList(Node head)
	{
		Node temp = head;
		int count = 0;
		while(temp!=null)
		{
			count++;
			temp = temp.next;
		}
		return count;
	}
	public Node insertAtGivenPosition(Node head, int x, int position)
	{
		int length = lengthOFList(head);
		if(position>length+1){
			System.out.println("Error while inserting : check bounds");
			return head;
		}
		else if(position==1)
			return insertAtBeginning(head,x);
		else if(position==length)
			return insertAtEnd(head,x);
		else
		{
			Node temp = head;
			for(int i=1;i<position-1;i++)
				temp = temp.next;
			Node newNode = new Node(x);
			newNode.next = temp.next;
			temp.next = newNode;
		}
		return head;
	}
	public Node deleteAtBeginning(Node head)
	{
		if(head==null)
			System.out.println("Error while deleting : deleting on an empty list");
		else
		    head = head.next;
		return head;
	}
	public Node deleteAtEnd(Node head)
	{
		if(head==null)
			System.out.println("Error while deleting : deleting on an empty list");
		else
		{
		Node temp = head;
		while(temp.next.next!=null)
			temp = temp.next;
		temp.next = null;
     	}
		return head;
	}
	public Node deleteAtGivenPosition(Node head, int position)
	{
		int length = lengthOFList(head);
		if(position > length){
			System.out.println("Error while deleting : check bounds");
			return head;
		}
		else if(position == 1)
			return deleteAtBeginning(head);
		else if(position == length)
			return deleteAtEnd(head);
		else
		{
			Node temp1 = head;
			Node temp2 = head;
			for(int i=1;i<position;i++)
			{
				temp2 = temp1;
				temp1 = temp1.next;
			}
			temp2.next = temp1.next;
		}
		return head;
	}
	public void printList(Node head){
		Node temp = head;
		System.out.print(temp.data);
		temp = temp.next;
		while(temp!=null)
		{
			System.out.print("->"+temp.data);
			temp = temp.next;
		}
		System.out.print("->NULL");
		System.out.println();
	}
	public void printMainMenu()
	{
		System.out.println("MENU");
		System.out.println("1. Insert");
		System.out.println("2. Delete");
		System.out.println("3. Length");
		System.out.println("4. Print");
		System.out.println("5. Exit");
	}
	public void printInsertMenu()
	{
		System.out.println("1. Insert at beginning");
		System.out.println("2. Insert at end");
		System.out.println("3. Insert at given position");
	}
	public void printDeleteMenu()
	{
		System.out.println("1. Delete at beginning");
		System.out.println("2. Delete at end");
		System.out.println("3. Delete at given position");
	}
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		LinkedList list = new LinkedList();
		Boolean flag = true;
		while(flag)
		{
			list.printMainMenu();
			System.out.println("Enter the choice:");
			int choice = scan.nextInt();
			switch(choice)
			{
				case 1:
				list.printInsertMenu();
				int choiceInsert = scan.nextInt();
				switch(choiceInsert)
				{
					case 1:
					System.out.println("Enter the data:");
					int data1 = scan.nextInt();
					list.head = list.insertAtBeginning(list.head,data1);
					break;
					case 2:
					System.out.println("Enter the data:");
					int data2 = scan.nextInt();
					list.head = list.insertAtEnd(list.head,data2);
					break;
					case 3:
					System.out.println("Enter the data:");
					int data3 = scan.nextInt();
					System.out.println("Enter the position:");
					int position = scan.nextInt();
					list.head = list.insertAtGivenPosition(list.head,data3,position);
					break;
					default:
					System.out.println("Enter a valid choice from 1-3:");
					break; 
				}
				list.printList(list.head);
				break;
				case 2:
				list.printDeleteMenu();
				int choiceDelete = scan.nextInt();
				switch(choiceDelete)
				{
					case 1:
					list.head = list.deleteAtBeginning(list.head);
					break;
					case 2:
					list.head = list.deleteAtEnd(list.head);
					break;
					case 3:
					System.out.println("Enter the position");
					int position = scan.nextInt();
					list.head = list.deleteAtGivenPosition(list.head,position);
					break;
					default:
					System.out.println("Enter a valid choice from 1-3:");
					break;
				}
				list.printList(list.head);
				break;
				case 3:
				list.printList(list.head);
				System.out.println("Length of the linked list is: " + list.lengthOFList(list.head));
				break;
				case 4:
				list.printList(list.head);
				break;
				case 5:
				flag = false;
				break;
				default:
				System.out.println("Enter a valid choice from 1-5:");
				break;
			}
		}
	}
}
