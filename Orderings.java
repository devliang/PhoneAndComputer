import java.util.Comparator;
import java.util.List;
import java.util.Collections;

public class Orderings{

    private static class numberComparator implements Comparator<Phone>{
        public int compare(Phone a, Phone b){
            return Long.compare(a.number().getNumber(), b.number().getNumber());
        }
    }

    private static class ownerNameComparator implements Comparator<Phone>{
        public int compare(Phone a, Phone b){
            return a.getOwner().toLowerCase().compareTo(b.getOwner().toLowerCase());
        }
    }

    private static class screenSizeComparator implements Comparator<Computer>{
        public int compare(Computer a, Computer b){
            return a.getScreenSize() - b.getScreenSize();
        }
    }

    private static class brandNameComparator implements Comparator<Computer>{
        public int compare(Computer a, Computer b){
            String brand1 = "";
            String brand2 = "";
            if(a instanceof SmartPhone){
                brand1 = "default";
            }else{
                brand1 = ((Laptop)a).getBrand();
            }

            if(b instanceof SmartPhone){
                brand2 = "default";
            }else{
                brand2 = ((Laptop)b).getBrand();
            }
            return brand1.toLowerCase().compareTo(brand2.toLowerCase());
        }
    }

    private static class ramComparator implements Comparator<Computer>{
        public int compare(Computer a, Computer b){
            return a.getRAM() - b.getRAM();
        }
    }

    public static void orderPhoneByNumber(List<Phone> plist){
        Collections.sort(plist, new numberComparator());
    }

    public static void orderPhoneByOwnerName(List<Phone> plist){
        Collections.sort(plist, new ownerNameComparator());
    }

    public static void orderComputerByScreenSize(List<Computer> clist){
        Collections.sort(clist, new screenSizeComparator());
    }

    public static void orderComputerByBrandName(List<Computer> clist){
        Collections.sort(clist, new brandNameComparator());
    }

    public static void orderComputerByRam(List<Computer> clist){
        Collections.sort(clist, new ramComparator());
    }
}