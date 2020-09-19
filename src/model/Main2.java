package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import hashstructure.HashTable;

public class Main2 {

	public static void main(String[]args) {
		ArrayList<ArrayList<String>> keys = new ArrayList<ArrayList<String>>();
		ArrayList<HashTable<String,String>> dataCases = new ArrayList<HashTable<String,String>>();
		Scanner scan = new Scanner(System.in);
		
		int cases = Integer.parseInt(scan.nextLine());
		scan.nextLine();

		for (int i = 0; i < cases; i++) {
			dataCases.add(new HashTable<String, String>(100000));
			keys.add(new ArrayList<String>());
		}
		
		for (int i = 0; i < cases; i++) {
			String aux = scan.nextLine();
			while(!aux.equals("")) {
				if(dataCases.get(i).getValue(aux) == null) {
					keys.get(i).add(aux);
				}
				dataCases.get(i).add(aux,aux);
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
			long total = dataCases.get(i).getSize();
			for(int j = 0; j<keys.get(i).size(); j++) {
				cont = 0;
				k = keys.get(i).get(j);
				String found = dataCases.get(i).getValue(k);
				while(found!=null) {
					cont++;
					dataCases.get(i).remove(k);
					found = dataCases.get(i).getValue(k);
				}
			double percentage = ((cont*100)/(double)total);
				System.out.println(k + " " +String.format("%.4f", percentage) );
			}
			System.out.println();
		}
	}
}
