package ali.chess.models.pieces;

import ali.chess.models.Board;
import ali.chess.models.Tile;

import java.util.ArrayList;

public class King extends Piece {
    private boolean hasMoved;
    public King(String name, String color) {
        super(name, color);
        if(color == "WHITE"){
            setPath(getPath()+"white_king.png");
        }else {
            setPath(getPath()+"black_king.png");
        }
    }

    @Override
    public ArrayList<Tile> getPossibleMoves(Board board, int x, int y) {
        return null;
    }
}
