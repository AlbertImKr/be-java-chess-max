package chess;


import chess.pieces.BlankPiece;
import chess.pieces.Color;
import chess.pieces.Piece;

public class Board {

    private Piece[][] pieces;

    public void initialize() {
        this.pieces = BoardUtility.initBoard();
    }

    public String print() {
        return ChessView.print(pieces);
    }

    public Piece findPiece(Position position) {
        int row = position.getRow();
        int column = position.getColumn();
        return pieces[row][column];
    }

    public void move(Position position, Piece piece) {
        int row = position.getRow();
        int column = position.getColumn();
        pieces[row][column] = piece;
    }

    public double calculatePoint(Color color) {
        return ChessView.calculatePoint(color, pieces);

    }

    public void move(Position sourcePosition, Position targetPosition) {
        Piece target = findPiece(sourcePosition);
        move(sourcePosition, new BlankPiece());
        move(targetPosition, target);
    }

}
