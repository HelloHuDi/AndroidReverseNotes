package com.tencent.p177mm.sdk.p603e;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.sdk.e.k */
public abstract class C7296k implements C4928g {
    protected final C4934l<C4931a, C4935m> xDf = new C72941();
    private final C4934l<Object, String> xDg = new C72952();

    /* renamed from: com.tencent.mm.sdk.e.k$a */
    public interface C4931a {
        /* renamed from: a */
        void mo5248a(String str, C4935m c4935m);
    }

    /* renamed from: com.tencent.mm.sdk.e.k$1 */
    class C72941 extends C4934l<C4931a, C4935m> {
        C72941() {
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        /* renamed from: w */
        public final /* synthetic */ void mo10134w(Object obj, Object obj2) {
            AppMethodBeat.m2504i(52516);
            C4935m c4935m = (C4935m) obj2;
            ((C4931a) obj).mo5248a(c4935m.ctq, c4935m);
            AppMethodBeat.m2505o(52516);
        }
    }

    /* renamed from: com.tencent.mm.sdk.e.k$2 */
    class C72952 extends C4934l<Object, String> {
        C72952() {
        }

        /* Access modifiers changed, original: protected|final|bridge|synthetic */
        /* renamed from: w */
        public final /* bridge */ /* synthetic */ void mo10134w(Object obj, Object obj2) {
        }
    }

    public void lock() {
        this.xDf.lock();
    }

    public void unlock() {
        this.xDf.unlock();
    }

    /* renamed from: c */
    public void mo10116c(C4931a c4931a) {
        this.xDf.mo10125a(c4931a, Looper.getMainLooper());
    }

    /* renamed from: a */
    public void mo10114a(C4931a c4931a, Looper looper) {
        this.xDf.mo10125a(c4931a, looper);
    }

    /* renamed from: d */
    public void mo10117d(C4931a c4931a) {
        this.xDf.remove(c4931a);
    }

    public final void doNotify() {
        this.xDf.mo10126cF(new C4935m("*"));
        this.xDf.doNotify();
    }

    public final void anF(String str) {
        this.xDf.mo10126cF(new C4935m(str));
        this.xDf.doNotify();
    }

    /* renamed from: b */
    public void mo15641b(String str, int i, Object obj) {
        C4935m c4935m = new C4935m();
        c4935m.ctq = str;
        c4935m.hsh = i;
        c4935m.obj = obj;
        c4935m.xDr = this;
        this.xDf.mo10126cF(c4935m);
        this.xDf.doNotify();
    }
}
