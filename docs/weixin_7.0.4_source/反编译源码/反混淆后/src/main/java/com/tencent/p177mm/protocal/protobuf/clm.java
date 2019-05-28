package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.clm */
public final class clm extends C1331a {
    public int OpCode;
    public LinkedList<String> xjj = new LinkedList();

    public clm() {
        AppMethodBeat.m2504i(62587);
        AppMethodBeat.m2505o(62587);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(62588);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.OpCode);
            c6093a.mo13474e(2, 1, this.xjj);
            AppMethodBeat.m2505o(62588);
            return 0;
        } else if (i == 1) {
            bs = (C6091a.m9572bs(1, this.OpCode) + 0) + C6087a.m9552c(2, 1, this.xjj);
            AppMethodBeat.m2505o(62588);
            return bs;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.xjj.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(62588);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            clm clm = (clm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    clm.OpCode = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(62588);
                    return 0;
                case 2:
                    clm.xjj.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(62588);
                    return 0;
                default:
                    AppMethodBeat.m2505o(62588);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(62588);
            return -1;
        }
    }
}
