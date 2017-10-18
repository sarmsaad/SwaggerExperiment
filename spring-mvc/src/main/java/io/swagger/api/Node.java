public class Node{
  public String data;
  public Node next;

  public Node(String dt, Node nxt){
    data = dt;
    next = nxt;
  }

  public Node(String dt){
    data = dt;
    next = null;
  }

}
