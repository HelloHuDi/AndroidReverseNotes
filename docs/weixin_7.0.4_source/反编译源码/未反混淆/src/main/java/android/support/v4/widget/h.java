package android.support.v4.widget;

import android.support.v4.f.k.a;
import android.support.v4.f.k.b;
import android.support.v4.f.m;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class h<T> {
    public final a<ArrayList<T>> PQ = new b(10);
    public final m<T, ArrayList<T>> PR = new m();
    private final ArrayList<T> PS = new ArrayList();
    private final HashSet<T> PT = new HashSet();

    public final void I(T t) {
        if (!this.PR.containsKey(t)) {
            this.PR.put(t, null);
        }
    }

    public final List J(T t) {
        return (List) this.PR.get(t);
    }

    public final List<T> K(T t) {
        List<T> list = null;
        int size = this.PR.size();
        for (int i = 0; i < size; i++) {
            ArrayList arrayList = (ArrayList) this.PR.valueAt(i);
            if (arrayList != null && arrayList.contains(t)) {
                if (list == null) {
                    arrayList = new ArrayList();
                } else {
                    List list2 = list;
                }
                arrayList.add(this.PR.keyAt(i));
                list = arrayList;
            }
        }
        return list;
    }

    public final ArrayList<T> eE() {
        this.PS.clear();
        this.PT.clear();
        int size = this.PR.size();
        for (int i = 0; i < size; i++) {
            a(this.PR.keyAt(i), this.PS, this.PT);
        }
        return this.PS;
    }

    private void a(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (!arrayList.contains(t)) {
            if (hashSet.contains(t)) {
                throw new RuntimeException("This graph contains cyclic dependencies");
            }
            hashSet.add(t);
            ArrayList arrayList2 = (ArrayList) this.PR.get(t);
            if (arrayList2 != null) {
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    a(arrayList2.get(i), arrayList, hashSet);
                }
            }
            hashSet.remove(t);
            arrayList.add(t);
        }
    }
}
