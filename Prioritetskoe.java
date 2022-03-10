class Prioritetskoe<T extends Comparable<T>> extends Lenkeliste<T> {
    
    Node foerStart = new Node(null); //Lager en node som ligger foer start

    @Override
    public void leggTil(T x){ //Skal sette inn elementer i sortert rekkefolge (fra minst til storst)
        Node nyNode = new Node(x);
        Node denne = start;
        Node forrige = foerStart;
        Boolean sattInn = false;
        forrige.neste = start;

        while (!sattInn) { //Looper til noden er satt inn
            if (denne == null || denne.nodeInfo.compareTo(nyNode.nodeInfo) >= 0) { //Hvis denne er null eller pekeren er paa riktig node
                forrige.neste = nyNode;
                nyNode.neste = denne;
                sattInn = true;

                if (start == denne){ 
                    start = nyNode;
                }
                break;
            }
            forrige = denne;
            denne = denne.neste;
        }
    }
}