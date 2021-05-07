import java.io.*;
import java.util.*;
public class SearchInRotatedSortedArray {
    int start=0;
    int end=0;
    int pivot = 0;
    int subPivot=0;
    boolean pivotExists= false;
    // Complete the function implementation below
    public int search(int[] nums, int target) {
//        1. Since the input is a rotated sorted array we need to make benefit of this point [ start__ =a[start]  end__= a[length -1]
//        2. Primary aim should be to identify the pivot of the array (To Formulate:: the very integer after which the values go decreasing PS: This will also be the max value in the array , and very next index value will be the sub pivot) (store pivot = a[max] & sub_pivot = a[max +1 ] )
//        3. Once pivots are identified we can check if the value given to us is greater than pivot or smaller than sub_pivot Integer. Both cases return -1 simply ( Best case Time complexity O(N))
//        4. If either pivot/ subpivot matched return respective indices
//
//        5. Going forward if value is greater than sub_pivot and lesser than end__ then search it in sub_pivot +i indices only (use binary search so Complexity: O(Log2(N-sub_pivot index))
//        6. On contrary if value is lesser than pivot and greater than start__ then search it sub_pivot +i indices only (use binary search so Complexity: O(Log2(N-sub_pivot index))

        end = nums.length-1;

        //array will look like : [7(start) , 8, 10, 11, 15 (Pivot) ,2 (subPivot), 3, 5 , 6 (end) ]
        if(!pivotExists) {
            pivot = getPivotData(nums, end, pivot);
            pivotExists= true;
        }

        subPivot= pivot +1 ;

        if(target == nums[pivot])
            return pivot;
        else if (target == nums[subPivot])
            return subPivot;
        else if (target == nums[start])
            return start;
        else if (target == nums[end])
            return end;
        else  if (target > nums[pivot] || target < nums[subPivot])
            return -1;
        else if (target  < nums[pivot] ){
            end = pivot; //start 0 default
            return getIndexForTarget(nums, target, start, end);
        }
        else if (target  > nums[subPivot] ){
            start= subPivot; //end is set last index already in pivot function
            return getIndexForTarget(nums, target, start, end);
        }
        return -1;
    }

    public Integer getIndexForTarget(int[] nums, int target, int start, int end) {
        int mid=  (start + end)/2;
        System.out.println("mid value "+mid);
        //mid found /2 then iterate while loope
        //if greater than mid then again update start , and mid
        while (end >= start){
            if(target == nums[mid]){
                return mid;
            }else if(target > nums[mid]){
                start = mid +1;
                mid= (start + end)/2;
            }else if(target < nums[mid]){
                end = mid -1;
                mid= (start + end)/2;
            }
        }
        return -1;
    }

    private int getPivotData(int[] nums, int endIndex, int pivot) {
        System.out.println("endIndex "+endIndex);
        int tempMax=0;
        // find index of max Value
        for (int i = 0; i <= endIndex; i++) {
            if  ( tempMax< nums[i] )         {
                tempMax = nums[i];
                pivot = i;
            }
        }
        System.out.println("pivot "+pivot);

        return pivot;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int nums[] = new int[n];
        for(int i = 0 ; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int q = scanner.nextInt();
        while(q > 0) {
            int target = scanner.nextInt();
            int result = new SearchInRotatedSortedArray().search(nums , target);
            System.out.println(result);
            q--;
        }
    }
}
