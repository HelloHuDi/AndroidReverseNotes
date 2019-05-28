package com.tencent.p177mm.plugin.shake.p506c.p507a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelgeo.C26443d;
import com.tencent.p177mm.modelgeo.C42207b.C42206a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.shake.p1019b.C28987m;
import com.tencent.p177mm.plugin.shake.p1019b.C39691l.C21826a;
import com.tencent.p177mm.plugin.shake.p1019b.C39691l.C21828b;
import com.tencent.p177mm.plugin.shake.p506c.p1411c.C28999a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.shake.c.a.g */
public final class C7084g extends C21828b implements C1202f {
    private static int qsn = 0;
    private float ecs = -85.0f;
    private float ect = -1000.0f;
    private C42206a ecy = new C70861();
    private int emC = 0;
    private C26443d fwu;
    private String hxK = "";
    public int kdC;
    private C7306ak mHandler = new C7306ak();
    private C39693c qsI;
    private C21829e qsJ = new C21829e();
    private boolean qsK = false;
    private boolean qsL = false;
    private long qso = 0;

    /* renamed from: com.tencent.mm.plugin.shake.c.a.g$2 */
    class C38232 implements Runnable {
        C38232() {
        }

        public final void run() {
            AppMethodBeat.m2504i(24529);
            C7084g.this.qsJ.kdC = 3;
            C7084g.this.kdC = C7084g.this.qsJ.kdC;
            C7084g.this.qsJ.qsu = C28987m.cjY().qsp;
            if (C7084g.this.qrT != null) {
                C7084g.this.qrT.mo25339a(1250, C7084g.this.qsJ, 2);
            }
            AppMethodBeat.m2505o(24529);
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.c.a.g$3 */
    class C70853 implements Runnable {
        C70853() {
        }

        public final void run() {
            AppMethodBeat.m2504i(24530);
            if (!C7084g.this.qsK) {
                C7084g.m11872d(C7084g.this);
            }
            AppMethodBeat.m2505o(24530);
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.c.a.g$1 */
    class C70861 implements C42206a {
        C70861() {
        }

        /* renamed from: a */
        public final boolean mo5861a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            AppMethodBeat.m2504i(24528);
            if (z) {
                if (C7084g.this.ecs == -85.0f && C7084g.this.ect == -1000.0f) {
                    C7084g.this.ecs = f2;
                    C7084g.this.ect = f;
                    C28987m.cjY().ecs = C7084g.this.ecs;
                    C28987m.cjY().ect = C7084g.this.ect;
                    if (C7084g.this.qsL) {
                        C4990ab.m7416i("MicroMsg.ShakeCardService", "ShakeCardService do netscen from onGetLocation()");
                        C7084g.m11872d(C7084g.this);
                    }
                }
                AppMethodBeat.m2505o(24528);
                return false;
            }
            AppMethodBeat.m2505o(24528);
            return true;
        }
    }

    /* renamed from: d */
    static /* synthetic */ void m11872d(C7084g c7084g) {
        AppMethodBeat.m2504i(24545);
        c7084g.ckc();
        AppMethodBeat.m2505o(24545);
    }

    public C7084g(C21826a c21826a) {
        super(c21826a);
        AppMethodBeat.m2504i(24531);
        AppMethodBeat.m2505o(24531);
    }

    public final void setFromScene(int i) {
        AppMethodBeat.m2504i(24532);
        this.emC = i;
        C4990ab.m7416i("MicroMsg.ShakeCardService", "ShakeCardService from_scene:".concat(String.valueOf(i)));
        AppMethodBeat.m2505o(24532);
    }

    /* renamed from: Ix */
    public final void mo15427Ix(String str) {
        AppMethodBeat.m2504i(24533);
        if (str == null || str.length() > 256) {
            C4990ab.m7416i("MicroMsg.ShakeCardService", "ShakeCardService ext_info size > 256 byte, extinfo:".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(24533);
            return;
        }
        C4990ab.m7416i("MicroMsg.ShakeCardService", "ShakeCardService mExtInfo:" + this.hxK);
        this.hxK = str;
        AppMethodBeat.m2505o(24533);
    }

    public final void init() {
        AppMethodBeat.m2504i(24534);
        qsn = C28987m.cjY().qsn;
        this.qso = C28987m.cjY().qso;
        this.ecs = C28987m.cjY().ecs;
        this.ect = C28987m.cjY().ect;
        C9638aw.m17182Rg().mo14539a(1250, (C1202f) this);
        cjv();
        AppMethodBeat.m2505o(24534);
    }

    public final void reset() {
        AppMethodBeat.m2504i(24535);
        if (this.qsI != null) {
            C9638aw.m17182Rg().mo14547c(this.qsI);
        }
        AppMethodBeat.m2505o(24535);
    }

    public final void start() {
        Object obj;
        AppMethodBeat.m2504i(24536);
        init();
        reset();
        if (this.fwu == null) {
            cjv();
        }
        this.fwu.mo44207b(this.ecy, true);
        C46197d cjY = C28987m.cjY();
        String str = "key_shake_card_item";
        if (TextUtils.isEmpty(str) || !cjY.kaV.containsKey(str)) {
            obj = null;
        } else {
            obj = cjY.kaV.get(str);
        }
        long currentTimeMillis = (System.currentTimeMillis() / 1000) - this.qso;
        if (obj == null || !(obj instanceof C21829e)) {
            boolean z;
            if (this.qso == 0) {
                z = true;
            } else if (currentTimeMillis >= 0) {
                z = true;
            } else {
                C7060h.pYm.mo8381e(11666, Integer.valueOf(this.emC));
                this.mHandler.postDelayed(new C38232(), 3000);
                C4990ab.m7416i("MicroMsg.ShakeCardService", "ShakeCardService do not doNetSceneShakeCard, because time is not expire");
                z = false;
            }
            if (z) {
                if (this.qsK) {
                    C4990ab.m7416i("MicroMsg.ShakeCardService", "ShakeCardService is doing netscene, return");
                    AppMethodBeat.m2505o(24536);
                    return;
                } else if (this.ecs == -85.0f || this.ect == -1000.0f) {
                    this.qsL = true;
                    C4990ab.m7416i("MicroMsg.ShakeCardService", "ShakeCardService location is not geted, wait 4 second");
                    this.mHandler.postDelayed(new C70853(), 4000);
                    AppMethodBeat.m2505o(24536);
                    return;
                } else {
                    ckc();
                }
            }
            AppMethodBeat.m2505o(24536);
            return;
        }
        this.qrT.mo25339a(1250, (C21829e) obj, 1);
        C28987m.cjY().putValue("key_shake_card_item", null);
        C4990ab.m7416i("MicroMsg.ShakeCardService", "getlbscard return data is no empty, don't do doNetSceneShakeCard, return ok");
        AppMethodBeat.m2505o(24536);
    }

    private void ckc() {
        AppMethodBeat.m2504i(24537);
        if (this.qsK) {
            C4990ab.m7416i("MicroMsg.ShakeCardService", "ShakeCardService is doing doNetSceneShakeCard, return");
            AppMethodBeat.m2505o(24537);
            return;
        }
        this.qsK = true;
        this.qsL = false;
        C4990ab.m7416i("MicroMsg.ShakeCardService", "ShakeCardService do doNetSceneShakeCard");
        this.qsI = new C39693c(this.ect, this.ecs, this.emC, this.hxK);
        C9638aw.m17182Rg().mo14541a(this.qsI, 0);
        AppMethodBeat.m2505o(24537);
    }

    public final void pause() {
        AppMethodBeat.m2504i(24538);
        aZv();
        AppMethodBeat.m2505o(24538);
    }

    public final void cjw() {
        AppMethodBeat.m2504i(24540);
        C9638aw.m17182Rg().mo14546b(1250, (C1202f) this);
        aZv();
        super.cjw();
        AppMethodBeat.m2505o(24540);
    }

    private void cjv() {
        AppMethodBeat.m2504i(24541);
        this.fwu = C26443d.agz();
        this.fwu.mo44204a(this.ecy, true);
        AppMethodBeat.m2505o(24541);
    }

    private void aZv() {
        AppMethodBeat.m2504i(24542);
        if (this.fwu != null) {
            this.fwu.mo44208c(this.ecy);
        }
        AppMethodBeat.m2505o(24542);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(24543);
        if (c1207m instanceof C39693c) {
            C39693c c39693c = (C39693c) c1207m;
            C21829e c21829e = this.qsJ;
            C21829e c21829e2 = c39693c.qsm;
            c21829e.kdC = c21829e2.kdC;
            c21829e.kbU = c21829e2.kbU;
            c21829e.cMD = c21829e2.cMD;
            c21829e.title = c21829e2.title;
            c21829e.kbW = c21829e2.kbW;
            c21829e.kbX = c21829e2.kbX;
            c21829e.kdg = c21829e2.kdg;
            c21829e.kbV = c21829e2.kbV;
            c21829e.color = c21829e2.color;
            c21829e.qsn = c21829e2.qsn;
            c21829e.qsq = c21829e2.qsq;
            c21829e.qsr = c21829e2.qsr;
            c21829e.qss = c21829e2.qss;
            c21829e.qst = c21829e2.qst;
            c21829e.qsu = c21829e2.qsu;
            c21829e.kbZ = c21829e2.kbZ;
            c21829e.qsv = c21829e2.qsv;
            c21829e.qsw = c21829e2.qsw;
            this.kdC = this.qsJ.kdC;
            C4990ab.m7416i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd()  action_type:" + this.kdC + "  frequency_level:" + qsn + " control_flag:" + this.qsJ.qsq);
            if (i == 0 && i2 == 0) {
                qsn = this.qsJ.qsn;
                C4990ab.m7416i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd is OK ");
                if (this.qrT != null) {
                    this.qrT.mo25339a(1250, this.qsJ, 1);
                }
                ckd();
            } else if (!(i == 5 && i2 == -1) && (i != 4 || i2 == 0)) {
                C4990ab.m7416i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd errType is " + i + " errCode is " + i2);
                if (this.qrT != null) {
                    this.qrT.mo25339a(1250, this.qsJ, 2);
                }
                ckd();
            } else {
                C4990ab.m7416i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd errType is " + i + " errCode is " + i2);
                if (this.qrT != null) {
                    this.qrT.mo25339a(1250, this.qsJ, 2);
                }
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                long Cy = (long) C28999a.m46035Cy(C28999a.ckr());
                C4990ab.m7416i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd wait nextInterval is ".concat(String.valueOf(Cy)));
                this.qso = currentTimeMillis + Cy;
            }
            C28987m.cjY().qsn = qsn;
            C28987m.cjY().qso = this.qso;
            this.qsK = false;
        }
        AppMethodBeat.m2505o(24543);
    }

    private void ckd() {
        long Cx;
        AppMethodBeat.m2504i(24544);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (C28999a.m46033Cw(qsn)) {
            C4990ab.m7416i("MicroMsg.ShakeCardService", "ShakeCardService frequency_level is valid");
            Cx = (long) C28999a.m46034Cx(qsn);
        } else {
            C4990ab.m7416i("MicroMsg.ShakeCardService", "ShakeCardService frequency_level is not valid");
            Cx = (long) C28999a.m46035Cy(C28999a.ckr());
        }
        C4990ab.m7416i("MicroMsg.ShakeCardService", "ShakeCardService updateWaitingTime wait nextInterval is ".concat(String.valueOf(Cx)));
        this.qso = Cx + currentTimeMillis;
        AppMethodBeat.m2505o(24544);
    }

    public final void resume() {
        AppMethodBeat.m2504i(24539);
        if (this.fwu != null) {
            this.fwu.mo44204a(this.ecy, true);
        }
        AppMethodBeat.m2505o(24539);
    }
}
