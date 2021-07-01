package com.abcd.sort;

import java.util.Arrays;

/**
 * @program: TestMaven
 * @description: 冒泡排序
 * @author: Liu Xinpeng
 * @create: 2021-06-25 10:42
 **/
public class BubbleSort {



    public void sortUp(Integer[] abc) {

        for (int i = 1; i < abc.length; i++) {
            for (int j = 0; j < abc.length - i; j++) {
                if (abc[j] > abc[j+1]) {
                    int def = 0;
                    def = abc[j];
                    abc[j] = abc[j+1];
                    abc[j+1] = def;
                }
            }
        }
        System.out.println(Arrays.toString(abc));
    }

    public void sortDown(Integer[] abc) {

        for (int i = 1; i < abc.length; i++) {
            for (int j = 0; j < abc.length - i; j++) {
                if (abc[j] < abc[j+1]) {
                    int def = 0;
                    def = abc[j];
                    abc[j] = abc[j+1];
                    abc[j+1] = def;
                }
            }
        }
        System.out.println(Arrays.toString(abc));
    }

    public static void main(String[] args) {
        Integer[] abc = {7,5,4,3,6,9,2,1};

        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sortUp(abc);
        bubbleSort.sortDown(abc);
    }
}