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
        ArrayList<Tile> possibleMoves = new ArrayList<>();

        for (int i = 1; i < 8 ; i++){
            if(isValid(x+i,y+i)){
                if(board.getTile(x+i,y+i).isOccupied()){
                    if(!board.getTile(x+i,y+i).getPiece().getColor().equals(getColor())){
                        possibleMoves.add(board.getTile(x+i,y+i));
                    }
                    break;
                }else {
                    possibleMoves.add(board.getTile(x+i,y+i));
                }
            }
        }

        for (int i = 1; i < 8 ; i++){
            if(isValid(x+i,y-i)){
                System.out.println(board.getTile(1,4).isOccupied());
                System.out.println(board.getTile(x+i,y-i).isOccupied());
                if(board.getTile(x+i,y-i).isOccupied()){
                    if(!board.getTile(x+i,y-i).getPiece().getColor().equals(getColor())){
                        possibleMoves.add(board.getTile(x+i,y-i));
                    }
                    break;
                }else {

                    possibleMoves.add(board.getTile(x+i,y-i));
                }
            }
        }

        for (int i = 1; i < 8 ; i++){
            if(isValid(x-i,y-i)){
                if(board.getTile(x-i,y-i).isOccupied()){
                    if(!board.getTile(x-i,y-i).getPiece().getColor().equals(getColor())){
                        possibleMoves.add(board.getTile(x-i,y-i));
                    }
                    break;
                }else {
                    possibleMoves.add(board.getTile(x-i,y-i));
                }
            }
        }

        for (int i = 1; i < 8 ; i++){
            if(isValid(x-i,y+i)){
                if(board.getTile(x-i,y+i).isOccupied()){
                    if(!board.getTile(x-i,y+i).getPiece().getColor().equals(getColor())){
                        possibleMoves.add(board.getTile(x-i,y+i));
                    }
                    break;
                }else {
                    possibleMoves.add(board.getTile(x-i,y+i));
                }
            }
        }


        return possibleMoves;
    }

}
