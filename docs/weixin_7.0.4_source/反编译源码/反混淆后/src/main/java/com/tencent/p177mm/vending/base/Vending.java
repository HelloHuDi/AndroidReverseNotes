package com.tencent.p177mm.vending.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.vending.base.C36368c.C36369a;
import com.tencent.p177mm.vending.p636b.C24124c;
import com.tencent.p177mm.vending.p636b.C7358b;
import com.tencent.p177mm.vending.p639e.C5684a;
import com.tencent.p177mm.vending.p640f.C5687a;
import com.tencent.p177mm.vending.p641g.C5698f;
import com.tencent.p177mm.vending.p642h.C5703d;
import com.tencent.p177mm.vending.p643i.C5709b;
import com.tencent.p177mm.vending.p644j.C5710a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.tencent.mm.vending.base.Vending */
public abstract class Vending<_Struct, _Index, _Change> implements C5684a {
    /* renamed from: a */
    private C36368c f17935a;
    /* renamed from: b */
    HashSet<C24131d> f17936b;
    /* renamed from: c */
    private Looper f17937c;
    /* renamed from: d */
    private Looper f17938d;
    /* renamed from: e */
    private Handler f17939e;
    /* renamed from: f */
    private Handler f17940f;
    /* renamed from: g */
    private AtomicBoolean f17941g;
    /* renamed from: h */
    private C24129c f17942h;
    /* renamed from: i */
    private byte[] f17943i;
    /* renamed from: j */
    private byte[] f17944j;
    /* renamed from: k */
    private boolean f17945k;
    /* renamed from: l */
    private boolean f17946l;
    /* renamed from: m */
    private C44412g<_Index> f17947m;
    /* renamed from: n */
    private volatile C24124c f17948n;
    /* renamed from: o */
    private volatile C24124c f17949o;
    /* renamed from: p */
    private C44413h<_Index, C46710i<_Struct, _Index>> f17950p;
    /* renamed from: q */
    private boolean f17951q;

    /* renamed from: com.tencent.mm.vending.base.Vending$8 */
    class C241278 implements Runnable {
        C241278() {
        }

        public final void run() {
            AppMethodBeat.m2504i(126147);
            C5687a.m8542i("Vending", "WTTTTF", new Object[0]);
            AppMethodBeat.m2505o(126147);
        }
    }

    /* renamed from: com.tencent.mm.vending.base.Vending$a */
    public interface C24128a {
        void cuN();
    }

    /* renamed from: com.tencent.mm.vending.base.Vending$c */
    public static final class C24129c<_Index> {
        /* renamed from: a */
        HashMap<_Index, C16032b> f4442a = new HashMap();
        /* renamed from: b */
        byte[] f4443b = new byte[0];
        /* renamed from: e */
        Handler f4444e;
        C5678a<_Index> zXp = null;
        AtomicBoolean zXq = new AtomicBoolean(false);

        /* renamed from: com.tencent.mm.vending.base.Vending$c$a */
        protected interface C5678a<_Index> {
            /* renamed from: cQ */
            void mo11562cQ(_Index _index);

            void cancel();
        }

        /* renamed from: com.tencent.mm.vending.base.Vending$c$b */
        public enum C16032b {
            NIL,
            PENDING,
            FILLED;

            static {
                AppMethodBeat.m2505o(126157);
            }
        }

        protected C24129c(Looper looper, C5678a<_Index> c5678a) {
            AppMethodBeat.m2504i(126150);
            this.zXp = c5678a;
            this.f4444e = new Handler(looper) {
                public final void handleMessage(Message message) {
                    AppMethodBeat.m2504i(126164);
                    if (C24129c.this.zXq.get()) {
                        C24129c.this.zXp.cancel();
                        AppMethodBeat.m2505o(126164);
                        return;
                    }
                    Object obj = message.obj;
                    C24129c.this.zXp.mo11562cQ(obj);
                    synchronized (C24129c.this.f4443b) {
                        try {
                            C24129c.this.f4442a.put(obj, C16032b.FILLED);
                        } finally {
                            while (true) {
                            }
                            AppMethodBeat.m2505o(126164);
                        }
                    }
                }
            };
            AppMethodBeat.m2505o(126150);
        }

        /* Access modifiers changed, original: protected|final */
        public final void dMe() {
            AppMethodBeat.m2504i(126151);
            this.f4444e.removeCallbacksAndMessages(null);
            C5687a.m8542i("Vending.Loader", "clear()", new Object[0]);
            synchronized (this.f4443b) {
                try {
                    this.f4442a.clear();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(126151);
                }
            }
            this.zXp.cancel();
        }
    }

    /* renamed from: com.tencent.mm.vending.base.Vending$d */
    public class C24131d {
        /* renamed from: b */
        private _Index f4445b;

        C24131d(_Index _index) {
            this.f4445b = _index;
        }
    }

    /* renamed from: com.tencent.mm.vending.base.Vending$e */
    static final class C24132e<T> {
        /* renamed from: a */
        volatile T f4446a;

        private C24132e() {
        }

        /* synthetic */ C24132e(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.vending.base.Vending$7 */
    class C308327 implements C5678a<_Index> {
        C308327() {
        }

        /* renamed from: cQ */
        public final void mo11562cQ(_Index _index) {
            AppMethodBeat.m2504i(126168);
            C46710i lock = Vending.this.getLock(_index);
            boolean a = Vending.this.m88512a(lock, (Object) _index);
            if (lock.f17933g) {
                C5687a.m8540d("Vending", "This lock is defer to return %s %s", lock, _index);
                AppMethodBeat.m2505o(126168);
            } else if (a) {
                AppMethodBeat.m2505o(126168);
            } else {
                Vending.this.m88503a(lock);
                AppMethodBeat.m2505o(126168);
            }
        }

        public final void cancel() {
            AppMethodBeat.m2504i(126169);
            Vending.this.loaderClear();
            Vending.this.m88517b();
            AppMethodBeat.m2505o(126169);
        }
    }

    /* renamed from: com.tencent.mm.vending.base.Vending$b */
    public interface C36367b<_Index> {
        /* renamed from: cP */
        void mo28395cP(_Index _index);
    }

    /* renamed from: com.tencent.mm.vending.base.Vending$3 */
    class C409203 implements C44411f {
        C409203() {
        }

        /* renamed from: a */
        public final void mo64545a() {
            AppMethodBeat.m2504i(126163);
            C5687a.m8542i("Vending", "SafeSparseArray fusing.", new Object[0]);
            Vending.this.m88517b();
            AppMethodBeat.m2505o(126163);
        }
    }

    /* renamed from: com.tencent.mm.vending.base.Vending$f */
    interface C44411f {
        /* renamed from: a */
        void mo64545a();
    }

    /* renamed from: com.tencent.mm.vending.base.Vending$g */
    static final class C44412g<_Index> {
        C24132e<_Index> zXw;
        C46710i zXx;

        private C44412g() {
            AppMethodBeat.m2504i(126152);
            this.zXw = new C24132e();
            AppMethodBeat.m2505o(126152);
        }

        /* synthetic */ C44412g(byte b) {
            this();
        }

        /* renamed from: a */
        public final void mo70298a() {
            this.zXw.f4446a = null;
            this.zXx = null;
        }
    }

    /* renamed from: com.tencent.mm.vending.base.Vending$h */
    static class C44413h<K, V> extends HashMap<K, V> {
        C44411f zXy = null;

        C44413h() {
        }

        public final void clear() {
            AppMethodBeat.m2504i(126170);
            super.clear();
            if (this.zXy != null) {
                this.zXy.mo64545a();
            }
            AppMethodBeat.m2505o(126170);
        }
    }

    /* renamed from: com.tencent.mm.vending.base.Vending$i */
    static final class C46710i<_Struct, _Index> {
        /* renamed from: a */
        _Index f17927a;
        /* renamed from: b */
        _Struct f17928b;
        /* renamed from: c */
        byte[] f17929c = new byte[0];
        /* renamed from: d */
        boolean f17930d = false;
        /* renamed from: e */
        boolean f17931e = false;
        /* renamed from: f */
        boolean f17932f = false;
        /* renamed from: g */
        boolean f17933g = false;
        /* renamed from: h */
        boolean f17934h = false;

        C46710i() {
            AppMethodBeat.m2504i(126167);
            AppMethodBeat.m2505o(126167);
        }
    }

    /* renamed from: com.tencent.mm.vending.base.Vending$4 */
    class C467114 implements C36369a {
        C467114() {
        }

        public final void dMc() {
            AppMethodBeat.m2504i(126159);
            C5687a.m8542i("Vending", "%s beforeSynchronize", Vending.this);
            Vending.this.f17942h.dMe();
            AppMethodBeat.m2505o(126159);
        }

        public final void synchronizing(int i, Object obj) {
            AppMethodBeat.m2504i(126160);
            C5687a.m8542i("Vending", "%s synchronizing", Vending.this);
            Vending.this.f17936b.clear();
            Vending.this.f17942h.dMe();
            Vending.this.f17939e.removeCallbacksAndMessages(null);
            if (i == 2) {
                obj = Vending.this.prepareVendingDataAsynchronous();
            }
            if (i == 2 || i == 1) {
                Vending.this.applyChangeSynchronized(obj);
            }
            Vending.this.synchronizing(i, obj);
            Vending.this.f17950p.clear();
            AppMethodBeat.m2505o(126160);
        }

        public final void dMd() {
            AppMethodBeat.m2504i(126161);
            C5687a.m8542i("Vending", "%s afterSynchronize", Vending.this);
            if (Vending.this.f17948n != null) {
                Vending.this.f17948n.aDt();
            }
            AppMethodBeat.m2505o(126161);
        }
    }

    public abstract void applyChangeSynchronized(_Change _change);

    public abstract void destroyAsynchronous();

    public abstract _Change prepareVendingDataAsynchronous();

    public abstract _Struct resolveAsynchronous(_Index _index);

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public C24129c<_Index> mo75077a() {
        return this.f17942h;
    }

    public C7358b<C24128a> addVendingDataChangedCallback(C24128a c24128a) {
        return this.f17948n.mo39928aD(c24128a);
    }

    public void removeVendingDataChangedCallback(C24128a c24128a) {
        this.f17948n.remove(c24128a);
    }

    public C7358b<C36367b> addVendingDataResolvedCallback(C36367b c36367b) {
        return this.f17949o.mo39928aD(c36367b);
    }

    public void removeVendingDataResolvedCallback(C36367b c36367b) {
        this.f17949o.remove(c36367b);
    }

    public Vending() {
        this(Looper.getMainLooper());
    }

    public Vending(Looper looper) {
        this.f17941g = new AtomicBoolean(false);
        this.f17943i = new byte[0];
        this.f17944j = new byte[0];
        this.f17945k = false;
        this.f17946l = false;
        this.f17947m = new C44412g();
        this.f17948n = new C24124c<C24128a>(C5703d.zYp) {
            /* renamed from: a */
            public final /* synthetic */ void mo28393a(Object obj, C5710a c5710a) {
                AppMethodBeat.m2504i(126165);
                ((C24128a) obj).cuN();
                AppMethodBeat.m2505o(126165);
            }
        };
        this.f17949o = new C24124c<C36367b>(C5703d.zYp) {
            /* renamed from: a */
            public final /* synthetic */ void mo28393a(Object obj, C5710a c5710a) {
                AppMethodBeat.m2504i(126154);
                ((C36367b) obj).mo28395cP(c5710a.get(0));
                AppMethodBeat.m2505o(126154);
            }
        };
        this.f17950p = new C44413h();
        this.f17936b = new HashSet();
        this.f17951q = false;
        this.f17937c = looper;
        this.f17938d = C5709b.dMs().f1355a.getLooper();
        this.f17950p.zXy = new C409203();
        this.f17935a = new C36368c(this.f17937c, this.f17938d);
        this.f17935a.zXA = new C467114();
        this.f17939e = new Handler(this.f17937c) {
            public final void handleMessage(Message message) {
                AppMethodBeat.m2504i(126166);
                switch (message.what) {
                    case 1:
                        C46710i c46710i = (C46710i) message.obj;
                        Vending.this.m88509a(c46710i.f17927a, c46710i.f17928b);
                        break;
                }
                AppMethodBeat.m2505o(126166);
            }
        };
        this.f17940f = new Handler(this.f17938d) {
            public final void handleMessage(Message message) {
                AppMethodBeat.m2504i(126158);
                switch (message.what) {
                    case 1:
                        Vending.this.m88519c();
                        AppMethodBeat.m2505o(126158);
                        return;
                    case 2:
                        Vending.this.destroyAsynchronous();
                        break;
                }
                AppMethodBeat.m2505o(126158);
            }
        };
        this.f17942h = new C24129c(this.f17938d, new C308327());
    }

    /* Access modifiers changed, original: protected */
    public void synchronizing(int i, Object obj) {
    }

    /* Access modifiers changed, original: protected */
    public C46710i<_Struct, _Index> getLock(_Index _index) {
        C46710i<_Struct, _Index> c46710i;
        synchronized (this.f17943i) {
            c46710i = (C46710i) this.f17950p.get(_index);
            if (c46710i == null) {
                c46710i = new C46710i();
                this.f17950p.put(_index, c46710i);
            }
        }
        return c46710i;
    }

    /* Access modifiers changed, original: protected */
    public C46710i<_Struct, _Index> peekLock(_Index _index) {
        C46710i c46710i;
        synchronized (this.f17943i) {
            c46710i = (C46710i) this.f17950p.get(_index);
        }
        return c46710i;
    }

    /* Access modifiers changed, original: protected */
    public C24131d defer(_Index _index) {
        looperCheckForVending();
        if (this.f17951q) {
            getLock(_index).f17933g = true;
            C24131d c24131d = new C24131d(_index);
            this.f17936b.add(c24131d);
            return c24131d;
        }
        C5687a.m8543w("Vending", "Please call defer in resolveAsynchronous()", new Object[0]);
        return null;
    }

    /* renamed from: a */
    private void m88502a(C24131d c24131d, _Index _index, _Struct _struct) {
        if (this.f17936b.contains(c24131d)) {
            C46710i lock = getLock(_index);
            synchronized (lock.f17929c) {
                lock.f17933g = false;
                m88504a(lock, (Object) _index, (Object) _struct);
            }
            m88503a(lock);
        }
    }

    public <T> T peek(_Index _index) {
        if (this.f17941g.get() || invalidIndex(_index)) {
            return null;
        }
        C46710i peekLock = peekLock(_index);
        if (peekLock == null || peekLock.f17930d) {
            return null;
        }
        return peekLock.f17928b;
    }

    public <T> T get(_Index _index) {
        return m88501a((Object) _index);
    }

    /* renamed from: a */
    private _Struct m88501a(_Index _index) {
        Looper myLooper = Looper.myLooper();
        if (myLooper != this.f17937c && myLooper != this.f17938d) {
            throw new IllegalAccessError("Call from wrong looper");
        } else if (this.f17941g.get()) {
            return null;
        } else {
            C46710i lock = getLock(_index);
            if (invalidIndex(_index)) {
                return lock.f17928b;
            }
            if (myLooper == this.f17937c) {
                return m88515b(lock, _index).f17928b;
            }
            m88512a(lock, (Object) _index);
            return lock.f17928b;
        }
    }

    /* renamed from: a */
    private void m88504a(C46710i<_Struct, _Index> c46710i, _Index _index, _Struct _struct) {
        c46710i.f17928b = _struct;
        c46710i.f17927a = _index;
        c46710i.f17930d = false;
        c46710i.f17931e = false;
        c46710i.f17932f = true;
        if (this.f17947m.zXx == c46710i) {
            c46710i.f17934h = true;
        }
        c46710i.f17929c.notify();
    }

    /* renamed from: a */
    private boolean m88512a(C46710i<_Struct, _Index> c46710i, _Index _index) {
        synchronized (c46710i.f17929c) {
            if (!c46710i.f17932f || c46710i.f17930d || c46710i.f17931e) {
                this.f17951q = true;
                Object resolveAsynchronous = resolveAsynchronous(_index);
                this.f17951q = false;
                if (c46710i.f17933g) {
                    return false;
                }
                m88504a((C46710i) c46710i, (Object) _index, resolveAsynchronous);
                return false;
            }
            return true;
        }
    }

    /* renamed from: b */
    private C46710i<_Struct, _Index> m88515b(C46710i<_Struct, _Index> c46710i, _Index _index) {
        if (C5709b.dMs().f1355a.isAlive()) {
            synchronized (c46710i.f17929c) {
                boolean c = m88520c(c46710i, _index);
                if (!c46710i.f17932f || c46710i.f17930d) {
                    if (c) {
                        this.f17947m.zXw.f4446a = _index;
                        this.f17947m.zXx = c46710i;
                        C5687a.m8542i("Vending", "%s waiting %s", this, _index);
                        long nanoTime = System.nanoTime();
                        try {
                            c46710i.f17929c.wait();
                        } catch (InterruptedException e) {
                        }
                        nanoTime = System.nanoTime() - nanoTime;
                        C5687a.m8542i("Vending", "%s waiting duration %s", this, Long.valueOf(nanoTime));
                        this.f17947m.mo70298a();
                    }
                }
            }
        } else {
            C5687a.m8541e("Vending", "Vending thread is not running!", new Object[0]);
        }
        return c46710i;
    }

    /* Access modifiers changed, original: protected */
    public boolean invalidIndex(_Index _index) {
        return false;
    }

    /* renamed from: b */
    private _Struct m88516b(_Index _index) {
        if (invalidIndex(_index)) {
            return null;
        }
        C46710i lock = getLock(_index);
        if (!m88520c(lock, _index) || lock.f17930d) {
            return null;
        }
        return lock.f17928b;
    }

    public void request(_Index _index) {
        m88510a((Object) _index, false);
    }

    public void requestConsistent(_Index _index) {
        m88510a((Object) _index, true);
    }

    /* renamed from: a */
    private void m88510a(_Index _index, boolean z) {
        looperCheckBoth();
        if (!this.f17941g.get()) {
            C46710i lock = getLock(_index);
            synchronized (lock.f17929c) {
                if (lock.f17932f) {
                    if (z) {
                        lock.f17930d = true;
                    } else {
                        lock.f17931e = true;
                    }
                }
            }
            m88516b((Object) _index);
        }
    }

    public void resolvedClear() {
        looperCheckBoth();
        if (!this.f17941g.get()) {
            this.f17935a.mo57287s(3, null);
        }
    }

    public void notifyVendingDataChange() {
        m88511a(false);
    }

    public void notifyVendingDataChangeSynchronize() {
        m88511a(true);
    }

    /* JADX WARNING: Missing block: B:24:0x0043, code skipped:
            if (android.os.Looper.myLooper() != r3.f17938d) goto L_0x0049;
     */
    /* JADX WARNING: Missing block: B:25:0x0045, code skipped:
            m88519c();
     */
    /* JADX WARNING: Missing block: B:26:0x0049, code skipped:
            r3.f17940f.removeMessages(1);
            r3.f17940f.sendMessage(r3.f17940f.obtainMessage(1));
            r3.f17940f.post(new com.tencent.p177mm.vending.base.Vending.C241278(r3));
     */
    /* JADX WARNING: Missing block: B:30:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:31:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private void m88511a(boolean z) {
        if (!this.f17941g.get()) {
            if (Looper.myLooper() != this.f17937c && Looper.myLooper() != this.f17938d) {
                throw new IllegalAccessError("Call from wrong thread");
            } else if (z) {
                this.f17935a.mo57287s(2, null);
            } else {
                synchronized (this.f17944j) {
                    if (this.f17946l) {
                        this.f17945k = true;
                    }
                }
            }
        }
    }

    public void freezeDataChange() {
        if (!this.f17941g.get()) {
            synchronized (this.f17944j) {
                this.f17946l = true;
            }
        }
    }

    public void unfreezeDataChange() {
        if (!this.f17941g.get()) {
            synchronized (this.f17944j) {
                this.f17946l = false;
                if (this.f17945k) {
                    notifyVendingDataChange();
                    this.f17945k = false;
                }
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void loaderClear() {
    }

    /* renamed from: b */
    private void m88517b() {
        if (this.f17947m.zXw.f4446a != null) {
            C5687a.m8541e("Vending", "Catch deadlock! Tell Carl! .. " + this.f17947m.zXw.f4446a, new Object[0]);
            if (this.f17947m.zXx != null) {
                synchronized (this.f17947m.zXx.f17929c) {
                    this.f17947m.zXx.f17929c.notify();
                }
                this.f17947m.mo70298a();
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void requestIndexImpl(C46710i<_Struct, _Index> c46710i, _Index _index) {
    }

    /* renamed from: c */
    private boolean m88520c(C46710i<_Struct, _Index> c46710i, _Index _index) {
        if (invalidIndex(_index)) {
            return false;
        }
        if (this.f17941g.get()) {
            C5687a.m8541e("Vending", "Vending.destroyed() has called.", new Object[0]);
            return false;
        }
        C24129c c24129c = this.f17942h;
        if (!c24129c.zXq.get()) {
            synchronized (c24129c.f4443b) {
                c24129c.f4442a.put(_index, C16032b.PENDING);
            }
            c24129c.f4444e.sendMessageAtFrontOfQueue(c24129c.f4444e.obtainMessage(0, _index));
        }
        requestIndexImpl(c46710i, _index);
        return true;
    }

    /* renamed from: c */
    private void m88519c() {
        if (!this.f17941g.get()) {
            C5687a.m8542i("Vending", "Vending.callPrepareVendingData()", new Object[0]);
            this.f17935a.mo57287s(1, prepareVendingDataAsynchronous());
        }
    }

    public Looper getLooper() {
        return this.f17938d;
    }

    public final void dead() {
        looperCheckBoth();
        C5687a.m8542i("Vending", "Vending.destroy()", new Object[0]);
        this.f17941g.set(true);
        this.f17940f.removeCallbacksAndMessages(null);
        this.f17939e.removeCallbacksAndMessages(null);
        this.f17942h.zXq.set(true);
        this.f17942h.dMe();
        this.f17940f.sendMessage(this.f17940f.obtainMessage(2));
    }

    /* renamed from: a */
    private void m88509a(_Index _index, _Struct _struct) {
        if (!this.f17941g.get() && this.f17949o != null) {
            this.f17949o.mo39927a(C5698f.m8560cV(_index));
        }
    }

    /* Access modifiers changed, original: protected */
    public void looperCheckForVending() {
        if (Looper.myLooper() != this.f17938d) {
            throw new IllegalAccessError("Call from wrong looper");
        }
    }

    /* Access modifiers changed, original: protected */
    public void looperCheckForSubscriber() {
        if (Looper.myLooper() != this.f17937c) {
            throw new IllegalAccessError("Call from wrong looper");
        }
    }

    /* Access modifiers changed, original: protected */
    public void looperCheckBoth() {
        Looper myLooper = Looper.myLooper();
        if (myLooper != this.f17937c && myLooper != this.f17938d) {
            throw new IllegalAccessError("Call from wrong looper");
        }
    }

    /* renamed from: a */
    private void m88503a(C46710i<_Struct, _Index> c46710i) {
        if (c46710i.f17934h) {
            c46710i.f17934h = false;
        } else {
            this.f17939e.sendMessage(this.f17939e.obtainMessage(1, c46710i));
        }
    }
}
