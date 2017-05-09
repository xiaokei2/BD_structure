class Quicksort{
  //your work here
  /*
    The key process in quickSort is       parition, we put last element as pivot 
point, put all smaller numbers before pivot point and bigger numbers after pivot
   
  */
  
  private static int[] output;

  public static int[] compute(int[] input) {
    output = input;
    qsort(output, 0, output.length - 1);
    return output;
  }
  
  public static void qsort(int arr[], int low, int high){
    if(low < high){
      
      
      // pi is a partition index, arr[pi] is now 
      
      if(low < high){
        /*
          
        */
        int pi = partition(arr, low ,high);
        qsort(arr, low, pi - 1);
        qsort(arr, pi + 1, high);
        
      }
    }
    
  }

  
  public static int partition(int arr[], int low, int high){
    
    int pivot = arr[high];
    
    int i = low - 1;
    for(int j = low; j < high; j++){
      if(arr[j] <= pivot){
         i++;
        swap(arr,i, j);
  
      }
    }
    
    // i + 1 is illegal index 
    swap(arr, i + 1, high);
    
    return i + 1;
  }
  
  public static void swap(int[] nums, int i, int j){
    
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
    
  }
  

  
}


// Time Complexity: O(nlogn)
// Auxiliary Space Complexity: O(N)
class Mergesort{
  //your work here
  public static void compute(int[] input) {
    
    sort(input, 0, input.length - 1);
      
  }
  
  public static void sort(int[] nums, int l, int r)
  {
    if(l < r){
      
      int m = (l + r) / 2;
      
      sort(nums, l, m);
      sort(nums, m + 1, r);
      
      merge(nums, l , m, r);
    }
    
  }

  private static void merge(int[] nums, int l, int m , int r){

    int l1 = m - l + 1;
    int r1 = r - m;
    
    int [] L = new int [l1];
    int [] R = new int [r1]; 
    
    for(int i = 0; i < l1; i++){
      L[i] = nums[l + i];
    }
    
    for(int i = 0; i < r1; i++){
      R[i] = nums[m + i + 1];
    }
    
    
    int i = 0, j = 0;
    
    int k = l;
    
    while(i < l1 && j < r1){
      
      if(L[i] <= R[j]){
        nums[k] = L[i];
        i++;
      }
      
      else{
        nums[k] = R[j];
        j++;
      }
      k ++;
    } 
    
    while(i < l1){
      nums[k++] = L[i++];
    }
    
    while(j < r1){
      nums[k++] = R[j++];
    }
    
  }
}
