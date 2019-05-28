package com.tencent.mm.plugin.appbrand.launching.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.ci.g;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.g.b.a.ch;
import com.tencent.mm.g.b.a.ch.c;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appcache.aj;
import com.tencent.mm.plugin.appbrand.config.p;
import com.tencent.mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify;
import com.tencent.mm.plugin.appbrand.launching.aa;
import com.tencent.mm.plugin.appbrand.launching.ag;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.s.e;
import com.tencent.mm.protocal.protobuf.axq;
import com.tencent.mm.protocal.protobuf.axr;
import com.tencent.mm.protocal.protobuf.btd;
import com.tencent.mm.protocal.protobuf.cwf;
import com.tencent.mm.protocal.protobuf.cxe;
import com.tencent.mm.protocal.protobuf.cxj;
import com.tencent.mm.protocal.protobuf.cyb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Locale;

public final class a extends com.tencent.mm.ai.a<axr> {
    final String bQd;
    final b ehh;
    public volatile boolean ihY = false;
    public volatile aa iiW;
    private final ch iiX;

    public final /* synthetic */ void a(int i, int i2, String str, btd btd, m mVar) {
        Object obj;
        String str2;
        AppMethodBeat.i(132025);
        final axr axr = (axr) btd;
        if (mVar == null) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            try {
                long anU = bo.anU();
                this.iiX.em(anU);
                this.iiX.ej(anU - this.iiX.ddB);
                ch chVar = this.iiX;
                if (aHC()) {
                    anU = 1;
                } else {
                    anU = 0;
                }
                chVar.dgc = anU;
                if (!com.tencent.mm.plugin.appbrand.k.a.a(i, i2, axr)) {
                    this.iiX.dga = c.common_fail;
                } else if (axr.wBJ == null) {
                    this.iiX.dga = c.bundle_null;
                } else if (axr.wBJ.vYw == null) {
                    this.iiX.dga = c.jsapi_control_bytes_null;
                } else {
                    this.iiX.dga = c.ok;
                }
                this.iiX.ajK();
            } catch (Exception e) {
                ab.e("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", "quality report e = %s", e);
            }
        }
        if (axr == null) {
            str2 = "NULL";
        } else {
            if (axr.wBJ == null) {
                str2 = "NULL_API_INFO";
            } else {
                str2 = "api_info~ fg:" + (axr.wBJ.vYw == null ? "NULL" : Integer.valueOf(axr.wBJ.vYw.wR.length));
                if (axr.wBJ.vYx != null) {
                    if (axr.wBJ.vYx.size() > 0) {
                        str2 = str2 + " | bg:" + ((com.tencent.mm.bt.b) axr.wBJ.vYx.get(0)).wR.length;
                    }
                    if (axr.wBJ.vYx.size() > 1) {
                        str2 = str2 + " | suspend:" + ((com.tencent.mm.bt.b) axr.wBJ.vYx.get(1)).wR.length;
                    }
                }
                str2 = str2 + "~";
            }
            if (axr.wBI == null) {
                str2 = str2 + " || NULL_LAUNCH";
            } else {
                str2 = str2 + " || launch " + axr.wBI.vAS;
            }
        }
        ab.i("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", "onCgiBack, errType %d, errCode %d, errMsg %s, req[appId %s, bg %B, sync %B, libVersion %d], resp[%s]", Integer.valueOf(i), Integer.valueOf(i2), str, getAppId(), Boolean.valueOf(aHC()), Boolean.valueOf(this.ihY), Integer.valueOf(aHE().wBD.wDC), str2);
        if (i == 0 && i2 == 0 && axr != null) {
            if (obj != null) {
                this.iiW = new aa();
                this.iiW.field_appId = getAppId();
                this.iiW.a(axr);
            } else {
                this.iiW = f.auP().a(getAppId(), axr);
            }
            this.iiW.ihY = this.ihY;
            g.dOW().i(new com.tencent.mm.vending.c.a<Void, Void>() {
                public final /* synthetic */ Object call(Object obj) {
                    AppMethodBeat.i(132020);
                    aj.a(a.this.aHE().wBD.wDC, axr.wBL);
                    Void voidR = zXH;
                    AppMethodBeat.o(132020);
                    return voidR;
                }
            }).dMk();
            if (axr.wBI != null) {
                if (axr.wBI.wBv) {
                    g.dOW().i(new com.tencent.mm.vending.c.a<Void, Void>() {
                        public final /* synthetic */ Object call(Object obj) {
                            AppMethodBeat.i(132021);
                            f.auT().a(p.zo(a.this.getAppId()), a.this.asT(), a.this.aHC(), a.this.aHD(), 1, a.this.bQd);
                            AppMethodBeat.o(132021);
                            return null;
                        }
                    }).dMk();
                }
                if (!this.ihY) {
                    ILaunchWxaAppInfoNotify.ihc.a(getAppId(), asT(), this.bQd, this.iiW);
                    AppMethodBeat.o(132025);
                    return;
                }
            }
        } else if (this.ihY) {
            Object[] objArr = new Object[1];
            objArr[0] = String.format(Locale.US, " (%d,%d)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            ag.Ck(ag.getMMString(R.string.mc, objArr));
        }
        AppMethodBeat.o(132025);
    }

    public a(String str, boolean z, cwf cwf, cyb cyb, cxj cxj, String str2, int i, QualitySession qualitySession) {
        ch.b bVar;
        AppMethodBeat.i(132022);
        this.bQd = str2;
        this.iiX = com.tencent.mm.plugin.appbrand.report.quality.g.b(qualitySession);
        ch chVar = this.iiX;
        if (z) {
            bVar = ch.b.sync;
        } else {
            bVar = ch.b.async;
        }
        chVar.dgb = bVar;
        this.iiX.cXm = (long) com.tencent.mm.plugin.appbrand.report.quality.g.getNetworkType();
        axq axq = new axq();
        axq.fKh = str;
        axq.wBB = cwf;
        axq.wsv = z ? 1 : 2;
        axq.wBE = cyb;
        axq.wBF = cxj;
        cxe cxe = new cxe();
        cxe.wDC = i;
        if (i > 0) {
            com.tencent.mm.plugin.appbrand.appcache.ab ava = f.ava();
            if (ava != null) {
                com.tencent.mm.plugin.appbrand.appcache.aa aaVar = new com.tencent.mm.plugin.appbrand.appcache.aa();
                aaVar.field_key = "@LibraryAppId";
                aaVar.field_version = i;
                if (ava.b((com.tencent.mm.sdk.e.c) aaVar, "key", "version")) {
                    cxe.vEr = (int) aaVar.field_updateTime;
                    cxe.xsE = aaVar.field_scene;
                }
            }
        }
        axq.wBD = cxe;
        try {
            if (q.etl.epE) {
                ab.i("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", "DeviceInfo isLimit benchmarkLevel");
                axq.wBH = -2;
            } else {
                axq.wBH = com.tencent.mm.m.g.Nu().getInt("ClientBenchmarkLevel", 0);
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", e, "read performanceLevel", new Object[0]);
        }
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsI = 1122;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaattr/launchwxaapp";
        aVar.fsJ = axq;
        aVar.fsK = new axr();
        b acD = aVar.acD();
        this.ehh = acD;
        this.ehh = acD;
        AppMethodBeat.o(132022);
    }

    /* Access modifiers changed, original: final */
    public final String getAppId() {
        return ((axq) this.ehh.fsG.fsP).fKh;
    }

    /* Access modifiers changed, original: final */
    public final int asT() {
        return ((axq) this.ehh.fsG.fsP).wBB.wzF;
    }

    /* Access modifiers changed, original: final */
    public final boolean aHC() {
        return ((axq) this.ehh.fsG.fsP).wBB.wDA > 0;
    }

    /* Access modifiers changed, original: final */
    public final int aHD() {
        return ((axq) this.ehh.fsG.fsP).wBB.Scene;
    }

    /* Access modifiers changed, original: final */
    public final axq aHE() {
        return (axq) this.ehh.fsG.fsP;
    }

    public final void aHF() {
        AppMethodBeat.i(132023);
        e.aNS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(132017);
                a.this.ihY = false;
                a.this.acy();
                AppMethodBeat.o(132017);
            }
        });
        AppMethodBeat.o(132023);
    }

    public final synchronized com.tencent.mm.ci.f<com.tencent.mm.ai.a.a<axr>> acy() {
        com.tencent.mm.ci.f<com.tencent.mm.ai.a.a<axr>> c;
        AppMethodBeat.i(132024);
        final Pair az = ((com.tencent.mm.plugin.appbrand.appcache.b.e.e) f.E(com.tencent.mm.plugin.appbrand.appcache.b.e.e.class)).az(getAppId(), aHD());
        com.tencent.mm.plugin.appbrand.appcache.b.c.a aVar;
        if (az.first != null) {
            ab.i("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", "before run, get issued data by appId(%s) scene(%d)", getAppId(), Integer.valueOf(aHD()));
            aVar = com.tencent.mm.plugin.appbrand.appcache.b.c.a.gWl;
            com.tencent.mm.plugin.appbrand.appcache.b.c.a.z(((Long) az.second).longValue(), 106);
            c = g.c(new com.tencent.mm.vending.g.c.a<com.tencent.mm.ai.a.a<axr>>() {
                public final /* synthetic */ Object call() {
                    AppMethodBeat.i(132018);
                    com.tencent.mm.ai.a.a a = com.tencent.mm.ai.a.a.a(0, 0, null, (btd) az.first, null, a.this);
                    AppMethodBeat.o(132018);
                    return a;
                }
            });
            AppMethodBeat.o(132024);
        } else {
            ab.i("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", "run() appId[%s], scene[%d], libVersion[%d] performanceLevel[%d]", getAppId(), Integer.valueOf(aHD()), Integer.valueOf(((axq) this.ehh.fsG.fsP).wBD.wDC), Integer.valueOf(aHE().wBH));
            if (aHE().wBH == 0) {
                ab.e("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", "run() appId[%s] invalid performanceLevel[%d]", getAppId(), Integer.valueOf(aHE().wBH));
            }
            if (!this.ihY) {
                az = ((com.tencent.mm.plugin.appbrand.appcache.b.e.b) f.E(com.tencent.mm.plugin.appbrand.appcache.b.e.b.class)).y(getAppId(), 2, aHD());
                if (((Boolean) az.first).booleanValue()) {
                    aVar = com.tencent.mm.plugin.appbrand.appcache.b.c.a.gWl;
                    com.tencent.mm.plugin.appbrand.appcache.b.c.a.z((long) ((Integer) az.second).intValue(), 168);
                    ab.i("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", "async launch with appid(%s) scene(%d) blocked", getAppId(), Integer.valueOf(aHD()));
                    c = g.c(new com.tencent.mm.vending.g.c.a<com.tencent.mm.ai.a.a<axr>>() {
                        public final /* synthetic */ Object call() {
                            AppMethodBeat.i(132019);
                            com.tencent.mm.ai.a.a a = com.tencent.mm.ai.a.a.a(3, 99999999, "Async Launch Blocked", null, null, a.this);
                            AppMethodBeat.o(132019);
                            return a;
                        }
                    });
                    AppMethodBeat.o(132024);
                }
            }
            this.iiX.el(bo.anU());
            c = super.acy();
            AppMethodBeat.o(132024);
        }
        return c;
    }
}
