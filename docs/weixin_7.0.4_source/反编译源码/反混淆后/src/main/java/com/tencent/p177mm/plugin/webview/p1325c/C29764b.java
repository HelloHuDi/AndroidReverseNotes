package com.tencent.p177mm.plugin.webview.p1325c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.buy;
import com.tencent.p177mm.protocal.protobuf.buz;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.view.C31128d;

/* renamed from: com.tencent.mm.plugin.webview.c.b */
public final class C29764b extends C1207m implements C1918k {
    private C1202f eIc;
    private final C7472b ehh;
    private long kVE = 0;
    private byte[] kWI = null;
    private String kWK;
    private int kWt;
    int ueW = -1;
    boolean ueX = true;

    public C29764b(int i, String str, byte[] bArr, int i2, long j) {
        AppMethodBeat.m2504i(5658);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new buy();
        c1196a.fsK = new buz();
        c1196a.uri = "/cgi-bin/micromsg-bin/mmsearchemotion";
        c1196a.fsI = C31128d.MIC_PTU_FENGJING;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        this.kWt = i;
        this.kWK = str;
        this.kWI = bArr;
        this.ueW = i2;
        this.kVE = j;
        AppMethodBeat.m2505o(5658);
    }

    public final int getType() {
        return C31128d.MIC_PTU_FENGJING;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(5659);
        this.eIc = c1202f;
        buy buy = (buy) this.ehh.fsG.fsP;
        if (C5046bo.m7540cb(this.kWI)) {
            buy.wok = new SKBuiltinBuffer_t();
            this.ueX = true;
        } else {
            buy.wok = C1946aa.m4152ad(this.kWI);
            this.ueX = false;
            buy.won = this.kVE;
        }
        C4990ab.m7410d("MicroMsg.emoji.NetSceneSearchEmotion", buy.wok == null ? "Buf is NULL" : buy.wok.toString());
        buy.ReqType = this.kWt;
        buy.wol = this.kWK;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(5659);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(5660);
        C4990ab.m7417i("MicroMsg.emoji.NetSceneSearchEmotion", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.eIc.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(5660);
    }

    public final buz cWk() {
        if (this.ehh == null) {
            return null;
        }
        return (buz) this.ehh.fsH.fsP;
    }
}
