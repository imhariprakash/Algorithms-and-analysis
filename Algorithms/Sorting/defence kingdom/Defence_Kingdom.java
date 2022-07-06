import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

/*
    stratergy game : rectangular grid - dimension given by user
    players take turns placing a mark in a cell
    The player builds crossbow towers in some cells of the grid. Thetower defends all the
    cells in the same row, column. No two towers share common row/column. -> obviously happens 
    in all cases. Give penalty : number of cells in largest undefended rectangle.


    Input : 
        15 8
        {(3, 8), (11, 2), (8,6)}
    output :
        12
 */
 
class Defence_Kingdom{
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        System.out.print("Enter the dimensions of the grid : ");
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        System.out.print("Enter how many towers you want to build : ");
        int n = sc.nextInt();

        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();

        for(int i = 0; i < n; i++){
            System.out.print("Enter the coordinates of the tower : ");
            x.add(sc.nextInt());
            y.add(sc.nextInt());
        }

        Collections.sort(x);
        Collections.sort(y);

        int x_max = 0;
        int y_max = 0;

        for(int i = 0; i < n - 1; i++){
            x_max = Math.max(x_max, x.get(i + 1) - x.get(i) - 1); // -1 -> how many cells are there between two towers
            y_max = Math.max(y_max, y.get(i + 1) - y.get(i) - 1);
        }

        System.out.println(x_max * y_max);



    }

    // public static class Tower{
    //     int row;
    //     int col;
    //     public Tower(int row, int col){
    //         this.row = row;
    //         this.col = col;
    //     }
    // }
}