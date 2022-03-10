class TestResepter {

    //Returnerer true om det er riktig farge
    public static boolean testFarge(Resept resept, String forventetFarge){
        return resept.farge() == forventetFarge;
    }

    //Returnerer true om det er riktig pris
    public static boolean testPrisAaBetale(Resept resept, int forventetPris){
        return resept.prisAaBetale() == forventetPris;
    }

    public static void main(String[] args){
        //Objekter av legemiddel
        Narkotisk stoff1 = new Narkotisk("Morfin", 300, 15.3, 76);
        Vanedannende stoff2 = new Vanedannende("Nikotin", 50, 8.7, 34);
        Vanlig stoff3 = new Vanlig("Paracetamol", 150, 23.1);
        Narkotisk stoff4 = new Narkotisk("Kokain", 499, 18.2, 92);

        //Legeobjekt
        Lege lege1 = new Lege("Per");

        //Objekter av resepter
        HvitResept resept1 = new HvitResept(stoff1, lege1, 1, 1);
        MilResept resept2 = new MilResept(stoff2, lege1, 2);
        PResept resept3 = new PResept(stoff3, lege1, 3, 2);
        BlaaResept resept4 = new BlaaResept(stoff4, lege1, 4, 3);

        //Tester testFarge
        System.out.println("testFarge resept1: " + testFarge(resept1, "Hvit"));
        System.out.println("testFarge resept2: " + testFarge(resept2, "Hvit"));
        System.out.println("testFarge resept3: " + testFarge(resept3, "Hvit"));
        System.out.println("testFarge resept4: " + testFarge(resept4, "Blaa"));

        //tester testPrisAaBetale
        System.out.println("testPrisAaBetale resept1: " + testPrisAaBetale(resept1, 300));
        System.out.println("testPrisAaBetale resept2: " + testPrisAaBetale(resept2, 0));
        System.out.println("testPrisAaBetale resept3: " + testPrisAaBetale(resept3, 42));
        System.out.println("testPrisAaBetale resept4: " + testPrisAaBetale(resept4, 125));
    }
}
