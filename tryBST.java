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
}                
    
