package com.tencent.p177mm.plugin.talkroom.p1041b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C23467ym;
import com.tencent.p177mm.protocal.protobuf.C30247yn;
import com.tencent.p177mm.protocal.protobuf.cgl;
import com.tencent.p177mm.protocal.protobuf.cgm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.talkroom.b.a */
public final class C13929a extends C29415f {
    private final C7472b ehh;
    private C1202f ehi;
    private final String nNq;
    public int nwu;
    public long nwv;
    private int sceneType = 0;
    public int syE;
    public int syF;
    public LinkedList<cgl> syH;
    public LinkedList<cgm> sza;

    public C13929a(String str, int i) {
        AppMethodBeat.m2504i(25867);
        C1196a c1196a = new C1196a();
        this.sceneType = i;
        c1196a.fsJ = new C23467ym();
        c1196a.fsK = new C30247yn();
        c1196a.uri = "/cgi-bin/micromsg-bin/entertalkroom";
        c1196a.fsI = 332;
        c1196a.fsL = ErrorCode.NEEDDOWNLOAD_8;
        c1196a.fsM = 1000000147;
        this.ehh = c1196a.acD();
        ((C23467ym) this.ehh.fsG.fsP).wel = str;
        ((C23467ym) this.ehh.fsG.fsP).Scene = i;
        this.nNq = str;
        AppMethodBeat.m2505o(25867);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(25868);
        C4990ab.m7411d("MicroMsg.NetSceneEnterTalkRoom", "doScene %d", Integer.valueOf(this.sceneType));
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(25868);
        return a;
    }

    public final int getType() {
        return 332;
    }

    public final String cED() {
        return this.nNq;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(25869);
        C4990ab.m7410d("MicroMsg.NetSceneEnterTalkRoom", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            C30247yn c30247yn = (C30247yn) this.ehh.fsH.fsP;
            C4990ab.m7417i("MicroMsg.NetSceneEnterTalkRoom", "resp %s", c30247yn.toString());
            this.nwu = c30247yn.wem;
            this.nwv = c30247yn.wen;
            this.syE = c30247yn.weo;
            this.syF = c30247yn.weq;
            this.sza = C13929a.m22076as(c30247yn.vEh);
            this.syH = C13929a.m22077at(c30247yn.vIO);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(25869);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(25869);
    }

    /* renamed from: as */
    private static LinkedList<cgm> m22076as(LinkedList<cgm> linkedList) {
        AppMethodBeat.m2504i(25870);
        LinkedList linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            cgm cgm = (cgm) it.next();
            if (!C5046bo.isNullOrNil(cgm.jBB)) {
                linkedList2.add(cgm);
            }
        }
        AppMethodBeat.m2505o(25870);
        return linkedList2;
    }

    /* renamed from: at */
    private static LinkedList<cgl> m22077at(LinkedList<cgl> linkedList) {
        AppMethodBeat.m2504i(25871);
        LinkedList linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            linkedList2.add((cgl) it.next());
        }
        AppMethodBeat.m2505o(25871);
        return linkedList2;
    }

    public final int cEE() {
        return this.sceneType;
    }
}
