//package linkedLists;
//linkList2.java
//demonstrates linked list
//to run this program: C>java LinkList2App
////////////////////////////////////////////////////////////////
// File: Link.java
// ------- Link Node -------
// Single node in a linked list, holding one Card and a reference to the next node.
public class Link {
    public Card card;  // card stored in this node
    public Link next;  // pointer to the next node in the list

    /**
     * Create a list node containing the given card.
     * @param card the Card object to store
     */
    public Link(Card card) {
        this.card = card;
        this.next = null; // next set when inserting into list
    }
}  // end class Link
/////////////////////////////////////////////////////////////////
