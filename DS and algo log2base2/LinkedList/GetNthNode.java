import java.util.Scanner;

class Node{
    int data;
    Node next;
}

class GetNthNode{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Node head = null;
        System.out.println("1. Add 2. Print 3. Exit");
        do{
            System.out.print("Enter choice : ");
            int choice = sc.nextInt();
            if(choice == 1){
                System.out.print("Enter value : ");
                int value = sc.nextInt();
                head = AddLastEle(head, value);
            }
            else if(choice == 2){
                printList(head);
            }
            else if(choice == 3){
                break;
            }
        }while(true);
        do{
            System.out.print("Enter the index : ");
            int index = sc.nextInt();
            if(index == -1)
                break;
            getNode(head, index);
        }while(true);
        sc.close();
    }

    public static void getNode(Node head, int index){
        Node temp = head;
        while(temp != null && index > 0){
            temp = temp.next;
            index--;
        }
        if(index == 0 && temp != null){
            System.out.println(temp.data);
        }
        else{
            System.out.println("Not found.");
            return;
        }
    }

    public static void printList(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static Node AddLastEle(Node head, int value){
        Node temp = new Node();
        temp.data = value;
        temp.next = null;
        if(head == null){
            return temp;
        }
        Node traverse = head;
        while(traverse.next != null){
            traverse = traverse.next;
        }
        traverse.next = temp;
        return head;
    }
}