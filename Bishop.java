package a1;

import java.util.ArrayList;

public class Bishop extends ChessPiece {

    public Bishop(ChessBoard board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {

        if (this.color == Color.BLACK)
            return "\u265D";
        else
            return "\u2657";
    }

    @Override
    public ArrayList<String> legalMoves() throws IllegalPositionException {

        ArrayList<String> moves = new ArrayList<String>();

        moves.clear();
        String pos = this.getPosition();
        int y = pos.charAt(0) - 97;
        int x = pos.charAt(1) - 49;


        for(int i=x+1,j=y+1;i<8 && j<8;i++,j++){

            if(this.board.getPiece(""+(char) (97 + j) +(char) (48+i+1))==null)
                moves.add(""+(char) (97 + j) +(char) (48+i+1));
            else if(this.board.getPiece(""+(char) (97 + j) +(char) (48+i+1)).getColor()!=this.color){
                moves.add(""+(char) (97 + j) +(char) (48+i+1));
                break;
            }
            else if(this.board.getPiece(""+(char) (97 + j) +(char) (48+i+1))!=null)
                break;
            else
                break;

        }
        for(int i=x+1,j=y-1;i<8 && j>=0;i++,j--){

            if(this.board.getPiece(""+(char) (97 + j) +(char) (48+i+1))==null)
                moves.add(""+(char) (97 + j) +(char) (48+i+1));
            else if(this.board.getPiece(""+(char) (97 + j) +(char) (48+i+1)).getColor()!=this.color){
                moves.add(""+(char) (97 + j) +(char) (48+i+1));
                break;
            }
            else if(this.board.getPiece(""+(char) (97 + j) +(char) (48+i+1))!=null)
                break;
            else
                break;

        }

        for(int i=x-1,j=y+1;i>=0 && j<8;i--,j++){

            if(this.board.getPiece(""+(char) (97 + j) +(char) (i+48+1))==null)
                moves.add(""+(char) (97 + j) +(char) (i+48+1));
            else if(this.board.getPiece(""+(char) (97 + j) +(char) (i+48+1)).getColor()==this.color) {
//				System.out.println("hi");
                break;
            }
            else if(this.board.getPiece(""+(char) (97 + j) +(char) (i+48+1)).getColor()!=this.color){
                moves.add(""+(char) (97 + j) +(char) (i+48+1));
//				System.out.println("hi");
                break;
            }

            else
                break;
        }
        for(int i=x-1,j=y-1;i>=0 && j>=0;i--,j--){

            if(this.board.getPiece(""+(char) (97 + j) +(char) (i+48+1))==null)
                moves.add(""+(char) (97 + j) +(char) (i+48+1));
            else if(this.board.getPiece(""+(char) (97 + j) +(char) (i+48+1)).getColor()==this.color) {
//				System.out.println("hi");
                break;
            }
            else if(this.board.getPiece(""+(char) (97 + j) +(char) (i+48+1)).getColor()!=this.color){
                moves.add(""+(char) (97 + j) +(char) (i+48+1));
//				System.out.println("hi");
                break;
            }

            else
                break;
        }


        return moves;
    }



}
