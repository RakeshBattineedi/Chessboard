package a1;

import java.util.ArrayList;

public class Pawn extends ChessPiece {
	int flag =0;
	int flag2 = 0;
	public Pawn(ChessBoard board, Color color) {
		super(board, color);

	}

	@Override
	public String toString() {

		if (this.color == Color.BLACK)
			return "\u265F";
		else
			return "\u2659";
	}

	@Override
	public ArrayList<String> legalMoves() throws IllegalPositionException {

		ArrayList<String> moves = new ArrayList<String>();
//		moves.add("c4");

//
		moves.clear();
		String pos = this.getPosition();
		int y = pos.charAt(0) - 97;
		int x = pos.charAt(1) - 49;



		// pawns need to follow 3 rules:
		// 1. they can only move forward, assuming there is no piece in their way
		// 2. they can only capture diagonally, but do not need to capture
		// 3. the can optionally move forward 2 squares on the first move
		// white pawns advance from rank 2 "up" to rank 8
		// black pawns advance from rank 7 "down to rank 1

		if(this.getColor()==this.color.WHITE) {
			if ((flag == 0 && x==1) && (this.board.getPiece("" + (char) (97 + y) + (char) (x + 49 + 1)) == null) && (this.board.getPiece("" + (char) (97 + y) + (char) (x + 49 + 2)) == null))
				moves.add("" + (char) (97 + y) + (char) (x + 49 + 2));
			if (x + 1 < 8 && (this.board.getPiece("" + (char) (97 + y) + (char) (x + 49 + 1)) == null)) {
				//System.out.println("hi");
				moves.add("" + (char) (97 + y) + (char) (x + 49 + 1)); // move up

			}
			if (x + 1 < 8 && y + 1 < 8 && ((this.board.getPiece(""+(char) (97 + y+1) +(char) (x+49+1))!=null) && (this.board.getPiece("" + (char) (97 + y + 1) + (char) (x + 49 + 1)).getColor() != this.color)))
				moves.add("" + (char) (97 + y + 1) + (char) (x + 49 + 1)); //move right diag

			if (x + 1 < 8 && y - 1 >= 0 &&  ((this.board.getPiece(""+(char) (97 + y-1) +(char) (x+49+1))!=null)&&(this.board.getPiece(""+(char) (97 + y-1) +(char) (x+49+1)).getColor()!=this.color )))
				moves.add("" + (char) (97 + y - 1) + (char) (x + 49 + 1));//move left dia
			flag = 1;
		}
		else{
			if ((flag2 == 0 && x==6) && (this.board.getPiece("" + (char) (97 + y) + (char) (x + 49 - 2)) == null) && (this.board.getPiece("" + (char) (97 + y) + (char) (x + 49 - 1)) == null))
				moves.add(""+(char) (97 + y) +(char) (x+49-2));
				if(x-1>=0 && ((this.board.getPiece(""+(char) (97 + y) +(char) (x+49-1))==null)||(this.board.getPiece(""+(char) (97 + y) +(char) (x+49-1)).getColor()!=this.color )))
					moves.add(""+(char) (97 + y) +(char) (x+49-1));// down
			if(x>0 && y+1<8 && ((this.board.getPiece(""+(char) (97 + y+1) +(char) (x+49-1))!=null)&&(this.board.getPiece(""+(char) (97 + y+1) +(char) (x+49-1)).getColor()!=this.color )))
				moves.add(""+(char) (97 + y+1) +(char) (x+49-1));//right dia down

			if(x-1>=0 && y-1>=0 && ((this.board.getPiece(""+(char) (97 + y-1) +(char) (x+49-1))!=null)&&(this.board.getPiece(""+(char) (97 + y-1) +(char) (x+49-1)).getColor()!=this.color )))
				moves.add(""+(char) (97 + y-1) +(char) (x+49-1));// left dia down

			flag2 = 1;
		}



		return moves;
	}

}
