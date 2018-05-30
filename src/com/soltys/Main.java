package com.soltys;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        TicTacToeLogic ttt = new TicTacToeLogic(1);

        while (!ttt.isFinished()) {
            System.out.println("Player " + ttt.getCurrentPlayer() + " write your coordinates.");


                try {
                    int x = scanner.nextInt();
                    int y = scanner.nextInt();
                    ttt.move(x, y);
                } catch (ArrayIndexOutOfBoundsException | InputMismatchException e) {
                    System.out.println("Written wrong coordinates.");
                    scanner.nextLine();
                }
                ttt.printBoard();



            }
        }
    }
