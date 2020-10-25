package a1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static junit.framework.TestCase.*;

public class PawnTest {
    private ChessBoard pt = new ChessBoard();
    private Pawn bp = new Pawn(pt, ChessPiece.Color.BLACK);
    private Pawn wp = new Pawn(pt, ChessPiece.Color.WHITE);

    @Test
    public void testlmb() throws IllegalPositionException {
        Pawn bp1 = new Pawn(pt, ChessPiece.Color.BLACK);
        pt.placePiece(bp1, "f6");
        pt.placePiece(bp, "f7");
        assertEquals("Array list doesn't match", bp.legalMoves(), new ArrayList<String>());
    }

    @Test
    public void testlmb1() throws IllegalPositionException {
        Pawn bp1 = new Pawn(pt, ChessPiece.Color.BLACK);
        pt.placePiece(bp1, "f6");
        pt.placePiece(bp, "f7");
        assertEquals("Array list doesn't match", bp.legalMoves(), new ArrayList<String>());
    }

    @Test
    public void testlmb2() throws IllegalPositionException {
        pt.placePiece(bp, "f7");
        ArrayList<String> a1, a2;
        a1 = bp.legalMoves();
        a2 = new ArrayList<String>(Arrays.asList("f6", "f5"));
        Collections.sort(a1);
        Collections.sort(a2);
        assertEquals("Array list doesn't match", a1, a2);
    }

    @Test
    public void testlmb3() throws IllegalPositionException {
        pt.placePiece(bp, "a6");
        Pawn bp1 = new Pawn(pt, ChessPiece.Color.BLACK);
        pt.placePiece(bp1, "b5");
        ArrayList<String> a1, a2;
        a1 = bp.legalMoves();
        a2 = new ArrayList<String>(Collections.singletonList("a5"));
        Collections.sort(a1);
        Collections.sort(a2);
        assertEquals("Array list doesn't match", a1, a2);
    }

    @Test
    public void testlmb4() throws IllegalPositionException {
        pt.placePiece(bp, "a6");
        Pawn wp1 = new Pawn(pt, ChessPiece.Color.WHITE);
        pt.placePiece(wp1, "b5");
        ArrayList<String> a1, a2;
        a1 = bp.legalMoves();
        a2 = new ArrayList<String>(Arrays.asList("a5", "b5"));
        Collections.sort(a1);
        Collections.sort(a2);
        assertEquals("Array list doesn't match", a1, a2);
    }

    @Test
    public void testlmb5() throws IllegalPositionException {
        pt.placePiece(bp, "h5");
        Pawn bp1 = new Pawn(pt, ChessPiece.Color.BLACK);
        pt.placePiece(bp1, "g4");
        ArrayList<String> a1, a2;
        a1 = bp.legalMoves();
        a2 = new ArrayList<String>(Collections.singletonList("h4"));
        Collections.sort(a1);
        Collections.sort(a2);
        assertEquals("Array list doesn't match", a1, a2);
    }

    @Test
    public void testlmb6() throws IllegalPositionException {
        pt.placePiece(bp, "h5");
        Pawn wp1 = new Pawn(pt, ChessPiece.Color.WHITE);
        pt.placePiece(wp1, "g4");
        ArrayList<String> a1, a2;
        a1 = bp.legalMoves();
        a2 = new ArrayList<String>(Arrays.asList("h4", "g4"));
        Collections.sort(a1);
        Collections.sort(a2);
        assertEquals("Array list doesn't match", a1, a2);
    }

    @Test
    public void testlmb7() throws IllegalPositionException {
        Pawn bp1 = new Pawn(pt, ChessPiece.Color.BLACK);
        pt.placePiece(bp1, "e6");
        Pawn bp2 = new Pawn(pt, ChessPiece.Color.BLACK);
        pt.placePiece(bp2, "f5");
        Pawn wp1 = new Pawn(pt, ChessPiece.Color.WHITE);
        pt.placePiece(wp1, "g6");
        pt.placePiece(bp, "f7");
        ArrayList<String> a1, a2;
        a1 = bp.legalMoves();
        a2 = new ArrayList<String>(Arrays.asList("f6", "g6"));
        Collections.sort(a1);
        Collections.sort(a2);
        assertEquals("Array list doesn't match", a1, a2);
    }

    @Test
    public void testlmb8() throws IllegalPositionException {
        Pawn bp1 = new Pawn(pt, ChessPiece.Color.BLACK);
        pt.placePiece(bp1, "g6");
        Pawn wp2 = new Pawn(pt, ChessPiece.Color.WHITE);
        pt.placePiece(wp2, "f5");
        Pawn wp1 = new Pawn(pt, ChessPiece.Color.WHITE);
        pt.placePiece(wp1, "e6");
        pt.placePiece(bp, "f7");
        ArrayList<String> a1, a2;
        a1 = bp.legalMoves();
        a2 = new ArrayList<String>(Arrays.asList("f6", "e6"));
        Collections.sort(a1);
        Collections.sort(a2);
        assertEquals("Array list doesn't match", a1, a2);
    }

    @Test
    public void testlmw() throws IllegalPositionException {
        Pawn wp1 = new Pawn(pt, ChessPiece.Color.WHITE);
        pt.placePiece(wp1, "e3");
        pt.placePiece(wp, "e2");
        assertEquals("Array list doesn't match", wp.legalMoves(), new ArrayList<String>());
    }

    @Test
    public void testlmw1() throws IllegalPositionException {
        Pawn bp1 = new Pawn(pt, ChessPiece.Color.BLACK);
        pt.placePiece(bp1, "e3");
        pt.placePiece(wp, "e2");
        assertEquals("Array list doesn't match", wp.legalMoves(), new ArrayList<String>());
    }

    @Test
    public void testlmw2() throws IllegalPositionException {
        pt.placePiece(wp, "a2");
        ArrayList<String> a1, a2;
        a1 = wp.legalMoves();
        a2 = new ArrayList<String>(Arrays.asList("a3", "a4"));
        Collections.sort(a1);
        Collections.sort(a2);
        assertEquals("Array list doesn't match", a1, a2);
    }

    @Test
    public void testlmw3() throws IllegalPositionException {
        pt.placePiece(wp, "a3");
        Pawn bp1 = new Pawn(pt, ChessPiece.Color.BLACK);
        pt.placePiece(bp1, "b4");
        ArrayList<String> a1, a2;
        a1 = wp.legalMoves();
        a2 = new ArrayList<String>(Arrays.asList("a4", "b4"));
        Collections.sort(a1);
        Collections.sort(a2);
        assertEquals("Array list doesn't match", a1, a2);
    }

    @Test
    public void testlmw4() throws IllegalPositionException {
        pt.placePiece(wp, "a3");
        Pawn wp1 = new Pawn(pt, ChessPiece.Color.WHITE);
        pt.placePiece(wp1, "b4");
        ArrayList<String> a1, a2;
        a1 = wp.legalMoves();
        a2 = new ArrayList<String>(Arrays.asList("a4"));
        Collections.sort(a1);
        Collections.sort(a2);
        assertEquals("Array list doesn't match", a1, a2);
    }

    @Test
    public void testlmw5() throws IllegalPositionException {
        pt.placePiece(wp, "h5");
        Pawn bp1 = new Pawn(pt, ChessPiece.Color.BLACK);
        pt.placePiece(bp1, "g6");
        ArrayList<String> a1, a2;
        a1 = wp.legalMoves();
        a2 = new ArrayList<String>(Arrays.asList("h6", "g6"));
        Collections.sort(a1);
        Collections.sort(a2);
        assertEquals("Array list doesn't match", a1, a2);
    }

    @Test
    public void testlmw6() throws IllegalPositionException {
        pt.placePiece(wp, "h5");
        Pawn wp1 = new Pawn(pt, ChessPiece.Color.WHITE);
        pt.placePiece(wp1, "g6");
        ArrayList<String> a1, a2;
        a1 = wp.legalMoves();
        a2 = new ArrayList<String>(Collections.singletonList("h6"));
        Collections.sort(a1);
        Collections.sort(a2);
        assertEquals("Array list doesn't match", a1, a2);
    }

    @Test
    public void testlmw7() throws IllegalPositionException {
        Pawn bp1 = new Pawn(pt, ChessPiece.Color.BLACK);
        pt.placePiece(bp1, "e8");
        Pawn bp2 = new Pawn(pt, ChessPiece.Color.BLACK);
        pt.placePiece(bp2, "f9");
        Pawn wp1 = new Pawn(pt, ChessPiece.Color.WHITE);
        pt.placePiece(wp1, "g8");
        pt.placePiece(wp, "f7");
        ArrayList<String> a1, a2;
        a1 = wp.legalMoves();
        a2 = new ArrayList<String>(Arrays.asList("f8", "e8"));
        Collections.sort(a1);
        Collections.sort(a2);
        assertEquals("Array list doesn't match", a1, a2);
    }

    @Test
    public void testlmw8() throws IllegalPositionException {
        Pawn bp1 = new Pawn(pt, ChessPiece.Color.BLACK);
        pt.placePiece(bp1, "g8");
        Pawn wp2 = new Pawn(pt, ChessPiece.Color.WHITE);
        pt.placePiece(wp2, "f9");
        Pawn wp1 = new Pawn(pt, ChessPiece.Color.WHITE);
        pt.placePiece(wp1, "e8");
        pt.placePiece(wp, "f7");
        ArrayList<String> a1, a2;
        a1 = wp.legalMoves();
        a2 = new ArrayList<String>(Arrays.asList("f8", "g8"));
        Collections.sort(a1);
        Collections.sort(a2);
        assertEquals("Array list doesn't match", a1, a2);
    }

    @Test
    public void testc() {
        assertSame("Color is not same", ChessPiece.Color.BLACK, bp.getColor());
        assertSame("Color is not same", ChessPiece.Color.WHITE, wp.getColor());
    }

    @Test
    public void testgp() {
        try {
            bp.setPosition("a8");
            assertEquals("Set position not working properly", "a8", bp.getPosition());
            wp.setPosition("a7");
            assertEquals("Set position not working properly", "a7", wp.getPosition());
        } catch (IllegalPositionException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testpp() {
        try {
            bp.setPosition("a8");
            assertEquals("Row not set properly", 7, bp.row);
            assertEquals("Column not set properly", 0, bp.column);
            wp.setPosition("d7");
            assertEquals("Row not set properly", 6, wp.row);
            assertEquals("Column not set properly", 3, wp.column);
        } catch (IllegalPositionException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testipe() {
        try {
            bp.setPosition("$0");
        } catch (IllegalPositionException e) {
            return;
        }
        fail("IllegalPositionException expected");

    }

    @Test
    public void testts() {
        assertSame("To String not working properly", "\u2659", wp.toString());
        assertSame("To String not working properly", "\u265F", bp.toString());
    }
}

