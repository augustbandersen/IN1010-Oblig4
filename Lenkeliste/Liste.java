package Lenkeliste;
interface Liste <T> extends Iterable<T> {
    int stoerrelse ();
    void leggTil (T x);
    T hent ();
    T fjern ();
}
