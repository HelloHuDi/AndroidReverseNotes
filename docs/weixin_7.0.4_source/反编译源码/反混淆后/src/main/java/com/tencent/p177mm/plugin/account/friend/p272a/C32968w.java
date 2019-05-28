package com.tencent.p177mm.plugin.account.friend.p272a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C15353jj;
import com.tencent.p177mm.protocal.protobuf.C46556ji;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.account.friend.a.w */
public final class C32968w extends C1207m implements C1918k {
    public static int gvL = 0;
    public static int gvM = 1;
    public static int gvN = -85;
    private final C7472b ehh;
    private C1202f ehi;
    private int gvO = -1;
    private String gvP;
    private int gvQ = 0;

    /* renamed from: com.tencent.mm.plugin.account.friend.a.w$a */
    public enum C1993a {
        MM_BIND_GCONTACT_OPCODE_BIND,
        MM_BIND_GCONTACT_OPCODE_UNBIND;

        static {
            AppMethodBeat.m2505o(108424);
        }
    }

    public C32968w(C1993a c1993a, String str, int i) {
        AppMethodBeat.m2504i(108425);
        switch (c1993a) {
            case MM_BIND_GCONTACT_OPCODE_BIND:
                this.gvO = 1;
                break;
            case MM_BIND_GCONTACT_OPCODE_UNBIND:
                this.gvO = 2;
                break;
        }
        this.gvP = str;
        this.gvQ = i;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C46556ji();
        c1196a.fsK = new C15353jj();
        c1196a.uri = "/cgi-bin/micromsg-bin/bindgooglecontact";
        c1196a.fsI = 487;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        AppMethodBeat.m2505o(108425);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(108426);
        C4990ab.m7416i("MicroMsg.GoogleContact.NetSceneInviteGoogleContact", "doScene");
        this.ehi = c1202f;
        C46556ji c46556ji = (C46556ji) this.ehh.fsG.fsP;
        c46556ji.vIJ = this.gvO;
        c46556ji.vLf = this.gvP;
        c46556ji.vLg = this.gvQ;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(108426);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(108427);
        C4990ab.m7417i("MicroMsg.GoogleContact.NetSceneInviteGoogleContact", "NetId:%d, ErrType:%d, ErrCode:%d, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(108427);
    }

    public final int getType() {
        return 487;
    }
}
