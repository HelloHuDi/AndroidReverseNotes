package com.tencent.p177mm.plugin.account.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C40534jh;
import com.tencent.p177mm.protocal.protobuf.C46555jg;

/* renamed from: com.tencent.mm.plugin.account.model.d */
public final class C42285d extends C1207m implements C1918k {
    public static int gyK = 1;
    public static int gyL = 2;
    private C7472b ehh;
    private C1202f ehi;

    public C42285d(int i, String str) {
        AppMethodBeat.m2504i(124676);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C46555jg();
        c1196a.fsK = new C40534jh();
        c1196a.uri = "/cgi-bin/micromsg-bin/bindemail";
        this.ehh = c1196a.acD();
        C46555jg c46555jg = (C46555jg) this.ehh.fsG.fsP;
        c46555jg.OpCode = i;
        c46555jg.vLe = str;
        AppMethodBeat.m2505o(124676);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(124677);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(124677);
        return a;
    }

    public final int getType() {
        return 256;
    }

    /* renamed from: Ah */
    public final int mo67805Ah() {
        return ((C46555jg) this.ehh.fsG.fsP).OpCode;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(124678);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(124678);
    }
}
