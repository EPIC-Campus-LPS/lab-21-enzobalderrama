import java.util.LinkedList;
import java.util.EmptyStackException;

public class Stac {
    private LinkedList list;

    /**
     * Standard declaration for LinkedList. I used the official notation stuff for this lab
     */
    public <E> Stac(){
        list = new LinkedList();
    }

    /**
     * Meant to put in a new element at the very top of the stack (end of the list)
     * @param element that is up to user
     */
    public void push(int element){
        list.add(element);
    }

    /**
     * Makes sure list is not null and pops top plate/last in list
     * @return int of the popped out plate.
     */
    public int pop(){
        if (list.isEmpty()){
            throw new EmptyStackException();
        }
        return (int)(list.removeLast());
    }

    /**
     * Checks if list is empty, looks but not pops the...
     * @return int of last in list
     */
    public int peek(){
        if (list.isEmpty()){
            throw new EmptyStackException();
        }
        return (int) list.peekLast();
    }

    /**
     * @return size of list
     */
    public int size(){
        return list.size();
    }

    /**
     * Checks if list is empty by checking the size of the array
     * @return true if empty, false if not
     */
    public boolean isEmpty(){
        if (list.size() == 0){
            return true;
        }
        return false;
    }



}
