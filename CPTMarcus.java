import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Font;

public class CPTMarcus{
	public static void main(String[] args){
		Console con = new Console("Math Training Game",960,540);
//Varibles 
		String strQuestion;
		String strName;
		String strQuiz[];
		String strEverything[][];
		char chrMenuOption;
		boolean blnOptions;
		String strPAnswer;
		int intCount; 
		int QuizAmount = 0;
		String strAnswer1[];
		String strAnswer2[];
		String strAnswer3[];
		double dblPlayerAnswer;

		
//Main Menu Screen

//Font and Logo
		blnOptions = true;
		while(blnOptions == true){
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
				con.clear();
				con.setBackgroundColor(Color.WHITE);			
				con.setDrawColor(Color.BLACK);
				con.drawString("Select Quiz [ S ]", 380, 250);
				con.drawString("Return [ R ]", 380, 285);
				chrMenuOption = con.getChar();
	//Return Menu Function
				System.out.println("entered Letter: "+chrMenuOption);
				if(chrMenuOption == 'R' || chrMenuOption == 'r'){
				con.setBackgroundColor(Color.BLACK);
				con.drawString("Math Training Game", 380, 215);
				con.drawString("Play [ P ] ", 380, 250);
				con.drawString("Leaderboard [ L ]", 380, 285);
				con.drawString("Add Quiz [ A ]", 380, 320);
				con.drawString("Rules [ R ]", 380, 355);
				con.drawImage(Logo, 385,1);
				con.repaint();
	//QUIZ SELECTION MENU
				}else if(Character.toUpperCase(chrMenuOption) == 'S'){
					con.clear();
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
	//CHOSEN TEST
					if(chrMenuOption == '2'){
						quizoptions.close();
						con.clear();
						con.println("What is your name? ");
						strName = con.readLine();
						con.clear();
						TextInputFile subtractionquiz = new TextInputFile("SubtractionQuiz.txt");
						strEverything = new String[10][5];
						strAnswer1 = new String[10];
						strAnswer2 = new String[10];
						strAnswer3 = new String[10];
						intCount = 0;
						while(subtractionquiz.eof() == false){
							strQuestion = subtractionquiz.readLine();
							strAnswer1[intCount] = subtractionquiz.readLine(); 
							strAnswer2[intCount] = subtractionquiz.readLine();
							strAnswer3[intCount] = subtractionquiz.readLine();
							con.println("Player: "+strName);
							con.println(strQuestion);
							con.print("Answer: ");
							strPAnswer = con.readLine();
							if(strPAnswer.equals(strAnswer1[intCount]) || strPAnswer.equals(strAnswer2[intCount]) || strPAnswer.equals(strAnswer3[intCount] )){
								con.println("Correct");
								con.sleep(1000);
								con.clear();

							}else{
								con.println("Wrong");
								con.sleep(1000);
								con.clear();
							}
							intCount++;
						}
						con.println("YOU WILL RETURN TO MAIN MENU IN 10 SECONDS");
						con.sleep(10000);
						subtractionquiz.close();
					}else if(chrMenuOption == '1'){
												quizoptions.close();
						con.clear();
						con.println("What is your name? ");
						strName = con.readLine();
						con.clear();
						TextInputFile additionquiz = new TextInputFile("AdditionQuiz.txt");
						strEverything = new String[10][5];
						strAnswer1 = new String[10];
						strAnswer2 = new String[10];
						strAnswer3 = new String[10];
						intCount = 0;
						while(additionquiz.eof() == false){
							strQuestion = additionquiz.readLine();
							strAnswer1[intCount] = additionquiz.readLine(); 
							strAnswer2[intCount] = additionquiz.readLine();
							strAnswer3[intCount] = additionquiz.readLine();
							con.println("Player: "+strName);
							con.println(strQuestion);
							con.print("Answer: ");
							strPAnswer = con.readLine();
							if(strPAnswer.equals(strAnswer1[intCount]) || strPAnswer.equals(strAnswer2[intCount]) || strPAnswer.equals(strAnswer3[intCount] )){
								con.println("Correct");
								con.sleep(1000);
								con.clear();

							}else{
								con.println("Wrong");
								con.sleep(1000);
								con.clear();
							}
							intCount++;
						}
						con.println("YOU WILL RETURN TO MAIN MENU IN 10 SECONDS");
						con.sleep(10000);
						additionquiz.close();			
				}
			}
			
			}else if(Character.toUpperCase(chrMenuOption) == 'L' ){
				con.clear();
				con.setBackgroundColor(Color.WHITE);

			
			}else if(chrMenuOption == 'A' || chrMenuOption == 'a'){
				con.clear();
				con.setBackgroundColor(Color.WHITE);			

			
			}else if(chrMenuOption == 'Q' || chrMenuOption == 'q'){
				con.setBackgroundColor(Color.WHITE);
				con.setDrawColor(Color.BLACK);
				con.drawString("Are you sure you want to quit?", 320, 215);
				con.drawString("YES [ Y ]   NO [ N ] ", 380, 250);	
				chrMenuOption = con.getChar();
				if(chrMenuOption == 'Y' || chrMenuOption == 'y'){
					con.closeConsole();
				}else if(chrMenuOption == 'N' || chrMenuOption == 'n'){
					con.setBackgroundColor(Color.WHITE);
					con.setDrawColor(Color.BLACK);
					con.drawString("Math Training Game", 380, 215);
					con.drawString("Play [ P ] ", 380, 250);
					con.drawString("Leaderboard [ L ]", 380, 285);
					con.drawString("Add Quiz [ A ]", 380, 320);
					con.drawString("Quit [ Q ]", 380, 355);
					con.drawImage(Logo, 385,1);
					con.repaint();
					
				}
							
			}

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




		

