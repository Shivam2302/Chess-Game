package chessGame;
import java.util.Scanner;
class Game
{
	Game(Board boar)
	{
		//Board Initialization.
		boar.board[0][0].p1=boar.r[0];
		boar.r[0].x=0;
		boar.r[0].y=0;
		boar.board[0][1].p1=boar.n[0];
		boar.n[0].x=0;
		boar.n[0].y=1;
		boar.board[0][2].p1=boar.b[0];
		boar.b[0].x=0;
		boar.b[0].y=2;
		boar.board[0][3].p1=boar.q[0];
		boar.q[0].x=0;
		boar.q[0].y=3;
		boar.board[0][4].p1=boar.k[0];
		boar.k[0].x=0;
		boar.k[0].y=4;
		boar.board[0][5].p1=boar.b[1];
		boar.b[1].x=0;
		boar.b[1].y=5;
		boar.board[0][6].p1=boar.n[1];
		boar.n[1].x=0;
		boar.n[1].y=6;
		boar.board[0][7].p1=boar.r[1];
		boar.r[1].x=0;
		boar.r[1].y=7;
		for(int i=0;i<16;i++)
		{
			if(i<8)
			{  
        boar.board[1][i].p1=boar.p[i];
        boar.p[i].x=1;
        boar.p[i].y=i;
			}				  
      else
			{
			  boar.board[6][i-8].p1=boar.p[i];
        boar.p[i].x=6;
        boar.p[i].y=i-8;				 
      }				 
		}
		boar.board[7][0].p1=boar.r[2];
		boar.r[2].x=7;
		boar.r[2].y=0;
		boar.board[7][1].p1=boar.n[2];
		boar.n[2].x=7;
		boar.n[2].y=1;
		boar.board[7][2].p1=boar.b[2];
		boar.b[2].x=7;
		boar.b[2].y=2;
		boar.board[7][3].p1=boar.q[1];
		boar.q[1].x=7;
		boar.q[1].y=3;
		boar.board[7][4].p1=boar.k[1];
		boar.k[1].x=7;
		boar.k[1].y=4;
		boar.board[7][5].p1=boar.b[3];
		boar.b[3].x=7;
		boar.b[3].y=5;
		boar.board[7][6].p1=boar.n[3];
		boar.n[3].x=7;
		boar.n[3].y=6;
		boar.board[7][7].p1=boar.r[3];
		boar.r[3].x=7;
		boar.r[3].y=7;
	}
	public static void main(String args[])
	{
		Scanner scan=new Scanner(System.in);
		Board boar=new Board();
		Game g1=new Game(boar);
		String color="white";
		System.out.println("Note:\n 1.) Capital letter means pieces of white player.");
		System.out.println(" 2.) Lower letter means pieces of black player.");
		System.out.println(" 3.) Co-ordinates of left Rook of white player is (0,0) other coordinates are according to this reference.");
		while(true)
		{
		  if(color=="white")
		  {
				boar.display();
			  System.out.println(" Turn of white player \n Enter initial positon");
			  int xi=scan.nextInt();
			  int yi=scan.nextInt();
				if(((xi>=0)&&(xi<=7))&&((yi>=0)&&(yi<=7)))//checking whether initial position is valid or not.
				{
				  System.out.println(" Enter final position");
			    int xf=scan.nextInt();
			    int yf=scan.nextInt();
					if(((xf>=0)&&(xf<=7))&&((yf>=0)&&(yf<=7)))//checking whether final position is valid or not.
					{
			      if(boar.isValidPiece(color,xi,yi))
				    {  
							if(boar.isValidMove(color,xi,yi,xf,yf))
				      {
				      	boar.updateBoard(xi,yi,xf,yf);
							  System.out.println("move successful");
					      color="black";
					      // check whether this move gives check to king of other player or not .
					      Piece pieceGivingCheck = boar.check(color,-1,-1,boar.k[1].x,boar.k[1].y);
					      if(pieceGivingCheck!=null)
					      {
					      	System.out.println(pieceGivingCheck.type);
					      	//check whether checkMate occurs or not . 
					      	if(boar.isCheckMate(color,pieceGivingCheck))
					      	{
					      		boar.display();
                    System.out.println("\n\n\t\t\t\t CHECKMATE ----- WHITE PLAYER WINS THE GAME ");
                    break ;
					      	}
					      	else
					      	  System.out.println("Be carefull , there is a check from piece at position ("+pieceGivingCheck.x+","+pieceGivingCheck.y+")");
					      }
					    }
							else 
								System.out.println("invalid move");  
				    }
						else 
							System.out.println("Not your piece at given initial position ");  
					}
					else
						System.out.println("invalid final position");
				}
				else
					System.out.println("invalid initial position");  
		  }
			else
			{
				boar.display();
			  System.out.println(" Turn of black player \n Enter initial positon");
			  int xi=scan.nextInt();
			  int yi=scan.nextInt();
				if(((xi>=0)&&(xi<=7))&&((yi>=0)&&(yi<=7)))//checking whether initial position is valid or not.
				{
				  System.out.println(" Enter final position");
			    int xf=scan.nextInt();
			    int yf=scan.nextInt();
					if(((xf>=0)&&(xf<=7))&&((yf>=0)&&(yf<=7)))//checking whether final position is valid or not.
					{
						if(boar.isValidPiece(color,xi,yi))
						{  
							if(boar.isValidMove(color,xi,yi,xf,yf))
				      {
				      	boar.updateBoard(xi,yi,xf,yf);
							  System.out.println("move successful");
					      color = "white";
					      // check whether this move gives check to king of other player or not .
					      Piece pieceGivingCheck = boar.check(color,-1,-1,boar.k[0].x,boar.k[0].y);
					      if(pieceGivingCheck!=null)
					      {
					      	//check whether checkMate occurs or not .
					      	if(boar.isCheckMate(color,pieceGivingCheck))
					      	{
					      		boar.display();
                    System.out.println("\n\n\t\t\t\t CHECKMATE ----- BLACK PLAYER WINS THE GAME ");
                    break ;
					      	}
					      	else
					      	  System.out.println("Be carefull , there is a check from piece at position ("+pieceGivingCheck.x+","+pieceGivingCheck.y+")");
					      }
					    }
						  else
								System.out.println("invalid move");
				    }
						else
							System.out.println("Not your piece at given initial position.");  
					}
					else
						System.out.println("invalid final position");
				}
				else
					System.out.println("invalid initial position");  	  
			}
		}
	}
}