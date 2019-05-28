package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cad */
public final class cad extends C1331a {
    public int pdi;
    public String vRN;
    public LinkedList<blq> wZm = new LinkedList();
    public C35968ze wZn;
    public LinkedList<bpz> wZo = new LinkedList();
    public int wZp;
    public C40508cx wpB;

    public cad() {
        AppMethodBeat.m2504i(56975);
        AppMethodBeat.m2505o(56975);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56976);
        int bs;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.pdi);
            c6093a.mo13474e(2, 8, this.wZm);
            if (this.wZn != null) {
                c6093a.mo13479iy(3, this.wZn.computeSize());
                this.wZn.writeFields(c6093a);
            }
            if (this.wpB != null) {
                c6093a.mo13479iy(4, this.wpB.computeSize());
                this.wpB.writeFields(c6093a);
            }
            c6093a.mo13474e(5, 8, this.wZo);
            c6093a.mo13480iz(6, this.wZp);
            if (this.vRN != null) {
                c6093a.mo13475e(7, this.vRN);
            }
            AppMethodBeat.m2505o(56976);
            return 0;
        } else if (i == 1) {
            bs = (C6091a.m9572bs(1, this.pdi) + 0) + C6087a.m9552c(2, 8, this.wZm);
            if (this.wZn != null) {
                bs += C6087a.m9557ix(3, this.wZn.computeSize());
            }
            if (this.wpB != null) {
                bs += C6087a.m9557ix(4, this.wpB.computeSize());
            }
            bs = (bs + C6087a.m9552c(5, 8, this.wZo)) + C6091a.m9572bs(6, this.wZp);
            if (this.vRN != null) {
                bs += C6091a.m9575f(7, this.vRN);
            }
            AppMethodBeat.m2505o(56976);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wZm.clear();
            this.wZo.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56976);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cad cad = (cad) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    cad.pdi = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56976);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        blq blq = new blq();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = blq.populateBuilderWithField(c6086a3, blq, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cad.wZm.add(blq);
                    }
                    AppMethodBeat.m2505o(56976);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C35968ze c35968ze = new C35968ze();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c35968ze.populateBuilderWithField(c6086a3, c35968ze, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cad.wZn = c35968ze;
                    }
                    AppMethodBeat.m2505o(56976);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C40508cx c40508cx = new C40508cx();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c40508cx.populateBuilderWithField(c6086a3, c40508cx, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cad.wpB = c40508cx;
                    }
                    AppMethodBeat.m2505o(56976);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bpz bpz = new bpz();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bpz.populateBuilderWithField(c6086a3, bpz, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cad.wZo.add(bpz);
                    }
                    AppMethodBeat.m2505o(56976);
                    return 0;
                case 6:
                    cad.wZp = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56976);
                    return 0;
                case 7:
                    cad.vRN = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56976);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56976);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56976);
            return -1;
        }
    }
}
