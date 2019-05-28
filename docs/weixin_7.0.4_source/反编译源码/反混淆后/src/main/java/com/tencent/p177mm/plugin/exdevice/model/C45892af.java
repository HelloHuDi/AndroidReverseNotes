package com.tencent.p177mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C42076vi;
import com.tencent.p177mm.p230g.p231a.C42076vi.C1581a;
import com.tencent.p177mm.plugin.exdevice.model.C38954i.C34037a;
import com.tencent.p177mm.plugin.exdevice.p952b.C11635k.C11639f;
import com.tencent.p177mm.plugin.exdevice.p956h.C11648b;
import com.tencent.p177mm.plugin.exdevice.service.C11656d;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.exdevice.model.af */
public final class C45892af implements C1202f {
    C4884c ecA = new C278491();

    /* renamed from: com.tencent.mm.plugin.exdevice.model.af$1 */
    class C278491 extends C4884c<C42076vi> {
        C278491() {
            AppMethodBeat.m2504i(19407);
            this.xxI = C42076vi.class.getName().hashCode();
            AppMethodBeat.m2505o(19407);
        }

        /* renamed from: a */
        private boolean m44273a(final C42076vi c42076vi) {
            boolean z = true;
            AppMethodBeat.m2504i(19408);
            if (c42076vi instanceof C42076vi) {
                switch (c42076vi.cSq.cuy) {
                    case 1:
                        C4990ab.m7417i("MicroMsg.WearHardDeviceLogic", "receive register deviceId=%s", c42076vi.cSq.ceI);
                        C38954i.lto.mo61833a(C4996ah.getContext(), new C34037a() {
                            /* renamed from: gM */
                            public final void mo35799gM(boolean z) {
                                AppMethodBeat.m2504i(19406);
                                if (z) {
                                    C45892af.m85029aA(c42076vi.cSq.ceI, true);
                                    AppMethodBeat.m2505o(19406);
                                    return;
                                }
                                C4990ab.m7413e("MicroMsg.WearHardDeviceLogic", "GetBoundDeviceLogic Fail, deviceId=%s|deviceType=%s", c42076vi.cSq.ceI, c42076vi.cSq.cws);
                                C45892af.m85029aA(c42076vi.cSq.ceI, false);
                                AppMethodBeat.m2505o(19406);
                            }
                        });
                        break;
                    case 3:
                        C11648b Kv = C45891ad.boW().mo45701Kv(c42076vi.cSq.ceI);
                        C1581a c1581a = c42076vi.cSq;
                        if (Kv == null) {
                            z = false;
                        }
                        c1581a.cxT = z;
                        break;
                    case 4:
                        C4990ab.m7417i("MicroMsg.WearHardDeviceLogic", "receive send deviceId=%s", c42076vi.cSq.ceI);
                        C9638aw.m17182Rg().mo14539a(538, C45892af.this);
                        C9638aw.m17182Rg().mo14541a(new C20539w(0, c42076vi.cSq.cws, c42076vi.cSq.ceI, C11639f.boz(), C5046bo.anU(), c42076vi.cSq.data, 1), 0);
                        break;
                    case 7:
                        C9638aw.m17182Rg().mo14539a(541, C45892af.this);
                        C9638aw.m17182Rg().mo14541a(new C42996r("AndroidWear", c42076vi.cSq.cws, c42076vi.cSq.ceI, 1, new byte[0]), 0);
                        break;
                    case 11:
                        if (!C5046bo.m7529bI(C4996ah.getContext(), C4996ah.getPackageName() + ":exdevice")) {
                            C11656d.m19470dI(C4996ah.getContext());
                            break;
                        }
                        break;
                }
            }
            AppMethodBeat.m2505o(19408);
            return false;
        }
    }

    public C45892af() {
        AppMethodBeat.m2504i(19410);
        C4879a.xxA.mo10052c(this.ecA);
        AppMethodBeat.m2505o(19410);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(19411);
        if (c1207m instanceof C42996r) {
            C9638aw.m17182Rg().mo14546b(541, (C1202f) this);
            C42996r c42996r = (C42996r) c1207m;
            if (i == 0 && i2 == 0) {
                C45892af.m85030ay(c42996r.ltF, true);
                AppMethodBeat.m2505o(19411);
                return;
            }
            C45892af.m85030ay(c42996r.ltF, false);
            AppMethodBeat.m2505o(19411);
            return;
        }
        if (c1207m instanceof C20539w) {
            C9638aw.m17182Rg().mo14546b(538, (C1202f) this);
            C20539w c20539w = (C20539w) c1207m;
            if (i == 0 && i2 == 0) {
                C45892af.m85031az(c20539w.ltH, true);
                AppMethodBeat.m2505o(19411);
                return;
            }
            C45892af.m85031az(c20539w.ltH, false);
        }
        AppMethodBeat.m2505o(19411);
    }

    /* renamed from: ay */
    private static void m85030ay(String str, boolean z) {
        AppMethodBeat.m2504i(19412);
        C4990ab.m7417i("MicroMsg.WearHardDeviceLogic", "publish auth response deviceId=%s | isSuccess=%b", str, Boolean.valueOf(z));
        C42076vi c42076vi = new C42076vi();
        c42076vi.cSq.cuy = 8;
        c42076vi.cSq.cxT = z;
        c42076vi.cSq.ceI = str;
        C4879a.xxA.mo10055m(c42076vi);
        AppMethodBeat.m2505o(19412);
    }

    /* renamed from: az */
    private static void m85031az(String str, boolean z) {
        AppMethodBeat.m2504i(19413);
        C4990ab.m7417i("MicroMsg.WearHardDeviceLogic", "publish send response deviceId=%s | isSuccess=%b", str, Boolean.valueOf(z));
        C42076vi c42076vi = new C42076vi();
        c42076vi.cSq.cuy = 5;
        c42076vi.cSq.cxT = z;
        c42076vi.cSq.ceI = str;
        C4879a.xxA.mo10055m(c42076vi);
        AppMethodBeat.m2505o(19413);
    }

    /* renamed from: aA */
    static /* synthetic */ void m85029aA(String str, boolean z) {
        AppMethodBeat.m2504i(19414);
        C4990ab.m7417i("MicroMsg.WearHardDeviceLogic", "publish register response deviceId=%s | isSuccess=%b", str, Boolean.valueOf(z));
        C42076vi c42076vi = new C42076vi();
        c42076vi.cSq.cuy = 2;
        c42076vi.cSq.cxT = z;
        c42076vi.cSq.ceI = str;
        C4879a.xxA.mo10055m(c42076vi);
        AppMethodBeat.m2505o(19414);
    }
}
