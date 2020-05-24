package 稀疏算法;

import java.util.Arrays;

public class SparseArrayUtils {





    public static void test() throws Exception {
        //创建一个模拟的2维数组
        int[][]  testArray = new int[11][12];
        testArray[4][5] = 8;
        testArray[6][5] = 9;
        testArray[7][10] = 13;
        testArray[10][8] = 14;

        int[][] sparseArray = saveDataInSparseArray(testArray);
        System.out.println("恢复数据");
        restoreData(sparseArray);

    }


    /**
     * 把数据保存到稀疏数组中
     * @param array
     * @return
     */
    public static int[][] saveDataInSparseArray(int[][] array){
        int sum  = 0;
        int rowLength = array.length-1;
        int colLength = array[0].length-1;




        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j]!=0) {
                    sum++;//知道有几个不同的值了
                }
            }
        }
        //创建稀疏数组
        int[][] sparseArray = new int[sum+1][3];
        sparseArray[0][0] = rowLength;
        sparseArray[0][1] = colLength;
        sparseArray[0][2] = sum;
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j]!=0) {
                    sparseArray[index+1] =new int[]{i,j,array[i][j]};
                    index++;
                }
            }
        }

        String s = Arrays.deepToString(sparseArray);
        System.out.println(s);
        return sparseArray;

    }

    /**
     * 把稀疏数组的数据恢复成原有的数组
     * @param sparseArray
     */
    public static  void  restoreData(int[][] sparseArray) throws Exception {
        if(sparseArray[0].length!=3){
            throw new Exception("数据格式不符合稀疏数组");
        }
        int[][] originalArray = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            int[] array = sparseArray[i];
            originalArray[array[0]-1][array[1]-1]  = array[2];
        }
        System.out.println(Arrays.deepToString(originalArray));
    }
}
