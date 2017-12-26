package chessGame;
class King extends Piece
{
	King(String col)
	{
    	color=col;
		status=0;
		type ='k';
	}
  	boolean pieceValidMove(int xi,int yi,int xf,int yf)
	{
		//checking whether piece can move to fianl position or not.
		if(xi==xf&&yi==yf)
			return false;
		else if((xf-xi)==0&&((yf-yi==1)||(yf-yi==-1)))
			return true;
		else if((yf-yi)==0&&((xf-xi==1)||(xf-xi==-1)))
			return true;
		else if(((yf-yi==1)&&(xf-xi==1))||((yf-yi==-1)&&(xf-xi==-1)))
			return true;
		else if(((yf-yi==1)&&(xi-xf==1))||((yf-yi==-1)&&(xi-xf==-1)))
			return true;
		else 
			return false;   
	}	  
}  
