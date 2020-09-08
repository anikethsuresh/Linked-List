public class Table{
    private Node head;
    private Node mark;
    private Node last;

    public Table(Node head, Node mark, Node last){
        this.head = head;
        this.mark = mark;
        this.last = last;
    }

    public boolean insert(String key, String value){//insert method
        Node newNode = new Node(key, value);
        if(isEmpty()){
            head = newNode;
            last = head;
            mark = head;
            //System.out.println("init" + mark.getValue());
            return true;
        }else{
            last.setNext(newNode);
            last = newNode;
            return false;
        }
    }

    public String lookUp(String key){//look up method
        markToStart();
        while(keyAtMark().equals(key)==false){
            advanceMark();
            if(mark == null){
                return null;
            }
        } 
        return mark.getValue();
    }

    public boolean delete(String key){//delete method
        markToStart();
        if(head.getKey().equals(key)){
            head = head.getNext();
            mark = head;
            return true;
        }
        while(mark.getNext()!=null){
            /* if(mark.getNext().equals(last)){
                last = mark;
                mark.setNext(null);
                return true;
            }else  */
            if(mark.getNext().getKey().equals(key)){
                if(mark.getNext().equals(last)){
                    last = mark;
                    mark.setNext(null);
                    return true;
                }
                mark.setNext(mark.getNext().getNext());
                return true;
            }
            advanceMark();
        }
        return false;
    }

    public boolean update(String key, String value){//update method
        markToStart();
        if(lookUp(key) == null){
            return false;
        }
        while(mark.getKey().equals(key)==false){
            mark = mark.getNext();
        }
        mark.setValue(value);
        return true;
    }

    public int displayAll(){//display method
        int count = 0; 
        markToStart();
        while(mark!=null){
            count++;
            System.out.println("Name:" + mark.getKey());
            System.out.println("Address:" + mark.getValue() + "\n");
            advanceMark();
        }
        return count;
    }

    public boolean markToStart(){
        if(isEmpty()){
            return false;
        }
        mark = head;
        //System.out.println("mark at " + keyAtMark());
        return true;    
    }

    public boolean advanceMark(){
        if(isEmpty()){
            return false;
        }
        mark = mark.getNext();
        return true;
    }

    public String keyAtMark(){
        return mark.getKey();
    }

    private boolean isEmpty(){
        return(head == null);
    }

}