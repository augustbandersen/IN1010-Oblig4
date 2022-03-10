package Oblig3;
class UgyldigListeindeks extends RuntimeException {
    UgyldigListeindeks (int indeks) {
        super("Ugyldig indeks: "+indeks);
    }
}
