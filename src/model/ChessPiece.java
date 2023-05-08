package model;


public class ChessPiece {
    // the owner of the chess
    private PlayerColor owner;
    /*private PlayerColor elephant;
    private PlayerColor lion;
    private PlayerColor tiger;
    private PlayerColor leopard;
    private PlayerColor wolf;
    private PlayerColor dog;
    private PlayerColor cat;
    private PlayerColor mouse;
    private PlayerColor trap;
    private PlayerColor cave;*/

    // Elephant? Cat? Dog? ...
    private String name;
    private int rank;

    public ChessPiece(PlayerColor owner, String name, int rank) {
        this.owner = owner;
        this.name = name;
        this.rank = rank;
    }

    public boolean canCapture(ChessPiece target) {
        // TODO: Finish this method!
        return false;
    }

    public String getName() {
        return name;
    }

    public PlayerColor getOwner() {
        return owner;
    }

    public int getRank() {
        return rank;
    }
}
