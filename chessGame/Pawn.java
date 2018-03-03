package chessGame;
class Pawn extends Piece
{
	Pawn(String col)
	{
    color=col;
		status=0;
		type='p';
	}
  boolean pieceValidMove(int xi,int yi,int xf,int yf)
	{
		//using first we are checking whether the pawn in moving first time or not.
		if(first==0)
		{
			if(yf-yi==0)
			{ 
			  if((xf-xi)==2||(xf-xi==-2)||(xf-xi==1)||(xf-xi==-1))
				{
				  return true;  
				}
			  else
					return false; 
			}
			else 
			{
				if((xf-xi==1||xf-xi==-1)&&(yf-yi==1||yf-yi==-1))
				{   
					return true;
				} 
        else
          return false;					   
			}
		}  
		else
		{
			if(yf-yi==0)
			{   
				if((xf-xi)==1||(xf-xi==-1))
					return true;
			  else
					return false; 
			}
			else 
			{
				if((xf-xi==1||xf-xi==-1)&&(yf-yi==1||yf-yi==-1)) 
					return true;
				else 
					return false;
			}
		}   
	}	  
}   