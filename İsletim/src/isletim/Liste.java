package isletim;

class Liste {
    Node head;
    public int size;
    // liste sonuna ekleme
    public void addLast(Node newNode) {
        // liste bos mu
        if (head == null) {
            head = newNode;
            size++;
        } else {
            // yeni ekleme
            Node crent = head;
            while (crent.next != null) {
                crent = crent.next;
            }
            size++;
            crent.next = newNode;
            newNode.prev = crent;
        }
    }
    public void arayaEkle(Node newNode,int suankiZaman){
        if (head == null) {
            head = newNode;
            return;
        }        // bossa ilk yap
        Node cr = head;
        while (cr.next != null && cr.proses.varisZamani <= suankiZaman) {
            cr = cr.next;
        }        // küçük olaný bul
        // varsa sona ekle
        if (cr.prev != null) {
            cr.prev.next = newNode;
            newNode.prev = cr.prev;
            newNode.next = cr;
            cr.prev = newNode;
        }
        
        else {
            Node crent = head;
            while (crent.next != null) {
                crent = crent.next;
            }
            size++;
            crent.next = newNode;
            newNode.prev = crent;
        }// yoksa saða ekle
    }
    public void deleteNode(Node node) {
        if (node == head) {
            head = node.next;
        }
        node.delete();
    }
    public void olumDegeriArttir(Liste p0,Liste p1,Liste p2,Liste p3,int gercekZaman) {
        // düðüm dolaþýmý
        Node crentP0 = p0.head;
        Node crentP1 = p1.head;
        Node crentP2 = p2.head;
        Node crentP3 = p3.head;
        int kalanSure=0;
        while (crentP0 != null) {
            crentP0.proses.olum += 1;
            if(crentP0.proses.olum==21){
                kalanSure=crentP0.proses.calisacagiSure - crentP0.proses.calistigiSure;
                crentP0.proses.zamanAsimi(gercekZaman,kalanSure);
                crentP0.delete();
            }
            else{
                crentP0 = crentP0.next;
            }
        }
        while (crentP1 != null) {
            crentP1.proses.olum += 1;

            if(crentP1.proses.olum==21){
                kalanSure=crentP1.proses.calisacagiSure - crentP1.proses.calistigiSure;
                crentP1.proses.zamanAsimi(gercekZaman,kalanSure);
                crentP1.delete();
            }
            else{
                crentP1 = crentP1.next;
            }
        }
        while (crentP2 != null) {
            crentP2.proses.olum += 1;
            if(crentP2.proses.olum==21){
                kalanSure=crentP2.proses.calisacagiSure - crentP2.proses.calistigiSure;
                crentP2.proses.zamanAsimi(gercekZaman,kalanSure);
                crentP2.delete();
            }
            else{
                crentP2 = crentP2.next;
            }
        }
        while (crentP3 != null) {
            crentP3.proses.olum += 1;
            if(crentP3.proses.olum==21){
                kalanSure=crentP3.proses.calisacagiSure - crentP3.proses.calistigiSure;
                crentP3.proses.zamanAsimi(gercekZaman,kalanSure);
                crentP3.delete();
            }
            else{
                crentP3 = crentP3.next;
            }
        }

    }
    public boolean IsEmpty() {
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }
    public void sonraki() {
        if (head == null) {
            return;
        }
        head = head.next;
    }
}