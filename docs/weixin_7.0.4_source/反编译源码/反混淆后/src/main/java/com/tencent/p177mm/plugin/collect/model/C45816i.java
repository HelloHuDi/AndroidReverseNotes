package com.tencent.p177mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.protocal.protobuf.C15371pa;
import com.tencent.p177mm.protocal.protobuf.C35944oz;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.collect.model.i */
public final class C45816i extends C1207m implements C1918k {
    public String cva;
    public long cvc;
    public int cvd;
    private C1202f ehi;
    private C7472b gme;
    public C15371pa kCf;
    public long kCg;
    private long kCh;

    public C45816i(int i, C1332b c1332b, String str, int i2, long j) {
        AppMethodBeat.m2504i(40967);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C35944oz();
        c1196a.fsK = new C15371pa();
        c1196a.uri = "/cgi-bin/mmpay-bin/getf2frcvvoice";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.gme = c1196a.acD();
        C35944oz c35944oz = (C35944oz) this.gme.fsG.fsP;
        c35944oz.nUf = i;
        c35944oz.vWi = 0;
        c35944oz.kCK = str;
        c35944oz.vWg = null;
        c35944oz.vWh = c1332b;
        this.cva = str;
        this.cvd = i2;
        this.cvc = j;
        this.kCh = System.currentTimeMillis();
        C4990ab.m7417i("MicroMsg.NetSceneF2FRcvVoice", "amount: %d, outtradeno: %s", Integer.valueOf(i), str);
        AppMethodBeat.m2505o(40967);
    }

    public final int getType() {
        return 1384;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(40968);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.gme, this);
        AppMethodBeat.m2505o(40968);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(40969);
        C4990ab.m7417i("MicroMsg.NetSceneF2FRcvVoice", "errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.kCf = (C15371pa) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneF2FRcvVoice", "ret_code: %d, ret_msg: %s，voice_type: %d", Integer.valueOf(this.kCf.kCl), this.kCf.kCm, Integer.valueOf(this.kCf.vWi));
        this.kCg = System.currentTimeMillis() - this.kCh;
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(40969);
    }
}
