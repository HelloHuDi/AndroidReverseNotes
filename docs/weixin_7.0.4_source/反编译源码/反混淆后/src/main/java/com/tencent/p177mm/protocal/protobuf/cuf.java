package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cuf */
public final class cuf extends C1331a {
    public LinkedList<Integer> xqG = new LinkedList();
    public boolean xqH;

    public cuf() {
        AppMethodBeat.m2504i(28744);
        AppMethodBeat.m2505o(28744);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28745);
        int c;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13474e(1, 2, this.xqG);
            c6093a.mo13471aO(2, this.xqH);
            AppMethodBeat.m2505o(28745);
            return 0;
        } else if (i == 1) {
            c = (C6087a.m9552c(1, 2, this.xqG) + 0) + (C6091a.m9576fv(2) + 1);
            AppMethodBeat.m2505o(28745);
            return c;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.xqG.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (c = C1331a.getNextFieldNumber(c6086a); c > 0; c = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, c)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(28745);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cuf cuf = (cuf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cuf.xqG.add(Integer.valueOf(c6086a2.BTU.mo13458vd()));
                    AppMethodBeat.m2505o(28745);
                    return 0;
                case 2:
                    cuf.xqH = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(28745);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28745);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28745);
            return -1;
        }
    }
}
