package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.coh */
public final class coh extends bsr {
    public int vZF;
    public String wPm;
    public int wem;
    public long wen;
    public int xlL;
    public cpx xlM;
    public cpx xlN;
    public String xlO;
    public int xlP;
    public long xlQ;
    public int xlR;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(5225);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.wem);
            c6093a.mo13472ai(3, this.wen);
            if (this.wPm != null) {
                c6093a.mo13475e(4, this.wPm);
            }
            c6093a.mo13480iz(5, this.xlL);
            if (this.xlM != null) {
                c6093a.mo13479iy(6, this.xlM.computeSize());
                this.xlM.writeFields(c6093a);
            }
            if (this.xlN != null) {
                c6093a.mo13479iy(7, this.xlN.computeSize());
                this.xlN.writeFields(c6093a);
            }
            c6093a.mo13480iz(8, this.vZF);
            if (this.xlO != null) {
                c6093a.mo13475e(9, this.xlO);
            }
            c6093a.mo13480iz(10, this.xlP);
            c6093a.mo13472ai(11, this.xlQ);
            c6093a.mo13480iz(12, this.xlR);
            AppMethodBeat.m2505o(5225);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + C6091a.m9572bs(2, this.wem)) + C6091a.m9578o(3, this.wen);
            if (this.wPm != null) {
                ix += C6091a.m9575f(4, this.wPm);
            }
            ix += C6091a.m9572bs(5, this.xlL);
            if (this.xlM != null) {
                ix += C6087a.m9557ix(6, this.xlM.computeSize());
            }
            if (this.xlN != null) {
                ix += C6087a.m9557ix(7, this.xlN.computeSize());
            }
            ix += C6091a.m9572bs(8, this.vZF);
            if (this.xlO != null) {
                ix += C6091a.m9575f(9, this.xlO);
            }
            int bs = ((ix + C6091a.m9572bs(10, this.xlP)) + C6091a.m9578o(11, this.xlQ)) + C6091a.m9572bs(12, this.xlR);
            AppMethodBeat.m2505o(5225);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(5225);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            coh coh = (coh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
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
                        coh.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(5225);
                    return 0;
                case 2:
                    coh.wem = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5225);
                    return 0;
                case 3:
                    coh.wen = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(5225);
                    return 0;
                case 4:
                    coh.wPm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(5225);
                    return 0;
                case 5:
                    coh.xlL = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5225);
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
                        coh.xlM = cpx;
                    }
                    AppMethodBeat.m2505o(5225);
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
                        coh.xlN = cpx;
                    }
                    AppMethodBeat.m2505o(5225);
                    return 0;
                case 8:
                    coh.vZF = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5225);
                    return 0;
                case 9:
                    coh.xlO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(5225);
                    return 0;
                case 10:
                    coh.xlP = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5225);
                    return 0;
                case 11:
                    coh.xlQ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(5225);
                    return 0;
                case 12:
                    coh.xlR = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5225);
                    return 0;
                default:
                    AppMethodBeat.m2505o(5225);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(5225);
            return -1;
        }
    }
}
