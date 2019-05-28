package com.tencent.p177mm.plugin.qmessage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p230g.p231a.C26203mx;
import com.tencent.p177mm.plugin.qmessage.p739a.C12873d;
import com.tencent.p177mm.plugin.qmessage.p739a.C46142g;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;

/* renamed from: com.tencent.mm.plugin.qmessage.b */
public final class C39534b extends C4884c<C26203mx> {
    public C39534b() {
        AppMethodBeat.m2504i(24067);
        this.xxI = C26203mx.class.getName().hashCode();
        AppMethodBeat.m2505o(24067);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        AppMethodBeat.m2504i(24068);
        C26203mx c26203mx = (C26203mx) c4883b;
        switch (c26203mx.cIO.opType) {
            case 0:
                String str = c26203mx.cIO.cIQ;
                String str2 = c26203mx.cIO.cIR;
                C9638aw.m17190ZK();
                C7616ad aoO = C18628c.m29078XM().aoO(str);
                if (aoO == null || ((int) aoO.ewQ) == 0) {
                    aoO = new C7616ad(str);
                    aoO.mo16682NH();
                    aoO.mo14703iB(str2);
                    aoO.mo14688hD(4);
                    C9638aw.m17190ZK();
                    C18628c.m29078XM().mo15702Z(aoO);
                    C41730b.m73503pV(aoO.field_username);
                }
                C12873d Vb = C46142g.cca().mo55344Vb(str);
                if (Vb == null || C5046bo.nullAsNil(Vb.getUsername()).length() <= 0) {
                    Vb = new C12873d();
                    Vb.bJt = -1;
                    Vb.psK = 1;
                    Vb.username = str;
                    Vb.psL = 0;
                    Vb.psM = 0;
                    if (!C46142g.cca().mo55345a(Vb)) {
                        C4990ab.m7412e("MicroMsg.QMsgExtension", "processModQContact: insert qcontact failed");
                    }
                }
                c26203mx.cIP.cvi = true;
                break;
            case 1:
                C12873d Vb2 = C46142g.cca().mo55344Vb(c26203mx.cIO.cIS);
                if (Vb2 != null && C5046bo.nullAsNil(Vb2.getUsername()).length() > 0) {
                    if (Vb2.psL != ((long) c26203mx.cIO.cIT) || Vb2.psM != ((long) c26203mx.cIO.cIU)) {
                        Vb2.psK = 1;
                        Vb2.username = c26203mx.cIO.cIS;
                        Vb2.psL = (long) c26203mx.cIO.cIT;
                        Vb2.psM = (long) c26203mx.cIO.cIU;
                        Vb2.bJt = 56;
                        if (!C46142g.cca().mo55346a(Vb2.getUsername(), Vb2)) {
                            C4990ab.m7412e("MicroMsg.QMsgOperationListener", "processModQContact: update qcontact failed");
                        }
                        c26203mx.cIP.cvi = true;
                        break;
                    }
                    c26203mx.cIP.cvi = true;
                    break;
                }
                Vb2 = new C12873d();
                Vb2.bJt = -1;
                Vb2.psK = 1;
                Vb2.username = c26203mx.cIO.cIS;
                Vb2.psL = (long) c26203mx.cIO.cIT;
                Vb2.psM = (long) c26203mx.cIO.cIU;
                if (!C46142g.cca().mo55345a(Vb2)) {
                    C4990ab.m7412e("MicroMsg.QMsgOperationListener", "processModQContact: insert qcontact failed");
                }
                c26203mx.cIP.cvi = true;
                break;
                break;
            case 2:
                C46142g.ccb();
                break;
        }
        AppMethodBeat.m2505o(24068);
        return false;
    }
}
