package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Scanner;

public class Main1 {

	public static void main (String [] args) {
		ArrayList<ArrayList<String>> keys = new ArrayList<ArrayList<String>>();
		ArrayList<Hashtable<String,String>> dataCases = new ArrayList<Hashtable<String,String>>();
		Scanner scan = new Scanner(System.in);
		
		int cases = Integer.parseInt(scan.nextLine());
		scan.nextLine();

		for (int i = 0; i < cases; i++) {
			dataCases.add(new Hashtable<String, String>(100000));
			keys.add(new ArrayList<String>());
		}
		
		for (int i = 0; i < cases; i++) {
			String aux = scan.nextLine();
			while(!aux.equals("")) {
				if(dataCases.get(i).get(aux) == null) {
					keys.get(i).add(aux);
				}
				dataCases.get(i).put(aux,aux);
				aux=scan.nextLine();
			}
		}
		
		//Ordenando arraylists de keys
		for (int i = 0; i < keys.size(); i++) {
			Collections.sort(keys.get(i));
		}
		
		//Salidas
		for (int i = 0; i < cases; i++) {
			String k = "";
			int cont;
			long total = dataCases.get(i).size();
			for(int j = 0; j<keys.get(i).size(); j++) {
				cont = 0;
				k = keys.get(i).get(j);
				String found = dataCases.get(i).get(k);
				while(found!=null) {
					cont++;
					dataCases.get(i).remove(k);
					found = dataCases.get(i).get(k);
				}
				System.out.println("Este es cont: " + cont + " Este es total: " + total);
				double percentage = ((cont*100)/(double)total);
				System.out.println(k + " " +String.format("%.4f", percentage) );
			}
			System.out.println();
		}
	}
}
