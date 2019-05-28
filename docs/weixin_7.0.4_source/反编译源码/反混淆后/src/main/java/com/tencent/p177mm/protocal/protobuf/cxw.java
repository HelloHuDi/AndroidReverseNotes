package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cxw */
public final class cxw extends C1331a {
    public LinkedList<Integer> xkP = new LinkedList();
    public cxp xsZ;
    public String xto;
    public int xtp;
    public int xtq;

    public cxw() {
        AppMethodBeat.m2504i(115023);
        AppMethodBeat.m2505o(115023);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(115024);
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.xsZ != null) {
                c6093a.mo13479iy(1, this.xsZ.computeSize());
                this.xsZ.writeFields(c6093a);
            }
            if (this.xto != null) {
                c6093a.mo13475e(2, this.xto);
            }
            c6093a.mo13474e(3, 2, this.xkP);
            c6093a.mo13480iz(4, this.xtp);
            c6093a.mo13480iz(5, this.xtq);
            AppMethodBeat.m2505o(115024);
            return 0;
        } else if (i == 1) {
            if (this.xsZ != null) {
                ix = C6087a.m9557ix(1, this.xsZ.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.xto != null) {
                ix += C6091a.m9575f(2, this.xto);
            }
            int c = ((ix + C6087a.m9552c(3, 2, this.xkP)) + C6091a.m9572bs(4, this.xtp)) + C6091a.m9572bs(5, this.xtq);
            AppMethodBeat.m2505o(115024);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xkP.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(115024);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cxw cxw = (cxw) objArr[1];
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
                        cxw.xsZ = cxp;
                    }
                    AppMethodBeat.m2505o(115024);
                    return 0;
                case 2:
                    cxw.xto = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(115024);
                    return 0;
                case 3:
                    cxw.xkP.add(Integer.valueOf(c6086a2.BTU.mo13458vd()));
                    AppMethodBeat.m2505o(115024);
                    return 0;
                case 4:
                    cxw.xtp = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(115024);
                    return 0;
                case 5:
                    cxw.xtq = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(115024);
                    return 0;
                default:
                    AppMethodBeat.m2505o(115024);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(115024);
            return -1;
        }
    }
}
