import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation


public class NestedIterator implements Iterator<Integer> {

    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();
        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    int index = 0;
    List<Integer> flattenedList = new ArrayList();

    public NestedIterator(List<NestedInteger> nestedList) {
        this.flattenedList = flattenNIList(nestedList);
    }

    public List<Integer> flattenNIList(List<NestedInteger> nis) {
        List<Integer> result = new ArrayList<>();
        for(NestedInteger niInner : nis) {
            if(niInner.isInteger()) { result.add(niInner.getInteger()); }
            else { result.addAll(flattenNIList(niInner.getList())); }
        }
        return result;
    }

    @Override
    public Integer next() {
        return flattenedList.get(this.index++);
    }

    @Override
    public boolean hasNext() {
        return index < flattenedList.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */