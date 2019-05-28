package com.tencent.p177mm.chatroom.p710c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C23445tl;
import com.tencent.p177mm.protocal.protobuf.C40574tk;
import com.tencent.p177mm.protocal.protobuf.arz;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.chatroom.c.f */
public final class C37638f extends C1207m implements C1918k {
    private LinkedList<arz> cFS;
    private final C7472b ehh;
    private C1202f ehi;

    public C37638f(LinkedList<arz> linkedList) {
        AppMethodBeat.m2504i(103913);
        this.cFS = linkedList;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C40574tk();
        c1196a.fsK = new C23445tl();
        c1196a.uri = "/cgi-bin/micromsg-bin/collectchatroom";
        this.ehh = c1196a.acD();
        C40574tk c40574tk = (C40574tk) this.ehh.fsG.fsP;
        c40574tk.waB = linkedList;
        c40574tk.waA = linkedList.size();
        AppMethodBeat.m2505o(103913);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(103914);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(103914);
        return a;
    }

    public final int getType() {
        return 181;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(103915);
        C4990ab.m7410d("MicroMsg.NetSceneCollectChatRoom", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (c1929q.mo5618ZS().vyl != 0) {
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(103915);
            return;
        }
        if (this.cFS != null) {
            Iterator it = this.cFS.iterator();
            while (it.hasNext()) {
                arz arz = (arz) it.next();
                C4990ab.m7410d("MicroMsg.NetSceneCollectChatRoom", "del groupcard Name :" + arz.wvO);
                C37921n.m64071mv(arz.wvO);
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(103915);
    }
}
