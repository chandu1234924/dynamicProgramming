package frctionalKnapsack;

import java.util.*;
    class Item {
         int weight;
         int profit;
         double ratio;
         Item(int weight,int profit){
            this.weight=weight;
            this.profit=profit;
            this.ratio=(double)profit/weight;
         
         }
    }
    public class FractionalKnapsack {
        public static void main(String[] args){
            int n=3;
            int capacity=50;
            Item[] items={
                new Item(10,60),
                new Item(20,100),
                new Item(30,120),
            };
            Arrays.sort(items,(a,b) -> Double.compare(b.ratio,a.ratio));
            double totalProfit=0.0;
            int remaining=capacity;
            for(Item item : items){
                if(remaining==0){
                    break;
                }
                if(item.weight<=remaining){
                    totalProfit+=item.profit;
                    remaining-=item.weight;
                }else{
                    totalProfit+=item.ratio*remaining;
                    remaining=0;
                }
            }
            System.out.print("Maximum profit : "+totalProfit);
        }
}