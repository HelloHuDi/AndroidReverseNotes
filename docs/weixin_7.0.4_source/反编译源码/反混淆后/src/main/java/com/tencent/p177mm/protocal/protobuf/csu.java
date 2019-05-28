package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.csu */
public final class csu extends bsr {
    public int jCt;
    public int vOq;
    public String vQg;
    public int wCu;
    public int wCv = 2;
    public double wCw;
    public double wCx;
    public String wCy;
    public int wOI;
    public String wol;
    public String xqb;
    public String xqc;
    public String xqd;
    public int xqe;
    public String xqf;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(93809);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.wol != null) {
                c6093a.mo13475e(2, this.wol);
            }
            c6093a.mo13480iz(3, this.vOq);
            c6093a.mo13480iz(4, this.wCu);
            if (this.vQg != null) {
                c6093a.mo13475e(5, this.vQg);
            }
            c6093a.mo13480iz(6, this.wCv);
            c6093a.mo13476f(7, this.wCw);
            c6093a.mo13476f(8, this.wCx);
            c6093a.mo13480iz(9, this.jCt);
            c6093a.mo13480iz(10, this.wOI);
            if (this.wCy != null) {
                c6093a.mo13475e(99, this.wCy);
            }
            if (this.xqb != null) {
                c6093a.mo13475e(100, this.xqb);
            }
            if (this.xqc != null) {
                c6093a.mo13475e(101, this.xqc);
            }
            if (this.xqd != null) {
                c6093a.mo13475e(102, this.xqd);
            }
            c6093a.mo13480iz(103, this.xqe);
            if (this.xqf != null) {
                c6093a.mo13475e(104, this.xqf);
            }
            AppMethodBeat.m2505o(93809);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wol != null) {
                ix += C6091a.m9575f(2, this.wol);
            }
            ix = (ix + C6091a.m9572bs(3, this.vOq)) + C6091a.m9572bs(4, this.wCu);
            if (this.vQg != null) {
                ix += C6091a.m9575f(5, this.vQg);
            }
            ix = ((((ix + C6091a.m9572bs(6, this.wCv)) + (C6091a.m9576fv(7) + 8)) + (C6091a.m9576fv(8) + 8)) + C6091a.m9572bs(9, this.jCt)) + C6091a.m9572bs(10, this.wOI);
            if (this.wCy != null) {
                ix += C6091a.m9575f(99, this.wCy);
            }
            if (this.xqb != null) {
                ix += C6091a.m9575f(100, this.xqb);
            }
            if (this.xqc != null) {
                ix += C6091a.m9575f(101, this.xqc);
            }
            if (this.xqd != null) {
                ix += C6091a.m9575f(102, this.xqd);
            }
            ix += C6091a.m9572bs(103, this.xqe);
            if (this.xqf != null) {
                ix += C6091a.m9575f(104, this.xqf);
            }
            AppMethodBeat.m2505o(93809);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(93809);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            csu csu = (csu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        C7267hl c7267hl = new C7267hl();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c7267hl.populateBuilderWithField(c6086a3, c7267hl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        csu.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(93809);
                    return 0;
                case 2:
                    csu.wol = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(93809);
                    return 0;
                case 3:
                    csu.vOq = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(93809);
                    return 0;
                case 4:
                    csu.wCu = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(93809);
                    return 0;
                case 5:
                    csu.vQg = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(93809);
                    return 0;
                case 6:
                    csu.wCv = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(93809);
                    return 0;
                case 7:
                    csu.wCw = Double.longBitsToDouble(c6086a2.BTU.eib());
                    AppMethodBeat.m2505o(93809);
                    return 0;
                case 8:
                    csu.wCx = Double.longBitsToDouble(c6086a2.BTU.eib());
                    AppMethodBeat.m2505o(93809);
                    return 0;
                case 9:
                    csu.jCt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(93809);
                    return 0;
                case 10:
                    csu.wOI = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(93809);
                    return 0;
                case 99:
                    csu.wCy = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(93809);
                    return 0;
                case 100:
                    csu.xqb = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(93809);
                    return 0;
                case 101:
                    csu.xqc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(93809);
                    return 0;
                case 102:
                    csu.xqd = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(93809);
                    return 0;
                case 103:
                    csu.xqe = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(93809);
                    return 0;
                case 104:
                    csu.xqf = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(93809);
                    return 0;
                default:
                    AppMethodBeat.m2505o(93809);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(93809);
            return -1;
        }
    }
}
