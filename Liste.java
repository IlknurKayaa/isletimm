package isletim;

class Liste {
    Node head;
    public int size;

    // Listenin sonuna bir nesne ekleme i�lemi
    public void addLast(Node newNode) {
        // Listenin bo� oldu�unu kontrol edelim
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


        // Liste bo�sa, yeni d���m� head olarak ayarla
        if (head == null) {
            head = newNode;
            return;
        }

        // De�eri kendinden k���k olan ilk d���m� bul
        Node curr = head;
        while (curr.next != null && curr.proses.varisZamani <= suankiZaman) {
            curr = curr.next;
        }

        // E�er bulunan d���m varsa, yeni d���m� o d���m�n soluna ekle
        if (curr.prev != null) {
            curr.prev.next = newNode;
            newNode.prev = curr.prev;
            newNode.next = curr;
            curr.prev = newNode;
        }
        // E�er bulunan d���m yoksa, yeni d���m� en sa�a ekle
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
        // E�er silinen d���m liste ba�� ise, ba��n referans�n�
        // ikinci d���me �evir
        if (node == head) {
            head = node.next;
        }
        // D���m� yok et
        node.delete();
    }
    public void olumDegeriArttir(Liste p0,Liste p1,Liste p2,Liste p3,int gercekZaman) {
        // D���mleri dola�mak i�in ge�ici bir d���m olu�turun
        Node currentP0 = p0.head;
        Node currentP1 = p1.head;
        Node currentP2 = p2.head;
        Node currentP3 = p3.head;
        int kalanSure=0;
        // D���mleri dola�maya devam etmek i�in, ge�ici d���m
        // son d���me (null de�ere sahip d���me) ula�ana kadar d�ng�y� s�rd�r�n
        while (currentP0 != null) {
            // D���m�n de�erini 1 artt�r�n
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
            // D���m�n de�erini 1 artt�r�n
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
            // D���m�n de�erini 1 artt�r�n
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
            // D���m�n de�erini 1 artt�r�n
            currentP3.proses.olumAdimi += 1;
            if(currentP3.proses.olumAdimi==21){
                kalanSure=currentP3.proses.calisacagiSure - currentP3.proses.calistigiSure;
                currentP3.proses.zamanAsimi(gercekZaman,kalanSure);
                currentP3.delete();
            }
            else{
                currentP3 = currentP3.next;
            }
            // Ge�ici d���m� sonraki d���me g�t�r�n
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