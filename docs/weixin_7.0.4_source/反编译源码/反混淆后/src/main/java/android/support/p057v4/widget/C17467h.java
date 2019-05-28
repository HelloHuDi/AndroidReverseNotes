package android.support.p057v4.widget;

import android.support.p057v4.p065f.C0417m;
import android.support.p057v4.p065f.C37122k.C16505b;
import android.support.p057v4.p065f.C37122k.C8387a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* renamed from: android.support.v4.widget.h */
public final class C17467h<T> {
    /* renamed from: PQ */
    public final C8387a<ArrayList<T>> f3995PQ = new C16505b(10);
    /* renamed from: PR */
    public final C0417m<T, ArrayList<T>> f3996PR = new C0417m();
    /* renamed from: PS */
    private final ArrayList<T> f3997PS = new ArrayList();
    /* renamed from: PT */
    private final HashSet<T> f3998PT = new HashSet();

    /* renamed from: I */
    public final void mo31808I(T t) {
        if (!this.f3996PR.containsKey(t)) {
            this.f3996PR.put(t, null);
        }
    }

    /* renamed from: J */
    public final List mo31809J(T t) {
        return (List) this.f3996PR.get(t);
    }

    /* renamed from: K */
    public final List<T> mo31810K(T t) {
        List<T> list = null;
        int size = this.f3996PR.size();
        for (int i = 0; i < size; i++) {
            ArrayList arrayList = (ArrayList) this.f3996PR.valueAt(i);
            if (arrayList != null && arrayList.contains(t)) {
                if (list == null) {
                    arrayList = new ArrayList();
                } else {
                    List list2 = list;
                }
                arrayList.add(this.f3996PR.keyAt(i));
                list = arrayList;
            }
        }
        return list;
    }

    /* renamed from: eE */
    public final ArrayList<T> mo31811eE() {
        this.f3997PS.clear();
        this.f3998PT.clear();
        int size = this.f3996PR.size();
        for (int i = 0; i < size; i++) {
            m27107a(this.f3996PR.keyAt(i), this.f3997PS, this.f3998PT);
        }
        return this.f3997PS;
    }

    /* renamed from: a */
    private void m27107a(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (!arrayList.contains(t)) {
            if (hashSet.contains(t)) {
                throw new RuntimeException("This graph contains cyclic dependencies");
            }
            hashSet.add(t);
            ArrayList arrayList2 = (ArrayList) this.f3996PR.get(t);
            if (arrayList2 != null) {
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    m27107a(arrayList2.get(i), arrayList, hashSet);
                }
            }
            hashSet.remove(t);
            arrayList.add(t);
        }
    }
}
