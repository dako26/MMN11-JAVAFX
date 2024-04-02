/**
 * Sample Skeleton for 'Untitled' Controller Class
 */

package com.example.maman112;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

import java.util.Random;

public class Mmn11Controller {

    @FXML // fx:id="canv"
    private Canvas canv; // Value injected by FXMLLoader
    private GraphicsContext gc;
    @FXML // fx:id="draw"
    private Button draw; // Value injected by FXMLLoader
    private final int SIZE = 100;
    private final int WIDTH = 10;


    @FXML
    void DrawPressed(ActionEvent event) {
        final int TOTAL_SQUARES = SIZE * SIZE;
        final double BLACK_SQUARES_PERCENTAGE = 0.1;

        int blackSquaresCount = (int) (TOTAL_SQUARES * BLACK_SQUARES_PERCENTAGE);
        gc.clearRect(0, 0, canv.getWidth(), canv.getHeight());
        Random r = new Random();
        Color[][] matrix = new Color[SIZE][SIZE];
        for (int j = 0; j < SIZE; j++) {
            for (int i = 0; i < SIZE; i++) {
                if (blackSquaresCount > 0 && r.nextDouble() < BLACK_SQUARES_PERCENTAGE) {
                    matrix[i][j] = Color.BLACK;
                    blackSquaresCount--;
                } else {
                    matrix[i][j] = Color.TRANSPARENT;
                }
            }
        }

        // Draw the squares based on the matrix
        gc.setStroke(Color.BLACK); // Set the stroke color to black
        gc.setLineWidth(1); // Set the stroke width to 1 pixel
        for (int j = 0; j < SIZE; j++) {
            for (int i = 0; i < SIZE; i++) {
                gc.setFill(matrix[i][j]);
                gc.fillRect(i * WIDTH, j * WIDTH, WIDTH, WIDTH);
                gc.strokeRect(i * WIDTH, j * WIDTH, WIDTH, WIDTH); // Draw the border
            }
        }
    }


    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert canv != null : "fx:id=\"canv\" was not injected: check your FXML file 'Untitled'.";
        assert draw != null : "fx:id=\"draw\" was not injected: check your FXML file 'Untitled'.";
        gc = canv.getGraphicsContext2D();
    }

}
