package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cum */
public final class cum extends C1331a {
    public C1332b vHn;
    public long vIs;
    public int xqP;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28753);
        C6092b c6092b;
        int o;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vHn == null) {
                c6092b = new C6092b("Not all required fields were included: VoiceData");
                AppMethodBeat.m2505o(28753);
                throw c6092b;
            }
            c6093a.mo13472ai(1, this.vIs);
            if (this.vHn != null) {
                c6093a.mo13473c(2, this.vHn);
            }
            c6093a.mo13480iz(3, this.xqP);
            AppMethodBeat.m2505o(28753);
            return 0;
        } else if (i == 1) {
            o = C6091a.m9578o(1, this.vIs) + 0;
            if (this.vHn != null) {
                o += C6091a.m9571b(2, this.vHn);
            }
            o += C6091a.m9572bs(3, this.xqP);
            AppMethodBeat.m2505o(28753);
            return o;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (o = C1331a.getNextFieldNumber(c6086a); o > 0; o = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, o)) {
                    c6086a.ems();
                }
            }
            if (this.vHn == null) {
                c6092b = new C6092b("Not all required fields were included: VoiceData");
                AppMethodBeat.m2505o(28753);
                throw c6092b;
            }
            AppMethodBeat.m2505o(28753);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cum cum = (cum) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cum.vIs = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(28753);
                    return 0;
                case 2:
                    cum.vHn = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(28753);
                    return 0;
                case 3:
                    cum.xqP = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28753);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28753);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28753);
            return -1;
        }
    }
}
