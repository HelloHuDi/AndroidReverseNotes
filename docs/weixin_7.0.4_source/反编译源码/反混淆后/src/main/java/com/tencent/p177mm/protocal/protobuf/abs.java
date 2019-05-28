package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.abs */
public final class abs extends C1331a {
    public LinkedList<String> wiI = new LinkedList();
    public LinkedList<String> wiJ = new LinkedList();

    public abs() {
        AppMethodBeat.m2504i(51421);
        AppMethodBeat.m2505o(51421);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(51422);
        int c;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13474e(1, 1, this.wiI);
            c6093a.mo13474e(2, 1, this.wiJ);
            AppMethodBeat.m2505o(51422);
            return 0;
        } else if (i == 1) {
            c = (C6087a.m9552c(1, 1, this.wiI) + 0) + C6087a.m9552c(2, 1, this.wiJ);
            AppMethodBeat.m2505o(51422);
            return c;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.wiI.clear();
            this.wiJ.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (c = C1331a.getNextFieldNumber(c6086a); c > 0; c = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, c)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(51422);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            abs abs = (abs) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    abs.wiI.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(51422);
                    return 0;
                case 2:
                    abs.wiJ.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(51422);
                    return 0;
                default:
                    AppMethodBeat.m2505o(51422);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(51422);
            return -1;
        }
    }
}
