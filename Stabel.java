class Stabel<T> extends Lenkeliste<T> {

    @Override
    public void leggTil(T x){ //Skal legge et element forst i listen
        Node nyNode = new Node(x);
        nyNode.neste = null;
        Node tmp;

        if (start == null){ //hvis det ikke finnes en node, blir startnoden nyNode
            start = nyNode;
            return;

        } else { //setter en ny node forst i listen
            tmp = start;
            start = nyNode;
            nyNode.neste = tmp;
        }
    }
}
