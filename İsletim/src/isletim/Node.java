package isletim;
class Node {
 Process proses;
 Node next;
 Node prev;

 public Node(Process process) {
     this.proses = process;
 }
 public void delete() {
     // d�g�m bagi kes
     if (prev != null) {
         prev.next = next;
     }
     if (next != null) {
         next.prev = prev;
     }
 }
}