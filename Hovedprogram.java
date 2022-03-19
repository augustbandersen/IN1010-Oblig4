import Lenkeliste.*;
import Sykehus.*;
import java.util.Scanner;
import java.io.File;

public class Hovedprogram {
    static Legesystem legesystem = new Legesystem();
    static boolean startup = true;
    static Boolean run = true;
    public static void main(String[] args) {
        //try {lesFraFil("legedata.txt");} catch (Exception e) {e.printStackTrace();}
        Scanner scanner = new Scanner(System.in);
        while(true){
            if(!hovedmeny(scanner)) break;
        }
        scanner.close();
    }
    public static void oversikt(){
        System.out.println("Oversikt");
    }
    public static void leggTil(Scanner in){ // Yuki
        System.out.println("Oenkser du aa legge til:\n\t- Lege, tast \"1\"");
            System.out.println("\t- Pasient, tast \"2\"\n\t- Legemiddel, tast \"3\"");
            System.out.println("\t- Resept, tast \"4\"");
            String nyValg = in.nextLine();
        
            if (nyValg.equals("1")) {
                addLege(in);
        
            } else if (nyValg.equals("2")) {
                addPasient(in);
        
            } else if (nyValg.equals("3")) {
                addLegemiddel(in);
        
            } else if (nyValg.equals("4")) {
                addResept(in);
        
            } else {
                System.out.println("Ugyldig valg, proev igjen.");
            }
        }
        public static void addLege(Scanner lege){
            System.out.println("Hva er legens navn? ");
            String navn = lege.nextLine();
            System.out.println("Er legen en spesialist?");
            System.out.println("\t- Ja: tast \"1\"");
            System.out.println("\t- Nei: tast \"2\"");
        
            String legeValg = lege.nextLine();
        
            if(legeValg.equals("1")) {
                System.out.println("Tast inn kontrollId ");
                String kontrollId = lege.nextLine();
                Lege nyLege = new Spesialist(navn, kontrollId);
                legesystem.leggTilLege(nyLege);
            }
            else if(legeValg.equals("2")) {
                Lege nyLege = new Lege(navn);
                legesystem.leggTilLege(nyLege);
            }else{
                System.out.println("Ugyldig input, venligst proev igjen");
                System.out.println("Tast ENTER for aa returnere til hovedmenyen");
                lege.nextLine();
                return;
            }
            System.out.println("Legen er blitt lagret! Tast enter for aa returnere til hovedmenyen.");
            lege.nextLine();
        }
        public static void addPasient(Scanner pasient){
        
            System.out.println("Hva er pasientens navn? ");
            String navn = pasient.nextLine();
        
            System.out.println("Hva er pasientens fodselsnummer? ");
            String fnr = pasient.nextLine();
            pasient.nextLine();
        
            Pasient nyPasient = new Pasient (navn, fnr);
            legesystem.leggTilPasient(nyPasient);
            System.out.println("Pasienten ble lagret!");
        }
        public static void addLegemiddel(Scanner tastatur){
            System.out.println("Hva slags type legemiddel er det?");
            System.out.println("Er det:\n\t- Narkotisk: tast \"a\"");
            System.out.println("\t- Vanedannende: tast \"b\"");
            System.out.println("\t- Vanlig: tast \"c\"");
        
            String nyInput = tastatur.nextLine();
            if (nyInput.equals("a")) {
                System.out.println("Navnet til leggemiddel: ");
                String navn = tastatur.nextLine();
        
                System.out.println("Prisen: ");
                int pris = tastatur.nextInt();
                tastatur.nextLine();
        
                System.out.println("Virkestoff: ");
                double virkestoff = tastatur.nextDouble();
                tastatur.nextLine();
        
                System.out.println("Narkotisk styrke: ");
                int styrke = tastatur.nextInt();
                tastatur.nextLine();
        
                Narkotisk legemiddelA = new Narkotisk(navn, pris, virkestoff, styrke);
                legesystem.leggTilLegemiddel(legemiddelA);
                System.out.println("Legemidlet ble lagret!");
        
        
        
            } else if (nyInput.equals("b")) {
                System.out.println("Navnet til leggemiddel: ");
                String navn = tastatur.nextLine();
        
                System.out.println("Prisen: ");
                int pris = tastatur.nextInt();
                tastatur.nextLine();
        
                System.out.println("Virkestoff: ");
                double virkestoff = tastatur.nextDouble();
                tastatur.nextLine();
        
                System.out.println("Vannedanende styrke: ");
                int styrke = tastatur.nextInt();
                tastatur.nextLine();
        
                Vanedannende legemiddelB = new Vanedannende(navn, pris, virkestoff, styrke);
                legesystem.leggTilLegemiddel(legemiddelB);
                System.out.println("Legemidlet ble lagret!");
        
        
        
            } else if (nyInput.equals("c")) {
                System.out.println("Navnet til leggemiddel: ");
                String navn = tastatur.nextLine();
        
                System.out.println("Prisen: ");
                Integer pris = tastatur.nextInt();
                tastatur.nextLine();
        
                System.out.println("Virkestoff: ");
                double virkestoff = tastatur.nextDouble();
                tastatur.nextLine();
        
                Vanlig legemiddelC = new Vanlig(navn, pris, virkestoff);
                legesystem.leggTilLegemiddel(legemiddelC);
                System.out.println("Legemidlet ble lagret!");
        
            } else {
                System.out.println("ugyldig bokstav");
            }
        }   
        public static void addResept(Scanner scanner){
            Prioritetskoe<Lege> legeListe = legesystem.hentLegeListe();
            IndeksertListe<Pasient> pasientListe = legesystem.hentPasientListe();
            IndeksertListe<Legemiddel> legemiddelListe = legesystem.hentLegemiddelListe();

            if (pasientListe.stoerrelse() < 1) {
                System.out.println("Resept kan ikke oprettes da det ikke er registrert noen pasienter enda\nVenligst registrer pasienter foerst.");
                System.out.println("Tast ENTER for aa returnere til hovedmenyen");
                scanner.nextLine();
                return;
            }
        
            System.out.println("Hvilken pasient skal utskrives en resept til?");
            for (Pasient pasient : pasientListe) {
                System.out.println(pasient.hentId() + ": " + pasient.toString());
            }
        
            Pasient pasient = null;
            int pasientensId = Integer.parseInt(scanner.nextLine());        
            for (Pasient p : pasientListe) {
                if (p.hentId() == pasientensId) {
                    pasient = p;
                }
            }
            if(pasient == null){
                    System.out.println("ugyldig pasient.");
                    System.out.println("Tast ENTER for aa returnere til hovedmenyen");
                    scanner.nextLine();
                    return;
            }
        
            if (legeListe.stoerrelse() < 1) {
                System.out.println("Resept kan ikke oprettes da det ikke er registrert noen leger enda\nVenligst registrer lege(r) først");
                System.out.println("Tast ENTER for aa returnere til hovedmenyen");
                scanner.nextLine();
                return;
            }

            System.out.println("Hvilken lege skriver ut resepten?");
            for (Lege lege: legeListe) {
                System.out.println(lege.hentLegeNavn());
            }
            Lege lege = null;
            String legensNavn = scanner.nextLine();
        
            for (Lege l : legeListe) {
                if (l.hentLegeNavn().equalsIgnoreCase(legensNavn)) {
                    lege = l;
                }
            }
            if(lege == null){
                System.out.println("Legen finnes ikke.");
                System.out.println("Tast ENTER for aa returnere til hovedmenyen");
                scanner.nextLine();
            }
        
            if (legemiddelListe.stoerrelse() < 1) {
                System.out.println("Resept kan ikke oprettes da det ikke er registrert noen legemidler enda\nVenligst registrer minst et legemiddel først");
                System.out.println("Tast ENTER for aa returnere til hovedmenyen");
                scanner.nextLine();
                return;
            }
        
            System.out.println("Hvilket legemiddel skal brukes?");
            for (Legemiddel legemiddel : legemiddelListe) {
                System.out.println(legemiddel.hentNavn());
            }
            Legemiddel legemiddel = null;
            String legemiddelNavn = scanner.nextLine();
        
            for (Legemiddel lm : legemiddelListe) {
                if (lm.hentNavn().equalsIgnoreCase(legemiddelNavn)) {
                    legemiddel = lm;
                }
            }
            if(legemiddel == null){
                System.out.println("Legemidlet finnes ikke.");
                System.out.println("Tast ENTER for aa returnere til hovedmenyen");
                scanner.nextLine();
                return;
            }
        
            System.out.println("Hvor mange ganger kan resepten brukes?");
            int reit = Integer.parseInt(scanner.nextLine());

            System.out.println("Hva slags type resept er det?");
            System.out.println("Er det:\n\t- Blaa Resept: tast \"b\"");
            System.out.println("\t- P resept: tast \"p\"");
            System.out.println("\t- Militaer resept: tast \"m\"");
        
            String in = scanner.nextLine();
        
            if(in.equals("b")) {
                try{
                    Resept bResept = lege.skrivBlaaResept(legemiddel, pasient, reit);
                    pasient.leggTilResept(bResept);
                    legesystem.leggTilResept(bResept);
                    System.out.println("Resepten er lagret!");
                }catch(UlovligUtskrift uu){System.out.println(uu);}
                
        
            } else if (in.equals("p")) {
                Resept pResept;
                try {
                    pResept = lege.skrivPResept(legemiddel, pasient, reit);
                    pasient.leggTilResept(pResept);
                    legesystem.leggTilResept(pResept);
                    System.out.println("Resepten er lagret!");
                } catch (UlovligUtskrift e) {
                    e.printStackTrace();
                }
        
            } else if (in.equals("m")) {
                Resept mResept;
                try {
                    mResept = lege.skrivMilResept(legemiddel, pasient);
                    pasient.leggTilResept(mResept);
                    legesystem.leggTilResept(mResept);
                System.out.println("Resepten er lagret!");
                } catch (UlovligUtskrift e) {
                    e.printStackTrace();
                }
        
            } else {
                System.out.println("Ugyldig input, venligst prøv igen");
                System.out.println("Tast ENTER for aa returnere til hovedmenyen");
                scanner.nextLine();
            }
            System.out.println("Tast ENTER for aa returnere til hovedmenyen");
            scanner.nextLine();
        }
    public static void statistikk(){
        System.out.println("Statistikk");
    }
    public static void skrivTilFil(){
        System.out.println("Skriv til fil");
    }
    public static boolean brukResept(Scanner scanner){
        IndeksertListe<Pasient> pasientliste = legesystem.hentPasientListe();
        clearScreen();
        System.out.println("Hvilken pasient vil du se resept for?");
        System.out.println(legesystem.hentPasientListe());
        for(int i = 0; i < pasientliste.stoerrelse(); i++){
            System.out.println(i + ".    " + pasientliste.hent(i));
        }
        System.out.println("Tast inn 'b' for aa returnere til hovedmenyen");
        System.out.print("> ");
        String input = scanner.nextLine();
        try{
            Pasient pasient = pasientliste.hent(Integer.parseInt(input));
            clearScreen();
            IndeksertListe<Resept> resepter = pasient.hentReseptListe();
            System.out.println("Velg resept du vil bruke:\n");
            System.out.println("Reseptene til " + pasient.hentNavn() + ":");
            if(resepter.stoerrelse() < 1){
                System.out.println("\nIngen resepter aa vise");
            }
            else{
                for(int i = 0; i < resepter.stoerrelse(); i++){
                    System.out.println(i + ".\n" + resepter.hent(i));
                }
                System.out.println("");
                input = scanner.nextLine();
                Resept resept = resepter.hent(Integer.parseInt(input));
                resept.bruk();
                if(resept.hentReit() == 0){
                    resepter.fjern(Integer.parseInt(input));
                }
                System.out.println("Resept brukt, reit er naa: " + resept.hentReit());
            }
            System.out.print("\nTast enter for aa returnere til hovedmenyen");
            scanner.nextLine();

        }catch(Exception e){
            if(input.equalsIgnoreCase("b")){
                return false;
            }
            System.out.println("ugyldig input, venligst prøv igjen");
            return true;
        }
        return false;

    }
    public static boolean hovedmeny(Scanner scanner){
        String input = "q";
        clearScreen();

        if(startup){
            System.out.println(
                "Velkommen, dette er et program som administrerer\n" + 
                "pasienter, leger, legemiddler og resepter.\n" + 
                "\nOensker du aa lese inn data fra fil?(j/n)"
            );
            input = scanner.nextLine();
            if(input.equalsIgnoreCase("j")){
                System.out.println("tast in komplett filsti for filen du oensker aa lese fra");
                input = scanner.nextLine();
                try {
                    lesFraFil(input);
                    System.out.println("\nLesing fra fil vellykket, det ble lest inn " + legesystem.hentLegeListe().stoerrelse() + 
                    " leger, " + legesystem.hentPasientListe().stoerrelse() + " pasienter, " + legesystem.hentLegemiddelListe().stoerrelse() + 
                    " legemidler og " + legesystem.hentReseptListe().stoerrelse() + " resepter.\nTast ENTER for aa gaa til hovedmenyen");
                    startup = false;
                    scanner.nextLine();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Det oppstod en feil under lesing fra fil, oensker du aa prøve igjen?(j/n)");
                    String input2 = scanner.nextLine();
                    if(input2.equalsIgnoreCase("j")) hovedmeny(scanner);
                }
            }if(input.equalsIgnoreCase("n")){
                System.out.println("\nTast ENTER for aa gaa til hovedmenyen");
                startup = false;
                scanner.nextLine();
            }
        }
        clearScreen();
        System.out.println("Hva oensker du aa gjoere?: ");
        System.out.println("    1. Skrive ut fullstendig oversikt");
        System.out.println("    2. Legge til nytt element");
        System.out.println("    3. Skrive ut statistikk");
        System.out.println("    4. Skrive alle data til fil");
        System.out.println("    5. Bruke resept");
        System.out.println("    Tast inn 'Q' for aa avslutte programmet");
        System.out.print("\nSkirv nummer for oensket gjoeremaal: ");
        input = scanner.nextLine();

        try {
            switch(Integer.parseInt(input)){
                case 1:
                    clearScreen();
                    legesystem.oversikt(scanner);
                    clearScreen();
                    break;
                case 2:
                    leggTil(scanner);
                    break;
                case 3:
                    clearScreen();
                    legesystem.skrivStatistikk(scanner);
                    clearScreen();
                    break;
                case 4:
                    System.out.println("Skriv inn filnavn du vil skrive til: ");
                    skrivTilFil(scanner);
                    break;
                case 5:
                    while(true){
                        if(!brukResept(scanner))break;
                    }
                    break;
                case 6:
                    skrivTilFil(scanner);
                    break;
            }
        } catch (NumberFormatException nfe) {
            if(input.equalsIgnoreCase("q")) run = false;
            System.out.flush();
            System.out.println("Ugyldig input, venligst proev igjen");
        }
        
        return run;
    }
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  
    public static void skrivTilFil(Scanner scanner){
        legesystem.skrivTilFil(scanner);
    }
    public static void lesFraFil(String filnavn) throws Exception{
        legesystem.lesFraFil(new File(filnavn));
    }
}


