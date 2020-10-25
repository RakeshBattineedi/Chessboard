package a1;

import org.junit.Test;
//import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static junit.framework.TestCase.*;

public class BishopTest {
    private ChessBoard bt = new ChessBoard();
    private Bishop bb = new Bishop(bt, ChessPiece.Color.BLACK);
    private Bishop wb = new Bishop(bt, ChessPiece.Color.WHITE);

    @Test
    public void testlm() {
        bt.initialize();
        try {
            bb.setPosition("c8");
            assertEquals("Array list doesn't match", bb.legalMoves(), new ArrayList<String>());
        } catch (IllegalPositionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testlm1() throws IllegalPositionException {
        bt.initialize();
        bt.placePiece(bb, "d5");
        ArrayList<String> a1, a2;
        a1 = bb.legalMoves();
        a2 = new ArrayList<String>(Arrays.asList("c6", "e6", "c4", "b3", "a2", "e4", "f3", "g2"));
        Collections.sort(a1);
        Collections.sort(a2);
        assertEquals("Array list doesn't match", a1, a2);
    }

    @Test
    public void testlm2() throws IllegalPositionException {
        bt.placePiece(bb, "a8");
        ArrayList<String> a1, a2;
        a1 = bb.legalMoves();
        a2 = new ArrayList<String>(Arrays.asList("b7", "c6", "d5", "e4", "f3", "g2", "h1"));
        Collections.sort(a1);
        Collections.sort(a2);
        assertEquals("Array list doesn't match", a1, a2);
    }

    @Test
    public void testlm3() throws IllegalPositionException {
        bt.placePiece(bb, "h8");
        ArrayList<String> a1, a2;
        a1 = bb.legalMoves();
        a2 = new ArrayList<String>(Arrays.asList("g7", "f6", "e5", "d4", "c3", "b2", "a1"));
        Collections.sort(a1);
        Collections.sort(a2);
        assertEquals("Array list doesn't match", a1, a2);
    }

    @Test
    public void testlm4() throws IllegalPositionException {
        bt.placePiece(bb, "a1");
        ArrayList<String> a1, a2;
        a1 = bb.legalMoves();
        a2 = new ArrayList<String>(Arrays.asList("g7", "f6", "e5", "d4", "c3", "b2", "h8"));
        Collections.sort(a1);
        Collections.sort(a2);
        assertEquals("Array list doesn't match", a1, a2);
    }

    @Test
    public void testlm5() throws IllegalPositionException {
        bt.placePiece(bb, "a8");
        ArrayList<String> a1, a2;
        a1 = bb.legalMoves();
        a2 = new ArrayList<String>(Arrays.asList("b7", "c6", "d5", "e4", "f3", "g2", "h1"));
        Collections.sort(a1);
        Collections.sort(a2);
        assertEquals("Array list doesn't match", a1, a2);
    }

    @Test
    public void testlm6() throws IllegalPositionException {
        Pawn bp = new Pawn(bt, ChessPiece.Color.BLACK);
        bt.placePiece(bp, "e6");
        Pawn wp = new Pawn(bt, ChessPiece.Color.WHITE);
        bt.placePiece(wp, "a6");
        bt.placePiece(bb, "c8");
        ArrayList<String> a1, a2;
        a1 = bb.legalMoves();
        a2 = new ArrayList<String>(Arrays.asList("b7", "a6", "d7"));
        Collections.sort(a1);
        Collections.sort(a2);
        assertEquals("Array list doesn't match", a1, a2);
    }

    @Test
    public void testlm7() throws IllegalPositionException {
        Pawn bp = new Pawn(bt, ChessPiece.Color.BLACK);
        bt.placePiece(bp, "b4");
        Pawn wp = new Pawn(bt, ChessPiece.Color.WHITE);
        bt.placePiece(wp, "f2");
        bt.placePiece(bb, "e1");
        ArrayList<String> a1, a2;
        a1 = bb.legalMoves();
        a2 = new ArrayList<String>(Arrays.asList("f2", "d2", "c3"));
        Collections.sort(a1);
        Collections.sort(a2);
        assertEquals("Array list doesn't match", a1, a2);
    }

    @Test
    public void testlm8() throws IllegalPositionException {
        Pawn bp = new Pawn(bt, ChessPiece.Color.BLACK);
        bt.placePiece(bp, "b1");
        Pawn wp = new Pawn(bt, ChessPiece.Color.WHITE);
        bt.placePiece(wp, "g8");
        bt.placePiece(bb, "h7");
        ArrayList<String> a1, a2;
        a1 = bb.legalMoves();
        a2 = new ArrayList<String>(Arrays.asList("g8", "g6", "f5", "e4", "d3", "c2"));
        Collections.sort(a1);
        Collections.sort(a2);
        assertEquals("Array list doesn't match", a1, a2);
    }

    @Test
    public void testlm9() throws IllegalPositionException {
        Pawn bp = new Pawn(bt, ChessPiece.Color.BLACK);
        bt.placePiece(bp, "b6");
        Pawn wp = new Pawn(bt, ChessPiece.Color.WHITE);
        bt.placePiece(wp, "e1");
        bt.placePiece(bb, "a5");
        ArrayList<String> a1, a2;
        a1 = bb.legalMoves();
        a2 = new ArrayList<String>(Arrays.asList("b4", "c3", "d2", "e1"));
        Collections.sort(a1);
        Collections.sort(a2);
        assertEquals("Array list doesn't match", a1, a2);
    }

    @Test
    public void testc() {
        assertSame("Color is not same", ChessPiece.Color.BLACK, bb.getColor());
        assertSame("Color is not same", ChessPiece.Color.WHITE, wb.getColor());
    }

    @Test
    public void testgp() {
        try {
            bb.setPosition("a8");
            assertEquals("Set position not working properly", "a8", bb.getPosition());
            wb.setPosition("a7");
            assertEquals("Set position not working properly", "a7", wb.getPosition());
        } catch (IllegalPositionException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testpp() {
        try {
            bb.setPosition("a8");
            assertEquals("Row not set properly", 7, bb.row);
            assertEquals("Column not set properly", 0, bb.column);
            wb.setPosition("d7");
            assertEquals("Row not set properly", 6, wb.row);
            assertEquals("Column not set properly", 3, wb.column);
        } catch (IllegalPositionException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testipe() {
        try {
            bb.setPosition("h20");
        } catch (IllegalPositionException e) {
            return;
        }
        fail("IllegalPositionException expected");

    }

    @Test
    public void testts() {
        assertSame("To String not working properly", "\u2657", wb.toString());
        assertSame("To String not working properly", "\u265D", bb.toString());
    }
}
