package Heap;

public class Heap {
    ArrayList list = new ArrayList();

    private int parentInedx(int index){
        return (index-1) / 2;
    }
    private int leftChildIndex(int index){
        return 2*index + 1;
    }
    private int rightChildIndex(int index){
        return 2*index + 2;
    }

    public void insert(int value){
        list.insert(value);
        upHeap(list.lastFilledIndex());
    }
    private void upHeap(int index){
        if(index == 0){
            return;
        }
        int parent = parentInedx(index);
        if(list.arr[index] >= list.arr[parent]){
            list.swapByIndex(index,parent);
            upHeap(parent);
        }
    }

    public int delete() throws Exception{
        if(list.isEmpty()){
            throw new Exception("heap is Empty");
        }
        int temp = list.arr[0];
        int last = list.delete();
        if(!list.isEmpty()){
            list.arr[0] = last;
            heapDown(0);
        }
        return temp;
    }
    private void heapDown(int index){
        int max = index;
        int left = leftChildIndex(index);
        int right = rightChildIndex(index);

        if(left <= list.lastFilledIndex() && list.arr[max] < list.arr[left]){
            max = left;
        }
        if(right <= list.lastFilledIndex() && list.arr[max] < list.arr[right]){
            max = right;
        }
        if(max != index){
            list.swapByIndex(max,index);
            heapDown(max);
        }
    }

    public int getMax(){
        return list.arr[0];
    }

    public static void main(String[] args) throws Exception{
        Heap heap = new Heap();
        int [] values = {4,1,2,7,2000,6,14};
        for(int i=0;i< values.length;i++){
            heap.insert(values[i]);
        }
        System.out.println(heap.getMax());
        System.out.println(heap.delete());
        System.out.println(heap.delete());
        System.out.println(heap.delete());
        System.out.println(heap.delete());
        System.out.println(heap.delete());
        System.out.println(heap.delete());
    }
}
