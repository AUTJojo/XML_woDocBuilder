package org;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class OhneDocBuilder {
final static int anzahl_werte = 9;
	
	public static void main(String[] args) throws IOException {	
		String s = getFile("data.txt");
		s = s.replaceAll(" ", "");
		String [][] array = csvToArray(s);
		arrayToXML(array);
	}
	
	public static String getFile(String path) throws IOException{
		FileReader fr = null;
		try {
			fr = new FileReader(path);
		} catch (FileNotFoundException e1) {
			System.out.println("Bitte geben Sie ein gültiges Dokument ab.");
		}
	    BufferedReader br = new BufferedReader(fr);

	    String s = "";
		try {
			s = br.readLine();
		} catch (IOException e) {
			System.out.println("Bitte Überprüfen Sie ihr Textdokument!2");
		}

	    br.close();
		
		return s;
	}
	
	public static void array_ausagbe(String[][] array){
		for(int i = 0; i < array.length; i++){
			for(int j = 0; j < anzahl_werte; j++){
				System.out.print(array[i][j]);
			}
		System.out.println();
		}
	}
	
	public static String[][] csvToArray(String s){
		String[] s_split = s.split(";");
		String[][] array = new String[s_split.length][anzahl_werte];
		for(int i = 0; i < s_split.length; i++){
			String x = s_split[i];
			String[] y = x.split(",");
			for(int j = 0; j < y.length; j++){
				array[i][j] = y[j];
			}
		}
		return array;
	}
	
	public static void arrayToXML(String [][] array){
	  	String s = "";
	  	s = s + "<Manschaft>";
		for(int i = 0; i < array.length; i++){
			s = s + "<Spieler>";
			
				s = s + "<Vorname>";
				s = s + array[i][0];
				s = s + "</Vorname>";
				
				s = s + "<Nachname>";
				s = s + array[i][1];	
				s = s + "</Nachname>";
			
				s = s + "<Adresse>";

					s = s + "<Straße>";
					s = s + array[i][2];	
					s = s + "</Straße>";
		
					s = s + "<PLZ>";
					s = s + array[i][3];	
					s = s + "</PLZ>";
					  
					s = s + "<Place>";
					s = s + array[i][4];	
					s = s + "</Place>";
				
				s = s + "</Adresse>";
			  
				s = s + "<Position>";
				s = s + array[i][5];	
				s = s + "</Position>";
			  
				s = s + "<Nummber>";
				s = s + array[i][6];	
				s = s + "</Nummber>";
			  
				s = s + "<GespielteSpiele>";
				s = s + array[i][7];	
				s = s + "</GespielteSpiele>";
			  
				s = s + "<Tore>";
				s = s + array[i][8];	
				s = s + "</Tore>";
				
			s = s + "</Spieler>";
			s = s + "\n";
		}  
		s = s + "</Manschaft>";
		
		File file = new File("test2.xml");
		FileWriter writer;
	     try {
	       
	       writer = new FileWriter(file ,true);
	       
	       writer.write(s);
	       
	       writer.flush();

	       writer.close();
	       
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	  
	}
	
}
