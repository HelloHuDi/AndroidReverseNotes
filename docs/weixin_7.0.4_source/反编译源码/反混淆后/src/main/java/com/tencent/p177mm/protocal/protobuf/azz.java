package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.azz */
public final class azz extends C1331a {
    public LinkedList<C1332b> wDN = new LinkedList();

    public azz() {
        AppMethodBeat.m2504i(102383);
        AppMethodBeat.m2505o(102383);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(102384);
        int c;
        if (i == 0) {
            ((C6093a) objArr[0]).mo13474e(1, 6, this.wDN);
            AppMethodBeat.m2505o(102384);
            return 0;
        } else if (i == 1) {
            c = C6087a.m9552c(1, 6, this.wDN) + 0;
            AppMethodBeat.m2505o(102384);
            return c;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.wDN.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (c = C1331a.getNextFieldNumber(c6086a); c > 0; c = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, c)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(102384);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            azz azz = (azz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    azz.wDN.add(c6086a2.BTU.emu());
                    AppMethodBeat.m2505o(102384);
                    return 0;
                default:
                    AppMethodBeat.m2505o(102384);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(102384);
            return -1;
        }
    }
}
