class IndeksertListe<T> extends Lenkeliste<T> {
    
    public void leggTil(int pos, T x){ //Skal legge til node paa en gitt posisjon
        if (pos > stoerrelse() || pos < 0){ //Hvis indeks er storre enn storrelsen paa listen eller mindre enn 0
            throw new UgyldigListeindeks(pos);
        }

        Node nyNode = new Node(x);
        nyNode.neste = null;
        Node tmp;

        if (pos == 0 && start != null){ //Sjekker om posisjonen er 0 og listen er tom
            tmp = start;
            start = nyNode;
            nyNode.neste = tmp;
        } else { //Lager lokke som finner riktig posisjon og putter inn en nyNode
            Node denne = start;
            int teller = 0;
            Node node = null;
            while (denne != null){
                if (teller == pos) {
                    node.neste = nyNode;
                    nyNode.neste = denne;
                }
                node = denne;
                denne = denne.neste;
                teller++;
            }
        }

        if (start == null) { //Hvis start ikke peker paa noe, blir startnoden en ny Node
            start = nyNode;
        }

        if (pos == stoerrelse()) { //Hvis pos er 1 utenfor listens storrelse, legges noden paa slutten
            leggTil(x);
          }
    }

    public void sett(int pos, T x){ //Skal erstatte elementet i posisjon pos med x
        if (pos >= stoerrelse() || pos < 0){ //Hvis indeks er storre enn eller lik storrelsen paa listen eller mindre enn 0
            throw new UgyldigListeindeks(pos); 
        }

        Node denne = start;
        int teller = 0;
        if (pos == 0 && denne != null){ //Hvis pos er 0 og start peker på null, settes start sin nodeInfo til x
            start.nodeInfo = x;
        }
        while (denne != null){ //Gaar gjennom listen til den finner riktig pos og endrer nodeInfo paa den noden til x
            if (teller == pos){
                denne.nodeInfo = x;
            }
            denne = denne.neste;
            teller++;
        }
    }

    public T hent(int pos){ //Skal hente infoen til elementet i gitt posisjon
        if (pos >= stoerrelse() || pos < 0){ //Hvis indeks er storre enn eller lik storrelsen paa listen eller mindre enn 0
            throw new UgyldigListeindeks(pos);
        }

        Node denne = start;
        int teller = 0;
        if (pos == 0 && denne != null){ //Hvis pos er 0 og start ikke er null, returnerer den start sin nodeInfo
            return denne.nodeInfo;
        }

        while (denne != null){ //Returnerer nodeInfo til node paa gitt pos
            if (teller == pos){
                return denne.nodeInfo;
            }
            denne = denne.neste;
            teller++;
        }
        return null;
    }


    public T fjern(int pos){ //Skal fjerne elementet paa gitt pos of returnere det
        if (pos >= stoerrelse() || pos < 0 || start == null) { //Exeption hvis listen er tom eller indeksen er ugyldig
            throw new UgyldigListeindeks(pos);
        }

        Node denne = start;
        Node forrige = null;
        if (pos == 0 && denne != null){ //Hvis pos er 0 og startnoden finnes setter den noden etter start som nye start og returnerer original start sin nodeInfo
            start = denne.neste;
            return denne.nodeInfo;
        }

        int teller = 0;
        while (denne != null){ //Finner riktig pos og returnerer nodeInfo der og flytter pekerene slik at noden paa pos blir fjernet
            if (teller == pos){
                forrige.neste = denne.neste;
                return denne.nodeInfo;
            } else {
                forrige = denne;
                denne = denne.neste;
                teller++;
            }

        }
        if (denne == null) { //Hvis pos ikke finnes, blir det printet en feilmelding 
            System.out.println(pos + "element finnes ikke");
        }
        return null;
    }
}
