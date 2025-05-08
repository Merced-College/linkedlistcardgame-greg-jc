
// File: LinkedList.java
// ------- LinkedList Class -------
// Implements a simple singly-linked list for Card objects
public class LinkedList {
    private Link first; // head of list (top of deck)

    /**
     * Initialize an empty list.
     */
    public LinkedList() {
        first = null;
    }

    /**
     * Check if list has no nodes.
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Add a card at the front (top) of the list.
     * @param card Card to insert
     */
    public void insertFirst(Card card) {
        Link newNode = new Link(card);
        newNode.next = first; // link new node to old head
        first = newNode;      // update head to new node
    }

    /**
     * Add a card at the end (bottom) of the list.
     * @param card Card to insert
     */
    public void insertLast(Card card) {
        if (isEmpty()) {
            insertFirst(card); // empty list: same as insertFirst
            return;
        }
        Link current = first;
        // traverse until the last node
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Link(card); // append new node
    }

    /**
     * Remove and return the first card (top) from the list.
     * @return removed Card, or null if list was empty
     */
    public Card removeFirst() {
        if (isEmpty()) {
            return null; // nothing to remove
        }
        Card temp = first.card; // save card to return
        first = first.next;     // head moves to next node
        return temp;
    }

    /**
     * Count how many cards are in the list.
     * @return number of nodes
     */
    public int size() {
        int count = 0;
        Link current = first;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}  // end class LinkList
////////////////////////////////////////////////////////////////
/*class LinkedLists
{
	public static void main(String[] args)
	{
		LinkList theList = new LinkList();  // make list

		theList.insertFirst(new Card("heart", "ace", 11,"ah.gif"));      // insert 4 items
		theList.insertFirst(new Card("Spade", "ace", 11,"as.gif"));
		//theList.insertFirst(66, 6.99);
		//theList.insertFirst(88, 8.99);

		theList.displayList();              // display list

		Link f = theList.find(new Card("heart", "ace", 11,"ah.gif"));          // find item
		if( f != null)
			System.out.println("Found link with key " + f.cardLink);
		else
			System.out.println("Can't find link");

		Link d = theList.delete(new Card("heart", "ace", 11,"ah.gif"));        // delete item
		if( d != null )
			System.out.println("Deleted link with key " + d.cardLink);
		else
			System.out.println("Can't delete link");

		theList.displayList();              // display list
	}  // end main()
}  // end class LinkList2App
////////////////////////////////////////////////////////////////
/// */
