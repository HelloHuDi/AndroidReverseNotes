package com.tencent.p177mm.plugin.sns.p514a.p515b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.plugin.sns.p1024b.C21877n;
import com.tencent.p177mm.protocal.protobuf.C23373bi;
import com.tencent.p177mm.protocal.protobuf.C30169bh;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;

/* renamed from: com.tencent.mm.plugin.sns.a.b.c */
public final class C46208c extends C1207m implements C1918k {
    private C7472b ehh;
    public C1202f ehi;

    public C46208c(long j, String str, int i, int i2, int i3, String str2, int i4, String str3, int i5, C1332b c1332b, C1332b c1332b2) {
        AppMethodBeat.m2504i(94483);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C30169bh();
        c1196a.fsK = new C23373bi();
        int jS = C21877n.qFD.mo62940jS(j);
        if (jS != 2) {
            c1196a.uri = "/cgi-bin/mmoc-bin/ad/click";
            c1196a.fsI = 1232;
        } else {
            c1196a.uri = "/cgi-bin/mmux-bin/adclick";
            c1196a.fsI = 1817;
        }
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        C4990ab.m7417i("MicroMsg.NetSceneAdClick", "source %d, uri %s", Integer.valueOf(jS), this.ehh.uri);
        C4990ab.m7416i("MicroMsg.NetSceneAdClick", "snsId:" + j + " viewId:" + str + " clickPos:" + i + " clickAction:" + i2 + " sceneType:" + i3 + " descXml:" + str2 + " adtype:" + i4 + " snsStatStr:" + str3 + " flipStatus:" + i5 + " remind_source_info.length:" + String.valueOf(c1332b != null ? c1332b.f1226wR.length : 0) + " remind_self_info.length:" + String.valueOf(c1332b2 != null ? c1332b2.f1226wR.length : 0));
        C30169bh c30169bh = (C30169bh) this.ehh.fsG.fsP;
        c30169bh.vDs = i;
        c30169bh.qEg = str;
        c30169bh.scene = i3;
        c30169bh.vDt = str2;
        c30169bh.bssid = C5023at.m7475gF(C4996ah.getContext());
        c30169bh.ssid = C5023at.m7474gE(C4996ah.getContext());
        c30169bh.vDu = System.currentTimeMillis();
        c30169bh.vDw = i4;
        c30169bh.vDx = i2;
        c30169bh.cvd = jS;
        c30169bh.vDy = str3;
        c30169bh.vDz = i5;
        if (c1332b2 != null) {
            c30169bh.vDB = c1332b2;
        }
        if (c1332b != null) {
            c30169bh.vDA = c1332b;
        }
        AppMethodBeat.m2505o(94483);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(94484);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(94484);
        return a;
    }

    public final int getType() {
        return 1232;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(94485);
        C4990ab.m7410d("MicroMsg.NetSceneAdClick", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(94485);
    }
}
