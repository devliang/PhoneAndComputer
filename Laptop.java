import java.util.Set;
import java.util.HashSet;

public class Laptop implements Computer{

    //enum State {ON, OFF}

    private String owner;
    private String brand;
    private String hostname;
    private int screenSize;
    private int ram;
    private int processorSpeeed;
    private State state;

    Set<String> gameSet = new HashSet<>();//create a hash set to save games. Because each game is unique in the set

    public Laptop(String owner, String brand, int screenSize, int ram, int processorSpeeed){
        this.owner = owner;
        this.brand = brand;
        this.hostname = owner + "'s " + brand + " laptop";
        this.screenSize = screenSize;
        this.ram = ram;
        this.processorSpeeed = processorSpeeed;
        this.state = null;
    }

    public String getOwner(){
        return owner;
    }

    public String getBrand(){
        return brand;
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
        if(state == State.OFF){//if laptop is off
            System.out.println("Laptop is off. Please turn it on first.");
        }else{//if laptop is on
            //store up to 5 games.
            if(hasGame(gameName) || gameSet.size() == 5){
                return;// silently just don't install
            }else{//this game is not installed
                gameSet.add(gameName);//add game to the hash set
                System.out.println("Installing " + gameName + " on " + this.getOwner() + " 's laptop.");
            }
        }
    }

    @Override
    public boolean hasGame(String gameName){//return if the game is already contained in the hash set.
        return gameSet.contains(gameName);
    }

    @Override
    public void playGame(String gameName){
        if(state == State.OFF){//if laptop is off
            System.out.println("Laptop is off. Please turn it on first.");
        }else{//if laptop is on
            if(hasGame(gameName)){//if the hash set has this game
                System.out.println(this.getOwner() + " is playing " + gameName + ".");
            }else{
                System.out.println("Cannot play " + gameName + " on " + this.getOwner() + " 's laptop. Install it first.");
            }
        }
    }

    @Override
    public String toString(){
        return ("\n\tOwner: " + this.getOwner() + ", brand name: " + this.getBrand() + ", screen size: " + this.getScreenSize()
                + ", ram: " + this.getRAM() + ", processor speed: " + this.getProcessorSpeeed() + ", Host name: " + this.hostname + ".");
    }
}