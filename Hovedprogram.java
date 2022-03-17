import Lenkeliste.*;
import Sykehus.*;
import java.util.Scanner;
import java.io.File;

public class Hovedprogram {
    static Legesystem legesystem = new Legesystem();
    public static void main(String[] args) {
        
        try{
            legesystem.lesFraFil(new File("legedata.txt"));
        }catch(Exception e){System.out.println("exception " + e);}
        
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
        System.out.println("Ønkser du å legge til:\n\t- Lege, tast \"1\"");
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
                System.out.println("Ugyldig valg, prov igjen.");
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
                lege.nextLine();
                Lege nyLege = new Spesialist(navn, kontrollId);
                legesystem.leggTilLege(nyLege);
        
            } else if(legeValg.equals("2")) {
                Lege nyLege = new Lege(navn);
                legesystem.leggTilLege(nyLege);
            }
            System.out.println("Legen er blitt lagret!");
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
        
            if (legesystem.hentPasientListe().hasNext().equals(false)) {
                System.out.println("Resept kan ikke oprettes.");
                return;
            }
        
            System.out.println("Hvilken pasient skal utskrives en resept til?");
            for (Pasient pasient : legesystem.hentPasientListe()) {
                System.out.println(pasient.hentId() + ": " + pasient.toString());
            }
        
            Pasient pasient = null;
            int pasientensId = scanner.nextInt();
            scanner.nextLine();
        
            for (Pasient p : legesystem.hentPasientListe()) {
                if (p.hentId() == pasientensId) {
                    pasient = p;
        
                } else {
                    System.out.println("ugyldig pasient.");
                    return;
                }
            }
        
            if (legesystem.hentLegeListe().hasNext().equals(false)) {
                System.out.println("Resept kan ikke oprettes.");
                return;
            }
        
            System.out.println("Hvilken lege skriver ut resepten? ");
            for (Lege lege : legesystem.hentLegeListe()) {
                System.out.println(lege.toString());
            }
            Lege lege = null;
            String legensNavn = scanner.nextLine();
        
            for (Lege l : legesystem.hentLegeListe()) {
                if (l.hentLegeNavn().equalsIgnoreCase(legensNavn)) {
                    lege = l;
        
                } else {
                    System.out.println("Legen finnes ikke.");
                }
            }
        
            if (legesystem.hentLegeListe().hasNext()) {
                System.out.println("Resept kan ikke oprettes.");
                return;
            }
        
            System.out.println("Hvilket legemiddel skal brukes?");
            for (Legemiddel legemiddel : legesystem.hentLegemiddelListe()) {
                System.out.println(legemiddel.toString());
            }
            Legemiddel legemiddel = null;
            String legemiddelNavn = scanner.nextLine();
        
            for (Legemiddel lm : legesystem.hentLegemiddelListe()) {
                if (lm.hentNavn().equalsIgnoreCase(legemiddelNavn)) {
                    legemiddel = lm;
        
                } else {
                    System.out.println("Legemidlet finnes ikke.");
                    return;
                }
            }
        
            System.out.println("Hvor mange ganger kan resepten brukes?");
            int reit = scanner.nextInt();
            scanner.nextLine();
        
            System.out.println("Hva slags type resept er det?");
            System.out.println("Er det:\n\t- Blaa Resept: tast \"b\"");
            System.out.println("\t- P resept: tast \"p\"");
            System.out.println("\t- Militaer resept: tast \"m\"");
        
            String in = scanner.nextLine();
        
            if(in.equals("b")) {
                BlaaResept bResept = lege.skrivBlaaResept(legemiddel, pasient, reit);
                pasient.leggTilResept(bResept);
                legesystem.leggTilResept(bResept);
                System.out.println("Resepten ber lagret!");
        
            } else if (in.equals("p")) {
                PResept pReseptlege.skrivPResept(legemiddel, pasient, reit);
                pasient.leggTilResept(pResept);
                legesystem.leggTilResept(pResept);
                System.out.println("Resepten er lagret!");
        
            } else if (in.equals("m")) {
                Resept mResept = new MilResept(legemiddel, lege, pasient, reit);
                lege.skrivMilResept(mResept);
                pasient.leggTilResept(mResept);
                legesystem.leggTilResept(mResept);
                System.out.println("Resepten er lagret!");
        
            } else {
                System.out.println("Feil bokstav");
            }
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
        Boolean run = true;
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
                    skrivTilFil();
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
        legesystem.skrivTilFil("");
    }
}


