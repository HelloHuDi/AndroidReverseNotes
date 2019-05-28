package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cpp */
public final class cpp extends bsr {
    public int vZF;
    public int wOQ;
    public String wPm;
    public int wem;
    public long wen;
    public int xcr;
    public cpx xlM;
    public cpx xlN;
    public long xlQ;
    public int xlR;
    public int xmL;
    public int xmW;
    public LinkedList<bts> xmX = new LinkedList();
    public int xmY;

    public cpp() {
        AppMethodBeat.m2504i(5249);
        AppMethodBeat.m2505o(5249);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(5250);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.xlM == null) {
                c6092b = new C6092b("Not all required fields were included: PeerId");
                AppMethodBeat.m2505o(5250);
                throw c6092b;
            } else if (this.xlN == null) {
                c6092b = new C6092b("Not all required fields were included: CapInfo");
                AppMethodBeat.m2505o(5250);
                throw c6092b;
            } else {
                if (this.BaseRequest != null) {
                    c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(c6093a);
                }
                if (this.wPm != null) {
                    c6093a.mo13475e(2, this.wPm);
                }
                c6093a.mo13480iz(3, this.xmW);
                c6093a.mo13474e(4, 8, this.xmX);
                if (this.xlM != null) {
                    c6093a.mo13479iy(6, this.xlM.computeSize());
                    this.xlM.writeFields(c6093a);
                }
                if (this.xlN != null) {
                    c6093a.mo13479iy(7, this.xlN.computeSize());
                    this.xlN.writeFields(c6093a);
                }
                c6093a.mo13480iz(8, this.vZF);
                c6093a.mo13480iz(9, this.xcr);
                c6093a.mo13480iz(10, this.wem);
                c6093a.mo13472ai(11, this.wen);
                c6093a.mo13480iz(12, this.xmL);
                c6093a.mo13472ai(13, this.xlQ);
                c6093a.mo13480iz(14, this.xmY);
                c6093a.mo13480iz(15, this.wOQ);
                c6093a.mo13480iz(16, this.xlR);
                AppMethodBeat.m2505o(5250);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wPm != null) {
                ix += C6091a.m9575f(2, this.wPm);
            }
            ix = (ix + C6091a.m9572bs(3, this.xmW)) + C6087a.m9552c(4, 8, this.xmX);
            if (this.xlM != null) {
                ix += C6087a.m9557ix(6, this.xlM.computeSize());
            }
            if (this.xlN != null) {
                ix += C6087a.m9557ix(7, this.xlN.computeSize());
            }
            int bs = ((((((((ix + C6091a.m9572bs(8, this.vZF)) + C6091a.m9572bs(9, this.xcr)) + C6091a.m9572bs(10, this.wem)) + C6091a.m9578o(11, this.wen)) + C6091a.m9572bs(12, this.xmL)) + C6091a.m9578o(13, this.xlQ)) + C6091a.m9572bs(14, this.xmY)) + C6091a.m9572bs(15, this.wOQ)) + C6091a.m9572bs(16, this.xlR);
            AppMethodBeat.m2505o(5250);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xmX.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.xlM == null) {
                c6092b = new C6092b("Not all required fields were included: PeerId");
                AppMethodBeat.m2505o(5250);
                throw c6092b;
            } else if (this.xlN == null) {
                c6092b = new C6092b("Not all required fields were included: CapInfo");
                AppMethodBeat.m2505o(5250);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(5250);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cpp cpp = (cpp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            cpx cpx;
            switch (intValue) {
                case 1:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7267hl c7267hl = new C7267hl();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7267hl.populateBuilderWithField(c6086a3, c7267hl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cpp.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(5250);
                    return 0;
                case 2:
                    cpp.wPm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(5250);
                    return 0;
                case 3:
                    cpp.xmW = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5250);
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
                        cpp.xmX.add(bts);
                    }
                    AppMethodBeat.m2505o(5250);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cpx = new cpx();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cpx.populateBuilderWithField(c6086a3, cpx, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cpp.xlM = cpx;
                    }
                    AppMethodBeat.m2505o(5250);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cpx = new cpx();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cpx.populateBuilderWithField(c6086a3, cpx, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cpp.xlN = cpx;
                    }
                    AppMethodBeat.m2505o(5250);
                    return 0;
                case 8:
                    cpp.vZF = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5250);
                    return 0;
                case 9:
                    cpp.xcr = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5250);
                    return 0;
                case 10:
                    cpp.wem = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5250);
                    return 0;
                case 11:
                    cpp.wen = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(5250);
                    return 0;
                case 12:
                    cpp.xmL = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5250);
                    return 0;
                case 13:
                    cpp.xlQ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(5250);
                    return 0;
                case 14:
                    cpp.xmY = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5250);
                    return 0;
                case 15:
                    cpp.wOQ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5250);
                    return 0;
                case 16:
                    cpp.xlR = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5250);
                    return 0;
                default:
                    AppMethodBeat.m2505o(5250);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(5250);
            return -1;
        }
    }
}
