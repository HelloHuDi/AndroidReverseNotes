package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.tr */
public final class C40575tr extends C1331a {
    public long waM;
    public int waN;
    public int waO;
    public int waP;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(135597);
        int o;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13472ai(1, this.waM);
            c6093a.mo13480iz(2, this.waN);
            c6093a.mo13480iz(3, this.waO);
            c6093a.mo13480iz(4, this.waP);
            AppMethodBeat.m2505o(135597);
            return 0;
        } else if (i == 1) {
            o = (((C6091a.m9578o(1, this.waM) + 0) + C6091a.m9572bs(2, this.waN)) + C6091a.m9572bs(3, this.waO)) + C6091a.m9572bs(4, this.waP);
            AppMethodBeat.m2505o(135597);
            return o;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (o = C1331a.getNextFieldNumber(c6086a); o > 0; o = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, o)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(135597);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C40575tr c40575tr = (C40575tr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c40575tr.waM = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(135597);
                    return 0;
                case 2:
                    c40575tr.waN = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(135597);
                    return 0;
                case 3:
                    c40575tr.waO = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(135597);
                    return 0;
                case 4:
                    c40575tr.waP = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(135597);
                    return 0;
                default:
                    AppMethodBeat.m2505o(135597);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(135597);
            return -1;
        }
    }
}
