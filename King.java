package a1;

import java.util.ArrayList;

public class King extends ChessPiece {

    public King(ChessBoard board, Color color) {
        super(board, color);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub

        if (this.color == Color.BLACK)
            return "\u265A";
        else
            return "\u2654";
    }

    @Override
    public ArrayList<String> legalMoves() throws IllegalPositionException {
        // TODO Auto-generated method stub

        ArrayList<String> moves = new ArrayList<String>();

        moves.clear();
        String pos = this.getPosition();
        int y = pos.charAt(0) - 97;
        int x = pos.charAt(1) - 49;
        if(x+1<8 && ((this.board.getPiece(""+(char) (97 + y) +(char) (x+49+1))==null) ||this.board.getPiece(""+(char) (97 + y) +(char) (x+49+1)).getColor()!=this.color)) {
            //System.out.println("hi");
            moves.add(""+ (char) (97 + y) + (char) (x + 49 + 1)); // move up
        }
        if(x+1<8 && y+1<8 && ((this.board.getPiece(""+(char) (97 + y+1) +(char) (x+49+1))==null)||(this.board.getPiece(""+(char) (97 + y+1) +(char) (x+49+1)).getColor()!=this.color )))
            moves.add(""+(char) (97 + y+1) +(char) (x+49+1)); //move right diag

        if(x+1<8 && y-1>=0 && ((this.board.getPiece(""+(char) (97 + y-1) +(char) (x+49+1))==null)||(this.board.getPiece(""+(char) (97 + y-1) +(char) (x+49+1)).getColor()!=this.color )))
            moves.add(""+(char) (97 + y-1) +(char) (x+49+1));//move left dia

        if(x>0 && y+1<8 && ((this.board.getPiece(""+(char) (97 + y+1) +(char) (x+49-1))==null)||(this.board.getPiece(""+(char) (97 + y+1) +(char) (x+49-1)).getColor()!=this.color )))
            moves.add(""+(char) (97 + y+1) +(char) (x+49-1));//right dia down

        if(x-1>=0 && y-1>=0 && ((this.board.getPiece(""+(char) (97 + y-1) +(char) (x+49-1))==null)||(this.board.getPiece(""+(char) (97 + y-1) +(char) (x+49-1)).getColor()!=this.color )))
            moves.add(""+(char) (97 + y-1) +(char) (x+49-1));// left dia down

        if(x-1>=0 && ((this.board.getPiece(""+(char) (97 + y) +(char) (x+49-1))==null)||(this.board.getPiece(""+(char) (97 + y) +(char) (x+49-1)).getColor()!=this.color )))
            moves.add(""+(char) (97 + y) +(char) (x+49-1));// down

        if(y+1<8 && ((this.board.getPiece(""+(char) (97 + y+1) +(char) (x+49))==null)||(this.board.getPiece(""+(char) (97 + y+1) +(char) (x+49)).getColor()!=this.color )))
            moves.add(""+(char) (97 + y+1) +(char) (x+49));//right

        if(y-1>=0 && ((this.board.getPiece(""+(char) (97 + y-1) +(char) (x+49))==null)||(this.board.getPiece(""+(char) (97 + y-1) +(char) (x+49)).getColor()!=this.color )))
            moves.add(""+(char) (97 + y-1) +(char) (x+49));//left


        return moves;
    }

}
