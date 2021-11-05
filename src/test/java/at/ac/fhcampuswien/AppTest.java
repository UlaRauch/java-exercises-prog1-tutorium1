package at.ac.fhcampuswien;

import ac.at.fhcampuswien.App;
import org.junit.jupiter.api.*;

import java.io.*;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

@Timeout(2)
public class AppTest {

    private PrintStream originalOut;
    private InputStream originalIn;
    private ByteArrayOutputStream bos;
    private PrintStream ps;

    @BeforeAll
    public static void init(){
        System.out.println("Testing Midterm");
    }

    @AfterAll
    public static void finish(){
        System.out.println("Finished Testing Midterm");
    }

    @BeforeEach
    public void setupStreams() throws IOException {
        originalOut = System.out;
        originalIn = System.in;

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        PipedOutputStream pos = new PipedOutputStream();
        PipedInputStream pis = new PipedInputStream(pos);
        System.setIn(pis);
        ps = new PrintStream(pos, true);
    }

    @AfterEach
    public void tearDownStreams() {
        // undo the binding in System
        System.setOut(originalOut);
        System.setIn(originalIn);
    }



    @Test
    public void sumUp1()
    {
        ps.println(1);
        ps.println(1);

        String output = "n1: " + System.lineSeparator() +
                "n2: " + System.lineSeparator() +
                "Sum: 1" + System.lineSeparator();

        try {
            //invoke method
            Method method = App.class.getMethod("sumUp");
            method.invoke(null);
            // assertion
            assertEquals(output, bos.toString());
        } catch (NoSuchMethodException nsme) {
            fail("Method sumUp doesn't exist");
        } catch (Exception e) {
            e.printStackTrace();
            fail("Some other problems have occurred.");
        }
    }


    @Test
    public void sumUp2()
    {
        ps.println(1);
        ps.println(4);

        String output = "n1: " + System.lineSeparator() +
                "n2: " + System.lineSeparator() +
                "Sum: 10" + System.lineSeparator();

        try {
            //invoke method
            Method method = App.class.getMethod("sumUp");
            method.invoke(null);
            // assertion
            assertEquals(output, bos.toString());
        } catch (NoSuchMethodException nsme) {
            fail("Method sumUp doesn't exist");
        } catch (Exception e) {
            e.printStackTrace();
            fail("Some other problems have occurred.");
        }
    }

    @Test
    public void sumUp3()
    {
        ps.println(4);
        ps.println(2);

        String output = "n1: " + System.lineSeparator() +
                "n2: " + System.lineSeparator() +
                "n2 must be > n1." + System.lineSeparator();

        try {
            //invoke method
            Method method = App.class.getMethod("sumUp");
            method.invoke(null);
            // assertion
            assertEquals(output, bos.toString());
        } catch (NoSuchMethodException nsme) {
            fail("Method sumUp doesn't exist");
        } catch (Exception e) {
            e.printStackTrace();
            fail("Some other problems have occurred.");
        }
    }

    @Test
    public void sumUp4()
    {
        ps.println(4);
        ps.println(-1);

        String output = "n1: " + System.lineSeparator() +
                "n2: " + System.lineSeparator() +
                "n2 must be > 0." + System.lineSeparator();
        try {
            //invoke method
            Method method = App.class.getMethod("sumUp");
            method.invoke(null);
            // assertion
            assertEquals(output, bos.toString());
        } catch (NoSuchMethodException nsme) {
            fail("Method sumUp doesn't exist");
        } catch (Exception e) {
            e.printStackTrace();
            fail("Some other problems have occurred.");
        }
    }

    @Test
    public void sumUp5()
    {
        ps.println(-5);
        ps.println(3);

        String output = "n1: " + System.lineSeparator() +
                "n2: " + System.lineSeparator() +
                "n1 must be > 0." + System.lineSeparator();
        try {
            //invoke method
            Method method = App.class.getMethod("sumUp");
            method.invoke(null);
            // assertion
            assertEquals(output, bos.toString());
        } catch (NoSuchMethodException nsme) {
            fail("Method sumUp doesn't exist");
        } catch (Exception e) {
            e.printStackTrace();
            fail("Some other problems have occurred.");
        }
    }

    @Test
    public void sumUp6()
    {
        ps.println(0);
        ps.println(-3);

        String output = "n1: " + System.lineSeparator() +
                "n2: " + System.lineSeparator() +
                "n1 and n2 must be > 0." + System.lineSeparator();

        try {
            //invoke method
            Method method = App.class.getMethod("sumUp");
            method.invoke(null);
            // assertion
            assertEquals(output, bos.toString());
        } catch (NoSuchMethodException nsme) {
            fail("Method sumUp doesn't exist");
        } catch (Exception e) {
            e.printStackTrace();
            fail("Some other problems have occurred.");
        }
    }

    @Test
    public void sumUp7()
    {
        ps.println(5);
        ps.println(10);

        String output = "n1: " + System.lineSeparator() +
                "n2: " + System.lineSeparator() +
                "Sum: 45" + System.lineSeparator();

        try {
            //invoke method
            Method method = App.class.getMethod("sumUp");
            method.invoke(null);
            // assertion
            assertEquals(output, bos.toString());
        } catch (NoSuchMethodException nsme) {
            fail("Method sumUp doesn't exist");
        } catch (Exception e) {
            e.printStackTrace();
            fail("Some other problems have occurred.");
        }
    }

    @Test
    public void compareNumbers1(){
        try {
            //get method
            Method method = App.class.getMethod("compareNumbers", int.class, int.class);
            //assert
            assertEquals(0, method.invoke(null, 6,6));
        } catch (NoSuchMethodException nsme) {
            fail("Method compareNumbers doesn't exist");
        } catch (Exception e) {
            e.printStackTrace();
            fail("Some other problems have occurred.");
        }
    }

    @Test
    public void compareNumbers2(){
        //assertEquals(App.compareNumbers(6, 12), 6);
        try {
            //get method
            Method method = App.class.getMethod("compareNumbers", int.class, int.class);
            //assert
            assertEquals(6, method.invoke(null, 6,12));
        } catch (NoSuchMethodException nsme) {
            fail("Method compareNumbers doesn't exist");
        } catch (Exception e) {
            e.printStackTrace();
            fail("Some other problems have occurred.");
        }
    }

    @Test
    public void compareNumbers3(){
        //assertEquals(App.compareNumbers(5, 3), 5);
        try {
            //get method
            Method method = App.class.getMethod("compareNumbers", int.class, int.class);
            //assert
            assertEquals(5, method.invoke(null, 5,3));
        } catch (NoSuchMethodException nsme) {
            fail("Method compareNumbers doesn't exist");
        } catch (Exception e) {
            e.printStackTrace();
            fail("Some other problems have occurred.");
        }
    }

    @Test
    public void compareNumbers4(){
        //assertEquals(App.compareNumbers(3, 7), 7);
        try {
            //get method
            Method method = App.class.getMethod("compareNumbers", int.class, int.class);
            //assert
            assertEquals(7, method.invoke(null, 3,7));
        } catch (NoSuchMethodException nsme) {
            fail("Method compareNumbers doesn't exist");
        } catch (Exception e) {
            e.printStackTrace();
            fail("Some other problems have occurred.");
        }
    }


    @Test
    public void digitSum1(){
        ps.println(42);
        String output = "Enter number: " + System.lineSeparator() +
                "Sum of digits: 6" + System.lineSeparator();

        try {
            //invoke method
            Method method = App.class.getMethod("digitSum");
            method.invoke(null);
            // assertion
            assertEquals(output, bos.toString());
        } catch (NoSuchMethodException nsme) {
            fail("Method digitSum doesn't exist");
        } catch (Exception e) {
            e.printStackTrace();
            fail("Some other problems have occurred.");
        }
    }

    @Test
    public void digitSum2(){
        ps.println(-1);
        String output = "Enter number: " + System.lineSeparator() +
                "Invalid number." + System.lineSeparator();

        try {
            //invoke method
            Method method = App.class.getMethod("digitSum");
            method.invoke(null);
            // assertion
            assertEquals(output, bos.toString());
        } catch (NoSuchMethodException nsme) {
            fail("Method digitSum doesn't exist");
        } catch (Exception e) {
            e.printStackTrace();
            fail("Some other problems have occurred.");
        }
    }

    @Test
    public void digitSum3(){
        ps.println(4399);
        String output = "Enter number: " + System.lineSeparator() +
                "Invalid number." + System.lineSeparator();

        try {
            //invoke method
            Method method = App.class.getMethod("digitSum");
            method.invoke(null);
            // assertion
            assertEquals(output, bos.toString());
        } catch (NoSuchMethodException nsme) {
            fail("Method digitSum doesn't exist");
        } catch (Exception e) {
            e.printStackTrace();
            fail("Some other problems have occurred.");
        }
    }

    @Test
    public void digitSum4(){
        ps.println(328);
        String output = "Enter number: " + System.lineSeparator() +
                "Sum of digits: 13" + System.lineSeparator();

        try {
            //invoke method
            Method method = App.class.getMethod("digitSum");
            method.invoke(null);
            // assertion
            assertEquals(output, bos.toString());
        } catch (NoSuchMethodException nsme) {
            fail("Method digitSum doesn't exist");
        } catch (Exception e) {
            e.printStackTrace();
            fail("Some other problems have occurred.");
        }
    }

    @Test
    public void digitSum5(){
        ps.println(0);
        String output = "Enter number: " + System.lineSeparator() +
                "Sum of digits: 0" + System.lineSeparator();

        try {
            //invoke method
            Method method = App.class.getMethod("digitSum");
            method.invoke(null);
            // assertion
            assertEquals(output, bos.toString());
        } catch (NoSuchMethodException nsme) {
            fail("Method digitSum doesn't exist");
        } catch (Exception e) {
            e.printStackTrace();
            fail("Some other problems have occurred.");
        }
    }

    @Test
    public void digitSum6(){
        ps.println(3);
        String output = "Enter number: " + System.lineSeparator() +
                "Sum of digits: 3" + System.lineSeparator();

        try {
            //invoke method
            Method method = App.class.getMethod("digitSum");
            method.invoke(null);
            // assertion
            assertEquals(output, bos.toString());
        } catch (NoSuchMethodException nsme) {
            fail("Method digitSum doesn't exist");
        } catch (Exception e) {
            e.printStackTrace();
            fail("Some other problems have occurred.");
        }
    }


    @Test
    public void printTriangle1(){
        String output = "* " + System.lineSeparator() +
                "* * "  + System.lineSeparator() +
                "* * * "  + System.lineSeparator() +
                "* * * * "  + System.lineSeparator() +
                "* * * * * "  + System.lineSeparator() +
                "* * * * * * "  + System.lineSeparator() +
                "* * * * * * * "  + System.lineSeparator();

        try {
            //invoke method
            Method method = App.class.getMethod("printTriangle", int.class);
            method.invoke(null, 7);
            //assert
            assertEquals(output, bos.toString());
        } catch (NoSuchMethodException nsme) {
            fail("Method printTriangle doesn't exist");
        } catch (Exception e) {
            e.printStackTrace();
            fail("Some other problems have occurred.");
        }
    }

    @Test
    public void printTriangle2(){
        String output = "";

        try {
            //invoke method
            Method method = App.class.getMethod("printTriangle", int.class);
            method.invoke(null, 0);
            //assert
            assertEquals(output, bos.toString());
        } catch (NoSuchMethodException nsme) {
            fail("Method printTriangle doesn't exist");
        } catch (Exception e) {
            e.printStackTrace();
            fail("Some other problems have occurred.");
        }
    }

    @Test
    public void printTriangle3(){
        String output = "Rows cannot be negative."  + System.lineSeparator();

        try {
            //invoke method
            Method method = App.class.getMethod("printTriangle", int.class);
            method.invoke(null, -2);
            //assert
            assertEquals(output, bos.toString());
        } catch (NoSuchMethodException nsme) {
            fail("Method printTriangle doesn't exist");
        } catch (Exception e) {
            e.printStackTrace();
            fail("Some other problems have occurred.");
        }
    }


    @Test
    public void incomeStatistics1(){
        ps.println(100);
        ps.println(200);
        ps.println(0);

        String output = "1. Income: " + System.lineSeparator() +
                "2. Income: " + System.lineSeparator() +
                "3. Income: " + System.lineSeparator() +
                "Average income: 150.00 Sum: 300.00 Count: 2" + System.lineSeparator();
        try {
            //invoke method
            Method method = App.class.getMethod("incomeStatistics");
            method.invoke(null);
            // assertion
            assertEquals(output, bos.toString());
        } catch (NoSuchMethodException nsme) {
            fail("Method incomeStatistics doesn't exist");
        } catch (Exception e) {
            e.printStackTrace();
            fail("Some other problems have occurred.");
        }
    }

    @Test
    public void incomeStatistics2(){
        ps.println(-1);
        ps.println(-5);
        ps.println(0);

        String output = "1. Income: " + System.lineSeparator() +
                "Invalid" + System.lineSeparator() +
                "1. Income: " + System.lineSeparator() +
                "Invalid" + System.lineSeparator() +
                "1. Income: " + System.lineSeparator() +
                "No valid income entered." + System.lineSeparator();

        try {
            //invoke method
            Method method = App.class.getMethod("incomeStatistics");
            method.invoke(null);
            // assertion
            assertEquals(output, bos.toString());
        } catch (NoSuchMethodException nsme) {
            fail("Method incomeStatistics doesn't exist");
        } catch (Exception e) {
            e.printStackTrace();
            fail("Some other problems have occurred.");
        }
    }

    @Test
    public void incomeStatistics3(){
        ps.println(-1);
        ps.println(100);
        ps.println(-100);
        ps.println(0);

        String output = "1. Income: " + System.lineSeparator() +
                "Invalid" + System.lineSeparator() +
                "1. Income: " + System.lineSeparator() +
                "2. Income: " + System.lineSeparator() +
                "Invalid" + System.lineSeparator() +
                "2. Income: " + System.lineSeparator() +
                "Average income: 100.00 Sum: 100.00 Count: 1" + System.lineSeparator();

        try {
            //invoke method
            Method method = App.class.getMethod("incomeStatistics");
            method.invoke(null);
            // assertion
            assertEquals(output, bos.toString());
        } catch (NoSuchMethodException nsme) {
            fail("Method incomeStatistics doesn't exist");
        } catch (Exception e) {
            e.printStackTrace();
            fail("Some other problems have occurred.");
        }
    }

    @Test
    public void incomeStatistics4(){
        ps.println(0);

        String output = "1. Income: " + System.lineSeparator() +
                "No valid income entered." + System.lineSeparator();

        try {
            //invoke method
            Method method = App.class.getMethod("incomeStatistics");
            method.invoke(null);
            // assertion
            assertEquals(output, bos.toString());
        } catch (NoSuchMethodException nsme) {
            fail("Method incomeStatistics doesn't exist");
        } catch (Exception e) {
            e.printStackTrace();
            fail("Some other problems have occurred.");
        }
    }

    @Test
    public void incomeStatistics5(){
        ps.println(119);
        ps.println(234);
        ps.println(59);
        ps.println(0);

        String output = "1. Income: " + System.lineSeparator() +
                "2. Income: " + System.lineSeparator() +
                "3. Income: " + System.lineSeparator() +
                "4. Income: " + System.lineSeparator() +
                "Average income: 137.33 Sum: 412.00 Count: 3" + System.lineSeparator();

        try {
            //invoke method
            Method method = App.class.getMethod("incomeStatistics");
            method.invoke(null);
            // assertion
            assertEquals(output, bos.toString());
        } catch (NoSuchMethodException nsme) {
            fail("Method incomeStatistics doesn't exist");
        } catch (Exception e) {
            e.printStackTrace();
            fail("Some other problems have occurred.");
        }
    }
    @Test
    public void weekdays1(){
        try {
            //get method
            Method method = App.class.getMethod("weekdays", int.class);
            //assertion
            assertEquals(method.invoke(null, 6), "Saturday");
        } catch (NoSuchMethodException nsme) {
            fail("Method weekdays doesn't exist");
        } catch (Exception e) {
            e.printStackTrace();
            fail("Some other problems have occurred.");
        }

    }

    @Test
    public void weekdays2(){
        try {
            //get method
            Method method = App.class.getMethod("weekdays", int.class);
            //assertion
           assertEquals(method.invoke(null, 0), "Invalid day.");
        } catch (NoSuchMethodException nsme) {
            fail("Method weekdays doesn't exist");
        } catch (Exception e) {
            e.printStackTrace();
            fail("Some other problems have occurred.");
        }


    }

    @Test
    public void weekdays3(){
        //ps.println(1);
        try {
            //get method
            Method method = App.class.getMethod("weekdays", int.class);
            //assertion
            assertEquals("Monday", method.invoke(null, 1));
        } catch (NoSuchMethodException nsme) {
            fail("Method weekdays doesn't exist");
        } catch (Exception e) {
            e.printStackTrace();
            fail("Some other problems have occurred.");
        }
    }

    @Test
    public void weekdays4(){
        //assertEquals(App.weekdays(9), "Invalid day.");
        //ps.println(9);
        try {
            //invoke method
            Method method = App.class.getMethod("weekdays", int.class);
            //assertion
            assertEquals("Invalid day.", method.invoke(null, 9));
        } catch (NoSuchMethodException nsme) {
            fail("Method weekdays doesn't exist");
        } catch (Exception e) {
            e.printStackTrace();
            fail("Some other problems have occurred.");
        }
    }

}
