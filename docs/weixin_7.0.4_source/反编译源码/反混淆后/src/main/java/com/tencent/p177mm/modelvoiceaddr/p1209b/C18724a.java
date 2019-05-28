package com.tencent.p177mm.modelvoiceaddr.p1209b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bsm;
import com.tencent.p177mm.protocal.protobuf.bsn;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.modelvoiceaddr.b.a */
public final class C18724a extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;

    public C18724a(int i, LinkedList<bts> linkedList, bts bts, bts bts2) {
        AppMethodBeat.m2504i(116796);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bsm();
        c1196a.fsK = new bsn();
        c1196a.uri = "/cgi-bin/micromsg-bin/reportvoiceresult";
        this.ehh = c1196a.acD();
        bsm bsm = (bsm) this.ehh.fsG.fsP;
        bsm.wUF = i;
        bsm.wUG = linkedList;
        bsm.wUH = bts;
        bsm.wUI = bts2;
        AppMethodBeat.m2505o(116796);
    }

    public final int getType() {
        return 228;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(116797);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(116797);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(116798);
        C4990ab.m7410d("MicroMsg.NetSceneNewVoiceInputReport", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(116798);
    }
}
