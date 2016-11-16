
public class GetMaxProfit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={10, 7, 5, 8, 9, 2};
		int[] arr2=new int[]{10, 7, 5, 8, 11, 9};
		System.out.println(getMaxProfit(arr));
		System.out.println("Lets start");
		int i=arr.length-1;
		while(i>=0){
			if(arr[i]>7){
				i--;
				continue;
			}
			System.out.println(arr[i]);
			i--;
		}

	}
	public static int getMaxProfit(int[] stockPrices){
		if(stockPrices.length==1){
			return 0;
		}
		int earlierPrice=0;
		int laterPrice=0;
		int currProfit=0;
		int maxProfit=0;
		for(int i=0;i<stockPrices.length-1;i++){
			earlierPrice=stockPrices[i];
			for(int k=i+1;k<stockPrices.length;k++){
				laterPrice=stockPrices[k];
				if(laterPrice>earlierPrice){
					currProfit=laterPrice-earlierPrice;
				}
				if(currProfit>maxProfit){
					maxProfit=currProfit;
				}
			}
		}
		return maxProfit;
	}

}
