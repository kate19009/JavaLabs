
import java.util.Scanner;

public class Main
        {
            public static void main(String[] args)
            {
                    int size;
                    Scanner in = new Scanner(System.in);
                    System.out.println("Input matrix size");
                    size = in.nextInt();
                    int matrixL [][] = new int[size][size];
                    for(int i=0;i<size;i++)
                    {
                        for (int j=0; j<size; j++)
                        {
                            if (i==j ||  i+j==size-1)
                            {
                                matrixL [i][j] = 1;
                            }
                            else matrixL [i][j] = 0;
                        }
                    }

                    for(int i=0;i<size;i++)
                    {
                        for (int j=0; j<size; j++)
                        {
                           System.out.print(matrixL[i][j] + "\t");
                        }
                    }
                    System.out.println();

            }
        }
