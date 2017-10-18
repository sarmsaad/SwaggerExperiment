public class LinkList{
  public Node first;
  public Node last;
  public int length = 0;

  public LinkList(Node nd){
    first = nd;
    last = nd;
    length = 1;
  }

  public LinkList(){
    first = null;
    last = null;
  }

  public boolean isEmpty(){
    return first == null;
  }

  public void add(String value){
    Node nx = new Node(value);
    if(length == 0){
      first = nx;
      last = nx;
    }else{
      last.next = nx;
      last = nx;
    }
  }

  public void delete(String value){
    Node temp = first;
    Node prev = first;
    while(temp != null){
      if(temp.data.equals(value)){
        prev.next = temp.next;
      }
      prev = temp;
      temp = temp.next;
    }
  }

  public boolean find(String value){
    Node temp = first;
    while(temp != null){
      if(temp.data.equals(value)){
        return true;
      }
      temp = temp.next;
    }
    return false;
  }

  public int size(){
    return length;
  }
}
