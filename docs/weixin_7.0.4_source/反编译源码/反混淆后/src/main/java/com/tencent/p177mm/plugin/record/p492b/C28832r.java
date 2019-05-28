package com.tencent.p177mm.plugin.record.p492b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C18348nt;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.protocal.p1338b.p1339a.C44100d;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.record.b.r */
public final class C28832r extends C4884c<C18348nt> {
    public C28832r() {
        AppMethodBeat.m2504i(135750);
        this.xxI = C18348nt.class.getName().hashCode();
        AppMethodBeat.m2505o(135750);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        AppMethodBeat.m2504i(135751);
        C18348nt c18348nt = (C18348nt) c4883b;
        C4990ab.m7417i("MicroMsg.RecordOperationListener", "on record operation listener, %d", Integer.valueOf(c18348nt.cJY.type));
        switch (c18348nt.cJY.type) {
            case 0:
                c18348nt.cJZ.cKi = C43436n.m77547VI(c18348nt.cJY.cKa);
                break;
            case 1:
                C4990ab.m7417i("MicroMsg.RecordOperationListener", "get record paths, msg id %d", Long.valueOf(c18348nt.cJY.cvx));
                c18348nt.cJZ.cKj = C43436n.m77560d(c18348nt.cJY.cAv, c18348nt.cJY.cvx);
                c18348nt.cJZ.dataPath = C43436n.m77558c(c18348nt.cJY.cAv, c18348nt.cJY.cvx);
                c18348nt.cJZ.cKk = C43436n.m77561e(c18348nt.cJY.cAv, c18348nt.cJY.cvx);
                c18348nt.cJZ.thumbPath = C43436n.m77562f(c18348nt.cJY.cAv, c18348nt.cJY.cvx);
                break;
            case 2:
                C4990ab.m7417i("MicroMsg.RecordOperationListener", "send record msg, to %s, thumbPath %s, thumbId %s", c18348nt.cJY.toUser, c18348nt.cJY.thumbPath, Integer.valueOf(c18348nt.cJY.cKc));
                C43436n.m77549a(c18348nt.cJY.toUser, c18348nt.cJY.cKb, c18348nt.cJY.title, c18348nt.cJY.desc, c18348nt.cJY.thumbPath, c18348nt.cJY.cKc, c18348nt.cJY.cKg);
                break;
            case 3:
                C4990ab.m7417i("MicroMsg.RecordOperationListener", "clear resouces, msg id %d", Long.valueOf(c18348nt.cJY.cvx));
                C43436n.m77567jF(c18348nt.cJY.cvx);
                break;
            case 4:
                C4990ab.m7417i("MicroMsg.RecordOperationListener", "forward record msg, to %s, msg id %d", c18348nt.cJY.toUser, Long.valueOf(c18348nt.cJY.cKd.field_msgId));
                C43436n.m77550a(c18348nt.cJY.toUser, c18348nt.cJY.cAN, c18348nt.cJY.cKd);
                break;
            case 5:
                C4990ab.m7417i("MicroMsg.RecordOperationListener", "summerrecord forward multi record msg, to %s", c18348nt.cJY.toUser);
                C43436n.m77548a(c18348nt.cJY.context, c18348nt.cJY.toUser, c18348nt.cJY.cKf, c18348nt.cJY.cKe, c18348nt.cJY.cJy, c18348nt.cJY.cKh);
                break;
            case 6:
                C45316cl c45316cl = new C45316cl();
                C46164b.m86180a(c18348nt.cJY.context, c45316cl, c18348nt.cJY.cKf, c18348nt.cJY.cKe);
                C44100d a = C43436n.m77552a(c18348nt.cJY.context, c45316cl, c18348nt.cJY.cKf);
                c18348nt.cJZ.cJy = c45316cl;
                c18348nt.cJZ.cKh = a;
                break;
            case 8:
                if (!C5046bo.isNullOrNil(c18348nt.cJY.thumbPath)) {
                    C43436n.m77559c(c18348nt.cJY.cAv, c18348nt.cJY.cvx, true);
                    break;
                }
                C43436n.m77557b(c18348nt.cJY.cAv, c18348nt.cJY.cvx, true);
                break;
            case 9:
                c18348nt.cJZ.cKj = C43436n.m77563g(c18348nt.cJY.cAv, c18348nt.cJY.cvx);
                break;
        }
        AppMethodBeat.m2505o(135751);
        return false;
    }
}
