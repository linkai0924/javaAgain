package object.test;

import org.openjdk.jol.vm.VM;

/**
 * https://segmentfault.com/a/1190000012354736
 * Connected to the target VM, address: '127.0.0.1:64092', transport: 'socket'
 * # WARNING: Unable to attach Serviceability Agent. You can try again with escalated privileges. Two options: a) use -Djol.tryWithSudo=true to try with sudo; b) echo 0 | sudo tee /proc/sys/kernel/yama/ptrace_scope
 * # Running 64-bit HotSpot VM.
 * # Using compressed oop with 3-bit shift.
 * # Using compressed klass with 3-bit shift.
 * # WARNING | Compressed references base/shifts are guessed by the experiment!
 * # WARNING | Therefore, computed addresses are just guesses, and ARE NOT RELIABLE.
 * # WARNING | Make sure to attach Serviceability Agent to get the reliable addresses.
 * # Objects are 8 bytes aligned.
 * # Field sizes by type: 4, 1, 1, 2, 2, 4, 4, 8, 8 [bytes]
 * # Array element sizes: 4, 1, 1, 2, 2, 4, 4, 8, 8 [bytes]
 */
public class ObjectTest {
    public static void main(String[] args) {

        System.out.println(VM.current().details());
    }
}
