import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        countsLeapYear(2022);
        getDeviceLink(0, 2005 );
        int deliveryDays = calculateDeliveryDays(60);
        System.out.println("Потребуется дней: " + deliveryDays);
    }
    public static void countsLeapYear(int year) {
        boolean isLeap;
        isLeap = (year % 400 == 0) || ((year % 100 != 0 && (year % 4 == 0)));
        System.out.println(isLeap ? year + " год является високосным" : year + " год не является високосным");
    }

    public static void getDeviceLink(int osType, int manufacturingYear) {
        if (osType != 1 && osType != 0) {
            throw new IllegalArgumentException("Wrong OS type");
        }
        int currentYear = LocalDate.now().getYear();
        if (manufacturingYear > currentYear) {
            throw new IllegalArgumentException("Wrong manufacturing year");
        }
        String osString = osType == 0 ? "iOS" : "Android";
        String versionString = manufacturingYear > 2015 ? "полную" : "облегченную";
        System.out.printf("Установите %s версию для %s по ссылке%n", versionString, osString);
    }

    public static int calculateDeliveryDays(int deliveryDistance) {
        if (deliveryDistance <= 20) {
            return 1;
        } else {
            return (int) Math.round((double) deliveryDistance / 40) + 1;
        }
    }
}