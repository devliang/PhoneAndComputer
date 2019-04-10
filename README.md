# PhoneAndComputer
## Classes and Interfaces
**Your implementation must adhere to the following behavioral specifications:**
1. The PhoneNumber class is a simple class. It is simply a wrapper containing a final long
value, which is a 10-digit phone number. The constructor of this class must ensure that an
instance of this class is always a 10-digit number. If the constructor is provided anything else,
it must throw a runtime exception of the type java.lang.IllegalArgumentException.

2. An old landline (i.e., the OldLandline class type) is a phone that can only make or receive
a phone call. The restrictions are:
* (a) More than one simultaneous calls cannot be made from an old landline.
* (b) More than one simultaneous calls cannot be received by an old landline.
* (c) For simplicity, you may assume that if the receiver of a call is not busy, then s/he will
pick up their phone when it rings.
3. A landline (i.e., the Landline class type) \is a" old landline with the additional functionality
that anyone calling it may choose to leave a message in case the intended recipient is busy
on another phone call. As such, it \has a" data type(s) to store messages. The details are:
* (a) Each message is marked as READ or UNREAD using an enumerable type called MSG STATUS.
* (b) A new message left on a Landline is initially always UNREAD.
* (c) Landline has an instance method to iterate through (i) all messages, or (ii) only unread
messages. The method, called readMessages(MSG STATUS) takes a MSG STATUS as its
parameter and iteratively prints all the relevant messages. Once a message has been
read, its status must be updated to READ (if it was already READ, then no change is
needed).
* (d) Adding a new message on a Landline must be a constant-time operation on the data
type used to store the messages.
* (e) The messages must be iterable in the order in which they were received. That is, if A
leaves a message m1 for B, and later, C leaves a message m2 for B, then the iteration
through the messages must print m1 before m2.
4. A SmartPhone is a class that adds even more functionality to the Landline1. This class also
obeys the behavior denoted by the Computer interface type. It must adhere to the following:
* (a) If the parameter is not one of \on", \ON", \oN', or \OFF", the setState(String to)
method must throw a runtime java.lang.IllegalArgumentException.
* (b) A SmartPhone is able to store up to 5 games. Accessing any particular game must be a
constant-time operation.
* (c) If a game is already installed on the smart phone, calling the installGame(String
gameName) method should realize this in constant-time, and not reinstall the game. This
method should silently ignore the reinstallation (i.e., you do not have to print anything
if the game is already installed).

5. Finally, there is a Laptop class, which again \is a" Computer. But unlike the SmartPhone, it
does not have the functionalities of any Phone.
* (a) A Laptop has two additional variables, private String brand and private String
hostname. The hostname incoroporates the brand name, the laptop owner's name, and
the type of computer. For example, if John is the owner of a Dell laptop, the hostname
is \John's Dell laptop".
* (b) The behavior of the setState(String to) method is exactly like that of a SmartPhone,
with the same exception handling.

## Generic Interfaces and Ordering

1. Order phones by their numbers (increasing).
2. Order phones by their owner names (alphabetically, case-insensitive).
3. Order computers by their screen size (increasing).
4. Order computers by their brand names (alphabetically, case-insensitive).
5. Order computers according to the amount of RAM (increasing).
Note that there may be objects that are phones as well as computers, so think carefully about how
you implement the ordering. At the end of your implementation, you must be able to directly use
the Java Collections library for sorting (i.e., the java.util.Collections#sort method), instead
of writing your own sorting code.

## Test Cases
**Sample Input**

`
public class Test {
    public static void main(String[] args) {
      Landline jack = new Landline("Jack", 6312028899L);
      Landline john = new Landline("John", 3028113434L);
      OldLandline julie = new OldLandline("Julie", 9018772324L);
      // further constructor details hidden in this sample
      SmartPhone paul = new SmartPhone("Paul", 2024449019, ...);
      jack.call(john);
      julie.call(john);
      john.end();
      julie.call(john);
      john.call(jack);
      julie.end();
      paul.installGame("fortnite");
      paul.installGame("angry birds");
      paul.installGame("fortnite");
      paul.playGame("minecraft");
      paul.playGame("fortnite");
    }
}
`

**Output**

The output of the above code is as follows (command-line user input in green italics):
Jack is on the phone with John.
Julie is unable to call John. Line is currently busy.
Does Julie want to leave a message? [y/n] y
call me back when you can
Julie left a message for John.
John has ended the call to Jack.
Julie is on the phone with John.
Julie has ended the call to John.
Installing fornite on Paul's smart phone.
Installing angry birds on Paul's smart phone.
Cannot play minecraft on Paul's smart phone. Install it firrst.
Paul is playing fortnite.
As you can see from the above sample, all the actions (e.g., calling, installing, playing, leaving a
message, etc.) are indicated by simple print statements that show what is going on. You must have
similar indicative statements in your code so that the user knows how your code is running. For
instance, if Jack is on the phone with John, and Julie calls John, the user must see some printed
statement showing that Julie was not able to make a call.
Leaving a message on the Landline must be done through user input (because it is possible that
the caller doesn't want to leave a message).
To create your own test cases, you must write a public class Test like above. If must include
the following types of tests:
1. What happens to the ordering and the various methods like call(), end(), etc. when real
and apparent types of the phones are different? That is, cases like:
OldLandline x = new Landline(...);
Phone x = new Landline(...);
Phone x = new OldLandline(...);
Phone x = new SmartPhone(...);
2. Similarly, what happens to the ordering and the various methods like playGame(), etc. when
the real and apparent types of the computers are different?
