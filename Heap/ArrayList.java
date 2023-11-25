package Heap;

public class ArrayList {
    int [] arr;
    int index;

    public ArrayList(){
        arr = new int[10];
        index = -1;
    }
    public boolean isFull(){
        return index == arr.length -1;
    }

    public boolean isEmpty(){
        return index == -1;
    }
    public int lastFilledIndex(){
        return index;
    }
    public void insert(int value){
        if(!isFull()){
            arr[++index] = value;
        } else {
            douleArray(value);
        }
    }
    private void douleArray(int value){
        int [] temp = new int[arr.length * 2];
        for(int i=0;i<arr.length;i++){
            temp[i] = arr[i];
        }
        arr = temp;
        arr[++index] = value;
    }
    public int delete(){
        return arr[index--];
    }
    public void swapByIndex(int first,int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

}
