package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cpy */
public final class cpy extends C1331a {
    public int xnY;
    public int xnZ;
    public int xoa;
    public int xob;
    public int xoc;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(5264);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.xnY);
            c6093a.mo13480iz(2, this.xnZ);
            c6093a.mo13480iz(3, this.xoa);
            c6093a.mo13480iz(4, this.xob);
            c6093a.mo13480iz(5, this.xoc);
            AppMethodBeat.m2505o(5264);
            return 0;
        } else if (i == 1) {
            bs = ((((C6091a.m9572bs(1, this.xnY) + 0) + C6091a.m9572bs(2, this.xnZ)) + C6091a.m9572bs(3, this.xoa)) + C6091a.m9572bs(4, this.xob)) + C6091a.m9572bs(5, this.xoc);
            AppMethodBeat.m2505o(5264);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(5264);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cpy cpy = (cpy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cpy.xnY = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5264);
                    return 0;
                case 2:
                    cpy.xnZ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5264);
                    return 0;
                case 3:
                    cpy.xoa = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5264);
                    return 0;
                case 4:
                    cpy.xob = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5264);
                    return 0;
                case 5:
                    cpy.xoc = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5264);
                    return 0;
                default:
                    AppMethodBeat.m2505o(5264);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(5264);
            return -1;
        }
    }
}
