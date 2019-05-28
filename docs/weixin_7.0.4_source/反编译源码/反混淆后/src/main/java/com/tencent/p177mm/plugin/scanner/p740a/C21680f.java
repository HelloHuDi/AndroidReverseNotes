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
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.ben;
import com.tencent.p177mm.protocal.protobuf.beo;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.scanner.a.f */
public final class C21680f extends C1207m implements C1918k {
    private int ctE;
    private int eCW = 1;
    public C7472b ehh;
    private C1202f ehi;
    private byte[] pZD;
    private String pZE = "en";
    private String pZF = "zh_CN";

    public C21680f(byte[] bArr, String str, String str2, int i) {
        this.pZD = bArr;
        this.eCW = 1;
        this.pZE = str;
        this.pZF = str2;
        this.ctE = i;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(80840);
        this.ehi = c1202f;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new ben();
        c1196a.fsK = new beo();
        c1196a.uri = "/cgi-bin/micromsg-bin/ocrtranslation";
        c1196a.fsI = 392;
        c1196a.fsL = 199;
        c1196a.fsM = 1000000199;
        this.ehh = c1196a.acD();
        ben ben = (ben) this.ehh.fsG.fsP;
        ben.vOn = ((int) C5046bo.anU()) & BaseClientBuilder.API_PRIORITY_OTHER;
        ben.vOo = new SKBuiltinBuffer_t().setBuffer(this.pZD);
        ben.vOr = this.eCW;
        ben.wID = this.pZE;
        ben.wIE = this.pZF;
        ben.vOs = this.ctE;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(80840);
        return a;
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        AppMethodBeat.m2504i(80841);
        ben ben = (ben) ((C7472b) c1929q).fsG.fsP;
        C1206b c1206b;
        if (ben.vOn <= 0 || C5046bo.isNullOrNil(ben.wIE) || C5046bo.isNullOrNil(ben.wID) || ben.vOr < 0 || ben.vOo == null || ben.vOo.getILen() <= 0) {
            C4990ab.m7412e("MicroMsg.scanner.NetSceneOCRTranslate", "ERR: Security Check Failed");
            c1206b = C1206b.EFailed;
            AppMethodBeat.m2505o(80841);
            return c1206b;
        }
        c1206b = C1206b.EOk;
        AppMethodBeat.m2505o(80841);
        return c1206b;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(80842);
        C4990ab.m7410d("MicroMsg.scanner.NetSceneOCRTranslate", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(80842);
    }

    public final int getType() {
        return 392;
    }
}
