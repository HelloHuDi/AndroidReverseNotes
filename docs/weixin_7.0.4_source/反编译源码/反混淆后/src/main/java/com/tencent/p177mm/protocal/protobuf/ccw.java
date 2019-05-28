package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ccw */
public final class ccw extends C1331a {
    public int xce;
    public int xcf;
    public int xcg;
    public coj xch;
    public int xci;
    public int xcj;
    public int xck;
    public int xcl;
    public LinkedList<Integer> xcm = new LinkedList();
    public int xcn;
    public LinkedList<Integer> xco = new LinkedList();
    public int xcp;
    public LinkedList<Integer> xcq = new LinkedList();

    public ccw() {
        AppMethodBeat.m2504i(5219);
        AppMethodBeat.m2505o(5219);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(5220);
        C6092b c6092b;
        int bs;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.xch == null) {
                c6092b = new C6092b("Not all required fields were included: Addr");
                AppMethodBeat.m2505o(5220);
                throw c6092b;
            }
            c6093a.mo13480iz(1, this.xce);
            c6093a.mo13480iz(2, this.xcf);
            c6093a.mo13480iz(3, this.xcg);
            if (this.xch != null) {
                c6093a.mo13479iy(4, this.xch.computeSize());
                this.xch.writeFields(c6093a);
            }
            c6093a.mo13480iz(5, this.xci);
            c6093a.mo13480iz(6, this.xcj);
            c6093a.mo13480iz(7, this.xck);
            c6093a.mo13480iz(8, this.xcl);
            c6093a.mo13477f(9, 2, this.xcm);
            c6093a.mo13480iz(10, this.xcn);
            c6093a.mo13477f(11, 2, this.xco);
            c6093a.mo13480iz(12, this.xcp);
            c6093a.mo13477f(13, 2, this.xcq);
            AppMethodBeat.m2505o(5220);
            return 0;
        } else if (i == 1) {
            bs = ((C6091a.m9572bs(1, this.xce) + 0) + C6091a.m9572bs(2, this.xcf)) + C6091a.m9572bs(3, this.xcg);
            if (this.xch != null) {
                bs += C6087a.m9557ix(4, this.xch.computeSize());
            }
            bs = ((((((((bs + C6091a.m9572bs(5, this.xci)) + C6091a.m9572bs(6, this.xcj)) + C6091a.m9572bs(7, this.xck)) + C6091a.m9572bs(8, this.xcl)) + C6087a.m9553d(9, 2, this.xcm)) + C6091a.m9572bs(10, this.xcn)) + C6087a.m9553d(11, 2, this.xco)) + C6091a.m9572bs(12, this.xcp)) + C6087a.m9553d(13, 2, this.xcq);
            AppMethodBeat.m2505o(5220);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xcm.clear();
            this.xco.clear();
            this.xcq.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            if (this.xch == null) {
                c6092b = new C6092b("Not all required fields were included: Addr");
                AppMethodBeat.m2505o(5220);
                throw c6092b;
            }
            AppMethodBeat.m2505o(5220);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            ccw ccw = (ccw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ccw.xce = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5220);
                    return 0;
                case 2:
                    ccw.xcf = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5220);
                    return 0;
                case 3:
                    ccw.xcg = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5220);
                    return 0;
                case 4:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        coj coj = new coj();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = coj.populateBuilderWithField(c6086a3, coj, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        ccw.xch = coj;
                    }
                    AppMethodBeat.m2505o(5220);
                    return 0;
                case 5:
                    ccw.xci = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5220);
                    return 0;
                case 6:
                    ccw.xcj = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5220);
                    return 0;
                case 7:
                    ccw.xck = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5220);
                    return 0;
                case 8:
                    ccw.xcl = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5220);
                    return 0;
                case 9:
                    ccw.xcm = new C6086a(c6086a2.BTU.emu().f1226wR, unknownTagHandler).BTU.emt();
                    AppMethodBeat.m2505o(5220);
                    return 0;
                case 10:
                    ccw.xcn = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5220);
                    return 0;
                case 11:
                    ccw.xco = new C6086a(c6086a2.BTU.emu().f1226wR, unknownTagHandler).BTU.emt();
                    AppMethodBeat.m2505o(5220);
                    return 0;
                case 12:
                    ccw.xcp = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5220);
                    return 0;
                case 13:
                    ccw.xcq = new C6086a(c6086a2.BTU.emu().f1226wR, unknownTagHandler).BTU.emt();
                    AppMethodBeat.m2505o(5220);
                    return 0;
                default:
                    AppMethodBeat.m2505o(5220);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(5220);
            return -1;
        }
    }
}
