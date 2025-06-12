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
		boolean blnQuizAv;
		boolean blnAddingQuest;
		String strPAnswer;
		int intCount; 
		int QuizAmount = 0;
		int intScore;
		String strAnswer1[];
		String strAnswer2[];
		String strAnswer3[];
		String strQuizSelect;
		String strFileName;
		String strNewFileName;
		String strQuizName;
		String strNewQuestion;
		String strAnswerNQ1;
		String strAnswerNQ2;
		String strAnswerNQ3;
		String strPlayer;
		double dblScorePercentage;


		
//Main Menu Screen

//Font and Logo
		blnOptions = true;
		while(blnOptions == true){
			con.clear();
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
					con.clear();
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
					strQuiz = new String[100];
					TextInputFile quizoptions = new TextInputFile("Quizzies.txt");
						while (!quizoptions.eof()) {
							strQuiz[QuizAmount] = quizoptions.readLine();
							con.println("- " + strQuiz[QuizAmount]);
							QuizAmount++;
						}
							quizoptions.close();
							
							con.println();
							con.println("NOTE: PLEASE ENTER THE QUIZ NAME EXACTLY HOW IT IS PRINTED");
							con.print("Enter the name of the quiz you want to play: ");
							strQuizSelect = con.readLine();
								blnQuizAv = false;
								for(intCount = 0; intCount < QuizAmount; intCount++){
									if(strQuizSelect.equalsIgnoreCase(strQuiz[intCount])){
										blnQuizAv = true;
										break;
									}
								}
					con.repaint();
	//CHOSEN TEST
					if (blnQuizAv) {
						con.clear();
						con.println("What is your name? ");
						strName = con.readLine();
						con.clear();
						
						strFileName = strQuiz[intCount] + ".txt";
						TextInputFile quizFile = new TextInputFile(strFileName);
						strEverything = new String[10][5];
						strAnswer1 = new String[10];
						strAnswer2 = new String[10];
						strAnswer3 = new String[10];
						intCount = 0;
						intScore = 0;
						
						while (!quizFile.eof()) {
							strQuestion = quizFile.readLine();
							strAnswer1[intCount] = quizFile.readLine(); 
							strAnswer2[intCount] = quizFile.readLine();
							strAnswer3[intCount] = quizFile.readLine();
							dblScorePercentage = (intScore / (intCount + 1)) * 100;
	
							con.println("Player: " + strName + " [Current Score: "+intScore+"/"+(intCount)+"]");
							con.println(strQuestion);
							con.print("Answer: ");
							strPAnswer = con.readLine();
							if (strPAnswer.equals(strAnswer1[intCount]) || 
								strPAnswer.equals(strAnswer2[intCount]) || 
								strPAnswer.equals(strAnswer3[intCount])) {
								con.println("Correct");
								intScore++;
							} else {
								con.println("Wrong");
							}
							
							con.sleep(1000);
							con.clear();
							intCount++;
						}	
						con.println("Quiz finished");
						con.println("Your score: " + intScore + " out of " + intCount);
						TextOutputFile leaderboardscore	= new TextOutputFile("Leaderboard.txt",true);
						leaderboardscore.println(strName+ " - " +strQuizSelect + " - " +intScore + " - " +intCount);
						leaderboardscore.close();
						con.println("Your score has been saved to the leaderboard.");
						con.println("YOU WILL RETURN TO MAIN MENU IN 10 SECONDS");
						con.sleep(10000);
						quizFile.close();
					} else {
					con.println("Invalid quiz name. Please try again.");
					con.sleep(2000);
					}
				}
			

			}else if(Character.toUpperCase(chrMenuOption) == 'L' ){
				con.clear();
				con.setBackgroundColor(Color.BLACK);
				con.println("THE LEADERBOARD");
				con.println("YOU HAVE 10 SECONDS TO VIEW");
				TextInputFile leaderboards = new TextInputFile("Leaderboard.txt");
				while(!leaderboards.eof()){
					strPlayer = leaderboards.readLine();
					con.println(strPlayer);
				}
				leaderboards.close();
				con.sleep(10000);
			
				
		
			



			}else if(Character.toUpperCase(chrMenuOption) == 'A'){
				con.clear();
				con.setBackgroundColor(Color.BLACK);
				con.println("WHEN MAKING A QUIZ ENSURE THERE IS NO SPACES WITHIN THE QUIZ NAME");
				con.println("What is the name of the quiz you want to add?");
				strQuizName = con.readLine();	
				strNewFileName = strQuizName + ".txt";
				TextOutputFile newQuizFile = new TextOutputFile(strNewFileName + ".txt");
				TextOutputFile quizoptions = new TextOutputFile("Quizzies.txt",true);
				quizoptions.println(strQuizName);
				quizoptions.close();
				
				con.clear();
				con.println("RULES: ADD QUESTIONS");
				con.println("AFTER EACH QUESTION ADD THREE OR TWO ANSWERS FOR THAT QUESTION");
				con.println("Example:");
				con.println("1 + 1 = ?");
				con.println(" 2 ");
				con.println("+2");
				con.println("Two");
				con.println("type DONE when finsihed");
				
				blnAddingQuest = true;

				while(blnAddingQuest){
					con.println("Enter question or 'done' if finished");
					strNewQuestion = con.readLine();
					if(strNewQuestion.equalsIgnoreCase("done")){
						blnAddingQuest = false;
					}else{
						con.print("Answer 1: ");
						strAnswerNQ1 = con.readLine();
						con.print("Answer 2: ");
						strAnswerNQ2 = con.readLine();
						con.print("Answer 3: ");
						strAnswerNQ3 = con.readLine();
						
						newQuizFile.println(strNewQuestion);
						newQuizFile.println(strAnswerNQ1);
						newQuizFile.println(strAnswerNQ2);
						newQuizFile.println(strAnswerNQ3);
					}
				}
				newQuizFile.close();
				con.println(strQuizName+ " has been added");
				con.sleep(5000);
			
			}else if(chrMenuOption == 'Q' || chrMenuOption == 'q'){
				con.clear();
				con.setBackgroundColor(Color.WHITE);
				con.setDrawColor(Color.BLACK);
				con.drawString("Are you sure you want to quit?", 320, 215);
				con.drawString("YES [ Y ]   NO [ N ] ", 380, 250);	
				con.repaint();
				chrMenuOption = con.getChar();
				if(chrMenuOption == 'Y' || chrMenuOption == 'y'){
					con.closeConsole();
				}else if(chrMenuOption == 'N' || chrMenuOption == 'n'){
					con.clear();
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
