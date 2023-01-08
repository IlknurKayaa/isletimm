package isletim;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;
public class DosyaOku {
    Process p;
    Node node;

    Liste list = new Liste();

    Random rand = new Random();
    public Liste Oku(String txt){
        int number = 0;
        try {

            java.io.File myObj = new java.io.File(txt);
            Scanner myReader = new Scanner(myObj);
            int id=0;
            while (myReader.hasNextLine()) {

                String data = myReader.nextLine();
                String[] saniye = data.split(", ",0);
               /* System.out.print("Id : "+id);
                System.out.print("  GelisZaman� ; "+ saniye[0]);
                System.out.print("  �ncelik ; "+ saniye[1]);
                System.out.println("  S�resi ; "+ saniye[2]);
                */RenkCode(number);
                p = new Process(id,Integer.parseInt(saniye[0]),Integer.parseInt(saniye[1]),Integer.parseInt(saniye[2]),NewColor(id),NewBColor(id));
                node=new Node(p);
                list.addLast(node);
                id++;

            }

            myReader.close();
            return list;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return null;

    }
    /* public void listegetir(LinkedList p0){
         for(int i = 0; !p0.IsEmpty();i++){
             System.out.println( i +" sn " + p0.peek());
             p0.pop();
         }
     }*/
    public String NewColor(int number){
        return "\u001B[1;3" +RenkCode(number) +"m";
    }
    public int RenkCode(int number){
        int newNumb = number %8;

        return newNumb;
    }

    public String NewBColor(int number){
        int rd =rand.nextInt(8);
        int nnumber = RenkCode(number);
        if(rd == nnumber){
            while(rd == nnumber){
                rd =rand.nextInt(8);
            }
        }
        return "\u001B[10" +rd +"m";
    }
}