package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StreamTokenizer;

import eroi.Hero;
import eroi.Knight;
import eroi.Pyromancer;
import eroi.Rogue;
import eroi.Wizard;
import field.Field;


public class Main  {
	
	private static FileReader in ;
	private static FileWriter out ;
	private static StreamTokenizer tokenizer ;
	private static BufferedReader buff_in;
	private static BufferedWriter buff_out;
	private static int x ;
	private static int y ;
	private static char[][] map_init ;
	private static int[][] map;
	
	
	private static int numberOfCharacters;
	private static char[] faction ;
	private static int[] x_pos_init;
	private static int[] y_pos_init; 

	
	private static int numberOfRounds;
	private static char[][] moves_map;
	
	private static Hero[] heros;
	
	@SuppressWarnings("deprecation")
	public static void main(String args[]){
		
		/**
		 * Initializari fisiere de intrare si de iesire
		 * functie de parametrii din linie de comanda
		 */
		try {

			in = new FileReader(args[0]);
			out = new FileWriter(args[1]);

			buff_in = new BufferedReader(in);
			buff_out = new BufferedWriter(out);

			tokenizer = new StreamTokenizer(buff_in);
			
			
			int current = tokenizer.nextToken();
			x = (int)tokenizer.nval ;
			tokenizer.nextToken();
			y = (int)tokenizer.nval;
			
			map = new int[x][y];
			map_init = new char[x][y];

			int i = 0;
			for(i=0 , current = tokenizer.nextToken() ; i < x ; i++){
				String linie = tokenizer.sval; 
				tokenizer.nextToken();
				for(int j = 0 ; j < linie.length() ; j ++){
					map_init[i][j] = linie.charAt(j);
				}
			}
			
			
			tokenizer.nextToken();
			numberOfCharacters = (int)tokenizer.nval;
			
			faction = new char[numberOfCharacters];
			x_pos_init = new int[numberOfCharacters];
			y_pos_init = new int[numberOfCharacters];
			heros = new Hero[numberOfCharacters];
			
			
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
				String line = buff_in.readLine();
				for(int k = 0 ; k < line.length() ; k++){
					moves_map[j][k] = line.charAt(k);
				}
				tokenizer.nextToken();
			}
			
		
		}catch (IOException e) {
			e.printStackTrace();
		}	

		/*
		 * 
		 * Sa nu dau de 2 ori spell damage
		 * Sa nu dau de 2 ori spell damage
		 * Sa nu dau de 2 ori spell damage 
		 * Sa nu dau de 2 ori spell damage
		 * Sa nu dau de 2 ori spell damage
		 * 
		 * 
		 */
		
		Wizard k1 = new Wizard();
		Pyromancer w1 = new Pyromancer();
		
		
		
//		System.out.println (Math.round( 500 - (0.35 * 1.3 *500)) -27);
//		System.out.println(Math.round( 500 - Percent.getPercent (35 + (Percent.getPercent(30, 35)) ,500) - 27));
		
		for(int i = 0 ; i < 2 ; i++){
		
			k1.fightsWith(w1, Field.VOLCANIC, i );
			//check pyromancer damage done
			System.out.println("K1 = "+k1.HP );
			System.out.println("W1 = "+w1.HP );
		}

		/*
		 * Create the map matrix
		 */
		for(int i = 0 ; i < x ; i++){
			for(int j = 0 ; j < y ; j++){
				if(map_init[i][j] == 'W')
					map[i][j] = Field.WOODS;
				else if (map_init[i][j] == 'D')
					map[i][j] = Field.DESERT;
				else if (map_init[i][j] == 'L')
					map[i][j] = Field.LAND;
				else if (map_init[i][j] == 'V')
					map[i][j] = Field.VOLCANIC;
			}
		}
		
		/*
		 * Instantiate the heros vector
		 */
		
		for(int i = 0 ; i < numberOfCharacters ; i++){
			if(faction[i] == 'P'){
				
				heros[i] = new Pyromancer();
				heros[i].x = x_pos_init[i];
				heros[i].y = y_pos_init[i];
				
			}else if(faction[i] == 'K'){
				
				heros[i] = new Knight();
				heros[i].x = x_pos_init[i];
				heros[i].y = y_pos_init[i]; 
				
			}else if(faction[i] == 'W'){
				
				heros[i] = new Wizard();
				heros[i].x = x_pos_init[i];
				heros[i].y = y_pos_init[i];
				
			}else if(faction[i] == 'R'){
				
				heros[i] = new Rogue();
				heros[i].x = x_pos_init[i];
				heros[i].y = y_pos_init[i];
			}
		}
		
		
		
		for(int i = 0 ; i < numberOfRounds ; i++){
			
			
			for(int j = 0 ; j < numberOfCharacters ; j++){
				/*
				 * apply DOT damage
				 */
			}
			
			for(int j = 0 ; j < numberOfCharacters ; j++){
				
				if(heros[j].isDead())
					continue ;
				
				if(heros[j].isIncapacitated())
					moves_map[i][j] = '_';
				
				else{
					
					if(moves_map[i][j] == 'U'){
						
						heros[j].y --;
						
					}else if(moves_map[i][j] == 'D'){
						
						heros[j].y++;
						
					}else if(moves_map[i][j] == 'L'){
						
						heros[j].x--;
						
					}else if(moves_map[i][j] == 'R'){
						
						heros[j].x++;
						
					}else if(moves_map[i][j] == '_'){
						/*
						 * do nothing
						 */
						
					}
				}
			}
			
			/*
			 * Fight fight fight fight fight fight fight
			 */
			for(int j = 0 ; j < numberOfCharacters-1 ; j++){
				for(int k = j+1 ; k < numberOfCharacters ; k++){
					if(heros[j].isDead() || heros[k].isDead())
						break;
					if(heros[j].x == heros[k].x && heros[j].y == heros[k].y){
						heros[j].damages(heros[k],map[heros[i].x][heros[i].y],i );
						if(heros[j].isDead()){
							heros[k].XP = heros[k].XP + Math.max(0, 200 - (heros[k].level - heros[j].level) *40);
						}else if(heros[k].isDead()){
							heros[j].XP = heros[j].XP + Math.max(0, 200 - (heros[k].level - heros[j].level) * 40);
						}
						heros[j].increaseLevel();
						heros[k].increaseLevel();
						
					}
				}
			}
		}
		
		
		
		for(int j = 0 ; j < numberOfCharacters ; j++){
			StringBuilder builder = new StringBuilder();
			if (!heros[j].isDead()) {
				builder.append(faction[j] + " ");
				builder.append(heros[j].level + " ");
				builder.append(heros[j].XP + " ");
				builder.append(heros[j].HP + " ");
				builder.append(heros[j].x + " ");
				builder.append(heros[j].y);

				if (j != numberOfCharacters - 1)
					builder.append(System.getProperty("line.separator"));

				try {
					buff_out.write(builder.toString());
				} catch (IOException e) {
					System.err.println("Error at converting string into bytes in Main method");
					e.printStackTrace();
				}
			}else{
				builder.append(faction[j]+" ");
				builder.append("dead");
				
				if(j != numberOfCharacters -1 )
					builder.append(System.getProperty("line.separator"));
				
					try {
						buff_out.write(builder.toString());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			}
		}
		
		try {
			
			buff_out.flush();
			buff_in.close();
			buff_out.close();
			in.close();
			out.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
