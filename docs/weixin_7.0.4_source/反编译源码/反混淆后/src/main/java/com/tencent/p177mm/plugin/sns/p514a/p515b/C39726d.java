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
import com.tencent.p177mm.protocal.protobuf.C40504bn;
import com.tencent.p177mm.protocal.protobuf.C44104bl;
import com.tencent.p177mm.protocal.protobuf.C46528bm;
import com.tencent.p177mm.protocal.protobuf.C46529bo;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;

/* renamed from: com.tencent.mm.plugin.sns.a.b.d */
public final class C39726d extends C1207m implements C1918k {
    private C7472b ehh;
    public C1202f ehi;

    public C39726d(String str, int i, C46529bo c46529bo, int i2, int i3, int i4, C1332b c1332b, C1332b c1332b2) {
        this(str, i, 1, 0, null, c46529bo, i2, "", i3, i4, 0, 0, 0, c1332b, c1332b2);
    }

    public C39726d(String str, int i, int i2, int i3, C44104bl c44104bl, C46529bo c46529bo, int i4, String str2, int i5, int i6, int i7, int i8, int i9, C1332b c1332b, C1332b c1332b2) {
        int i10;
        AppMethodBeat.m2504i(35705);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C46528bm();
        c1196a.fsK = new C40504bn();
        if (i6 != 2) {
            c1196a.uri = "/cgi-bin/mmoc-bin/ad/exposure";
            c1196a.fsI = 1231;
        } else {
            c1196a.uri = "/cgi-bin/mmux-bin/adexposure";
            c1196a.fsI = 1875;
        }
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        C4990ab.m7417i("MicroMsg.NetSceneAdExposure", "uri %s", this.ehh.uri);
        C46528bm c46528bm = (C46528bm) this.ehh.fsG.fsP;
        c46528bm.vDK = i3;
        c46528bm.type = i2;
        c46528bm.scene = i;
        c46528bm.qEg = str;
        c46528bm.vDN = i5;
        c46528bm.vDO = i7;
        c46528bm.vDP = i8;
        c46528bm.vDz = i9;
        if (c44104bl != null) {
            c46528bm.vDL = c44104bl;
            C4990ab.m7416i("MicroMsg.NetSceneAdExposure", "exposure_info " + c44104bl.vDI);
        }
        if (c46529bo != null) {
            c46528bm.vDM = c46529bo;
            C4990ab.m7416i("MicroMsg.NetSceneAdExposure", "social_info " + c46529bo.vDR + " " + c46529bo.vDQ);
        }
        c46528bm.bssid = C5023at.m7475gF(C4996ah.getContext());
        c46528bm.ssid = C5023at.m7474gE(C4996ah.getContext());
        c46528bm.vDu = System.currentTimeMillis();
        c46528bm.vDw = i4;
        if (str2 != null) {
            c46528bm.vDt = str2;
        }
        if (c1332b2 != null) {
            c46528bm.vDB = c1332b2;
        }
        if (c1332b != null) {
            c46528bm.vDA = c1332b;
        }
        String str3 = "MicroMsg.NetSceneAdExposure";
        StringBuilder append = new StringBuilder("##viewid:").append(str).append(" scene:").append(i).append(" exposureScene:").append(i2).append(" duration:").append(i3).append(" feed_duration:").append(i7).append(" feed_full_duration:").append(i8).append(" ad_type:").append(i4).append(" exposureCount:").append(i5).append(" descXml:").append(str2).append(" flip_status:").append(i9).append(" self_info.length:");
        if (c1332b2 == null) {
            i10 = 0;
        } else {
            i10 = c1332b2.f1226wR.length;
        }
        append = append.append(i10).append(" source_info.length:");
        if (c1332b == null) {
            i10 = 0;
        } else {
            i10 = c1332b.f1226wR.length;
        }
        C4990ab.m7416i(str3, append.append(i10).toString());
        AppMethodBeat.m2505o(35705);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(35706);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(35706);
        return a;
    }

    public final int getType() {
        return 1231;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(35707);
        C4990ab.m7416i("MicroMsg.NetSceneAdExposure", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        C40504bn c40504bn = (C40504bn) this.ehh.fsH.fsP;
        C4990ab.m7416i("MicroMsg.NetSceneAdExposure", "resp " + c40504bn.ret + " msg: " + c40504bn.bzH);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(35707);
    }
}
