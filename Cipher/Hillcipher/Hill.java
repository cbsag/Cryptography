import java.util.Scanner;

class Hill {
    public static void main( String args[])
    {   
        // System.out.println("HEllo");
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Plain Text");
        String pt = sc.nextLine();
        
        int n = pt.length();
        System.out.println(n);
        
        int matsize = n*n;
        System.out.println("Enter the Key in N*N");
        String key = sc.nextLine();

        if(key.length()== matsize)
        {
            System.out.println("Key is Valid");
            System.out.println("------------------------------------------------------------------------------------");
            int [][] Keymatrix = new int[n][n];
            int [][] PlainTextmatrix = new int[n][1];
            int[][] EncipheredMatrix = new int[n][1];
        
            System.out.println("--- ------");
            System.out.println("Key Matrix :");
            System.out.println("--- ------");
            KeyMatrixGeneration(Keymatrix,n,key);
            System.out.println("----- ---- ------");
            System.out.println("Plain Text Matrix : ");
            System.out.println("----- ---- ------");
            PlainTextMatrixGeneration(PlainTextmatrix,n,pt);
            System.out.println("------ -------------- ---- - -- ");
            System.out.println("Matrix Multiplication with % 26 : ");
            System.out.println("------ -------------- ---- - -- ");
            MatrixMultiplication(EncipheredMatrix,PlainTextmatrix,Keymatrix,n,pt,key);
            System.out.println("-------- ----");
            System.out.println("Ciphered Text :");
            System.out.println("-------- ----");
            String Ckey = MatrixToString(EncipheredMatrix,n);

            // int [][] Keymatrix = new int[n][n];
            int [][] CiperTextmatrix = new int[n][1];
            // int[][] EncipheredMatrix = new int[n][1];
            System.out.println("-------- ---- ------");
            System.out.println("Ciphered Text Vector");
            System.out.println("-------- ---- ------");
            CiperTextMatrixGeneration(CiperTextmatrix,n,Ckey);
        
        }

        else
        {
        System.out.println("Key is Invalid");

        }

    }
    static public int [][] KeyMatrixGeneration (int[][] Keymatrix, int n , String key)
    {
                   
            // int [][] Keymatrix = new int[n][n];
            int k=0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {   int x = ((int)(key.charAt(k)))-65;
                    Keymatrix[i][j] = x;
                    k++;
                }
            }
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    System.out.print(Keymatrix[i][j] + "\t");
                } System.out.print("\n");
            }
            return Keymatrix;

    }
    // ----------------------------------------------------------------------------------------------------
        static public int [][] PlainTextMatrixGeneration (int[][] PlainTextmatrix, int n , String pt)
    {
                   
            // int [][] Keymatrix = new int[n][n];
            int k=0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<1;j++)
                {   int x = ((int)(pt.charAt(k)))-65;
                    PlainTextmatrix[i][j] = x;
                    k++;
                }
            }
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<1;j++)
                {
                    System.out.print(PlainTextmatrix[i][j]+" ");
                } System.out.print("\n");
            }
            return PlainTextmatrix;

    }
// --------------------------------------------------------------------------------------------------------
            static public int [][] MatrixMultiplication (int[][] EncipheredMatrix, int[][] PlainTextmatrix, int[][] Keymatrix, int n , String pt, String Key)
    {
                   
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<1;j++)
                {   EncipheredMatrix[i][j]=0;
                    for(int k=0;k<n;k++)
                    {
                        EncipheredMatrix[i][j]+= Keymatrix[i][k] * PlainTextmatrix[k][j];
                    }
                    EncipheredMatrix[i][j] %=26;
                }

            }

            for(int i=0;i<n;i++)
            {
                for(int j=0;j<1;j++)
                {
                    System.out.print(EncipheredMatrix[i][j]+" ");
                } System.out.print("\n");
            }
            return EncipheredMatrix;

    }
    static public String MatrixToString(int[][] EncipheredMatrix, int n)
    {
        String str="";
         for(int i=0;i<n;i++)
         {
             str += (char) (EncipheredMatrix[i][0] + 65);
            
         } System.out.print(str);
         return str;
    }
        // Decryption 
    static public int [][] CiperTextMatrixGeneration (int[][] CiperTextmatrix, int n , String Ckey)
    {
                   
            // int [][] Keymatrix = new int[n][n];
            int k=0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<1;j++)
                {   int x = ((int)(Ckey.charAt(k)))-65;
                    CiperTextmatrix[i][j] = x;
                    k++;
                }
            }
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<1;j++)
                {
                    System.out.print(CiperTextmatrix[i][j]+" ");
                } System.out.print("\n");
            }
            return CiperTextmatrix;

    }


}