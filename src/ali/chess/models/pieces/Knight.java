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
        ArrayList<Tile> possibleMoves = new ArrayList<>();
        if(isValid(x+2,y+1) &&
                (!board.getTile(x+2,y+1).isOccupied() ||
                (board.getTile(x+2,y+1).isOccupied() && !board.getTile(x+2,y+1).getPiece().getColor().equals(this.getColor()))))
            possibleMoves.add(board.getTile(x+2,y+1));

        if(isValid(x+2,y-1) &&
                (!board.getTile(x+2,y-1).isOccupied() ||
                (board.getTile(x+2,y-1).isOccupied() && !board.getTile(x+2,y-1).getPiece().getColor().equals(getColor()))))
            possibleMoves.add(board.getTile(x+2,y-1));

        if(isValid(x+1,y-2) &&
                (!board.getTile(x+1,y-2).isOccupied() ||
                (board.getTile(x+1,y-2).isOccupied() && !board.getTile(x+1,y-2).getPiece().getColor().equals(getColor()))))
            possibleMoves.add(board.getTile(x+1,y-2));

        if(isValid(x+1,y+2) &&
                (!board.getTile(x+1,y+2).isOccupied() ||
                (board.getTile(x+1,y+2).isOccupied() && !board.getTile(x+1,y+2).getPiece().getColor().equals(getColor()))))
            possibleMoves.add(board.getTile(x+1,y+2));

        if(isValid(x-2,y+1) &&
                (!board.getTile(x-2,y+1).isOccupied() ||
                (board.getTile(x-2,y+1).isOccupied() && !board.getTile(x-2,y+1).getPiece().getColor().equals(getColor()))))
            possibleMoves.add(board.getTile(x-2,y+1));

        if(isValid(x-2,y-1) &&
                (!board.getTile(x-2,y-1).isOccupied() ||
                (board.getTile(x-2,y-1).isOccupied() && !board.getTile(x-2,y-1).getPiece().getColor().equals(getColor()))))
            possibleMoves.add(board.getTile(x-2,y-1));

        if(isValid(x-1,y+2) &&
                (!board.getTile(x-1,y+2).isOccupied() ||
                (board.getTile(x-1,y+2).isOccupied() && !board.getTile(x-1,y+2).getPiece().getColor().equals(getColor()))))
            possibleMoves.add(board.getTile(x-1,y+2));

        if(isValid(x-1,y-2) &&
                (!board.getTile(x-1,y-2).isOccupied() ||
                (board.getTile(x-1,y-2).isOccupied() && !board.getTile(x-1,y-2).getPiece().getColor().equals(getColor()))))
            possibleMoves.add(board.getTile(x-1,y-2));

        return possibleMoves;
    }
}
