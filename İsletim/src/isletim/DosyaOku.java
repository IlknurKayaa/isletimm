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
            Scanner mr = new Scanner(myObj);
            int id=0;
            while (mr.hasNextLine()) {

                String data = mr.nextLine();
                String[] saniye = data.split(", ",0);
                RenkCode(number);
                p = new Process(id,Integer.parseInt(saniye[0]),Integer.parseInt(saniye[1]),Integer.parseInt(saniye[2]),YeniRenk(id),YeniRenk2(id));
                node=new Node(p);
                list.addLast(node);
                id++;
            }
            mr.close();
            return list;
        } catch (FileNotFoundException e) {
            System.out.println("ERROR");
            e.printStackTrace();
        }
        return null;

    }
    public String YeniRenk(int number){
        return "\u001B[1;3" +RenkCode(number) +"m";
    }
    public int RenkCode(int number){
        int newNumb = number %8;

        return newNumb;
    }
    public String YeniRenk2(int number){
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