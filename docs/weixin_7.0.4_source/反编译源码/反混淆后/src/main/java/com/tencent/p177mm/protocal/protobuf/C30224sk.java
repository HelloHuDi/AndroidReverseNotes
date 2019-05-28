package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.sk */
public final class C30224sk extends C1331a {
    public int vZG;
    public int vZH;
    public int vZI;
    public LinkedList<C23439sj> vZJ = new LinkedList();
    public C1332b vZK;
    public atd vZL;

    public C30224sk() {
        AppMethodBeat.m2504i(72843);
        AppMethodBeat.m2505o(72843);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(72844);
        int bs;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.vZG);
            c6093a.mo13480iz(2, this.vZH);
            c6093a.mo13480iz(3, this.vZI);
            c6093a.mo13474e(4, 8, this.vZJ);
            if (this.vZK != null) {
                c6093a.mo13473c(5, this.vZK);
            }
            if (this.vZL != null) {
                c6093a.mo13479iy(6, this.vZL.computeSize());
                this.vZL.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(72844);
            return 0;
        } else if (i == 1) {
            bs = (((C6091a.m9572bs(1, this.vZG) + 0) + C6091a.m9572bs(2, this.vZH)) + C6091a.m9572bs(3, this.vZI)) + C6087a.m9552c(4, 8, this.vZJ);
            if (this.vZK != null) {
                bs += C6091a.m9571b(5, this.vZK);
            }
            if (this.vZL != null) {
                bs += C6087a.m9557ix(6, this.vZL.computeSize());
            }
            AppMethodBeat.m2505o(72844);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vZJ.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(72844);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C30224sk c30224sk = (C30224sk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    c30224sk.vZG = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72844);
                    return 0;
                case 2:
                    c30224sk.vZH = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72844);
                    return 0;
                case 3:
                    c30224sk.vZI = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72844);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C23439sj c23439sj = new C23439sj();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c23439sj.populateBuilderWithField(c6086a3, c23439sj, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c30224sk.vZJ.add(c23439sj);
                    }
                    AppMethodBeat.m2505o(72844);
                    return 0;
                case 5:
                    c30224sk.vZK = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(72844);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        atd atd = new atd();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = atd.populateBuilderWithField(c6086a3, atd, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c30224sk.vZL = atd;
                    }
                    AppMethodBeat.m2505o(72844);
                    return 0;
                default:
                    AppMethodBeat.m2505o(72844);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(72844);
            return -1;
        }
    }
}
