package com.bumptech.glide.c.b;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.bumptech.glide.c.h;
import com.bumptech.glide.f.f;
import com.bumptech.glide.h.a.a.c;
import com.bumptech.glide.h.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class k<R> implements a<R>, c {
    private static final a aBF = new a();
    private static final Handler aBG = new Handler(Looper.getMainLooper(), new b());
    com.bumptech.glide.c.a aAL;
    public final com.bumptech.glide.h.a.b aAq;
    private final android.support.v4.f.k.a<k<?>> aAr;
    boolean aAz;
    public final List<f> aBH;
    private final a aBI;
    boolean aBJ;
    boolean aBK;
    public boolean aBL;
    private p aBM;
    public boolean aBN;
    public List<f> aBO;
    o<?> aBP;
    public g<R> aBQ;
    private final com.bumptech.glide.c.b.c.a aBy;
    public final l aBz;
    private final com.bumptech.glide.c.b.c.a awq;
    final com.bumptech.glide.c.b.c.a awr;
    private final com.bumptech.glide.c.b.c.a awx;
    public h azP;
    boolean azQ;
    u<?> azR;
    public volatile boolean isCancelled;

    static class b implements Callback {
        b() {
        }

        public final boolean handleMessage(Message message) {
            AppMethodBeat.i(91822);
            k kVar = (k) message.obj;
            IllegalStateException illegalStateException;
            switch (message.what) {
                case 1:
                    kVar.aAq.oq();
                    if (!kVar.isCancelled) {
                        if (!kVar.aBH.isEmpty()) {
                            if (!kVar.aBL) {
                                kVar.aBP = new o(kVar.azR, kVar.azQ, true);
                                kVar.aBL = true;
                                kVar.aBP.acquire();
                                kVar.aBz.a(kVar, kVar.azP, kVar.aBP);
                                int size = kVar.aBH.size();
                                for (int i = 0; i < size; i++) {
                                    f fVar = (f) kVar.aBH.get(i);
                                    if (!kVar.b(fVar)) {
                                        kVar.aBP.acquire();
                                        fVar.c(kVar.aBP, kVar.aAL);
                                    }
                                }
                                kVar.aBP.release();
                                kVar.mI();
                                break;
                            }
                            illegalStateException = new IllegalStateException("Already have resource");
                            AppMethodBeat.o(91822);
                            throw illegalStateException;
                        }
                        illegalStateException = new IllegalStateException("Received a resource without any callbacks to notify");
                        AppMethodBeat.o(91822);
                        throw illegalStateException;
                    }
                    kVar.azR.recycle();
                    kVar.mI();
                    break;
                case 2:
                    kVar.mJ();
                    break;
                case 3:
                    kVar.aAq.oq();
                    if (kVar.isCancelled) {
                        kVar.aBz.a(kVar, kVar.azP);
                        kVar.mI();
                        break;
                    }
                    illegalStateException = new IllegalStateException("Not cancelled");
                    AppMethodBeat.o(91822);
                    throw illegalStateException;
                default:
                    illegalStateException = new IllegalStateException("Unrecognized message: " + message.what);
                    AppMethodBeat.o(91822);
                    throw illegalStateException;
            }
            AppMethodBeat.o(91822);
            return true;
        }
    }

    static class a {
        a() {
        }
    }

    static {
        AppMethodBeat.i(91831);
        AppMethodBeat.o(91831);
    }

    k(com.bumptech.glide.c.b.c.a aVar, com.bumptech.glide.c.b.c.a aVar2, com.bumptech.glide.c.b.c.a aVar3, com.bumptech.glide.c.b.c.a aVar4, l lVar, android.support.v4.f.k.a<k<?>> aVar5) {
        this(aVar, aVar2, aVar3, aVar4, lVar, aVar5, aBF);
    }

    private k(com.bumptech.glide.c.b.c.a aVar, com.bumptech.glide.c.b.c.a aVar2, com.bumptech.glide.c.b.c.a aVar3, com.bumptech.glide.c.b.c.a aVar4, l lVar, android.support.v4.f.k.a<k<?>> aVar5, a aVar6) {
        AppMethodBeat.i(91823);
        this.aBH = new ArrayList(2);
        this.aAq = new com.bumptech.glide.h.a.b.a();
        this.awr = aVar;
        this.awq = aVar2;
        this.aBy = aVar3;
        this.awx = aVar4;
        this.aBz = lVar;
        this.aAr = aVar5;
        this.aBI = aVar6;
        AppMethodBeat.o(91823);
    }

    /* Access modifiers changed, original: final */
    public final void a(f fVar) {
        AppMethodBeat.i(91824);
        j.om();
        this.aAq.oq();
        if (this.aBL) {
            fVar.c(this.aBP, this.aAL);
            AppMethodBeat.o(91824);
        } else if (this.aBN) {
            fVar.a(this.aBM);
            AppMethodBeat.o(91824);
        } else {
            this.aBH.add(fVar);
            AppMethodBeat.o(91824);
        }
    }

    /* Access modifiers changed, original: final */
    public final com.bumptech.glide.c.b.c.a mH() {
        if (this.aBJ) {
            return this.aBy;
        }
        return this.aBK ? this.awx : this.awq;
    }

    /* Access modifiers changed, original: final */
    public final boolean b(f fVar) {
        AppMethodBeat.i(91825);
        if (this.aBO == null || !this.aBO.contains(fVar)) {
            AppMethodBeat.o(91825);
            return false;
        }
        AppMethodBeat.o(91825);
        return true;
    }

    /* Access modifiers changed, original: final */
    public final void mI() {
        AppMethodBeat.i(91826);
        j.om();
        this.aBH.clear();
        this.azP = null;
        this.aBP = null;
        this.azR = null;
        if (this.aBO != null) {
            this.aBO.clear();
        }
        this.aBN = false;
        this.isCancelled = false;
        this.aBL = false;
        g gVar = this.aBQ;
        if (gVar.aAt.mA()) {
            gVar.ms();
        }
        this.aBQ = null;
        this.aBM = null;
        this.aAL = null;
        this.aAr.release(this);
        AppMethodBeat.o(91826);
    }

    public final void c(u<R> uVar, com.bumptech.glide.c.a aVar) {
        AppMethodBeat.i(91827);
        this.azR = uVar;
        this.aAL = aVar;
        aBG.obtainMessage(1, this).sendToTarget();
        AppMethodBeat.o(91827);
    }

    public final void a(p pVar) {
        AppMethodBeat.i(91828);
        this.aBM = pVar;
        aBG.obtainMessage(2, this).sendToTarget();
        AppMethodBeat.o(91828);
    }

    public final void a(g<?> gVar) {
        AppMethodBeat.i(91829);
        mH().execute(gVar);
        AppMethodBeat.o(91829);
    }

    /* Access modifiers changed, original: final */
    public final void mJ() {
        AppMethodBeat.i(91830);
        this.aAq.oq();
        IllegalStateException illegalStateException;
        if (this.isCancelled) {
            mI();
            AppMethodBeat.o(91830);
        } else if (this.aBH.isEmpty()) {
            illegalStateException = new IllegalStateException("Received an exception without any callbacks to notify");
            AppMethodBeat.o(91830);
            throw illegalStateException;
        } else if (this.aBN) {
            illegalStateException = new IllegalStateException("Already failed once");
            AppMethodBeat.o(91830);
            throw illegalStateException;
        } else {
            this.aBN = true;
            this.aBz.a(this, this.azP, null);
            for (f fVar : this.aBH) {
                if (!b(fVar)) {
                    fVar.a(this.aBM);
                }
            }
            mI();
            AppMethodBeat.o(91830);
        }
    }

    public final com.bumptech.glide.h.a.b my() {
        return this.aAq;
    }
}
