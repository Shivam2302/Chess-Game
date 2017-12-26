package chessGame;
class Rook extends Piece
{
	Rook(String col)
	{
    	color=col;
		status=0;
		type='r';
	}
  boolean pieceValidMove(int xi,int yi,int xf,int yf)
	{
		//checking whether piece can move to fianl position or not.
		if(xi==xf&&yi==yf)
		  return false;
		else if((xf-xi==0)||(yf-yi==0))
			return true;
		else 
			return false;
	}	  
}  
	