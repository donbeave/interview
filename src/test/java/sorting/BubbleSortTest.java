package sorting;

import com.zhokhov.interview.sorting.BubbleSort;
import com.zhokhov.interview.util.Console;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


@RunWith(JUnit4.class)
public class BubbleSortTest extends TestCase {


    private static int[] array;


    @Test
    public void bubbleSortIntegerArray(){
        array = new int[]{12, 2, 8, 5, 1, 6, 4, 15};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(array);
        Console.__red("Index 1 is value in this array => " + array[1]);
        assertEquals(2, array[1]);
    }

    @Test
    public void checkLengthAfterUsingBubbleSort(){
        array = new int[]{12, 2, 8, 5, 1, 6, 4, 15};
        int lengthBeforeSort = array.length;
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(array);
        int lengthAfterSort = array.length;
        assertEquals(lengthBeforeSort, lengthAfterSort);
    }


}