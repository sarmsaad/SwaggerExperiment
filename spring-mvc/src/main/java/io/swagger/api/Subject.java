public class Subject{
  public String ID;
  public LinkList list;

  public Subject(){
    String = 000;
    list = new LinkList();
  }

  public Subject(String subjectID){
    ID = subjectID;
    list = new LinkList();
  }

  public void addItem(String item){
    list.add(item);
  }

  public void deleteItem(String item){
    list.delete(item);
  }

}
