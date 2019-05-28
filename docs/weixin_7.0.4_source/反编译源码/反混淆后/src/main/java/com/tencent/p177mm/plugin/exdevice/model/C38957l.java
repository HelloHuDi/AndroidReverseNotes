package com.tencent.p177mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.exdevice.p956h.C11648b;
import com.tencent.p177mm.plugin.exdevice.service.C20548u;
import com.tencent.p177mm.plugin.exdevice.service.C27859f;
import com.tencent.p177mm.plugin.exdevice.service.C27859f.C27860a;
import com.tencent.p177mm.protocal.protobuf.C15354jk;
import com.tencent.p177mm.protocal.protobuf.C30196jl;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.exdevice.model.l */
public final class C38957l extends C1207m implements C1918k {
    private C7472b ehh = null;
    private C1202f ehi = null;

    public C38957l(String str, int i) {
        AppMethodBeat.m2504i(19314);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C15354jk();
        c1196a.fsK = new C30196jl();
        c1196a.uri = "/cgi-bin/micromsg-bin/bindharddevice";
        c1196a.fsI = 536;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        C15354jk c15354jk = (C15354jk) this.ehh.fsG.fsP;
        c15354jk.vKK = C5046bo.nullAsNil(str);
        c15354jk.vLh = C5046bo.m7567h(Integer.valueOf(i));
        AppMethodBeat.m2505o(19314);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(19315);
        C4990ab.m7416i("MicroMsg.exdevice.NetSceneBindHardDevice", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        if (i2 == 0 && i3 == 0) {
            C30196jl boP = boP();
            C4990ab.m7417i("MicroMsg.exdevice.NetSceneBindHardDevice", "hardDevice : DeviceIdServer = %s, DeviceType = %s", boP.vLi.jBE, boP.vLi.vIk);
            String str2 = "MicroMsg.exdevice.NetSceneBindHardDevice";
            String str3 = "hardDeviceAttr : AuthKey = %s, BrandName = %s, Mac = %s, connProto = %s, ConnStrategy = %s, bindFlag = %s";
            Object[] objArr = new Object[6];
            objArr[0] = boP.vLj.vHO;
            objArr[1] = boP.vLj.wwm;
            objArr[2] = boP.vLj.vKF;
            objArr[3] = boP.vLj.wwn;
            objArr[4] = Integer.valueOf(boP.vLj.wwo);
            objArr[5] = boP.vEq == 0 ? "sync" : "async";
            C4990ab.m7417i(str2, str3, objArr);
            Object obj = null;
            if (C45891ad.boW().mo45707dT(boP.vLj.wwm, boP.vLi.jBE) != null) {
                C4990ab.m7417i("MicroMsg.exdevice.NetSceneBindHardDevice", "delete local deviceinfo : %s, ret : %b", boP.vLj.wwm, Boolean.valueOf(C45891ad.boW().mo45708dU(boP.vLi.jBE, boP.vLj.wwm)));
                if (C45891ad.boW().mo45708dU(boP.vLi.jBE, boP.vLj.wwm)) {
                    obj = 1;
                }
            } else {
                obj = 1;
            }
            C11648b c11648b = new C11648b();
            C27852f.m44277a(c11648b, boP.vLi, boP.vLj);
            c11648b.field_url = "";
            C27860a hT = C20548u.bpx().mo45721hT(c11648b.field_mac);
            if (hT != null && hT.cxs == 2) {
                C4990ab.m7416i("MicroMsg.exdevice.NetSceneBindHardDevice", "before do bind netscene, stop the channel now");
                C45891ad.bpd();
                C2971d.m5266hH(c11648b.field_mac);
                C27859f bpx = C20548u.bpx();
                long j = c11648b.field_mac;
                if (bpx.lwJ.containsKey(Long.valueOf(j))) {
                    bpx.lwJ.remove(Long.valueOf(j));
                    C4990ab.m7417i("MicroMsg.exdevice.ExdeviceInfoManager", "remove the device from map : %d", Long.valueOf(j));
                } else {
                    C4990ab.m7417i("MicroMsg.exdevice.ExdeviceInfoManager", "device id not contains in the map : %d", Long.valueOf(j));
                }
            }
            if (obj != null) {
                C45891ad.boW().mo10101b((C4925c) c11648b);
            } else {
                C45891ad.boW().mo45709e(c11648b);
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(19315);
    }

    public final int getType() {
        return 536;
    }

    public final C30196jl boP() {
        if (this.ehh == null || this.ehh.fsH.fsP == null) {
            return null;
        }
        return (C30196jl) this.ehh.fsH.fsP;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(19316);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(19316);
        return a;
    }
}
