package com.tencent.p177mm.plugin.backup.p921i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.backup.i.ad */
public final class C33708ad extends C1331a {
    public int jCA;
    public int jCB;
    public int jCD;
    public String jCx;
    public int jCy;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(18079);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.jCx == null) {
                c6092b = new C6092b("Not all required fields were included: DataID");
                AppMethodBeat.m2505o(18079);
                throw c6092b;
            }
            if (this.jCx != null) {
                c6093a.mo13475e(1, this.jCx);
            }
            c6093a.mo13480iz(2, this.jCy);
            c6093a.mo13480iz(3, this.jCA);
            c6093a.mo13480iz(4, this.jCB);
            c6093a.mo13480iz(5, this.jCD);
            AppMethodBeat.m2505o(18079);
            return 0;
        } else if (i == 1) {
            if (this.jCx != null) {
                f = C6091a.m9575f(1, this.jCx) + 0;
            } else {
                f = 0;
            }
            int bs = (((f + C6091a.m9572bs(2, this.jCy)) + C6091a.m9572bs(3, this.jCA)) + C6091a.m9572bs(4, this.jCB)) + C6091a.m9572bs(5, this.jCD);
            AppMethodBeat.m2505o(18079);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.jCx == null) {
                c6092b = new C6092b("Not all required fields were included: DataID");
                AppMethodBeat.m2505o(18079);
                throw c6092b;
            }
            AppMethodBeat.m2505o(18079);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C33708ad c33708ad = (C33708ad) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c33708ad.jCx = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(18079);
                    return 0;
                case 2:
                    c33708ad.jCy = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(18079);
                    return 0;
                case 3:
                    c33708ad.jCA = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(18079);
                    return 0;
                case 4:
                    c33708ad.jCB = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(18079);
                    return 0;
                case 5:
                    c33708ad.jCD = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(18079);
                    return 0;
                default:
                    AppMethodBeat.m2505o(18079);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(18079);
            return -1;
        }
    }
}
