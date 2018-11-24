import java.lang.invoke.SwitchPoint;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

//import static com.sun.org.apache.bcel.internal.classfile.Utility.printArray;

public class Calender {
    static enum weekDays{
        SU,MO,TU,WE,TH,FR,SA
    }



    public static void main(String[] args) {
        printYearCalender(2018);




        //LocalDate date = LocalDate.of(2018,1,1);
        //String[][] calenderArray = new String[6][7];

        //int indexRij = 0;
        //int indexKolom = 0;

        //System.out.println(date.getDayOfWeek());


        //1) print maandnaam:
        //System.out.println(date.getMonth());

        //System.out.println("Su mo di wo do vr za");

        //int hoeveelspaties = 0;
        //if(date.getDayOfWeek().name().equals("MONDAY")){
        //  hoeveelspaties = 1;
        //}

        //for (int i = 0; i < hoeveelspaties; i++) {
        //   calenderArray[indexRij][indexKolom]= "   ";
        //System.out.print("   ");
        //}
        //printAarray2(calenderArray);

        //System.out.print("   ");
        //System.out.println(1);


    }

    private static void printAarray2(String[][] monthCalender) {
        for (int i = 0; i < 6; i++) {




            for (int j = 0; j < 7; j++) {

                System.out.print(monthCalender[i][j]);


            }

            System.out.println();


        }


    }


    private static void printYearCalender(int yr) {
        LocalDate date;

        for (int i = 1; i <= 12; i++) {
            date = LocalDate.of(yr,i,1);
            Month month = date.getMonth();
            int year = date.getYear();
            printMonthCalender(month,year);
        }
    }

    private static void printMonthCalender(Month month, int year) {
        String[][] monthCalender = new String[6][7];
        //Print header
        System.out.println(month.name());
        printWeekEnums();


        //Bepaal op welke dag de 1e van de maand is
        LocalDate date = LocalDate.of(year,month,1);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        //dayOfWeek.
        //System.out.println(dayOfWeek);

        //Print zoveel spaties:
        if(dayOfWeek.name().equals("THURDAY"))
            System.out.println("ja");

        int spaces = 0;
        switch (dayOfWeek.name()){
            case "MONDAY":
                spaces = 1;
                break;
            case "TUESDAY":
                spaces = 2;
                break;
            case "WEDNESDAY":
                spaces = 3;
                break;
            case "THURSDAY":
                spaces = 4;
                break;
            case "FRIDAY":
                spaces = 5;
                break;
            case "SATURDAY":
                spaces = 6;
                break;
            case "SUNDAY":
                spaces = 0;
                break;
        }


        int huidigeRij = 0;
        int huidigeKolom = 0;
        String tePlaatsen= "";

        for (int i = 0; i < spaces; i++) {
            tePlaatsen = "   ";
            monthCalender[huidigeRij][huidigeKolom] = tePlaatsen;
            huidigeKolom++;
        }


        //System.out.println(1);


        //Hoeveel dagen in deze maand?
        //System.out.println(date.lengthOfMonth());


        for (int i = 1; i <= (date.lengthOfMonth()); i++) {
            String getal = Integer.toString(i);
            //Createmonthobject:

            monthCalender[huidigeRij][huidigeKolom] = createDayString(getal);
            if(huidigeKolom == 6) {
                huidigeRij++;
                huidigeKolom = 0;
            }
            else{
                huidigeKolom++;
            }

        }
        printAarray(monthCalender);

        //Vul de rest van de array aan






    }

    private static String createDayString(String getal) {
        String nieuw = getal;
        if(getal.length() ==1 ){
            nieuw = getal + "  ";
            return nieuw;
        }
        else if(getal.length() ==2 ){
            nieuw = getal + " ";
            return nieuw;
        }
        else{
            return  nieuw;
        }
    }

    private static void printAarray(String[][] monthCalender) {
        for (int i = 0; i < 6; i++) {
            if (monthCalender[i][0] == null)
                break;



            for (int j = 0; j < 7; j++) {
                if(monthCalender[i][j] != null)
                    System.out.print(monthCalender[i][j]);
                else
                    break;

            }

            System.out.println();


        }


    }

    private static void printWeekEnums() {
        for (weekDays w: weekDays.values()) {
            System.out.print(w + " ");
        }
        System.out.println();

    }

}
