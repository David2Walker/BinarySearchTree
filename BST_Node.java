public class BST_Node
{
   int key;
   BST_Node parent;
   BST_Node left;
   BST_Node right;
   
   BST_Node(int k)
   {
      key = k;
      parent = left = right = null;
   }
}