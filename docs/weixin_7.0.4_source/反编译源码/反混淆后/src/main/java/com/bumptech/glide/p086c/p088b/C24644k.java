package com.bumptech.glide.p086c.p088b;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.p057v4.p065f.C37122k.C8387a;
import com.bumptech.glide.p086c.C0779h;
import com.bumptech.glide.p086c.C25405a;
import com.bumptech.glide.p086c.p088b.C36671g.C17522a;
import com.bumptech.glide.p086c.p088b.p786c.C44985a;
import com.bumptech.glide.p095h.C45002j;
import com.bumptech.glide.p095h.p1136a.C37193a.C31972c;
import com.bumptech.glide.p095h.p1136a.C41574b;
import com.bumptech.glide.p095h.p1136a.C41574b.C17561a;
import com.bumptech.glide.p791f.C41571f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bumptech.glide.c.b.k */
public final class C24644k<R> implements C17522a<R>, C31972c {
    private static final C24645a aBF = new C24645a();
    private static final Handler aBG = new Handler(Looper.getMainLooper(), new C8526b());
    C25405a aAL;
    public final C41574b aAq;
    private final C8387a<C24644k<?>> aAr;
    boolean aAz;
    public final List<C41571f> aBH;
    private final C24645a aBI;
    boolean aBJ;
    boolean aBK;
    public boolean aBL;
    private C37169p aBM;
    public boolean aBN;
    public List<C41571f> aBO;
    C44988o<?> aBP;
    public C36671g<R> aBQ;
    private final C44985a aBy;
    public final C25423l aBz;
    private final C44985a awq;
    final C44985a awr;
    private final C44985a awx;
    public C0779h azP;
    boolean azQ;
    C17526u<?> azR;
    public volatile boolean isCancelled;

    /* renamed from: com.bumptech.glide.c.b.k$b */
    static class C8526b implements Callback {
        C8526b() {
        }

        public final boolean handleMessage(Message message) {
            AppMethodBeat.m2504i(91822);
            C24644k c24644k = (C24644k) message.obj;
            IllegalStateException illegalStateException;
            switch (message.what) {
                case 1:
                    c24644k.aAq.mo31993oq();
                    if (!c24644k.isCancelled) {
                        if (!c24644k.aBH.isEmpty()) {
                            if (!c24644k.aBL) {
                                c24644k.aBP = new C44988o(c24644k.azR, c24644k.azQ, true);
                                c24644k.aBL = true;
                                c24644k.aBP.acquire();
                                c24644k.aBz.mo42466a(c24644k, c24644k.azP, c24644k.aBP);
                                int size = c24644k.aBH.size();
                                for (int i = 0; i < size; i++) {
                                    C41571f c41571f = (C41571f) c24644k.aBH.get(i);
                                    if (!c24644k.mo41477b(c41571f)) {
                                        c24644k.aBP.acquire();
                                        c41571f.mo66598c(c24644k.aBP, c24644k.aAL);
                                    }
                                }
                                c24644k.aBP.release();
                                c24644k.mo41479mI();
                                break;
                            }
                            illegalStateException = new IllegalStateException("Already have resource");
                            AppMethodBeat.m2505o(91822);
                            throw illegalStateException;
                        }
                        illegalStateException = new IllegalStateException("Received a resource without any callbacks to notify");
                        AppMethodBeat.m2505o(91822);
                        throw illegalStateException;
                    }
                    c24644k.azR.recycle();
                    c24644k.mo41479mI();
                    break;
                case 2:
                    c24644k.mo41480mJ();
                    break;
                case 3:
                    c24644k.aAq.mo31993oq();
                    if (c24644k.isCancelled) {
                        c24644k.aBz.mo42465a(c24644k, c24644k.azP);
                        c24644k.mo41479mI();
                        break;
                    }
                    illegalStateException = new IllegalStateException("Not cancelled");
                    AppMethodBeat.m2505o(91822);
                    throw illegalStateException;
                default:
                    illegalStateException = new IllegalStateException("Unrecognized message: " + message.what);
                    AppMethodBeat.m2505o(91822);
                    throw illegalStateException;
            }
            AppMethodBeat.m2505o(91822);
            return true;
        }
    }

    /* renamed from: com.bumptech.glide.c.b.k$a */
    static class C24645a {
        C24645a() {
        }
    }

    static {
        AppMethodBeat.m2504i(91831);
        AppMethodBeat.m2505o(91831);
    }

    C24644k(C44985a c44985a, C44985a c44985a2, C44985a c44985a3, C44985a c44985a4, C25423l c25423l, C8387a<C24644k<?>> c8387a) {
        this(c44985a, c44985a2, c44985a3, c44985a4, c25423l, c8387a, aBF);
    }

    private C24644k(C44985a c44985a, C44985a c44985a2, C44985a c44985a3, C44985a c44985a4, C25423l c25423l, C8387a<C24644k<?>> c8387a, C24645a c24645a) {
        AppMethodBeat.m2504i(91823);
        this.aBH = new ArrayList(2);
        this.aAq = new C17561a();
        this.awr = c44985a;
        this.awq = c44985a2;
        this.aBy = c44985a3;
        this.awx = c44985a4;
        this.aBz = c25423l;
        this.aAr = c8387a;
        this.aBI = c24645a;
        AppMethodBeat.m2505o(91823);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo41476a(C41571f c41571f) {
        AppMethodBeat.m2504i(91824);
        C45002j.m82426om();
        this.aAq.mo31993oq();
        if (this.aBL) {
            c41571f.mo66598c(this.aBP, this.aAL);
            AppMethodBeat.m2505o(91824);
        } else if (this.aBN) {
            c41571f.mo66597a(this.aBM);
            AppMethodBeat.m2505o(91824);
        } else {
            this.aBH.add(c41571f);
            AppMethodBeat.m2505o(91824);
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: mH */
    public final C44985a mo41478mH() {
        if (this.aBJ) {
            return this.aBy;
        }
        return this.aBK ? this.awx : this.awq;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final boolean mo41477b(C41571f c41571f) {
        AppMethodBeat.m2504i(91825);
        if (this.aBO == null || !this.aBO.contains(c41571f)) {
            AppMethodBeat.m2505o(91825);
            return false;
        }
        AppMethodBeat.m2505o(91825);
        return true;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: mI */
    public final void mo41479mI() {
        AppMethodBeat.m2504i(91826);
        C45002j.m82426om();
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
        C36671g c36671g = this.aBQ;
        if (c36671g.aAt.mo31957mA()) {
            c36671g.mo58537ms();
        }
        this.aBQ = null;
        this.aBM = null;
        this.aAL = null;
        this.aAr.release(this);
        AppMethodBeat.m2505o(91826);
    }

    /* renamed from: c */
    public final void mo31953c(C17526u<R> c17526u, C25405a c25405a) {
        AppMethodBeat.m2504i(91827);
        this.azR = c17526u;
        this.aAL = c25405a;
        aBG.obtainMessage(1, this).sendToTarget();
        AppMethodBeat.m2505o(91827);
    }

    /* renamed from: a */
    public final void mo31952a(C37169p c37169p) {
        AppMethodBeat.m2504i(91828);
        this.aBM = c37169p;
        aBG.obtainMessage(2, this).sendToTarget();
        AppMethodBeat.m2505o(91828);
    }

    /* renamed from: a */
    public final void mo31951a(C36671g<?> c36671g) {
        AppMethodBeat.m2504i(91829);
        mo41478mH().execute(c36671g);
        AppMethodBeat.m2505o(91829);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: mJ */
    public final void mo41480mJ() {
        AppMethodBeat.m2504i(91830);
        this.aAq.mo31993oq();
        IllegalStateException illegalStateException;
        if (this.isCancelled) {
            mo41479mI();
            AppMethodBeat.m2505o(91830);
        } else if (this.aBH.isEmpty()) {
            illegalStateException = new IllegalStateException("Received an exception without any callbacks to notify");
            AppMethodBeat.m2505o(91830);
            throw illegalStateException;
        } else if (this.aBN) {
            illegalStateException = new IllegalStateException("Already failed once");
            AppMethodBeat.m2505o(91830);
            throw illegalStateException;
        } else {
            this.aBN = true;
            this.aBz.mo42466a(this, this.azP, null);
            for (C41571f c41571f : this.aBH) {
                if (!mo41477b(c41571f)) {
                    c41571f.mo66597a(this.aBM);
                }
            }
            mo41479mI();
            AppMethodBeat.m2505o(91830);
        }
    }

    /* renamed from: my */
    public final C41574b mo18630my() {
        return this.aAq;
    }
}
