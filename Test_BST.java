import java.util.*;
import java.io.*;
public class Test_BST
{
   public static void main (String [] args) throws FileNotFoundException
   {
      Scanner kb = new Scanner(System.in);
      char choice;  
      int size = 5;//get number of lines in file
      Scanner fin = new Scanner(new File(args [0]));
      int num;
      String name;
      BST bst = new BST(); 
      while(fin.hasNext())
      {
         num = fin.nextInt();
         bst.insert(num); 
         //System.out.println(num); 
      }   
      
      choice = menu();
      //System.out.println("outer" + choice);
      while(choice != 'x')
      {
         if(choice == '1')
         {
            int k; BST_Node t;
            System.out.println("Input the key:");
            k = kb.nextInt();
            t = bst.search(k); 
            if(t == null)
               System.out.println("key doesn't exist");
            else
               System.out.println("key " + t.key + " does exist");   
         }
         else if(choice == '2')
         {
            int k; BST_Node t;
            System.out.println("Input the key:");
            k = kb.nextInt();
            t = bst.insert(k);
            if(t == null)
               System.out.println("key already exist");
            else
               System.out.println("key " + t.key + " was added");
         }
         else if(choice == '3')
         {
            int k; BST_Node t;
            System.out.println("Input the key:");
            k = kb.nextInt();
            t = bst.delete(k);
            if(t == null)
               System.out.println("key didn't exist");
            else
               System.out.println("key " + t.key + " was deleted");
         }
         else if(choice == '4')
         {
            bst.inOrderTrav(bst.root);
         }
         else if(choice == '5')
         {
            bst.preOrderTrav(bst.root);
         }
         else if(choice == '6')
         {
            bst.postOrderTrav(bst.root);
         }
         else if(choice == '7')
         {
            bst.levelOrderTrav(bst.root);
         }
         else if(choice == '8')
         {
            BST_Node small;
            small = bst.min(bst.root);
            if(small == null)
               System.out.println("tree is empty");
            else
               System.out.println(small.key + " is the smallest key");   
         }
         else if(choice == '9')
         {
            BST_Node max;
            max = bst.max(bst.root);
            if(max == null)
               System.out.println("tree is empty");
            else
               System.out.println(max.key + " is the largest key");   
         }
         else if(choice == 'a')
         {
            System.out.println("Enter the key:");
            int k = kb.nextInt();
            BST_Node a = new BST_Node(k);
            a = bst.search(k);
            if(a == null)
               System.out.println("No such key");
            else
            {   
               a = bst.suc(a);
               if(a == null)
               {
                  System.out.println("key found but no successor");
               }   
               else
               {
                  System.out.println(a.key);
               }
            }
         }
         else if(choice == 'b')
         {
            System.out.println("Enter the key:");
            int k = kb.nextInt();
            BST_Node a = new BST_Node(k);
            a = bst.search(k);
            if(a == null)
               System.out.println("No such key");
            else
            {   
               a = bst.pred(a);
               if(a == null)
               {
                  System.out.println("key found but no predecessor");
               }   
               else
               {
                  System.out.println(a.key);
               }
            }
         }
         choice = menu();
      }
      
      
   }//endmain
   
   public static char menu()
{
   Scanner kb = new Scanner(System.in);
   char choice;
      System.out.println("Chose one of the following options");
      System.out.println("1) Search for a key");
      System.out.println("2) Insert a new key");
      System.out.println("3) Delete an existing key");
      System.out.println("4) Inorder traversal");
      System.out.println("5) Preorder traversal");
      System.out.println("6) Postorder traversal");
      System.out.println("7) Level-order traversal");
      System.out.println("8) Find smallest key");
      System.out.println("9) Find largest key");
      System.out.println("a) find the successor of given key");
      System.out.println("b) find predecessor of a given key");
      System.out.println("x) quit");
      choice= kb.nextLine().charAt(0);
     // System.out.println("menu" + choice);
   return choice;
}
   
}

