import java.util.*;

public class arrayDque
{
   int size, cap, head, tail;
   BST_Node []Q;
   public arrayDque(int c)
   {
      if(c <= 0) return;
      this.cap = c; 
      Q = new BST_Node[c];
      head = tail = -1; 
      size = 0;
   }
   
   public void addFirst(BST_Node i)
   {
      if(size == cap) return;
      if(size == 0)
      {
         Q[0] = i;
         head = tail = 0;    
      }
      else
      {
         head = (head-1+cap)%cap;
         Q[head] = i;
      }
      size++;
   }
   
   public void addLast(BST_Node i)
   {
      if(size == cap) return;
      if(size == 0)
      {
         Q[0] = i;
         head = tail = 0;
      }
      else
      {
         tail = (tail + 1)%cap;
         Q[tail] = i;
      }         
      size++;
   }
   
   public BST_Node removeFirst()
   {
      if(size == 0) return null;
      BST_Node r = Q[head];
      Q[head] = null;
      if(size == 1)
         head = tail = -1;
      else
         head = (head+1)%cap;
      size--;
      return r;
   }
   
   public BST_Node removeLast()
   {
      if(size==0) return null;
      BST_Node r = Q[tail];
      Q[tail] = null;
      if(size == 1)
         head = tail = -1;
      else
         tail = (tail-1+cap)%cap;
      size--;
      return r;     
   }
   
   public void setSize(int c)
   {
      this.size = c;   
   }

}