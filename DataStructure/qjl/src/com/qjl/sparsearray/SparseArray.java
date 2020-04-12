package com.qjl.sparsearray;

/***
 * @author qinjielan
 * 稀疏数组
 */
public class SparseArray {
    public static void main(String[] args) {
        twoDimensionalArray();
        toSparseArray();
    }

    public static int[][] chessboard() {
        int[][] chessboardArr = new int[9][10];
        // 1表示黑子，2表示白子，0表示无棋子
        chessboardArr[1][2] = 1;
        chessboardArr[2][3] = 2;
        chessboardArr[1][4] = 1;
        return chessboardArr;
    }

    public static void twoDimensionalArray() {
        int[][] chessboardArr = chessboard();
        // 输出原始二维数组
        System.out.println("原始二维数组");
        for (int[] row : chessboardArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        System.out.println("\n");
    }

    public static void toSparseArray() {
        int[][] chessboardArr = chessboard();
        int sum = 0;
        int lengthX = chessboardArr.length;
        int lengthY = chessboardArr[0].length;
       // System.out.println(lengthX);
       // System.out.println(lengthY);
        for (int i = 0; i < chessboardArr.length; i++) {
            for (int j = 0; j < chessboardArr[i].length; j++) {
                if (chessboardArr[i][j] != 0) {
                    sum++;
                }
            }
        }
        // System.out.println(sum);
        // 创建新的稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        sparseArr[0][0] = lengthX;
        sparseArr[0][1] = lengthY;
        sparseArr[0][2] = sum;
        // 遍历二维数组，将非0的值存入sparseArr中
        int count = 0;
        for (int i = 0; i < chessboardArr.length; i++) {
            for (int j = 0; j < chessboardArr[i].length; j++) {
                if (chessboardArr[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessboardArr[i][j];
                }
            }
        }
        System.out.println("To稀疏数组");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
        }

        System.out.println("--------------------");
        //1.先读取稀疏数组的第一行，根据第一行数据，还原二维数组
        int[][] newTwoDimensionalArr = new int[sparseArr[0][0]][sparseArr[0][1]];
        //2.再读取稀疏数组后面的行数（第二行开始），赋值给二维数组
        for (int i = 1; i < sparseArr.length; i++) {
            newTwoDimensionalArr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        System.out.println("To二维数组");
        for (int[] row : newTwoDimensionalArr) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }


}
