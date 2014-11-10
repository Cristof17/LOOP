package main;
import java.io.*;

import eroi.Knight;
import eroi.Pyromancer;
import eroi.Rogue;
import eroi.Wizard;
import field.Field;


public class Main {
	
	private static FileInputStream in ;
	private static FileOutputStream out ;
	private static StreamTokenizer tokenizer ;
	private static BufferedInputStream buff_in;
	private static BufferedOutputStream buff_out;
	private static int x ;
	private static int y ;
	private static char[][] map ;
	
	
	
	private static int numberOfCharacters;
	private static char[] faction ;
	private static int[] x_pos_init;
	private static int[] y_pos_init; 

	
	private static int numberOfRounds;
	private static char[][] moves_map;
	@SuppressWarnings("deprecation")
	public static void main(String args[]){
		
		/**
		 * Initializari fisiere de intrare si de iesire
		 * functie de parametrii din linie de comanda
		 */
		try {

			in = new FileInputStream(args[0]);
			out = new FileOutputStream(args[1]);

			buff_in = new BufferedInputStream(in);
			buff_out = new BufferedOutputStream(out);

			tokenizer = new StreamTokenizer(buff_in);
			
			
			
			int current = tokenizer.nextToken();
			x = (int)tokenizer.nval ;
			tokenizer.nextToken();
			y = (int)tokenizer.nval;
			
			map = new char[x][y];

			int i = 0;
			for(i=0 , current = tokenizer.nextToken() ; i < x ; i++){
				String linie = tokenizer.sval; 
				tokenizer.nextToken();
				for(int j = 0 ; j < linie.length() ; j ++){
					map[i][j] = linie.charAt(j);
				}
			}
			
			
			tokenizer.nextToken();
			numberOfCharacters = (int)tokenizer.nval;
			
			faction = new char[numberOfCharacters];
			x_pos_init = new int[numberOfCharacters];
			y_pos_init = new int[numberOfCharacters];
			
			
			for(int j = 0 ; j < numberOfCharacters ; j++){
				faction[j] = tokenizer.sval.charAt(0);
				tokenizer.nextToken();
				x_pos_init[j] =(int)tokenizer.nval;
				tokenizer.nextToken();
				y_pos_init[j] =(int)tokenizer.nval;
				tokenizer.nextToken();
				
			}
			
			
			numberOfRounds = (int)tokenizer.nval;
			moves_map = new char[numberOfRounds][numberOfCharacters];
			tokenizer.nextToken();
			
			for(int j = 0 ; j < numberOfRounds ; j++){
				String line = tokenizer.sval ;
				for(int k = 0 ; k < line.length() ; k++){
					moves_map[j][k] = line.charAt(k);
				}
				tokenizer.nextToken();
			}
		
		}catch (IOException e) {
			e.printStackTrace();
		}	

		
		
		Knight k1 = new Knight();
		Wizard w1 = new Wizard();
		
		for(int i = 0 ; i < 2 ; i++){
		
			k1.fightsWith(w1, Field.DESERT, i );
			
			System.out.println("K1 = "+k1.HP );
			System.out.println("W1 = "+w1.HP );
		}

		
	}
	
}
