package ali.chess.models.pieces;

import ali.chess.models.Board;
import ali.chess.models.Tile;

import java.util.ArrayList;

public class Knight extends Piece{

    public Knight(String name, String color) {
        super(name, color);
        if(color == "WHITE"){
            setPath(getPath()+"white_knight.png");
        }else {
            setPath(getPath()+"black_knight.png");
        }
    }

    @Override
    public ArrayList<Tile> getPossibleMoves(Board board, int x, int y) {
        return null;
    }
}
