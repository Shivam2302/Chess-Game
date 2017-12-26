package chessGame;
class Board
{
	Square board[][]=new Square[8][8];
	King k[]=new King[2];
	Queen q[]=new Queen[2];
	Bisoph b[]=new Bisoph[4];
	Rook r[]=new Rook[4];
	Knight n[]=new Knight[4];
	Pawn p[]=new Pawn[16];
	int i,j;
	{
	  for(i=0;i<8;i++)
	  {
		  for(j=0;j<8;j++) 
			  board[i][j]=new Square();  
	  }
	  k[0]=new King("white");
	  k[1]=new King("black");
	  q[0]=new Queen("white");
	  q[1]=new Queen("black");
	  b[0]=new Bisoph("white");
	  b[1]=new Bisoph("white");
	  b[2]=new Bisoph("black");
	  b[3]=new Bisoph("black");
	  r[0]=new Rook("white");
	  r[1]=new Rook("white");
	  r[2]=new Rook("black");
	  r[3]=new Rook("black");
	  n[0]=new Knight("white");
	  n[1]=new Knight("white");
	  n[2]=new Knight("black");
	  n[3]=new Knight("black");
	  for(i=0;i<8;i++)
		  p[i]=new Pawn("white");
	  for(i=8;i<16;i++)
		  p[i]=new Pawn("black");
	}

	// This Function checks whether check given by other player is checkMate or not .
	Boolean isCheckMate(String col , Piece pieceGivingCheck)
  {
    int e = col=="black"?1:0;
    String col1 = col=="black" ? "white" :"black" ;  
    int xd,yd,dec=0;

    if(pieceGivingCheck.type=='n'||pieceGivingCheck.type=='p')
    {
      if(check(col1,-1,-1,pieceGivingCheck.x,pieceGivingCheck.y)!=null)
      	return false;
      else
      	return true;
    }

    else if(pieceGivingCheck.type=='r')
		{
			xd=k[e].x-pieceGivingCheck.x;
			yd=k[e].y-pieceGivingCheck.y;
			
			if(xd==0)
			{ 
				if(yd>0)
					dec=1;
				else if(yd<0)
					dec=-1;
				for(i=pieceGivingCheck.y;i!=k[e].y;i+=dec)
				{
          if(check(col1,-1,-1,k[e].x,i)!=null)
          	return false;
				}
			}

			else if(yd==0)
			{
				if(xd>0)
					dec=1;
				else if(xd<0)
					dec=-1;
				for(i=pieceGivingCheck.x;i!=k[e].x;i=i+dec)
				{
					if(check(col1,-1,-1,i,k[e].y)!=null)
						return false;
				}
			}
      //check for the case of king then return accorindly . 
		  return true ;
		}


		else if(pieceGivingCheck.type=='b')
		{
			xd=k[e].x-pieceGivingCheck.x;
			yd=k[e].y-pieceGivingCheck.y;
			if(xd>0)
			{
				
				if(yd>0)
					dec=1; 
        else if(yd<0)
          dec=-1;
        for(i=pieceGivingCheck.x,j=pieceGivingCheck.y;i!=k[e].x;i++,j+=dec)	
			  {  
				  if(check(col1,-1,-1,i,j)!=null)
          	return false;
				}
			}
			else if(xd<0)
			{
			  
				if(yd>0)
					dec=1; 
        else if(yd<0)
          dec=-1;
        for(i=pieceGivingCheck.x,j=pieceGivingCheck.y;i!=k[e].x;i--,j+=dec)	
			  {  
					if(check(col1,-1,-1,i,j)!=null)
					  return false;
				}					
			}
			//check for the case of king then return accorindly . 
		  return true ;	
		}


		else if(pieceGivingCheck.type=='q')
		{
      xd=k[e].x-pieceGivingCheck.x;
			yd=k[e].y-pieceGivingCheck.y;
			if(xd==0||yd==0)
			{
        if(xd==0)
			  { 
				  if(yd>0)
					  dec=1;
				  else if(yd<0)
					  dec=-1;
				  for(i=pieceGivingCheck.y;i!=k[e].y;i+=dec)
				  {
            if(check(col1,-1,-1,k[e].x,i)!=null)
          	  return false;
				  }
			  }

			  else if(yd==0)
			  {
				  if(xd>0)
					  dec=1;
				  else if(xd<0)
					  dec=-1;
				  for(i=pieceGivingCheck.x;i!=k[e].x;i=i+dec)
				  {
					  if(check(col1,-1,-1,i,k[e].y)!=null)
						  return false;
				  }
			  }
			}

			else
			{
				if(xd>0)
			  {
				  if(yd>0)
					  dec=1; 
          else if(yd<0)
            dec=-1;
          for(i=pieceGivingCheck.x,j=pieceGivingCheck.y;i!=k[e].x;i++,j+=dec)	
			    {  
				    if(check(col1,-1,-1,i,j)!=null)
          	  return false;
				  }
			  }
			  else if(xd<0)
			  {
				  if(yd>0)
					  dec=1; 
          else if(yd<0)
            dec=-1;
          for(i=pieceGivingCheck.x,j=pieceGivingCheck.y;i!=k[e].x;i--,j+=dec)	
			    {  
					  if(check(col1,-1,-1,i,j)!=null)
					    return false;
				  }					
			  }
			}
			return true;
		}
		else
			return false ; // Kuch b random ho jaye .
  }



  // This Function removes player at position xi,yi temporarily and return piece of color != given color that can reach given final position . 
	Piece check(String color,int xi,int yi, int xf , int yf)
	{
		System.out.println("Sudhanshu");
		Piece temp=null;
		if(xi>=0&&yi>=0)
		{
		  temp = board[xi][yi].p1;
		  board[xi][yi].p1=null;
		}
		//int e = color=="black"?1:0;
		int f= color=="black"?0:2;
		int m= color=="black"?0:8;
		int o= color=="black"?0:1;
		String col= color=="black"?"white":"black";
	
		if((r[f].status!=-1)&&isValidMove(col,r[f].x,r[f].y,xf,yf))
		{
			if(xi>=0&&yi>=0)
			  board[xi][yi].p1=temp;
      return r[f];
		}
		else if((r[f+1].status!=-1)&&isValidMove(col,r[f+1].x,r[f+1].y,xf,yf))
		{
			if(xi>=0&&yi>=0)
			  board[xi][yi].p1=temp;
			return r[f+1];
	  }
		else if((b[f].status!=-1)&&isValidMove(col,b[f].x,b[f].y,xf,yf))
		{
			if(xi>=0&&yi>=0)
			  board[xi][yi].p1=temp;
			return b[f];
		}
    else if((b[f+1].status!=-1)&&isValidMove(col,b[f+1].x,b[f+1].y,xf,yf))
		{ 
		  if(xi>=0&&yi>=0)
			  board[xi][yi].p1=temp;
			return b[f+1];
	  }
    else if((n[f].status!=-1)&&isValidMove(col,n[f].x,n[f].y,xf,yf))
		{ 
		  if(xi>=0&&yi>=0)
			  board[xi][yi].p1=temp;
		  return n[f];
    }			  
		else if((n[f+1].status!=-1)&&isValidMove(col,n[f+1].x,n[f+1].y,xf,yf))
		{
			if(xi>=0&&yi>=0)
			  board[xi][yi].p1=temp;
			return n[f+1];
    }			  
		else if((q[o].status!=-1)&&isValidMove(col,q[o].x,q[o].y,xf,yf))
		{
			if(xi>=0&&yi>=0)
			  board[xi][yi].p1=temp;
			return q[o];
	  }
		else if((k[o].status!=-1)&&isValidMove(col,k[o].x,k[o].y,xf,yf))
		{
			if(xi>=0&&yi>=0)
			  board[xi][yi].p1=temp; 
		  return k[o];
		}

		for(int i=m;i<m+8;i++)
	  {
	  	if(p[i].status!=-1&&isValidMove(col,p[i].x,p[i].y,xf,yf))
	  	{
	  		if(xi>=0&&yi>=0)
			    board[xi][yi].p1=temp;
	  		return p[i];
	  	}
	  }

    if(xi>=0&&yi>=0)
			board[xi][yi].p1=temp;
		return null;
	}



	// This Function updates the board after the move .
	void updateBoard(int xi,int yi,int xf,int yf)
	{
		// No piece at final position
		if(board[xf][yf].p1==null)
		{ 
		  board[xi][yi].p1.x=xf;
			board[xi][yi].p1.y=yf;
			board[xf][yf].p1=board[xi][yi].p1;
			board[xi][yi].p1=null;
		}

		// Piece of opposite color at final position , So change status of that piece to -1 .
		else
		{ 
		  board[xi][yi].p1.x=xf;
			board[xi][yi].p1.y=yf;
		  board[xf][yf].p1.status=-1;
			board[xf][yf].p1=board[xi][yi].p1;
			board[xi][yi].p1=null;
		}
	}



	// This Function is used to check whether final position is allowing move or not . 
	boolean checkAtLast(String col,int xf,int yf)
	{
		if(board[xf][yf].p1==null)
			return true;
		else if((board[xf][yf].p1!=null)&&(board[xf][yf].p1.color!=col))
			return true;
		else
			return false;
	}



	// This Function is used to check whether there is a piece of player having turn at initial position or not .
	boolean isValidPiece(String col , int xi , int yi)
	{
    if((board[xi][yi].p1!=null) && (board[xi][yi].p1.color==col))
      return true;
    else
    	return false;
	}



  // This Function is used to check whether the way in between initial position and final position is empty or not .(Except at final position)
	boolean isValidMove(String col,int xi,int yi,int xf,int yf)
	{
		Piece pi=board[xi][yi].p1;
    int e = col=="black"?1:0;

		// check if piece moves in specified direction or not , there should not be any check just after this move .
		if(pi!=null&&(pi.pieceValidMove(xi,yi,xf,yf))&&(check(col,xi,yi,k[e].x,k[e].y)==null))
		{
			int xd,yd,dec=0;

      // Piece at given initial po is KNIGHT or KING
			if(pi.type=='n'||pi.type=='k')
				return checkAtLast(col,xf,yf);


			// Checking horizontal and vertical move of ROOK , QUEEN 
			if(pi.type=='r')
			{
				xd=xf-xi;
				yd=yf-yi;
				// Horizontal move .
				if(xd==0)
				{ 
					if(yd>0)
						dec=1;
					else if(yd<0)
						dec=-1;
					for(i=yi+dec;i!=yf;i+=dec)
					{
						if(board[xi][i].p1!=null)
              return false;
					}
				}
				else if(yd==0) 
				{
				  // Vertical move .
					if(xd>0)
						dec=1;
					else if(xd<0)
						dec=-1;
					for(i=xi+dec;i!=xf;i=i+dec)
					{
						if(board[i][yi].p1!=null)
              return false;
					}
				} 
				return checkAtLast(col,xf,yf); 
			}



      // Piece at given position is BISHOP . 
			else if(pi.type=='b')
			{
				xd=xf-xi;
				yd=yf-yi;
				if(xd>0)
				{
					if(yd>0)
						dec=1; 
          else if(yd<0)
            dec=-1;
          for(i=xi+1,j=yi+dec;i!=xf;i++,j+=dec)	
					{  
						if(board[i][j].p1!=null)
							return false;
					}
				}

				else if(xd<0)
				{
					if(yd>0)
						dec=1; 
          else if(yd<0)
            dec=-1;
          for(i=xi-1,j=yi+dec;i!=xf;i--,j+=dec)	
					{  
						if(board[i][j].p1!=null)
							return false;
					}				
				}
				return checkAtLast(col,xf,yf);
			}



			// piece at given position is QUEEN
      else if(pi.type=='q')
      {
        xd=xf-xi;
				yd=yf-yi;
				if(xd==0||yd==0)
				{
          if(xd==0)
				  { 
					  if(yd>0)
						  dec=1;
					  else if(yd<0)
						  dec=-1;
					  for(i=yi+dec;i!=yf;i+=dec)
					  {
						  if(board[xi][i].p1!=null)
                return false;
					  }
				  }
				  else if(yd==0) 
				  {
					  // Vertical move .
					  if(xd>0)
						  dec=1;
					  else if(xd<0)
						  dec=-1;
					  for(i=xi+dec;i!=xf;i=i+dec)
					  {
						  if(board[i][yi].p1!=null)
                return false;
					  }
				  } 
				}
				else
				{
          xd=xf-xi;
				  yd=yf-yi;
				  if(xd>0)
				  {
					  if(yd>0)
						  dec=1; 
            else if(yd<0)
              dec=-1;
            for(i=xi+1,j=yi+dec;i!=xf;i++,j+=dec)	
					  {  
						  if(board[i][j].p1!=null)
							  return false;
					  }
				  }
				  else if(xd<0)
				  {
					  if(yd>0)
						  dec=1; 
            else if(yd<0)
              dec=-1;
            for(i=xi-1,j=yi+dec;i!=xf;i--,j+=dec)	
					  {  
						  if(board[i][j].p1!=null)
							  return false;
					  }				
				  }
				}
				return checkAtLast(col,xf,yf);
      }

      

      //Piece at given initial position is PAWN.					
			else if(pi.type=='p')
		  {
				xd=xf-xi;
				yd=yf-yi;
				if(yd==0)
				{
					if(xd>0) 
						dec=1;
					else if(xd<0)
						dec=-1;
					else
						return false;
					for(i=xi+dec;i!=xf;i+=dec)
					{
						if(board[i][yi].p1!=null)
              return false;								  
					}
					if(board[xf][yf].p1==null)
						return true;
					else
            return false;								  
				}
				else
				{
					if((board[xf][yf].p1!=null)&&(board[xf][yf].p1.color!=col))
            return true;							  
					else
            return false;							  
				}
			}

			else
				return false;  // kuch b random ho jaye agr .
		}
		else
		{
			// invalid direction for piece .
			return false;
		}
  }		


  // This Function is used to display board on the console .	
	void display()
	{
		int i,j;
		System.out.println("\n");
		for(i=0;i<=7;i++)
		{
		  System.out.print("\t\t\t\t");
			for(j=0;j<=7;j++)
			{
				if(board[i][j].p1==null)
					System.out.print("-   ");  
				else if(board[i][j].p1.color=="white")
					System.out.print(Character.toUpperCase(board[i][j].p1.type)+"   "); 
        else
          System.out.print(board[i][j].p1.type+"   "); 					  
			}
			System.out.println("\n");
		}
	}
}
