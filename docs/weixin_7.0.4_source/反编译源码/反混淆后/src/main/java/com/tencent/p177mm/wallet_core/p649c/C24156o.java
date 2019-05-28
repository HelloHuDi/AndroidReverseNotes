package com.tencent.p177mm.wallet_core.p649c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.pluginsdk.wallet.C30158b.C30159a;
import com.tencent.p177mm.protocal.protobuf.bvz;
import com.tencent.p177mm.protocal.protobuf.bwa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Map;

/* renamed from: com.tencent.mm.wallet_core.c.o */
public final class C24156o extends C1207m implements C1918k {
    private C30159a AfA;
    private int Afz = 2632;
    private final C7472b ehh;
    private C1202f ehi;

    public C24156o(Map<String, Object> map, String str, String str2, int i, C30159a c30159a) {
        AppMethodBeat.m2504i(49069);
        C4990ab.m7416i("MicroMsg.NetSceneJSAPISecureTunnel", "new pay sercuretunnel netscene url :" + str + " appid: " + str2);
        this.AfA = c30159a;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bvz();
        c1196a.fsK = new bwa();
        c1196a.uri = "/cgi-bin/mmpay-bin/securetunnel";
        c1196a.fsI = this.Afz;
        if (map.containsKey("timeout")) {
            c1196a.azs = ((Integer) map.get("timeout")).intValue();
        }
        this.ehh = c1196a.acD();
        bvz bvz = (bvz) this.ehh.fsG.fsP;
        bvz.wWO = (String) map.get("reqbuf");
        bvz.wap = (String) map.get("cmd");
        bvz.url = str;
        bvz.csB = str2;
        bvz.scene = i;
        bvz.cvd = 0;
        AppMethodBeat.m2505o(49069);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(49070);
        C4990ab.m7416i("MicroMsg.NetSceneJSAPISecureTunnel", "onGYNetEnd, netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (this.AfA != null) {
            C4990ab.m7416i("MicroMsg.NetSceneJSAPISecureTunnel", "secureTunnel callback");
            if (i2 == 0 && i3 == 0) {
                C4990ab.m7416i("MicroMsg.NetSceneJSAPISecureTunnel", "secureTunnel callback success");
                this.AfA.onSuccess(((bwa) this.ehh.fsH.fsP).wWP);
            } else {
                C4990ab.m7416i("MicroMsg.NetSceneJSAPISecureTunnel", "secureTunnel callback fail");
                this.AfA.mo34551BD(str);
            }
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(49070);
    }

    public final int getType() {
        return this.Afz;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(49071);
        this.ehi = c1202f;
        C4990ab.m7410d("MicroMsg.NetSceneJSAPISecureTunnel", "doScene");
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(49071);
        return a;
    }
}
