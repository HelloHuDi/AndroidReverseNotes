package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.qe */
public final class C7280qe extends C1331a {
    public int ehB;
    public LinkedList<C7281qf> vXi = new LinkedList();
    public int vXj;
    public bts vXk;

    public C7280qe() {
        AppMethodBeat.m2504i(60025);
        AppMethodBeat.m2505o(60025);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(60026);
        int bs;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.ehB);
            c6093a.mo13474e(2, 8, this.vXi);
            c6093a.mo13480iz(3, this.vXj);
            if (this.vXk != null) {
                c6093a.mo13479iy(4, this.vXk.computeSize());
                this.vXk.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(60026);
            return 0;
        } else if (i == 1) {
            bs = ((C6091a.m9572bs(1, this.ehB) + 0) + C6087a.m9552c(2, 8, this.vXi)) + C6091a.m9572bs(3, this.vXj);
            if (this.vXk != null) {
                bs += C6087a.m9557ix(4, this.vXk.computeSize());
            }
            AppMethodBeat.m2505o(60026);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vXi.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(60026);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C7280qe c7280qe = (C7280qe) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    c7280qe.ehB = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60026);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7281qf c7281qf = new C7281qf();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7281qf.populateBuilderWithField(c6086a3, c7281qf, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c7280qe.vXi.add(c7281qf);
                    }
                    AppMethodBeat.m2505o(60026);
                    return 0;
                case 3:
                    c7280qe.vXj = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60026);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c7280qe.vXk = bts;
                    }
                    AppMethodBeat.m2505o(60026);
                    return 0;
                default:
                    AppMethodBeat.m2505o(60026);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(60026);
            return -1;
        }
    }
}
