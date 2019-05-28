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
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.protocal.protobuf.C15393vj;
import com.tencent.p177mm.protocal.protobuf.C15394vt;
import com.tencent.p177mm.protocal.protobuf.C7555vk;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.chatroom.c.h */
public final class C6399h extends C1207m implements C1918k {
    public List<String> cFX;
    private C7472b ehh;
    private C1202f ehi;

    public C6399h(String str, List<String> list, int i) {
        AppMethodBeat.m2504i(103922);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C15393vj();
        c1196a.fsK = new C7555vk();
        c1196a.uri = "/cgi-bin/micromsg-bin/delchatroommember";
        this.ehh = c1196a.acD();
        C15393vj c15393vj = (C15393vj) this.ehh.fsG.fsP;
        c15393vj.vEf = str;
        LinkedList linkedList = new LinkedList();
        for (String str2 : list) {
            C15394vt c15394vt = new C15394vt();
            c15394vt.wcG = C1946aa.m4154vy(str2);
            linkedList.add(c15394vt);
        }
        c15393vj.vEh = linkedList;
        c15393vj.ehB = linkedList.size();
        c15393vj.Scene = i;
        this.cFX = list;
        AppMethodBeat.m2505o(103922);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(103923);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(103923);
        return a;
    }

    public final int getType() {
        return 179;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(103924);
        C4990ab.m7410d("MicroMsg.NetSceneDelChatRoomMember", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        C15393vj c15393vj = (C15393vj) this.ehh.fsG.fsP;
        C7555vk c7555vk = (C7555vk) this.ehh.fsH.fsP;
        if (this.ehh.fsH.vyl != 0) {
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(103924);
            return;
        }
        C37921n.m64053a(c15393vj.vEf, c7555vk);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(103924);
    }
}
