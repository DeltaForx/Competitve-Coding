class Node{
	int data;
	Node next;
	Node(int x)
	{
		data = x;
		next = null;
	}
}
public class LinkedList5{
	static Node head = null;
	public Node append(Node head, int x)
	{
		Node newNode = new Node(x);
		if(head == null)
			head = newNode;
		else
		{
			Node temp = head;
			while(temp.next != null)
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
    public int getNthElement(Node head, int n)
    {
    	Node len = head;
    	int count = 0;
    	while(len!=null)
    	{
    		count++;
    		len = len.next;
    	}
    	if(n > count || n < 1)
    		return -1;
    	else
    	{
    		Node temp = head;
    		for(int i=1;i<n;i++)
    			temp = temp.next;
    		return temp.data;
    	}
    }
    public static void main(String args[])
    {
    	LinkedList5 list = new LinkedList5();
    	list.head = list.append(list.head,10);
    	list.head = list.append(list.head,20);
    	list.head = list.append(list.head,30);
    	list.head = list.append(list.head,40);
    	list.head = list.append(list.head,50);
    	list.printList(list.head);
    	System.out.println(list.getNthElement(list.head,1));
    	System.out.println(list.getNthElement(list.head,2));
    	System.out.println(list.getNthElement(list.head,3));
    	System.out.println(list.getNthElement(list.head,4));
    	System.out.println(list.getNthElement(list.head,5));
    	System.out.println(list.getNthElement(list.head,6));
    	System.out.println(list.getNthElement(list.head,-5));
    }
}
