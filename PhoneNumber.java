public class PhoneNumber{
    private final long number;

    public PhoneNumber(long number){
        if((number + "").length() != 10){//if the number length is not equal to 10
            throw new IllegalArgumentException("Phone number must be 10-digit number!");
        }
        this.number = number;
    }

    public long getNumber(){//get this long typed number
        return number;
    }

    public String toString(){
        return number + "";
    }
}