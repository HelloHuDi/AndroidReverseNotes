package com.bumptech.glide.p086c.p088b;

import android.os.Looper;
import com.bumptech.glide.p086c.C0779h;
import com.bumptech.glide.p095h.C8561i;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.bumptech.glide.c.b.o */
final class C44988o<Z> implements C17526u<Z> {
    private final boolean aBS;
    private int aBT;
    private boolean aBU;
    private C44987a azJ;
    private C0779h azP;
    final boolean azQ;
    final C17526u<Z> azR;

    /* renamed from: com.bumptech.glide.c.b.o$a */
    interface C44987a {
        /* renamed from: b */
        void mo52055b(C0779h c0779h, C44988o<?> c44988o);
    }

    C44988o(C17526u<Z> c17526u, boolean z, boolean z2) {
        AppMethodBeat.m2504i(91837);
        this.azR = (C17526u) C8561i.m15217d(c17526u, "Argument must not be null");
        this.azQ = z;
        this.aBS = z2;
        AppMethodBeat.m2505o(91837);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo72280a(C0779h c0779h, C44987a c44987a) {
        this.azP = c0779h;
        this.azJ = c44987a;
    }

    /* renamed from: mK */
    public final Class<Z> mo2232mK() {
        AppMethodBeat.m2504i(91838);
        Class mK = this.azR.mo2232mK();
        AppMethodBeat.m2505o(91838);
        return mK;
    }

    public final Z get() {
        AppMethodBeat.m2504i(91839);
        Object obj = this.azR.get();
        AppMethodBeat.m2505o(91839);
        return obj;
    }

    public final int getSize() {
        AppMethodBeat.m2504i(91840);
        int size = this.azR.getSize();
        AppMethodBeat.m2505o(91840);
        return size;
    }

    public final void recycle() {
        AppMethodBeat.m2504i(91841);
        IllegalStateException illegalStateException;
        if (this.aBT > 0) {
            illegalStateException = new IllegalStateException("Cannot recycle a resource while it is still acquired");
            AppMethodBeat.m2505o(91841);
            throw illegalStateException;
        } else if (this.aBU) {
            illegalStateException = new IllegalStateException("Cannot recycle a resource that has already been recycled");
            AppMethodBeat.m2505o(91841);
            throw illegalStateException;
        } else {
            this.aBU = true;
            if (this.aBS) {
                this.azR.recycle();
            }
            AppMethodBeat.m2505o(91841);
        }
    }

    /* Access modifiers changed, original: final */
    public final void acquire() {
        AppMethodBeat.m2504i(91842);
        if (this.aBU) {
            IllegalStateException illegalStateException = new IllegalStateException("Cannot acquire a recycled resource");
            AppMethodBeat.m2505o(91842);
            throw illegalStateException;
        } else if (Looper.getMainLooper().equals(Looper.myLooper())) {
            this.aBT++;
            AppMethodBeat.m2505o(91842);
        } else {
            IllegalThreadStateException illegalThreadStateException = new IllegalThreadStateException("Must call acquire on the main thread");
            AppMethodBeat.m2505o(91842);
            throw illegalThreadStateException;
        }
    }

    /* Access modifiers changed, original: final */
    public final void release() {
        AppMethodBeat.m2504i(91843);
        if (this.aBT <= 0) {
            IllegalStateException illegalStateException = new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            AppMethodBeat.m2505o(91843);
            throw illegalStateException;
        } else if (Looper.getMainLooper().equals(Looper.myLooper())) {
            int i = this.aBT - 1;
            this.aBT = i;
            if (i == 0) {
                this.azJ.mo52055b(this.azP, this);
            }
            AppMethodBeat.m2505o(91843);
        } else {
            IllegalThreadStateException illegalThreadStateException = new IllegalThreadStateException("Must call release on the main thread");
            AppMethodBeat.m2505o(91843);
            throw illegalThreadStateException;
        }
    }

    public final String toString() {
        AppMethodBeat.m2504i(91844);
        String str = "EngineResource{isCacheable=" + this.azQ + ", listener=" + this.azJ + ", key=" + this.azP + ", acquired=" + this.aBT + ", isRecycled=" + this.aBU + ", resource=" + this.azR + '}';
        AppMethodBeat.m2505o(91844);
        return str;
    }
}
