package chessGame;
class Knight extends Piece
{
	Knight(String col)
	{
    	color=col;
		status=0;
		type='n';
	}
  boolean pieceValidMove(int xi,int yi,int xf,int yf)
	{
		//checking whether piece can move to fianl position or not.
		if(xi==xf&&yi==yf)
			return false;
		else if((yf==yi+2)&&((xf==xi-1)||(xf==xi+1)))
			return true;
		else if((yf==yi-2)&&((xf==xi-1)||(xf==xi+1)))
		  return true;
		else if((xf==xi-2)&&((yf==yi-1)||(yf==yi+1)))
			return true;
		else if((xf==xi+2)&&((yf==yi-1)||(yf==yi+1)))
			return true;
		else 
      return false;				
	}	  
}  