import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

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
                if (pos > 0 & pos < 10){return pos;}
                else {
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
            }
        }
        clearScreen();
        printBoard();
    }

    public static void CompTurn(){
        posComp = new Random().nextInt(9);
        System.out.println("Компьютер выбрал позицию: " + posComp);
        int row = posComp/3;
        int col = posComp%3;
        if (board[row][col] == ' ')
        {board[row][col] = 'O';}
        else {
            while (board[row][col] != ' ') {
                posComp = new Random().nextInt(9);
                row = posComp / 3;
                col = posComp % 3;
            }
        }
        clearScreen();
        printBoard();
    }

    public static void printBoard(){
        System.out.println("___________");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " | ");}
            System.out.println();
            System.out.println("___________");
        }
    }

    public static void main(String[] args) {

        //Вступление
        System.out.println("Крестики-нолики!");

        /* Необходимо сделать инициализацию победы или ничьи
        *  */
        while (true){
            {
                PlayerTurn();
                CompTurn();
            }
        }
    }
}