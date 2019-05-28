package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.b.l;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

public final class g extends b implements f {
    private static int qsn = 0;
    private float ecs = -85.0f;
    private float ect = -1000.0f;
    private a ecy = new a() {
        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            AppMethodBeat.i(24528);
            if (z) {
                if (g.this.ecs == -85.0f && g.this.ect == -1000.0f) {
                    g.this.ecs = f2;
                    g.this.ect = f;
                    m.cjY().ecs = g.this.ecs;
                    m.cjY().ect = g.this.ect;
                    if (g.this.qsL) {
                        ab.i("MicroMsg.ShakeCardService", "ShakeCardService do netscen from onGetLocation()");
                        g.d(g.this);
                    }
                }
                AppMethodBeat.o(24528);
                return false;
            }
            AppMethodBeat.o(24528);
            return true;
        }
    };
    private int emC = 0;
    private d fwu;
    private String hxK = "";
    public int kdC;
    private ak mHandler = new ak();
    private c qsI;
    private e qsJ = new e();
    private boolean qsK = false;
    private boolean qsL = false;
    private long qso = 0;

    static /* synthetic */ void d(g gVar) {
        AppMethodBeat.i(24545);
        gVar.ckc();
        AppMethodBeat.o(24545);
    }

    public g(l.a aVar) {
        super(aVar);
        AppMethodBeat.i(24531);
        AppMethodBeat.o(24531);
    }

    public final void setFromScene(int i) {
        AppMethodBeat.i(24532);
        this.emC = i;
        ab.i("MicroMsg.ShakeCardService", "ShakeCardService from_scene:".concat(String.valueOf(i)));
        AppMethodBeat.o(24532);
    }

    public final void Ix(String str) {
        AppMethodBeat.i(24533);
        if (str == null || str.length() > 256) {
            ab.i("MicroMsg.ShakeCardService", "ShakeCardService ext_info size > 256 byte, extinfo:".concat(String.valueOf(str)));
            AppMethodBeat.o(24533);
            return;
        }
        ab.i("MicroMsg.ShakeCardService", "ShakeCardService mExtInfo:" + this.hxK);
        this.hxK = str;
        AppMethodBeat.o(24533);
    }

    public final void init() {
        AppMethodBeat.i(24534);
        qsn = m.cjY().qsn;
        this.qso = m.cjY().qso;
        this.ecs = m.cjY().ecs;
        this.ect = m.cjY().ect;
        aw.Rg().a(1250, (f) this);
        cjv();
        AppMethodBeat.o(24534);
    }

    public final void reset() {
        AppMethodBeat.i(24535);
        if (this.qsI != null) {
            aw.Rg().c(this.qsI);
        }
        AppMethodBeat.o(24535);
    }

    public final void start() {
        Object obj;
        AppMethodBeat.i(24536);
        init();
        reset();
        if (this.fwu == null) {
            cjv();
        }
        this.fwu.b(this.ecy, true);
        d cjY = m.cjY();
        String str = "key_shake_card_item";
        if (TextUtils.isEmpty(str) || !cjY.kaV.containsKey(str)) {
            obj = null;
        } else {
            obj = cjY.kaV.get(str);
        }
        long currentTimeMillis = (System.currentTimeMillis() / 1000) - this.qso;
        if (obj == null || !(obj instanceof e)) {
            boolean z;
            if (this.qso == 0) {
                z = true;
            } else if (currentTimeMillis >= 0) {
                z = true;
            } else {
                h.pYm.e(11666, Integer.valueOf(this.emC));
                this.mHandler.postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(24529);
                        g.this.qsJ.kdC = 3;
                        g.this.kdC = g.this.qsJ.kdC;
                        g.this.qsJ.qsu = m.cjY().qsp;
                        if (g.this.qrT != null) {
                            g.this.qrT.a(1250, g.this.qsJ, 2);
                        }
                        AppMethodBeat.o(24529);
                    }
                }, 3000);
                ab.i("MicroMsg.ShakeCardService", "ShakeCardService do not doNetSceneShakeCard, because time is not expire");
                z = false;
            }
            if (z) {
                if (this.qsK) {
                    ab.i("MicroMsg.ShakeCardService", "ShakeCardService is doing netscene, return");
                    AppMethodBeat.o(24536);
                    return;
                } else if (this.ecs == -85.0f || this.ect == -1000.0f) {
                    this.qsL = true;
                    ab.i("MicroMsg.ShakeCardService", "ShakeCardService location is not geted, wait 4 second");
                    this.mHandler.postDelayed(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(24530);
                            if (!g.this.qsK) {
                                g.d(g.this);
                            }
                            AppMethodBeat.o(24530);
                        }
                    }, 4000);
                    AppMethodBeat.o(24536);
                    return;
                } else {
                    ckc();
                }
            }
            AppMethodBeat.o(24536);
            return;
        }
        this.qrT.a(1250, (e) obj, 1);
        m.cjY().putValue("key_shake_card_item", null);
        ab.i("MicroMsg.ShakeCardService", "getlbscard return data is no empty, don't do doNetSceneShakeCard, return ok");
        AppMethodBeat.o(24536);
    }

    private void ckc() {
        AppMethodBeat.i(24537);
        if (this.qsK) {
            ab.i("MicroMsg.ShakeCardService", "ShakeCardService is doing doNetSceneShakeCard, return");
            AppMethodBeat.o(24537);
            return;
        }
        this.qsK = true;
        this.qsL = false;
        ab.i("MicroMsg.ShakeCardService", "ShakeCardService do doNetSceneShakeCard");
        this.qsI = new c(this.ect, this.ecs, this.emC, this.hxK);
        aw.Rg().a(this.qsI, 0);
        AppMethodBeat.o(24537);
    }

    public final void pause() {
        AppMethodBeat.i(24538);
        aZv();
        AppMethodBeat.o(24538);
    }

    public final void cjw() {
        AppMethodBeat.i(24540);
        aw.Rg().b(1250, (f) this);
        aZv();
        super.cjw();
        AppMethodBeat.o(24540);
    }

    private void cjv() {
        AppMethodBeat.i(24541);
        this.fwu = d.agz();
        this.fwu.a(this.ecy, true);
        AppMethodBeat.o(24541);
    }

    private void aZv() {
        AppMethodBeat.i(24542);
        if (this.fwu != null) {
            this.fwu.c(this.ecy);
        }
        AppMethodBeat.o(24542);
    }

    public final void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(24543);
        if (mVar instanceof c) {
            c cVar = (c) mVar;
            e eVar = this.qsJ;
            e eVar2 = cVar.qsm;
            eVar.kdC = eVar2.kdC;
            eVar.kbU = eVar2.kbU;
            eVar.cMD = eVar2.cMD;
            eVar.title = eVar2.title;
            eVar.kbW = eVar2.kbW;
            eVar.kbX = eVar2.kbX;
            eVar.kdg = eVar2.kdg;
            eVar.kbV = eVar2.kbV;
            eVar.color = eVar2.color;
            eVar.qsn = eVar2.qsn;
            eVar.qsq = eVar2.qsq;
            eVar.qsr = eVar2.qsr;
            eVar.qss = eVar2.qss;
            eVar.qst = eVar2.qst;
            eVar.qsu = eVar2.qsu;
            eVar.kbZ = eVar2.kbZ;
            eVar.qsv = eVar2.qsv;
            eVar.qsw = eVar2.qsw;
            this.kdC = this.qsJ.kdC;
            ab.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd()  action_type:" + this.kdC + "  frequency_level:" + qsn + " control_flag:" + this.qsJ.qsq);
            if (i == 0 && i2 == 0) {
                qsn = this.qsJ.qsn;
                ab.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd is OK ");
                if (this.qrT != null) {
                    this.qrT.a(1250, this.qsJ, 1);
                }
                ckd();
            } else if (!(i == 5 && i2 == -1) && (i != 4 || i2 == 0)) {
                ab.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd errType is " + i + " errCode is " + i2);
                if (this.qrT != null) {
                    this.qrT.a(1250, this.qsJ, 2);
                }
                ckd();
            } else {
                ab.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd errType is " + i + " errCode is " + i2);
                if (this.qrT != null) {
                    this.qrT.a(1250, this.qsJ, 2);
                }
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                long Cy = (long) com.tencent.mm.plugin.shake.c.c.a.Cy(com.tencent.mm.plugin.shake.c.c.a.ckr());
                ab.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd wait nextInterval is ".concat(String.valueOf(Cy)));
                this.qso = currentTimeMillis + Cy;
            }
            m.cjY().qsn = qsn;
            m.cjY().qso = this.qso;
            this.qsK = false;
        }
        AppMethodBeat.o(24543);
    }

    private void ckd() {
        long Cx;
        AppMethodBeat.i(24544);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (com.tencent.mm.plugin.shake.c.c.a.Cw(qsn)) {
            ab.i("MicroMsg.ShakeCardService", "ShakeCardService frequency_level is valid");
            Cx = (long) com.tencent.mm.plugin.shake.c.c.a.Cx(qsn);
        } else {
            ab.i("MicroMsg.ShakeCardService", "ShakeCardService frequency_level is not valid");
            Cx = (long) com.tencent.mm.plugin.shake.c.c.a.Cy(com.tencent.mm.plugin.shake.c.c.a.ckr());
        }
        ab.i("MicroMsg.ShakeCardService", "ShakeCardService updateWaitingTime wait nextInterval is ".concat(String.valueOf(Cx)));
        this.qso = Cx + currentTimeMillis;
        AppMethodBeat.o(24544);
    }

    public final void resume() {
        AppMethodBeat.i(24539);
        if (this.fwu != null) {
            this.fwu.a(this.ecy, true);
        }
        AppMethodBeat.o(24539);
    }
}
