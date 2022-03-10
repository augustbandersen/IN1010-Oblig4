class TestLegemiddel {

    //Returnerer true om det er riktig ID
    public static boolean testHentId(Legemiddel legemiddel, int forventetId){
        return legemiddel.hentId() == forventetId;
    }

    //Returnerer true om det er riktig navn
    public static boolean testHentNavn(Legemiddel legemiddel, String forventetNavn){
        return legemiddel.hentNavn() == forventetNavn;
    }

    //Returnerer true om det er riktig pris
    public static boolean testHentPris(Legemiddel legemiddel, int forventetPris){
        return legemiddel.hentPris() == forventetPris;
    }

    //Returnerer true om det er riktig virkestoff
    public static boolean testHentVirkestoff(Legemiddel legemiddel, double forventetVirkestoff){
        return legemiddel.hentVirkestoff() == forventetVirkestoff;
    }

    public static boolean testSettNyPris(Legemiddel legemiddel, int nyPris, int forventedPris){
        legemiddel.settNyPris(nyPris);
        return legemiddel.hentPris() == forventedPris;
    }

    //Returnerer true om det er riktig styrke
    public static boolean testHentNarkotiskStyrke(Narkotisk narkotisk, int forventetNarkotiskStyrke){
        return narkotisk.hentNarkotiskStyrke() == forventetNarkotiskStyrke;
    }

    //Returnerer true om det er riktig styrke
    public static boolean testHentVanedannendeStyrke(Vanedannende vanedannende, int forventetVanedannendeStyrke){
        return vanedannende.hentVanedannendeStyrke() == forventetVanedannendeStyrke;
    }

    public static void main(String[] args) {
        Narkotisk stoff1 = new Narkotisk("Morfin", 300, 15.3, 76);
        Vanedannende stoff2 = new Vanedannende("Nikotin", 50, 8.7, 34);
        Vanlig stoff3 = new Vanlig("Paracetamol", 39, 23.1);

        //Tester for Narkotisk. Skriver ut true hvis det forventede stemmer.
        System.out.println("testHentId stoff1: " + testHentId(stoff1, 1));
        System.out.println("testHentNavn stoff1: " +testHentNavn(stoff1, "Morfin"));
        System.out.println("testhentPris stoff1: " + testHentPris(stoff1, 300));
        System.out.println("testHentVirkestoff stoff1 : " + testHentVirkestoff(stoff1, 15.3));
        System.out.println("testSettNyPris stoff1: " + testSettNyPris(stoff1, 250, 250));
        System.out.println("testHentNarkotsikStyrke stoff1 : " + testHentNarkotiskStyrke(stoff1, 76));

        //Tester for Vanedannende. Skriver ut true hvis det forventede stemmer.
        System.out.println("testHentId stoff2 : " + testHentId(stoff2, 1));
        System.out.println("testHentNavn stoff2 : " +testHentNavn(stoff2, "Nikotin"));
        System.out.println("testhentPris stoff2 : " + testHentPris(stoff2, 50));
        System.out.println("testHentVirkestoff stoff2 : " + testHentVirkestoff(stoff2, 8.7));
        System.out.println("testSettNyPris stoff2: " + testSettNyPris(stoff2, 60, 60));
        System.out.println("testHentNarkotsikStyrke stoff2 : " + testHentVanedannendeStyrke(stoff2, 34));

        //Tester for Vanlig. Skriver ut true hvis det forventede stemmer.
        System.out.println("testHentId stoff3: " + testHentId(stoff3, 1));
        System.out.println("testHentNavn stoff3 : " +testHentNavn(stoff3, "Paracetamol"));
        System.out.println("testhentPris stoff3 : " + testHentPris(stoff3, 39));
        System.out.println("testHentVirkestoff stoff3 : " + testHentVirkestoff(stoff3, 23.1));
        System.out.println("testSettNyPris stoff3: " + testSettNyPris(stoff3, 49, 49));
    }
}