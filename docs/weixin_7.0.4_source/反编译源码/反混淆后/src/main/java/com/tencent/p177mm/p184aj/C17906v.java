package com.tencent.p177mm.p184aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.protocal.protobuf.awv;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.aj.v */
public final class C17906v extends C1207m implements C1918k {
    public C7472b ehh;
    private C1202f ehi;
    public String fwO;

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(11453);
        C4990ab.m7417i("MicroMsg.NetSceneKFGetDefaultList", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(11453);
    }

    public final int getType() {
        return 672;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(11454);
        this.ehi = c1202f;
        C4990ab.m7416i("MicroMsg.NetSceneKFGetDefaultList", "do scene");
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(11454);
        return a;
    }

    public final awv aeN() {
        if (this.ehh == null || this.ehh.fsH.fsP == null) {
            return null;
        }
        return (awv) this.ehh.fsH.fsP;
    }
}
