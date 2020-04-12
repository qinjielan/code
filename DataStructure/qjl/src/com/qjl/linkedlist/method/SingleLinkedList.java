package com.qjl.linkedlist.method;


public class SingleLinkedList {

    private Node headNode = new Node(0, "");

    public Node getHeadNode() {
        return headNode;
    }


    /***
     * 添加节点，根据ID按顺序排序，如果ID存在，则添加失败并提示
     * @param newNode
     */
    public void addNodeByOrder(Node newNode) {
        Node cur = headNode;
        boolean flag = false;
        while (true) {
            if (cur.getNext() == null) {
                break;
            }
            if (cur.getNext().getId() > newNode.getId()) {
                break;
            } else if (cur.getNext().getId() == newNode.getId()) {
                flag = true;
                break;
            }
            cur = cur.getNext();
        }
        if (flag) {
            System.out.printf("要插入的数据ID：%d 已存在\n", newNode.getId());
        }
        newNode.setNext(cur.getNext());
        cur.setNext(newNode);


    }


    /***
     * 根据节点ID修改节点信息
     * @param updateNode
     */
    public void updateNode(Node updateNode) {
        if (headNode.getNext() == null) {
            System.out.println("链表为空!");
            return;
        }
        Node cur = headNode.getNext();
        boolean flag = false;
        while (true) {
            if (cur == null) {
                break;
            }
            if (cur.getId() == updateNode.getId()) {
                flag = true;
                break;
            }
            cur = cur.getNext();
        }
        if (flag) {
            cur.setName(updateNode.getName());
        } else {
            System.out.printf("没有找到ID：%d 的节点，无法修改\n", updateNode.getId());
        }

    }


    /***
     * 单链表节点无法自己删除自己，所以需要找到待删除节点前一个节点，
     * 使待删除删除节点的前一个节点，直接指向待删除节点的下一个节点(就是直接跳过删除节点)
     * @param delId
     */
    public void deleteNode(int delId) {
        if (headNode.getNext() == null) {
            System.out.println("链表为空!");
            return;
        }
        Node cur = headNode;
        boolean flag = false;
        while (true) {
            if (cur.getNext() == null) {
                break;
            }
            if (cur.getNext().getId() == delId) {
                flag = true;
                break;
            }
            cur = cur.getNext();
        }
        if (flag) {
            cur.setNext(cur.getNext().getNext());
        } else {
            System.out.printf("要删除的ID: %d 节点不存在\n", delId);
        }

    }

    /***
     * 显示链表（遍历链表）
     */
    public void showLinkedList() {
        if (headNode.getNext() == null) {
            System.out.println("链表为空!");
            return;
        }
        Node cur = headNode.getNext();
        while (true) {
            if (cur == null) { //遍历到链表的最后了
                break;
            }
            System.out.println(cur);
            cur = cur.getNext();
        }
    }
}
