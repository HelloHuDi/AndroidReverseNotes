package com.tencent.p177mm.plugin.talkroom.p1041b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.aow;
import com.tencent.p177mm.protocal.protobuf.aox;
import com.tencent.p177mm.protocal.protobuf.cgm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.talkroom.b.c */
public final class C39946c extends C29415f {
    private final C7472b ehh;
    private C1202f ehi;
    private final String nNq;
    private int sceneType = 0;
    public int syE;
    public LinkedList<cgm> sza;

    public C39946c(int i, long j, String str, int i2) {
        AppMethodBeat.m2504i(25875);
        this.sceneType = i2;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new aow();
        c1196a.fsK = new aox();
        c1196a.uri = "/cgi-bin/micromsg-bin/gettalkroommember";
        c1196a.fsI = 336;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        aow aow = (aow) this.ehh.fsG.fsP;
        aow.wem = i;
        aow.wen = j;
        this.nNq = str;
        aow.Scene = i2;
        AppMethodBeat.m2505o(25875);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(25876);
        C4990ab.m7410d("MicroMsg.NetSceneGetTalkRoomMember", "doScene");
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(25876);
        return a;
    }

    public final int getType() {
        return 336;
    }

    public final String cED() {
        return this.nNq;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(25877);
        C4990ab.m7410d("MicroMsg.NetSceneGetTalkRoomMember", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            aox aox = (aox) this.ehh.fsH.fsP;
            C4990ab.m7417i("MicroMsg.NetSceneGetTalkRoomMember", "resp %s", aox.toString());
            this.syE = aox.weo;
            this.sza = C39946c.m68409as(aox.vEh);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(25877);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(25877);
    }

    /* renamed from: as */
    private static LinkedList<cgm> m68409as(LinkedList<cgm> linkedList) {
        AppMethodBeat.m2504i(25878);
        LinkedList linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            cgm cgm = (cgm) it.next();
            if (!C5046bo.isNullOrNil(cgm.jBB)) {
                linkedList2.add(cgm);
            }
        }
        AppMethodBeat.m2505o(25878);
        return linkedList2;
    }

    public final int cEE() {
        return this.sceneType;
    }
}
