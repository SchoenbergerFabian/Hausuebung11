import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static java.time.temporal.ChronoUnit.*;

public class Main {
    private static LocalDateTime date1;
    private static LocalDateTime date2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in,"Windows-1252");
        System.out.println("1st date:");
        date1 = getDateInput(scanner);
        System.out.println("2nd date:");
        date2 = getDateInput(scanner);

        if(date1.isAfter(date2)){
            swap();
        }

        if(YEARS.between(date1,date2)>0){
            String output = "\n";
            long dayDiff = DAYS.between(date1,date2);
            if(dayDiff!=0){
                output+="days: "+dayDiff+"\n";
            }
            long monthDiff = MONTHS.between(date1,date2);
            if(monthDiff!=0){
                output+="months: "+monthDiff+"\n";
            }
            long yearDiff = YEARS.between(date1,date2);
            if(yearDiff!=0){
                output+="years: "+yearDiff+"\n";
            }
            long hourDiff = HOURS.between(date1,date2);
            if(hourDiff!=0){
                output+="hours: "+hourDiff+"\n";
            }
            long minuteDiff = MINUTES.between(date1,date2);
            if(minuteDiff!=0){
                output+="minutes: "+minuteDiff+"\n";
            }
            long secondDiff = SECONDS.between(date1,date2);
            if(secondDiff!=0){
                output+="seconds: "+secondDiff+"\n";
            }

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

    private static void swap(){
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

        date1 = LocalDateTime.of(year2,month2,day2,hours2,minutes2,seconds2);
        date2 = LocalDateTime.of(year1,month1,day1,hours1,minutes1,seconds1);
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