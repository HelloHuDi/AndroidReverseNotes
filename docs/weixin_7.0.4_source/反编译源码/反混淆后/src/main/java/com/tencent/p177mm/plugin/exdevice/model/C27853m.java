package com.tencent.p177mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.exdevice.p1611j.C42992b;
import com.tencent.p177mm.plugin.exdevice.p956h.C11648b;
import com.tencent.p177mm.protocal.protobuf.C7543js;
import com.tencent.p177mm.protocal.protobuf.C7544jt;
import com.tencent.p177mm.protocal.protobuf.asq;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.exdevice.model.m */
public final class C27853m extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;
    private String ltA;
    private long ltB;
    private String ltC;
    private long ltD;

    public C27853m(long j, String str, String str2, long j2) {
        this.ltB = j;
        this.ltC = str;
        this.ltA = str2;
        this.ltD = j2;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(19317);
        C4990ab.m7416i("MicroMsg.NetSceneBindUnauthDevice", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        if (i2 == 0 && i3 == 0) {
            Object obj;
            C7544jt c7544jt = (C7544jt) this.ehh.fsH.fsP;
            asq asq = c7544jt.vLi;
            String str2 = null;
            String str3 = null;
            if (asq != null) {
                str2 = asq.jBE;
                str3 = asq.vIk;
            }
            C4990ab.m7411d("MicroMsg.NetSceneBindUnauthDevice", "unauth bind deviceId = %s, deviceType = %s", str2, str3);
            if (C45891ad.boW().mo45707dT(str3, str2) != null) {
                C4990ab.m7417i("MicroMsg.NetSceneBindUnauthDevice", "delete local deviceinfo : %s, ret : %b", str3, Boolean.valueOf(C45891ad.boW().mo45708dU(str2, str3)));
                if (C45891ad.boW().mo45708dU(str2, str3)) {
                    obj = 1;
                } else {
                    obj = null;
                }
            } else {
                obj = 1;
            }
            C11648b c11648b = new C11648b();
            c11648b.field_connProto = this.ltA;
            c11648b.field_connStrategy = 1;
            c11648b.field_closeStrategy = 1;
            c11648b.field_url = "";
            C27852f.m44277a(c11648b, asq, c7544jt.vLj);
            if (c11648b.field_mac == 0) {
                C4990ab.m7410d("MicroMsg.NetSceneBindUnauthDevice", "onSceneEnd, mac of hardDeviceAttr is 0 so set a local mac.");
                c11648b.field_mac = this.ltB;
            }
            if (obj != null) {
                C45891ad.boW().mo10101b((C4925c) c11648b);
            } else {
                C45891ad.boW().mo45709e(c11648b);
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(19317);
    }

    public final int getType() {
        return 1262;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(19318);
        this.ehi = c1202f;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C7543js();
        c1196a.fsK = new C7544jt();
        c1196a.uri = "/cgi-bin/mmoc-bin/hardware/bindunauthdevice";
        c1196a.fsI = 1262;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        C7543js c7543js = (C7543js) this.ehh.fsG.fsP;
        c7543js.mac = C42992b.m76359if(this.ltB);
        c7543js.vMh = this.ltC;
        c7543js.vMg = this.ltA;
        c7543js.vMi = this.ltD;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(19318);
        return a;
    }
}
