package a1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static junit.framework.TestCase.*;

public class KingTest {
    private ChessBoard kt = new ChessBoard();
    private King bk = new King(kt, ChessPiece.Color.BLACK);
    private King wk = new King(kt, ChessPiece.Color.WHITE);

    @Test
    public void testlm() {
        kt.initialize();
        try {
            bk.setPosition("e8");
            assertEquals("Array list doesn't match", bk.legalMoves(), new ArrayList<String>());
        } catch (IllegalPositionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testlm1() throws IllegalPositionException {
        kt.initialize();
        kt.placePiece(bk, "d3");
        ArrayList<String> a1, a2;
        a1 = bk.legalMoves();
        a2 = new ArrayList<String>(Arrays.asList("c4", "d4", "e4", "c3", "e3", "c2", "d2", "e2"));
        Collections.sort(a1);
        Collections.sort(a2);
        assertEquals("Array list doesn't match", a1, a2);
    }

    @Test
    public void testlm2() throws IllegalPositionException {
        kt.initialize();
        kt.placePiece(bk, "d6");
        ArrayList<String> a1, a2;
        a1 = bk.legalMoves();
        a2 = new ArrayList<String>(Arrays.asList("c6", "e6", "c5", "d5", "e5"));
        Collections.sort(a1);
        Collections.sort(a2);
        assertEquals("Array list doesn't match", a1, a2);
    }

    @Test
    public void testlm3() throws IllegalPositionException {
        kt.placePiece(bk, "a1");
        ArrayList<String> a1, a2;
        a1 = bk.legalMoves();
        a2 = new ArrayList<String>(Arrays.asList("a2", "b2", "b1"));
        Collections.sort(a1);
        Collections.sort(a2);
        assertEquals("Array list doesn't match", a1, a2);
    }

    @Test
    public void testlm4() throws IllegalPositionException {
        kt.placePiece(bk, "a8");
        ArrayList<String> a1, a2;
        a1 = bk.legalMoves();
        a2 = new ArrayList<String>(Arrays.asList("a7", "b7", "b8"));
        Collections.sort(a1);
        Collections.sort(a2);
        assertEquals("Array list doesn't match", a1, a2);
    }

    @Test
    public void testlm5() throws IllegalPositionException {
        kt.placePiece(bk, "h1");
        ArrayList<String> a1, a2;
        a1 = bk.legalMoves();
        a2 = new ArrayList<String>(Arrays.asList("h2", "g2", "g1"));
        Collections.sort(a1);
        Collections.sort(a2);
        assertEquals("Array list doesn't match", a1, a2);
    }

    @Test
    public void testlm6() throws IllegalPositionException {
        kt.placePiece(bk, "h8");
        ArrayList<String> a1, a2;
        a1 = bk.legalMoves();
        a2 = new ArrayList<String>(Arrays.asList("h7", "g7", "g8"));
        Collections.sort(a1);
        Collections.sort(a2);
        assertEquals("Array list doesn't match", a1, a2);
    }

    @Test
    public void testlm7() throws IllegalPositionException {
        Pawn bp = new Pawn(kt, ChessPiece.Color.BLACK);
        kt.placePiece(bp, "b7");
        Pawn wp = new Pawn(kt, ChessPiece.Color.WHITE);
        kt.placePiece(wp, "a5");
        kt.placePiece(bk, "a6");
        ArrayList<String> a1, a2;
        a1 = bk.legalMoves();
        a2 = new ArrayList<String>(Arrays.asList("a7", "b6", "b5", "a5"));
        Collections.sort(a1);
        Collections.sort(a2);
        assertEquals("Array list doesn't match", a1, a2);
    }

    @Test
    public void testlm8() throws IllegalPositionException {
        Pawn bp = new Pawn(kt, ChessPiece.Color.BLACK);
        kt.placePiece(bp, "g4");
        Pawn wp = new Pawn(kt, ChessPiece.Color.WHITE);
        kt.placePiece(wp, "h6");
        kt.placePiece(bk, "h5");
        ArrayList<String> a1, a2;
        a1 = bk.legalMoves();
        a2 = new ArrayList<String>(Arrays.asList("h6", "g6", "g5", "h4"));
        Collections.sort(a1);
        Collections.sort(a2);
        assertEquals("Array list doesn't match", a1, a2);
    }

    @Test
    public void testlm9() throws IllegalPositionException {
        Pawn bp = new Pawn(kt, ChessPiece.Color.BLACK);
        kt.placePiece(bp, "d8");
        Pawn wp = new Pawn(kt, ChessPiece.Color.WHITE);
        kt.placePiece(wp, "f8");
        kt.placePiece(bk, "e8");
        ArrayList<String> a1, a2;
        a1 = bk.legalMoves();
        a2 = new ArrayList<String>(Arrays.asList("d7", "e7", "f7", "f8"));
        Collections.sort(a1);
        Collections.sort(a2);
        assertEquals("Array list doesn't match", a1, a2);
    }

    @Test
    public void testlm10() throws IllegalPositionException {
        Pawn bp = new Pawn(kt, ChessPiece.Color.BLACK);
        kt.placePiece(bp, "e1");
        Pawn wp = new Pawn(kt, ChessPiece.Color.WHITE);
        kt.placePiece(wp, "c1");
        kt.placePiece(bk, "d1");
        ArrayList<String> a1, a2;
        a1 = bk.legalMoves();
        a2 = new ArrayList<String>(Arrays.asList("c1", "c2", "d2", "e2"));
        Collections.sort(a1);
        Collections.sort(a2);
        assertEquals("Array list doesn't match", a1, a2);
    }

    @Test
    public void testc() {
        assertSame("Color is not same", ChessPiece.Color.BLACK, bk.getColor());
        assertSame("Color is not same", ChessPiece.Color.WHITE, wk.getColor());
    }

    @Test
    public void testgp() {
        try {
            bk.setPosition("a8");
            assertEquals("Set position not working properly", "a8", bk.getPosition());
            wk.setPosition("a7");
            assertEquals("Set position not working properly", "a7", wk.getPosition());
        } catch (IllegalPositionException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testpp() {
        try {
            bk.setPosition("a8");
            assertEquals("Row not set properly", 7, bk.row);
            assertEquals("Column not set properly", 0, bk.column);
            wk.setPosition("d7");
            assertEquals("Row not set properly", 6, wk.row);
            assertEquals("Column not set properly", 3, wk.column);
        } catch (IllegalPositionException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testipe() {
        try {
            bk.setPosition("$");
        } catch (IllegalPositionException e) {
            return;
        }
        fail("IllegalPositionException expected");

    }

    @Test
    public void testts() {
        assertSame("To String not working properly", "\u2654", wk.toString());
        assertSame("To String not working properly", "\u265A", bk.toString());
    }
}
