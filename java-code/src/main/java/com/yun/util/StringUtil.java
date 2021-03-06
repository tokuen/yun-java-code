package com.yun.util;

import java.util.ArrayList;

/**
 * @author: yun<\br>
 * @description: <\br>
 * @date:  2020/9/10 9:30<\br>
*/
public class StringUtil {
    public static String maskName(String name) {
        if (name == null || name.length() < 2) {
            return null;
        }
        if (name.length() == 2) {
            name = name.substring(0, 1) + "*";
        } else {
            name = name.replaceAll(name.substring(1, name.length() - 1), "*");
        }
        return name;
    }

    public static String maskPhone(String tel) {
        if (tel == null || tel.length() < 11) {
            return null;
        }
        tel = tel.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
        return tel;
    }

    //旋转二维数值从行格式变为列格式
    public static String[][] change(String[][] matrix) {
        String[][] temp = new String[matrix[0].length][matrix.length];
        int dst = matrix.length - 1;
        for (int i = 0; i < matrix.length; i++, dst--) {
            for (int j = 0; j < matrix[0].length; j++) {
                temp[j][dst] = matrix[dst][j];
            }
        }
        return temp;
    }

    //将普通的二维数据进行裁剪
    public static String[][] change2(String[][] matrix) {

        //每一块的数据
        ArrayList<String> arrayList = new ArrayList<>();
        //每一块的数量
        ArrayList<Integer> arrayLength = new ArrayList<>();
        //每一块的开始坐标
        ArrayList<Integer> arrayBeginIndex = new ArrayList<>();
        arrayBeginIndex.add(0);
        int maxLength = 0;//最大块的长度
        int maxBlockEndNum = 0;//最大块的结束坐标
        for (int i = 0; i < matrix[0].length; i++) {
            String type = matrix[1][i];
            boolean diff_block_sign = true;
            if (arrayList.size() != 0) {
                diff_block_sign = arrayList.get(0).equals(type);
            }
            if (diff_block_sign == true) {
                arrayList.add(type);
            } else {
                if (maxLength < arrayList.size()) {
                    maxLength = arrayList.size();
                    maxBlockEndNum = i;
                }
                arrayLength.add(arrayList.size());
                arrayList.clear();
                arrayList.add(type);
                arrayBeginIndex.add(i);
            }
        }
        arrayLength.add(arrayList.size());
        String[][] temp = new String[arrayLength.size() + 1][];
        //设置x轴
        System.out.println(maxBlockEndNum + " " + maxLength);
        temp[0] = arraySub(matrix[0], maxBlockEndNum - maxLength, maxBlockEndNum);
//        print(temp[0]);
        for (int i = 0; i < arrayLength.size(); i++) {
            temp[i + 1] = arraySub(matrix[2], arrayBeginIndex.get(i), arrayBeginIndex.get(i) + arrayLength.get(i));
        }
        return temp;
    }

    //截取数组的一部分
    public static String[] arraySub(String[] data, int start, int end) {
        String[] temp = new String[end - start];
        int j = 0;
        for (int i = start; i < end; i++) {
            temp[j] = data[i];
            j++;
        }
        return temp;
    }

}
