package pair;

import java.util.Stack;

public class StackOperations {

    Stack stack = new Stack();
    public int count() {
        return stack.size();
    }

    public void push(String new_element) {
        stack.push(new_element);
        //throw new RuntimeException("new element is not added");
    }

    public String pop() {
        if(stack.isEmpty()){
            throw new IllegalArgumentException("stack is empty for pop operation");
        }
        String element = (String)stack.pop();
        return element;
    }

    public String peek() {
        return (String) stack.peek();

    }
}
