/*
 * Name: Sam Li
 * Date: 
 * Description: 
 */

package tree;

import java.util.ArrayList;

/**
 *
 * @author Jihongli
 * @param <T>
 */
public class Tree<T extends Comparable<T>> {
    
    
    public Node<T> root;
    
    public Tree()
    {
        root = null;
    }
    
    public Tree(T value)
    {
        
        root = new Node<>(value);
    }
    
    public void add(T value,Node<T> placeIn)
    {
    	if(this.root == null)
    	{
    		this.root = new Node<T>(value);
    	}
    	else
    	{
            int compare;
            compare = ((Comparable<T>)value).compareTo(placeIn.getValue());
            if(compare == 0)
            {
                return;
            }
            else if(compare<0)
            {
                if(placeIn.getChildL()!=null)
                {
                    add(value, placeIn.getChildL());
                }
                else
                {
                    placeIn.setChildL(new Node<>(value));
                }
            }
            else
            {
                if(placeIn.getChildR()!=null)
                {
                    add(value, placeIn.getChildR());
                }
                else
                {
                    placeIn.setChildR(new Node<>(value));
                }
            }
    	}

    }
    
    public void addFromArray(T[] array)
    {
        for(T object : array)
        {
            this.add(object, this.root);
        }
    }
    
    public void printTree(Node<T> toBePrinted)
    {
        System.out.print(" "+ toBePrinted.getValue() + " {");
        if(toBePrinted.getChildL()!=null)
        {
            printTree(toBePrinted.getChildL());
        }
        System.out.print(", ");
        if(toBePrinted.getChildR()!=null)
        {
            printTree(toBePrinted.getChildR());
        }
        System.out.print("} ");
    }
    
    public void addFromArray(ArrayList<T> array)
    {
        for(T object : array)
        {
            this.add(object, this.root);
        }
    }



}
