package ali.chess.models;

import ali.chess.constants.Constants;
import ali.chess.models.pieces.*;

import javafx.scene.layout.Pane;

import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Board {
    /**
     * represent the horizontal symbol of each square/tile
     */
    public static final int a=0, b=1, c=2, d=3, e=4, f=5, g=6, h=7;

    private Tile[][] tiles = new Tile[8][8];

    public Board () {
        //Color the board
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (((x + y) % 2) == 0) {
                    tiles[x][y] = new Tile(x,y, Constants.WHITE_TILE);
                } else {
                    tiles[x][y] = new Tile(x,y, Constants.BLACK_TILE);
                }
            }
        }

        //initialize the pieces on the board

        //Initialize White pieces
        String color = "WHITE";
        tiles[0][0].setPiece(new Rock("rock", color));
        tiles[0][1].setPiece(new Knight("knight", color));
        tiles[0][2].setPiece(new Bishop("Bishop", color));
        tiles[0][3].setPiece(new Queen("Queen", color));
        tiles[0][4].setPiece(new King(Constants.KING, color));
        tiles[0][5].setPiece(new Bishop("Bishop", color));
        tiles[0][6].setPiece(new Knight("knight", color));
        tiles[0][7].setPiece(new Rock("rock", color));

        for (int i = 0; i < 8; i++) {
            tiles[1][i].setPiece(new Pawn("pawn", color));
        }
        //Initialize Black pieces
        color = "BLACK";
        tiles[7][0].setPiece(new Rock("rock", color));
        tiles[7][1].setPiece(new Knight("knight", color));
        tiles[7][2].setPiece(new Bishop("Bishop", color));
        tiles[7][3].setPiece(new King(Constants.KING, color));
        tiles[7][4].setPiece(new Queen("Queen", color));
        tiles[7][5].setPiece(new Bishop("Bishop", color));
        tiles[7][6].setPiece(new Knight("knight", color));
        tiles[7][7].setPiece(new Rock("rock", color));

        for (int i = 0; i < 8; i++) {
            tiles[6][i].setPiece(new Pawn("pawn", color));
        }
    }

    public ArrayList<Tile> getMoves(Piece piece, int x, int y){
       return piece.getPossibleMoves(this,x,y);

    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public Tile getTile(int x, int y){
        return tiles[x][y];
    }
}
