package cn.lyc.ds.list.impl;

/**
 * 数组结构
 * 先排序，后查找
 * @author asdc
 *
 */
public class Array {

	 public final static int MAXSIZE = 20;
	
	/**
	 * 二分查找,返回key的位置，没查到返回<0  时间复杂度为O(logN)
	 * @param a
	 * @param key
	 * @return
	 */
	public static int binarySearch(long[] a, long key){
		
		int lo = 0;//起始位置
		int hi = a.length - 1;//终止位置
		
		while(lo < hi){
			
			int mid = (lo + hi)/2;//中间位置
			
			if(key == a[mid]){
				
				return mid;
				
			}else if(key > a[mid]){
				
				lo = mid + 1;
				
			}else if(key < a[mid]){
				
				hi = mid - 1;
				
			}
			
		}
		
		return -1;
		
	}
	
	/**
	 * 插值查找
	 * @param a
	 * @param key
	 * @return
	 */
	public static int interpolationSearch(long[] a, long key){
		
		//插值查找其实跟二分查找差不多，适合大数据量的查找，数据量小的话采用二分查找或者顺序查找效率更高，差值插找主要使用一个公式
		//二分查找公式   mid = (lo + hi)/2
		//公式转换  mid = lo/2 + hi/2    ---->    mid = lo + hi/2 - lo/2  ----> mid = lo + (hi - lo)/2
		//mid = lo + (1/2)(hi - lo)  将1/2换成插值公式    (key - a[lo])/(a[hi] - a[lo])
		//得出结果   mid = lo + (hi - lo) * (key - a[lo])/(a[hi] - a[lo])  这就是插值查找的算法  替换到二分查找中即可
		
		int lo = 0;//起始位置
		int hi = a.length - 1;//终止位置
		
		while(lo < hi){
			
			int mid = (int) (lo + (hi - lo) * (key - a[lo])/(a[hi] - a[lo]));//中间位置
			
			if(key == a[mid]){
				
				return mid;
				
			}else if(key > a[mid]){
				
				lo = mid + 1;
				
			}else if(key < a[mid]){
				
				hi = mid - 1;
				
			}
			
		}
		
		return -1;
		
	}
	
	/**
	 * 斐波那契查找
	 * @param a
	 * @param key
	 * @return
	 */
	public static int fibonacciSearch(long[] a,long key){
		
		int lo = 0;
		int hi = a.length - 1;
		
		int[] f = fibonacci();
		
		int k = 0;//黄金分割下标
		
		while(a.length > f[k] - 1){
			
			k++;
			
		}
		
		long[] temp = new long[f[k] - 1];
		for(int i = 0; i < a.length; i++){
			
			temp[i] = a[i];
			
		}
		
		// 序列补充至f[k]个元素  
        // 补充的元素值为最后一个元素的值 
		for (int i = a.length; i < f[k] - 1; i++) {  
            temp[i] = temp[hi];  
        }  
		
		while (lo <= hi) {  
            // low：起始位置  
            // 前半部分有f[k-1]个元素，由于下标从0开始  
            // 则-1 获取 黄金分割位置元素的下标  
            int mid = lo + f[k - 1] - 1;  
  
            if (temp[mid] > key) {  
                // 查找前半部分，高位指针移动  
                hi = mid - 1;  
                // （全部元素） = （前半部分）+（后半部分）  
                // f[k] = f[k-1] + f[k-2]  
                // 因为前半部分有f[k-1]个元素，所以 k = k-1  
                k = k - 1;  
            } else if (temp[mid] < key) {  
                // 查找后半部分，高位指针移动  
                lo = mid + 1;  
                // （全部元素） = （前半部分）+（后半部分）  
                // f[k] = f[k-1] + f[k-2]  
                // 因为后半部分有f[k-1]个元素，所以 k = k-2  
                k = k - 2;  
            } else {  
                // 如果为真则找到相应的位置  
                if (mid <= hi) {  
                    return mid;  
                } else {  
                    // 出现这种情况是查找到补充的元素  
                    // 而补充的元素与high位置的元素一样  
                    return hi;  
                }  
            }  
        }  
        return -1;  
        
        
    } 
		
	
	/**
	 * 构建斐波那契数列
	 * @return
	 */
	public static int[] fibonacci(){
		
		int[] f = new int[MAXSIZE];
		f[0] = 1;
		f[1] = 1;
		for(int i = 2; i < MAXSIZE; i++){
			
			f[i] = f[i - 1] + f[i - 2];
			
		}
		
		return f;
		
	}
	
	//查找总结
	//折半查找：进行加法与除法的运算mid = (lo + hi)/2
	//插值查找:进行复杂的四则运算mid = lo + (hi - lo)*(key-a[lo])/(a[hi]-a[lo])
	//斐波那契查找:进行最简单的加减法运算mid = low + f[k-1] - 1 又称换进分割   比值
	//在海量数据查找过程中，这种细微的差别可能会影响最终的效率
	//三种查找方式本质区别为分割点选择不同，各有优劣，实际开发时可根据数据特点进行选择
	
	
	/**
	 * 气泡排序 低效版
	 * @param a
	 * @return
	 */
	public static void bubbleSort(long[] a){
		
		boolean isSort = true;//判断是否还有紧邻逆序对
		
		for(int j = a.length - 1; j > 0; j--){
			
			for(int i = 0; i < j; i++){

				if(a[i] > a[i + 1]){
					
					isSort = false;
					
					//交换
					long temp = a[i + 1];
					a[i + 1] = a[i];
					a[i] = temp;
					
				}
				
			}
			
			if(isSort == true){
				
				break;
				
			}
			
		}
		
	}
	
	/**
	 * 归并排序 算法
	 * @param a
	 * @param lo
	 * @param hi
	 */
	public static void Merger(long[] a, int lo, int hi, int mid){
		
		long[] temp = new long[hi - lo];//临时数组  存放归并比较时的值
		
		int indexA = lo;
		int indexB = mid;//两端的启示值
		
		//从两端开始比较大小  将小的值放入temp数组中
		int i = 0;
		while(indexA < mid && indexB < hi){
			
			if(a[indexA] > a[indexB]){
				
				temp[i++] = a[indexB++];
				
			}else{
				
				temp[i++] = a[indexA++];
				
			}
			
		}
		
		//将剩余的值放入temp中
		while(indexA < mid){
			
			temp[i++] = a[indexA++];
			
		}
		while(indexB < hi){
			
			temp[i++] = a[indexB++];
			
		}
		
		//更改a数组
		for (int k2 = 0; k2 < temp.length; k2++) {  
            a[k2 + lo] = temp[k2];  
        }  
		
		
	}
	
	public static void MergerSort(long[] a, int lo, int hi){
        if (hi > lo) //hi - lo > 1
        {
            int mid = (lo + hi) / 2;
            System.out.println("左" + lo + "," + mid);
            MergerSort(a, lo, mid);
            System.out.println("右" + (mid+1) + "," + hi);
            MergerSort(a, mid + 1, hi);
            Merger(a, lo, hi, mid);
        }
    } 
	
}
