import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Font;

public class CPTMarcus{
	public static void main(String[] args){
		Console con = new Console("Math Training Game",960,540);
//Main Menu Screen
		Font fnt = con.loadFont("font1.ttf", 30);
		BufferedImage Logo = con.loadImage("Logo1.jpeg");
		con.setDrawColor(Color.WHITE);
		con.fillRect(0,0,960,540);
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
		String strPlayerName;
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
		

