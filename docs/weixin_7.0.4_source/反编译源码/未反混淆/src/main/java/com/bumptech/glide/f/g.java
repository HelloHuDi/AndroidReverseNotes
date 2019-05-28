package com.bumptech.glide.f;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.c.b.j;
import com.bumptech.glide.c.b.k;
import com.bumptech.glide.c.b.p;
import com.bumptech.glide.c.b.u;
import com.bumptech.glide.f.a.d;
import com.bumptech.glide.f.a.e;
import com.bumptech.glide.h.a.a.c;
import com.bumptech.glide.h.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;

public final class g<R> implements d, b, f, c {
    private static final android.support.v4.f.k.a<g<?>> aCd = com.bumptech.glide.h.a.a.a(new com.bumptech.glide.h.a.a.a<g<?>>() {
        public final /* synthetic */ Object mG() {
            AppMethodBeat.i(92487);
            g gVar = new g();
            AppMethodBeat.o(92487);
            return gVar;
        }
    });
    private static final boolean aHx = Log.isLoggable("Request", 2);
    private com.bumptech.glide.g aAk;
    private final b aAq;
    private e<R> aHA;
    private com.bumptech.glide.f.b.c<? super R> aHB;
    private j.d aHC;
    private a aHD;
    private Drawable aHE;
    private Drawable aHm;
    private int aHo;
    private int aHp;
    private Drawable aHr;
    private boolean aHw;
    private d<R> aHy;
    private c aHz;
    private Class<R> awY;
    private e awZ;
    private j awe;
    private com.bumptech.glide.e awi;
    private Object axb;
    private d<R> axc;
    private u<R> azR;
    private Context context;
    private int height;
    private long startTime;
    private final String tag;
    private int width;

    enum a {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CANCELLED,
        CLEARED,
        PAUSED;

        static {
            AppMethodBeat.o(92490);
        }
    }

    static {
        AppMethodBeat.i(92517);
        AppMethodBeat.o(92517);
    }

    public static <R> g<R> a(Context context, com.bumptech.glide.e eVar, Object obj, Class<R> cls, e eVar2, int i, int i2, com.bumptech.glide.g gVar, e<R> eVar3, d<R> dVar, d<R> dVar2, c cVar, j jVar, com.bumptech.glide.f.b.c<? super R> cVar2) {
        AppMethodBeat.i(92491);
        g gVar2 = (g) aCd.aA();
        if (gVar2 == null) {
            gVar2 = new g();
        }
        gVar2.context = context;
        gVar2.awi = eVar;
        gVar2.axb = obj;
        gVar2.awY = cls;
        gVar2.awZ = eVar2;
        gVar2.aHp = i;
        gVar2.aHo = i2;
        gVar2.aAk = gVar;
        gVar2.aHA = eVar3;
        gVar2.aHy = dVar;
        gVar2.axc = dVar2;
        gVar2.aHz = cVar;
        gVar2.awe = jVar;
        gVar2.aHB = cVar2;
        gVar2.aHD = a.PENDING;
        AppMethodBeat.o(92491);
        return gVar2;
    }

    g() {
        String valueOf;
        AppMethodBeat.i(92492);
        if (aHx) {
            valueOf = String.valueOf(super.hashCode());
        } else {
            valueOf = null;
        }
        this.tag = valueOf;
        this.aAq = new com.bumptech.glide.h.a.b.a();
        AppMethodBeat.o(92492);
    }

    public final b my() {
        return this.aAq;
    }

    public final void recycle() {
        AppMethodBeat.i(92493);
        nW();
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
        AppMethodBeat.o(92493);
    }

    public final void begin() {
        AppMethodBeat.i(92494);
        nW();
        this.aAq.oq();
        this.startTime = com.bumptech.glide.h.e.ok();
        if (this.axb == null) {
            if (com.bumptech.glide.h.j.aW(this.aHp, this.aHo)) {
                this.width = this.aHp;
                this.height = this.aHo;
            }
            a(new p("Received null model"), nY() == null ? 5 : 3);
            AppMethodBeat.o(92494);
        } else if (this.aHD == a.RUNNING) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Cannot restart a running request");
            AppMethodBeat.o(92494);
            throw illegalArgumentException;
        } else if (this.aHD == a.COMPLETE) {
            c(this.azR, com.bumptech.glide.c.a.MEMORY_CACHE);
            AppMethodBeat.o(92494);
        } else {
            this.aHD = a.WAITING_FOR_SIZE;
            if (com.bumptech.glide.h.j.aW(this.aHp, this.aHo)) {
                aV(this.aHp, this.aHo);
            } else {
                this.aHA.a(this);
            }
            if ((this.aHD == a.RUNNING || this.aHD == a.WAITING_FOR_SIZE) && ob()) {
                nX();
            }
            if (aHx) {
                ae("finished run method in " + com.bumptech.glide.h.e.q(this.startTime));
            }
            AppMethodBeat.o(92494);
        }
    }

    private void nW() {
        AppMethodBeat.i(92495);
        if (this.aHw) {
            IllegalStateException illegalStateException = new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
            AppMethodBeat.o(92495);
            throw illegalStateException;
        }
        AppMethodBeat.o(92495);
    }

    public final void clear() {
        boolean z = true;
        AppMethodBeat.i(92496);
        com.bumptech.glide.h.j.om();
        nW();
        this.aAq.oq();
        if (this.aHD == a.CLEARED) {
            AppMethodBeat.o(92496);
            return;
        }
        nW();
        this.aAq.oq();
        this.aHD = a.CANCELLED;
        if (this.aHC != null) {
            j.d dVar = this.aHC;
            k kVar = dVar.aBD;
            f fVar = dVar.aBE;
            com.bumptech.glide.h.j.om();
            kVar.aAq.oq();
            if (kVar.aBL || kVar.aBN) {
                if (kVar.aBO == null) {
                    kVar.aBO = new ArrayList(2);
                }
                if (!kVar.aBO.contains(fVar)) {
                    kVar.aBO.add(fVar);
                }
            } else {
                kVar.aBH.remove(fVar);
                if (!(!kVar.aBH.isEmpty() || kVar.aBN || kVar.aBL || kVar.isCancelled)) {
                    kVar.isCancelled = true;
                    com.bumptech.glide.c.b.g gVar = kVar.aBQ;
                    gVar.isCancelled = true;
                    com.bumptech.glide.c.b.e eVar = gVar.aAG;
                    if (eVar != null) {
                        eVar.cancel();
                    }
                    kVar.aBz.a(kVar, kVar.azP);
                }
            }
            this.aHC = null;
        }
        if (this.azR != null) {
            f(this.azR);
        }
        if (!(this.aHz == null || this.aHz.d(this))) {
            z = false;
        }
        if (z) {
            nX();
        }
        this.aHD = a.CLEARED;
        AppMethodBeat.o(92496);
    }

    public final void pause() {
        AppMethodBeat.i(92497);
        clear();
        this.aHD = a.PAUSED;
        AppMethodBeat.o(92497);
    }

    private void f(u<?> uVar) {
        AppMethodBeat.i(92498);
        j.b(uVar);
        this.azR = null;
        AppMethodBeat.o(92498);
    }

    public final boolean isRunning() {
        return this.aHD == a.RUNNING || this.aHD == a.WAITING_FOR_SIZE;
    }

    public final boolean isComplete() {
        return this.aHD == a.COMPLETE;
    }

    public final boolean nL() {
        AppMethodBeat.i(92499);
        boolean isComplete = isComplete();
        AppMethodBeat.o(92499);
        return isComplete;
    }

    public final boolean isCancelled() {
        return this.aHD == a.CANCELLED || this.aHD == a.CLEARED;
    }

    public final boolean isFailed() {
        return this.aHD == a.FAILED;
    }

    private Drawable nX() {
        AppMethodBeat.i(92500);
        if (this.aHm == null) {
            this.aHm = this.awZ.aHm;
            if (this.aHm == null && this.awZ.aHn > 0) {
                this.aHm = dk(this.awZ.aHn);
            }
        }
        Drawable drawable = this.aHm;
        AppMethodBeat.o(92500);
        return drawable;
    }

    private Drawable nY() {
        AppMethodBeat.i(92501);
        if (this.aHr == null) {
            this.aHr = this.awZ.aHr;
            if (this.aHr == null && this.awZ.aHs > 0) {
                this.aHr = dk(this.awZ.aHs);
            }
        }
        Drawable drawable = this.aHr;
        AppMethodBeat.o(92501);
        return drawable;
    }

    private Drawable dk(int i) {
        Theme theme;
        AppMethodBeat.i(92502);
        if (this.awZ.aHt != null) {
            theme = this.awZ.aHt;
        } else {
            theme = this.context.getTheme();
        }
        Drawable a = com.bumptech.glide.c.d.c.a.a(this.awi, i, theme);
        AppMethodBeat.o(92502);
        return a;
    }

    private void nZ() {
        AppMethodBeat.i(92503);
        if (ob()) {
            Drawable drawable = null;
            if (this.axb == null) {
                drawable = nY();
            }
            if (drawable == null) {
                if (this.aHE == null) {
                    this.aHE = this.awZ.aHk;
                    if (this.aHE == null && this.awZ.aHl > 0) {
                        this.aHE = dk(this.awZ.aHl);
                    }
                }
                drawable = this.aHE;
            }
            if (drawable == null) {
                nX();
            }
            AppMethodBeat.o(92503);
            return;
        }
        AppMethodBeat.o(92503);
    }

    public final void aV(int i, int i2) {
        AppMethodBeat.i(92504);
        this.aAq.oq();
        if (aHx) {
            ae("Got onSizeReady in " + com.bumptech.glide.h.e.q(this.startTime));
        }
        if (this.aHD != a.WAITING_FOR_SIZE) {
            AppMethodBeat.o(92504);
            return;
        }
        this.aHD = a.RUNNING;
        float f = this.awZ.aHj;
        this.width = g(i, f);
        this.height = g(i2, f);
        if (aHx) {
            ae("finished setup for calling load in " + com.bumptech.glide.h.e.q(this.startTime));
        }
        this.aHC = this.awe.a(this.awi, this.axb, this.awZ.aAb, this.width, this.height, this.awZ.aAf, this.awY, this.aAk, this.awZ.aAl, this.awZ.aAh, this.awZ.aAm, this.awZ.aAn, this.awZ.aAd, this.awZ.azQ, this.awZ.aHv, this.awZ.aBK, this.awZ.aAz, this);
        if (this.aHD != a.RUNNING) {
            this.aHC = null;
        }
        if (aHx) {
            ae("finished onSizeReady in " + com.bumptech.glide.h.e.q(this.startTime));
        }
        AppMethodBeat.o(92504);
    }

    private static int g(int i, float f) {
        AppMethodBeat.i(92505);
        if (i == android.support.v4.widget.j.INVALID_ID) {
            AppMethodBeat.o(92505);
            return i;
        }
        i = Math.round(((float) i) * f);
        AppMethodBeat.o(92505);
        return i;
    }

    private boolean oa() {
        AppMethodBeat.i(92506);
        if (this.aHz == null || this.aHz.b(this)) {
            AppMethodBeat.o(92506);
            return true;
        }
        AppMethodBeat.o(92506);
        return false;
    }

    private boolean ob() {
        AppMethodBeat.i(92507);
        if (this.aHz == null || this.aHz.c(this)) {
            AppMethodBeat.o(92507);
            return true;
        }
        AppMethodBeat.o(92507);
        return false;
    }

    private boolean oc() {
        AppMethodBeat.i(92508);
        if (this.aHz == null || !this.aHz.nM()) {
            AppMethodBeat.o(92508);
            return true;
        }
        AppMethodBeat.o(92508);
        return false;
    }

    private void od() {
        AppMethodBeat.i(92509);
        if (this.aHz != null) {
            this.aHz.f(this);
        }
        AppMethodBeat.o(92509);
    }

    private void oe() {
        AppMethodBeat.i(92510);
        if (this.aHz != null) {
            this.aHz.g(this);
        }
        AppMethodBeat.o(92510);
    }

    public final void c(u<?> uVar, com.bumptech.glide.c.a aVar) {
        AppMethodBeat.i(92511);
        this.aAq.oq();
        this.aHC = null;
        if (uVar == null) {
            a(new p("Expected to receive a Resource<R> with an object of " + this.awY + " inside, but instead got null."), 5);
            AppMethodBeat.o(92511);
            return;
        }
        Object obj = uVar.get();
        if (obj == null || !this.awY.isAssignableFrom(obj.getClass())) {
            String str;
            f(uVar);
            StringBuilder append = new StringBuilder("Expected to receive an object of ").append(this.awY).append(" but instead got ").append(obj != null ? obj.getClass() : "").append("{").append(obj).append("} inside Resource{").append(uVar).append("}.");
            if (obj != null) {
                str = "";
            } else {
                str = " To indicate failure return a null Resource object, rather than a Resource object containing null data.";
            }
            a(new p(append.append(str).toString()), 5);
            AppMethodBeat.o(92511);
        } else if (oa()) {
            a(uVar, obj, aVar);
            AppMethodBeat.o(92511);
        } else {
            f(uVar);
            this.aHD = a.COMPLETE;
            AppMethodBeat.o(92511);
        }
    }

    private void a(u<R> uVar, R r, com.bumptech.glide.c.a aVar) {
        AppMethodBeat.i(92512);
        oc();
        this.aHD = a.COMPLETE;
        this.azR = uVar;
        if (this.awi.awu <= 3) {
            new StringBuilder("Finished loading ").append(r.getClass().getSimpleName()).append(" from ").append(aVar).append(" for ").append(this.axb).append(" with size [").append(this.width).append(VideoMaterialUtil.CRAZYFACE_X).append(this.height).append("] in ").append(com.bumptech.glide.h.e.q(this.startTime)).append(" ms");
        }
        this.aHw = true;
        try {
            if ((this.axc == null || !this.axc.nO()) && (this.aHy == null || !this.aHy.nO())) {
                this.aHB.oi();
                this.aHA.aa(r);
            }
            this.aHw = false;
            od();
            AppMethodBeat.o(92512);
        } catch (Throwable th) {
            this.aHw = false;
            AppMethodBeat.o(92512);
        }
    }

    public final void a(p pVar) {
        AppMethodBeat.i(139056);
        a(pVar, 5);
        AppMethodBeat.o(139056);
    }

    /* JADX WARNING: Missing block: B:10:0x005d, code skipped:
            if (r0.nN() == false) goto L_0x005f;
     */
    /* JADX WARNING: Missing block: B:14:0x006c, code skipped:
            if (r0.nN() == false) goto L_0x006e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(p pVar, int i) {
        AppMethodBeat.i(92514);
        this.aAq.oq();
        int i2 = this.awi.awu;
        if (i2 <= i) {
            new StringBuilder("Load failed for ").append(this.axb).append(" with size [").append(this.width).append(VideoMaterialUtil.CRAZYFACE_X).append(this.height).append("]");
            if (i2 <= 4) {
                pVar.mM();
            }
        }
        this.aHC = null;
        this.aHD = a.FAILED;
        this.aHw = true;
        try {
            d dVar;
            if (this.axc != null) {
                dVar = this.axc;
                oc();
            }
            if (this.aHy != null) {
                dVar = this.aHy;
                oc();
            }
            nZ();
            this.aHw = false;
            oe();
            AppMethodBeat.o(92514);
        } catch (Throwable th) {
            this.aHw = false;
            AppMethodBeat.o(92514);
        }
    }

    public final boolean a(b bVar) {
        AppMethodBeat.i(92515);
        if (bVar instanceof g) {
            g gVar = (g) bVar;
            if (this.aHp == gVar.aHp && this.aHo == gVar.aHo && com.bumptech.glide.h.j.i(this.axb, gVar.axb) && this.awY.equals(gVar.awY) && this.awZ.equals(gVar.awZ) && this.aAk == gVar.aAk && (!this.axc == null ? gVar.axc != null : gVar.axc == null)) {
                AppMethodBeat.o(92515);
                return true;
            }
            AppMethodBeat.o(92515);
            return false;
        }
        AppMethodBeat.o(92515);
        return false;
    }

    private void ae(String str) {
        AppMethodBeat.i(92516);
        new StringBuilder().append(str).append(" this: ").append(this.tag);
        AppMethodBeat.o(92516);
    }
}
