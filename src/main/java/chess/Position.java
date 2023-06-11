package chess;

import java.util.regex.Pattern;

public class Position {

    public static final String POSITION_PATTERN = "^[a-h][1-8]$";
    public static final String ERROR_POSITION_MESSAGE = "잘못된 위치 정보입니다.";
    private final int row;
    private final int column;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public static Position parse(String position) {
        if (position == null || position.isBlank() || !Pattern.matches(POSITION_PATTERN,
                position)) {
            throw new IllegalArgumentException(ERROR_POSITION_MESSAGE);
        }
        char[] chars = position.toCharArray();
        int column = chars[0] - 'a';
        int row = 8 - (chars[1] - '0');
        return new Position(row, column);
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
