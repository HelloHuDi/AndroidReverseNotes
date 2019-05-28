package com.tencent.p177mm.plugin.fingerprint.p1261c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.soter.p527b.C35149d;
import com.tencent.p177mm.pluginsdk.C30052l;
import com.tencent.p177mm.protocal.protobuf.ccs;
import com.tencent.p177mm.protocal.protobuf.cct;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tenpay.android.wechat.TenpayUtil;

/* renamed from: com.tencent.mm.plugin.fingerprint.c.b */
public final class C43096b extends C35149d implements C1918k {
    public final C7472b ehh;
    private C1202f ehi;
    private int msp;

    public C43096b(String str, String str2, String str3, int i) {
        AppMethodBeat.m2504i(41573);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new ccs();
        c1196a.fsK = new cct();
        c1196a.uri = "/cgi-bin/mmpay-bin/soteropenfppayment";
        this.ehh = c1196a.acD();
        ccs ccs = (ccs) this.ehh.fsG.fsP;
        ccs.wKv = str;
        ccs.signature = str2;
        ccs.xcb = str3;
        ccs.cDo = TenpayUtil.signWith3Des("passwd=" + ccs.xcb);
        ccs.xbY = i;
        ccs.xbZ = 1;
        this.msp = i;
        C4990ab.m7417i("MicroMsg.NetSceneSoterOpenTouchPay", "soter type: %s", Integer.valueOf(i));
        AppMethodBeat.m2505o(41573);
    }

    /* renamed from: d */
    public final void mo55792d(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(41574);
        C4990ab.m7417i("MicroMsg.NetSceneSoterOpenTouchPay", "hy: errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (i == 0 && i2 == 0) {
            C4990ab.m7416i("MicroMsg.NetSceneSoterOpenTouchPay", "open fingerprintpay success");
            if (this.msp == 1) {
                ((C30052l) C1720g.m3528K(C30052l.class)).mo48312hq(true);
                ((C30052l) C1720g.m3528K(C30052l.class)).mo48313hr(false);
            } else {
                ((C30052l) C1720g.m3528K(C30052l.class)).mo48313hr(true);
                ((C30052l) C1720g.m3528K(C30052l.class)).mo48312hq(false);
            }
        } else {
            C4990ab.m7412e("MicroMsg.NetSceneSoterOpenTouchPay", "open fingerprintpay failed");
        }
        this.ehi.onSceneEnd(i, i2, "", this);
        AppMethodBeat.m2505o(41574);
    }

    public final void bxO() {
        AppMethodBeat.m2504i(41575);
        C4990ab.m7416i("MicroMsg.NetSceneSoterOpenTouchPay", "hy: authkey required");
        if (this.ehi != null) {
            this.ehi.onSceneEnd(4, -1, "", this);
        }
        AppMethodBeat.m2505o(41575);
    }

    /* renamed from: vL */
    public final void mo55793vL(int i) {
        AppMethodBeat.m2504i(41576);
        C4990ab.m7417i("MicroMsg.NetSceneSoterOpenTouchPay", "hy: onError: errType: %d, errcode: %d", Integer.valueOf(3), Integer.valueOf(i));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(4, -1, "", this);
        }
        AppMethodBeat.m2505o(41576);
    }

    public final int getType() {
        return 1638;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(41577);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(41577);
        return a;
    }
}
