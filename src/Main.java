import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void clearScreen() {
        for (int i = 0; i < 50; i++) {  // 50 пустых строк
            System.out.println();
        }
    }

    static Scanner in = new Scanner(System.in);

    static char[][] board =
            {
                    {' ', ' ', ' '},
                    {' ', ' ', ' '},
                    {' ', ' ', ' '}
            };

    static int pos;

    static int posComp;

    public static int ValidPosPlayer(){
        while (true){
            try {
                pos = in.nextInt();
                if (pos > 0 & pos < 10) {
                    return pos;
                } else {
                    System.out.print("Введенное значение имеет некорректное значение!\nВыберите позицию (1-9): ");
                    in.nextLine();
                }
            } catch (InputMismatchException e){
                System.out.print("Введенное значение имеет некорректное значение!\nВыберите позицию (1-9): ");
                in.nextLine();
            }
        }
    }

    public static void PlayerTurn(){
        System.out.print("Выберите позицию (1-9): ");
        pos = ValidPosPlayer();
        int row = (pos-1)/3;
        int col = (pos-1)%3;
        if (board[row][col] == ' ')
        {board[row][col] = 'X';}
        else {
            while (board[row][col] != ' '){
                System.out.print("Выбранная позиция недоступна, выберите иную (1-9): ");
                pos = ValidPosPlayer();
                row = (pos-1)/3;
                col = (pos-1)%3;
                if (board[row][col] == ' ')
                {
                    board[row][col] = 'X';
                    break;
                }
            }
        }
        printBoard();
    }

    public static void CompTurn(){
        posComp = new Random().nextInt(9);
        int set = posComp + 1;
        System.out.println("Компьютер выбрал позицию: " + set);
        int row = posComp/3;
        int col = posComp%3;
        if (board[row][col] == ' ')
        {board[row][col] = 'O';}
        else {
            while (board[row][col] != ' ') {
                int New = new Random().nextInt(9);
                row = New / 3;
                col = New % 3;
                if (board[row][col] == ' ') {
                    System.out.print("Она занята, поэтому выбрал: " + New);
                    board[row][col] = 'O';
                    break;
                }
            }
        }
        clearScreen();
        printBoard();
    }

    public static void printBoard(){
        System.out.println("___________");
        for (char[] row : board) {
            for (char cell: row) {
                System.out.print(cell + " | ");}
            System.out.println();
            System.out.println("___________");
        }
    }

    public static void Checking() {
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++){
                if (((board[i][0] == board[i][1]) & (board[i][1] == board[i][2])) & board[i][0] != ' ') {
                    System.out.println("Поздравляем победил: " + board[i][0] + "\nИгра завершена!");
                    //in.close();
                    System.exit(0);
                }
                else if (((board[0][i] == board[1][i]) & (board[1][i] == board[2][i])) & board[0][i] != ' ') {
                    System.out.println("Поздравляем победил: " + board[0][i] + "\nИгра завершена!");
                    //in.close();
                    System.exit(0);
                }
                else if (((board[0][0] == board[1][1]) & (board[1][1] == board[2][2])) | ((board[0][2] == board[1][1]) & (board[1][1] == board[2][0]))) {
                    System.out.println("Поздравляем победил: " + board[0][i] + "\nИгра завершена!");
                    //in.close();
                    System.exit(0);
                }
            }
        }
    }

    public static void main(String[] args) {

        //Вступление
        System.out.println("Крестики-нолики!");

        /* Необходимо сделать инициализацию победы или ничьи
        *  */
        while (true){
                for (int step = 0; step < 5; step++){
                    if (step < 2){
                        PlayerTurn();
                        CompTurn();
                    }
                    else {
                        PlayerTurn();
                        Checking();
                        if (step == 4) {
                            System.out.println("Ничья!\nИгра завершена!");
                            System.exit(0);
                        }
                        CompTurn();
                        Checking();
                    }
                }
                System.out.println("Игра завершена!");
                break;
        }
    }
}