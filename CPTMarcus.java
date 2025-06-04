import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Font;

public class CPTMarcus{
	public static void main(String[] args){
		Console con = new Console("Math Training Game",960,540);
//Varibles 

		String strPlayerName;
		char chrMenuOption;
		
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
	
//Variables	


		chrMenuOption = con.getChar();
		System.out.println("entered Letter: "+chrMenuOption);
		if(chrMenuOption == 'P' || chrMenuOption == 'p'){
			con.setBackgroundColor(Color.WHITE);
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
		}
		else if(chrMenuOption == 'L' || chrMenuOption == 'l' ){
			con.setBackgroundColor(Color.WHITE);
		}
		else if(chrMenuOption == 'A' || chrMenuOption == 'a'){
			con.setBackgroundColor(Color.WHITE);
		}
		else if(chrMenuOption == 'Q' || chrMenuOption == 'q'){
			con.setBackgroundColor(Color.WHITE);
		}
		else if(chrMenuOption == 'R' || chrMenuOption == 'r'){
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
}
		

