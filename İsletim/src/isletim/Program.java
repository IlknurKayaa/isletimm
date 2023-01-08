package isletim;

public class Program {
    public static void main(String[] args) {

        Liste tumListe = new Liste();
        DosyaOku DosyaOku = new DosyaOku();
        Liste p0 = new Liste();
        Liste p1 = new Liste();
        Liste p2 = new Liste();
        Liste p3 = new Liste();
        Node node;
        Node nodetut;
        int oncelik;
        tumListe=DosyaOku.Oku("giris.txt");
        //oncelikli liste
        for (int i=0;i<tumListe.size;i++){
            oncelik = tumListe.head.proses.oncelik;
            if(oncelik==0){
                node= new Node(tumListe.head.proses);
                p0.addLast(node);
            }
            if(oncelik==1){
                node= new Node(tumListe.head.proses);
                p1.addLast(node);
            }
            if(oncelik==2){
                node= new Node(tumListe.head.proses);
                p2.addLast(node);
            }
            if(oncelik==3){
                node= new Node(tumListe.head.proses);
                p3.addLast(node);
            }
            tumListe.sonraki();
        }
        int yenimi=0;
        int calistigiSure=0;
        int calisacagiSure=0;
        int gercekZaman = 0;
        int gzartmadi=0;
        while(true){
            gzartmadi=0;
            if (p0.head!=null) {// liste bos mu
                if (p0.head.proses.varisZamani <= gercekZaman) { 
                    calisacagiSure = p0.head.proses.calisacagiSure;
                    calistigiSure = p0.head.proses.calistigiSure;
                    yenimi = calisacagiSure - calistigiSure;
                    if (yenimi == calisacagiSure) {
                        p0.head.proses.yeniBasladi(gercekZaman, yenimi);
                        p0.head.proses.calistigiSure++;
                        gercekZaman++;
                    } else if (yenimi < calisacagiSure && yenimi > 0) { 
                        p0.head.proses.yurutuluyor(gercekZaman, yenimi);
                        p0.head.proses.calistigiSure++;
                        gercekZaman++;
                    }
                    calisacagiSure = p0.head.proses.calisacagiSure;
                    calistigiSure = p0.head.proses.calistigiSure;
                    yenimi = calisacagiSure - calistigiSure;
                    if (yenimi == 0) {
                        p0.head.proses.bitti(gercekZaman, yenimi);
                        p0.sonraki();
                    }
                    p0.olumDegeriArttir(p0,p1,p2,p3,gercekZaman); 
                    continue; 
                }
                else
                    gzartmadi++; 
            }

            if (p1.head!=null) {
                if (p1.head.proses.varisZamani <= gercekZaman) {
                    calisacagiSure = p1.head.proses.calisacagiSure;
                    calistigiSure = p1.head.proses.calistigiSure;
                    yenimi = calisacagiSure - calistigiSure;
                    if (yenimi == calisacagiSure) {
                        p1.head.proses.yeniBasladi(gercekZaman, yenimi);
                        p1.head.proses.calistigiSure++;
                        gercekZaman++;
                        calisacagiSure = p1.head.proses.calisacagiSure;
                        calistigiSure = p1.head.proses.calistigiSure;
                        yenimi = calisacagiSure - calistigiSure;
                        if (yenimi == 0) {
                            p1.head.proses.bitti(gercekZaman, yenimi);
                            p1.sonraki();
                        } else {
                            p1.head.proses.oncelik = 2;
                            p1.head.proses.askida(gercekZaman, yenimi);
                            nodetut= new Node(p1.head.proses);
                            p2.arayaEkle(nodetut,gercekZaman);
                            p1.sonraki();
                        }
                    }
                    p0.olumDegeriArttir(p0,p1,p2,p3,gercekZaman);
                    continue;
                }
                else
                    gzartmadi++;
            }
            if (p2.head!=null) {
                if (p2.head.proses.varisZamani <= gercekZaman) {
                    calisacagiSure = p2.head.proses.calisacagiSure;
                    calistigiSure = p2.head.proses.calistigiSure;
                    yenimi = calisacagiSure - calistigiSure;
                    if (yenimi == calisacagiSure) { //yeni basladiysa olacaklar
                        p2.head.proses.yeniBasladi(gercekZaman, yenimi);
                        p2.head.proses.calistigiSure++;
                        gercekZaman++;
                        calisacagiSure = p2.head.proses.calisacagiSure;
                        calistigiSure = p2.head.proses.calistigiSure;
                        yenimi = calisacagiSure - calistigiSure;
                        if (yenimi == 0) {
                            p2.head.proses.bitti(gercekZaman, yenimi);
                            p2.sonraki();
                        } else {
                            p2.head.proses.oncelik = 3;
                            p2.head.proses.askida(gercekZaman, yenimi);
                            nodetut= new Node(p2.head.proses);
                            p3.arayaEkle(nodetut,gercekZaman);
                            p2.sonraki();
                        }
                    }
                    else if((calisacagiSure> calistigiSure)){
                        p2.head.proses.yurutuluyor(gercekZaman, yenimi);
                        p2.head.proses.calistigiSure++;
                        gercekZaman++;
                        calisacagiSure = p2.head.proses.calisacagiSure;
                        calistigiSure = p2.head.proses.calistigiSure;
                        yenimi = calisacagiSure - calistigiSure;
                        if (yenimi == 0) {
                            p2.head.proses.bitti(gercekZaman, yenimi);
                            p2.sonraki();
                        } else {
                            p2.head.proses.oncelik = 3;
                            p2.head.proses.askida(gercekZaman, yenimi);
                            nodetut= new Node(p2.head.proses);
                            p3.arayaEkle(nodetut,gercekZaman);
                            p2.sonraki();
                        }
                    }
                    p0.olumDegeriArttir(p0,p1,p2,p3,gercekZaman);
                    continue;
                }
                else
                    gzartmadi++;

            }
            //RR
            if (p3.head!=null) { 
                if (p3.head.proses.varisZamani <= gercekZaman) {
                    calisacagiSure = p3.head.proses.calisacagiSure;
                    calistigiSure = p3.head.proses.calistigiSure;
                    yenimi = calisacagiSure - calistigiSure;
                    if (yenimi == calisacagiSure) {
                        p3.head.proses.yeniBasladi(gercekZaman, yenimi);
                        p3.head.proses.calistigiSure++;
                        gercekZaman++;

                        calisacagiSure = p3.head.proses.calisacagiSure;
                        calistigiSure = p3.head.proses.calistigiSure;
                        yenimi = calisacagiSure - calistigiSure;
                        if (yenimi == 0) {
                            p3.head.proses.bitti(gercekZaman, yenimi);
                            p3.deleteNode(p3.head);
                        }
                        else{
                            p3.head.proses.askida(gercekZaman, yenimi);
                            nodetut=new Node(p3.head.proses);
                            p3.arayaEkle(nodetut,gercekZaman);
                            p3.deleteNode(p3.head);
                        } //dugumu sona tasýyýp her þeyi bir sola kaydýracaðýz.

                    } else if (yenimi < calisacagiSure && yenimi > 0) {
                        p3.head.proses.yurutuluyor(gercekZaman, yenimi);
                        p3.head.proses.calistigiSure++;
                        gercekZaman++;
                        calisacagiSure = p3.head.proses.calisacagiSure;
                        calistigiSure = p3.head.proses.calistigiSure;
                        yenimi = calisacagiSure - calistigiSure;
                        if (yenimi == 0) {
                            p3.head.proses.bitti(gercekZaman, yenimi);
                            p3.deleteNode(p3.head);
                        }
                        else{

                            p3.head.proses.askida(gercekZaman, yenimi);
                            nodetut=new Node(p3.head.proses);
                            p3.arayaEkle(nodetut,gercekZaman);
                            p3.deleteNode(p3.head);

                        } 
                    }
                    p0.olumDegeriArttir(p0,p1,p2,p3,gercekZaman);
                    continue;
                }
                else
                    gzartmadi++;
            }
            if (gzartmadi==4){
                p0.olumDegeriArttir(p0,p1,p2,p3,gercekZaman);
                System.out.println(gercekZaman + "  proses bu sürede yok.");
                gercekZaman++;
            }
            if(p0.IsEmpty() && p1.IsEmpty() && p2.IsEmpty() && p3.IsEmpty())
                break;


        }


    }
}