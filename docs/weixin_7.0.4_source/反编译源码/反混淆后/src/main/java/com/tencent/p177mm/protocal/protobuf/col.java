package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.col */
public final class col extends bsr {
    public int vZF;
    public String wPm;
    public int wem;
    public long wen;
    public cpx xlM;
    public cpx xlN;
    public long xlQ;
    public int xlR;
    public int xmb;
    public int xmc;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(5230);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.wPm != null) {
                c6093a.mo13475e(2, this.wPm);
            }
            c6093a.mo13480iz(3, this.wem);
            c6093a.mo13480iz(4, this.xmb);
            if (this.xlM != null) {
                c6093a.mo13479iy(5, this.xlM.computeSize());
                this.xlM.writeFields(c6093a);
            }
            if (this.xlN != null) {
                c6093a.mo13479iy(6, this.xlN.computeSize());
                this.xlN.writeFields(c6093a);
            }
            c6093a.mo13472ai(7, this.wen);
            c6093a.mo13480iz(8, this.vZF);
            c6093a.mo13472ai(9, this.xlQ);
            c6093a.mo13480iz(10, this.xmc);
            c6093a.mo13480iz(11, this.xlR);
            AppMethodBeat.m2505o(5230);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wPm != null) {
                ix += C6091a.m9575f(2, this.wPm);
            }
            ix = (ix + C6091a.m9572bs(3, this.wem)) + C6091a.m9572bs(4, this.xmb);
            if (this.xlM != null) {
                ix += C6087a.m9557ix(5, this.xlM.computeSize());
            }
            if (this.xlN != null) {
                ix += C6087a.m9557ix(6, this.xlN.computeSize());
            }
            int o = ((((ix + C6091a.m9578o(7, this.wen)) + C6091a.m9572bs(8, this.vZF)) + C6091a.m9578o(9, this.xlQ)) + C6091a.m9572bs(10, this.xmc)) + C6091a.m9572bs(11, this.xlR);
            AppMethodBeat.m2505o(5230);
            return o;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(5230);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            col col = (col) objArr[1];
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
                        col.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(5230);
                    return 0;
                case 2:
                    col.wPm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(5230);
                    return 0;
                case 3:
                    col.wem = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5230);
                    return 0;
                case 4:
                    col.xmb = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5230);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cpx = new cpx();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cpx.populateBuilderWithField(c6086a3, cpx, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        col.xlM = cpx;
                    }
                    AppMethodBeat.m2505o(5230);
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
                        col.xlN = cpx;
                    }
                    AppMethodBeat.m2505o(5230);
                    return 0;
                case 7:
                    col.wen = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(5230);
                    return 0;
                case 8:
                    col.vZF = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5230);
                    return 0;
                case 9:
                    col.xlQ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(5230);
                    return 0;
                case 10:
                    col.xmc = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5230);
                    return 0;
                case 11:
                    col.xlR = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5230);
                    return 0;
                default:
                    AppMethodBeat.m2505o(5230);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(5230);
            return -1;
        }
    }
}
