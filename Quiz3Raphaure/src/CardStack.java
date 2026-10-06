import java.util.EmptyStackException;

public class CardStack {
    // a basic way to hold the cards in the array by using the memory
    private TheCard[] stack;
    private int top;

    public CardStack(int capacity) {
        stack = new TheCard[capacity];
        top = -1;
    }

    // this adds a new card if it wasn't obvious
    // and if the array is full, it doubles the capacity. so it's quite literally impossible to run out of capacity
    public void push(TheCard card) {
        if (top == stack.length - 1) {
            TheCard[] newStack = new TheCard[stack.length * 2];
            System.arraycopy(stack, 0, newStack, 0, stack.length);
            stack = newStack;
        }

        stack[++top] = card;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    // removes and returns the top card from the stack
    public TheCard pop() {
        if (isEmpty()) {
            // this one only triggers if the stack is empty and sets the old slot to null
            throw new EmptyStackException();
        }

        TheCard poppedCard = stack[top];
        stack[top] = null;
        top--;

        return poppedCard;
    }

    // this is probably appears as "no usages" but it returns the top card
    // without actually deleting it; it also triggers the EmptyStackException if its empty
    // does practically the same thing as TheCard pop() except it's peek()
    public TheCard peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return stack[top];
    }

    public int size() {
        return top + 1;
    }

    public void printStack() {
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }
}