package com.tencent.p177mm.plugin.appbrand.dynamic.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p183ai.C8920x;
import com.tencent.p177mm.plugin.appbrand.p1468a.C33065d;
import com.tencent.p177mm.protocal.protobuf.C44160qv;
import com.tencent.p177mm.protocal.protobuf.C46578qw;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.launching.c */
public final class C42428c {
    private final String appId;
    private final String cvZ;
    private final String hoo;
    private final boolean hop;

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.launching.c$a */
    public enum C26870a {
        Ok,
        Fail,
        Timeout,
        CgiFail,
        ResponseInvalid,
        AwaitFail;

        static {
            AppMethodBeat.m2505o(10926);
        }
    }

    private C42428c(String str, String str2, String str3) {
        this.appId = str;
        this.cvZ = str2;
        this.hoo = str3;
        this.hop = false;
    }

    public C42428c(String str, String str2, String str3, byte b) {
        this(str, str2, str3);
    }

    /* renamed from: o */
    private void m75146o(int i, String str, String str2) {
        AppMethodBeat.m2504i(10927);
        ((C33065d) C1720g.m3528K(C33065d.class)).mo53635xF().mo60848a(this.appId, i, str, str2, 0, 0);
        AppMethodBeat.m2505o(10927);
    }

    public final int aAa() {
        AppMethodBeat.m2504i(10928);
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
                    ordinal = C26870a.ResponseInvalid.ordinal();
                    AppMethodBeat.m2505o(10928);
                    return ordinal;
                }
                C4990ab.m7417i("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", "CgiCheckDemoInfo, appId %s, wxa.ErrCode %d, has_new_demo %b, url %s, md5 %s", this.appId, Integer.valueOf(c46578qw.vXT.luT), Boolean.valueOf(c46578qw.vXU), c46578qw.vXV, c46578qw.vXW);
                if (c46578qw.vXT.luT != 0) {
                    ordinal = c46578qw.vXT.luT;
                    AppMethodBeat.m2505o(10928);
                    return ordinal;
                }
                if (!(!c46578qw.vXU || C5046bo.isNullOrNil(c46578qw.vXW) || C5046bo.isNullOrNil(c46578qw.vXV))) {
                    m75146o(2, c46578qw.vXV, c46578qw.vXW);
                }
                if (!(!c46578qw.vXX || C5046bo.isNullOrNil(c46578qw.vXZ) || C5046bo.isNullOrNil(c46578qw.vXY))) {
                    m75146o(10001, c46578qw.vXY, c46578qw.vXZ);
                }
                ordinal = C26870a.Ok.ordinal();
                AppMethodBeat.m2505o(10928);
                return ordinal;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", e, "CgiCheckDemoInfo, appId %s, cast response failed", this.appId);
                ordinal = C26870a.ResponseInvalid.ordinal();
                AppMethodBeat.m2505o(10928);
                return ordinal;
            }
        }
        C4990ab.m7413e("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", "CgiCheckDemoInfo, appId %s, errType %d, errCode %d, errMsg %s", this.appId, Integer.valueOf(c.errType), Integer.valueOf(c.errCode), c.aIm);
        ordinal = C26870a.CgiFail.ordinal();
        AppMethodBeat.m2505o(10928);
        return ordinal;
    }
}
