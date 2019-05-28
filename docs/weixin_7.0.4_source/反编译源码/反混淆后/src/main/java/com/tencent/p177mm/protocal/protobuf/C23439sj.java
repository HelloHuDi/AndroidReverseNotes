package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.sj */
public final class C23439sj extends C1331a {
    public int jCy;
    public int luF;
    public LinkedList<awy> naO = new LinkedList();
    public int vKd;
    public String vOA;
    public String vOB;
    public String vOC;
    public String vOD;
    public String vOz;
    public int vZF;

    public C23439sj() {
        AppMethodBeat.m2504i(72841);
        AppMethodBeat.m2505o(72841);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(72842);
        int bs;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.luF);
            if (this.vOB != null) {
                c6093a.mo13475e(7, this.vOB);
            }
            c6093a.mo13480iz(2, this.vKd);
            c6093a.mo13480iz(3, this.vZF);
            c6093a.mo13474e(4, 8, this.naO);
            if (this.vOz != null) {
                c6093a.mo13475e(5, this.vOz);
            }
            if (this.vOA != null) {
                c6093a.mo13475e(6, this.vOA);
            }
            if (this.vOC != null) {
                c6093a.mo13475e(8, this.vOC);
            }
            if (this.vOD != null) {
                c6093a.mo13475e(9, this.vOD);
            }
            c6093a.mo13480iz(10, this.jCy);
            AppMethodBeat.m2505o(72842);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.luF) + 0;
            if (this.vOB != null) {
                bs += C6091a.m9575f(7, this.vOB);
            }
            bs = ((bs + C6091a.m9572bs(2, this.vKd)) + C6091a.m9572bs(3, this.vZF)) + C6087a.m9552c(4, 8, this.naO);
            if (this.vOz != null) {
                bs += C6091a.m9575f(5, this.vOz);
            }
            if (this.vOA != null) {
                bs += C6091a.m9575f(6, this.vOA);
            }
            if (this.vOC != null) {
                bs += C6091a.m9575f(8, this.vOC);
            }
            if (this.vOD != null) {
                bs += C6091a.m9575f(9, this.vOD);
            }
            bs += C6091a.m9572bs(10, this.jCy);
            AppMethodBeat.m2505o(72842);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.naO.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(72842);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C23439sj c23439sj = (C23439sj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c23439sj.luF = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72842);
                    return 0;
                case 2:
                    c23439sj.vKd = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72842);
                    return 0;
                case 3:
                    c23439sj.vZF = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72842);
                    return 0;
                case 4:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        awy awy = new awy();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = awy.populateBuilderWithField(c6086a3, awy, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c23439sj.naO.add(awy);
                    }
                    AppMethodBeat.m2505o(72842);
                    return 0;
                case 5:
                    c23439sj.vOz = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(72842);
                    return 0;
                case 6:
                    c23439sj.vOA = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(72842);
                    return 0;
                case 7:
                    c23439sj.vOB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(72842);
                    return 0;
                case 8:
                    c23439sj.vOC = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(72842);
                    return 0;
                case 9:
                    c23439sj.vOD = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(72842);
                    return 0;
                case 10:
                    c23439sj.jCy = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72842);
                    return 0;
                default:
                    AppMethodBeat.m2505o(72842);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(72842);
            return -1;
        }
    }
}
