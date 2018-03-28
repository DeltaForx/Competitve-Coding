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
public class LinkedList3
{
	static Node head = null;
	public Node append(Node head,int x)
	{
		Node newNode = new Node(x);
		if(head==null)
			head = newNode;
		else
		{
			Node temp = head;
			while(temp.next!=null)
				temp = temp.next;
			temp.next = newNode;
		}
		return head;
	}
	public void printList(Node head)
	{
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
	public Boolean search(Node head, int element)
	{
		Node temp = head;
		if(temp == null)
			return false;
		if(temp.data == element)
			return true;
		return search(temp.next,element);
	}
	public static void main(String args[])
	{
		LinkedList3 list = new LinkedList3();
		list.head = list.append(list.head,1);
		list.head = list.append(list.head,2);
		list.head = list.append(list.head,3);
		list.head = list.append(list.head,4);
		list.printList(list.head);
		System.out.println(list.search(list.head,1));
		System.out.println(list.search(list.head,2));
		System.out.println(list.search(list.head,3));
		System.out.println(list.search(list.head,4));
		System.out.println(list.search(list.head,5));
		System.out.println(list.search(list.head,10));
	}
}
