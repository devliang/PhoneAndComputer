import java.util.Set;
import java.util.HashSet;

public class SmartPhone extends Landline implements Computer{

    // enum State {ON, OFF}

    private State state;//create a State typed object, state

    Set<String> gameSet = new HashSet<>();//create a hash set to save games. Because each game is unique in the set

    private int screenSize;
    private int ram;
    private int processorSpeeed;

    public SmartPhone(String owner, long number, int screenSize, int ram, int processorSpeeed){
        super(owner, number);
        this.screenSize = screenSize;
        this.ram = ram;
        this.processorSpeeed = processorSpeeed;
    }

    @Override
    public int getScreenSize(){
        return screenSize;
    }

    @Override
    public int getRAM(){
        return ram;
    }

    @Override
    public int getProcessorSpeeed(){
        return processorSpeeed;
    }

    @Override
    public void call(Phone phone){
        if(state == State.ON){//if state is on
            super.call(phone);
        }else{//if state is off
            System.out.println("Smart phone is off. Turn it on first.");
        }

    }

    @Override
    public void receive(Phone from){
        if(state == State.ON){//if state is on
            super.receive(from);
        }else{//if state is off
            System.out.println("The receiver's phone is off.");
        }
    }

    //method overloading
    public void readMessages(){
        if(state == State.ON){//if state is on
            super.readMessages();
        }else{//if state is off
            System.out.println("Smart phone is off. Turn it on first.");
        }
    }

    @Override
    public void readMessages(MSG_STATUS status){
        if(state == State.ON){//if state is on
            super.readMessages(status);
        }else{//if state is off
            System.out.println("Smart phone is off. Turn it on first.");
        }
    }

    @Override
    public State getState(){
        return state;
    }

    @Override
    public void setState(String to){//set the state to ON or OFF
        to = to.toLowerCase();//to be easy, make it to lower case, then do string compare
        if(to.compareTo("on") == 0){
            state = State.ON;
        }else if(to.compareTo("off") == 0){
            state = State.OFF;
        }else{
            throw new IllegalArgumentException("State must be on, off, ON, or OFF.");
        }
    }

    @Override
    public void installGame(String gameName){
        if(state == State.OFF){//if phone is off
            System.out.println("Smart phone is off. Please turn it on first.");
        }else{//if phone is on
            //store up to 5 games.
            if(gameSet.size() == 5 || hasGame(gameName)){
                return; // silently just don't install
            }else{//this game is not installed
                gameSet.add(gameName);//add game to the hash set
                System.out.println("Installing " + gameName + " on " + this.getOwner() + "'s smart phone.");
            }
        }
    }

    @Override
    public boolean hasGame(String gameName){//return if the game is already contained in the hash set.
        return gameSet.contains(gameName);
    }

    @Override
    public void playGame(String gameName){
        if(state == State.OFF){//if phone is off
            System.out.println("Smart phone is off. Please turn it on first.");
        }else{//if phone is on
            if(hasGame(gameName)){//if the hash set has this game
                System.out.println(this.getOwner() + " is playing " + gameName + ".");
            }else{
                System.out.println("Cannot play " + gameName + " on " + this.getOwner() + "'s smart phone. Install it first.");
            }
        }
    }

    public String toString(){
        return ("\n\tOwner: " + this.getOwner() + ", phone number: " + this.number() + ", screen size: " + this.getScreenSize()
                + ", ram: " + this.getRAM() + ", processor speed: " + this.getProcessorSpeeed());
    }

}