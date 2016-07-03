/*
 * Name: Sam Li
 * Date: 
 * Description: 
 */

package tree;


public class Node<T extends Comparable<T>> {
    
    private T value;

    public Node getChildL() {
        return childL;
    }

    public Node getChildR() {
        return childR;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
    private Node childL;
    private Node childR;
    
    public Node(T value)
    {
        this.value = value;
        
    }
    public void setChildL(Node childL)
    {
        this.childL = childL;
    }
    
    public void setChildR(Node childR)
    {
        this.childR = childR;
    }
    
    
}
