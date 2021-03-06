package step18.ex2;

public class Exam04 {
    static class A {
        static class B {} // static nested class
        class C {} // non-static nested class = inner class
        public void m() {
            class D {} // local class
        }
        public void m2() {
            Object obj = new Object() {}; // anonymous class
        }
        public static class E {}
        public class F {}
        private class G {}
        protected class H {}
    }
    
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("step18.ex2.Exam04$A");
        
        Class[] nestedList = clazz.getDeclaredClasses();
        for(Class nested : nestedList) {
            System.out.println(nested.getName());
        }
    }
}
