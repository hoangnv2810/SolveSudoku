import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;

public class Controller {
    @FXML
    private TextField id00;
    @FXML
    private TextField id01;
    @FXML
    private TextField id02;
    @FXML
    private TextField id03;
    @FXML
    private TextField id04;
    @FXML
    private TextField id05;
    @FXML
    private TextField id06;
    @FXML
    private TextField id07;
    @FXML
    private TextField id08;
    @FXML
    private TextField id10;
    @FXML
    private TextField id11;
    @FXML
    private TextField id12;
    @FXML
    private TextField id13;
    @FXML
    private TextField id14;
    @FXML
    private TextField id15;
    @FXML
    private TextField id16;
    @FXML
    private TextField id17;
    @FXML
    private TextField id18;
    @FXML
    private TextField id20;
    @FXML
    private TextField id21;
    @FXML
    private TextField id22;
    @FXML
    private TextField id23;
    @FXML
    private TextField id24;
    @FXML
    private TextField id25;
    @FXML
    private TextField id26;
    @FXML
    private TextField id27;
    @FXML
    private TextField id28;
    @FXML
    private TextField id30;
    @FXML
    private TextField id31;
    @FXML
    private TextField id32;
    @FXML
    private TextField id33;
    @FXML
    private TextField id34;
    @FXML
    private TextField id35;
    @FXML
    private TextField id36;
    @FXML
    private TextField id37;
    @FXML
    private TextField id38;
    @FXML
    private TextField id40;
    @FXML
    private TextField id41;
    @FXML
    private TextField id42;
    @FXML
    private TextField id43;
    @FXML
    private TextField id44;
    @FXML
    private TextField id45;
    @FXML
    private TextField id46;
    @FXML
    private TextField id47;
    @FXML
    private TextField id48;
    @FXML
    private TextField id50;
    @FXML
    private TextField id51;
    @FXML
    private TextField id52;
    @FXML
    private TextField id53;
    @FXML
    private TextField id54;
    @FXML
    private TextField id55;
    @FXML
    private TextField id56;
    @FXML
    private TextField id57;
    @FXML
    private TextField id58;
    @FXML
    private TextField id60;
    @FXML
    private TextField id61;
    @FXML
    private TextField id62;
    @FXML
    private TextField id63;
    @FXML
    private TextField id64;
    @FXML
    private TextField id65;
    @FXML
    private TextField id66;
    @FXML
    private TextField id67;
    @FXML
    private TextField id68;
    @FXML
    private TextField id70;
    @FXML
    private TextField id71;
    @FXML
    private TextField id72;
    @FXML
    private TextField id73;
    @FXML
    private TextField id74;
    @FXML
    private TextField id75;
    @FXML
    private TextField id76;
    @FXML
    private TextField id77;
    @FXML
    private TextField id78;
    @FXML
    private TextField id80;
    @FXML
    private TextField id81;
    @FXML
    private TextField id82;
    @FXML
    private TextField id83;
    @FXML
    private TextField id84;
    @FXML
    private TextField id85;
    @FXML
    private TextField id86;
    @FXML
    private TextField id87;
    @FXML
    private TextField id88;

    private char[][] board = new char[9][9];
    TextField[][] tfMatrix = new TextField[9][9];
    int[][] rows = new int[9][10];
    int[][] columns = new int[9][10];
    int[][] boxes = new int[9][10];
    boolean sudokuSovled = false;

    @FXML
    void buttonSolve(ActionEvent event) {
        tfMatrix = new TextField[][]{
                {id00, id01, id02, id03, id04, id05, id06, id07, id08},
                {id10, id11, id12, id13, id14, id15, id16, id17, id18},
                {id20, id21, id22, id23, id24, id25, id26, id27, id28},
                {id30, id31, id32, id33, id34, id35, id36, id37, id38},
                {id40, id41, id42, id43, id44, id45, id46, id47, id48},
                {id50, id51, id52, id53, id54, id55, id56, id57, id58},
                {id60, id61, id62, id63, id64, id65, id66, id67, id68},
                {id70, id71, id72, id73, id74, id75, id76, id77, id78},
                {id80, id81, id82, id83, id84, id85, id86, id87, id88}
        };
        System.out.println("First");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                try {
                    board[i][j] = tfMatrix[i][j].getText().charAt(0);
                } catch (Exception e) {
                    board[i][j] = '.';
                }
                System.out.print(board[i][j]);
            }
            System.out.println();
        }

        solveSudoku();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                String tmp = tfMatrix[i][j].getText();
                if(tmp.compareTo("") == 0){
                    tfMatrix[i][j].setStyle("-fx-background-color: DodgerBlue; -fx-border-color: black; -fx-text-fill: white");
                    tfMatrix[i][j].setText(String.valueOf(board[i][j]));
                }
            }
        }
    }

    @FXML
    void buttonReset(ActionEvent event) {
        board = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                tfMatrix[i][j].clear();
                tfMatrix[i][j].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-text-fill: black");
            }
        }
        rows = new int[9][10];
        columns = new int[9][10];
        boxes = new int[9][10];
        sudokuSovled = false;
    }

    @FXML
    void inputNumber(InputMethodEvent event) {
//        if (!newValue.matches("\\d*")) {
//            textField.setText(newValue.replaceAll("[^\\d]", ""));
//        }
    }


    public void solveSudoku() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int d = Character.getNumericValue(board[i][j]);
                    placeNumber(d, i, j);
                }
            }
        }
        backtrack(0, 0);
    }

    public void placeNumber(int d, int row, int col) {
        int idx = (row / 3) * 3 + col / 3;
        rows[row][d]++;
        columns[col][d]++;
        boxes[idx][d]++;
        board[row][col] = (char) (d + '0');
    }

    public void backtrack(int row, int col) {
        if (board[row][col] == '.') {
            for (int d = 1; d < 10; d++) {
                if (countPlace(d, row, col)) {
                    placeNumber(d, row, col);
                    placeNextNumbers(row, col);
                    if (!sudokuSovled) removeNumber(d, row, col);
                }
            }
        } else placeNextNumbers(row, col);
    }

    public boolean countPlace(int d, int row, int col) {
        int idx = (row / 3) * 3 + col / 3;
        return rows[row][d] + columns[col][d] + boxes[idx][d] == 0;
    }

    public void placeNextNumbers(int row, int col) {
        if (row == 8 && col == 8) {
            sudokuSovled = true;
        } else {
            if (col == 8) backtrack(row + 1, 0);
            else backtrack(row, col + 1);
        }
    }

    public void removeNumber(int d, int row, int col) {
        int idx = (row / 3) * 3 + col / 3;
        rows[row][d]--;
        columns[col][d]--;
        boxes[idx][d]--;
        board[row][col] = '.';
    }
}
