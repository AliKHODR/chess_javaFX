package ali.chess.models;

public class Move {
    private final Tile startTile;
    private final Tile endTile;

    public Move(Tile startTile, Tile endTile) {
        this.startTile = startTile;
        this.endTile = endTile;
    }
}
