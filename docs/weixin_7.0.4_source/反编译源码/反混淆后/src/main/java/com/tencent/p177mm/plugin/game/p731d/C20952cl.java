package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.cl */
public final class C20952cl extends C1331a {
    public int nda;
    public String ndb;
    public String ndc;
    public boolean ndd;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(111649);
        C6092b c6092b;
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.ndc == null) {
                c6092b = new C6092b("Not all required fields were included: MediaURL");
                AppMethodBeat.m2505o(111649);
                throw c6092b;
            }
            c6093a.mo13480iz(1, this.nda);
            if (this.ndb != null) {
                c6093a.mo13475e(2, this.ndb);
            }
            if (this.ndc != null) {
                c6093a.mo13475e(3, this.ndc);
            }
            c6093a.mo13471aO(4, this.ndd);
            AppMethodBeat.m2505o(111649);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.nda) + 0;
            if (this.ndb != null) {
                bs += C6091a.m9575f(2, this.ndb);
            }
            if (this.ndc != null) {
                bs += C6091a.m9575f(3, this.ndc);
            }
            bs += C6091a.m9576fv(4) + 1;
            AppMethodBeat.m2505o(111649);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            if (this.ndc == null) {
                c6092b = new C6092b("Not all required fields were included: MediaURL");
                AppMethodBeat.m2505o(111649);
                throw c6092b;
            }
            AppMethodBeat.m2505o(111649);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C20952cl c20952cl = (C20952cl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c20952cl.nda = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(111649);
                    return 0;
                case 2:
                    c20952cl.ndb = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111649);
                    return 0;
                case 3:
                    c20952cl.ndc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111649);
                    return 0;
                case 4:
                    c20952cl.ndd = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(111649);
                    return 0;
                default:
                    AppMethodBeat.m2505o(111649);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(111649);
            return -1;
        }
    }
}
