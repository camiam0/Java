public class PolymorphismExample {

    public static void main(String[] args) {

        Foo[] arr = {new Bar(), new Ni(), new Foo(), new Baz()};
        for(Foo element : arr) {

            System.out.println(element);
            element.method2();
            element.method1();
            System.out.println();

        }

    }

}

class Ni extends Bar {

    public void method2() {System.out.println("ni");}

}

class Foo {

    public void method1() {System.out.println("foo 1");}

    public void method2() {System.out.println("foo 2");}

    public String toString() {return "foo";}

}

class Baz extends Bar {

    public String toString() {return "baz";}

}

class Bar extends Foo {

    public void method1() {System.out.println("bar 1");}

}