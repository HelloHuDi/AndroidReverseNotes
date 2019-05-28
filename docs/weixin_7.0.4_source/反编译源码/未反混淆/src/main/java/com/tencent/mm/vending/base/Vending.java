package com.tencent.mm.vending.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class Vending<_Struct, _Index, _Change> implements com.tencent.mm.vending.e.a {
    private c a;
    HashSet<d> b;
    private Looper c;
    private Looper d;
    private Handler e;
    private Handler f;
    private AtomicBoolean g;
    private c h;
    private byte[] i;
    private byte[] j;
    private boolean k;
    private boolean l;
    private g<_Index> m;
    private volatile com.tencent.mm.vending.b.c n;
    private volatile com.tencent.mm.vending.b.c o;
    private h<_Index, i<_Struct, _Index>> p;
    private boolean q;

    public interface a {
        void cuN();
    }

    public static final class c<_Index> {
        HashMap<_Index, b> a = new HashMap();
        byte[] b = new byte[0];
        Handler e;
        a<_Index> zXp = null;
        AtomicBoolean zXq = new AtomicBoolean(false);

        protected interface a<_Index> {
            void cQ(_Index _index);

            void cancel();
        }

        public enum b {
            NIL,
            PENDING,
            FILLED;

            static {
                AppMethodBeat.o(126157);
            }
        }

        protected c(Looper looper, a<_Index> aVar) {
            AppMethodBeat.i(126150);
            this.zXp = aVar;
            this.e = new Handler(looper) {
                public final void handleMessage(Message message) {
                    AppMethodBeat.i(126164);
                    if (c.this.zXq.get()) {
                        c.this.zXp.cancel();
                        AppMethodBeat.o(126164);
                        return;
                    }
                    Object obj = message.obj;
                    c.this.zXp.cQ(obj);
                    synchronized (c.this.b) {
                        try {
                            c.this.a.put(obj, b.FILLED);
                        } finally {
                            while (true) {
                            }
                            AppMethodBeat.o(126164);
                        }
                    }
                }
            };
            AppMethodBeat.o(126150);
        }

        /* Access modifiers changed, original: protected|final */
        public final void dMe() {
            AppMethodBeat.i(126151);
            this.e.removeCallbacksAndMessages(null);
            com.tencent.mm.vending.f.a.i("Vending.Loader", "clear()", new Object[0]);
            synchronized (this.b) {
                try {
                    this.a.clear();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(126151);
                }
            }
            this.zXp.cancel();
        }
    }

    public class d {
        private _Index b;

        d(_Index _index) {
            this.b = _index;
        }
    }

    static final class e<T> {
        volatile T a;

        private e() {
        }

        /* synthetic */ e(byte b) {
            this();
        }
    }

    public interface b<_Index> {
        void cP(_Index _index);
    }

    interface f {
        void a();
    }

    static final class g<_Index> {
        e<_Index> zXw;
        i zXx;

        private g() {
            AppMethodBeat.i(126152);
            this.zXw = new e();
            AppMethodBeat.o(126152);
        }

        /* synthetic */ g(byte b) {
            this();
        }

        public final void a() {
            this.zXw.a = null;
            this.zXx = null;
        }
    }

    static class h<K, V> extends HashMap<K, V> {
        f zXy = null;

        h() {
        }

        public final void clear() {
            AppMethodBeat.i(126170);
            super.clear();
            if (this.zXy != null) {
                this.zXy.a();
            }
            AppMethodBeat.o(126170);
        }
    }

    static final class i<_Struct, _Index> {
        _Index a;
        _Struct b;
        byte[] c = new byte[0];
        boolean d = false;
        boolean e = false;
        boolean f = false;
        boolean g = false;
        boolean h = false;

        i() {
            AppMethodBeat.i(126167);
            AppMethodBeat.o(126167);
        }
    }

    public abstract void applyChangeSynchronized(_Change _change);

    public abstract void destroyAsynchronous();

    public abstract _Change prepareVendingDataAsynchronous();

    public abstract _Struct resolveAsynchronous(_Index _index);

    /* Access modifiers changed, original: 0000 */
    public c<_Index> a() {
        return this.h;
    }

    public com.tencent.mm.vending.b.b<a> addVendingDataChangedCallback(a aVar) {
        return this.n.aD(aVar);
    }

    public void removeVendingDataChangedCallback(a aVar) {
        this.n.remove(aVar);
    }

    public com.tencent.mm.vending.b.b<b> addVendingDataResolvedCallback(b bVar) {
        return this.o.aD(bVar);
    }

    public void removeVendingDataResolvedCallback(b bVar) {
        this.o.remove(bVar);
    }

    public Vending() {
        this(Looper.getMainLooper());
    }

    public Vending(Looper looper) {
        this.g = new AtomicBoolean(false);
        this.i = new byte[0];
        this.j = new byte[0];
        this.k = false;
        this.l = false;
        this.m = new g();
        this.n = new com.tencent.mm.vending.b.c<a>(com.tencent.mm.vending.h.d.zYp) {
            public final /* synthetic */ void a(Object obj, com.tencent.mm.vending.j.a aVar) {
                AppMethodBeat.i(126165);
                ((a) obj).cuN();
                AppMethodBeat.o(126165);
            }
        };
        this.o = new com.tencent.mm.vending.b.c<b>(com.tencent.mm.vending.h.d.zYp) {
            public final /* synthetic */ void a(Object obj, com.tencent.mm.vending.j.a aVar) {
                AppMethodBeat.i(126154);
                ((b) obj).cP(aVar.get(0));
                AppMethodBeat.o(126154);
            }
        };
        this.p = new h();
        this.b = new HashSet();
        this.q = false;
        this.c = looper;
        this.d = com.tencent.mm.vending.i.b.dMs().a.getLooper();
        this.p.zXy = new f() {
            public final void a() {
                AppMethodBeat.i(126163);
                com.tencent.mm.vending.f.a.i("Vending", "SafeSparseArray fusing.", new Object[0]);
                Vending.this.b();
                AppMethodBeat.o(126163);
            }
        };
        this.a = new c(this.c, this.d);
        this.a.zXA = new com.tencent.mm.vending.base.c.a() {
            public final void dMc() {
                AppMethodBeat.i(126159);
                com.tencent.mm.vending.f.a.i("Vending", "%s beforeSynchronize", Vending.this);
                Vending.this.h.dMe();
                AppMethodBeat.o(126159);
            }

            public final void synchronizing(int i, Object obj) {
                AppMethodBeat.i(126160);
                com.tencent.mm.vending.f.a.i("Vending", "%s synchronizing", Vending.this);
                Vending.this.b.clear();
                Vending.this.h.dMe();
                Vending.this.e.removeCallbacksAndMessages(null);
                if (i == 2) {
                    obj = Vending.this.prepareVendingDataAsynchronous();
                }
                if (i == 2 || i == 1) {
                    Vending.this.applyChangeSynchronized(obj);
                }
                Vending.this.synchronizing(i, obj);
                Vending.this.p.clear();
                AppMethodBeat.o(126160);
            }

            public final void dMd() {
                AppMethodBeat.i(126161);
                com.tencent.mm.vending.f.a.i("Vending", "%s afterSynchronize", Vending.this);
                if (Vending.this.n != null) {
                    Vending.this.n.aDt();
                }
                AppMethodBeat.o(126161);
            }
        };
        this.e = new Handler(this.c) {
            public final void handleMessage(Message message) {
                AppMethodBeat.i(126166);
                switch (message.what) {
                    case 1:
                        i iVar = (i) message.obj;
                        Vending.this.a(iVar.a, iVar.b);
                        break;
                }
                AppMethodBeat.o(126166);
            }
        };
        this.f = new Handler(this.d) {
            public final void handleMessage(Message message) {
                AppMethodBeat.i(126158);
                switch (message.what) {
                    case 1:
                        Vending.this.c();
                        AppMethodBeat.o(126158);
                        return;
                    case 2:
                        Vending.this.destroyAsynchronous();
                        break;
                }
                AppMethodBeat.o(126158);
            }
        };
        this.h = new c(this.d, new a<_Index>() {
            public final void cQ(_Index _index) {
                AppMethodBeat.i(126168);
                i lock = Vending.this.getLock(_index);
                boolean a = Vending.this.a(lock, (Object) _index);
                if (lock.g) {
                    com.tencent.mm.vending.f.a.d("Vending", "This lock is defer to return %s %s", lock, _index);
                    AppMethodBeat.o(126168);
                } else if (a) {
                    AppMethodBeat.o(126168);
                } else {
                    Vending.this.a(lock);
                    AppMethodBeat.o(126168);
                }
            }

            public final void cancel() {
                AppMethodBeat.i(126169);
                Vending.this.loaderClear();
                Vending.this.b();
                AppMethodBeat.o(126169);
            }
        });
    }

    /* Access modifiers changed, original: protected */
    public void synchronizing(int i, Object obj) {
    }

    /* Access modifiers changed, original: protected */
    public i<_Struct, _Index> getLock(_Index _index) {
        i<_Struct, _Index> iVar;
        synchronized (this.i) {
            iVar = (i) this.p.get(_index);
            if (iVar == null) {
                iVar = new i();
                this.p.put(_index, iVar);
            }
        }
        return iVar;
    }

    /* Access modifiers changed, original: protected */
    public i<_Struct, _Index> peekLock(_Index _index) {
        i iVar;
        synchronized (this.i) {
            iVar = (i) this.p.get(_index);
        }
        return iVar;
    }

    /* Access modifiers changed, original: protected */
    public d defer(_Index _index) {
        looperCheckForVending();
        if (this.q) {
            getLock(_index).g = true;
            d dVar = new d(_index);
            this.b.add(dVar);
            return dVar;
        }
        com.tencent.mm.vending.f.a.w("Vending", "Please call defer in resolveAsynchronous()", new Object[0]);
        return null;
    }

    private void a(d dVar, _Index _index, _Struct _struct) {
        if (this.b.contains(dVar)) {
            i lock = getLock(_index);
            synchronized (lock.c) {
                lock.g = false;
                a(lock, (Object) _index, (Object) _struct);
            }
            a(lock);
        }
    }

    public <T> T peek(_Index _index) {
        if (this.g.get() || invalidIndex(_index)) {
            return null;
        }
        i peekLock = peekLock(_index);
        if (peekLock == null || peekLock.d) {
            return null;
        }
        return peekLock.b;
    }

    public <T> T get(_Index _index) {
        return a((Object) _index);
    }

    private _Struct a(_Index _index) {
        Looper myLooper = Looper.myLooper();
        if (myLooper != this.c && myLooper != this.d) {
            throw new IllegalAccessError("Call from wrong looper");
        } else if (this.g.get()) {
            return null;
        } else {
            i lock = getLock(_index);
            if (invalidIndex(_index)) {
                return lock.b;
            }
            if (myLooper == this.c) {
                return b(lock, _index).b;
            }
            a(lock, (Object) _index);
            return lock.b;
        }
    }

    private void a(i<_Struct, _Index> iVar, _Index _index, _Struct _struct) {
        iVar.b = _struct;
        iVar.a = _index;
        iVar.d = false;
        iVar.e = false;
        iVar.f = true;
        if (this.m.zXx == iVar) {
            iVar.h = true;
        }
        iVar.c.notify();
    }

    private boolean a(i<_Struct, _Index> iVar, _Index _index) {
        synchronized (iVar.c) {
            if (!iVar.f || iVar.d || iVar.e) {
                this.q = true;
                Object resolveAsynchronous = resolveAsynchronous(_index);
                this.q = false;
                if (iVar.g) {
                    return false;
                }
                a((i) iVar, (Object) _index, resolveAsynchronous);
                return false;
            }
            return true;
        }
    }

    private i<_Struct, _Index> b(i<_Struct, _Index> iVar, _Index _index) {
        if (com.tencent.mm.vending.i.b.dMs().a.isAlive()) {
            synchronized (iVar.c) {
                boolean c = c(iVar, _index);
                if (!iVar.f || iVar.d) {
                    if (c) {
                        this.m.zXw.a = _index;
                        this.m.zXx = iVar;
                        com.tencent.mm.vending.f.a.i("Vending", "%s waiting %s", this, _index);
                        long nanoTime = System.nanoTime();
                        try {
                            iVar.c.wait();
                        } catch (InterruptedException e) {
                        }
                        nanoTime = System.nanoTime() - nanoTime;
                        com.tencent.mm.vending.f.a.i("Vending", "%s waiting duration %s", this, Long.valueOf(nanoTime));
                        this.m.a();
                    }
                }
            }
        } else {
            com.tencent.mm.vending.f.a.e("Vending", "Vending thread is not running!", new Object[0]);
        }
        return iVar;
    }

    /* Access modifiers changed, original: protected */
    public boolean invalidIndex(_Index _index) {
        return false;
    }

    private _Struct b(_Index _index) {
        if (invalidIndex(_index)) {
            return null;
        }
        i lock = getLock(_index);
        if (!c(lock, _index) || lock.d) {
            return null;
        }
        return lock.b;
    }

    public void request(_Index _index) {
        a((Object) _index, false);
    }

    public void requestConsistent(_Index _index) {
        a((Object) _index, true);
    }

    private void a(_Index _index, boolean z) {
        looperCheckBoth();
        if (!this.g.get()) {
            i lock = getLock(_index);
            synchronized (lock.c) {
                if (lock.f) {
                    if (z) {
                        lock.d = true;
                    } else {
                        lock.e = true;
                    }
                }
            }
            b((Object) _index);
        }
    }

    public void resolvedClear() {
        looperCheckBoth();
        if (!this.g.get()) {
            this.a.s(3, null);
        }
    }

    public void notifyVendingDataChange() {
        a(false);
    }

    public void notifyVendingDataChangeSynchronize() {
        a(true);
    }

    /* JADX WARNING: Missing block: B:24:0x0043, code skipped:
            if (android.os.Looper.myLooper() != r3.d) goto L_0x0049;
     */
    /* JADX WARNING: Missing block: B:25:0x0045, code skipped:
            c();
     */
    /* JADX WARNING: Missing block: B:26:0x0049, code skipped:
            r3.f.removeMessages(1);
            r3.f.sendMessage(r3.f.obtainMessage(1));
            r3.f.post(new com.tencent.mm.vending.base.Vending.AnonymousClass8(r3));
     */
    /* JADX WARNING: Missing block: B:30:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:31:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(boolean z) {
        if (!this.g.get()) {
            if (Looper.myLooper() != this.c && Looper.myLooper() != this.d) {
                throw new IllegalAccessError("Call from wrong thread");
            } else if (z) {
                this.a.s(2, null);
            } else {
                synchronized (this.j) {
                    if (this.l) {
                        this.k = true;
                    }
                }
            }
        }
    }

    public void freezeDataChange() {
        if (!this.g.get()) {
            synchronized (this.j) {
                this.l = true;
            }
        }
    }

    public void unfreezeDataChange() {
        if (!this.g.get()) {
            synchronized (this.j) {
                this.l = false;
                if (this.k) {
                    notifyVendingDataChange();
                    this.k = false;
                }
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void loaderClear() {
    }

    private void b() {
        if (this.m.zXw.a != null) {
            com.tencent.mm.vending.f.a.e("Vending", "Catch deadlock! Tell Carl! .. " + this.m.zXw.a, new Object[0]);
            if (this.m.zXx != null) {
                synchronized (this.m.zXx.c) {
                    this.m.zXx.c.notify();
                }
                this.m.a();
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void requestIndexImpl(i<_Struct, _Index> iVar, _Index _index) {
    }

    private boolean c(i<_Struct, _Index> iVar, _Index _index) {
        if (invalidIndex(_index)) {
            return false;
        }
        if (this.g.get()) {
            com.tencent.mm.vending.f.a.e("Vending", "Vending.destroyed() has called.", new Object[0]);
            return false;
        }
        c cVar = this.h;
        if (!cVar.zXq.get()) {
            synchronized (cVar.b) {
                cVar.a.put(_index, b.PENDING);
            }
            cVar.e.sendMessageAtFrontOfQueue(cVar.e.obtainMessage(0, _index));
        }
        requestIndexImpl(iVar, _index);
        return true;
    }

    private void c() {
        if (!this.g.get()) {
            com.tencent.mm.vending.f.a.i("Vending", "Vending.callPrepareVendingData()", new Object[0]);
            this.a.s(1, prepareVendingDataAsynchronous());
        }
    }

    public Looper getLooper() {
        return this.d;
    }

    public final void dead() {
        looperCheckBoth();
        com.tencent.mm.vending.f.a.i("Vending", "Vending.destroy()", new Object[0]);
        this.g.set(true);
        this.f.removeCallbacksAndMessages(null);
        this.e.removeCallbacksAndMessages(null);
        this.h.zXq.set(true);
        this.h.dMe();
        this.f.sendMessage(this.f.obtainMessage(2));
    }

    private void a(_Index _index, _Struct _struct) {
        if (!this.g.get() && this.o != null) {
            this.o.a(com.tencent.mm.vending.g.f.cV(_index));
        }
    }

    /* Access modifiers changed, original: protected */
    public void looperCheckForVending() {
        if (Looper.myLooper() != this.d) {
            throw new IllegalAccessError("Call from wrong looper");
        }
    }

    /* Access modifiers changed, original: protected */
    public void looperCheckForSubscriber() {
        if (Looper.myLooper() != this.c) {
            throw new IllegalAccessError("Call from wrong looper");
        }
    }

    /* Access modifiers changed, original: protected */
    public void looperCheckBoth() {
        Looper myLooper = Looper.myLooper();
        if (myLooper != this.c && myLooper != this.d) {
            throw new IllegalAccessError("Call from wrong looper");
        }
    }

    private void a(i<_Struct, _Index> iVar) {
        if (iVar.h) {
            iVar.h = false;
        } else {
            this.e.sendMessage(this.e.obtainMessage(1, iVar));
        }
    }
}
