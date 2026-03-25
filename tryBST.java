//created a java file
import java.util.*;

class tNode{
    int key;
    tNode left, right;
    
    public tNode(int key){
        this.key = key;
        left = null;
        right = null;
    }
}             // Defined tree node structure

class BST{
    tNode root;
    BST(){
        root = null;
    }
    tNode insertRec(tNode node, int key){
        if(root == null){
            root = new tNode (key);
            return root;
        }
        if (key< root.key){
            root.left = insertRec(root.left, key);
            
        else if (key > root.key)
            root.right  = insertRec(root.right, key);
        
        return root;
    }
    void insert(int key){
        root = insertRec(root, key);
    }          //implemented BST core functionality
  boolean isBST(tNode node, int min, int max){
    if(node == null)
        return true;
    if(node.key<min || node.key>max) 
        return false;
      
    return isBST(node.left, min, node.key-1) &&  isBST(node.right, node.key+1, max);
}                      //check BST property
int minValue(tNode node){
    int min = node.key;
    
    while(node.left != null){
        min = node.left.key;
        node = node.left;
    }
    return min;
}                     // find minimum value

tNode deleteRec(tNode node, int key){
    if(root == null) 
        return root;
    if(key < root.key){
        root.left = deleteRec(root.left, key);
    else if(key > root.key)
        root.right = deleteRec(root.right, key);
    else{
        if(root.left == null) 
            return node.right;
        else if(root.right == null) 
            return root.left;
        root.key = minValue(root.right);
        root.right = deleteRec(root.right, root.key);
     }
     return root;
  } 
}                      //Added delete operation to BST

 public class tryBST{
    static void buildBalanced(BST tree, int start, int end){
        if(start > end) 
            return;
        int mid = (start + end)/2;
        tree.insert(mid);
        buildBalanced(tree, start, mid-1);
        buildBalanced(tree, mid+1, end);
    }                       // utility methods for building and modifying the tree
        
  static void removeEvens(BST tree, int max){
        for(int i=2; i<=max; i+=2){
            tree.root = tree.deleteRec(tree.root, i);
        }
  }                       // remove even numbers
     public static void main(String[] args){
        int n = 18;
        int max = (int) Math.pow(2, n)-1;
        int repetitions = 30;

         double [] populateTimes = new double[repetitions];
         double [] deleteTimes = new double[repetitions];
         
        long totalPopulate = 0;
        long totalDelete = 0;
        
        for(int i=0; i<repetitions; i++){
            BST tree = new BST();    //main method with benchmarking logic
            long populateStart = System.currentTimeMillis();
            buildBalanced(tree,1 ,max);
            long populateEnd = System.currentTimeMillis();
            
            populateTotal += (populateEnd - populateStart);  //populate tree
            
            if(!tree.isBST(tree.root, Integer.MIN_VALUE, Integer.MAX_VALUE)){
                System.out.println("Tree is not BST!");
            }
            
            long deleteStart = System.currentTimeMillis();
            removeEvenNumbers(tree, max);
            long deleteEnd = System.currentTimeMillis();
            deleteTotal += (deleteEnd - deleteStart);
        }
        double populateAvg = populateTotal/ (double) repetitions;
        double deleteAvg = deleteTotal/(double) repetitions;
        
        System.out.println("\nMethod\t\t\tNumber of keys n\tAverage time(ms). \tStandard Deviation");
        System.out.println("Populate tree\t\t" + max + "\t\t" + populateAvg + "\t\t" + stdPopulate);
        System.out.println("Remove evens\t\t" + max + "\t\t" + deleteAvg + "\t\t\t" + stdDelete);
    }
}      
    
            



    
