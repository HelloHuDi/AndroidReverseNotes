package com.bumptech.glide.p086c.p088b;

import android.support.p057v4.p065f.C37122k.C8387a;
import com.bumptech.glide.p095h.C8561i;
import com.bumptech.glide.p095h.p1136a.C37193a;
import com.bumptech.glide.p095h.p1136a.C37193a.C31972c;
import com.bumptech.glide.p095h.p1136a.C37193a.C37194a;
import com.bumptech.glide.p095h.p1136a.C41574b;
import com.bumptech.glide.p095h.p1136a.C41574b.C17561a;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.bumptech.glide.c.b.t */
final class C8529t<Z> implements C17526u<Z>, C31972c {
    private static final C8387a<C8529t<?>> aCd = C37193a.m62341a(20, new C85301());
    private final C41574b aAq = new C17561a();
    private boolean aBU;
    private C17526u<Z> aCe;
    private boolean aCf;

    /* renamed from: com.bumptech.glide.c.b.t$1 */
    class C85301 implements C37194a<C8529t<?>> {
        C85301() {
        }

        /* renamed from: mG */
        public final /* synthetic */ Object mo18632mG() {
            AppMethodBeat.m2504i(91868);
            C8529t c8529t = new C8529t();
            AppMethodBeat.m2505o(91868);
            return c8529t;
        }
    }

    static {
        AppMethodBeat.m2504i(91876);
        AppMethodBeat.m2505o(91876);
    }

    /* renamed from: d */
    static <Z> C8529t<Z> m15147d(C17526u<Z> c17526u) {
        AppMethodBeat.m2504i(91869);
        C8529t c8529t = (C8529t) C8561i.m15217d((C8529t) aCd.mo6364aA(), "Argument must not be null");
        c8529t.aBU = false;
        c8529t.aCf = true;
        c8529t.aCe = c17526u;
        AppMethodBeat.m2505o(91869);
        return c8529t;
    }

    C8529t() {
        AppMethodBeat.m2504i(91870);
        AppMethodBeat.m2505o(91870);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void unlock() {
        AppMethodBeat.m2504i(91871);
        this.aAq.mo31993oq();
        if (this.aCf) {
            this.aCf = false;
            if (this.aBU) {
                recycle();
            }
            AppMethodBeat.m2505o(91871);
        } else {
            IllegalStateException illegalStateException = new IllegalStateException("Already unlocked");
            AppMethodBeat.m2505o(91871);
            throw illegalStateException;
        }
    }

    /* renamed from: mK */
    public final Class<Z> mo2232mK() {
        AppMethodBeat.m2504i(91872);
        Class mK = this.aCe.mo2232mK();
        AppMethodBeat.m2505o(91872);
        return mK;
    }

    public final Z get() {
        AppMethodBeat.m2504i(91873);
        Object obj = this.aCe.get();
        AppMethodBeat.m2505o(91873);
        return obj;
    }

    public final int getSize() {
        AppMethodBeat.m2504i(91874);
        int size = this.aCe.getSize();
        AppMethodBeat.m2505o(91874);
        return size;
    }

    public final synchronized void recycle() {
        AppMethodBeat.m2504i(91875);
        this.aAq.mo31993oq();
        this.aBU = true;
        if (!this.aCf) {
            this.aCe.recycle();
            this.aCe = null;
            aCd.release(this);
        }
        AppMethodBeat.m2505o(91875);
    }

    /* renamed from: my */
    public final C41574b mo18630my() {
        return this.aAq;
    }
}
