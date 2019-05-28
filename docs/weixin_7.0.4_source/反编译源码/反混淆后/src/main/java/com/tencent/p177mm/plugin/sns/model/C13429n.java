package com.tencent.p177mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.protocal.protobuf.car;
import com.tencent.p177mm.protocal.protobuf.cas;
import com.tencent.p177mm.protocal.protobuf.cbf;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

/* renamed from: com.tencent.mm.plugin.sns.model.n */
public final class C13429n extends C1207m implements C1918k {
    private static Vector<String> qIZ = new Vector();
    private ArrayList<C46236n> ckx = new ArrayList();
    final int cvp;
    private String desc = "";
    private boolean eTf = false;
    private C7472b ehh;
    public C1202f ehi;
    private boolean qIW;
    private long qIX = 0;
    private long qIY = 0;
    public int qJa = 0;
    public int qJb = 0;

    static {
        AppMethodBeat.m2504i(36260);
        AppMethodBeat.m2505o(36260);
    }

    /* renamed from: XO */
    public static synchronized boolean m21572XO(String str) {
        boolean z;
        synchronized (C13429n.class) {
            AppMethodBeat.m2504i(36254);
            if (qIZ.contains(str)) {
                z = false;
                AppMethodBeat.m2505o(36254);
            } else {
                qIZ.add(str);
                z = true;
                AppMethodBeat.m2505o(36254);
            }
        }
        return z;
    }

    /* renamed from: XP */
    public static synchronized boolean m21573XP(String str) {
        synchronized (C13429n.class) {
            AppMethodBeat.m2504i(36255);
            qIZ.remove(str);
            AppMethodBeat.m2505o(36255);
        }
        return true;
    }

    public C13429n(String str) {
        AppMethodBeat.m2504i(36256);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new car();
        c1196a.fsK = new cas();
        c1196a.uri = "/cgi-bin/micromsg-bin/mmsnsclassifytimeline";
        c1196a.fsI = 601;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        this.qIX = 0;
        this.qIW = 0 == 0;
        this.cvp = 2;
        car car = (car) this.ehh.fsG.fsP;
        car.wZT = "";
        car.wZU = 0;
        car.wZV = str;
        car.wZW = 1;
        C4990ab.m7411d("MicroMsg.NetSceneSnsClassifyTimeLine", "maxid %s classifyid %s classifyType %d", C29036i.m46117jV(0), str, Integer.valueOf(0));
        AppMethodBeat.m2505o(36256);
    }

    /* renamed from: b */
    private C46236n m21574b(cbf cbf) {
        AppMethodBeat.m2504i(36257);
        C46236n c46236n = new C46236n();
        String str = new String(cbf.xam.getBuffer().toByteArray());
        C4990ab.m7411d("MicroMsg.NetSceneSnsClassifyTimeLine", "from server %d ", Long.valueOf(cbf.vQE));
        if (c46236n.mo74255YR(str)) {
            cbf.xam.setBuffer(new byte[0]);
            c46236n.field_userName = cbf.vHl;
            c46236n.mo74294ls(cbf.pcX);
            c46236n.field_likeFlag = cbf.xan;
            c46236n.mo74293kz(cbf.vQE);
            c46236n.mo74292kB(cbf.vQE);
            c46236n.mo74252DF(this.cvp);
            try {
                c46236n.mo74256bi(cbf.toByteArray());
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.NetSceneSnsClassifyTimeLine", e, "", new Object[0]);
            }
            TimeLineObject cqu = c46236n.cqu();
            cqu.jBB = cbf.vHl;
            c46236n.field_pravited = cqu.wEJ;
            C4990ab.m7410d("MicroMsg.NetSceneSnsClassifyTimeLine", "ext flag " + cbf.wGz);
            c46236n.cqR();
            c46236n.mo74257c(cqu);
            c46236n.field_type = cqu.xfI.wbJ;
            c46236n.field_subType = cqu.xfI.wbL;
            AppMethodBeat.m2505o(36257);
            return c46236n;
        }
        AppMethodBeat.m2505o(36257);
        return null;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(36258);
        C4990ab.m7410d("MicroMsg.NetSceneSnsClassifyTimeLine", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        cas cas = (cas) ((C7472b) c1929q).fsH.fsP;
        if (c1929q.mo5618ZS().vyl == 207 || c1929q.mo5618ZS().vyl == 0 || c1929q.mo5618ZS().vyl == 212) {
            this.eTf = c1929q.mo5618ZS().vyl == 212;
            this.qJa = cas.wZX;
            this.desc = cas.vEA;
            C29036i.m46118jW(this.qIX);
            C4990ab.m7411d("MicroMsg.NetSceneSnsClassifyTimeLine", "resp objCount %d desc %s", Integer.valueOf(cas.wGG), this.desc);
            Iterator it = cas.vKB.iterator();
            while (it.hasNext()) {
                C46236n b = m21574b((cbf) it.next());
                if (b != null) {
                    this.ckx.add(b);
                }
            }
            C13429n.m21573XP("@__classify_timeline");
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(36258);
            return;
        }
        C13429n.m21573XP("@__classify_timeline");
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(36258);
    }

    public final int getType() {
        return 601;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(36259);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(36259);
        return a;
    }
}
