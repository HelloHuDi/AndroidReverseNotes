package com.bumptech.glide.c.b;

import android.os.Looper;
import com.bumptech.glide.c.h;
import com.bumptech.glide.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class o<Z> implements u<Z> {
    private final boolean aBS;
    private int aBT;
    private boolean aBU;
    private a azJ;
    private h azP;
    final boolean azQ;
    final u<Z> azR;

    interface a {
        void b(h hVar, o<?> oVar);
    }

    o(u<Z> uVar, boolean z, boolean z2) {
        AppMethodBeat.i(91837);
        this.azR = (u) i.d(uVar, "Argument must not be null");
        this.azQ = z;
        this.aBS = z2;
        AppMethodBeat.o(91837);
    }

    /* Access modifiers changed, original: final */
    public final void a(h hVar, a aVar) {
        this.azP = hVar;
        this.azJ = aVar;
    }

    public final Class<Z> mK() {
        AppMethodBeat.i(91838);
        Class mK = this.azR.mK();
        AppMethodBeat.o(91838);
        return mK;
    }

    public final Z get() {
        AppMethodBeat.i(91839);
        Object obj = this.azR.get();
        AppMethodBeat.o(91839);
        return obj;
    }

    public final int getSize() {
        AppMethodBeat.i(91840);
        int size = this.azR.getSize();
        AppMethodBeat.o(91840);
        return size;
    }

    public final void recycle() {
        AppMethodBeat.i(91841);
        IllegalStateException illegalStateException;
        if (this.aBT > 0) {
            illegalStateException = new IllegalStateException("Cannot recycle a resource while it is still acquired");
            AppMethodBeat.o(91841);
            throw illegalStateException;
        } else if (this.aBU) {
            illegalStateException = new IllegalStateException("Cannot recycle a resource that has already been recycled");
            AppMethodBeat.o(91841);
            throw illegalStateException;
        } else {
            this.aBU = true;
            if (this.aBS) {
                this.azR.recycle();
            }
            AppMethodBeat.o(91841);
        }
    }

    /* Access modifiers changed, original: final */
    public final void acquire() {
        AppMethodBeat.i(91842);
        if (this.aBU) {
            IllegalStateException illegalStateException = new IllegalStateException("Cannot acquire a recycled resource");
            AppMethodBeat.o(91842);
            throw illegalStateException;
        } else if (Looper.getMainLooper().equals(Looper.myLooper())) {
            this.aBT++;
            AppMethodBeat.o(91842);
        } else {
            IllegalThreadStateException illegalThreadStateException = new IllegalThreadStateException("Must call acquire on the main thread");
            AppMethodBeat.o(91842);
            throw illegalThreadStateException;
        }
    }

    /* Access modifiers changed, original: final */
    public final void release() {
        AppMethodBeat.i(91843);
        if (this.aBT <= 0) {
            IllegalStateException illegalStateException = new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            AppMethodBeat.o(91843);
            throw illegalStateException;
        } else if (Looper.getMainLooper().equals(Looper.myLooper())) {
            int i = this.aBT - 1;
            this.aBT = i;
            if (i == 0) {
                this.azJ.b(this.azP, this);
            }
            AppMethodBeat.o(91843);
        } else {
            IllegalThreadStateException illegalThreadStateException = new IllegalThreadStateException("Must call release on the main thread");
            AppMethodBeat.o(91843);
            throw illegalThreadStateException;
        }
    }

    public final String toString() {
        AppMethodBeat.i(91844);
        String str = "EngineResource{isCacheable=" + this.azQ + ", listener=" + this.azJ + ", key=" + this.azP + ", acquired=" + this.aBT + ", isRecycled=" + this.aBU + ", resource=" + this.azR + '}';
        AppMethodBeat.o(91844);
        return str;
    }
}
