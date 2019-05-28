package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.car;
import com.tencent.mm.protocal.protobuf.cas;
import com.tencent.mm.protocal.protobuf.cbf;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public final class n extends m implements k {
    private static Vector<String> qIZ = new Vector();
    private ArrayList<com.tencent.mm.plugin.sns.storage.n> ckx = new ArrayList();
    final int cvp;
    private String desc = "";
    private boolean eTf = false;
    private b ehh;
    public f ehi;
    private boolean qIW;
    private long qIX = 0;
    private long qIY = 0;
    public int qJa = 0;
    public int qJb = 0;

    static {
        AppMethodBeat.i(36260);
        AppMethodBeat.o(36260);
    }

    public static synchronized boolean XO(String str) {
        boolean z;
        synchronized (n.class) {
            AppMethodBeat.i(36254);
            if (qIZ.contains(str)) {
                z = false;
                AppMethodBeat.o(36254);
            } else {
                qIZ.add(str);
                z = true;
                AppMethodBeat.o(36254);
            }
        }
        return z;
    }

    public static synchronized boolean XP(String str) {
        synchronized (n.class) {
            AppMethodBeat.i(36255);
            qIZ.remove(str);
            AppMethodBeat.o(36255);
        }
        return true;
    }

    public n(String str) {
        AppMethodBeat.i(36256);
        a aVar = new a();
        aVar.fsJ = new car();
        aVar.fsK = new cas();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsclassifytimeline";
        aVar.fsI = 601;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        this.qIX = 0;
        this.qIW = 0 == 0;
        this.cvp = 2;
        car car = (car) this.ehh.fsG.fsP;
        car.wZT = "";
        car.wZU = 0;
        car.wZV = str;
        car.wZW = 1;
        ab.d("MicroMsg.NetSceneSnsClassifyTimeLine", "maxid %s classifyid %s classifyType %d", i.jV(0), str, Integer.valueOf(0));
        AppMethodBeat.o(36256);
    }

    private com.tencent.mm.plugin.sns.storage.n b(cbf cbf) {
        AppMethodBeat.i(36257);
        com.tencent.mm.plugin.sns.storage.n nVar = new com.tencent.mm.plugin.sns.storage.n();
        String str = new String(cbf.xam.getBuffer().toByteArray());
        ab.d("MicroMsg.NetSceneSnsClassifyTimeLine", "from server %d ", Long.valueOf(cbf.vQE));
        if (nVar.YR(str)) {
            cbf.xam.setBuffer(new byte[0]);
            nVar.field_userName = cbf.vHl;
            nVar.ls(cbf.pcX);
            nVar.field_likeFlag = cbf.xan;
            nVar.kz(cbf.vQE);
            nVar.kB(cbf.vQE);
            nVar.DF(this.cvp);
            try {
                nVar.bi(cbf.toByteArray());
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.NetSceneSnsClassifyTimeLine", e, "", new Object[0]);
            }
            TimeLineObject cqu = nVar.cqu();
            cqu.jBB = cbf.vHl;
            nVar.field_pravited = cqu.wEJ;
            ab.d("MicroMsg.NetSceneSnsClassifyTimeLine", "ext flag " + cbf.wGz);
            nVar.cqR();
            nVar.c(cqu);
            nVar.field_type = cqu.xfI.wbJ;
            nVar.field_subType = cqu.xfI.wbL;
            AppMethodBeat.o(36257);
            return nVar;
        }
        AppMethodBeat.o(36257);
        return null;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(36258);
        ab.d("MicroMsg.NetSceneSnsClassifyTimeLine", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        cas cas = (cas) ((b) qVar).fsH.fsP;
        if (qVar.ZS().vyl == 207 || qVar.ZS().vyl == 0 || qVar.ZS().vyl == 212) {
            this.eTf = qVar.ZS().vyl == 212;
            this.qJa = cas.wZX;
            this.desc = cas.vEA;
            i.jW(this.qIX);
            ab.d("MicroMsg.NetSceneSnsClassifyTimeLine", "resp objCount %d desc %s", Integer.valueOf(cas.wGG), this.desc);
            Iterator it = cas.vKB.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.sns.storage.n b = b((cbf) it.next());
                if (b != null) {
                    this.ckx.add(b);
                }
            }
            XP("@__classify_timeline");
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(36258);
            return;
        }
        XP("@__classify_timeline");
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(36258);
    }

    public final int getType() {
        return 601;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(36259);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(36259);
        return a;
    }
}
