package com.tencent.p177mm.plugin.wallet_index.p564c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.aea;
import com.tencent.p177mm.protocal.protobuf.aeb;
import com.tencent.p177mm.protocal.protobuf.auh;
import com.tencent.p177mm.protocal.protobuf.aui;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p649c.C36378u;

/* renamed from: com.tencent.mm.plugin.wallet_index.c.f */
public final class C14345f extends C36378u {
    private C7472b ehh;
    private C1202f ehi;
    public int errCode;
    public auh tRe;
    public aui tRf;

    public C14345f(int i, String str, String str2, String str3, int i2, String str4, String str5, String str6, String str7) {
        AppMethodBeat.m2504i(48184);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new aea();
        c1196a.fsK = new aeb();
        c1196a.uri = "/cgi-bin/mmbiz-bin/boss/getandroidiappackage";
        this.ehh = c1196a.acD();
        aea aea = (aea) this.ehh.fsG.fsP;
        aea.csB = str;
        aea.wlY = i;
        aea.wlZ = Integer.parseInt(str2);
        aea.desc = str3;
        aea.count = i2;
        aea.scene = 13;
        aea.wma = str4;
        aea.wmb = str5;
        aea.sign = str6;
        aea.wmc = str7;
        AppMethodBeat.m2505o(48184);
    }

    /* renamed from: e */
    public final void mo9541e(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(48185);
        C4990ab.m7412e("MicroMsg.NetSceneGetAndroidIapPackage", "ErrType:" + i + ",errCode:" + i2 + ",errMsg:" + str);
        if (i == 0 && i2 == 0) {
            aeb aeb = (aeb) this.ehh.fsH.fsP;
            C4990ab.m7412e("MicroMsg.NetSceneGetAndroidIapPackage", "business: errCode:" + aeb.cCJ + ",errMsg:" + aeb.cCK);
            int i3 = aeb.cCJ;
            String str2 = aeb.cCK;
            if (i3 == 0) {
                this.tRe = aeb.wmd;
                this.tRf = aeb.wme;
            }
            this.ehi.onSceneEnd(i, i3, str2, this);
            AppMethodBeat.m2505o(48185);
            return;
        }
        this.ehi.onSceneEnd(i, i2, str, this);
        AppMethodBeat.m2505o(48185);
    }

    public final int getType() {
        return 1130;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(48186);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(48186);
        return a;
    }
}
