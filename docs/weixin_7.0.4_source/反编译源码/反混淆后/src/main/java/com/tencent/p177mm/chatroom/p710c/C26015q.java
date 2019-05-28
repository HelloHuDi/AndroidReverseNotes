package com.tencent.p177mm.chatroom.p710c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.chatroom.p721a.C6822c;
import com.tencent.p177mm.protocal.protobuf.cko;
import com.tencent.p177mm.protocal.protobuf.ckp;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7577u;

/* renamed from: com.tencent.mm.chatroom.c.q */
public final class C26015q extends C1207m implements C1918k {
    public String chatroomName = null;
    public String ehC = null;
    public int ehD = 0;
    public int ehE = 0;
    private final C7472b ehh;
    private C1202f ehi = null;
    public String ehr = null;

    public C26015q(String str) {
        AppMethodBeat.m2504i(103953);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cko();
        c1196a.fsK = new ckp();
        c1196a.uri = "/cgi-bin/micromsg-bin/upgradechatroom";
        c1196a.fsI = 482;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        this.chatroomName = str;
        ((cko) this.ehh.fsG.fsP).vEf = str;
        AppMethodBeat.m2505o(103953);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(103954);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(103954);
        return a;
    }

    public final int getType() {
        return 482;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(103955);
        ckp ckp = (ckp) this.ehh.fsH.fsP;
        C4990ab.m7411d("MicroMsg.NetSceneUpgradeChatroom", "NetSceneUpgradeChatroom onGYNetEnd errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehC = ckp.wGj;
        if (!C5046bo.isNullOrNil(this.ehC)) {
            C7577u oa = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14885oa(this.chatroomName);
            if (oa == null) {
                oa = new C7577u();
            }
            oa.mo16805ib(C1853r.m3846Yz(), this.ehC);
            C37921n.m64050a(oa);
        }
        this.ehr = ckp.wnK;
        this.ehD = ckp.wnJ;
        this.ehE = ckp.wnL;
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(103955);
    }
}
