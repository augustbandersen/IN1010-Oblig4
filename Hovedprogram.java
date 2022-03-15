import Lenkeliste.*;
import Sykehus.*;
import java.util.Scanner;
import java.lang.ProcessBuilder;

public class Hovedprogram {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input;
        Boolean run = true;
        while(run){
            clearScreen();
            System.out.println("Hva oensker du aa gjoere?: ");
            System.out.println("    1. Skrive ut fullstendig oversikt");
            System.out.println("    2. Legge til nytt element");
            System.out.println("    3. Skrive ut statistikk");
            System.out.println("    4. Skrive alle data til fil");
            System.out.println("    Tast inn 'Q' for å avslutte programmet");
            System.out.print("\nSkirv nummer for oensket gjoeremål: ");
            input = in.nextLine();

            try {
                switch(Integer.parseInt(input)){

                    case 1:
                        oversikt();
                        break;
                    case 2:
                        leggTil();
                        break;
                    case 3:
                        statistikk();
                        break;
                    case 4:
                        skrivTilFil();
                        break;
                }
            } catch (NumberFormatException nfe) {
                if(input.equalsIgnoreCase("q")) break;
                System.out.flush();
                System.out.println("Ugyldig input, venligst prøv igjen");
            }

        }
    }
    public static void oversikt(){
        System.out.println("Oversikt");
    }
    public static void leggTil(){
        System.out.println("Legg til");
    }
    public static void statistikk(){
        System.out.println("Statistikk");
    }
    public static void skrivTilFil(){
        System.out.println("Skriv til fil");
    }
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  
}
