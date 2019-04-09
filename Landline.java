import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Landline extends OldLandline{

    Scanner scan = new Scanner(System.in);

    public Landline(String owner, long number){
        super(owner, number);
    }

    enum MSG_STATUS {READ, UNREAD}

    List<Message> msgList = new ArrayList<Message>();//an Message typed arraylist to store messages

    private class Message{//inner class. Each message comes with a status and a content. I want to keep two
        //data fields only be accessed by Message class
        private MSG_STATUS status;
        private String msg;

        public Message(MSG_STATUS status, String msg){
            this.status = status;
            this.msg = msg;
        }
    }

    @Override
    public void receive(Phone from){////the receiver receives the call from caller
        boolean busy = this.isBusy();//save the value of isBusy to a temp variable, busy
        super.receive(from);//pass the caller to parent class to handle.
        if(busy){//if receiver is busy
            System.out.println("Does " + from.getOwner() + " want to leave a message? [y/n]");
//            String option = scan.nextLine();
            String option = "";
            do{//force user can only enter y or n.
                System.out.println("[y/n] only.");
                option = scan.nextLine();
            }while(!option.equalsIgnoreCase("y") && !option.equalsIgnoreCase("n"));

            if(option.equalsIgnoreCase("y")){//check if caller wants to leave message
                System.out.println("Please leave your message.");
                this.addMessage(scan.nextLine());//pass the message content to addMessage method
                System.out.println(from.getOwner() + " left a message for " + this.getOwner());
            }
        }
    }

    public void addMessage(String message){//save the message to the arraylist, with initial status unread.
        msgList.add(new Message(MSG_STATUS.UNREAD,message));
    }

    //method overloading
    public void readMessages(){//read all messages
        System.out.println("Total " + msgList.size() + " message(s) for " + this.getOwner() + ": ");
        for(Message m : msgList){//iterate all the message arraylist
            System.out.println(m.msg);
        }
        System.out.println();
    }

    public void readMessages(MSG_STATUS status){//read message with certain status

        System.out.println("Phone message for " + this.getOwner() + " with status " + status + ": ");
        for(int i = 0; i < msgList.size(); i++){//iterate through the arraylist
            if(msgList.get(i).status == status){//if item i status is equal to the given status
                System.out.println(msgList.get(i).msg);//print message
                msgList.get(i).status = MSG_STATUS.READ;//set the item i status to read.
            }
        }
        System.out.println();
    }

}
