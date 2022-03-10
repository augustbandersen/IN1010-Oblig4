public class Stabel<T> extends Lenkeliste<T>{
    @Override
    public void leggTil(T x){
        Node node = new Node(x);
        if(this.foersteNode == null) this.sisteNode = node;
        node.neste = this.foersteNode;
        this.foersteNode = node;
        this.stoerrelse ++;
    }
}
