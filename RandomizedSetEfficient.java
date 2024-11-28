import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

class RandomizedSetEfficient {
    HashMap<Integer,Integer> table = new HashMap<>();
    ArrayList<Integer> arr = new ArrayList<>();
    Random random= new Random();

    public RandomizedSetEfficient() {


    }

    public boolean insert(int val) {
        if(table.containsKey(val)){
            return false;
        }
        int n = arr.size();
        arr.add(val);
        table.put(val, n);
        return true;
    }

    public boolean remove(int val) {
        if(!table.containsKey(val)){
            return false;
        }
        int index = table.get(val);
        int lastItem = arr.get(arr.size() - 1);

        table.put(lastItem, index);
        arr.set(index, lastItem);
        arr.remove(arr.size() - 1);
        table.remove(val);
        return true;
    }
    public int getRandom() {

        int r = random.nextInt(arr.size());
        return arr.get(r);
    }

    public static void main(String[] args) {
        RandomizedSetEfficient rs = new RandomizedSetEfficient();
        rs.remove(0);
        rs.remove(0);
        rs.insert(0);
        rs.getRandom();
        rs.remove(0);
        rs.insert(0);
    }
}