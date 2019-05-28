package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.aso */
public final class aso extends C1331a {
    public int wwc;
    public C1332b wwd;
    public C1332b wwe;
    public C1332b wwf;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(5216);
        C6092b c6092b;
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wwd == null) {
                c6092b = new C6092b("Not all required fields were included: SPSBuf");
                AppMethodBeat.m2505o(5216);
                throw c6092b;
            } else if (this.wwe == null) {
                c6092b = new C6092b("Not all required fields were included: PPSBuf");
                AppMethodBeat.m2505o(5216);
                throw c6092b;
            } else {
                c6093a.mo13480iz(1, this.wwc);
                if (this.wwd != null) {
                    c6093a.mo13473c(2, this.wwd);
                }
                if (this.wwe != null) {
                    c6093a.mo13473c(3, this.wwe);
                }
                if (this.wwf != null) {
                    c6093a.mo13473c(4, this.wwf);
                }
                AppMethodBeat.m2505o(5216);
                return 0;
            }
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.wwc) + 0;
            if (this.wwd != null) {
                bs += C6091a.m9571b(2, this.wwd);
            }
            if (this.wwe != null) {
                bs += C6091a.m9571b(3, this.wwe);
            }
            if (this.wwf != null) {
                bs += C6091a.m9571b(4, this.wwf);
            }
            AppMethodBeat.m2505o(5216);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            if (this.wwd == null) {
                c6092b = new C6092b("Not all required fields were included: SPSBuf");
                AppMethodBeat.m2505o(5216);
                throw c6092b;
            } else if (this.wwe == null) {
                c6092b = new C6092b("Not all required fields were included: PPSBuf");
                AppMethodBeat.m2505o(5216);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(5216);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            aso aso = (aso) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aso.wwc = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5216);
                    return 0;
                case 2:
                    aso.wwd = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(5216);
                    return 0;
                case 3:
                    aso.wwe = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(5216);
                    return 0;
                case 4:
                    aso.wwf = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(5216);
                    return 0;
                default:
                    AppMethodBeat.m2505o(5216);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(5216);
            return -1;
        }
    }
}
