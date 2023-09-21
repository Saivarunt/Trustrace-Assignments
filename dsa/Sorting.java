package dsa;

class SortingTypes{
    void selection(Integer arr[]){
        for(Integer i=0;i<arr.length-1;i++){
            for(Integer j=i+1;j<arr.length;j++){
                if(arr[j]<arr[i]){
                    Integer temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        for(Integer v:arr){
            System.out.print(v+" ");
        }
    }
    void bubble(Integer arr[]){
        boolean swap;
        for(Integer i=0;i<arr.length;i++){
            swap=false;
            for(Integer j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    Integer temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    swap=true;
                }
            }
            if(swap==false){
                break;
            }
        }
        for(Integer v:arr){
            System.out.print(v+" ");
        }
    }
    void cocktail_sort(Integer arr[]){
        Integer b=0;
        Integer e=arr.length-1;
        boolean swap=true;
        while(swap==true){
            swap=false;
            for(Integer i=b;i<e;i++){
                if(arr[i]>arr[i+1]){
                    Integer temp=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=temp;
                    swap=true;
                }
            }
            e--;
            for(Integer j=e-1;j>=b;j--){
                if(arr[j]>arr[j+1]){
                    Integer temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    swap=true;
                }
            }
            b++;
            if(swap==false){
                break;
            }
        }
        for(Integer v:arr){
            System.out.print(v+" ");
        }
    }
}
public class Sorting {
    public static void main(String[] args) {
        SortingTypes s = new SortingTypes();
        System.out.println("Selection:");
        s.selection(new Integer[]{2,3,4,1,5,7,0,8,9,6});
        System.out.println();
        System.out.println("Bubble: ");
        s.bubble(new Integer[]{2,3,4,1,5,7,0,8,9,6});
        System.out.println();
        System.out.println("Cocktail: ");
        s.cocktail_sort(new Integer[]{2,3,4,1,5,7,0,8,9,6});
        System.out.println();
    }
}
