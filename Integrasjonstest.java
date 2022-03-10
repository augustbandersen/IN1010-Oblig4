class Integrasjonstest {
    public static void main(String[] args){

        //Objekter av legemiddel
        Narkotisk stoff1 = new Narkotisk("Morfin", 300, 15.3, 76);
        Vanedannende stoff2 = new Vanedannende("Nikotin", 50, 8.7, 34);
        Vanlig stoff3 = new Vanlig("Paracetamol", 150, 23.1);
        Narkotisk stoff4 = new Narkotisk("Kokain", 499, 18.2, 92);
        
        //Objekt av lege
        Lege lege1 = new Lege("Per");

        //Objekter av resepter
        HvitResept resept1 = new HvitResept(stoff1, lege1, 1, 1);
        MilResept resept2 = new MilResept(stoff2, lege1, 2);
        PResept resept3 = new PResept(stoff3, lege1, 3, 2);
        BlaaResept resept4 = new BlaaResept(stoff4, lege1, 4, 3);

        //Objekt av spesielist
        Spesialist spesialist1 = new Spesialist("Ole", "ABC123");


        //Tester toString-metoden på alle objektene med \n for mer oversikt
        System.out.println("Narkotisk 1 (stoff1): " + stoff1 + "\n");
        System.out.println("Vanedannende (stoff2): " + stoff2 + "\n");
        System.out.println("Vanlig (stoff3): " + stoff3 + "\n");
        System.out.println("Narkotisk 2 (stoff4): " + stoff4 + "\n");

        System.out.println("Lege (lege1): " + lege1 + "\n");

        System.out.println("HvitResept (resept1): " + resept1 + "\n");
        System.out.println("MilResept (resept2): " + resept2 + "\n");
        System.out.println("RResept (resept3): " + resept3 + "\n");
        System.out.println("BlaaResept (resept4): " + resept4 + "\n");

        System.out.println("Spesialist (spesialist1): " + spesialist1 + "\n");
    }
}
