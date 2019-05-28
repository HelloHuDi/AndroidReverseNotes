package com.tencent.p177mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p612ui.p1094i.C15898a;
import com.tencent.p177mm.protocal.protobuf.bkv;
import com.tencent.p177mm.protocal.protobuf.bkw;
import com.tencent.p177mm.protocal.protobuf.civ;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.modelmulti.g */
public final class C18665g extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;
    private int fHT = 0;

    public C18665g(int i, String str) {
        AppMethodBeat.m2504i(16500);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bkv();
        c1196a.fsK = new bkw();
        c1196a.uri = "/cgi-bin/micromsg-bin/postinvitefriendsmsg";
        c1196a.fsI = 1804;
        this.ehh = c1196a.acD();
        bkv bkv = (bkv) this.ehh.fsG.fsP;
        bkv.wpw = i;
        bkv.wpy = str;
        if ((i & 16) > 0) {
            C15898a c15898a = new C15898a();
            civ civ = new civ();
            if (c15898a.zKU == null) {
                civ = null;
            } else if (!C5046bo.isNullOrNil(c15898a.zKU.token)) {
                civ.xhJ = c15898a.zKU.token;
                civ.xhK = c15898a.zKU.wFn;
            }
            bkv.wNQ = civ;
        }
        this.fHT = i;
        AppMethodBeat.m2505o(16500);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(16501);
        C4990ab.m7410d("MicroMsg.NetScenePostInviteFriendsMsg", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(16501);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(16501);
    }

    public final int getType() {
        return 1804;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(16502);
        C4990ab.m7410d("MicroMsg.NetScenePostInviteFriendsMsg", "doScene");
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(16502);
        return a;
    }
}
