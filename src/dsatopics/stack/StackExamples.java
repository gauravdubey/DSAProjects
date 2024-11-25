package dsatopics.stack;

import java.util.Stack;

public class StackExamples {

    public static void main(String[] args) {

        String parenthesisStr="{()}";
//        System.out.println("Is Parenthesis Equal : "+isParenthesisEqual(parenthesisStr));
        /*Stack<Integer>stack=new Stack<>();
        stack.push(4);
        stack.push(14);
        stack.push(24);
        stack.push(23);
//        insertAtBottom(stack,20);
        reverseStack(stack);
        System.out.println("Reverse stack : ");
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }*/

//        String redundantBracketStr="((a+b))";
//        System.out.println("Is Redundant Bracket : "+isRedundantBracket(redundantBracketStr));

        Stack<Integer>stack=new Stack<>();
        stack.push(4);
        stack.push(10);
        stack.push(8);
        stack.push(12);
        stack.push(6);
        sortStack(stack);
        System.out.println("Sorted stack : ");
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }


    /**
     * Check the parenthesis is equal or not
     * @param str
     * @return
     */
    private static boolean isParenthesisEqual(String str){
        Stack<Character>stackChar=new Stack<>();

        for(int i=0; i<str.length(); i++){
            char c= str.charAt(i);
            if (c=='(' || c=='{' || c=='['){
                stackChar.push(c);
            }else if (c==')' || c=='}' || c==']'){
                if (stackChar.isEmpty()){
                    return false;
                }
                char top=stackChar.pop();
                if (!isMatchingPair(top,c))
                    return false;
            }
        }
        return stackChar.isEmpty();
    }

    public static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }


    /**
     * Insert the element at its bottom
     *
     * @param stack
     * @param item
     */
    private static void insertAtBottom(Stack<Integer> stack, int item) {
        insertItem(stack,item);
    }

    private static void insertItem(Stack<Integer> stack, int item){
        if(stack.isEmpty()){
            stack.push(item);
        }else{
            int top=stack.pop();
            insertItem(stack,item);
            stack.push(top);
        }
    }

    /**
     * Reverse the stack
     * @param stack
     */
    private static void reverseStack(Stack<Integer> stack){
        if (!stack.isEmpty()){
            int top=stack.pop();
            reverseStack(stack);
            insertAtBottom(stack,top);
        }
    }

    /**
     * Insert the element in sorted order
     * @param stack
     */
    private static void sortStack(Stack<Integer>stack){
        if (!stack.isEmpty()){
            int top=stack.pop();
            sortStack(stack);
            insertSorted(stack,top);
        }
    }

    /**
     * insert the element in sorted order
     * @param stack
     * @param top
     */
    private static void insertSorted(Stack<Integer> stack, int top) {
        if (stack.isEmpty() || stack.peek()<=top){
            stack.push(top);
        }else{
            int temp=stack.pop();
            insertSorted(stack,top);
            stack.push(temp);
        }
    }


    /**
     * Check the bracket is redundant or not
     * @param str
     * @return
     */
    private static boolean isRedundantBracket(String str){
        Stack<Character>stack=new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c=str.charAt(i);
            if (c=='(' || c=='+' || c=='-' || c=='*' || c=='/'){
                stack.push(c);
            }else {
                if (c==')'){
                    boolean redundant=true;
                    while (stack.peek()!='('){
                        char top=stack.peek();
                        if (top=='+' || top=='-' || top=='*' || top=='/'){
                            redundant=false;
                        }
                        stack.pop();
                    }
                    if (redundant){
                        return true;
                    }
                    stack.pop();
                }
            }
        }
        return false;
    }

}
