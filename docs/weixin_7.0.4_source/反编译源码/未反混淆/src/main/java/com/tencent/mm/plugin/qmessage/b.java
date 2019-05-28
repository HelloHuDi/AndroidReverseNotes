package com.tencent.mm.plugin.qmessage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.qmessage.a.d;
import com.tencent.mm.plugin.qmessage.a.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;

public final class b extends c<mx> {
    public b() {
        AppMethodBeat.i(24067);
        this.xxI = mx.class.getName().hashCode();
        AppMethodBeat.o(24067);
    }

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
        AppMethodBeat.i(24068);
        mx mxVar = (mx) bVar;
        switch (mxVar.cIO.opType) {
            case 0:
                String str = mxVar.cIO.cIQ;
                String str2 = mxVar.cIO.cIR;
                aw.ZK();
                ad aoO = com.tencent.mm.model.c.XM().aoO(str);
                if (aoO == null || ((int) aoO.ewQ) == 0) {
                    aoO = new ad(str);
                    aoO.NH();
                    aoO.iB(str2);
                    aoO.hD(4);
                    aw.ZK();
                    com.tencent.mm.model.c.XM().Z(aoO);
                    com.tencent.mm.ah.b.pV(aoO.field_username);
                }
                d Vb = g.cca().Vb(str);
                if (Vb == null || bo.nullAsNil(Vb.getUsername()).length() <= 0) {
                    Vb = new d();
                    Vb.bJt = -1;
                    Vb.psK = 1;
                    Vb.username = str;
                    Vb.psL = 0;
                    Vb.psM = 0;
                    if (!g.cca().a(Vb)) {
                        ab.e("MicroMsg.QMsgExtension", "processModQContact: insert qcontact failed");
                    }
                }
                mxVar.cIP.cvi = true;
                break;
            case 1:
                d Vb2 = g.cca().Vb(mxVar.cIO.cIS);
                if (Vb2 != null && bo.nullAsNil(Vb2.getUsername()).length() > 0) {
                    if (Vb2.psL != ((long) mxVar.cIO.cIT) || Vb2.psM != ((long) mxVar.cIO.cIU)) {
                        Vb2.psK = 1;
                        Vb2.username = mxVar.cIO.cIS;
                        Vb2.psL = (long) mxVar.cIO.cIT;
                        Vb2.psM = (long) mxVar.cIO.cIU;
                        Vb2.bJt = 56;
                        if (!g.cca().a(Vb2.getUsername(), Vb2)) {
                            ab.e("MicroMsg.QMsgOperationListener", "processModQContact: update qcontact failed");
                        }
                        mxVar.cIP.cvi = true;
                        break;
                    }
                    mxVar.cIP.cvi = true;
                    break;
                }
                Vb2 = new d();
                Vb2.bJt = -1;
                Vb2.psK = 1;
                Vb2.username = mxVar.cIO.cIS;
                Vb2.psL = (long) mxVar.cIO.cIT;
                Vb2.psM = (long) mxVar.cIO.cIU;
                if (!g.cca().a(Vb2)) {
                    ab.e("MicroMsg.QMsgOperationListener", "processModQContact: insert qcontact failed");
                }
                mxVar.cIP.cvi = true;
                break;
                break;
            case 2:
                g.ccb();
                break;
        }
        AppMethodBeat.o(24068);
        return false;
    }
}
