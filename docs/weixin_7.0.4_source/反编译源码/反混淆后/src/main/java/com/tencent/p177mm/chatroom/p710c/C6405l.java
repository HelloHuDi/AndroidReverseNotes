package com.tencent.p177mm.chatroom.p710c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.arw;
import com.tencent.p177mm.protocal.protobuf.arx;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.chatroom.c.l */
public final class C6405l extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi = null;

    public final int getType() {
        return 339;
    }

    public C6405l(String str) {
        AppMethodBeat.m2504i(103937);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new arw();
        c1196a.fsK = new arx();
        c1196a.uri = "/cgi-bin/micromsg-bin/grantbigchatroom";
        c1196a.fsI = 339;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        ((arw) this.ehh.fsG.fsP).ndF = str;
        C4990ab.m7410d("MicroMsg.NetSceneGrantBigChatRoom", "grant to userName :".concat(String.valueOf(str)));
        AppMethodBeat.m2505o(103937);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(103938);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(103938);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(103939);
        C4990ab.m7410d("MicroMsg.NetSceneGrantBigChatRoom", "onGYNetEnd " + i2 + " " + i3 + "  " + str);
        if (i2 == 0 && i3 == 0) {
            int intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(135176, Integer.valueOf(0))).intValue();
            if (intValue - 1 >= 0) {
                C1720g.m3536RP().mo5239Ry().set(135176, Integer.valueOf(intValue - 1));
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(103939);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(103939);
    }
}
