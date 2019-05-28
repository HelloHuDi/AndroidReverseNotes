package com.tencent.p177mm.chatroom.p710c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.protocal.protobuf.C35910cb;
import com.tencent.p177mm.protocal.protobuf.C40506ca;
import com.tencent.p177mm.protocal.protobuf.bay;
import com.tencent.p177mm.protocal.protobuf.baz;
import com.tencent.p177mm.roomsdk.p1086a.C15409a;
import com.tencent.p177mm.roomsdk.p1086a.p1341b.C44205c;
import com.tencent.p177mm.roomsdk.p1086a.p1341b.C46609a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.chatroom.c.e */
public final class C32437e extends C15409a implements C1918k {
    private int cEX = 0;
    public final List<String> cFX;
    private final List<String> cGa;
    private final List<String> cGc;
    private final List<String> cGd;
    private String chatroomName = null;
    private final C7472b ehh;
    private C1202f ehi = null;
    private final List<String> ehj;
    private final List<String> ehk;
    private final List<String> ehl;

    public C32437e(String str, List<String> list, String str2) {
        AppMethodBeat.m2504i(103910);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C40506ca();
        c1196a.fsK = new C35910cb();
        c1196a.uri = "/cgi-bin/micromsg-bin/addchatroommember";
        c1196a.fsI = 120;
        c1196a.fsL = 36;
        c1196a.fsM = 1000000036;
        this.ehh = c1196a.acD();
        C40506ca c40506ca = (C40506ca) this.ehh.fsG.fsP;
        c40506ca.vEi = C1946aa.m4154vy(str);
        this.chatroomName = str;
        LinkedList linkedList = new LinkedList();
        for (String str3 : list) {
            bay bay = new bay();
            bay.wcG = C1946aa.m4154vy(str3);
            linkedList.add(bay);
        }
        c40506ca.vEh = linkedList;
        c40506ca.ehB = linkedList.size();
        this.ehj = new ArrayList();
        this.cGa = new LinkedList();
        this.ehk = new LinkedList();
        this.cGc = new LinkedList();
        this.cGd = new LinkedList();
        this.ehl = new ArrayList();
        this.cFX = list;
        c40506ca.vEk = str2;
        AppMethodBeat.m2505o(103910);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(103911);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(103911);
        return a;
    }

    public final int getType() {
        return 120;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(103912);
        C40506ca c40506ca = (C40506ca) this.ehh.fsG.fsP;
        C35910cb c35910cb = (C35910cb) this.ehh.fsH.fsP;
        this.cEX = c35910cb.ehB;
        LinkedList linkedList = c35910cb.vEh;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= linkedList.size()) {
                break;
            }
            i4 = ((baz) linkedList.get(i5)).wFJ;
            if (i4 == 0) {
                this.ehj.add(C1946aa.m4148a(((baz) linkedList.get(i5)).wcG));
            } else if (i4 == 3) {
                C4990ab.m7410d("MicroMsg.NetSceneAddChatRoomMember", " blacklist : " + ((baz) linkedList.get(i5)).wcG);
                this.ehk.add(C1946aa.m4148a(((baz) linkedList.get(i5)).wcG));
            } else if (i4 == 1) {
                C4990ab.m7410d("MicroMsg.NetSceneAddChatRoomMember", " not user : " + ((baz) linkedList.get(i5)).wcG);
                this.cGc.add(C1946aa.m4148a(((baz) linkedList.get(i5)).wcG));
            } else if (i4 == 2) {
                C4990ab.m7410d("MicroMsg.NetSceneAddChatRoomMember", " invalid username : " + ((baz) linkedList.get(i5)).wcG);
                this.cGa.add(C1946aa.m4148a(((baz) linkedList.get(i5)).wcG));
            } else if (i4 == 4) {
                C4990ab.m7410d("MicroMsg.NetSceneAddChatRoomMember", " verify user : " + ((baz) linkedList.get(i5)).wcG);
                this.cGd.add(C1946aa.m4148a(((baz) linkedList.get(i5)).wcG));
            } else if (i4 != 5) {
                if (i4 == 6) {
                    this.ehl.add(C1946aa.m4148a(((baz) linkedList.get(i5)).wcG));
                } else {
                    C4990ab.m7420w("MicroMsg.NetSceneAddChatRoomMember", "unknown member status : status = ".concat(String.valueOf(i4)));
                }
            }
            i4 = i5 + 1;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        if (i2 == 0 && i3 == 0) {
            C37921n.m64051a(C1946aa.m4148a(c40506ca.vEi), c35910cb);
        }
        AppMethodBeat.m2505o(103912);
    }

    /* renamed from: a */
    public final C46609a mo27452a(C46609a c46609a) {
        if (!(c46609a instanceof C44205c)) {
            return c46609a;
        }
        C44205c c44205c = (C44205c) c46609a;
        c44205c.chatroomName = this.chatroomName;
        c44205c.cGa = this.cGa;
        c44205c.cEX = this.cEX;
        c44205c.cFX = this.cFX;
        c44205c.ehk = this.ehk;
        c44205c.ehj = this.ehj;
        c44205c.cGc = this.cGc;
        c44205c.ehl = this.ehl;
        c44205c.cGd = this.cGd;
        return c44205c;
    }
}
