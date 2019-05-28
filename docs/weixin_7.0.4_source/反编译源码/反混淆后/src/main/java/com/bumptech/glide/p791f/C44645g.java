package com.bumptech.glide.p791f;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.support.p057v4.p065f.C37122k.C8387a;
import android.support.p057v4.widget.C8415j;
import android.util.Log;
import com.bumptech.glide.C37191e;
import com.bumptech.glide.C37192g;
import com.bumptech.glide.p086c.C25405a;
import com.bumptech.glide.p086c.p088b.C0753e;
import com.bumptech.glide.p086c.p088b.C17526u;
import com.bumptech.glide.p086c.p088b.C24644k;
import com.bumptech.glide.p086c.p088b.C31941j;
import com.bumptech.glide.p086c.p088b.C31941j.C0759d;
import com.bumptech.glide.p086c.p088b.C36671g;
import com.bumptech.glide.p086c.p088b.C37169p;
import com.bumptech.glide.p086c.p092d.p787c.C8550a;
import com.bumptech.glide.p095h.C31975e;
import com.bumptech.glide.p095h.C45002j;
import com.bumptech.glide.p095h.p1136a.C37193a;
import com.bumptech.glide.p095h.p1136a.C37193a.C31972c;
import com.bumptech.glide.p095h.p1136a.C37193a.C37194a;
import com.bumptech.glide.p095h.p1136a.C41574b;
import com.bumptech.glide.p095h.p1136a.C41574b.C17561a;
import com.bumptech.glide.p791f.p1156a.C17551e;
import com.bumptech.glide.p791f.p1156a.C25457d;
import com.bumptech.glide.p791f.p792b.C25459c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;

/* renamed from: com.bumptech.glide.f.g */
public final class C44645g<R> implements C25457d, C17553b, C41571f, C31972c {
    private static final C8387a<C44645g<?>> aCd = C37193a.m62344a(new C175541());
    private static final boolean aHx = Log.isLoggable("Request", 2);
    private C37192g aAk;
    private final C41574b aAq;
    private C17551e<R> aHA;
    private C25459c<? super R> aHB;
    private C0759d aHC;
    private C31971a aHD;
    private Drawable aHE;
    private Drawable aHm;
    private int aHo;
    private int aHp;
    private Drawable aHr;
    private boolean aHw;
    private C8559d<R> aHy;
    private C25460c aHz;
    private Class<R> awY;
    private C41570e awZ;
    private C31941j awe;
    private C37191e awi;
    private Object axb;
    private C8559d<R> axc;
    private C17526u<R> azR;
    private Context context;
    private int height;
    private long startTime;
    private final String tag;
    private int width;

    /* renamed from: com.bumptech.glide.f.g$1 */
    class C175541 implements C37194a<C44645g<?>> {
        C175541() {
        }

        /* renamed from: mG */
        public final /* synthetic */ Object mo18632mG() {
            AppMethodBeat.m2504i(92487);
            C44645g c44645g = new C44645g();
            AppMethodBeat.m2505o(92487);
            return c44645g;
        }
    }

    /* renamed from: com.bumptech.glide.f.g$a */
    enum C31971a {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CANCELLED,
        CLEARED,
        PAUSED;

        static {
            AppMethodBeat.m2505o(92490);
        }
    }

    static {
        AppMethodBeat.m2504i(92517);
        AppMethodBeat.m2505o(92517);
    }

    /* renamed from: a */
    public static <R> C44645g<R> m81156a(Context context, C37191e c37191e, Object obj, Class<R> cls, C41570e c41570e, int i, int i2, C37192g c37192g, C17551e<R> c17551e, C8559d<R> c8559d, C8559d<R> c8559d2, C25460c c25460c, C31941j c31941j, C25459c<? super R> c25459c) {
        AppMethodBeat.m2504i(92491);
        C44645g c44645g = (C44645g) aCd.mo6364aA();
        if (c44645g == null) {
            c44645g = new C44645g();
        }
        c44645g.context = context;
        c44645g.awi = c37191e;
        c44645g.axb = obj;
        c44645g.awY = cls;
        c44645g.awZ = c41570e;
        c44645g.aHp = i;
        c44645g.aHo = i2;
        c44645g.aAk = c37192g;
        c44645g.aHA = c17551e;
        c44645g.aHy = c8559d;
        c44645g.axc = c8559d2;
        c44645g.aHz = c25460c;
        c44645g.awe = c31941j;
        c44645g.aHB = c25459c;
        c44645g.aHD = C31971a.PENDING;
        AppMethodBeat.m2505o(92491);
        return c44645g;
    }

    C44645g() {
        String valueOf;
        AppMethodBeat.m2504i(92492);
        if (aHx) {
            valueOf = String.valueOf(super.hashCode());
        } else {
            valueOf = null;
        }
        this.tag = valueOf;
        this.aAq = new C17561a();
        AppMethodBeat.m2505o(92492);
    }

    /* renamed from: my */
    public final C41574b mo18630my() {
        return this.aAq;
    }

    public final void recycle() {
        AppMethodBeat.m2504i(92493);
        m81163nW();
        this.context = null;
        this.awi = null;
        this.axb = null;
        this.awY = null;
        this.awZ = null;
        this.aHp = -1;
        this.aHo = -1;
        this.aHA = null;
        this.axc = null;
        this.aHy = null;
        this.aHz = null;
        this.aHB = null;
        this.aHC = null;
        this.aHE = null;
        this.aHm = null;
        this.aHr = null;
        this.width = -1;
        this.height = -1;
        aCd.release(this);
        AppMethodBeat.m2505o(92493);
    }

    public final void begin() {
        AppMethodBeat.m2504i(92494);
        m81163nW();
        this.aAq.mo31993oq();
        this.startTime = C31975e.m51954ok();
        if (this.axb == null) {
            if (C45002j.m82415aW(this.aHp, this.aHo)) {
                this.width = this.aHp;
                this.height = this.aHo;
            }
            m81157a(new C37169p("Received null model"), m81165nY() == null ? 5 : 3);
            AppMethodBeat.m2505o(92494);
        } else if (this.aHD == C31971a.RUNNING) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Cannot restart a running request");
            AppMethodBeat.m2505o(92494);
            throw illegalArgumentException;
        } else if (this.aHD == C31971a.COMPLETE) {
            mo66598c(this.azR, C25405a.MEMORY_CACHE);
            AppMethodBeat.m2505o(92494);
        } else {
            this.aHD = C31971a.WAITING_FOR_SIZE;
            if (C45002j.m82415aW(this.aHp, this.aHo)) {
                mo42496aV(this.aHp, this.aHo);
            } else {
                this.aHA.mo31976a(this);
            }
            if ((this.aHD == C31971a.RUNNING || this.aHD == C31971a.WAITING_FOR_SIZE) && m81168ob()) {
                m81164nX();
            }
            if (aHx) {
                m81159ae("finished run method in " + C31975e.m51955q(this.startTime));
            }
            AppMethodBeat.m2505o(92494);
        }
    }

    /* renamed from: nW */
    private void m81163nW() {
        AppMethodBeat.m2504i(92495);
        if (this.aHw) {
            IllegalStateException illegalStateException = new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
            AppMethodBeat.m2505o(92495);
            throw illegalStateException;
        }
        AppMethodBeat.m2505o(92495);
    }

    public final void clear() {
        boolean z = true;
        AppMethodBeat.m2504i(92496);
        C45002j.m82426om();
        m81163nW();
        this.aAq.mo31993oq();
        if (this.aHD == C31971a.CLEARED) {
            AppMethodBeat.m2505o(92496);
            return;
        }
        m81163nW();
        this.aAq.mo31993oq();
        this.aHD = C31971a.CANCELLED;
        if (this.aHC != null) {
            C0759d c0759d = this.aHC;
            C24644k c24644k = c0759d.aBD;
            C41571f c41571f = c0759d.aBE;
            C45002j.m82426om();
            c24644k.aAq.mo31993oq();
            if (c24644k.aBL || c24644k.aBN) {
                if (c24644k.aBO == null) {
                    c24644k.aBO = new ArrayList(2);
                }
                if (!c24644k.aBO.contains(c41571f)) {
                    c24644k.aBO.add(c41571f);
                }
            } else {
                c24644k.aBH.remove(c41571f);
                if (!(!c24644k.aBH.isEmpty() || c24644k.aBN || c24644k.aBL || c24644k.isCancelled)) {
                    c24644k.isCancelled = true;
                    C36671g c36671g = c24644k.aBQ;
                    c36671g.isCancelled = true;
                    C0753e c0753e = c36671g.aAG;
                    if (c0753e != null) {
                        c0753e.cancel();
                    }
                    c24644k.aBz.mo42465a(c24644k, c24644k.azP);
                }
            }
            this.aHC = null;
        }
        if (this.azR != null) {
            m81161f(this.azR);
        }
        if (!(this.aHz == null || this.aHz.mo42499d(this))) {
            z = false;
        }
        if (z) {
            m81164nX();
        }
        this.aHD = C31971a.CLEARED;
        AppMethodBeat.m2505o(92496);
    }

    public final void pause() {
        AppMethodBeat.m2504i(92497);
        clear();
        this.aHD = C31971a.PAUSED;
        AppMethodBeat.m2505o(92497);
    }

    /* renamed from: f */
    private void m81161f(C17526u<?> c17526u) {
        AppMethodBeat.m2504i(92498);
        C31941j.m51892b(c17526u);
        this.azR = null;
        AppMethodBeat.m2505o(92498);
    }

    public final boolean isRunning() {
        return this.aHD == C31971a.RUNNING || this.aHD == C31971a.WAITING_FOR_SIZE;
    }

    public final boolean isComplete() {
        return this.aHD == C31971a.COMPLETE;
    }

    /* renamed from: nL */
    public final boolean mo31987nL() {
        AppMethodBeat.m2504i(92499);
        boolean isComplete = isComplete();
        AppMethodBeat.m2505o(92499);
        return isComplete;
    }

    public final boolean isCancelled() {
        return this.aHD == C31971a.CANCELLED || this.aHD == C31971a.CLEARED;
    }

    public final boolean isFailed() {
        return this.aHD == C31971a.FAILED;
    }

    /* renamed from: nX */
    private Drawable m81164nX() {
        AppMethodBeat.m2504i(92500);
        if (this.aHm == null) {
            this.aHm = this.awZ.aHm;
            if (this.aHm == null && this.awZ.aHn > 0) {
                this.aHm = m81160dk(this.awZ.aHn);
            }
        }
        Drawable drawable = this.aHm;
        AppMethodBeat.m2505o(92500);
        return drawable;
    }

    /* renamed from: nY */
    private Drawable m81165nY() {
        AppMethodBeat.m2504i(92501);
        if (this.aHr == null) {
            this.aHr = this.awZ.aHr;
            if (this.aHr == null && this.awZ.aHs > 0) {
                this.aHr = m81160dk(this.awZ.aHs);
            }
        }
        Drawable drawable = this.aHr;
        AppMethodBeat.m2505o(92501);
        return drawable;
    }

    /* renamed from: dk */
    private Drawable m81160dk(int i) {
        Theme theme;
        AppMethodBeat.m2504i(92502);
        if (this.awZ.aHt != null) {
            theme = this.awZ.aHt;
        } else {
            theme = this.context.getTheme();
        }
        Drawable a = C8550a.m15195a(this.awi, i, theme);
        AppMethodBeat.m2505o(92502);
        return a;
    }

    /* renamed from: nZ */
    private void m81166nZ() {
        AppMethodBeat.m2504i(92503);
        if (m81168ob()) {
            Drawable drawable = null;
            if (this.axb == null) {
                drawable = m81165nY();
            }
            if (drawable == null) {
                if (this.aHE == null) {
                    this.aHE = this.awZ.aHk;
                    if (this.aHE == null && this.awZ.aHl > 0) {
                        this.aHE = m81160dk(this.awZ.aHl);
                    }
                }
                drawable = this.aHE;
            }
            if (drawable == null) {
                m81164nX();
            }
            AppMethodBeat.m2505o(92503);
            return;
        }
        AppMethodBeat.m2505o(92503);
    }

    /* renamed from: aV */
    public final void mo42496aV(int i, int i2) {
        AppMethodBeat.m2504i(92504);
        this.aAq.mo31993oq();
        if (aHx) {
            m81159ae("Got onSizeReady in " + C31975e.m51955q(this.startTime));
        }
        if (this.aHD != C31971a.WAITING_FOR_SIZE) {
            AppMethodBeat.m2505o(92504);
            return;
        }
        this.aHD = C31971a.RUNNING;
        float f = this.awZ.aHj;
        this.width = C44645g.m81162g(i, f);
        this.height = C44645g.m81162g(i2, f);
        if (aHx) {
            m81159ae("finished setup for calling load in " + C31975e.m51955q(this.startTime));
        }
        this.aHC = this.awe.mo52054a(this.awi, this.axb, this.awZ.aAb, this.width, this.height, this.awZ.aAf, this.awY, this.aAk, this.awZ.aAl, this.awZ.aAh, this.awZ.aAm, this.awZ.aAn, this.awZ.aAd, this.awZ.azQ, this.awZ.aHv, this.awZ.aBK, this.awZ.aAz, this);
        if (this.aHD != C31971a.RUNNING) {
            this.aHC = null;
        }
        if (aHx) {
            m81159ae("finished onSizeReady in " + C31975e.m51955q(this.startTime));
        }
        AppMethodBeat.m2505o(92504);
    }

    /* renamed from: g */
    private static int m81162g(int i, float f) {
        AppMethodBeat.m2504i(92505);
        if (i == C8415j.INVALID_ID) {
            AppMethodBeat.m2505o(92505);
            return i;
        }
        i = Math.round(((float) i) * f);
        AppMethodBeat.m2505o(92505);
        return i;
    }

    /* renamed from: oa */
    private boolean m81167oa() {
        AppMethodBeat.m2504i(92506);
        if (this.aHz == null || this.aHz.mo42497b(this)) {
            AppMethodBeat.m2505o(92506);
            return true;
        }
        AppMethodBeat.m2505o(92506);
        return false;
    }

    /* renamed from: ob */
    private boolean m81168ob() {
        AppMethodBeat.m2504i(92507);
        if (this.aHz == null || this.aHz.mo42498c(this)) {
            AppMethodBeat.m2505o(92507);
            return true;
        }
        AppMethodBeat.m2505o(92507);
        return false;
    }

    /* renamed from: oc */
    private boolean m81169oc() {
        AppMethodBeat.m2504i(92508);
        if (this.aHz == null || !this.aHz.mo42502nM()) {
            AppMethodBeat.m2505o(92508);
            return true;
        }
        AppMethodBeat.m2505o(92508);
        return false;
    }

    /* renamed from: od */
    private void m81170od() {
        AppMethodBeat.m2504i(92509);
        if (this.aHz != null) {
            this.aHz.mo42500f(this);
        }
        AppMethodBeat.m2505o(92509);
    }

    /* renamed from: oe */
    private void m81171oe() {
        AppMethodBeat.m2504i(92510);
        if (this.aHz != null) {
            this.aHz.mo42501g(this);
        }
        AppMethodBeat.m2505o(92510);
    }

    /* renamed from: c */
    public final void mo66598c(C17526u<?> c17526u, C25405a c25405a) {
        AppMethodBeat.m2504i(92511);
        this.aAq.mo31993oq();
        this.aHC = null;
        if (c17526u == null) {
            m81157a(new C37169p("Expected to receive a Resource<R> with an object of " + this.awY + " inside, but instead got null."), 5);
            AppMethodBeat.m2505o(92511);
            return;
        }
        Object obj = c17526u.get();
        if (obj == null || !this.awY.isAssignableFrom(obj.getClass())) {
            String str;
            m81161f(c17526u);
            StringBuilder append = new StringBuilder("Expected to receive an object of ").append(this.awY).append(" but instead got ").append(obj != null ? obj.getClass() : "").append("{").append(obj).append("} inside Resource{").append(c17526u).append("}.");
            if (obj != null) {
                str = "";
            } else {
                str = " To indicate failure return a null Resource object, rather than a Resource object containing null data.";
            }
            m81157a(new C37169p(append.append(str).toString()), 5);
            AppMethodBeat.m2505o(92511);
        } else if (m81167oa()) {
            m81158a(c17526u, obj, c25405a);
            AppMethodBeat.m2505o(92511);
        } else {
            m81161f(c17526u);
            this.aHD = C31971a.COMPLETE;
            AppMethodBeat.m2505o(92511);
        }
    }

    /* renamed from: a */
    private void m81158a(C17526u<R> c17526u, R r, C25405a c25405a) {
        AppMethodBeat.m2504i(92512);
        m81169oc();
        this.aHD = C31971a.COMPLETE;
        this.azR = c17526u;
        if (this.awi.awu <= 3) {
            new StringBuilder("Finished loading ").append(r.getClass().getSimpleName()).append(" from ").append(c25405a).append(" for ").append(this.axb).append(" with size [").append(this.width).append(VideoMaterialUtil.CRAZYFACE_X).append(this.height).append("] in ").append(C31975e.m51955q(this.startTime)).append(" ms");
        }
        this.aHw = true;
        try {
            if ((this.axc == null || !this.axc.mo18662nO()) && (this.aHy == null || !this.aHy.mo18662nO())) {
                this.aHB.mo31979oi();
                this.aHA.mo18652aa(r);
            }
            this.aHw = false;
            m81170od();
            AppMethodBeat.m2505o(92512);
        } catch (Throwable th) {
            this.aHw = false;
            AppMethodBeat.m2505o(92512);
        }
    }

    /* renamed from: a */
    public final void mo66597a(C37169p c37169p) {
        AppMethodBeat.m2504i(139056);
        m81157a(c37169p, 5);
        AppMethodBeat.m2505o(139056);
    }

    /* JADX WARNING: Missing block: B:10:0x005d, code skipped:
            if (r0.mo18661nN() == false) goto L_0x005f;
     */
    /* JADX WARNING: Missing block: B:14:0x006c, code skipped:
            if (r0.mo18661nN() == false) goto L_0x006e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private void m81157a(C37169p c37169p, int i) {
        AppMethodBeat.m2504i(92514);
        this.aAq.mo31993oq();
        int i2 = this.awi.awu;
        if (i2 <= i) {
            new StringBuilder("Load failed for ").append(this.axb).append(" with size [").append(this.width).append(VideoMaterialUtil.CRAZYFACE_X).append(this.height).append("]");
            if (i2 <= 4) {
                c37169p.mo59255mM();
            }
        }
        this.aHC = null;
        this.aHD = C31971a.FAILED;
        this.aHw = true;
        try {
            C8559d c8559d;
            if (this.axc != null) {
                c8559d = this.axc;
                m81169oc();
            }
            if (this.aHy != null) {
                c8559d = this.aHy;
                m81169oc();
            }
            m81166nZ();
            this.aHw = false;
            m81171oe();
            AppMethodBeat.m2505o(92514);
        } catch (Throwable th) {
            this.aHw = false;
            AppMethodBeat.m2505o(92514);
        }
    }

    /* renamed from: a */
    public final boolean mo31980a(C17553b c17553b) {
        AppMethodBeat.m2504i(92515);
        if (c17553b instanceof C44645g) {
            C44645g c44645g = (C44645g) c17553b;
            if (this.aHp == c44645g.aHp && this.aHo == c44645g.aHo && C45002j.m82423i(this.axb, c44645g.axb) && this.awY.equals(c44645g.awY) && this.awZ.equals(c44645g.awZ) && this.aAk == c44645g.aAk && (!this.axc == null ? c44645g.axc != null : c44645g.axc == null)) {
                AppMethodBeat.m2505o(92515);
                return true;
            }
            AppMethodBeat.m2505o(92515);
            return false;
        }
        AppMethodBeat.m2505o(92515);
        return false;
    }

    /* renamed from: ae */
    private void m81159ae(String str) {
        AppMethodBeat.m2504i(92516);
        new StringBuilder().append(str).append(" this: ").append(this.tag);
        AppMethodBeat.m2505o(92516);
    }
}
