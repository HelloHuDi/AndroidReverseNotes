package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.nc */
public final class C40548nc extends C1331a {
    public String vRI;
    public LinkedList<String> vRJ = new LinkedList();

    public C40548nc() {
        AppMethodBeat.m2504i(48787);
        AppMethodBeat.m2505o(48787);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48788);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vRI != null) {
                c6093a.mo13475e(1, this.vRI);
            }
            c6093a.mo13474e(2, 1, this.vRJ);
            AppMethodBeat.m2505o(48788);
            return 0;
        } else if (i == 1) {
            if (this.vRI != null) {
                f = C6091a.m9575f(1, this.vRI) + 0;
            } else {
                f = 0;
            }
            int c = f + C6087a.m9552c(2, 1, this.vRJ);
            AppMethodBeat.m2505o(48788);
            return c;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.vRJ.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(48788);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C40548nc c40548nc = (C40548nc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c40548nc.vRI = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48788);
                    return 0;
                case 2:
                    c40548nc.vRJ.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(48788);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48788);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48788);
            return -1;
        }
    }
}
