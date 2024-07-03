//total complexity O(n)
public static int maxProfit(int[] arr) {
    //define maxProfit and minimum price variable
    int maxPro = 0;
    int minPrice = Integer.MAX_VALUE;
    for (int i = 0; i < arr.length; i++) {
        minPrice = Math.min(minPrice, arr[i]); // checking if the price is minimum at index i
        maxPro = Math.max(maxPro, arr[i] - minPrice); //calculating profit and checking if the profit is greater than maxPro
    }
    return maxPro;
}