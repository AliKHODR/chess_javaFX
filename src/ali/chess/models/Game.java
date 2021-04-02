package ali.chess.models;

import ali.chess.constants.Constants;
import ali.chess.models.pieces.King;
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

        Move move = new Move(selectedTile, targetTile);
        if(isMate(selectedTile,targetTile)){
            newGame();
            return;
        }
        Piece piece = selectedTile.getPiece();
        piece.setHasMoved(true);
        selectedTile.setPiece(null);
        targetTile.setPiece(piece);
        //Check for possible checks
        isCheckAfterMove();
        movesList.add(move);
        if(currentPlayer.equals(Constants.WHITE_PLAYER)){
            currentPlayer = Constants.BLACK_PLAYER;
        }else {
            currentPlayer = Constants.WHITE_PLAYER;
        }
    }

    private void highlightPossibleMoves(){
        if(possibleMoves != null)
            possibleMoves.forEach(possibleMove -> possibleMove.setHighlighted(true));
    }

    private boolean canMove(Tile targetTile){
        return possibleMoves.contains(targetTile);
    }

    /**
     * Checks if there is any possible check after a move, if so it sets isChecked to true
     */
    private void isCheckAfterMove(){

        ArrayList<Tile> allPossibleMoves = new ArrayList<>();
        Tile[][] tiles = board.getTiles();
        for(int i = 1; i < 8; i++ ){
            for (int j = 1; j < 8; j++) {
                if(tiles[i][j].isOccupied() && !tiles[i][j].getPiece().getColor().equals(currentPlayer)){
                    int x = tiles[i][j].getX();
                    int y = tiles[i][j].getY();
                    ArrayList<Tile> possibleMoves = board.getMoves(tiles[i][j].getPiece(),x,y);
                    if(possibleMoves.size() > 0){
                        //possibleMoves.forEach(s-> System.out.println(s.getPiece()));
                        allPossibleMoves.addAll(possibleMoves);
                    }
                }
            }
        }
        allPossibleMoves.forEach(e-> System.out.println("case"+e.getX()+e.getY()));
        allPossibleMoves.forEach(tile ->{
                 //System.out.println("here"+tile.getX()+tile.getY());
             if(tile.getPiece() instanceof King){
                 //System.out.println("here2");
                 ((King) tile.getPiece()).setChecked(!tile.getPiece().getColor().equals(currentPlayer));
             }

        });
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
