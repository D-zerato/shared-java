/*
 * COPYRIGHT (c) NEXTREE Consulting 2014
 * This software is the proprietary of NEXTREE Consulting CO.
 * @since 2014. 6. 10.
 */

package dz.shared.domain.etc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OffsetElementList<T> implements Iterable<T>, Serializable {
    //
    private List<T> results;
    private int totalCount;

    protected OffsetElementList() {
        //
        this.results = new ArrayList<>();
    }

    public OffsetElementList(int totalCount) {
        //
        this();
        this.totalCount = totalCount;
    }

    public OffsetElementList(List<T> results, int totalCount) {
        //
        this.results = results;
        this.totalCount = totalCount;
    }

    @Override
    public Iterator<T> iterator() {
        //
        return results.iterator();
    }

    public int size() {
        //
        return (results != null) ? results.size() : 0;
    }

    public T get(int index) {
        //
        return (results != null) ? results.get(index) : null;
    }

    public void add(T result) {
        //
        results.add(result);
    }

    public boolean isEmpty() {
        //
        return (results == null || results.isEmpty());
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
