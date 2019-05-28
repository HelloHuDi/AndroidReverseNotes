package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bia */
public final class bia extends C1331a {
    public String pdA;
    public int state;
    public LinkedList<bhz> wLj = new LinkedList();
    public int wLk;
    public int wLl;
    public bsz wLm;
    public int wLn;
    public LinkedList<bhy> wLo = new LinkedList();
    public boolean wLp;
    public LinkedList<bsz> wLq = new LinkedList();

    public bia() {
        AppMethodBeat.m2504i(90704);
        AppMethodBeat.m2505o(90704);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(90705);
        C6092b c6092b;
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.pdA == null) {
                c6092b = new C6092b("Not all required fields were included: pid");
                AppMethodBeat.m2505o(90705);
                throw c6092b;
            }
            if (this.pdA != null) {
                c6093a.mo13475e(1, this.pdA);
            }
            c6093a.mo13480iz(2, this.state);
            c6093a.mo13474e(3, 8, this.wLj);
            c6093a.mo13480iz(4, this.wLk);
            c6093a.mo13480iz(5, this.wLl);
            if (this.wLm != null) {
                c6093a.mo13479iy(6, this.wLm.computeSize());
                this.wLm.writeFields(c6093a);
            }
            c6093a.mo13480iz(7, this.wLn);
            c6093a.mo13474e(8, 8, this.wLo);
            c6093a.mo13471aO(9, this.wLp);
            c6093a.mo13474e(10, 8, this.wLq);
            AppMethodBeat.m2505o(90705);
            return 0;
        } else if (i == 1) {
            if (this.pdA != null) {
                f = C6091a.m9575f(1, this.pdA) + 0;
            } else {
                f = 0;
            }
            f = (((f + C6091a.m9572bs(2, this.state)) + C6087a.m9552c(3, 8, this.wLj)) + C6091a.m9572bs(4, this.wLk)) + C6091a.m9572bs(5, this.wLl);
            if (this.wLm != null) {
                f += C6087a.m9557ix(6, this.wLm.computeSize());
            }
            int bs = (((f + C6091a.m9572bs(7, this.wLn)) + C6087a.m9552c(8, 8, this.wLo)) + (C6091a.m9576fv(9) + 1)) + C6087a.m9552c(10, 8, this.wLq);
            AppMethodBeat.m2505o(90705);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wLj.clear();
            this.wLo.clear();
            this.wLq.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.pdA == null) {
                c6092b = new C6092b("Not all required fields were included: pid");
                AppMethodBeat.m2505o(90705);
                throw c6092b;
            }
            AppMethodBeat.m2505o(90705);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bia bia = (bia) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            bsz bsz;
            switch (intValue) {
                case 1:
                    bia.pdA = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(90705);
                    return 0;
                case 2:
                    bia.state = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(90705);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bhz bhz = new bhz();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.populateBuilderWithField(c6086a3, bhz, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bia.wLj.add(bhz);
                    }
                    AppMethodBeat.m2505o(90705);
                    return 0;
                case 4:
                    bia.wLk = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(90705);
                    return 0;
                case 5:
                    bia.wLl = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(90705);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bsz = new bsz();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bsz.populateBuilderWithField(c6086a3, bsz, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bia.wLm = bsz;
                    }
                    AppMethodBeat.m2505o(90705);
                    return 0;
                case 7:
                    bia.wLn = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(90705);
                    return 0;
                case 8:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bhy bhy = new bhy();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.populateBuilderWithField(c6086a3, bhy, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bia.wLo.add(bhy);
                    }
                    AppMethodBeat.m2505o(90705);
                    return 0;
                case 9:
                    bia.wLp = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(90705);
                    return 0;
                case 10:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bsz = new bsz();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bsz.populateBuilderWithField(c6086a3, bsz, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bia.wLq.add(bsz);
                    }
                    AppMethodBeat.m2505o(90705);
                    return 0;
                default:
                    AppMethodBeat.m2505o(90705);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(90705);
            return -1;
        }
    }
}
