package com.tencent.p177mm.sdk.p603e;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p604g.p605a.C4943e;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/* renamed from: com.tencent.mm.sdk.e.l */
public abstract class C4934l<T, E> {
    private static final C7306ak xDl = new C7306ak(Looper.getMainLooper());
    public int xDi = 0;
    private final Hashtable<T, Object> xDj = new Hashtable();
    private final HashSet<E> xDk = new HashSet();

    /* renamed from: com.tencent.mm.sdk.e.l$a */
    protected static class C4933a {
        String xDp;
        C4943e xDq;
        Looper xzn;

        public C4933a(Looper looper) {
            this.xzn = looper;
        }
    }

    /* renamed from: w */
    public abstract void mo10134w(T t, E e);

    public final void lock() {
        this.xDi++;
    }

    public final void unlock() {
        this.xDi--;
        if (this.xDi <= 0) {
            this.xDi = 0;
            dpZ();
        }
    }

    public final boolean isLocked() {
        return this.xDi > 0;
    }

    /* renamed from: a */
    public synchronized void mo10125a(T t, Looper looper) {
        if (!this.xDj.containsKey(t)) {
            if (looper != null) {
                this.xDj.put(t, new C4933a(looper));
            } else {
                this.xDj.put(t, new Object());
            }
        }
    }

    public final synchronized void remove(T t) {
        this.xDj.remove(t);
    }

    public final synchronized void removeAll() {
        this.xDj.clear();
    }

    private synchronized Vector<T> dpY() {
        Vector vector;
        vector = new Vector();
        vector.addAll(this.xDj.keySet());
        return vector;
    }

    /* renamed from: cF */
    public final boolean mo10126cF(E e) {
        boolean add;
        synchronized (this.xDk) {
            add = this.xDk.add(e);
        }
        return add;
    }

    public final void doNotify() {
        if (!isLocked()) {
            dpZ();
        }
    }

    /* renamed from: el */
    public void mo10128el(List<E> list) {
    }

    private void dpZ() {
        Vector dpY = dpY();
        if (dpY.size() <= 0) {
            this.xDk.clear();
            return;
        }
        ArrayList arrayList;
        synchronized (this.xDk) {
            arrayList = new ArrayList(this.xDk);
            this.xDk.clear();
        }
        mo10128el(arrayList);
        HashMap hashMap = new HashMap();
        Iterator it = dpY.iterator();
        while (it.hasNext()) {
            final Object next = it.next();
            Object obj = this.xDj.get(next);
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                final Object next2 = it2.next();
                if (!(next2 == null || obj == null)) {
                    if (obj instanceof C4933a) {
                        C4933a c4933a = (C4933a) obj;
                        C49321 c49321 = new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(52517);
                                C4934l.this.mo10134w(next, next2);
                                AppMethodBeat.m2505o(52517);
                            }
                        };
                        if (c4933a.xDq != null) {
                            c4933a.xDq.mo10151b(c49321, c4933a.xDp);
                        } else if (c4933a.xzn != null) {
                            C7306ak c7306ak = (C7306ak) hashMap.get(c4933a.xzn);
                            if (c7306ak == null) {
                                c7306ak = new C7306ak(c4933a.xzn);
                                hashMap.put(c4933a.xzn, c7306ak);
                            }
                            c7306ak.post(c49321);
                        } else {
                            xDl.post(c49321);
                        }
                    } else {
                        mo10134w(next, next2);
                    }
                }
            }
        }
    }
}
