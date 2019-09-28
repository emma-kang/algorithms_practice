/**
* 2019-09-27
* HackkerRank Insert a node at a specific position in a linked list 
*
**/

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
        SinglyLinkedListNode res = new SinglyLinkedListNode(data);

        if(llist != null){
            res.next = llist;
        }
    
        return res;
        
    }
