package ali.chess.models.pieces;

import ali.chess.models.Board;
import ali.chess.models.Tile;

import java.util.ArrayList;

public class Queen extends Piece{

    public Queen(String name, String color) {
        super(name, color);
        if(color == "WHITE"){
            setPath(getPath()+"white_queen.png");
        }else {
            setPath(getPath()+"black_queen.png");
        }
    }

    @Override
    public ArrayList<Tile> getPossibleMoves(Board board, int x, int y) {
        ArrayList<Tile> possibleMoves = new ArrayList<>();

        //Rook movements
        //vertically
        for(int i = 1;i < 8; i++){
            if(isValid(x,y+i)){
                if(board.getTile(x,y+i).isOccupied()){
                    if(!board.getTile(x,y+i).getPiece().getColor().equals(getColor())){
                        possibleMoves.add(board.getTile(x,y+1));
                    }
                    break;
                }else {
                    possibleMoves.add(board.getTile(x,y+i));
                }
            }
        }
        for(int i = 1;i < 8; i++){
            if(isValid(x,y-i)){
                if(board.getTile(x,y-i).isOccupied()){
                    if(!board.getTile(x,y-i).getPiece().getColor().equals(getColor())){
                        possibleMoves.add(board.getTile(x,y-1));
                    }
                    break;
                }else {
                    possibleMoves.add(board.getTile(x,y-i));
                }
            }
        }
        //Horizantally
        for(int i = 1;i < 8; i++){
            if(isValid(x+i,y)){
                if(board.getTile(x+i,y).isOccupied()){
                    if(!board.getTile(x+i,y).getPiece().getColor().equals(getColor())){
                        possibleMoves.add(board.getTile(x+i,y));
                    }
                    break;
                }else {
                    possibleMoves.add(board.getTile(x+i,y));
                }
            }
        }
        for(int i = 1;i < 8; i++){
            if(isValid(x-i,y)){
                if(board.getTile(x-i,y).isOccupied()){
                    if(!board.getTile(x-i,y).getPiece().getColor().equals(getColor())){
                        possibleMoves.add(board.getTile(x-i,y));
                    }
                    break;
                }else {
                    possibleMoves.add(board.getTile(x-i,y));
                }
            }
        }
        //Bishop movements
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
