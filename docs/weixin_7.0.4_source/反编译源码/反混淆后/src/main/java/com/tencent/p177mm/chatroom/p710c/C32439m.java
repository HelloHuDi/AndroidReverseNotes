package com.tencent.p177mm.chatroom.p710c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.protocal.protobuf.aut;
import com.tencent.p177mm.protocal.protobuf.auu;
import com.tencent.p177mm.protocal.protobuf.bay;
import com.tencent.p177mm.roomsdk.p1086a.C15409a;
import com.tencent.p177mm.roomsdk.p1086a.p1341b.C44206d;
import com.tencent.p177mm.roomsdk.p1086a.p1341b.C46609a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7620bi;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.chatroom.c.m */
public final class C32439m extends C15409a implements C1918k {
    public C7620bi cKd;
    public int ehB;
    private final C7472b ehh;
    private C1202f ehi;

    public C32439m(String str, List<String> list) {
        AppMethodBeat.m2504i(103940);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new aut();
        c1196a.fsK = new auu();
        c1196a.uri = "/cgi-bin/micromsg-bin/invitechatroommember";
        this.ehh = c1196a.acD();
        aut aut = (aut) this.ehh.fsG.fsP;
        LinkedList linkedList = new LinkedList();
        for (String str2 : list) {
            bay bay = new bay();
            bay.wcG = C1946aa.m4154vy(str2);
            linkedList.add(bay);
        }
        aut.vEh = linkedList;
        aut.ehB = linkedList.size();
        aut.vEi = C1946aa.m4154vy(str);
        aut.wyV = 0;
        AppMethodBeat.m2505o(103940);
    }

    public C32439m(String str, List<String> list, String str2, C7620bi c7620bi) {
        AppMethodBeat.m2504i(103941);
        this.cKd = c7620bi;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new aut();
        c1196a.fsK = new auu();
        c1196a.uri = "/cgi-bin/micromsg-bin/invitechatroommember";
        this.ehh = c1196a.acD();
        aut aut = (aut) this.ehh.fsG.fsP;
        LinkedList linkedList = new LinkedList();
        for (String str3 : list) {
            bay bay = new bay();
            bay.wcG = C1946aa.m4154vy(str3);
            linkedList.add(bay);
        }
        this.ehB = linkedList.size();
        aut.vEh = linkedList;
        aut.ehB = linkedList.size();
        aut.vEi = C1946aa.m4154vy(str);
        aut.wyV = 2;
        aut.wyW = str2;
        AppMethodBeat.m2505o(103941);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(103942);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(103942);
        return a;
    }

    public final int getType() {
        return 610;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(103943);
        C4990ab.m7410d("MicroMsg.NetSceneInviteChatRoomMember", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(103943);
    }

    /* renamed from: a */
    public final C46609a mo27452a(C46609a c46609a) {
        if (!(c46609a instanceof C44206d)) {
            return c46609a;
        }
        C44206d c44206d = (C44206d) c46609a;
        c44206d.ehB = this.ehB;
        c44206d.xuW = this.cKd;
        return c44206d;
    }
}
