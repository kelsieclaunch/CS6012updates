package assignment05;

public class BSTNode<T> {
    T dataValue;
    BSTNode root = null;
    BSTNode left;
    BSTNode right;

    BSTNode(T data) {
        this.dataValue = data;
    }

}
