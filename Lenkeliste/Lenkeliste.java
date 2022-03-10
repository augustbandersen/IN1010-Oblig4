package Lenkeliste;

import java.util.Iterator;

public abstract class Lenkeliste<T> implements Liste<T> {
    class Node{
        Node neste = null;
        T objekt;

        Node(T objekt){
            this.objekt = objekt;
        } 
        public String toString(){return this.objekt.toString();}
    }
    protected int stoerrelse;
    protected Node foersteNode;
    protected Node sisteNode;

    class LenkelisteIterator implements Iterator<T> {
        Node neste = null;
        Node node;
        Boolean opprettet = false;

        public LenkelisteIterator(){
            node = foersteNode;
            if(node != null) neste = node.neste; 
        }
        @Override
        public T next(){
            T objekt = node.objekt;
            node = neste;
            if(node != null) neste = node.neste;
            return objekt;
        }  
        @Override
        public boolean hasNext(){
            return node != null;
        }
    }
    
    public Lenkeliste(){
        stoerrelse = 0;
        foersteNode = null;
        sisteNode = null;
    }
 
    @Override
    public T fjern() {
        T objekt;
        Node node = this.foersteNode;
        try{objekt = node.objekt;}
        catch(NullPointerException npe){throw new UgyldigListeindeks(-1);}
        if(node.neste == null) this.foersteNode = this.sisteNode = null;
        else this.foersteNode = this.foersteNode.neste;
        this.stoerrelse --;
        return objekt;
        
    }

    @Override
    public T hent() {
        try{
            return this.foersteNode.objekt;
        }catch(NullPointerException npe){
            throw new UgyldigListeindeks(-1);
        }
        
    }

    @Override
    public void leggTil(T x) {
        Node node = new Node(x);
        try{
            this.sisteNode.neste = node;
        }catch(NullPointerException npe){
            this.foersteNode = node;
        }
        this.sisteNode = node;
        this.stoerrelse += 1;

    }

    @Override
    public int stoerrelse() {
        return stoerrelse;
    }

    @Override
    public Iterator<T> iterator(){
        return new LenkelisteIterator();
    }
    public String toString(){
        String output = "[";
        Node node = this.foersteNode;
        for(int i = 0; i < stoerrelse-1; i++){
            output += node.toString() + ", ";
            node = node.neste;
        } try{output += node.toString();} catch(NullPointerException npe){}
        return output + "]";
    }

}