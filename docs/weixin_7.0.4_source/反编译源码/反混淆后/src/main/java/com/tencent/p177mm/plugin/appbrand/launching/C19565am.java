package com.tencent.p177mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p183ai.C8920x;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.task.C45694h;
import com.tencent.p177mm.protocal.protobuf.C44160qv;
import com.tencent.p177mm.protocal.protobuf.C46578qw;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.am */
public final class C19565am {
    private final String appId;
    private final String cvZ;
    private final String hoo;
    private final boolean hop;

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.am$a */
    public enum C19566a {
        Ok,
        Fail,
        Timeout,
        CgiFail,
        ResponseInvalid,
        AwaitFail;

        static {
            AppMethodBeat.m2505o(131997);
        }

        /* renamed from: pa */
        public static C19566a m30339pa(int i) {
            AppMethodBeat.m2504i(131996);
            if (i < 0) {
                AppMethodBeat.m2505o(131996);
                return null;
            }
            for (C19566a c19566a : C19566a.values()) {
                if (c19566a.ordinal() == i) {
                    AppMethodBeat.m2505o(131996);
                    return c19566a;
                }
            }
            AppMethodBeat.m2505o(131996);
            return null;
        }
    }

    public C19565am(String str, String str2, String str3, boolean z) {
        this.appId = str;
        this.cvZ = str2;
        this.hoo = str3;
        this.hop = z;
    }

    /* renamed from: o */
    private void m30338o(int i, String str, String str2) {
        AppMethodBeat.m2504i(131998);
        if (C42340f.auV().mo60848a(this.appId, i, str, str2, 0, 0) && this.hop) {
            C45694h.m84422bt(this.appId, 2);
        }
        AppMethodBeat.m2505o(131998);
    }

    public final int aAa() {
        AppMethodBeat.m2504i(131999);
        String str = this.appId;
        String str2 = this.cvZ;
        String str3 = this.hoo;
        C1196a c1196a = new C1196a();
        C44160qv c44160qv = new C44160qv();
        c44160qv.csB = str;
        c44160qv.vXR = str2;
        c44160qv.vXS = str3;
        c1196a.fsJ = c44160qv;
        c1196a.fsK = new C46578qw();
        c1196a.uri = "/cgi-bin/mmbiz-bin/wxaapp/checkdemoinfo";
        c1196a.fsI = 1124;
        C37441a c = C8920x.m16082c(c1196a.acD());
        int ordinal;
        if (c.errType == 0 && c.errCode == 0) {
            try {
                C46578qw c46578qw = (C46578qw) c.fsy;
                if (c46578qw.vXT == null) {
                    C4990ab.m7413e("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", "CgiCheckDemoInfo, appId %s, null wxaapp resp", this.appId);
                    ordinal = C19566a.ResponseInvalid.ordinal();
                    AppMethodBeat.m2505o(131999);
                    return ordinal;
                }
                C4990ab.m7417i("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", "CgiCheckDemoInfo, appId %s, wxa.ErrCode %d, has_new_demo %b, url %s, md5 %s", this.appId, Integer.valueOf(c46578qw.vXT.luT), Boolean.valueOf(c46578qw.vXU), c46578qw.vXV, c46578qw.vXW);
                if (c46578qw.vXT.luT != 0) {
                    ordinal = c46578qw.vXT.luT;
                    AppMethodBeat.m2505o(131999);
                    return ordinal;
                }
                if (!(!c46578qw.vXU || C5046bo.isNullOrNil(c46578qw.vXW) || C5046bo.isNullOrNil(c46578qw.vXV))) {
                    m30338o(2, c46578qw.vXV, c46578qw.vXW);
                }
                if (!(!c46578qw.vXX || C5046bo.isNullOrNil(c46578qw.vXZ) || C5046bo.isNullOrNil(c46578qw.vXY))) {
                    m30338o(10001, c46578qw.vXY, c46578qw.vXZ);
                }
                if (!C5046bo.isNullOrNil(c46578qw.vYa)) {
                    ((C42611l) C42340f.m74878E(C42611l.class)).mo68053n(this.appId, 2, c46578qw.vYa);
                }
                ordinal = C19566a.Ok.ordinal();
                AppMethodBeat.m2505o(131999);
                return ordinal;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", e, "CgiCheckDemoInfo, appId %s, cast response failed", this.appId);
                ordinal = C19566a.ResponseInvalid.ordinal();
                AppMethodBeat.m2505o(131999);
                return ordinal;
            }
        }
        C4990ab.m7413e("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", "CgiCheckDemoInfo, appId %s, errType %d, errCode %d, errMsg %s", this.appId, Integer.valueOf(c.errType), Integer.valueOf(c.errCode), c.aIm);
        ordinal = C19566a.CgiFail.ordinal();
        AppMethodBeat.m2505o(131999);
        return ordinal;
    }
}
