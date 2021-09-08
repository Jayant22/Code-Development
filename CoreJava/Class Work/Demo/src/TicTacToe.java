import javax.swing.*;
import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
    static char[] Board = new char[10];
    static int count;
    static Scanner scan = new Scanner(System.in);
    TicTacToe(){
        System.out.println("Welcome to TicTacToe Program");
        Arrays.fill(Board, '1');
    }

    void StartGame(){
        for(int i=1; i<10;i++){
            count++;
            if(count % 2 == 0)
                ComputerPlay();
            else
                HumanPlay();
        }
    }

    void ComputerPlay(){
        ChooseLocationComputer();
    }
    void HumanPlay(){
        ChooseLocationHuman();
    }

    void ChooseLocationComputer(){
        boolean itr=true;
            do{
                int Choice =(int) Math.floor(Math.random()* 10) % 9;
                if(Board[Choice] == '1') {
                	Input(Choice(),Choice);
                }
                    
                else
                    itr=false;

            }while(!itr);
        }

        void ChooseLocationHuman() {
            System.out.println("Enter Cell Number");
            int cell= scan.nextInt();
            char ch;
            System.out.println("Enter X or O");

            do ch = scan.next().charAt(0); while (!Choose(ch)); // do_while loop

            boolean itr = true;
            do {
                if (Board[cell] == '1')
                    Input(ch,cell);
                else {
                    System.out.println("Enter another cell number");
                    cell= scan.nextInt();
                    itr = false;
                }
            }while (!itr);
        }

    char Choice(){
        int Choice =(int) Math.floor(Math.random()* 10) % 2;
        if(Choice % 2 == 0)
            return 'X';
        else
            return 'O';
    }

    void Input(char ch,int Cell){
        Board[Cell]=ch;
        if(Cell == 4 || Cell == 7)
            System.out.println("\n");

        System.out.print(Board[Cell]+"\t");
    }



    boolean Choose(char ch){
        if(ch == 'X' || ch == 'O')
            return true;
        else {
            System.out.println("Enter X or O");
            return false;
        }
    }
    void ShowBoard(){
        for(int i=1; i<10; i++)
        {
            if(i == 1 || i == 4 || i == 7)
                System.out.println("\n");

            System.out.print(i+":"+Board[i]);
        }
    }
    public static void main(String[] args){
        TicTacToe Game = new TicTacToe();
        Game.StartGame();
        Game.ShowBoard();
    }
}
