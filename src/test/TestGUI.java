package test;

import java.util.Arrays;

public class TestGUI {  
        /** 
         * 归并排序 
         * 简介:将两个（或两个以上）有序表合并成一个新的有序表 即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列 
         * 时间复杂度为O(nlogn) 
         * 稳定排序方式 
         * @param a 待排序数组 
         * @return 输出有序数组 
         */  
        public static int[] sort(int[] a, int lo, int hi) {  
            int mid = (lo + hi) / 2;  
            if (lo < hi) {  
                // 左边  
            	System.out.println("左" + lo + "," + mid);
                sort(a, lo, mid);  
                // 右边  
                System.out.println("右" + (mid+1) + "," + hi);
                sort(a, mid + 1, hi);  
                // 左右归并  
                merge(a, lo, mid, hi);  
            }  
            return a;  
        }  
      
        public static void merge(int[] a, int lo, int mid, int hi) {  
            int[] temp = new int[hi - lo + 1];  
            int indexA = lo;// 左指针  
            int indexB = mid + 1;// 右指针  
            int i = 0;  
      
            // 把较小的数先移到新数组中  
            while (indexA <= mid && indexB <= hi) {  
                if (a[indexA] < a[indexB]) {  
                    temp[i++] = a[indexA++];  
                } else {  
                    temp[i++] = a[indexB++];  
                }  
            }  
      
            // 把左边剩余的数移入数组  
            while (indexA <= mid) {  
                temp[i++] = a[indexA++];  
            }  
      
            // 把右边边剩余的数移入数组  
            while (indexB <= hi) {  
                temp[i++] = a[indexB++];  
            }  
      
            // 把新数组中的数覆盖a数组  
            for (int k2 = 0; k2 < temp.length; k2++) {  
                a[k2 + lo] = temp[k2];  
            }  
        }  
      
          
        // 归并排序的实现  
        public static void main(String[] args) {  
      
        	int[] test = {24,1,9,10};
      
            TestGUI.sort(test, 0, test.length-1);  
            System.out.println(Arrays.toString(test));  
        }  
    }  