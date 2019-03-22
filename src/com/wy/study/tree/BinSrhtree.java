package com.wy.study.tree;

import java.awt.event.MouseWheelListener;

/**
 * @Author WangYang
 * @Description:
 * @Date Created in 14:07 2019/3/15
 */
public class BinSrhtree {

    class Node {
        int key;
        int value;
        Node leftNode;
        Node rightNode;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Node root;

    public Node find(int key) {
        Node currentnode = root;
        while (currentnode != null && currentnode.key != key) {
            if (currentnode.key > key) {
                currentnode = currentnode.leftNode;
            } else {
                currentnode = currentnode.rightNode;
            }
        }
        return currentnode;
    }

    public void insert(int key, int value) {
        if (root == null) {
            root = new Node(key, value);
        }
        Node currentnode = root;
        Node parentnode = root;
        boolean isLeft = true;
        while (currentnode != null) {
            parentnode = currentnode;
            if (currentnode.key > key) {
                currentnode = currentnode.leftNode;
                isLeft = true;
            } else {
                currentnode = currentnode.rightNode;
                isLeft = false;
            }
        }
        Node newNode = new Node(key, value);
        if (isLeft) {
            parentnode.leftNode = newNode;
        } else {
            parentnode.rightNode = newNode;
        }

    }

    public boolean delete(int key) {
        Node currentnode = root;
        Node parent = root;
        boolean islLeft = true;
        while (currentnode != null && currentnode.key != key) {
            parent = currentnode;
            if (currentnode.key > key) {
                currentnode = currentnode.leftNode;
                islLeft = true;
            } else {
                currentnode = currentnode.rightNode;
                islLeft = false;
            }
        }
        if (currentnode == null) {
            return false;
        }
        if (currentnode.leftNode == null && currentnode.rightNode == null) {
            if (currentnode == root) {
                root = null;
            } else if (islLeft) {
                parent.leftNode = null;
            } else {
                parent.rightNode = null;
            }
        } else if (currentnode.rightNode == null) {
            if (currentnode == root) {
                root = currentnode.leftNode;
            } else if (islLeft) {
                parent.leftNode = currentnode.leftNode;
            } else {
                parent.rightNode = currentnode.leftNode;
            }
        } else if (currentnode.leftNode == null) {
            if (currentnode == root) {
                root = currentnode.rightNode;
            } else if (islLeft) {
                parent.leftNode = currentnode.rightNode;
            } else {
                parent.rightNode = currentnode.rightNode;
            }
        }else{
            Node directNode = getDirectPostNode(currentnode);
            currentnode.key = directNode.key;
            currentnode.value = directNode.value;
        }
        return true;
    }

    private Node getDirectPostNode(Node delNode) {
        Node parent = delNode;
        Node directPostNode = delNode;
        Node currentNode = delNode.rightNode;
        while (currentNode != null) {
            parent = directPostNode;
            directPostNode = currentNode;
            currentNode = currentNode.leftNode;
        }
        if(directPostNode!=delNode.rightNode){
            parent.leftNode = directPostNode.rightNode;
            directPostNode.rightNode = null;
        }
        return directPostNode;
    }

    public void preOrder(Node rootNode) {
        if (rootNode != null) {
            System.out.println(rootNode.key + " " + rootNode.value);
            preOrder(rootNode.leftNode);
            preOrder(rootNode.rightNode);
        }
    }

    public void inOrder(Node rootNode) {
        if (rootNode != null) {
            inOrder(rootNode.leftNode);
            System.out.println(rootNode.key + " " + rootNode.value);
            inOrder(rootNode.rightNode);
        }
    }

    public void postOrder(Node rootNode) {
        if (rootNode != null) {
            postOrder(rootNode.leftNode);
            postOrder(rootNode.rightNode);
            System.out.println(rootNode.key + " " + rootNode.value);
        }
    }

}
