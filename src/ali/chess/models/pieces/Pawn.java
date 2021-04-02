package ali.chess.models.pieces;

import ali.chess.constants.Constants;
import ali.chess.models.Board;
import ali.chess.models.Tile;

import java.util.ArrayList;

public class Pawn extends Piece{
    private boolean hasMoved = false;

    public Pawn(String name, String color) {
        super(name, color);
        if(color.equals("WHITE")){
            setPath(getPath()+"white_pawn.png");
        }else {
            setPath(getPath()+"black_pawn.png");
        }
    }

    @Override
    public ArrayList<Tile> getPossibleMoves(Board board, int x, int y) {
        ArrayList<Tile> possibleMoves = new ArrayList<>();
        if(this.getColor().equals(Constants.WHITE_PLAYER)){
            //advance forward, twice if it has never moved
            if(isValid(x+1,y) && !board.getTile(x+1,y).isOccupied()){
                System.out.println("1x"+x+"y"+y);
                possibleMoves.add(board.getTile(x+1,y));
            }
            if(isValid(x+2, y) && !this.hasMoved && !board.getTile(x+2,y).isOccupied()){
                System.out.println("2x"+x+"y"+y);
                possibleMoves.add(board.getTile(x+2,y));
            }
            //take
            if(isValid(x+1,y+1) && board.getTile(x+1, y+1).isOccupied() && !board.getTile(x+1,y+1).getPiece().getColor().equals(this.getColor())){
                System.out.println("3x"+x+"y"+y);
                possibleMoves.add(board.getTile(x+1,y+1));
            }
        }else{
            //advance forward, twice if it has never moved
            if(isValid(x-1,y) && !board.getTile(x-1,y).isOccupied()){
                System.out.println("1x"+x+"y"+y);
                possibleMoves.add(board.getTile(x-1,y));
            }
            if(isValid(x-2, y) && !this.hasMoved && !board.getTile(x-2,y).isOccupied()){
                System.out.println("2x"+x+"y"+y);
                possibleMoves.add(board.getTile(x-2,y));
            }
            //take
            if(isValid(x-1,y-1) && board.getTile(x-1, y-1).isOccupied() && !board.getTile(x-1,y-1).getPiece().getColor().equals(this.getColor())){
                System.out.println("3x"+x+"y"+y);
                possibleMoves.add(board.getTile(x-1,y-1));
            }
        }
        return possibleMoves;
    }

}
