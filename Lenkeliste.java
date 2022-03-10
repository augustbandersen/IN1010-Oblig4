abstract class Lenkeliste<T> implements Liste<T> {
    protected Node start;

    public int stoerrelse() { //Skal returnere hvor mange elementer det er i listen
        int stoerrelse = 0;
        Node node = start;
        
        if (node == null){ //Hvis noden ikke peker på noe
            return stoerrelse;
        }

        while (node != null){ //Oker storrelse med 1 helt til det ikke finnes flere aa peke paa
            stoerrelse ++;
            node = node.neste;
        }
        return stoerrelse;
    }

    public void leggTil(T x){ //Skal legge inne et nytt element paa slutten av listen
        Node nyNode = new Node(x);
        nyNode.neste = null;

        if (start == null){ //hvis det ikke finnes en node, blir startnoden nyNode
            start = nyNode;
        } else { //legger paa slutten av listen
            Node siste = start;
            while (siste.neste != null){
                siste = siste.neste;
            }
            siste.neste = nyNode;
        }
    }
    
    public T hent() { //Skal returner det forste elemntet i listen
        Node node = start;
        return node.hentNodeInfo();
    }

    public T fjern(){ //Skal fjerne det forste elementet i listen og returnere det
        if (start == null) { //Hvis det ikke finnes noen node, vil det bli kjort UgyldigListeindeks
            throw new UgyldigListeindeks(0);
        }
        Node node = start;
        if (start != null) { //Hvis det finnes noder, blir start satt som neste node, som vil si at den originale noden peker paa null
        start = node.neste;
        return node.hentNodeInfo(); //returnerer nodeinfor paa original node
        }
        return null;
    }

    public String toString(){ //Skal bygge opp en en svarstreng av elementene i listen
        String svarstreng = "";
        Node node = start;

        while (node != null){
            svarstreng += node + ", ";
            node = node.neste;
        }
        
        return svarstreng;
    }


    protected class Node { //Nodeklasse
        protected T nodeInfo;
        protected Node neste;
    
        protected Node(T nodeInfo){
          this.nodeInfo = nodeInfo;
        }
       
        protected T hentNodeInfo(){
            return nodeInfo;
        }
    
        @Override
        public String toString() {
          return nodeInfo.toString();
        }
    }
    
}
