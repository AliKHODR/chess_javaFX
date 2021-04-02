package ali.chess.models;

import ali.chess.models.pieces.Piece;

public class Tile {

    private boolean isOccupied;
    private Piece piece;
    private String color;
    private boolean isSelected;
    /**
     * highlight possible moves
     */
    private boolean isHighlighted;
    private final int x;
    private final int y;

    public Tile(int x, int y, String color) {
        isOccupied = false;
        this.color = color;
        this.x = x;
        this.y = y;
    }
    @Override
    public String toString() {
        return piece.getName();
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        if(piece != null){
            setOccupied(true);
        }else {
            setOccupied(false);
        }

        this.piece = piece;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public String getColor() {
        return color;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setHighlighted(boolean highlighted) {
        isHighlighted = highlighted;
    }

    public boolean isHighlighted() {
        return isHighlighted;
    }
}
