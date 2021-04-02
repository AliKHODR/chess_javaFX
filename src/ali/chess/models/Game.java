package ali.chess.models;

import ali.chess.constants.Constants;
import ali.chess.models.pieces.Piece;

import java.util.ArrayList;

public class Game {
    private Board board;
    private String currentPlayer;
    private ArrayList<Move> movesList;
    private Tile selectedTile;
    private ArrayList<Tile> possibleMoves;
    public Game() {
        newGame();
    }
    public void newGame(){
        this.board = new Board();
        this.movesList = new ArrayList<>();
        this.currentPlayer = Constants.WHITE_PLAYER;
    }
    /**
     * takes a pane's id and parses it, in order to get the Tile's position
     * @param id id of Pane
     */
    public void select(String id){
        int x = Integer.parseInt(id.substring(0,1));
        int y = Integer.parseInt(id.substring(1,2));

        Tile tile = board.getTile(x,y);

        cleanHighlightedPossibleMoves();

        //set selected to false, for visual effect
        if(tile.equals(selectedTile)){
            selectedTile.setSelected(false);
            selectedTile = null;
            return;
        }
        if(selectedTile != null ){
            selectedTile.setSelected(false);
        }


        //if tile is not empty or the piece belongs to the current player, assign selectedTile to the clicked Tile
        if(tile.isOccupied() && tile.getPiece().getColor().equals(currentPlayer)){
            selectedTile = tile;
            selectedTile.setSelected(true);
            possibleMoves = board.getMoves(tile.getPiece(), x,y);
            highlightPossibleMoves();
            return;
        }
        if(canMove(tile))
            move(selectedTile, tile);
    }

    private void move(Tile selectedTile, Tile targetTile){
        System.out.println("here2");
        if(!possibleMoves.contains(targetTile)) return;
        Move move = new Move(selectedTile, targetTile);
        if(isMate(selectedTile,targetTile)){
            newGame();
            return;
        }
        Piece piece = selectedTile.getPiece();
        selectedTile.setPiece(null);
        targetTile.setPiece(piece);
        movesList.add(move);
        if(currentPlayer.equals(Constants.WHITE_PLAYER)){
            currentPlayer = Constants.BLACK_PLAYER;
        }else {
            currentPlayer = Constants.WHITE_PLAYER;
        }
    }
    private void highlightPossibleMoves(){
        System.out.println("high");
        if(possibleMoves != null)
            possibleMoves.forEach(possibleMove -> possibleMove.setHighlighted(true));
    }
    private boolean canMove(Tile targetTile){
        if(!possibleMoves.contains(targetTile)) return false;
        return true;
    }
    private void cleanHighlightedPossibleMoves(){
        if(possibleMoves != null)
            possibleMoves.forEach(possibleMove -> possibleMove.setHighlighted(false));
    }
    private boolean isMate(Tile selectedTile, Tile targetTile){
        if(targetTile.getPiece() != null &&
                !selectedTile.getPiece().getColor().equals(targetTile.getPiece().getColor()) &&
                targetTile.getPiece().getName().equals(Constants.KING)){
            return true;
        }
        return false;
    }
    public Board getBoard() {
        return board;
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }
}
