package com.tencent.mm.sdk.e;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.a.e;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public abstract class l<T, E> {
    private static final ak xDl = new ak(Looper.getMainLooper());
    public int xDi = 0;
    private final Hashtable<T, Object> xDj = new Hashtable();
    private final HashSet<E> xDk = new HashSet();

    protected static class a {
        String xDp;
        e xDq;
        Looper xzn;

        public a(Looper looper) {
            this.xzn = looper;
        }
    }

    public abstract void w(T t, E e);

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

    public synchronized void a(T t, Looper looper) {
        if (!this.xDj.containsKey(t)) {
            if (looper != null) {
                this.xDj.put(t, new a(looper));
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

    public final boolean cF(E e) {
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

    public void el(List<E> list) {
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
        el(arrayList);
        HashMap hashMap = new HashMap();
        Iterator it = dpY.iterator();
        while (it.hasNext()) {
            final Object next = it.next();
            Object obj = this.xDj.get(next);
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                final Object next2 = it2.next();
                if (!(next2 == null || obj == null)) {
                    if (obj instanceof a) {
                        a aVar = (a) obj;
                        AnonymousClass1 anonymousClass1 = new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(52517);
                                l.this.w(next, next2);
                                AppMethodBeat.o(52517);
                            }
                        };
                        if (aVar.xDq != null) {
                            aVar.xDq.b(anonymousClass1, aVar.xDp);
                        } else if (aVar.xzn != null) {
                            ak akVar = (ak) hashMap.get(aVar.xzn);
                            if (akVar == null) {
                                akVar = new ak(aVar.xzn);
                                hashMap.put(aVar.xzn, akVar);
                            }
                            akVar.post(anonymousClass1);
                        } else {
                            xDl.post(anonymousClass1);
                        }
                    } else {
                        w(next, next2);
                    }
                }
            }
        }
    }
}
