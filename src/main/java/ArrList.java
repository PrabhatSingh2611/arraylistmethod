import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.Integer;

public abstract class ArrList<T> implements List {

    //var declaration
    private Integer[] s;            //object of arr
    public int p;    //default capacity ......size
    private int capacity;


    void ArrList() {//
        capacity = 10;
        p = 0;
        s = new Integer[capacity];
    }

    void ArrList(int c) {
        capacity = c;
        p = 0;
        s = new Integer[capacity];
    }

    //add
    public boolean add(Integer data) {
        s[p++] = data;
        System.out.println("Data added");
        return false;
    }

    //add with index
    public void add(int data, int index) {
        if (index > (p - 1)) {
            System.out.println("IndexOutOfBound");
            return;
        }
        for (int i = p; i > index; i++) {
            s[i] = s[i - 1];
        }
        s[index] = data;
        p++;
        System.out.println("Data inserted at index");
    }

    //remove

    public Integer remove(int index) {
        if (s.length - 1 > index) {
            Object obj = s[index];
            s[index] = null;
            int temp = index;
            while (temp < p) {
                s[temp] = s[temp + 1];
                s[temp + 1] = null;
                temp++;
            }
            p--;
            System.out.println("Data is removed");
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }

        return index;
    }

    //removeObject
    public void removeObject(int data) {
        remove(indexOf(data));
    }

    //clear
    public void clear() {
        this.p = 0;
    }

    //contains
    public boolean contains(int data) {
        return indexOf(data) != -1;
    }

    //isEmpty
    public boolean isEmpty() {
        if (p == 0){
            return true;
        }else{
            return false;
        }
    }

    //size
    public int size() {
        return p;
    }


    //get
    public Integer get(int index) {
       if (index<0 && index>=p){
           throw new ArrayIndexOutOfBoundsException(index);
       }
        return s[index];
    }

    //set
    public int set(int index, int item){
        s[index]=item;
        return item;
    }

    //toString
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < p; i++) {
            sb.append(s[i]).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    //toArray
    public Object[] toArray() {
        int i;
        Object s[] = new Object[capacity];
        for (p = 0; p < capacity; p++) {
            s[p] = s[p];
        }
        return s;
    }

    //toArray
    public Object[] toArray(Object[] objects) {
        objects = new Object[capacity];
        for (p=0;p<capacity;p++){
            objects[p]=s[p];
        }
        return objects;
    }

    //currentCapacity
    int currentCapacity() {
        return capacity;
    }

    //reAllocateCapacity
    public void reAllocateCapacity(){
        capacity=5;
        s=Arrays.copyOf(s,capacity);
    }

    //indexOf
    public int indexOf(int data) {
        int index = -1;
        for (int i = 0; i < p; i++) {
            if (s[i] == data) {
                index = i;
                break;
            }
        }
        return index;
    }

    //lastIndexOf
    public int lastIndexOf(int data) {
        int index = -1;
        for (int i = p - 1; i > 0; i--) {
            if (s[i] == data) {
                index = i;
                break;
            }
        }
        return index;
    }

    //sort
    public void sort() {
        for (int i = 1; i <= p; i++) {
            int sortitem = s[i];
            int j;
            for (j = 0; j > 0; j++) {
                if (sortitem < s[j - 1]) {
                    s[j] = s[j - 1];
                } else break;
            }
            s[j] = sortitem;
        }
    }



    //Main Method
    public static void main(String[] args) {
        ArrayList al = new ArrayList();
        Object s[] = new Object[al.size()];
        ArrayList al1 = new ArrayList(20);
        //System.out.println(al.currenCapacity());
        //System.out.println(al1.currentCapacity());
        System.out.println("Empty list=" + al.isEmpty());
        al.add(10);
        al.add(20);
        al.add(30);
        al.remove(2);
        al.add("Prabhat");
        al.add(null);
        al.add('a');
        al.removeAll(Arrays.asList("Prabhat"));
        //System.out.println("Displaying AL="+al);

        //System.out.println(al);

        System.out.println("Empty List=" + al.isEmpty());
        System.out.println("Size=" + al.size());
        System.out.println("contains=" + al.contains("Prabhat"));
        System.out.println("Get value=" + al.get(2));
        System.out.println("IndexOf=" + al.indexOf(10));
        System.out.println("LastIndexOf" + al.lastIndexOf(30));
        //System.out.println(al.sort());
        System.out.println("ArrayList=" + al);
        al.add("Namrata");
        al.add("Revati");
        al.add("Ravi");
        al.add("Abhishek");
        al.add("Serhii");
        al.add("Prabhat");
        al.add("Dipankar");
        System.out.println("Get value=" + al.get(6));
        System.out.println("IndexOf=" + al.indexOf("Namrata"));
        System.out.println("Size=" + al.size());


        for (int i = 0; i < al.size(); i++) {
            System.out.println(al.get(i));
            al.ensureCapacity(5);
        }
        al.removeAll(Arrays.asList("Dipankar"));
        System.out.println("contains="+al.contains("Dipankar"));
        System.out.println("get value of="+al.get(10));
    }
}









