package com.tencent.p177mm.plugin.location.model.p1278a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C26982f;
import com.tencent.p177mm.protocal.protobuf.bqt;
import com.tencent.p177mm.protocal.protobuf.bqu;
import com.tencent.p177mm.protocal.protobuf.cie;
import com.tencent.p177mm.protocal.protobuf.cmj;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.location.model.a.c */
public final class C43241c extends C1207m implements C1918k {
    public final C7472b ehh;
    private C1202f ehi;
    private Runnable fPK;
    public String hwA;
    public int nLb;
    public cie nLc = null;
    public List<cmj> nLd = null;
    public bqu nLe;
    public int nLf;
    private String nLg;

    public C43241c(String str, int i, cmj cmj, int i2, cie cie) {
        AppMethodBeat.m2504i(113415);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bqt();
        c1196a.fsK = new bqu();
        c1196a.uri = "/cgi-bin/micromsg-bin/refreshtrackroom";
        c1196a.fsI = C26982f.CTRL_INDEX;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        bqt bqt = (bqt) this.ehh.fsG.fsP;
        bqt.weu = str;
        bqt.jCt = i;
        bqt.wTf = cmj;
        bqt.nbj = i2;
        bqt.wTg = cie;
        this.nLg = str;
        this.nLf = bqt.jCt;
        C4990ab.m7410d("MicroMsg.NetSceneRefreshTrackRoom", "userPosiItem " + cmj.vHl + " " + cmj.xkm.vNI + " " + cmj.xkm.vNH + " heading:" + cmj.xkm.wNP);
        C4990ab.m7410d("MicroMsg.NetSceneRefreshTrackRoom", "userPoi " + cie.vNI + " " + cie.vNH + " " + cie.Name);
        C4990ab.m7410d("MicroMsg.NetSceneRefreshTrackRoom", "trackRoomId:" + str + " uploadStatus:" + i);
        AppMethodBeat.m2505o(113415);
    }

    public final int getType() {
        return C26982f.CTRL_INDEX;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(113416);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(113416);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(113417);
        this.nLe = (bqu) ((C7472b) c1929q).fsH.fsP;
        if (this.nLe != null) {
            this.hwA = this.nLe.vKq;
        }
        if (i2 == 0 && i3 == 0) {
            this.nLb = this.nLe.wBg;
            this.nLc = this.nLe.wTi;
            this.nLd = this.nLe.wTh;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(String.format("[ resp count %d ] ", new Object[]{Integer.valueOf(this.nLe.jBv)}));
            if (this.nLc != null) {
                stringBuffer.append(String.format("[ roomPoi  %f %f %s] ", new Object[]{Double.valueOf(this.nLc.vNI), Double.valueOf(this.nLc.vNH), this.nLc.Name}));
            }
            C4990ab.m7410d("MicroMsg.NetSceneRefreshTrackRoom", "onGynetEnd " + stringBuffer.toString());
            LinkedList linkedList = new LinkedList();
            Iterator it = this.nLe.wTh.iterator();
            while (it.hasNext()) {
                cmj cmj = (cmj) it.next();
                if (cmj == null) {
                    linkedList.add(cmj);
                } else {
                    if (cmj.xkm == null) {
                        linkedList.add(cmj);
                    }
                    if (Math.abs(cmj.xkm.vNH) > 180.0d || Math.abs(cmj.xkm.vNI) > 90.0d) {
                        C4990ab.m7421w("MicroMsg.NetSceneRefreshTrackRoom", "server lat lng invalid %s %f %f %f", cmj.vHl, Double.valueOf(cmj.xkm.vNI), Double.valueOf(cmj.xkm.vNH), Double.valueOf(cmj.xkm.wNP));
                        linkedList.add(cmj);
                    }
                }
            }
            this.nLe.jBv = this.nLe.wTh.size();
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        if (this.fPK != null) {
            this.fPK.run();
        }
        AppMethodBeat.m2505o(113417);
    }
}
