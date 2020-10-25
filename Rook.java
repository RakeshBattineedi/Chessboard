package a1;

import java.util.ArrayList;

public class Rook extends ChessPiece {

	public Rook(ChessBoard board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {

		if (this.color == Color.BLACK)
			return "\u265C";
		else
			return "\u2656";
	}

	@Override
	public ArrayList<String> legalMoves() throws IllegalPositionException {

		ArrayList<String> moves = new ArrayList<String>();


		moves.clear();
		String pos = this.getPosition();
		int y = pos.charAt(0) - 97;
		int x = pos.charAt(1) - 49;

		for(int i=x+1;i<=7;i++){

			if(this.board.getPiece(""+(char) (97 + y) +(char) (48+i+1))==null)
				moves.add(""+(char) (97 + y) +(char) (48+i+1));
			else if(this.board.getPiece(""+(char) (97 + y) +(char) (48+i+1)).getColor()!=this.color){
				moves.add(""+(char) (97 + y) +(char) (48+i+1));
				break;
			}
			else if(this.board.getPiece(""+(char) (97 + y) +(char) (48+i+1))!=null)
				break;
			else
				break;

		}
		for(int i=x-1;i>=0;i--){

			if(this.board.getPiece(""+(char) (97 + y) +(char) (i+48+1))==null)
				moves.add(""+(char) (97 + y) +(char) (i+48+1));
			else if(this.board.getPiece(""+(char) (97 + y) +(char) (i+48+1)).getColor()==this.color) {
//				System.out.println("hi");
				break;
			}
			else if(this.board.getPiece(""+(char) (97 + y) +(char) (i+48+1)).getColor()!=this.color){
				moves.add(""+(char) (97 + y) +(char) (i+48+1));
//				System.out.println("hi");
				break;
			}

			else
				break;
		}
			for(int i=y+1;i<8;i++){
//				if(y+i<=8 ) {
					if (this.board.getPiece("" + (char) (97 + i) + (char) (x + 49)) == null)
						moves.add("" + (char) (97 + i) + (char) (x + 49));
					else if (this.board.getPiece("" + (char) (97 + i) + (char) (x + 49)).getColor() != this.color) {
						moves.add("" + (char) (97 + i) + (char) (x + 49));
						break;
					} else if (this.board.getPiece("" + (char) (97 + i) + (char) (x + 49)) != null)
						break;
					else
						break;
//				}
			}

		for(int i=y-1;i>=0;i--){
			if(this.board.getPiece(""+(char) (97 +i) +(char) (x+49))==null)
				moves.add(""+(char) (97 +i) +(char) (x+49));
			else if(this.board.getPiece(""+(char) (97 + i) +(char) (x+49)).getColor()!=this.color){
				moves.add(""+(char) (97 +i) +(char) (x+49));
				break;
			}
			else if(this.board.getPiece(""+(char) (97 +i) +(char) (x+49))!=null)
				break;
			else
				break;
		}


		return moves;

	}

}
