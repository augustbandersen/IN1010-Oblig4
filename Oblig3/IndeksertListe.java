package Oblig3;
public class IndeksertListe<T> extends Lenkeliste<T> {
    public void leggTil(int pos, T x){
        if(0 > pos || pos > this.stoerrelse) throw new UgyldigListeindeks(pos);
        Node node = new Node(x);
        Node nodeFoer = null;
        Node nodeEtter = null;
        stoerrelse ++;
        try{nodeFoer = getNode(pos-1);}
        catch(UgyldigListeindeks uli){}

        try{nodeEtter = getNode(pos);}
        catch(UgyldigListeindeks uli){}

        if(nodeFoer == null) this.foersteNode = node;
        else nodeFoer.neste = node;
        if(nodeEtter == null) this.sisteNode = node;
        else node.neste = nodeEtter;

    }
    public void sett(int pos, T x){
        getNode(pos).objekt = x;
    }
    public T hent(int pos){
        return getNode(pos).objekt;
    }
    public T fjern(int pos){ 
        Node node = getNode(pos);
        try{
            getNode(pos-1).neste = node.neste;  //prøver å finne forrige node
        }catch(UgyldigListeindeks uli3){        // om den ikke eksisterer prøver jeg å sette neste som første
            try{
                this.foersteNode = node.neste;
            }catch(NullPointerException npe){}
        }
        stoerrelse --;
        return node.objekt;
    }
    private Node getNode(int pos){
        if(0 > pos || pos >= this.stoerrelse) throw new UgyldigListeindeks(pos);
        Node node = this.foersteNode;
        for(int i = 0; i < pos; i++){
            node = node.neste;
        }
        return node;
    }
}
