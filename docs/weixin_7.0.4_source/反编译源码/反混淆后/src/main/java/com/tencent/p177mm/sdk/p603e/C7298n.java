package com.tencent.p177mm.sdk.p603e;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.sdk.e.n */
public abstract class C7298n implements C4929h {
    private final C4934l<C4937b, C4936a> xDf = new C72971();

    /* renamed from: com.tencent.mm.sdk.e.n$a */
    class C4936a {
        Object obj;
        int xDt;
        C7298n xDu;

        C4936a(int i, C7298n c7298n, Object obj) {
            this.xDt = i;
            this.obj = obj;
            this.xDu = c7298n;
        }
    }

    /* renamed from: com.tencent.mm.sdk.e.n$b */
    public interface C4937b {
        /* renamed from: a */
        void mo10136a(int i, C7298n c7298n, Object obj);
    }

    /* renamed from: com.tencent.mm.sdk.e.n$1 */
    class C72971 extends C4934l<C4937b, C4936a> {
        C72971() {
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        /* renamed from: w */
        public final /* synthetic */ void mo10134w(Object obj, Object obj2) {
            AppMethodBeat.m2504i(52519);
            C4937b c4937b = (C4937b) obj;
            C4936a c4936a = (C4936a) obj2;
            if (C7298n.this.apK()) {
                c4937b.mo10136a(c4936a.xDt, c4936a.xDu, c4936a.obj);
            }
            AppMethodBeat.m2505o(52519);
        }
    }

    public abstract boolean apK();

    /* renamed from: a */
    public final void mo10118a(C4937b c4937b) {
        if (c4937b != null) {
            this.xDf.mo10125a(c4937b, Looper.getMainLooper());
        }
    }

    /* renamed from: a */
    public final void mo10119a(C4937b c4937b, Looper looper) {
        this.xDf.mo10125a(c4937b, looper);
    }

    /* renamed from: b */
    public final void mo10121b(C4937b c4937b) {
        if (c4937b != null) {
            this.xDf.remove(c4937b);
        }
    }

    /* renamed from: b */
    public final void mo10120b(int i, C7298n c7298n, Object obj) {
        this.xDf.mo10126cF(new C4936a(i, c7298n, obj));
        this.xDf.doNotify();
    }
}
