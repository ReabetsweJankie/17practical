//created a java file
import java.util.*;

class TNode{
    int key;
    TNode left, right;
    
    public TNode(int key){
        this.key = key;
        this.left = null;
        this.right = null;
    }
}                      // Defined tree node structure
class BST{
    
    TNode root;
    
    public BST(){
        this.root = null;
    }
    
    private TNode insertRec(TNode node, int key){
        if(node == null){
            return new TNode(key);
        }
        if (key<node.key){
            node.left = insertRec(node.left, key);
        }else if (key>node.key){
            node.right  = insertRec(node.right, key);
        }
        return node;
    }
    
    public void insert(int key){
        root = insertRec(root, key);
    }
}                      //implemented BST core functionality
public boolean isBST(TNode node, int min, int max){
    if(node == null) return true;
    if(node.key<min || node.key>max) return false;
    return isBST(node.left, min, node.key - 1) &&  isBST(node.right, node.key + 1, max);
}                      //check BST property
private int minValue(TNode node){
    while(node.left!= null){
        node = node.left;
    }
    return node.key;
}                     // find minimum value

public TNode deleteRec(TNode node, int key){
    if(node == null) return null;
    
    if(key<node.key){
        node.left = deleteRec(node.left, key);
    }else if(key>node.key){
        node.right = deleteRec(node.right, key);
    }else{
        if(node.left == null) return node.right;
        if(node.right == null) return node.left;
        
        node.key = minValue(node.right);
        node.right = deleteRec(node.right, node.key);
    }
    return node;
}                       //Added delete operation to BST

Public class tryBST{
    static void buildBalanced(BST tree, int start, int end){
        if(start>end) return;
        
        int mid = (start + end)/2;
        tree.insert(mid);
        
        buildBalanced(tree, start, mid-1);
        buildBalanced(tree, mid+1, end);
    }                       // utility methods for building and modifying the tree
        
    static void removeEvens(BST tree, int max){
        for(int i = 2; i<=max; i+=2){
            tree.root = tree.deleteRec(tree.root, i);
        }
    }                       // remove even numbers



    
