package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bzm */
public final class bzm extends C1331a {
    public LinkedList<String> wYv = new LinkedList();
    public LinkedList<String> wYw = new LinkedList();
    public LinkedList<Integer> wYx = new LinkedList();
    public LinkedList<Integer> wYy = new LinkedList();

    public bzm() {
        AppMethodBeat.m2504i(89146);
        AppMethodBeat.m2505o(89146);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(89147);
        int c;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13474e(1, 1, this.wYv);
            c6093a.mo13474e(2, 1, this.wYw);
            c6093a.mo13474e(3, 2, this.wYx);
            c6093a.mo13474e(4, 2, this.wYy);
            AppMethodBeat.m2505o(89147);
            return 0;
        } else if (i == 1) {
            c = (((C6087a.m9552c(1, 1, this.wYv) + 0) + C6087a.m9552c(2, 1, this.wYw)) + C6087a.m9552c(3, 2, this.wYx)) + C6087a.m9552c(4, 2, this.wYy);
            AppMethodBeat.m2505o(89147);
            return c;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.wYv.clear();
            this.wYw.clear();
            this.wYx.clear();
            this.wYy.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (c = C1331a.getNextFieldNumber(c6086a); c > 0; c = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, c)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(89147);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bzm bzm = (bzm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bzm.wYv.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(89147);
                    return 0;
                case 2:
                    bzm.wYw.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(89147);
                    return 0;
                case 3:
                    bzm.wYx.add(Integer.valueOf(c6086a2.BTU.mo13458vd()));
                    AppMethodBeat.m2505o(89147);
                    return 0;
                case 4:
                    bzm.wYy.add(Integer.valueOf(c6086a2.BTU.mo13458vd()));
                    AppMethodBeat.m2505o(89147);
                    return 0;
                default:
                    AppMethodBeat.m2505o(89147);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(89147);
            return -1;
        }
    }
}
