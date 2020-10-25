package a1;

import a1.ChessPiece.Color;

import java.util.ArrayList;

import static java.lang.StrictMath.abs;

public class ChessBoard {

	private ChessPiece[][] board;
	private static final int BOARDSIZE = 8;

	Boolean d=false;
	Boolean ini = true;


	// initializes the board to an 8X8 array with all
	// empty squares. An empty square is null
	ChessBoard() {
		
		board = new ChessPiece[BOARDSIZE][BOARDSIZE];
		

		for (int i = 0; i < BOARDSIZE; i++) {
			for (int j = 0; j < BOARDSIZE; j++) {
				board[i][j] = null;
			}
		}

	}

	// This method initializes the board to the standard chess
	// opening state with indexing as shown in the figure.
	// This method should use the constructors of the appropriate
	// pieces, and call placePiece below to place the newly
	// constructed pieces in the right position.
	public void initialize() {
		
		//creating all the Pawns
		Pawn whitePawnA = new Pawn(this, Color.WHITE);
		Pawn whitePawnB = new Pawn(this, Color.WHITE);
		Pawn whitePawnC = new Pawn(this, Color.WHITE);
		Pawn whitePawnD = new Pawn(this, Color.WHITE);
		Pawn whitePawnE = new Pawn(this, Color.WHITE);
		Pawn whitePawnF = new Pawn(this, Color.WHITE);
		Pawn whitePawnG = new Pawn(this, Color.WHITE);
		Pawn whitePawnH = new Pawn(this, Color.WHITE);
		
		Pawn blackPawnA = new Pawn(this, Color.BLACK);
		Pawn blackPawnB = new Pawn(this, Color.BLACK);
		Pawn blackPawnC = new Pawn(this, Color.BLACK);
		Pawn blackPawnD = new Pawn(this, Color.BLACK);
		Pawn blackPawnE = new Pawn(this, Color.BLACK);
		Pawn blackPawnF = new Pawn(this, Color.BLACK);
		Pawn blackPawnG = new Pawn(this, Color.BLACK);
		Pawn blackPawnH = new Pawn(this, Color.BLACK);
		
		// bishops are always bound the the square color they start on
		Bishop whiteBishopW = new Bishop(this, Color.WHITE);
		Bishop whiteBishopB = new Bishop(this, Color.WHITE);
		Bishop blackBishopW = new Bishop(this, Color.BLACK);
		Bishop blackBishopB = new Bishop(this, Color.BLACK);
		
		// Knights can't move in the game
		Knight whiteKnightW = new Knight(this, Color.WHITE);
		Knight whiteKnightB = new Knight(this, Color.WHITE);
		Knight blackKnightW = new Knight(this, Color.BLACK);
		Knight blackKnightB = new Knight(this, Color.BLACK);
		
		// rooks have the ability to be on any square on the board
		Rook whiteRookW = new Rook(this, Color.WHITE);
		Rook whiteRookB = new Rook(this, Color.WHITE);
		Rook blackRookW = new Rook(this, Color.BLACK);
		Rook blackRookB = new Rook(this, Color.BLACK);
		
		Queen whiteQueen = new Queen(this, Color.WHITE);
		Queen blackQueen = new Queen(this, Color.BLACK);
		
		King whiteKing = new King(this, Color.WHITE);
		King blackKing = new King(this, Color.BLACK);
		
		
		// no need for error checking on the initial board set up
		placePiece(whitePawnA, "a2");
		placePiece(whitePawnB, "b2");
		placePiece(whitePawnC, "c2");
		placePiece(whitePawnD, "d2");
		placePiece(whitePawnE, "e2");
		placePiece(whitePawnF, "f2");
		placePiece(whitePawnG, "g2");
		placePiece(whitePawnH, "h2");
		
		placePiece(blackPawnA, "a7");
		placePiece(blackPawnB, "b7");
		placePiece(blackPawnC, "c7");
		placePiece(blackPawnD, "d7");
		placePiece(blackPawnE, "e7");
		placePiece(blackPawnF, "f7");
		placePiece(blackPawnG, "g7");
		placePiece(blackPawnH, "h7");
		
		placePiece(whiteBishopW, "f1");
		placePiece(whiteBishopB, "c1");
		placePiece(blackBishopW, "c8");
		placePiece(blackBishopB, "f8");
		
		placePiece(whiteKnightW, "b1");
		placePiece(whiteKnightB, "g1");
		placePiece(blackKnightW, "g8");
		placePiece(blackKnightB, "b8");
		
		placePiece(whiteRookW, "h1");
		placePiece(whiteRookB, "a1");
		placePiece(blackRookW, "a8");
		placePiece(blackRookB, "h8");
		
		placePiece(whiteQueen, "d1");
		placePiece(whiteKing, "e1");
		placePiece(blackQueen, "d8");
		placePiece(blackKing, "e8");

	}

	// This method returns the chess piece at a given position.
	// The position is represented as a two-character string
	// (e.g., e8) as described above. The first letter is in lowercase
	// (a..h) and the second letter is a digit (1..8). If the
	// position is illegal because the string contains illegal
	// characters or represents a position outside the board, the exception is
	// thrown.
	public ChessPiece getPiece(String position) throws IllegalPositionException {
		
		int rank = position.charAt(1) - 49;
		int file = position.charAt(0) - 97;
		
		if(rank < 0 || rank > 7 || file < 0 || file > 7)
			throw new IllegalPositionException("Position out of bounds!");
		
		
		
		return board[rank][file];

	}

	// This method tries to place the given piece at a given position,
	// and returns true if successful, and false if there is already
	// a piece of the same player in the given position or the
	// position was illegal for any of the two reasons mentioned
	// in the description of getPiece. If an opponent's piece exists,
	// that piece is captured. If successful, this method should
	// call an appropriate method in the ChessPiece class
	// (i.e., setPosition) to set the piece's position.
	public boolean placePiece(ChessPiece piece, String position) {
		// position a1 = [0][0], e1 = [0][4], d8 = [7][3], h8 = [7][7]
		// ascii 'a' = 97, 'h' = 104, '1' = 49, '8' = 56.
		
		int col = position.charAt(1) - 49;
		int row = position.charAt(0) - 97;
		if(col < 0 || col > 7 || row < 0 || row > 7)
			return false;
//		if(ini){
//			if(board[col][row]==null) {
//			board[col][row] = piece;
//			piece.row=col;
//			piece.column=row;
//			if(position=="e8")
//				ini=false;
//			return true;}
//			else
//				return false;
//		}



		if(piece.toString()=="\u265F" || piece.toString()== "\u2659"){
//			if(d && this.board[row][col]!=null && piece.toString()!=this.board[row][col].toString()) {
////				board[col][row] = null;
//				board[col][row] = piece;
//				this.d=false;
//			}
//			else if(d && this.board[row][col]==null) {
//				this.d=false;
//				return false;
//			}
//			else if(!d && this.board[row][col]!=null)
//					return false;
//			else
				board[col][row] = piece;
		}
		if(piece.toString()=="\u265C" || piece.toString()== "\u2656"){

			if(this.board[row][col]!=null && piece.toString()!=this.board[row][col].toString()){
				board[col][row] = null;
				board[col][row] = piece;

			}
			else
				board[col][row] = piece;
		}
		else
			board[col][row] = piece;


//		board[col][row] = piece;
		piece.row=col;
		piece.column=row;
		
		return true;

	}

	// This method checks if moving the piece from the fromPosition to
	// toPosition is a legal move. Legality is defined based on the
	// rules described above in Section 2.1. If the move is legal,
	// it executes the move, changing the value of the board as needed.
	// Otherwise, the stated exception is thrown.
	public void move(String fromPosition, String toPosition) throws IllegalMoveException, IllegalPositionException {

		ChessPiece p = this.getPiece(fromPosition);
		ArrayList list = p. legalMoves();
//		System.out.println(list.get(0));
		if(list.contains(toPosition)) {
			Boolean result = this.placePiece(p, toPosition);
			if(abs(fromPosition.charAt(0)-toPosition.charAt(0))== 1)
					this.d=true;
			if(result)
				this.board[fromPosition.charAt(1) - 49][fromPosition.charAt(0) - 97]=null;
			if(!result)
				throw new IllegalPositionException("Error: not a legal Position.");
		}
		else
			throw new IllegalMoveException("Error: not a legal move.");

	}

	// You must include the following toString method to help debug your program.
	// We assume that ChessPiece has an appropriately implemented
	// toString method, whose implementation is described below.
	public String toString() {
		
		// provided toString code for debugging
		String chess = "";
		String upperLeft = "\u250C";
		String upperRight = "\u2510";
		String horizontalLine = "\u2500";
		String horizontal3 = horizontalLine + "\u3000" + horizontalLine;
		String verticalLine = "\u2502";
		String upperT = "\u252C";
		String bottomLeft = "\u2514";
		String bottomRight = "\u2518";
		String bottomT = "\u2534";
		String plus = "\u253C";
		String leftT = "\u251C";
		String rightT = "\u2524";

		String topLine = upperLeft;
		for (int i = 0; i < 7; i++) {
			topLine += horizontal3 + upperT;
		}
		topLine += horizontal3 + upperRight;

		String bottomLine = bottomLeft;
		for (int i = 0; i < 7; i++) {
			bottomLine += horizontal3 + bottomT;
		}
		bottomLine += horizontal3 + bottomRight;
		chess += topLine + "\n";

		for (int row = 7; row >= 0; row--) {
			String midLine = "";
			for (int col = 0; col < 8; col++) {
				if (board[row][col] == null) {
					midLine += verticalLine + " \u3000 ";
				} else {
					midLine += verticalLine + " " + board[row][col] + " ";
				}
			}
			midLine += verticalLine;
			String midLine2 = leftT;
			for (int i = 0; i < 7; i++) {
				midLine2 += horizontal3 + plus;
			}
			midLine2 += horizontal3 + rightT;
			chess += midLine + "\n";
			if (row >= 1)
				chess += midLine2 + "\n";
		}

		chess += bottomLine;
		return chess;

	}

//	public static void main(String[] args) throws IllegalMoveException, IllegalPositionException {
//		
////		System.out.println( (char) 97);
////		System.out.println( '1' - 49);
////		System.out.println( (int) '1');
//		
//		
//		
//		ChessBoard board = new ChessBoard();
////		board.initialize();
////		board.move("d2", "d3");
//
//////		System.out.println(board);
////		board.move("c7", "c6");
////		board.move("c6", "c5");
////		board.move("a7", "a5");
////		board.move("a5", "a4");
////		board.move("a4", "a3");
//		ChessPiece bi = new King(board, ChessPiece.Color.WHITE);
//		board.placePiece(bi, "b2");
//		System.out.println(board);
////		board.move("c1", "h6");
//		ChessPiece bi1 = new Bishop(board, ChessPiece.Color.WHITE);
////		board.placePiece(bi1, "g7");
//		System.out.println(board);
//		board.move("b2", "b3");
////		board.move("e4", "h2");
//
//		System.out.println(board);
//
////		System.out.println(board.getPiece("d2").getPosition());
//	}

}
