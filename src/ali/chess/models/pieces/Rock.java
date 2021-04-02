package ali.chess.models.pieces;

import ali.chess.models.Board;
import ali.chess.models.Tile;

import java.util.ArrayList;

public class Rock extends Piece{
    private boolean hasMoved;

    public Rock(String name, String color) {
        super(name, color);
        if(color == "WHITE"){
            setPath(getPath()+"white_rook.png");
        }else {
            setPath(getPath()+"black_rook.png");
        }
    }

    @Override
    public ArrayList<Tile> getPossibleMoves(Board board, int x, int y) {
        return null;
    }
}
