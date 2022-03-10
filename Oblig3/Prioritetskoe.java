public class Prioritetskoe<T extends Comparable<T>> extends Lenkeliste<T>{
    public Prioritetskoe(){
        this.stoerrelse = 0;
        this.foersteNode = null;
        this.sisteNode = null;
    }
    @Override
    public void leggTil(T x) {
        Node node = new Node(x);
        Node nodeFoer = null;
        Node nodeEtter = null;
        stoerrelse ++;

        nodeFoer = stoersteMindreEn(x);
        try{nodeEtter = nodeFoer.neste; node.neste = nodeEtter;}
        catch(NullPointerException npe){
            if(stoerrelse > 0) node.neste = foersteNode;
            foersteNode = node;
        }

        if(node != foersteNode) nodeFoer.neste = node;
        if(nodeEtter == null) sisteNode = node;
        
    }

    private Node stoersteMindreEn(T x){
        Node node = this.foersteNode;
        boolean nesteStoerreEnX;
        boolean nesteLikX;
        boolean nesteMindreEnX;
        if(node == null) return null;
        if(node.objekt.compareTo(x) >= 0) return null;

        for(int i = 0; i <= stoerrelse; i++){
            try{
            nesteStoerreEnX = node.neste.objekt.compareTo(x) > 0;
            nesteLikX = node.neste.objekt.compareTo(x) == 0;
            nesteMindreEnX = node.neste.objekt.compareTo(x) < 0;
            if(nesteStoerreEnX) i = stoerrelse;
            if(nesteLikX) node = node.neste;
            if(nesteMindreEnX) node = node.neste;
            }catch(NullPointerException npe){}
        }
        return node;
    }
}
