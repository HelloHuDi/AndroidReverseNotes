package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.mx */
public final class C7274mx extends C1331a {
    public int vRj;
    public LinkedList<Integer> vRk = new LinkedList();

    public C7274mx() {
        AppMethodBeat.m2504i(58900);
        AppMethodBeat.m2505o(58900);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(58901);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.vRj);
            c6093a.mo13477f(2, 2, this.vRk);
            AppMethodBeat.m2505o(58901);
            return 0;
        } else if (i == 1) {
            bs = (C6091a.m9572bs(1, this.vRj) + 0) + C6087a.m9553d(2, 2, this.vRk);
            AppMethodBeat.m2505o(58901);
            return bs;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.vRk.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(58901);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C7274mx c7274mx = (C7274mx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c7274mx.vRj = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58901);
                    return 0;
                case 2:
                    c7274mx.vRk = new C6086a(c6086a2.BTU.emu().f1226wR, unknownTagHandler).BTU.emt();
                    AppMethodBeat.m2505o(58901);
                    return 0;
                default:
                    AppMethodBeat.m2505o(58901);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(58901);
            return -1;
        }
    }
}
