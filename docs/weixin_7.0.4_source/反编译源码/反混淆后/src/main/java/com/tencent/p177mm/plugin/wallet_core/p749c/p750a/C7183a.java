package com.tencent.p177mm.plugin.wallet_core.p749c.p750a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C7532biz;
import com.tencent.p177mm.protocal.protobuf.biy;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.wallet_core.c.a.a */
public final class C7183a extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;

    public C7183a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        AppMethodBeat.m2504i(46560);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new biy();
        c1196a.fsK = new C7532biz();
        c1196a.uri = "/cgi-bin/mmpay-bin/payibgcheckjsapisign";
        this.ehh = c1196a.acD();
        biy biy = (biy) this.ehh.fsG.fsP;
        biy.fKh = str;
        biy.vYP = str4;
        biy.vYO = str2;
        biy.vYQ = str5;
        biy.vYR = str6;
        biy.vLo = str3;
        biy.vXP = str7;
        AppMethodBeat.m2505o(46560);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(46561);
        C4990ab.m7417i("MicroMsg.NetSceneIbgCheckJsapi", "check jsapi: errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        C7532biz c7532biz = (C7532biz) ((C7472b) c1929q).fsH.fsP;
        if (i3 == 0 && i2 == 0) {
            i3 = c7532biz.luT;
            str = c7532biz.luU;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(46561);
    }

    public final int getType() {
        return 1767;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(46562);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(46562);
        return a;
    }
}
