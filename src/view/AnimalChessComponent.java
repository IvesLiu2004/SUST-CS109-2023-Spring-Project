package view;


import model.PlayerColor;

import javax.swing.*;
import java.awt.*;

/**
 * This is the equivalent of the ChessPiece class,
 * but this class only cares how to draw Chess on ChessboardComponent
 */
public abstract class  AnimalChessComponent extends JComponent {
    private PlayerColor owner;

    private boolean selected;

    public AnimalChessComponent(){};

    public AnimalChessComponent(PlayerColor owner, int size) {
        this.owner = owner;
        this.selected = false;
        setSize(size/2, size/2);
        setLocation(0,0);
        setVisible(true);
    }

    public boolean isSelected() {
        return selected;
    }


    @Override
    protected void paintComponent(Graphics g) {
    }

    public abstract void setSelected(boolean b);
    public abstract int getRank();
}


