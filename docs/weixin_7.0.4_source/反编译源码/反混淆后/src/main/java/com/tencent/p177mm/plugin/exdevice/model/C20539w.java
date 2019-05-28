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
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.asq;
import com.tencent.p177mm.protocal.protobuf.asu;
import com.tencent.p177mm.protocal.protobuf.bwh;
import com.tencent.p177mm.protocal.protobuf.bwi;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.exdevice.model.w */
public final class C20539w extends C1207m implements C1918k {
    private C1202f eIc = null;
    String ltH;
    public C7472b lty = null;

    public C20539w(long j, String str, String str2, long j2, long j3, byte[] bArr, int i) {
        AppMethodBeat.m2504i(19347);
        C4990ab.m7417i("MicroMsg.exdevice.NetSceneSendHardDeviceMsg", "NetSceneSendHardDeviceMsg deviceType = %s, deviceId = %s, sessionId = %d, createTime = %d, data length = %d, msgType = %d", str, str2, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(bArr.length), Integer.valueOf(i));
        this.ltH = str2;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bwh();
        c1196a.fsK = new bwi();
        c1196a.fsI = 538;
        c1196a.uri = "/cgi-bin/micromsg-bin/sendharddevicemsg";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.lty = c1196a.acD();
        bwh bwh = (bwh) this.lty.fsG.fsP;
        asq asq = new asq();
        asq.vIk = str;
        asq.jBE = str2;
        bwh.vLi = asq;
        asu asu = new asu();
        asu.wwE = j2;
        asu.pcX = (int) j3;
        asu.vJd = new SKBuiltinBuffer_t().setBuffer(bArr);
        asu.jCt = i;
        bwh.wWW = asu;
        if (j != 0) {
            bwh.wwz = new SKBuiltinBuffer_t().setBuffer(C20548u.bpx().mo45726o(j, 2));
            AppMethodBeat.m2505o(19347);
            return;
        }
        C11648b Kv = C45891ad.boW().mo45701Kv(str2);
        if (Kv != null) {
            bwh.wwz = new SKBuiltinBuffer_t().setBuffer(Kv.field_sessionBuf);
        }
        AppMethodBeat.m2505o(19347);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(19348);
        C4990ab.m7416i("MicroMsg.exdevice.NetSceneSendHardDeviceMsg", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        this.eIc.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(19348);
    }

    public final int getType() {
        return 538;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(19349);
        this.eIc = c1202f;
        int a = mo4457a(c1902e, this.lty, this);
        AppMethodBeat.m2505o(19349);
        return a;
    }
}
