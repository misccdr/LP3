import java.util.Arrays;
import java.util.Comparator;

class Item{
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class MComparator implements Comparator<Item>{
    @Override
    public int compare(Item a, Item b){
        double ratio_a = (double)(a.value) / (double)(a.weight);
        double ratio_b = (double)(b.value) / (double)(b.weight);
        
        if(ratio_a < ratio_b){
            return 1;
        }else if(ratio_a > ratio_b){
            return -1;
        }else{
            return 0;
        }
    }
}

public class FractionalKnapsack {

    static double solve(int W, Item arr[], int n){
    
        //IMPORTANT

        Arrays.sort(arr, new MComparator());
        int curWeight = 0;
        double finalValue = 0.0;

        for(int i=0; i<n; i++){
            if(curWeight + arr[i].weight <= W){
                curWeight += arr[i].weight;
                finalValue += arr[i].value;
            }
            else{
                int remain = W - curWeight;
                finalValue += ((double)arr[i].value / (double)arr[i].weight) * (double)remain;
                break;
            }
        }
        return finalValue;

        //IMPORTANT
    }

    
    
    public static void main(String[] args) {
        int n =3, weight = 50;
        Item arr[] = {new Item(100, 20), new Item(60, 10), new Item(120, 30)};
        double ans = solve(weight, arr, n);
        
        System.out.println("The maximum value: " + ans);
    }
}
