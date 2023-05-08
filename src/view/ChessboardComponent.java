package view;


import controller.GameController;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static model.Constant.CHESSBOARD_COL_SIZE;
import static model.Constant.CHESSBOARD_ROW_SIZE;

/**
 * This class represents the checkerboard component object on the panel
 */
public class ChessboardComponent extends JComponent {
    private final CellComponent[][] gridComponents = new CellComponent[CHESSBOARD_ROW_SIZE.getNum()][CHESSBOARD_COL_SIZE.getNum()];
    private final int CHESS_SIZE;
    private final Set<ChessboardPoint> riverCell = new HashSet<>();

    private GameController gameController;

    public ChessboardComponent(int chessSize) {
        CHESS_SIZE = chessSize;
        int width = CHESS_SIZE * 7;
        int height = CHESS_SIZE * 9;
        enableEvents(AWTEvent.MOUSE_EVENT_MASK);// Allow mouse events to occur
        setLayout(null); // Use absolute layout.
        setSize(width, height);
        System.out.printf("chessboard width, height = [%d : %d], chess size = %d\n", width, height, CHESS_SIZE);

        initiateGridComponents();
    }


    /**
     * This method represents how to initiate ChessComponent
     * according to Chessboard information
     */
    public void initiateChessComponent(Chessboard chessboard) {
        Cell[][] grid = chessboard.getGrid();
        ChessPiece chessPieceTiger00 = grid[0][0].getPiece();
        gridComponents[0][0].add(
                new TigerChessComponent(
                        chessPieceTiger00.getOwner(),
                        CHESS_SIZE));

        ChessPiece chessPieceTrap02 = grid[0][2].getPiece();
        gridComponents[0][2].add(
                new TrapChessComponent(
                        chessPieceTrap02.getOwner(),
                        CHESS_SIZE));

        ChessPiece chessPieceCave03 = grid[0][3].getPiece();
        gridComponents[0][3].add(
                new CaveChessComponent(
                        chessPieceCave03.getOwner(),
                        CHESS_SIZE));

        ChessPiece chessPieceTrap04 = grid[0][4].getPiece();
        gridComponents[0][4].add(
                new TrapChessComponent(
                        chessPieceTrap04.getOwner(),
                        CHESS_SIZE));

        ChessPiece chessPieceLion06 = grid[0][6].getPiece();
        gridComponents[0][6].add(
                new LionChessComponent(
                        chessPieceLion06.getOwner(),
                        CHESS_SIZE));

        ChessPiece chessPieceDog11 = grid[1][1].getPiece();
        gridComponents[1][1].add(
                new DogChessComponent(
                        chessPieceDog11.getOwner(),
                        CHESS_SIZE));

        ChessPiece chessPieceTrap13 = grid[1][3].getPiece();
        gridComponents[1][3].add(
                new TrapChessComponent(
                        chessPieceTrap13.getOwner(),
                        CHESS_SIZE));

        ChessPiece chessPieceCat15 = grid[1][5].getPiece();
        gridComponents[1][5].add(
                new CatChessComponent(
                        chessPieceCat15.getOwner(),
                        CHESS_SIZE));

        ChessPiece chessPieceMouse20 = grid[2][0].getPiece();
        gridComponents[2][0].add(
                new MouseChessComponent(
                        chessPieceMouse20.getOwner(),
                        CHESS_SIZE));

        ChessPiece chessPieceLeopard22 = grid[2][2].getPiece();
        gridComponents[2][2].add(
                new LeopardChessComponent(
                        chessPieceLeopard22.getOwner(),
                        CHESS_SIZE));

        ChessPiece chessPieceWolf24 = grid[2][4].getPiece();
        gridComponents[2][4].add(
                new WolfChessComponent(
                        chessPieceWolf24.getOwner(),
                        CHESS_SIZE));

        ChessPiece chessPieceElephant26 = grid[2][6].getPiece();
        gridComponents[2][6].add(
                new ElephantChessComponent(
                        chessPieceElephant26.getOwner(),
                        CHESS_SIZE));


        ChessPiece chessPieceLion86 = grid[8][6].getPiece();
        gridComponents[8][6].add(
                new LionChessComponent(
                        chessPieceLion86.getOwner(),
                        CHESS_SIZE));

        ChessPiece chessPieceTrap84 = grid[8][4].getPiece();
        gridComponents[8][4].add(
                new TrapChessComponent(
                        chessPieceTrap84.getOwner(),
                        CHESS_SIZE));

        ChessPiece chessPieceCave83 = grid[8][3].getPiece();
        gridComponents[8][3].add(
                new CaveChessComponent(
                        chessPieceCave83.getOwner(),
                        CHESS_SIZE));

        ChessPiece chessPieceTrap82 = grid[8][2].getPiece();
        gridComponents[8][2].add(
                new TrapChessComponent(
                        chessPieceTrap82.getOwner(),
                        CHESS_SIZE));

        ChessPiece chessPieceTiger80 = grid[8][0].getPiece();
        gridComponents[8][0].add(
                new TigerChessComponent(
                        chessPieceTiger80.getOwner(),
                        CHESS_SIZE));

        ChessPiece chessPieceDog75 = grid[7][5].getPiece();
        gridComponents[7][5].add(
                new DogChessComponent(
                        chessPieceDog75.getOwner(),
                        CHESS_SIZE));

        ChessPiece chessPieceTrap73 = grid[7][3].getPiece();
        gridComponents[7][3].add(
                new TrapChessComponent(
                        chessPieceTrap73.getOwner(),
                        CHESS_SIZE));

        ChessPiece chessPieceCat71 = grid[7][1].getPiece();
        gridComponents[7][1].add(
                new CatChessComponent(
                        chessPieceCat71.getOwner(),
                        CHESS_SIZE));

        ChessPiece chessPieceMouse66 = grid[6][6].getPiece();
        gridComponents[6][6].add(
                new MouseChessComponent(
                        chessPieceMouse66.getOwner(),
                        CHESS_SIZE));

        ChessPiece chessPieceLeopard64 = grid[6][4].getPiece();
        gridComponents[6][4].add(
                new LeopardChessComponent(
                        chessPieceLeopard64.getOwner(),
                        CHESS_SIZE));

        ChessPiece chessPieceWolf62 = grid[6][2].getPiece();
        gridComponents[6][2].add(
                new WolfChessComponent(
                        chessPieceWolf62.getOwner(),
                        CHESS_SIZE));

        ChessPiece chessPieceElephant60 = grid[6][0].getPiece();
        gridComponents[6][0].add(
                new ElephantChessComponent(
                        chessPieceElephant60.getOwner(),
                        CHESS_SIZE));

        //
        /*for (int i = 0; i < CHESSBOARD_ROW_SIZE.getNum(); i++) {
            for (int j = 0; j < CHESSBOARD_COL_SIZE.getNum(); j++) {
                // TODO: Implement the initialization checkerboard

                if (grid[i][j].getPiece() != null) {
                    ChessPiece chessPiece = grid[i][j].getPiece();
                    System.out.println(chessPiece.getOwner());
                    gridComponents[i][j].add(
                            new ElephantChessComponent(
                                    chessPiece.getOwner(),
                                    CHESS_SIZE));
                }
            }
        }*/

    }

    public void initiateGridComponents() {

        riverCell.add(new ChessboardPoint(3,1));
        riverCell.add(new ChessboardPoint(3,2));
        riverCell.add(new ChessboardPoint(4,1));
        riverCell.add(new ChessboardPoint(4,2));
        riverCell.add(new ChessboardPoint(5,1));
        riverCell.add(new ChessboardPoint(5,2));

        riverCell.add(new ChessboardPoint(3,4));
        riverCell.add(new ChessboardPoint(3,5));
        riverCell.add(new ChessboardPoint(4,4));
        riverCell.add(new ChessboardPoint(4,5));
        riverCell.add(new ChessboardPoint(5,4));
        riverCell.add(new ChessboardPoint(5,5));

        for (int i = 0; i < CHESSBOARD_ROW_SIZE.getNum(); i++) {
            for (int j = 0; j < CHESSBOARD_COL_SIZE.getNum(); j++) {
                ChessboardPoint temp = new ChessboardPoint(i, j);
                CellComponent cell;
                if (riverCell.contains(temp)) {
                    cell = new CellComponent(Color.CYAN, calculatePoint(i, j), CHESS_SIZE);
                    this.add(cell);
                } else {
                    cell = new CellComponent(Color.LIGHT_GRAY, calculatePoint(i, j), CHESS_SIZE);
                    this.add(cell);
                }
                gridComponents[i][j] = cell;
            }
        }
    }

    public void registerController(GameController gameController) {
        this.gameController = gameController;
    }

    public void setChessComponentAtGrid(ChessboardPoint point, AnimalChessComponent chess) {
        getGridComponentAt(point).add(chess);
        /*if (!(getChessboardPoint(point)==null)){
            if (chess.getRank()>=)
        }*/
    }

    public AnimalChessComponent removeChessComponentAtGrid(ChessboardPoint point) {
        // Note re-validation is required after remove / removeAll.
        AnimalChessComponent chess = (AnimalChessComponent) getGridComponentAt(point).getComponents()[0];
        getGridComponentAt(point).removeAll();
        getGridComponentAt(point).revalidate();
        chess.setSelected(false);
        return chess;
    }

    /*public LionChessComponent removeChessComponentAtGrid(ChessboardPoint point) {
        // Note re-validation is required after remove / removeAll.
        LionChessComponent chess = (LionChessComponent) getGridComponentAt(point).getComponents()[0];
        getGridComponentAt(point).removeAll();
        getGridComponentAt(point).revalidate();
        chess.setSelected(false);
        return chess;
    }

    public TigerChessComponent removeChessComponentAtGrid(ChessboardPoint point) {
        // Note re-validation is required after remove / removeAll.
        TigerChessComponent chess = (TigerChessComponent) getGridComponentAt(point).getComponents()[0];
        getGridComponentAt(point).removeAll();
        getGridComponentAt(point).revalidate();
        chess.setSelected(false);
        return chess;
    }

    public LeopardChessComponent removeChessComponentAtGrid(ChessboardPoint point) {
        // Note re-validation is required after remove / removeAll.
        LeopardChessComponent chess = (LeopardChessComponent) getGridComponentAt(point).getComponents()[0];
        getGridComponentAt(point).removeAll();
        getGridComponentAt(point).revalidate();
        chess.setSelected(false);
        return chess;
    }

    public ElephantChessComponent removeChessComponentAtGrid(ChessboardPoint point) {
        // Note re-validation is required after remove / removeAll.
        ElephantChessComponent chess = (ElephantChessComponent) getGridComponentAt(point).getComponents()[0];
        getGridComponentAt(point).removeAll();
        getGridComponentAt(point).revalidate();
        chess.setSelected(false);
        return chess;
    }

    public ElephantChessComponent removeChessComponentAtGrid(ChessboardPoint point) {
        // Note re-validation is required after remove / removeAll.
        ElephantChessComponent chess = (ElephantChessComponent) getGridComponentAt(point).getComponents()[0];
        getGridComponentAt(point).removeAll();
        getGridComponentAt(point).revalidate();
        chess.setSelected(false);
        return chess;
    }

    public ElephantChessComponent removeChessComponentAtGrid(ChessboardPoint point) {
        // Note re-validation is required after remove / removeAll.
        ElephantChessComponent chess = (ElephantChessComponent) getGridComponentAt(point).getComponents()[0];
        getGridComponentAt(point).removeAll();
        getGridComponentAt(point).revalidate();
        chess.setSelected(false);
        return chess;
    }

    public ElephantChessComponent removeChessComponentAtGrid(ChessboardPoint point) {
        // Note re-validation is required after remove / removeAll.
        ElephantChessComponent chess = (ElephantChessComponent) getGridComponentAt(point).getComponents()[0];
        getGridComponentAt(point).removeAll();
        getGridComponentAt(point).revalidate();
        chess.setSelected(false);
        return chess;
    }

    public ElephantChessComponent removeChessComponentAtGrid(ChessboardPoint point) {
        // Note re-validation is required after remove / removeAll.
        ElephantChessComponent chess = (ElephantChessComponent) getGridComponentAt(point).getComponents()[0];
        getGridComponentAt(point).removeAll();
        getGridComponentAt(point).revalidate();
        chess.setSelected(false);
        return chess;
    }

    public ElephantChessComponent removeChessComponentAtGrid(ChessboardPoint point) {
        // Note re-validation is required after remove / removeAll.
        ElephantChessComponent chess = (ElephantChessComponent) getGridComponentAt(point).getComponents()[0];
        getGridComponentAt(point).removeAll();
        getGridComponentAt(point).revalidate();
        chess.setSelected(false);
        return chess;
    }*/

    private CellComponent getGridComponentAt(ChessboardPoint point) {
        return gridComponents[point.getRow()][point.getCol()];
    }

    private ChessboardPoint getChessboardPoint(Point point) {
        System.out.println("[" + point.y/CHESS_SIZE +  ", " +point.x/CHESS_SIZE + "] Clicked");
        return new ChessboardPoint(point.y/CHESS_SIZE, point.x/CHESS_SIZE);
    }
    private Point calculatePoint(int row, int col) {
        return new Point(col * CHESS_SIZE, row * CHESS_SIZE);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    @Override
    protected void processMouseEvent(MouseEvent e) {
        if (e.getID() == MouseEvent.MOUSE_PRESSED) {
            JComponent clickedComponent = (JComponent) getComponentAt(e.getX(), e.getY());
            if (clickedComponent.getComponentCount() == 0) {
                System.out.print("None chess here and ");
                gameController.onPlayerClickCell(getChessboardPoint(e.getPoint()), (CellComponent) clickedComponent);
            } else {
                System.out.print("One chess here and ");
                //gameController.onPlayerClickChessPiece(getChessboardPoint(e.getPoint()), (ElephantChessComponent) clickedComponent.getComponents()[0]);
                gameController.onPlayerClickChessPiece(getChessboardPoint(e.getPoint()), (AnimalChessComponent) clickedComponent.getComponents()[0]);
            }
        }
    }
}
