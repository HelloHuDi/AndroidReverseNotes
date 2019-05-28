package com.tencent.p177mm.plugin.appbrand.launching.p905a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.p217ci.C37654f;
import com.tencent.p177mm.p217ci.C41930g;
import com.tencent.p177mm.p230g.p232b.p233a.C18443ch;
import com.tencent.p177mm.p230g.p232b.p233a.C18443ch.C18444b;
import com.tencent.p177mm.p230g.p232b.p233a.C18443ch.C18445c;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appcache.C10068aj;
import com.tencent.p177mm.plugin.appbrand.appcache.C19033ab;
import com.tencent.p177mm.plugin.appbrand.appcache.C24683aa;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p279e.C2060e;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p279e.C45513b;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p883c.C19050a;
import com.tencent.p177mm.plugin.appbrand.config.C26842p;
import com.tencent.p177mm.plugin.appbrand.launching.C27157aa;
import com.tencent.p177mm.plugin.appbrand.launching.C42608ag;
import com.tencent.p177mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify;
import com.tencent.p177mm.plugin.appbrand.p329s.C42677e;
import com.tencent.p177mm.plugin.appbrand.p904k.C42597a;
import com.tencent.p177mm.plugin.appbrand.report.quality.C2453g;
import com.tencent.p177mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.p177mm.protocal.protobuf.axq;
import com.tencent.p177mm.protocal.protobuf.axr;
import com.tencent.p177mm.protocal.protobuf.btd;
import com.tencent.p177mm.protocal.protobuf.cwf;
import com.tencent.p177mm.protocal.protobuf.cxe;
import com.tencent.p177mm.protocal.protobuf.cxj;
import com.tencent.p177mm.protocal.protobuf.cyb;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.vending.p641g.C7361c.C5689a;
import java.util.Locale;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.a.a */
public final class C33430a extends C37440a<axr> {
    final String bQd;
    final C7472b ehh;
    public volatile boolean ihY = false;
    public volatile C27157aa iiW;
    private final C18443ch iiX;

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.a.a$3 */
    class C105783 implements C5689a<C37441a<axr>> {
        C105783() {
        }

        public final /* synthetic */ Object call() {
            AppMethodBeat.m2504i(132019);
            C37441a a = C37441a.m63107a(3, 99999999, "Async Launch Blocked", null, null, C33430a.this);
            AppMethodBeat.m2505o(132019);
            return a;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.a.a$5 */
    class C105795 implements C5681a<Void, Void> {
        C105795() {
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(132021);
            C42340f.auT().mo73330a(C26842p.m42742zo(C33430a.this.getAppId()), C33430a.this.asT(), C33430a.this.aHC(), C33430a.this.aHD(), 1, C33430a.this.bQd);
            AppMethodBeat.m2505o(132021);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.a.a$1 */
    class C334291 implements Runnable {
        C334291() {
        }

        public final void run() {
            AppMethodBeat.m2504i(132017);
            C33430a.this.ihY = false;
            C33430a.this.acy();
            AppMethodBeat.m2505o(132017);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo21469a(int i, int i2, String str, btd btd, C1207m c1207m) {
        Object obj;
        String str2;
        AppMethodBeat.m2504i(132025);
        final axr axr = (axr) btd;
        if (c1207m == null) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            try {
                long anU = C5046bo.anU();
                this.iiX.mo33715em(anU);
                this.iiX.mo33712ej(anU - this.iiX.ddB);
                C18443ch c18443ch = this.iiX;
                if (aHC()) {
                    anU = 1;
                } else {
                    anU = 0;
                }
                c18443ch.dgc = anU;
                if (!C42597a.m75414a(i, i2, axr)) {
                    this.iiX.dga = C18445c.common_fail;
                } else if (axr.wBJ == null) {
                    this.iiX.dga = C18445c.bundle_null;
                } else if (axr.wBJ.vYw == null) {
                    this.iiX.dga = C18445c.jsapi_control_bytes_null;
                } else {
                    this.iiX.dga = C18445c.ok;
                }
                this.iiX.ajK();
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", "quality report e = %s", e);
            }
        }
        if (axr == null) {
            str2 = "NULL";
        } else {
            if (axr.wBJ == null) {
                str2 = "NULL_API_INFO";
            } else {
                str2 = "api_info~ fg:" + (axr.wBJ.vYw == null ? "NULL" : Integer.valueOf(axr.wBJ.vYw.f1226wR.length));
                if (axr.wBJ.vYx != null) {
                    if (axr.wBJ.vYx.size() > 0) {
                        str2 = str2 + " | bg:" + ((C1332b) axr.wBJ.vYx.get(0)).f1226wR.length;
                    }
                    if (axr.wBJ.vYx.size() > 1) {
                        str2 = str2 + " | suspend:" + ((C1332b) axr.wBJ.vYx.get(1)).f1226wR.length;
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
        C4990ab.m7417i("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", "onCgiBack, errType %d, errCode %d, errMsg %s, req[appId %s, bg %B, sync %B, libVersion %d], resp[%s]", Integer.valueOf(i), Integer.valueOf(i2), str, getAppId(), Boolean.valueOf(aHC()), Boolean.valueOf(this.ihY), Integer.valueOf(aHE().wBD.wDC), str2);
        if (i == 0 && i2 == 0 && axr != null) {
            if (obj != null) {
                this.iiW = new C27157aa();
                this.iiW.field_appId = getAppId();
                this.iiW.mo44830a(axr);
            } else {
                this.iiW = C42340f.auP().mo61132a(getAppId(), axr);
            }
            this.iiW.ihY = this.ihY;
            C41930g.dOW().mo60493i(new C5681a<Void, Void>() {
                public final /* synthetic */ Object call(Object obj) {
                    AppMethodBeat.m2504i(132020);
                    C10068aj.m17650a(C33430a.this.aHE().wBD.wDC, axr.wBL);
                    Void voidR = zXH;
                    AppMethodBeat.m2505o(132020);
                    return voidR;
                }
            }).dMk();
            if (axr.wBI != null) {
                if (axr.wBI.wBv) {
                    C41930g.dOW().mo60493i(new C105795()).dMk();
                }
                if (!this.ihY) {
                    ILaunchWxaAppInfoNotify.ihc.mo34768a(getAppId(), asT(), this.bQd, this.iiW);
                    AppMethodBeat.m2505o(132025);
                    return;
                }
            }
        } else if (this.ihY) {
            Object[] objArr = new Object[1];
            objArr[0] = String.format(Locale.US, " (%d,%d)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            C42608ag.m75434Ck(C42608ag.getMMString(C25738R.string.f9010mc, objArr));
        }
        AppMethodBeat.m2505o(132025);
    }

    public C33430a(String str, boolean z, cwf cwf, cyb cyb, cxj cxj, String str2, int i, QualitySession qualitySession) {
        C18444b c18444b;
        AppMethodBeat.m2504i(132022);
        this.bQd = str2;
        this.iiX = C2453g.m4697b(qualitySession);
        C18443ch c18443ch = this.iiX;
        if (z) {
            c18444b = C18444b.sync;
        } else {
            c18444b = C18444b.async;
        }
        c18443ch.dgb = c18444b;
        this.iiX.cXm = (long) C2453g.getNetworkType();
        axq axq = new axq();
        axq.fKh = str;
        axq.wBB = cwf;
        axq.wsv = z ? 1 : 2;
        axq.wBE = cyb;
        axq.wBF = cxj;
        cxe cxe = new cxe();
        cxe.wDC = i;
        if (i > 0) {
            C19033ab ava = C42340f.ava();
            if (ava != null) {
                C24683aa c24683aa = new C24683aa();
                c24683aa.field_key = "@LibraryAppId";
                c24683aa.field_version = i;
                if (ava.mo10102b((C4925c) c24683aa, "key", "version")) {
                    cxe.vEr = (int) c24683aa.field_updateTime;
                    cxe.xsE = c24683aa.field_scene;
                }
            }
        }
        axq.wBD = cxe;
        try {
            if (C1427q.etl.epE) {
                C4990ab.m7416i("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", "DeviceInfo isLimit benchmarkLevel");
                axq.wBH = -2;
            } else {
                axq.wBH = C26373g.m41964Nu().getInt("ClientBenchmarkLevel", 0);
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", e, "read performanceLevel", new Object[0]);
        }
        C1196a c1196a = new C1196a();
        c1196a.fsI = 1122;
        c1196a.uri = "/cgi-bin/mmbiz-bin/wxaattr/launchwxaapp";
        c1196a.fsJ = axq;
        c1196a.fsK = new axr();
        C7472b acD = c1196a.acD();
        this.ehh = acD;
        this.ehh = acD;
        AppMethodBeat.m2505o(132022);
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
        AppMethodBeat.m2504i(132023);
        C42677e.aNS().mo10302aa(new C334291());
        AppMethodBeat.m2505o(132023);
    }

    public final synchronized C37654f<C37441a<axr>> acy() {
        C37654f<C37441a<axr>> c;
        AppMethodBeat.m2504i(132024);
        final Pair az = ((C2060e) C42340f.m74878E(C2060e.class)).mo5826az(getAppId(), aHD());
        C19050a c19050a;
        if (az.first != null) {
            C4990ab.m7417i("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", "before run, get issued data by appId(%s) scene(%d)", getAppId(), Integer.valueOf(aHD()));
            c19050a = C19050a.gWl;
            C19050a.m29623z(((Long) az.second).longValue(), 106);
            c = C41930g.m74066c(new C5689a<C37441a<axr>>() {
                public final /* synthetic */ Object call() {
                    AppMethodBeat.m2504i(132018);
                    C37441a a = C37441a.m63107a(0, 0, null, (btd) az.first, null, C33430a.this);
                    AppMethodBeat.m2505o(132018);
                    return a;
                }
            });
            AppMethodBeat.m2505o(132024);
        } else {
            C4990ab.m7417i("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", "run() appId[%s], scene[%d], libVersion[%d] performanceLevel[%d]", getAppId(), Integer.valueOf(aHD()), Integer.valueOf(((axq) this.ehh.fsG.fsP).wBD.wDC), Integer.valueOf(aHE().wBH));
            if (aHE().wBH == 0) {
                C4990ab.m7413e("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", "run() appId[%s] invalid performanceLevel[%d]", getAppId(), Integer.valueOf(aHE().wBH));
            }
            if (!this.ihY) {
                az = ((C45513b) C42340f.m74878E(C45513b.class)).mo73326y(getAppId(), 2, aHD());
                if (((Boolean) az.first).booleanValue()) {
                    c19050a = C19050a.gWl;
                    C19050a.m29623z((long) ((Integer) az.second).intValue(), 168);
                    C4990ab.m7417i("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", "async launch with appid(%s) scene(%d) blocked", getAppId(), Integer.valueOf(aHD()));
                    c = C41930g.m74066c(new C105783());
                    AppMethodBeat.m2505o(132024);
                }
            }
            this.iiX.mo33714el(C5046bo.anU());
            c = super.acy();
            AppMethodBeat.m2505o(132024);
        }
        return c;
    }
}
