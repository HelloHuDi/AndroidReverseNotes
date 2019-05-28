package com.tencent.p177mm.plugin.backup.p921i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.backup.i.ac */
public final class C33707ac extends C1331a {
    public int jBT;
    public int jBh;
    public C42778q jCL;
    public C42777p jCM;
    public C38664r jCN;
    public C45753s jCO;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(18078);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.jBh);
            c6093a.mo13480iz(2, this.jBT);
            if (this.jCL != null) {
                c6093a.mo13479iy(3, this.jCL.computeSize());
                this.jCL.writeFields(c6093a);
            }
            if (this.jCM != null) {
                c6093a.mo13479iy(4, this.jCM.computeSize());
                this.jCM.writeFields(c6093a);
            }
            if (this.jCN != null) {
                c6093a.mo13479iy(5, this.jCN.computeSize());
                this.jCN.writeFields(c6093a);
            }
            if (this.jCO != null) {
                c6093a.mo13479iy(6, this.jCO.computeSize());
                this.jCO.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(18078);
            return 0;
        } else if (i == 1) {
            bs = (C6091a.m9572bs(1, this.jBh) + 0) + C6091a.m9572bs(2, this.jBT);
            if (this.jCL != null) {
                bs += C6087a.m9557ix(3, this.jCL.computeSize());
            }
            if (this.jCM != null) {
                bs += C6087a.m9557ix(4, this.jCM.computeSize());
            }
            if (this.jCN != null) {
                bs += C6087a.m9557ix(5, this.jCN.computeSize());
            }
            if (this.jCO != null) {
                bs += C6087a.m9557ix(6, this.jCO.computeSize());
            }
            AppMethodBeat.m2505o(18078);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(18078);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C33707ac c33707ac = (C33707ac) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    c33707ac.jBh = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(18078);
                    return 0;
                case 2:
                    c33707ac.jBT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(18078);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C42778q c42778q = new C42778q();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c42778q.populateBuilderWithField(c6086a3, c42778q, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c33707ac.jCL = c42778q;
                    }
                    AppMethodBeat.m2505o(18078);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C42777p c42777p = new C42777p();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c42777p.populateBuilderWithField(c6086a3, c42777p, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c33707ac.jCM = c42777p;
                    }
                    AppMethodBeat.m2505o(18078);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C38664r c38664r = new C38664r();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c38664r.populateBuilderWithField(c6086a3, c38664r, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c33707ac.jCN = c38664r;
                    }
                    AppMethodBeat.m2505o(18078);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C45753s c45753s = new C45753s();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c45753s.populateBuilderWithField(c6086a3, c45753s, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c33707ac.jCO = c45753s;
                    }
                    AppMethodBeat.m2505o(18078);
                    return 0;
                default:
                    AppMethodBeat.m2505o(18078);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(18078);
            return -1;
        }
    }
}
