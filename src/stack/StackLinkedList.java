package stack;

public class StackLinkedList {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            next=null;
        }

    }
    //this is best way to implement stack it is provide best space complexity than array list so

    static class Stack{
        public static Node head;
        public static boolean isEmpty(){
            return head==null;
        }
        public static void push(int data){
            Node newNode=new Node(data);
            if(isEmpty()){
                head=newNode;
                return;

            }
            newNode.next=head;
            head=newNode;
        }

        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int top=head.data;
            head=head.next;
            return top;

        }

        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return head.data;
        }



    }

    public static void main(String[] args) {
        Stack stack=new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        while (!stack.isEmpty()){
            System.out.println(stack.peek());
            stack.pop();
        }
    }
}
