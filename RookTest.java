package a1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static junit.framework.TestCase.*;

public class RookTest {
    private ChessBoard rt = new ChessBoard();
    private Rook br = new Rook(rt, ChessPiece.Color.BLACK);
    private Rook wr = new Rook(rt, ChessPiece.Color.WHITE);

    @Test
    public void testlm() {
        rt.initialize();
        try {
            br.setPosition("a8");
            assertEquals("Array list doesn't match", br.legalMoves(), new ArrayList<String>());
        } catch (IllegalPositionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testlm1() throws IllegalPositionException {
        rt.initialize();
        rt.placePiece(br, "d4");
        ArrayList<String> a1, a2;
        a1 = br.legalMoves();
        a2 = new ArrayList<String>(Arrays.asList("a4", "b4", "c4", "e4", "f4", "g4", "h4", "d3", "d5", "d6", "d2"));
        Collections.sort(a1);
        Collections.sort(a2);
        assertEquals("Array list doesn't match", a1, a2);
    }

    @Test
    public void testlm2() throws IllegalPositionException {
        Pawn bp = new Pawn(rt, ChessPiece.Color.BLACK);
        rt.placePiece(bp, "d8");
        Pawn wp = new Pawn(rt, ChessPiece.Color.WHITE);
        rt.placePiece(wp, "a3");
        rt.placePiece(br, "a8");
        ArrayList<String> a1, a2;
        a1 = br.legalMoves();
        a2 = new ArrayList<String>(Arrays.asList("b8", "c8", "a7", "a6", "a5", "a4", "a3"));
        Collections.sort(a1);
        Collections.sort(a2);
        assertEquals("Array list doesn't match", a1, a2);
    }

    @Test
    public void testlm3() throws IllegalPositionException {
        Pawn bp = new Pawn(rt, ChessPiece.Color.BLACK);
        rt.placePiece(bp, "a6");
        Pawn wp = new Pawn(rt, ChessPiece.Color.WHITE);
        rt.placePiece(wp, "c1");
        rt.placePiece(br, "a1");
        ArrayList<String> a1, a2;
        a1 = br.legalMoves();
        a2 = new ArrayList<String>(Arrays.asList("b1", "c1", "a2", "a3", "a4", "a5"));
        Collections.sort(a1);
        Collections.sort(a2);
        assertEquals("Array list doesn't match", a1, a2);
    }

    @Test
    public void testlm4() throws IllegalPositionException {
        Pawn bp = new Pawn(rt, ChessPiece.Color.BLACK);
        rt.placePiece(bp, "e1");
        Pawn wp = new Pawn(rt, ChessPiece.Color.WHITE);
        rt.placePiece(wp, "h2");
        rt.placePiece(br, "h1");
        ArrayList<String> a1, a2;
        a1 = br.legalMoves();
        a2 = new ArrayList<String>(Arrays.asList("h2", "g1", "f1"));
        Collections.sort(a1);
        Collections.sort(a2);
        assertEquals("Array list doesn't match", a1, a2);
    }

    @Test
    public void testlm5() throws IllegalPositionException {
        Pawn bp = new Pawn(rt, ChessPiece.Color.BLACK);
        rt.placePiece(bp, "h5");
        Pawn wp = new Pawn(rt, ChessPiece.Color.WHITE);
        rt.placePiece(wp, "d8");
        rt.placePiece(br, "h8");
        ArrayList<String> a1, a2;
        a1 = br.legalMoves();
        a2 = new ArrayList<String>(Arrays.asList("h7", "h6", "g8", "f8", "e8", "d8"));
        Collections.sort(a1);
        Collections.sort(a2);
        assertEquals("Array list doesn't match", a1, a2);
    }

    @Test
    public void testlm6() throws IllegalPositionException {
        rt.placePiece(br, "c8");
        ArrayList<String> a1, a2;
        a1 = br.legalMoves();
        a2 = new ArrayList<String>(Arrays.asList("b8", "a8", "d8", "e8", "f8", "g8", "h8", "c7", "c6", "c5", "c4", "c3", "c2", "c1"));
        Collections.sort(a1);
        Collections.sort(a2);
        assertEquals("Array list doesn't match", a1, a2);
    }

    @Test
    public void testlm7() throws IllegalPositionException {
        rt.placePiece(br, "a7");
        ArrayList<String> a1, a2;
        a1 = br.legalMoves();
        a2 = new ArrayList<String>(Arrays.asList("a8", "a6", "a5", "a4", "a3", "a2", "a1", "b7", "c7", "d7", "e7", "f7", "g7", "h7"));
        Collections.sort(a1);
        Collections.sort(a2);
        assertEquals("Array list doesn't match", a1, a2);
    }

    @Test
    public void testlm8() throws IllegalPositionException {
        rt.placePiece(br, "f1");
        ArrayList<String> a1, a2;
        a1 = br.legalMoves();
        a2 = new ArrayList<String>(Arrays.asList("g1", "h1", "e1", "d1", "c1", "b1", "a1", "f2", "f3", "f4", "f5", "f6", "f7", "f8"));
        Collections.sort(a1);
        Collections.sort(a2);
        assertEquals("Array list doesn't match", a1, a2);
    }

    @Test
    public void testlm9() throws IllegalPositionException {
        rt.placePiece(br, "h4");
        ArrayList<String> a1, a2;
        a1 = br.legalMoves();
        a2 = new ArrayList<String>(Arrays.asList("h3", "h2", "h1", "h5", "h6", "h7", "h8", "g4", "f4", "e4", "d4", "c4", "b4", "a4"));
        Collections.sort(a1);
        Collections.sort(a2);
        assertEquals("Array list doesn't match", a1, a2);
    }

    @Test
    public void testc() {
        assertSame("Color is not same", ChessPiece.Color.BLACK, br.getColor());
        assertSame("Color is not same", ChessPiece.Color.WHITE, wr.getColor());
    }

    @Test
    public void testgp() {
        try {
            br.setPosition("a8");
            assertEquals("Set position not working properly", "a8", br.getPosition());
            wr.setPosition("a7");
            assertEquals("Set position not working properly", "a7", wr.getPosition());
        } catch (IllegalPositionException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testpp() {
        try {
            br.setPosition("a8");
            assertEquals("Row not set properly", 7, br.row);
            assertEquals("Column not set properly", 0, br.column);
            wr.setPosition("d7");
            assertEquals("Row not set properly", 6, wr.row);
            assertEquals("Column not set properly", 3, wr.column);
        } catch (IllegalPositionException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testipe() {
        try {
            br.setPosition("0000");
        } catch (IllegalPositionException e) {
            return;
        }
        fail("IllegalPositionException expected");

    }

    @Test
    public void testts() {
        assertSame("To String not working properly", "\u2656", wr.toString());
        assertSame("To String not working properly", "\u265C", br.toString());
    }
}


