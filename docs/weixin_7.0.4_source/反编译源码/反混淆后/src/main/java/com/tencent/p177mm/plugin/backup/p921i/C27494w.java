package com.tencent.p177mm.plugin.backup.p921i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.backup.i.w */
public final class C27494w extends C1331a {
    /* renamed from: ID */
    public String f13685ID;
    public int Version;
    public int jBT;
    public C1332b jBi;
    public int jCs;
    public int jCt;
    public int jCu;
    public C1332b jCw;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(18071);
        C6092b c6092b;
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.f13685ID == null) {
                c6092b = new C6092b("Not all required fields were included: ID");
                AppMethodBeat.m2505o(18071);
                throw c6092b;
            }
            c6093a.mo13480iz(1, this.jCs);
            c6093a.mo13480iz(2, this.jBT);
            if (this.f13685ID != null) {
                c6093a.mo13475e(3, this.f13685ID);
            }
            if (this.jBi != null) {
                c6093a.mo13473c(4, this.jBi);
            }
            c6093a.mo13480iz(5, this.Version);
            c6093a.mo13480iz(6, this.jCt);
            c6093a.mo13480iz(7, this.jCu);
            if (this.jCw != null) {
                c6093a.mo13473c(8, this.jCw);
            }
            AppMethodBeat.m2505o(18071);
            return 0;
        } else if (i == 1) {
            bs = (C6091a.m9572bs(1, this.jCs) + 0) + C6091a.m9572bs(2, this.jBT);
            if (this.f13685ID != null) {
                bs += C6091a.m9575f(3, this.f13685ID);
            }
            if (this.jBi != null) {
                bs += C6091a.m9571b(4, this.jBi);
            }
            bs = ((bs + C6091a.m9572bs(5, this.Version)) + C6091a.m9572bs(6, this.jCt)) + C6091a.m9572bs(7, this.jCu);
            if (this.jCw != null) {
                bs += C6091a.m9571b(8, this.jCw);
            }
            AppMethodBeat.m2505o(18071);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            if (this.f13685ID == null) {
                c6092b = new C6092b("Not all required fields were included: ID");
                AppMethodBeat.m2505o(18071);
                throw c6092b;
            }
            AppMethodBeat.m2505o(18071);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C27494w c27494w = (C27494w) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c27494w.jCs = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(18071);
                    return 0;
                case 2:
                    c27494w.jBT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(18071);
                    return 0;
                case 3:
                    c27494w.f13685ID = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(18071);
                    return 0;
                case 4:
                    c27494w.jBi = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(18071);
                    return 0;
                case 5:
                    c27494w.Version = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(18071);
                    return 0;
                case 6:
                    c27494w.jCt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(18071);
                    return 0;
                case 7:
                    c27494w.jCu = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(18071);
                    return 0;
                case 8:
                    c27494w.jCw = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(18071);
                    return 0;
                default:
                    AppMethodBeat.m2505o(18071);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(18071);
            return -1;
        }
    }
}
