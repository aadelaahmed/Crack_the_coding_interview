package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int n, m, tempInput;
    static Node head;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        for (int i = 0; i < n; i++) {
            tempInput = input.nextInt();
            if (i == 0) {
                head = new Node(tempInput);
                continue;
            }
            head.appendToTail(tempInput);
        }
        String result= head.isPlaindrome();
        System.out.println(result);
    }


}


class Node {
    int data;
    Node next;

    public Node() {

    }

    public Node(int value) {
        data = value;
    }

    public void appendToTail(int d) {
        Node newNode = new Node(d);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = newNode;
    }

    public String isPlaindrome() {
        Node current = this;
        while (current.next != null) {
            if (!checkPlaindrome(current))
                return "NO";
            current = current.next;
        }
        return "YES";
    }

    public boolean checkPlaindrome(Node head) {
        Node current = head;
        while (current.next != null) {
            if (current.next.data == head.data && current.next.next == null) {
                //we reach on tail and it's equal to the head
                //so, we need to delete head and tail and update it
                //otherwise, return false
                current.next = null;
                head = head.next;
                return true;
            } else if (current.next != null)
                current = current.next;
        }
        return false;
    }

}
