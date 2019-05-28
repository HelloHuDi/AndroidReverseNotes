package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cxq */
public final class cxq extends C1331a {
    public LinkedList<Integer> xkP = new LinkedList();
    public cxp xsZ;
    public LinkedList<Integer> xta = new LinkedList();
    public int xtb;
    public int xtc;

    public cxq() {
        AppMethodBeat.m2504i(115016);
        AppMethodBeat.m2505o(115016);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(115017);
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.xsZ != null) {
                c6093a.mo13479iy(1, this.xsZ.computeSize());
                this.xsZ.writeFields(c6093a);
            }
            c6093a.mo13474e(2, 2, this.xta);
            c6093a.mo13474e(3, 2, this.xkP);
            c6093a.mo13480iz(4, this.xtb);
            c6093a.mo13480iz(5, this.xtc);
            AppMethodBeat.m2505o(115017);
            return 0;
        } else if (i == 1) {
            if (this.xsZ != null) {
                ix = C6087a.m9557ix(1, this.xsZ.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int c = (((ix + C6087a.m9552c(2, 2, this.xta)) + C6087a.m9552c(3, 2, this.xkP)) + C6091a.m9572bs(4, this.xtb)) + C6091a.m9572bs(5, this.xtc);
            AppMethodBeat.m2505o(115017);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xta.clear();
            this.xkP.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(115017);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cxq cxq = (cxq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cxp cxp = new cxp();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cxp.populateBuilderWithField(c6086a3, cxp, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cxq.xsZ = cxp;
                    }
                    AppMethodBeat.m2505o(115017);
                    return 0;
                case 2:
                    cxq.xta.add(Integer.valueOf(c6086a2.BTU.mo13458vd()));
                    AppMethodBeat.m2505o(115017);
                    return 0;
                case 3:
                    cxq.xkP.add(Integer.valueOf(c6086a2.BTU.mo13458vd()));
                    AppMethodBeat.m2505o(115017);
                    return 0;
                case 4:
                    cxq.xtb = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(115017);
                    return 0;
                case 5:
                    cxq.xtc = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(115017);
                    return 0;
                default:
                    AppMethodBeat.m2505o(115017);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(115017);
            return -1;
        }
    }
}
