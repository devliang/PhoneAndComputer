import java.util.List;
import java.util.ArrayList;

public class Test{
    public static void main(String[] args){

        System.out.println("Test phone interface: ");

        Landline jack = new Landline("Jack", 6312028899L);
        Landline john = new Landline("John", 3028113434L);
        OldLandline julie = new OldLandline("Julie", 9018772324L);
        SmartPhone paul = new SmartPhone("Paul", 2024449019, 12, 1000, 8);

        jack.call(john);//land line calls land line
        julie.call(john);//old land line calls land line
        john.end();
        julie.call(john);//old land line calls land line
        john.call(jack);//land line calls land line
        julie.end();
        System.out.println();

        System.out.println("\nTest computer interface: ");

        paul.setState("off");
        paul.installGame("fortnite");
        paul.installGame("angry birds");
        paul.installGame("fortnite");
        paul.playGame("minecraft");
        paul.playGame("fortnite");
        System.out.println();

        paul.setState("on");
        paul.installGame("fortnite");
        paul.installGame("angry birds");
        paul.installGame("fortnite");
        paul.playGame("minecraft");
        paul.playGame("fortnite");
        System.out.println();

        Laptop eason = new Laptop("Eason","Asus",13,2048, 12);

        eason.setState("off");
        eason.installGame("fortnite");
        eason.installGame("angry birds");
        eason.installGame("fortnite");
        eason.playGame("minecraft");
        eason.playGame("fortnite");
        System.out.println();

        eason.setState("on");
        eason.installGame("fortnite");
        eason.installGame("angry birds");
        eason.installGame("fortnite");
        eason.playGame("minecraft");
        eason.playGame("fortnite");
        System.out.println();

        System.out.println("\nTest real and apparent type of the phone: ");
        OldLandline alex = new Landline("Alex", 1312018899L);
        Phone amy = new Landline("Amy", 1028113434L);
        Phone louis = new OldLandline("Louis", 1018772324L);
        Phone tina = new SmartPhone("Tina", 1038772324L, 11, 1024, 10);
        Phone linda = new SmartPhone("Linda", 9174462228L, 8, 512, 6);

        louis.call(alex);//old landline calls landline
        amy.call(alex);//landline calls landline
        alex.end();
        alex.call(tina);//landline calls smartphone
        amy.call(alex);//landline calls smartphone
        alex.end();
        louis.call(john);
        alex.call(john);

        System.out.println("\nTest the smart phone is off: ");
        ((SmartPhone)linda).setState("off");
        linda.call(louis);//smartphone call old landline
        alex.call(linda);//landline call smartphone
        alex.end();

        System.out.println("\nSmart phone is now set to on.");
        ((SmartPhone)linda).setState("on");
        alex.call(linda);
        amy.call(linda);
        amy.end();


        System.out.println("\nTest Landline's read messages: ");
        System.out.println("---------------------------------------------");
        john.readMessages();
        john.readMessages(Landline.MSG_STATUS.UNREAD);
        john.readMessages(Landline.MSG_STATUS.UNREAD);
        john.readMessages(Landline.MSG_STATUS.READ);

        System.out.println("---------------------------------------------");
        ((Landline)alex).readMessages();
        ((Landline)alex).readMessages(Landline.MSG_STATUS.UNREAD);
        ((Landline)alex).readMessages(Landline.MSG_STATUS.UNREAD);
        ((Landline)alex).readMessages(Landline.MSG_STATUS.READ);

        System.out.println("\nTest Smartphone's read messages: ");
        System.out.println("---------------------------------------------");
        ((SmartPhone)linda).readMessages();
        ((SmartPhone)linda).readMessages(Landline.MSG_STATUS.UNREAD);
        ((SmartPhone)linda).readMessages(Landline.MSG_STATUS.UNREAD);
        ((SmartPhone)linda).readMessages(Landline.MSG_STATUS.READ);

        System.out.println("\nTest real and apparent types of the computer: ");
        Computer paul2 = new SmartPhone("Paul2", 6038772324L, 16, 2000, 18);
        Computer paul3 = new Laptop("Paul3", "Dell", 30, 3000, 58);
        Computer ryan = new Laptop("Ryan", "HP", 35, 3500, 65);

        //smart phone
        System.out.println();
        paul2.installGame("fortnite");
        paul2.installGame("angry birds");
        paul2.installGame("fortnite");
        paul2.playGame("minecraft");
        paul2.playGame("fortnite");

        //laptop
        System.out.println();
        paul3.installGame("fortnite");
        paul3.installGame("angry birds");
        paul3.installGame("fortnite");
        paul3.playGame("minecraft");
        paul3.playGame("fortnite");
        System.out.println();

        System.out.println("\nTest sorting with computer or phone: ");
        List<Phone> phoneList = new ArrayList<>();
        List<Computer> computerList = new ArrayList<>();

        phoneList.add(jack);
        phoneList.add(john);
        phoneList.add(julie);
        phoneList.add(paul);
        phoneList.add(alex);
        phoneList.add(amy);
        phoneList.add(louis);
        phoneList.add(linda);

        computerList.add(paul);
        computerList.add(paul2);
        computerList.add(paul3);
        computerList.add(ryan);
        computerList.add(eason);
        computerList.add((Computer)linda);


        Orderings.orderPhoneByNumber(phoneList);
        System.out.println("Sort phones by phone number: " + phoneList);
        Orderings.orderPhoneByOwnerName(phoneList);
        System.out.println("Sort phones by owner name: " + phoneList);

        Orderings.orderComputerByScreenSize(computerList);
        System.out.println("Sort computer by screen size: " + computerList);
        Orderings.orderComputerByBrandName(computerList);
        System.out.println("Sort computer by brand name: " +computerList);
        Orderings.orderComputerByRam(computerList);
        System.out.println("Sort computer by RAM: " + computerList);
    }
}