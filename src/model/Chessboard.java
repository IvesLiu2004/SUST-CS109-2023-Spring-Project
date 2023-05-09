package model;

/**
 * This class store the real chess information.
 * The Chessboard has 9*7 cells, and each cell has a position for chess
 */
public class Chessboard {
    private Cell[][] grid;

    public Chessboard() {
        this.grid =
                new Cell[Constant.CHESSBOARD_ROW_SIZE.getNum()][Constant.CHESSBOARD_COL_SIZE.getNum()];//19X19

        initGrid();
        initPieces();
    }

    private void initGrid() {
        for (int i = 0; i < Constant.CHESSBOARD_ROW_SIZE.getNum(); i++) {
            for (int j = 0; j < Constant.CHESSBOARD_COL_SIZE.getNum(); j++) {
                grid[i][j] = new Cell();
            }
        }
    }

    private void initPieces() {
        grid[0][0].setPiece(new ChessPiece(PlayerColor.BLUE, "Tiger",6));
        grid[0][2].setPiece(new ChessPiece(PlayerColor.BLUE, "Trap",0));
        grid[0][3].setPiece(new ChessPiece(PlayerColor.BLUE, "Cave",0));
        grid[0][4].setPiece(new ChessPiece(PlayerColor.BLUE, "Trap",0));
        grid[0][6].setPiece(new ChessPiece(PlayerColor.BLUE, "Lion",7));
        grid[1][1].setPiece(new ChessPiece(PlayerColor.BLUE, "Dog",3));
        grid[1][3].setPiece(new ChessPiece(PlayerColor.BLUE, "Trap",0));
        grid[1][5].setPiece(new ChessPiece(PlayerColor.BLUE, "Cat",2));
        grid[2][0].setPiece(new ChessPiece(PlayerColor.BLUE, "Mouse",1));
        grid[2][2].setPiece(new ChessPiece(PlayerColor.BLUE, "Leopard",5));
        grid[2][4].setPiece(new ChessPiece(PlayerColor.BLUE, "Wolf",4));
        grid[2][6].setPiece(new ChessPiece(PlayerColor.BLUE, "Elephant",8));
        grid[8][6].setPiece(new ChessPiece(PlayerColor.RED, "Lion",7));
        grid[8][4].setPiece(new ChessPiece(PlayerColor.RED, "Trap",0));
        grid[8][3].setPiece(new ChessPiece(PlayerColor.RED, "Cave",0));
        grid[8][2].setPiece(new ChessPiece(PlayerColor.RED, "TRAP",0));
        grid[8][0].setPiece(new ChessPiece(PlayerColor.RED, "Tiger",6));
        grid[7][5].setPiece(new ChessPiece(PlayerColor.RED, "Dog",3));
        grid[7][3].setPiece(new ChessPiece(PlayerColor.RED, "Trap",0));
        grid[7][1].setPiece(new ChessPiece(PlayerColor.RED, "Cat",2));
        grid[6][6].setPiece(new ChessPiece(PlayerColor.RED, "Mouse",1));
        grid[6][4].setPiece(new ChessPiece(PlayerColor.RED, "Leopard",5));
        grid[6][2].setPiece(new ChessPiece(PlayerColor.RED, "Wolf",4));
        grid[6][0].setPiece(new ChessPiece(PlayerColor.RED, "Elephant",8));
    }//把棋盘写好

    private ChessPiece getChessPieceAt(ChessboardPoint point) {
        return getGridAt(point).getPiece();
    }

    private Cell getGridAt(ChessboardPoint point) {
        return grid[point.getRow()][point.getCol()];
    }

    private int calculateDistance(ChessboardPoint src, ChessboardPoint dest) {
        return Math.abs(src.getRow() - dest.getRow()) + Math.abs(src.getCol() - dest.getCol());
    }
    //初始地 到 目的地  算距离

    private ChessPiece removeChessPiece(ChessboardPoint point) {
        ChessPiece chessPiece = getChessPieceAt(point);
        getGridAt(point).removePiece();
        return chessPiece;
    }//删除point位置的棋子

    private void setChessPiece(ChessboardPoint point, ChessPiece chessPiece) {
        getGridAt(point).setPiece(chessPiece);
    }//在point位置增加chessPiece棋子

    public void moveChessPiece(ChessboardPoint src, ChessboardPoint dest) {
        if (!isValidMove(src, dest)) {
            throw new IllegalArgumentException("Illegal chess move!");
        }
        setChessPiece(dest, removeChessPiece(src));
        /*if (!(getChessPieceAt(src) == null || getChessPieceAt(dest) == null)){
            if (getChessPieceAt(src).getRank()>=getChessPieceAt(dest).getRank()){
                setChessPiece(dest,removeChessPiece(dest));
                setChessPiece(dest,removeChessPiece(src));
            }
            if (getChessPieceAt(src).getRank()<=getChessPieceAt(dest).getRank()){
                setChessPiece(src,removeChessPiece(src));
            }
        }*/
    }//移动棋子从src到dest，并且将src位置棋子删除（？）

    public boolean isValidMove(ChessboardPoint src, ChessboardPoint dest) {
        if (getChessPieceAt(src) == null || getChessPieceAt(dest) != null) {
            return false;
        }
        if (!(getChessPieceAt(src).getName()=="Mouse")) {
            if (dest.getCol() >= 1 && dest.getCol() <= 2 && dest.getRow() >= 3 && dest.getRow() <= 5) {
                return false;//除鼠外进不了河
            }
            if (dest.getCol() >= 4 && dest.getCol() <= 5 && dest.getRow() >= 3 && dest.getRow() <= 5) {
                return false;//除鼠外进不了河
            }
        }
        if (getChessPieceAt(src).getName().equals("Lion") || getChessPieceAt(src).getName().equals("Tiger")){
            if (src.getCol()==1 && src.getRow()==2 && dest.getCol()==1 && dest.getRow()==6 && grid[3][1].getPiece()==null && grid[4][1].getPiece()==null && grid[5][1].getPiece()==null){
                return true;
            }
            if (src.getCol()==2 && src.getRow()==2 && dest.getCol()==2 && dest.getRow()==6 && grid[3][2].getPiece()==null && grid[4][2].getPiece()==null && grid[5][2].getPiece()==null){
                return true;
            }
            if (src.getCol()==4 && src.getRow()==2 && dest.getCol()==4 && dest.getRow()==6 && grid[3][4].getPiece()==null && grid[4][4].getPiece()==null && grid[5][4].getPiece()==null){
                return true;
            }
            if (src.getCol()==5 && src.getRow()==2 && dest.getCol()==5 && dest.getRow()==6 && grid[3][5].getPiece()==null && grid[4][5].getPiece()==null && grid[5][5].getPiece()==null){
                return true;
            }
            if (src.getCol()==1 && src.getRow()==6 && dest.getCol()==1 && dest.getRow()==2 && grid[3][1].getPiece()==null && grid[4][1].getPiece()==null && grid[5][1].getPiece()==null){
                return true;
            }
            if (src.getCol()==2 && src.getRow()==6 && dest.getCol()==2 && dest.getRow()==2 && grid[3][2].getPiece()==null && grid[4][2].getPiece()==null && grid[5][2].getPiece()==null){
                return true;
            }
            if (src.getCol()==4 && src.getRow()==6 && dest.getCol()==4 && dest.getRow()==2 && grid[3][4].getPiece()==null && grid[4][4].getPiece()==null && grid[5][4].getPiece()==null){
                return true;
            }
            if (src.getCol()==5 && src.getRow()==6 && dest.getCol()==5 && dest.getRow()==2 && grid[3][5].getPiece()==null && grid[4][5].getPiece()==null && grid[5][5].getPiece()==null){
                return true;
            }


            if (src.getCol()==0 && src.getRow()==3 && dest.getCol()==3 && dest.getRow()==3 && grid[3][1].getPiece()==null && grid[3][2].getPiece()==null){
                return true;
            }
            if (src.getCol()==0 && src.getRow()==4 && dest.getCol()==3 && dest.getRow()==4 && grid[4][1].getPiece()==null && grid[4][2].getPiece()==null){
                return true;
            }
            if (src.getCol()==0 && src.getRow()==5 && dest.getCol()==3 && dest.getRow()==5 && grid[5][1].getPiece()==null && grid[5][2].getPiece()==null){
                return true;
            }
            if (src.getCol()==3 && src.getRow()==3 && dest.getCol()==6 && dest.getRow()==3 && grid[3][4].getPiece()==null && grid[3][5].getPiece()==null){
                return true;
            }
            if (src.getCol()==3 && src.getRow()==4 && dest.getCol()==6 && dest.getRow()==4 && grid[4][4].getPiece()==null && grid[4][5].getPiece()==null){
                return true;
            }
            if (src.getCol()==3 && src.getRow()==5 && dest.getCol()==6 && dest.getRow()==5 && grid[5][4].getPiece()==null && grid[5][5].getPiece()==null){
                return true;
            }
            if (src.getCol()==3 && src.getRow()==3 && dest.getCol()==0 && dest.getRow()==3 && grid[3][1].getPiece()==null && grid[3][2].getPiece()==null){
                return true;
            }
            if (src.getCol()==3 && src.getRow()==4 && dest.getCol()==0 && dest.getRow()==4 && grid[4][1].getPiece()==null && grid[4][2].getPiece()==null){
                return true;
            }
            if (src.getCol()==3 && src.getRow()==5 && dest.getCol()==0 && dest.getRow()==5 && grid[5][1].getPiece()==null && grid[5][2].getPiece()==null){
                return true;
            }
            if (src.getCol()==6 && src.getRow()==3 && dest.getCol()==3 && dest.getRow()==3 && grid[3][4].getPiece()==null && grid[3][5].getPiece()==null){
                return true;
            }
            if (src.getCol()==6 && src.getRow()==4 && dest.getCol()==3 && dest.getRow()==4 && grid[4][4].getPiece()==null && grid[4][5].getPiece()==null){
                return true;
            }
            if (src.getCol()==6 && src.getRow()==5 && dest.getCol()==3 && dest.getRow()==5 && grid[5][4].getPiece()==null && grid[5][5].getPiece()==null){
                return true;
            }
        }
        return calculateDistance(src, dest) == 1;
    }
    //移动棋子

    public boolean isValidCapture(ChessboardPoint src, ChessboardPoint dest) {
        ChessPiece attacker = getChessPieceAt(src);
        ChessPiece defender = getChessPieceAt(dest);
        if (attacker == null || defender == null){
            return false;
        }
        if (attacker.getOwner() == defender.getOwner()){
            return false;
        }
        if (attacker.getName().equals("Elephant")){
            if (defender.getRank() != 1){
                return true;
            }
            return false;
        }
        if (attacker.getName().equals("Mouse")){
            if ((src.getRow()>=3 && src.getRow()<=5 && src.getCol()>=1 && src.getCol()<=2) || (src.getRow()>=3 && src.getRow()<=5 && src.getCol()>=4 && src.getCol()<=5) ){
                return false;
            }
            if (defender.getName().equals("Elephant") || defender.getRank() <= 1){
                return true;
            }
            return false;
        }
        if ( !(attacker.getName().equals("Elephant") || attacker.getName().equals("Mouse")) ){
            if (attacker.getRank() >= defender.getRank()){
                return true;
            }
            return false;
        }
        // TODO:Fix this method
        return false;
    }
    public void captureChessPiece(ChessboardPoint src, ChessboardPoint dest) {
        if (!(isValidCapture(src, dest))) {
            throw new IllegalArgumentException("Illegal chess capture!");
        }
        ChessPiece attacker = removeChessPiece(src);
        ChessPiece defender = removeChessPiece(dest);
        setChessPiece(dest,attacker);
        // TODO: Finish the method.
    }


    public Cell[][] getGrid() {
        return grid;
    }
    public PlayerColor getChessPieceOwner(ChessboardPoint point) {
        return getGridAt(point).getPiece().getOwner();
    }

    public  PlayerColor getChessOwner(ChessboardPoint point) {
        return getGridAt(point).getPiece().getOwner();
    }
}
