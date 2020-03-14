package object.test;

import org.openjdk.jol.vm.VM;

public class ObjectTest {
    public static void main(String[] args) {
        System.out.println(VM.current().details());
    }
}
