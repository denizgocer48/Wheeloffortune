public class SingleLinkedList {
    Node head;
    
    
    
    public void add(Object data) {

        if(head == null) {
            Node newNode = new Node(data);
            head = newNode;}
        else {
            Node temp = head;
            while(temp.getLink() != null) {
                temp = temp.getLink();}
            Node newNode = new Node(data);
            temp.setLink(newNode);}
   }

    
    public  int size() {

        if(head == null) return 0;
        else {
            int count = 0;
            Node temp = head;

            while(temp!= null) {
                temp = temp.getLink();
                count++;
                }
            return count;
            }
    }
    public void changes(int index,Object data) {
        if (index == 0) {
            head = head.getLink();
            Node newNode = new Node(data);
            newNode.setLink(head);
            head=newNode;           
        }
        else {
            Node temp = head;
            Node previous = null;
            for (int i = 0; i < index; i++) {
                previous = temp;
                temp = temp.getLink();
            }
            previous.setLink(temp.getLink());
            Node newNode = new Node(data);
            newNode.setLink(temp.getLink());           
            previous.setLink(newNode);
        }
    }
    public void change(int index,Object data) {
        if (head==null) {
            Node newNode = new Node(data);
            head = newNode;
        }
        else {
            Node temp=head;
            Node previous = null;
            if (index == 0) {
                head = head.getLink();
                Node newNode = new Node(data);
                newNode.setLink(head);
                head=newNode;
            }
            else {
                for (int i = 0; i < index; i++) {
                    previous = temp;
                    temp = temp.getLink();
                }
                Node newNode = new Node(data);
                previous.setLink(newNode);
                newNode.setLink(temp.getLink());
            }
        }
    }
    public void display() {
        if(head == null) System.out.println("List is empty!");
        else {
            Node temp = head;

            while(temp != null) {
                System.out.print(temp.getData() + " ");
                temp = temp.getLink();}
        }
    }
    

    public void delete(Object dataToDelete) {
        if(head == null) System.out.println("LinkedList is empty!");
        else {        	
            while(head.getData() == dataToDelete) {
            	head = head.getLink();
            	if(head==null) {
            		break;
            	}
            }

            Node temp = head;
            Node previous = null;

            
            
            while(temp != null) {
                if(temp.getData() == dataToDelete) {
                    previous.setLink(temp.getLink());
                    temp = previous;}

                previous = temp;
                temp = temp.getLink();}
        }
        
    }
    
    public Object random(int number) {//indexteki datayý bulma
    	Node temp = head;
    	for(int i =0 ; i<number;i++) {
    		if(temp.getLink()!=null) {
    			temp = temp.getLink();
    		}   		
    	}
    	return temp.getData();
    }

    public Object search(char letter) { 
    	if(head == null){
    		 System.out.println("LinkedList is empty!");
    		return null;   		
    	}   		
    	else {  		
    		Node temp = head;
        	while (temp != null) {  		
        		if (letter == (char)temp.getData()) {
        			break;	
        		}  
        		temp = temp.getLink();   		       		      		
        	}		     	
        	return temp.getData(); 
    	}    	
    }


    public Boolean search1(char letter,int t) { 
    	boolean flag=false;
    	if(head == null){
    		 System.out.println("LinkedList is empty!");
    		return null;   		
    	}   		
    	else {  		
    		Node temp = head;
        	int y =1;
        	while (temp != null && y<=t) {  		
        		if (letter == (char)temp.getData()) {
        			flag=true;
        			break;	
        		}  
        		temp = temp.getLink();   		 
        		y++;       		
        	}		     	
        	return flag; 
    	} 
    	
    }         
}