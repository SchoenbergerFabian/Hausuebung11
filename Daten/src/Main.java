import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static java.time.temporal.ChronoUnit.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in,"Windows-1252");
        System.out.println("1st date:");
        LocalDateTime date1 = getDateInput(scanner);
        System.out.println("2nd date:");
        LocalDateTime date2 = getDateInput(scanner);

        if(date1.isAfter(date2)){
            LocalDateTime[] datetimes = swap(date1, date2);
            date1 = datetimes[0];
            date2 = datetimes[1];
        }

        if(YEARS.between(date1,date2)>0){
            long[] differences = getDifferences(date1, date2);

            String output = "\ndays: "+differences[0]
                    +"\nmonths: "+differences[1]
                    +"\nyears: "+differences[2]
                    +"\nhours: "+differences[3]
                    +"\nminutes: "+differences[4]
                    +"\nseconds: "+differences[5];

            System.out.println(output);

            scanner.nextLine(); //wait for input so output is readable

            LocalDate begin = date1.toLocalDate();
            LocalDate end = date2.toLocalDate();
            for(begin = begin.plusDays(1);!begin.equals(end);begin = begin.plusDays(1)){
                System.out.println(begin);
            }
        }else{
            System.out.println("Invalid dates! (there has to be at least a one year difference)");
        }
    }

    public static long[] getDifferences(LocalDateTime date1,LocalDateTime date2){
        long[] differences = new long[6];
        differences[0] = DAYS.between(date1,date2);
        differences[1] = MONTHS.between(date1,date2);
        differences[2] = YEARS.between(date1,date2);
        differences[3] = HOURS.between(date1,date2);
        differences[4] = MINUTES.between(date1,date2);
        differences[5] = SECONDS.between(date1,date2);
        return differences;
    }

    private static LocalDateTime[] swap(LocalDateTime date1, LocalDateTime date2){
        LocalDateTime[] datetimes = new LocalDateTime[2];

        int day1 = date1.getDayOfMonth();
        Month month1 = date1.getMonth();
        int year1 = date1.getYear();
        int hours1 = date1.getHour();
        int minutes1 = date1.getMinute();
        int seconds1 = date1.getSecond();

        int day2 = date2.getDayOfMonth();
        Month month2 = date2.getMonth();
        int year2 = date2.getYear();
        int hours2 = date2.getHour();
        int minutes2 = date2.getMinute();
        int seconds2 = date2.getSecond();

        datetimes[0] = LocalDateTime.of(year2,month2,day2,hours2,minutes2,seconds2);
        datetimes[1] = LocalDateTime.of(year1,month1,day1,hours1,minutes1,seconds1);

        return datetimes;
    }

    private static LocalDateTime getDateInput(Scanner scanner){
        String format = "dd.MM.yyyy HH:mm:ss";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
        System.out.println(format);
        System.out.print(" > ");
        String line = scanner.nextLine();
        return LocalDateTime.parse(line,dtf);
    }
}