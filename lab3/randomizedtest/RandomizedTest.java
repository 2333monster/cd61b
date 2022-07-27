package randomizedtest;

import edu.princeton.cs.introcs.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;


public class RandomizedTest {
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> broken = new BuggyAList<>();

        correct.addLast(5);
        correct.addLast(10);
        correct.addLast(15);

        broken.addLast(5);
        broken.addLast(10);
        broken.addLast(15);

        assertEquals(correct.size(), broken.size());

        assertEquals(correct.removeLast(), broken.removeLast());
        assertEquals(correct.removeLast(), broken.removeLast());
        assertEquals(correct.removeLast(), broken.removeLast());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> broken = new BuggyAList<>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0 || operationNumber == 1) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                broken.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
//            } else if (operationNumber == 1) {
//                // size
//                int size = L.size();
//                int size2 = broken.size();
//                System.out.println("size: " + size);


//            } else if(operationNumber == 2 && L.size() != 0){
//                // getLast
//                int val = L. getLast();
//                assertEquals(L.getLast(),broken.getLast());
//                System.out.println("getLast: " + val);
            } else if ((operationNumber == 3  ||  operationNumber == 2)&& L.size() != 0 ) {
                // removeLast
                int val = L.removeLast();
                int brk = (int) broken.removeLast();
                assertEquals(val,brk);
                System.out.println("removeLast(" +val + ")");

            }
        }
    }
}
