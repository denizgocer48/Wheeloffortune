import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Whelloffortune {
	public static void main(String[] args) throws Exception{
		SingleLinkedList tempanimals = new SingleLinkedList();
		SingleLinkedList animals = new SingleLinkedList();
		SingleLinkedList alphabet = new SingleLinkedList();		
		SingleLinkedList sll1 = new SingleLinkedList();
		SingleLinkedList sll4 = new SingleLinkedList();
		SingleLinkedList sll5 = new SingleLinkedList();
		SingleLinkedList money = new SingleLinkedList();
		SingleLinkedList highscore = new SingleLinkedList();
		SingleLinkedList namelist = new SingleLinkedList();
		SingleLinkedList highscore2 = new SingleLinkedList();
		
		File f = new File("odev4.txt");
        Scanner animal = new Scanner(f);
        String str = "";
        while(animal.hasNextLine()) {
            str = animal.nextLine();
            tempanimals.add(str.toLowerCase(Locale.ENGLISH));
        }
		String str1,str2 ;
		Object temp;
		for (int i = 0; i < tempanimals.size(); i++) {			
			for (int j = 0; j < tempanimals.size(); j++) {
				str1=(String)tempanimals.random(i);
				str2=(String)tempanimals.random(j);
				if(str1.charAt(0)<str2.charAt(0)) {
					temp = tempanimals.random(i);
					tempanimals.change(i, tempanimals.random(j));
					tempanimals.change(j, temp);
				}
				else if(str1.charAt(0)==str2.charAt(0)) {
					if(str1.charAt(1)<str2.charAt(1)) {
						temp = tempanimals.random(i);
						tempanimals.change(i, tempanimals.random(j));
						tempanimals.change(j, temp);
					}
				}
			}
		}				
		for (int i = 0; i < tempanimals.size(); i++) {
			animals.add(tempanimals.random(i));
		}				
		money.add(10);money.add(20);money.add(30);money.add(40);money.add(10);money.add(200);money.add(300);money.add(400);money.add("Bankrupt");money.add("Bankrupt");
		
		alphabet.add('a');alphabet.add('b');alphabet.add('c');alphabet.add('d');alphabet.add('e');alphabet.add('f');alphabet.add('g');alphabet.add('h');alphabet.add('i');alphabet.add('j');alphabet.add('k');alphabet.add('l');alphabet.add('m');
		alphabet.add('n');alphabet.add('o');alphabet.add('p');alphabet.add('q');alphabet.add('r');alphabet.add('s');alphabet.add('t');alphabet.add('u');alphabet.add('v');alphabet.add('w');alphabet.add('x');alphabet.add('y');alphabet.add('z');
		
		Random r = new Random();
		int a = r.nextInt(7);
		sll1.add(a);
		System.out.println("Randomly generated number:" + a);
		for(int i =0; i<animals.random(a).toString().length();i++) {
			sll4.add(animals.random(a).toString().charAt(i));
			sll5.add('_');
		}
		int counter =0;
		int totalmoney=0;
		while(true) {			
			if(!sll5.search1('_', sll4.size())) {
				break;
			}
			int money1 = r.nextInt(10);
			Object cash = money.random(money1);			
					
			counter++;
			if(cash.equals((Object)"Bankrupt")) {					
				System.out.print("Word :");
				sll5.display();
				System.out.print("                Step : "+counter);
				System.out.print("                       Score " + totalmoney);
				System.out.print("       ");
				alphabet.display();
				System.out.println();
				System.out.println("Whell : " + cash);
				System.out.println();
				totalmoney=0;
			}
			else {
				int c = r.nextInt(27);
				char letter = (char)alphabet.random(c);	
				boolean q = sll4.search1(letter,sll4.size());	
				int count =0;
				System.out.print("Word :");
				sll5.display();
				System.out.print("                Step : "+counter);
				System.out.print("                       Score " + totalmoney);
				System.out.print("       ");
				alphabet.display();				
				alphabet.delete(alphabet.random(c));
				System.out.println();
				System.out.println("Whell : " + cash);
				System.out.println("Guess : " + letter);
				System.out.println();
				if(q) {
					for(int i =0;i< sll4.size();i++) {
						if(sll4.random(i) == (Object)letter) {
							sll5.changes(i, letter);
							count++;
						}
					}					
				}	
				totalmoney = totalmoney+(int)cash*count;				
			}		
		}	
		System.out.println("You get " + totalmoney + "TL ! ! !");
		
		String name = "You";		
		File g = new File("highscoretable.txt");
		BufferedReader file = new BufferedReader(new InputStreamReader(
	               new FileInputStream(g), "UTF8"));
		for(int k =0; k<10;k++) {
			namelist.add(file.readLine());
			highscore.add(file.readLine());
		}
		file.close();
		namelist.add(name);
		String score = String.valueOf(totalmoney);
		highscore.add(score);
		System.out.println();
		String s;
		String s2;
		Object temp2 ;
		Object temp3;
		int b = highscore.size();
		for (int i = 0; i < b; i++) {
			for (int j = 0; j < b; j++) {	
				if(Integer.parseInt((String)highscore.random(i))>Integer.parseInt((String)highscore.random(j))) {					
					temp2 = highscore.random(i);
					highscore.change(i, highscore.random(j));
					highscore.change(j, temp2);	
					
					temp3 = namelist.random(i);
					namelist.change(i, namelist.random(j));
					namelist.change(j, temp3);
				}																
			}
		}			
		highscore.delete(highscore.random(11));
		namelist.delete(namelist.random(11));
		System.out.println("High score table");
		for (int i = 0; i < 10; i++) {
			System.out.println(namelist.random(i));
			System.out.println(highscore.random(i));			
		}
		File af = new File("highscoretable");
		FileWriter fw = new FileWriter(af, false);
		BufferedWriter writer = new BufferedWriter(fw);
		for(int i =0;i<10;i++) {
			writer.write((String)namelist.random(i)+"\n");
			writer.write((String)highscore.random(i)+"\n");
		}			
		writer.close();	
	}	
}