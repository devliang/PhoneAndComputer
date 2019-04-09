public class OldLandline implements Phone{

    private String owner;
    private PhoneNumber number;
    private Phone phoneWith;

    public OldLandline(String owner, long number){
        this.owner = owner;
        this.number = new PhoneNumber(number);
        this.phoneWith = null;
    }

    @Override
    public String getOwner(){
        return owner;
    }

    @Override
    public void call(Phone phone){//this caller calls the receiver
        if(this.isBusy()){//if this caller is busy
            System.out.println(this.owner + " is unable to call " + phone.getOwner() + ". Line is currently busy.");
        }else{//if this caller is not busy
            if(!phone.isBusy()){//if the receiver is not busy
                this.phoneWith = phone;//this caller is speaking with receiver
            }
            phone.receive(this);//the receiver receives the phone call from this caller
        }
    }

    @Override
    public void receive(Phone from){//the receiver receives the call from caller
        if(this.isBusy()){//if the receiver is busy
            System.out.println(from.getOwner() + " is unable to call " + this.getOwner() + ". Line is currently busy.");
            from.end();//caller end the phone
        }else{//if the receiver is not busy
            System.out.println(from.getOwner() + " is on the phone with " + this.getOwner());
            phoneWith = from;//this receiver is speaking with caller
        }
    }

    @Override
    public void end(){//caller end the phone
        receiveEndSignal(phoneWith);//receive end signal method and pass in phoneWith value
        phoneWith = null;//set phoneWith to null
    }

    @Override
    public void receiveEndSignal(Phone from){//receiver receives end signal from caller
        if(from != null){//if caller does exist
            System.out.println(this.getOwner() + " has ended call to " + from.getOwner());//receiver ended call to caller
        }
    }

    @Override
    public boolean isBusy(){
        return phoneWith != null;//if phoneWith is not equal to null, means x is speaking with y.
    }

    @Override
    public PhoneNumber number(){//return a phoneNumber typed object, number
        return number;
    }

    @Override
    public String toString(){
        return this.getOwner() + ": " + this.number();
    }

}