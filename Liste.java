package isletim;

class Liste {
    Node head;
    public int size;

    // Listenin sonuna bir nesne ekleme iþlemi
    public void addLast(Node newNode) {
        // Listenin boþ olduðunu kontrol edelim
        if (head == null) {
            head = newNode;
            size++;

        } else {
            // Listenin sonuna gidip, yeni nesneyi oraya ekleyelim
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            size++;
            current.next = newNode;
            newNode.prev = current;
        }
    }
    public void arayaEkle(Node newNode,int suankiZaman){


        // Liste boþsa, yeni düðümü head olarak ayarla
        if (head == null) {
            head = newNode;
            return;
        }

        // Deðeri kendinden küçük olan ilk düðümü bul
        Node curr = head;
        while (curr.next != null && curr.proses.varisZamani <= suankiZaman) {
            curr = curr.next;
        }

        // Eðer bulunan düðüm varsa, yeni düðümü o düðümün soluna ekle
        if (curr.prev != null) {
            curr.prev.next = newNode;
            newNode.prev = curr.prev;
            newNode.next = curr;
            curr.prev = newNode;
        }
        // Eðer bulunan düðüm yoksa, yeni düðümü en saða ekle
        else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            size++;
            current.next = newNode;
            newNode.prev = current;
        }
    }
    public void deleteNode(Node node) {
        // Eðer silinen düðüm liste baþý ise, baþýn referansýný
        // ikinci düðüme çevir
        if (node == head) {
            head = node.next;
        }
        // Düðümü yok et
        node.delete();
    }
    public void olumDegeriArttir(Liste p0,Liste p1,Liste p2,Liste p3,int gercekZaman) {
        // Düðümleri dolaþmak için geçici bir düðüm oluþturun
        Node currentP0 = p0.head;
        Node currentP1 = p1.head;
        Node currentP2 = p2.head;
        Node currentP3 = p3.head;
        int kalanSure=0;
        // Düðümleri dolaþmaya devam etmek için, geçici düðüm
        // son düðüme (null deðere sahip düðüme) ulaþana kadar döngüyü sürdürün
        while (currentP0 != null) {
            // Düðümün deðerini 1 arttýrýn
            currentP0.proses.olumAdimi += 1;

            if(currentP0.proses.olumAdimi==21){
                kalanSure=currentP0.proses.calisacagiSure - currentP0.proses.calistigiSure;
                currentP0.proses.zamanAsimi(gercekZaman,kalanSure);
                currentP0.delete();
            }
            else{
                currentP0 = currentP0.next;
            }
        }
        while (currentP1 != null) {
            // Düðümün deðerini 1 arttýrýn
            currentP1.proses.olumAdimi += 1;

            if(currentP1.proses.olumAdimi==21){
                kalanSure=currentP1.proses.calisacagiSure - currentP1.proses.calistigiSure;
                currentP1.proses.zamanAsimi(gercekZaman,kalanSure);
                currentP1.delete();
            }
            else{
                currentP1 = currentP1.next;
            }
        }
        while (currentP2 != null) {
            // Düðümün deðerini 1 arttýrýn
            currentP2.proses.olumAdimi += 1;

            if(currentP2.proses.olumAdimi==21){
                kalanSure=currentP2.proses.calisacagiSure - currentP2.proses.calistigiSure;
                currentP2.proses.zamanAsimi(gercekZaman,kalanSure);
                currentP2.delete();
            }
            else{
                currentP2 = currentP2.next;
            }
        }
        while (currentP3 != null) {
            // Düðümün deðerini 1 arttýrýn
            currentP3.proses.olumAdimi += 1;
            if(currentP3.proses.olumAdimi==21){
                kalanSure=currentP3.proses.calisacagiSure - currentP3.proses.calistigiSure;
                currentP3.proses.zamanAsimi(gercekZaman,kalanSure);
                currentP3.delete();
            }
            else{
                currentP3 = currentP3.next;
            }
            // Geçici düðümü sonraki düðüme götürün
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
        // check if the list is empty
        if (head == null) {
            return;
        }

        // set the head of the list to the next node
        head = head.next;
    }
}