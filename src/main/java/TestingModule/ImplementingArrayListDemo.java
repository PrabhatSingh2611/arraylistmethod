package TestingModule;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;


public  class ImplementingArrayListDemo<E> implements List<E> {
    private Object[] arrobj;
    private int size_array = 0;
    private static int default_capacity = 10;
    private int capacity = 0;

    /*  //Constructor ArrayList object with maximum size
       public TestingModule.ImplementingArrayListDemo(int maxSize) {
           if (maxSize <= 0) {
               throw new IllegalArgumentException();
           }
           arrobj = new Object[maxSize];
           size_array = 0;
       }

       //Constructor with ArrayList Object containing the elements
       public TestingModule.ImplementingArrayListDemo(Object[] initElements) {
           arrobj = new Object[2 * initElements.length];
           for (int i = 0; i < initElements.length; i++) {
               arrobj[i] = initElements[i];
           }
           size_array = initElements.length;
       }


   */
    void ImplementingArrayListDemo() {
        capacity = default_capacity;
        arrobj = new Object[capacity];
    }

    void ImplementingArrayListDemo(int c) {
        capacity = c;
        arrobj = new Integer[capacity];
    }

    /**
     * Method implementation
     */
    //size
    @Override
    public int size() {
        return size_array;
    }

    /**
     * isEmpty() method Returns true if this list contains no elements else return false.
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        if (size_array == 0) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public boolean contains(Object o) {
        for (Object obj : arrobj) {
            if (obj == null) {
                break;
            }
            if (obj.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        Iterator<?> itr = c.iterator();
        boolean loopFlag = true;
        boolean whileLoop = true;
        for (Object o : arrobj
        ) {
            while (itr.hasNext()) {
                Object elementObj = itr.next();
                if (elementObj == o) {
                    loopFlag = true;
                }
                whileLoop = true;
            }
            if (!whileLoop) {
                return true;
            }
            if (!loopFlag) {
                break;
            }
            loopFlag = false;
            whileLoop = false;
        }
        return false;
    }

    @Override
    public String toString() {
        String str = "Prabhat";
        for (int i = 0; i < size_array; i++) {
            str = str + arrobj[i];
            if (i < size_array - 1)
                str = str + " Singh";
        }
        return str;
    }
  /*  //toString
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < default_capacity; i++) {
            sb.append(arrobj[i]).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }
*/

    //toArray
    @Override
    public Object[] toArray() {
        Object[] temp = Arrays.copyOf(arrobj, size_array);
        return temp;
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        return null;
    }

    /*
    public Object[] toArray(Object[] obj) {
        Object objects[]=new Object[size_array];
        for ( default_capacity=0; default_capacity<size_array; default_capacity++)
        {
            objects[default_capacity]=arrobj[default_capacity];
        }
        return objects;
    }
*/
    @Override
    public boolean add(Object e) {
        if (size_array == arrobj.length) {
            increaseCapacity();
        }
        arrobj[size_array++] = e;
        return true;
    }

    /**
     * This method increases the size of our array (doubles the size) and assign it to the same list data.
     */
    private void increaseCapacity() {
        int newLength = arrobj.length * 2;
        arrobj = Arrays.copyOf(arrobj, newLength);
    }

    //add
  /*  @Override
    public boolean add(Object item) {
        if (size_array < capacity) {
            arrobj[size_array] = item;
            size_array++;
            return true;
        } else {
            reAllocateCapacity();
            arrobj[size_array] = item;
            return true;
        }
    }

    //reAllocateCapacity
    private void reAllocateCapacity() {
        capacity *= 2;
        arrobj = Arrays.copyOf(arrobj, capacity);
    }

   */
 /*@Override
        public void add(int index, Object item) {
            if(index<size_array) {
                arrobj[index] = item;
            }else{
                throw new ArrayIndexOutOfBoundsException();
            }
        }
   */

    //add an element with specified position i
    public boolean add(Object obj, int i) {
        if (obj == null || i < 0 || i > size_array) {
            throw new IllegalArgumentException();
        }
        for (int j = size_array - 1; j >= i; j--) {
            arrobj[j + 1] = arrobj[j];
        }
        arrobj[i] = obj;
        size_array++;
        return true;
    }


    @Override
    public boolean addAll(Collection c) {
        if (c.isEmpty()) {
            return false;
        }
        for (Object e : c) {
            if (size_array == arrobj.length) {
                increaseCapacity();
            }
            arrobj[size_array++] = e;
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        if (c.isEmpty() || index >= size_array) {
            return false;
        }
        for (Object e : c) {
            if (size_array == arrobj.length) {
                increaseCapacity();
            }
            for (int i = size_array++ - 1; i >= index; i--) {
                if (size_array == arrobj.length) {
                    increaseCapacity();
                }
                arrobj[i + 1] = arrobj[i];
            }
            arrobj[index++] = e;
        }
        return true;
    }

    //removeObject
    public void removeObject(int data) {
        remove(indexOf(data));
    }

    //remove
    @Override
    public E remove(int i) {
        if (i < 0 || i >= size_array) {
            throw new IndexOutOfBoundsException();
        }
        Object removed = arrobj[i];
        for (int j = i; j < size_array - 1; j++) {
            arrobj[j] = arrobj[j + 1];
        }
        arrobj[size_array - 1] = null;
        size_array--;
        return (E) removed;
    }

    @Override
    public boolean remove(Object item) {
        for (size_array = 0; size_array < capacity; size_array++) {
            if (arrobj[size_array] == item) {
                for (int i = size_array; i < size(); i++) {
                    arrobj[size_array] = arrobj[size_array + 1];
                }
                return true;
            }
        }
        return false;
    }

    /*
        @Override
        public boolean removeAll(Collection collection) {
            boolean rm = false;
            Iterator<T> e= iterator();
            while(e.hasNext())
            {
                if(collection.contains(e.next())){
                    e.remove();
                    rm=true;
                }
            }return rm;
        }
    */
    @Override
    public boolean removeAll(Collection<?> c) {
        Iterator<?> itr = c.iterator();
        for (int i = 0; i < size_array; i++) {
            while (itr.hasNext()) {
                Object elementobj = itr.next();
                if (elementobj == arrobj[i]) {
                    arrobj[i] = null;
                    size_array--;
                }
            }
        }
        nullRemover();
        return false;
    }

    //nullRemover
    private void nullRemover() {
        Object[] temp = new Object[arrobj.length];
        for (int i = 0, j = 0; i < size_array; i++) {
            if (arrobj[i] == null) {
                continue;
            }
            temp[j] = arrobj[i];
            j++;
        }
        arrobj = temp;
    }

    //clear
    @Override
    public void clear() {
        for (int i = 0; i < size_array; i++) {
            arrobj[i] = null;
            size_array = 0;
        }
    }

    //get
    @Override
    public E get(int i) {
        if (i < 0 || i >= size_array) {
            throw new IndexOutOfBoundsException("Out of Index: " + i);
        }
        return (E) arrobj[i];
    }

    @Override
    public void add(int i, E e) {

    }

    //set
    @Override
    public Object set(int i, Object o) {
        if (o == null || i >= size_array) {
            return null;
        }
        arrobj[i] = o;
        return null;
    }

    //subList
    @Override
    public List subList(int a, int a1) {
        if (a < 0 || a1 > size() || a > a1)
            throw new IndexOutOfBoundsException();
        Object subarray[] = new Object[a1 - a];
        for (int i = 0; i < subarray.length; i++) {
            subarray[a] = arrobj[a + i];
        }
        List<Object> subList = Arrays.asList((Object) subarray);
        return subList;
    }

/*    //sort
       public void sort() {
        for (int i = 1; i <= default_capacity; i++) {
            int sortitem = (int) arrobj[i];
            int j;
            for (j = 0; j > 0; j++) {
                if (sortitem < arrobj[[j - 1]]) {
                    arrobj[j] = arrobj[j - 1];
                } else break;
            }
            arrobj[j] = sortitem;
        }
    }
*/

    //indexOf
    @Override
    public int indexOf(Object item) {
        for (int i = 0; i < size_array; i++) {
            if (arrobj[i] == item) {
                return i;
            }
        }
        return -1;
    }

    //lastIndexOf
    @Override
    public int lastIndexOf(Object o) {
        for (int i = this.size_array - 1; i >= 0; i--) {
            if (arrobj[i] == o) {
                return i;
            }
        }
        return -1;
    }

    //display
    public void display() {
        System.out.println("Display the content of ArrayList : ");
        for (int i = 0; i < size_array; i++) {
            System.out.println(arrobj[i]);
        }
        System.out.println("The list size is : " + size_array);
    }


    //Not Implemented
    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    //Not Implemented
    @Override
    public ListIterator<E> listIterator(int i) {
        return null;
    }

    //Not Implemented
    @Override
    public void forEach(Consumer action) {
        List.super.forEach(action);
    }

    //Not Implemented
    @Override
    public boolean removeIf(Predicate filter) {
        return List.super.removeIf(filter);
    }

    //Not Implemented
    @Override
    public void replaceAll(UnaryOperator operator) {
        List.super.replaceAll(operator);
    }

    //Not Implemented
    @Override
    public boolean retainAll(Collection collection) {
        return false;
    }


    //Main Method
    public static void main(String[] args) {
        List al = new ArrayList();
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
        al.add("Namrata");
        al.add("Ravi");
        al.add("Revati");
        al.add("Abhishek");
        al.remove(null);
        al.remove(40);
        al.remove(50);

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

        System.out.println("Get value=" + al.get(6));
        System.out.println("IndexOf=" + al.indexOf("Prabhat"));
        System.out.println("Size=" + al.size());


        for (int i = 0; i < al.size(); i++) {
            System.out.println(al.get(i));
            ((ArrayList<?>) al).ensureCapacity(5);
        }
        al.removeAll(Arrays.asList("Namrata"));
        System.out.println("contains= " + al.contains("Namrata"));
        System.out.println("get value of=" + al.get(8));
    }
}









