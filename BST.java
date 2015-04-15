public class BST
{
   BST_Node root;
   
   BST()
   {
      root = null;
   }
   
   BST_Node insert(int k)
   {
      BST_Node n = new BST_Node(k);
      BST_Node y = null;
      BST_Node x = root;
      
      while(x!=null)
      {
         y=x;
         if(k == x.key)
         {
            return null; // already exists
         }
         else if(k < x.key)
            x = x.left;
         else
            x = x.right;   
      }
      n.parent = y;
      if(y==null)
         root = n;
      else if(k < y.key)
         y.left = n;
      else
         y.right = n;
      
      return n;    
   }//end insert
   
   BST_Node search(int k)
   {
      BST_Node temp = root;
      while(temp!=null && k != temp.key)
      {
         if(k < temp.key)
            temp = temp.left;
         else
            temp = temp.right;
      }
      
      return temp;
   }//end search
   
   BST_Node min(BST_Node subroot)
   {
      BST_Node temp = subroot;
      while(temp.left != null)
      {
         temp = temp.left;
      }
      return temp;
   }//end find min
   
   BST_Node max(BST_Node subroot)
   {
      BST_Node temp = subroot;
      while(temp.right != null)
         temp = temp.right;
         
      return temp;   
   }//end find max
   
   BST_Node suc(BST_Node x)
   {
      if(x.right!=null)
         return min(x.right);
      
      BST_Node y=x.parent;
      while(y!=null && x == y.right)
      {
         x = y;
         y = y.parent;
      }   
      //if y = null, x has no successor
      return y;
   } //end find successor
   
   BST_Node pred(BST_Node x)
   {
      if(x.left != null)
         return max(x.left);
      BST_Node y = x.parent;
      while(y != null && x == y.left)
      {
         x = y;
         y = y.parent;
      }//y = null, x have no pred   
      return y;
   }//end find pred
   
   void inOrderTrav(BST_Node subroot)
   {
      if(subroot != null)
      {
         inOrderTrav(subroot.left);
         System.out.println(subroot.key);
         inOrderTrav(subroot.right);
      }
   }
   
   void preOrderTrav(BST_Node subroot)
   {
      if(subroot != null)
      {
         System.out.println(subroot.key);
         preOrderTrav(subroot.left);
         preOrderTrav(subroot.right);
      }
   }
   
   void postOrderTrav(BST_Node subroot)
   {
      if(subroot != null)
      {
         postOrderTrav(subroot.left);
         postOrderTrav(subroot.right);
         System.out.println(subroot.key);
      }
   }
   
   void levelOrderTrav(BST_Node subroot)
   {
      arrayDque Q = new arrayDque(20);//num?
      Q.addFirst(subroot);
      
      while(Q.size > 0)
      {
         BST_Node n = Q.removeLast();
         System.out.println(n.key);
         if(n.left != null)
            Q.addFirst(n.left);
         if(n.right != null)
            Q.addFirst(n.right);
      }
   }  //end level order trav
   
   BST_Node delete(int k)
   {
      BST_Node z = search(k);
      if(z != null)
         delete(z);
      return z;   
   }
   
   void transplant(BST_Node oldtree, BST_Node newtree)
   {
      if(oldtree.parent == null)
         root = newtree;
      else if(oldtree == oldtree.parent.left)
         oldtree.parent.left= newtree;
      else
         oldtree.parent.right = newtree;
         
      if(newtree != null)
         newtree.parent = oldtree.parent;         
   }
   
   void delete(BST_Node z)
   {
      if(z.left == null && z.right ==null)
         transplant(z, null);
      else if(z.left == null)
         transplant(z, z.right);
      else if(z.right == null)
         transplant(z, z.left);
      else
      {
         BST_Node y = min(z.right);
         if(y.parent != z)
         {
            transplant(y, y.right);
            y.right=z.right;
            y.right.parent = y;
         }
         transplant(z,y);
         y.left = z.left;
         y.left.parent = y;
      }       
   }
    
}