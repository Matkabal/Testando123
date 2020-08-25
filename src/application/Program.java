package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.CardException;
import entities.Leitor;
import entities.MasterCard;
import entities.VISA;
import entities.cart�o;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);
		List<cart�o> list = new ArrayList<>();		

		System.out.println("Deseja ver os valores das opera��es ?s/n");
		char m = sc.next().charAt(0);
		
		if(m == 's') {
			Load();
			System.out.println();
		}
		
		System.out.println("Deseja realizar uma opera��o ?s/n");
		char c = sc.next().charAt(0);

		while(c == 's') {

		System.out.println("Digite o nome do Cart�o");
		sc.nextLine();
		String name =  sc.nextLine();
		
		
		if(name.toUpperCase().charAt(0) == 'M') {
			System.out.println("Digite o c�digo: " );
			int code = sc.nextInt();
			System.out.println("Digite o valor do empr�stimo que deseja ? ");
			double value = sc.nextDouble();
			
			cart�o d = new MasterCard(code, value);
		
			list.add(d);
			System.out.println("Deseja realizar outra opera��o ?s/n");
			 c = sc.next().charAt(0);
		}else if(name.toUpperCase().charAt(0) == 'V') {
			
			System.out.println("Digite o c�digo: " );
			int code = sc.nextInt();
			System.out.println("Digite o valor do empr�stimo que deseja ? ");
			double value = sc.nextDouble();
			
			cart�o d = new VISA(code, value);
		
			list.add(d);
			System.out.println("Deseja realizar outra opera��o ?s/n");
			 c = sc.next().charAt(0);
			 }
		else {
			throw new CardException("Cart�o inexistente");
			
		}
			
		}
		
		list.sort((p1,p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()));
		System.out.println("Valores");
		
		for(cart�o x: list) {
			
			System.out.println(x);
			
		}
	
		double sggs = list.stream().map(x -> x.getValue()).reduce(0.0, (x,y) -> x+y);
		
		System.out.println("Quantidade de Opera��es: "+list.size());
		System.out.println();
		System.out.println(sggs);
		
		
		System.out.println("Deseja salvar? s/n");
		char r = sc.next().charAt(0);
		if(r == 's') {
			Save(list);
		}
		else {
			
		}
		
		sc.close();
	}

	public static void Save(List<cart�o> list ) {
		
		
		
		String path = "c:\\temp\\in.txt";
		
		File p1 = new File(path);
		
		String end = p1.getParent();
		
		
		boolean success =  new File(end + "\\out").mkdir();
		
		String destiny = end+"\\out\\localhost.csv";
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(destiny, true))){
			

			for(cart�o item: list ) {
				
				bw.write(item.getName()+ ","+item.totalValue()+","+item.totalValueWithAntecipation());
				bw.newLine();
			}
			
			System.out.println(destiny + " CREATED!");
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}


	}
	
	public static void Load() {
		
		String path = "c:\\temp\\out\\localhost.csv";
		
		List<Leitor> listt = new ArrayList<>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String line = br.readLine();
			while(line != null){
				String []vect = line.split(",");
				String one = vect[0];
				double two = Double.parseDouble(vect[1]);
				double three = Double.parseDouble(vect[2]);

				listt.add(new Leitor(one, two, three));
				
				line = br.readLine();
				
			}
			
			listt.forEach(System.out::println);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
