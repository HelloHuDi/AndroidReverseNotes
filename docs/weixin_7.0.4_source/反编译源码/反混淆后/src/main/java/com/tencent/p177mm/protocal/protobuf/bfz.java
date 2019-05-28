package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bfz */
public final class bfz extends C1331a {
    public String app_id;
    public String gfa;
    public int oqG;
    public int wJQ;
    public bga wJR;
    public int wJS;
    public int wJT;
    public int wJU;
    public int wJV;
    public int wqI;
    public bgb wqJ;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(80125);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.gfa != null) {
                c6093a.mo13475e(1, this.gfa);
            }
            c6093a.mo13480iz(2, this.wJQ);
            if (this.wJR != null) {
                c6093a.mo13479iy(3, this.wJR.computeSize());
                this.wJR.writeFields(c6093a);
            }
            c6093a.mo13480iz(4, this.wqI);
            if (this.wqJ != null) {
                c6093a.mo13479iy(5, this.wqJ.computeSize());
                this.wqJ.writeFields(c6093a);
            }
            c6093a.mo13480iz(6, this.wJS);
            c6093a.mo13480iz(7, this.wJT);
            c6093a.mo13480iz(8, this.oqG);
            c6093a.mo13480iz(9, this.wJU);
            if (this.app_id != null) {
                c6093a.mo13475e(10, this.app_id);
            }
            c6093a.mo13480iz(11, this.wJV);
            AppMethodBeat.m2505o(80125);
            return 0;
        } else if (i == 1) {
            if (this.gfa != null) {
                f = C6091a.m9575f(1, this.gfa) + 0;
            } else {
                f = 0;
            }
            f += C6091a.m9572bs(2, this.wJQ);
            if (this.wJR != null) {
                f += C6087a.m9557ix(3, this.wJR.computeSize());
            }
            f += C6091a.m9572bs(4, this.wqI);
            if (this.wqJ != null) {
                f += C6087a.m9557ix(5, this.wqJ.computeSize());
            }
            f = (((f + C6091a.m9572bs(6, this.wJS)) + C6091a.m9572bs(7, this.wJT)) + C6091a.m9572bs(8, this.oqG)) + C6091a.m9572bs(9, this.wJU);
            if (this.app_id != null) {
                f += C6091a.m9575f(10, this.app_id);
            }
            int bs = f + C6091a.m9572bs(11, this.wJV);
            AppMethodBeat.m2505o(80125);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(80125);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bfz bfz = (bfz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    bfz.gfa = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80125);
                    return 0;
                case 2:
                    bfz.wJQ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80125);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bga bga = new bga();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bga.populateBuilderWithField(c6086a3, bga, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bfz.wJR = bga;
                    }
                    AppMethodBeat.m2505o(80125);
                    return 0;
                case 4:
                    bfz.wqI = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80125);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bgb bgb = new bgb();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bgb.populateBuilderWithField(c6086a3, bgb, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bfz.wqJ = bgb;
                    }
                    AppMethodBeat.m2505o(80125);
                    return 0;
                case 6:
                    bfz.wJS = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80125);
                    return 0;
                case 7:
                    bfz.wJT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80125);
                    return 0;
                case 8:
                    bfz.oqG = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80125);
                    return 0;
                case 9:
                    bfz.wJU = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80125);
                    return 0;
                case 10:
                    bfz.app_id = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80125);
                    return 0;
                case 11:
                    bfz.wJV = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80125);
                    return 0;
                default:
                    AppMethodBeat.m2505o(80125);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(80125);
            return -1;
        }
    }
}
