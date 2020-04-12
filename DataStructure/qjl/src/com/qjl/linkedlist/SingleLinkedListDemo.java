package com.qjl.linkedlist;

import com.qjl.linkedlist.method.Node;
import com.qjl.linkedlist.method.SingleLinkedList;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        Node node01 = new Node(1, "阿西");
        Node node02 = new Node(2, "阿梨");
        Node node03 = new Node(3, "阿舍");
        Node node04 = new Node(4, "大佬");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        System.out.println("原始链表------");
        singleLinkedList.addNodeByOrder(node01);
        singleLinkedList.addNodeByOrder(node04);
        singleLinkedList.addNodeByOrder(node03);
        singleLinkedList.addNodeByOrder(node02);
        singleLinkedList.showLinkedList();
        System.out.println("修改后的链表-------");
        Node updateNode02 = new Node(4, "钊哥");
        singleLinkedList.updateNode(updateNode02);
        singleLinkedList.showLinkedList();
        singleLinkedList.deleteNode(1);
        singleLinkedList.showLinkedList();
        //System.out.println(findLastIndexNode(singleLinkedList, 2));
        // reverseLinkedList(singleLinkedList).ShowLinkedList();
        //reversePrint(singleLinkedList);
    }

  /*  *//***
     *面试题: 获取到单链表的节点的个数(如果是带头结点的链表，需求不统计头节点)
     * @param linkedList
     * @return length
     *//*
    public static int getLinkedLength(LinkedList linkedList) {
        CustomNode headNode = linkedList.getHeadNode();
        if (headNode.next == null) {
            return 0;
        }
        int length = 0;
        CustomNode temporary = headNode;
        while (temporary.next != null) {
            length++;
            //遍历
            temporary = temporary.next;
        }
        return length;
    }


    //查找单链表中的倒数第k个结点 【新浪面试题】

    *//***
     *	//1. index 表示是倒数第index个节点
     * 	//2. 先把链表从头到尾遍历，得到链表的总的长度 getLength
     * 	//3. 得到size 后，我们从链表的第一个节点开始遍历到 (size-index)个，就可以得到
     * 	//4. 如果找到了，则返回该节点，否则返回nulll
     * @return
     *//*
    public static CustomNode findLastIndexNode(LinkedList linkedList, int index) {
        CustomNode headNode = linkedList.getHeadNode();
        if (headNode.next == null) {
            return null;
        }
        //获取节点总个数(不包括头节点)
        int size = getLinkedLength(linkedList);
        //先做一个index的校验
        if (index < 0 || index > size) {
            return null;
        }
        //定义个辅助指针， for 循环定位到，倒数第index个
        CustomNode cur = headNode.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }


    //单链表的反转【腾讯面试题，有点难度】

    *//***
     *
     *//*
    public static LinkedList reverseLinkedList(LinkedList linkedList) {
        CustomNode headNode = linkedList.getHeadNode();
        if (headNode.next == null || headNode.next.next == null) {
            return linkedList;
        }

        CustomNode cur = headNode.next;
        //当前节点(cur)的下一个节点
        CustomNode curNext = null;
        CustomNode reverseHeadNode = new CustomNode(0, "");
        //遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHeadNode的最前端
        while (cur != null) {
            //保存当前节点的下一个节点（如果不保存，就找不到之前链表的节点）
            curNext = cur.next;
            //将cur指向新链表头节点的最前端（头节点和第一个节点之间）
            cur.next = reverseHeadNode.next;
            //将头节点与cur相连
            reverseHeadNode.next = cur;
            //找到原来链表的节点
            cur = curNext;
        }
        headNode.next = reverseHeadNode.next;
        return linkedList;
    }


    //从尾到头打印单链表 【百度面试题】

    *//***
     *
     *//*
    public static void reversePrint(LinkedList linkedList) {
        CustomNode headNode = linkedList.getHeadNode();
        if (headNode.next == null) {
            System.out.println("链表为空，无法打印");
            return;
        }
        CustomNode temporary = headNode.next;
        Stack<CustomNode> stack = new Stack<>();
        //将链表的所有节点压入栈中
        while (temporary != null) {
            stack.push(temporary);
            temporary = temporary.next;
        }
        //将节点弹栈（先进后出）
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }

    }


    //合并两个有序的单链表，合并之后的链表依然有序【课后练习】

    *//***
     *
     *//*
    public static void mergeLinkedList(LinkedList linkedListOne, LinkedList linkedListTwo) {
        CustomNode headNodeOne = linkedListOne.getHeadNode();
        CustomNode headNodeTwo = linkedListOne.getHeadNode();
        if (headNodeOne.next == null || headNodeTwo.next == null) {
            System.out.println("链表不能为空");
            return;
        }


    }*/

}


/*class LinkedList {
    private CustomNode headNode = new CustomNode(0, "");

    public CustomNode getHeadNode() {
        return headNode;
    }

    *//***
     * 显示链表（遍历链表）
     *//*
    public void ShowLinkedList() {
        if (headNode.next == null) {
            System.out.println("链表为空!");
            return;
        }
        CustomNode temporary = headNode.next;
        while (true) {
            if (temporary == null) {
                break;
            }
            System.out.println(temporary);
            temporary = temporary.next;
        }
    }

    *//**
     * 添加节点到单向链表
     * 思路:当不考虑编号顺序时
     * 1. 找到当前链表的最后节点
     * 2. 将最后这个节点的next指向新的节点
     *
     * @param newCustomNode
     *//*
    public void addNode(CustomNode newCustomNode) {
        CustomNode temporary = headNode;
        while (true) {
            if (temporary.next == null) {
                break;
            }
            temporary.next = newCustomNode;
        }
    }

    *//***
     * 添加节点，根据ID按顺序排序，如果ID存在，则添加失败并提示
     * @param newCustomNode
     *//*
    public void addNodeByOrder(CustomNode newCustomNode) {
        //头节点是固定不动的
        CustomNode temporary = headNode;
        //flag标志，判断添加的ID是否存在，默认false
        boolean flag = false;
        while (true) {
            if (temporary.next == null) {
                break;
            }
            //位置找到，就添加再temporary节点和temporary.next节点之间
            if (temporary.next.id > newCustomNode.id) {
                break;
                // ID已经存在
            } else if (temporary.next.id == newCustomNode.id) {
                flag = true;
                break;
            }
            // 后移，遍历当前链表
            temporary = temporary.next;
        }

        if (flag) {
            System.out.printf("要插入的数据ID：%d 已存在\n", newCustomNode.id);
        } else {
            //新节点插入到链表中（先连接后面的线，再连接前面的线）
            newCustomNode.next = temporary.next;
            temporary.next = newCustomNode;
        }
    }


    *//***
     * 根据节点ID修改节点信息
     * @param upDateCustomNode
     *//*
    public void updateNode(CustomNode upDateCustomNode) {
        if (headNode.next == null) {
            System.out.println("链表为空------");
            return;
        }
        //辅助指针
        CustomNode temporary = headNode.next;
        //判断是否找到改节点
        boolean flag = false;
        while (true) {
            if (temporary == null) {
                break;
            }
            if (temporary.id == upDateCustomNode.id) {
                flag = true;
                break;
            }
            temporary = temporary.next;

        }
        if (flag) {
            temporary.name = upDateCustomNode.name;
        } else {
            System.out.printf("没有找到ID：%d 的节点，无法修改\n", upDateCustomNode.id);
        }
    }


    *//***
     * 单链表节点无法自己删除自己，所以需要找到待删除节点前一个节点，
     * 使待删除删除节点的前一个节点，直接指向待删除节点的下一个节点(就是直接跳过删除节点)
     * @param id
     *//*
    public void deleteNode(int id) {
        if (headNode.next == null) {
            System.out.println("链表为空!!");
        }
        CustomNode temporary = headNode;
        boolean flag = false;
        while (true) {
            if (temporary == null) { //已经到链表的最后
                break;
            }
            if (temporary.next.id == id) {
                flag = true;
                break;
            }
            temporary = temporary.next;
        }
        if (flag) {
            temporary.next = temporary.next.next;
        } else {
            System.out.printf("要删除的ID: %d 节点不存在\n", id);

        }
    }


}*/


/*class CustomNode {

    int id;
    String name;
    CustomNode next;

    public CustomNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "CustomNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }*/

