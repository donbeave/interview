/*
 *  You are free to use this code anywhere, copy, modify and redistribute at your
 *  own risk.
 *  Your are solely responsibly for any damage that may occur by using this code.
 *
 *  This code is not tested for all boundary conditions. Use it at your own risk.
 *
 *  Original code: http://www.mycstutorials.com/articles/data_structures/stacks
 */
package com.zhokhov.interview.data;

/**
 * @author <a href='mailto:alexey@zhokhov.com'>Alexey Zhokhov</a>
 */
public class Stack {

    private LinkedList list;

    // Stack constructor
    public Stack() {
        // Create a new LinkedList.
        list = new LinkedList();
    }

    public boolean isEmpty()
    // Post: Returns true if the stack is empty. Otherwise, false.
    {
        return (list.size() == 0);
    }

    public void push(Object item)
    // Post: An item is added to the back of the stack.
    {
        // Append the item to the end of our linked list.
        list.add(item);
    }

    public Object pop()
    // Pre: this.isEmpty() == false
    // Post: The item at the front of the stack is returned and
    //         deleted from the stack. Returns null if precondition
    //         not met.
    {
        // Store a reference to the item at the front of the stack
        //   so that it does not get garbage collected when we
        //   remove it from the list.
        // Note: list.get(...) returns null if item not found at
        //   specified index. See postcondition.
        Object item = list.get(list.size());
        // Remove the item from the list.
        // My implementation of the linked list is based on the
        //   J2SE API reference. In both, elements start at 1,
        //   unlike arrays which start at 0.
        list.remove(list.size());
        // Return the item
        return item;
    }

    public Object peek()
    // Pre: this.isEmpty() == false
    // Post: The item at the front of the stack is returned and
    //         deleted from the stack. Returns null if precondition
    //         not met.
    {
        // This method is very similar to pop().
        // See Stack.pop() for comments.
        return list.get(list.size());
    }
}