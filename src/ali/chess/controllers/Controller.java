package ali.chess.controllers;

import ali.chess.models.Board;
import ali.chess.models.Game;
import ali.chess.models.Tile;
import ali.chess.models.pieces.King;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private Pane pane;
    private String clickedTile;
    private String targetTile;
    private Game game;
    @FXML
    private AnchorPane root;

    @FXML
    private Label currentPlayer;
    @FXML
    private Button restartGame;
    /**
     * initiate Board, and create 64 panes that represent the board and append them to the root Node
     * each pane has an id of two digits [xy] ex: [00] [01]...., it represents the position of each Tile (Coordinate X - Coordinate Y)
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initBoard();
        currentPlayer.textProperty().setValue(game.getCurrentPlayer());
        restartGame.setOnMouseClicked(event -> initBoard());
        root.addEventHandler(MouseEvent.MOUSE_CLICKED, event-> {
            String id;
           if(event.getTarget() instanceof ImageView){
               ImageView imageView = (ImageView) event.getTarget();
               id = imageView.getParent().getId();
           }else {
               Pane pane = (Pane) event.getTarget();
               id = pane.getId();
           }
           game.select(id);
           updateBoard();
        });

    }

    /**
     * initiate Board, and create 64 panes that represent the board and append them to the root Node
     * each pane has an id of two digits [xy] ex: [00] [01]...., it represents the position of each Tile (Coordinate X - Coordinate Y)
     */
    private void initBoard (){
        game = new Game();
        updateBoard();
    }
    private void updateBoard(){
        Tile[][] tiles = game.getBoard().getTiles();
        for(int x=7; x > -1; x--){
            for(int y=7; y > -1;y--){
                pane = new Pane();
                pane.setMinWidth(50);
                pane.setMinHeight(50);
                pane.setLayoutX (y*50);
                pane.setLayoutY(x* 50);
                pane.setId(x + Integer.toString(y));
                pane.setStyle("-fx-background-color:" + tiles[x][y].getColor());
                //pane.setStyle("-fx-border-color:#000000");
                if(tiles[x][y].isSelected()) {
                    pane.setStyle("-fx-background-color:#577f2f" );
                }
                if(tiles[x][y].isHighlighted()) {
                    pane.setStyle("-fx-background-color:#589cc9" );
                } if(tiles[x][y].getPiece() instanceof King && ((King) tiles[x][y].getPiece()).isChecked()) {
                    pane.setStyle("-fx-background-color:#d32a54" );
                }
                if(tiles[x][y].getPiece() != null){
                    String path = tiles[x][y].getPiece().getPath();
                    Image image = new Image(path);
                    ImageView imageView = new ImageView(image);
                    imageView.setImage(image);
                    pane.getChildren().add(imageView);
                }
                root.getChildren().add(pane);
            }
        }

        currentPlayer.textProperty().setValue(game.getCurrentPlayer());
    }

}
