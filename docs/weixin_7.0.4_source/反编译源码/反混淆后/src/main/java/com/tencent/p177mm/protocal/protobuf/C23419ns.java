package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ns */
public final class C23419ns extends C1331a {
    public String vSR;
    public String vSS;
    public String vST;
    public String vSU;
    public LinkedList<C7277nr> vSV = new LinkedList();
    public int vSW;
    public String vSX;
    public C30208ny vSY;
    public String vSZ;
    public LinkedList<C7276nq> vTa = new LinkedList();
    public String vTb;
    public String vTc;
    public C30208ny vTd;
    public C7277nr vTe;
    public int vTf;
    public int vTg;
    public int vTh;
    public long vTi;

    public C23419ns() {
        AppMethodBeat.m2504i(89025);
        AppMethodBeat.m2505o(89025);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(89026);
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vSR != null) {
                c6093a.mo13475e(1, this.vSR);
            }
            if (this.vSS != null) {
                c6093a.mo13475e(2, this.vSS);
            }
            if (this.vST != null) {
                c6093a.mo13475e(3, this.vST);
            }
            if (this.vSU != null) {
                c6093a.mo13475e(4, this.vSU);
            }
            c6093a.mo13474e(5, 8, this.vSV);
            c6093a.mo13480iz(6, this.vSW);
            if (this.vSX != null) {
                c6093a.mo13475e(7, this.vSX);
            }
            if (this.vSY != null) {
                c6093a.mo13479iy(8, this.vSY.computeSize());
                this.vSY.writeFields(c6093a);
            }
            if (this.vSZ != null) {
                c6093a.mo13475e(9, this.vSZ);
            }
            c6093a.mo13474e(10, 8, this.vTa);
            if (this.vTb != null) {
                c6093a.mo13475e(11, this.vTb);
            }
            if (this.vTc != null) {
                c6093a.mo13475e(12, this.vTc);
            }
            if (this.vTd != null) {
                c6093a.mo13479iy(13, this.vTd.computeSize());
                this.vTd.writeFields(c6093a);
            }
            if (this.vTe != null) {
                c6093a.mo13479iy(14, this.vTe.computeSize());
                this.vTe.writeFields(c6093a);
            }
            c6093a.mo13480iz(15, this.vTf);
            c6093a.mo13480iz(16, this.vTg);
            c6093a.mo13480iz(17, this.vTh);
            c6093a.mo13472ai(18, this.vTi);
            AppMethodBeat.m2505o(89026);
            return 0;
        } else if (i == 1) {
            if (this.vSR != null) {
                f = C6091a.m9575f(1, this.vSR) + 0;
            } else {
                f = 0;
            }
            if (this.vSS != null) {
                f += C6091a.m9575f(2, this.vSS);
            }
            if (this.vST != null) {
                f += C6091a.m9575f(3, this.vST);
            }
            if (this.vSU != null) {
                f += C6091a.m9575f(4, this.vSU);
            }
            f = (f + C6087a.m9552c(5, 8, this.vSV)) + C6091a.m9572bs(6, this.vSW);
            if (this.vSX != null) {
                f += C6091a.m9575f(7, this.vSX);
            }
            if (this.vSY != null) {
                f += C6087a.m9557ix(8, this.vSY.computeSize());
            }
            if (this.vSZ != null) {
                f += C6091a.m9575f(9, this.vSZ);
            }
            f += C6087a.m9552c(10, 8, this.vTa);
            if (this.vTb != null) {
                f += C6091a.m9575f(11, this.vTb);
            }
            if (this.vTc != null) {
                f += C6091a.m9575f(12, this.vTc);
            }
            if (this.vTd != null) {
                f += C6087a.m9557ix(13, this.vTd.computeSize());
            }
            if (this.vTe != null) {
                f += C6087a.m9557ix(14, this.vTe.computeSize());
            }
            int bs = (((f + C6091a.m9572bs(15, this.vTf)) + C6091a.m9572bs(16, this.vTg)) + C6091a.m9572bs(17, this.vTh)) + C6091a.m9578o(18, this.vTi);
            AppMethodBeat.m2505o(89026);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vSV.clear();
            this.vTa.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(89026);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C23419ns c23419ns = (C23419ns) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C7277nr c7277nr;
            C6086a c6086a3;
            boolean z;
            C30208ny c30208ny;
            switch (intValue) {
                case 1:
                    c23419ns.vSR = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89026);
                    return 0;
                case 2:
                    c23419ns.vSS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89026);
                    return 0;
                case 3:
                    c23419ns.vST = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89026);
                    return 0;
                case 4:
                    c23419ns.vSU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89026);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c7277nr = new C7277nr();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7277nr.populateBuilderWithField(c6086a3, c7277nr, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c23419ns.vSV.add(c7277nr);
                    }
                    AppMethodBeat.m2505o(89026);
                    return 0;
                case 6:
                    c23419ns.vSW = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89026);
                    return 0;
                case 7:
                    c23419ns.vSX = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89026);
                    return 0;
                case 8:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c30208ny = new C30208ny();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c30208ny.populateBuilderWithField(c6086a3, c30208ny, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c23419ns.vSY = c30208ny;
                    }
                    AppMethodBeat.m2505o(89026);
                    return 0;
                case 9:
                    c23419ns.vSZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89026);
                    return 0;
                case 10:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7276nq c7276nq = new C7276nq();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7276nq.populateBuilderWithField(c6086a3, c7276nq, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c23419ns.vTa.add(c7276nq);
                    }
                    AppMethodBeat.m2505o(89026);
                    return 0;
                case 11:
                    c23419ns.vTb = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89026);
                    return 0;
                case 12:
                    c23419ns.vTc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89026);
                    return 0;
                case 13:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c30208ny = new C30208ny();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c30208ny.populateBuilderWithField(c6086a3, c30208ny, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c23419ns.vTd = c30208ny;
                    }
                    AppMethodBeat.m2505o(89026);
                    return 0;
                case 14:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c7277nr = new C7277nr();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7277nr.populateBuilderWithField(c6086a3, c7277nr, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c23419ns.vTe = c7277nr;
                    }
                    AppMethodBeat.m2505o(89026);
                    return 0;
                case 15:
                    c23419ns.vTf = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89026);
                    return 0;
                case 16:
                    c23419ns.vTg = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89026);
                    return 0;
                case 17:
                    c23419ns.vTh = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89026);
                    return 0;
                case 18:
                    c23419ns.vTi = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(89026);
                    return 0;
                default:
                    AppMethodBeat.m2505o(89026);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(89026);
            return -1;
        }
    }
}
