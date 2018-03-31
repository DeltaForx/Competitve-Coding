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
public class LinkedList4
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
	public static Node swap(Node head, int x, int y)
	{
		//if x and y are equal then do nothing
		if(x==y)
			return head;
		//search for x
		Node prevX = null, currX = head;
		while(currX != null && currX.data != x)
		{
			prevX = currX;
			currX = currX.next;
		}
		//search for y
		Node prevY = null, currY = head;
		while(currY != null && currY.data != y)
		{
			prevY = currY;
			currY = currY.next;
		}
		//if any of x and y are not present then do nothing
		if(currY == null || currX == null)
			return head;
		//if x is not the head of the LL
		if(prevX != null)
			prevX.next = currY;
		else
			head = currY;
		//if y is not the head if the LL
		if(prevY != null)
			prevY.next = currX;
		else
			head = currX;
		Node temp = currX.next;
		currX.next = currY.next;
		currY.next = temp;
		return head;
	}
	public static void main(String args[])
	{
		LinkedList4 list = new LinkedList4();
		list.head = list.append(list.head,1);
		list.head = list.append(list.head,2);
		list.head = list.append(list.head,3);
		list.head = list.append(list.head,4);
		list.head = list.append(list.head,5);
		list.head = list.append(list.head,6);
		list.head = list.append(list.head,7);
		list.printList(list.head);
		list.head = list.swap(list.head,1,9);
		list.printList(list.head);
	}
}
