package ali.chess.models.pieces;

import ali.chess.models.Board;
import ali.chess.models.Tile;

import java.util.ArrayList;

public abstract class Piece {

    private String name;
    private String color;
    private String PATH = "/assets/pieces/";

    public Piece(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return PATH;
    }

    public String getColor() {
        return color;
    }

    public void setPath(String path) {
        this.PATH = path;
    }
    public abstract ArrayList<Tile> getPossibleMoves(Board board, int x, int y);
    public boolean isValid(int x, int y){
        if(x > 7 || x < 0 || y > 7 || y < 0){
            return false;
        }
        return true;
    }
}
