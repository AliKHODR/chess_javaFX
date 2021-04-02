package ali.chess.models.pieces;

import ali.chess.models.Board;
import ali.chess.models.Tile;

import java.util.ArrayList;

public class King extends Piece {
    private boolean isChecked;
    public King(String name, String color) {
        super(name, color);
        this.isChecked = false;
        if(color == "WHITE"){
            setPath(getPath()+"white_king.png");
        }else {
            setPath(getPath()+"black_king.png");
        }
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public boolean isChecked() {
        return isChecked;
    }

    @Override
    public ArrayList<Tile> getPossibleMoves(Board board, int x, int y) {
        ArrayList<Tile> possibleMoves = new ArrayList<>();

        if(isValid(x, y+1) &&
                (!board.getTile(x, y+1).isOccupied() ||
                        (board.getTile(x, y+1).isOccupied() && board.getTile(x, y+1).getPiece().getColor() != getColor())))
            possibleMoves.add(board.getTile(x,y+1));

        if(isValid(x+1, y+1) &&
                (!board.getTile(x+1, y+1).isOccupied() ||
                        (board.getTile(x+1, y+1).isOccupied() && board.getTile(x+1, y+1).getPiece().getColor() != getColor())))
            possibleMoves.add(board.getTile(x+1,y+1));

        if(isValid(x+1,y) &&
                (!board.getTile(x+1,y).isOccupied() ||
                        (board.getTile(x+1,y).isOccupied() && board.getTile(x+1,y).getPiece().getColor() != getColor())))
            possibleMoves.add(board.getTile(x+1,y));

        if(isValid(x+1,y-1) &&
                (!board.getTile(x+1,y-1).isOccupied() ||
                        (board.getTile(x+1,y-1).isOccupied() && board.getTile(x+1,y-1).getPiece().getColor() != getColor())))
            possibleMoves.add(board.getTile(x+1,y-1));

        if(isValid(x,y-1) &&
                (!board.getTile(x,y-1).isOccupied() ||
                        (board.getTile(x,y-1).isOccupied() && board.getTile(x,y-1).getPiece().getColor() != getColor())))
            possibleMoves.add(board.getTile(x,y-1));

        if(isValid(x-1,y-1) &&
                (!board.getTile(x-1,y-1).isOccupied() ||
                        (board.getTile(x-1,y-1).isOccupied() && board.getTile(x-1,y-1).getPiece().getColor() != getColor())))
            possibleMoves.add(board.getTile(x-1,y-1));

        if(isValid(x-1,y) &&
                (!board.getTile(x-1,y).isOccupied() ||
                        (board.getTile(x-1,y).isOccupied() && board.getTile(x-1,y).getPiece().getColor() != getColor())))
            possibleMoves.add(board.getTile(x-1,y));

        if(isValid(x-1,y+1) &&
                (!board.getTile(x-1,y+1).isOccupied() ||
                        (board.getTile(x-1,y+1).isOccupied() && board.getTile(x-1,y+1).getPiece().getColor() != getColor())))
            possibleMoves.add(board.getTile(x-1,y+1));
        return possibleMoves;
    }
}
