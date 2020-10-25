# Chessboard
Chess game

1. Objectives

Use Java to Develop chess toy game.

Use Test Driven Development.

Use JUnit to write unit tests while implementing a new program.

2. Tasks

2.1. Implementing the Modified Chess program

I am just creating a toy chess program that lets you set up pieces on a chessboard, move them, and find possible moves for a given piece in a certain position. I am not implementing Deep Blue. Because I am simplifying so many rules, I will call this game, Modified chESS or MESS!


Chess is played on an 8 X 8 board where the initial placement of pieces is as shown in the following figure, taken from Wikipedia. Note the indexing scheme. The white king is on e1, and the black king is on e8. Familiarize yourself with the names of the pieces.

Chess Board

Each chess piece can move in a specific way. Details of the original rules are provided here. However, I will follow a simplified version in this assignment. Most importantly, I will ignore an important rule in chess: Moving any piece in a way that puts your own king in check is illegal. Since I don't know what check means, for us a move is legal if the piece I are moving has an empty square to move to or can capture (replace) an opponent's piece (including their king, although that's also illegal in real chess). The simplified rules are as follows:


Assume that the queen and knight can't move.
The king can only move one square horizontally, vertically, or diagonally. Assume that it cannot castle.
A pawn in the initial position may move one or two squares vertically forward to an empty square but cannot leap over any piece. Subsequently it can move only one square vertically forward to an empty square. A pawn may also capture (replace) an opponent's piece diagonally one square in front of it. Pawns can never move backwards. These are the only moves; I will not implement the En passant rule and will also not allow promotion to another piece if the pawn reaches the end of the column. If you don't know what these rules are, don't worry. I won't use them.
A rook can move any number of squares horizontally or vertically, forward or backward, as long as it does not have to leap over other pieces. At the end of the move, it can occupy a previously empty square or capture (replace) an opponent's piece but it cannot replace another piece of the same player.
A bishop can move any number of squares diagonally in any direction as long as it does not have to leap over other pieces. At the end of the move, it can occupy a previously empty square or capture (replace) an opponent's piece but it cannot replace another piece of the same player.
I have implement eight classes ChessBoard, ChessPiece, Rook, Knight, Bishop, Queen, King, and Pawn, and two exception classes called IllegalPositionException and IllegalMoveException that are described below.

