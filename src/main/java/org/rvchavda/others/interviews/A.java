package org.rvchavda.test;


/**
 * Orcl
 */
public abstract class A {
  public static int x=19;
  A() {
    System.out.println("Hello from A");
  }
  abstract public void doSomething();

}

class B extends A {
  B() {
    System.out.println("Hello from B");
  }
  @Override
  public void doSomething() {
    System.out.println("X = "+x);
  }

  public static void main(String[] args) {
    A a = new B();
    System.out.println("a.x"+a.x);
    System.out.println(A.x);
    System.out.println(x);

    String d = "a";
    String f = "a";
    System.out.println(d == f);
    System.out.println(d.equals(f));

    String g = new String("a");
    String h = new String("a");
    System.out.println(g==h);
    System.out.println(g.equals(h));
  }
}
