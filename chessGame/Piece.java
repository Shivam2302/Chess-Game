package chessGame;
abstract class Piece
{
  String color;
  char type;
  int status;//if 0 piece is alive, if -1 piece is dead;
  int x,y;
  abstract boolean pieceValidMove(int xi,int yi,int xf,int yf);
}