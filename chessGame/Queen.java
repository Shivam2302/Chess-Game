package chessGame;
class Queen extends Piece
{
  Queen(String col)
	{
    	color=col;
		status=0;
		type='q';
	}
  boolean pieceValidMove(int xi,int yi,int xf,int yf)
	{
		//checking whether piece can move to final position or not.
		if(xi==xf&&yi==yf)
			return false;
		else if((xf-xi)==0||(yf-yi)==0||(xf-xi)==(yf-yi)||(xf-xi)==(yi-yf))
		  return true;
	  else
			return false;   
	}	  
}  