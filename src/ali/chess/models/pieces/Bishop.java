package ali.chess.models.pieces;

import ali.chess.models.Board;
import ali.chess.models.Tile;

import java.util.ArrayList;

public class Bishop extends Piece{

    public Bishop(String name, String color) {
        super(name, color);
        if(color == "WHITE"){
            setPath(getPath()+"white_bishop.png");
        }else {
            setPath(getPath()+"black_bishop.png");
        }
    }

    @Override
    public ArrayList<Tile> getPossibleMoves(Board board, int x, int y) {
        return null;
    }

}
