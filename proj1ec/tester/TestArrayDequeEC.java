package tester;

import static org.junit.Assert.*;

import edu.princeton.cs.introcs.StdRandom;
import org.junit.Test;
import student.StudentArrayDeque;

public class TestArrayDequeEC {
    @Test
    public void testRandomized(){
        ArrayDequeSolution<Integer> correct = new ArrayDequeSolution<>();
        StudentArrayDeque<Integer> incorrect = new StudentArrayDeque<>();
        int N = 500;
        for(int i = 0; i < N; i++){
            int operationNumbers = StdRandom.uniform(0,4);
            if(operationNumbers == 0){
                Integer var = StdRandom.uniform(0,100);
                correct.addFirst(var);
                incorrect.addFirst(var);
                System.out.println("addFirst(" + var + ")");
            } else if (operationNumbers == 1) {
                Integer var = StdRandom.uniform(0,100);
                correct.addLast(var);
                incorrect.addLast(var);
                System.out.println("addLast(" + ")");
            } else if (operationNumbers == 2 && correct.size() != 0) {
                Integer item1 = correct.removeFirst();
                Integer item2 = incorrect.removeFirst();
                assertEquals("removeFirst",item1,item2);
                System.out.println("removeFirst(" + item1 + ")");
            } else if (operationNumbers == 3 && correct.size() != 0) {
                Integer item1 = correct.removeLast();
                Integer item2 = incorrect.removeLast();
                assertEquals("removeLast",item1,item2);
                System.out.println("removeLast(" + item1 + ")");
            }
        }
    }
}
