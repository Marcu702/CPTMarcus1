import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Font;

public class CPTMarcus{
	public static void main(String[] args){
		Console con = new Console("Math Training Game",960,540);
//Varibles 
		String strQuestion;
		String strAnswer3;
		String strName;
		String strQuiz[];
		char chrMenuOption;
		int intCount; 
		int QuizAmount = 0;
		double dblAnswer1;
		double dblAnswer2;

		
//Main Menu Screen

//Font and Logo
		Font fnt = con.loadFont("", 30);
		BufferedImage Logo = con.loadImage("Logo1.jpeg");
		
//Background
		con.setDrawColor(Color.WHITE);
		con.fillRect(0,0,960,540);
		
//Text
		con.setDrawFont(fnt);
		con.setDrawColor(Color.BLACK);
		con.drawString("Math Training Game", 380, 215);
		con.drawString("Play [ P ] ", 380, 250);
		con.drawString("Leaderboard [ L ]", 380, 285);
		con.drawString("Add Quiz [ A ]", 380, 320);
		con.drawString("Quit [ Q ]", 380, 355);
		con.drawImage(Logo, 385,1);

		
		con.repaint();
	
//Button Functions	
		chrMenuOption = con.getChar();
		System.out.println("entered Letter: "+chrMenuOption);
//Play Button Funciton
		if(chrMenuOption == 'P' || chrMenuOption == 'p'){
			con.setBackgroundColor(Color.WHITE);			
			con.setDrawColor(Color.BLACK);
			con.drawString("Select Quiz [ S ]", 380, 250);
			con.drawString("Return [ R ]", 380, 285);
			chrMenuOption = con.getChar();
//Return Menu Function
			System.out.println("entered Letter: "+chrMenuOption);
			chrMenuOption = con.getChar();
			if(chrMenuOption == 'R' || chrMenuOption == 'r'){
			con.setBackgroundColor(Color.WHITE);
			con.setDrawColor(Color.BLACK);
			con.drawString("Math Training Game", 380, 215);
			con.drawString("Play [ P ] ", 380, 250);
			con.drawString("Leaderboard [ L ]", 380, 285);
			con.drawString("Add Quiz [ A ]", 380, 320);
			con.drawString("Quit [ Q ]", 380, 355);
			con.drawImage(Logo, 385,1);
			con.repaint();
			}else if(Character.toUpperCase(chrMenuOption) == 'S'){
				con.setBackgroundColor(Color.BLACK);
				con.println("What QUIZ would you like to do?");
				con.println("(SELECT THE NUMBER CORRESPONDING WITH THE QUIZ ORDER)");
				strQuiz = new String[100];
					TextInputFile quizoptions = new TextInputFile("Quizzies.txt");
					for(intCount = 0; intCount < 5; intCount++){
						strQuiz[intCount] = quizoptions.readLine();
						con.println(strQuiz[intCount]);
							}
						quizoptions.close();
				con.repaint();
				chrMenuOption = con.getChar();
				if(chrMenuOption == '1'){
					con.clear();
					con.println("What is your name? ");
					strName = con.readLine();
					con.clear();
					con.println("Player: "+strName);
					TextInputFile additionquiz = new TextInputFile("AdditionQuiz.txt");
					while(additionquiz.eof() == false){
						strQuestion = additionquiz.readLine();
						dblAnswer1 = additionquiz.readDouble();
						dblAnswer2 = additionquiz.readDouble();
						strAnswer3 = additionquiz.readLine();
						con.println(strQuestion);
						
					}
				}

				
				
			}
		
		}else if(chrMenuOption == 'L' || chrMenuOption == 'l' ){
			con.setBackgroundColor(Color.WHITE);

		
		}else if(chrMenuOption == 'A' || chrMenuOption == 'a'){
			con.setBackgroundColor(Color.WHITE);			

		
		}else if(chrMenuOption == 'Q' || chrMenuOption == 'q'){
			con.setBackgroundColor(Color.WHITE);
		}

	
//Data
//ONE MASTER FILE
//SUB FILES - (quiz)
//Game interface

//PLAY GAME
//LEADBOARD
//ADD QUIZ
//QUIT BUTTON

//Gameplay

//ASK FOR NAME
//SHOW THE QUIZ THAT CAN BE CHOSEN
//SHOW THE QUESTION THEN LET TEM ANSWER WITH TEXT
//TAKE THE PLAYERS ANSWER TO SEE IF IT MATCHES
//KEEP TRACK OF THE CORRECT ANSWERS, QUIZ NAME, AMOUNT ANSWERED, NAME, AND SCORE.




		
		}
	}




		

