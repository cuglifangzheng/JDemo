/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.learn.algo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.testng.annotations.Test;

/**
 *
 * @author lifangzheng
 * @version : AlgoTest.java, v 0.1 2020年12月15日 10:54 上午 lifangzheng Exp $
 */
public class AlgoTest {
    @AllArgsConstructor(staticName = "of")
    static class Node {
        int i;
        Node next;
    }

    void print(Node n) {
        System.out.print(n.i + " ");
        if (n.next == null) {
            return;
        }
        print(n.next);
    }

    Node reverse(Node head) {
        if (head.next == null) {
            return head;
        }
        Node nextNext = head.next;
        Node next = reverse(head.next);
        nextNext.next = head;
        head.next = null;
        return next;
    }

    Node reverseBy(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node guard = null;
        Node cur = head;
        while (cur != null) {
            Node tmp = cur.next;
            cur.next = guard;
            guard = cur;
            cur = tmp;
        }
        return guard;
    }

    @Test
    public void reverse() {
        Node n5 = Node.of(5, null);
        Node n4 = Node.of(4, n5);
        Node n3 = Node.of(3, n4);
        Node n2 = Node.of(2, n3);
        Node n1 = Node.of(1, n2);
        print(n1);
        System.out.println();
        //print(reverse(n1));
        System.out.println();
        print(reverseBy(n1));
    }

}