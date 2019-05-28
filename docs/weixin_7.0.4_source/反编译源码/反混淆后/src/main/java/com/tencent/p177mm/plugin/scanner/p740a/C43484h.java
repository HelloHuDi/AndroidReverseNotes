package com.tencent.p177mm.plugin.scanner.p740a;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C23411ky;
import com.tencent.p177mm.protocal.protobuf.C7545kz;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.FilterEnum4Shaka;

/* renamed from: com.tencent.mm.plugin.scanner.a.h */
public final class C43484h extends C1207m implements C1918k {
    private int ctE;
    private int eCW = 1;
    public C7472b ehh;
    private C1202f ehi;
    private int frO;
    private int offset;
    private byte[] pZD;

    public C43484h(byte[] bArr, int i, int i2) {
        this.pZD = bArr;
        this.eCW = 1;
        this.frO = i;
        this.offset = 0;
        this.ctE = i2;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(80847);
        this.ehi = c1202f;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C23411ky();
        c1196a.fsK = new C7545kz();
        c1196a.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanimg";
        c1196a.fsI = FilterEnum4Shaka.MIC_WEISHI_HUAYE;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        C23411ky c23411ky = (C23411ky) this.ehh.fsG.fsP;
        c23411ky.vOn = ((int) C5046bo.anU()) & BaseClientBuilder.API_PRIORITY_OTHER;
        c23411ky.vOo = new SKBuiltinBuffer_t().setBuffer(this.pZD);
        c23411ky.vOp = this.frO;
        c23411ky.vOq = this.offset;
        if (this.offset + this.pZD.length < this.frO) {
            c23411ky.fJT = 0;
        } else {
            c23411ky.fJT = 1;
        }
        c23411ky.vOr = this.eCW;
        c23411ky.vOs = this.ctE;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(80847);
        return a;
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        AppMethodBeat.m2504i(80848);
        C23411ky c23411ky = (C23411ky) ((C7472b) c1929q).fsG.fsP;
        C1206b c1206b;
        if (c23411ky.vOn <= 0 || c23411ky.vOr < 0 || c23411ky.vOo == null || c23411ky.vOo.getILen() <= 0 || c23411ky.vOp <= 0 || c23411ky.vOq < 0 || c23411ky.vOq + c23411ky.vOo.getILen() > c23411ky.vOp) {
            C4990ab.m7413e("MicroMsg.scanner.NetSceneScanImage", "ERR: Security Check Failed, imageType = %s, totalLen = %s, offset = %s", Integer.valueOf(c23411ky.vOr), Integer.valueOf(c23411ky.vOp), Integer.valueOf(c23411ky.vOq));
            if (c23411ky.vOo != null) {
                C4990ab.m7413e("MicroMsg.scanner.NetSceneScanImage", "buffer length = %s", Integer.valueOf(c23411ky.vOo.getILen()));
            }
            c1206b = C1206b.EFailed;
            AppMethodBeat.m2505o(80848);
            return c1206b;
        }
        c1206b = C1206b.EOk;
        AppMethodBeat.m2505o(80848);
        return c1206b;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(80849);
        C4990ab.m7410d("MicroMsg.scanner.NetSceneScanImage", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(80849);
    }

    public final int getType() {
        return FilterEnum4Shaka.MIC_WEISHI_HUAYE;
    }
}
