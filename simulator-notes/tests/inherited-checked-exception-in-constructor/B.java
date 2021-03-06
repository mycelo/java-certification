/*
 * This was presented in Exam Lab simulator.
 *
 * Results: if the no parameter constructor throws an exception, a
 * child class can't omit the constructor. This is because the default
 * constructor generated by the compiler doesn't propagate the exception.
 * Also, a constructor can't try to handle the exception, as tried below.
 * The call to `super()` must be the very first statement in the constructor,
 * not even an `try` clause is allowed.
 */
class A {

    A() throws InterruptedException {
        System.out.println("A");
        Thread.sleep(1000);
        System.out.println("B");
    }
}

public class B extends A implements Runnable {

    public B() {
        try {
            super();
        }
        catch(InterruptedException ex) {}
    }

    public void run() {
        System.out.println("C");
    }

    public static void main(String[] args) {
        try {
            Thread t = new Thread(new B());
            t.start();
        }
        catch(InterruptedException ex) {
            System.out.println("InterruptedException thrown");
        }
    }
}
