package chessGame;
class Bisoph extends Piece
{
	Bisoph(String col)
	{
    	color=col;
		status=0;
		type ='b';
	}
  boolean pieceValidMove(int xi,int yi,int xf,int yf)
	{
		if(xi==xf&&yi==yf)
			return false;
		else if((xf-xi)==(yf-yi)||(xf-xi)==(yi-yf))
			return true;
		else
	    return false;     
	}	  
} 
