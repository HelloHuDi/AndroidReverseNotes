package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.lc */
public final class C7546lc extends bsr {
    public int count;
    public int oZe;
    public int pXL;
    public String pZo;
    public String pZp;
    public int type;
    public String vOA;
    public String vOB;
    public String vOC;
    public String vOD;
    public String vOE;
    public String vOz;
    public String value;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(11727);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.vOz != null) {
                c6093a.mo13475e(2, this.vOz);
            }
            if (this.vOA != null) {
                c6093a.mo13475e(3, this.vOA);
            }
            if (this.vOB != null) {
                c6093a.mo13475e(4, this.vOB);
            }
            if (this.vOC != null) {
                c6093a.mo13475e(5, this.vOC);
            }
            if (this.vOD != null) {
                c6093a.mo13475e(6, this.vOD);
            }
            c6093a.mo13480iz(7, this.pXL);
            if (this.vOE != null) {
                c6093a.mo13475e(8, this.vOE);
            }
            if (this.pZp != null) {
                c6093a.mo13475e(9, this.pZp);
            }
            if (this.pZo != null) {
                c6093a.mo13475e(10, this.pZo);
            }
            c6093a.mo13480iz(11, this.type);
            if (this.value != null) {
                c6093a.mo13475e(12, this.value);
            }
            c6093a.mo13480iz(13, this.count);
            c6093a.mo13480iz(14, this.oZe);
            AppMethodBeat.m2505o(11727);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vOz != null) {
                ix += C6091a.m9575f(2, this.vOz);
            }
            if (this.vOA != null) {
                ix += C6091a.m9575f(3, this.vOA);
            }
            if (this.vOB != null) {
                ix += C6091a.m9575f(4, this.vOB);
            }
            if (this.vOC != null) {
                ix += C6091a.m9575f(5, this.vOC);
            }
            if (this.vOD != null) {
                ix += C6091a.m9575f(6, this.vOD);
            }
            ix += C6091a.m9572bs(7, this.pXL);
            if (this.vOE != null) {
                ix += C6091a.m9575f(8, this.vOE);
            }
            if (this.pZp != null) {
                ix += C6091a.m9575f(9, this.pZp);
            }
            if (this.pZo != null) {
                ix += C6091a.m9575f(10, this.pZo);
            }
            ix += C6091a.m9572bs(11, this.type);
            if (this.value != null) {
                ix += C6091a.m9575f(12, this.value);
            }
            int bs = (ix + C6091a.m9572bs(13, this.count)) + C6091a.m9572bs(14, this.oZe);
            AppMethodBeat.m2505o(11727);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(11727);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C7546lc c7546lc = (C7546lc) objArr[1];
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
                        c7546lc.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(11727);
                    return 0;
                case 2:
                    c7546lc.vOz = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(11727);
                    return 0;
                case 3:
                    c7546lc.vOA = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(11727);
                    return 0;
                case 4:
                    c7546lc.vOB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(11727);
                    return 0;
                case 5:
                    c7546lc.vOC = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(11727);
                    return 0;
                case 6:
                    c7546lc.vOD = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(11727);
                    return 0;
                case 7:
                    c7546lc.pXL = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(11727);
                    return 0;
                case 8:
                    c7546lc.vOE = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(11727);
                    return 0;
                case 9:
                    c7546lc.pZp = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(11727);
                    return 0;
                case 10:
                    c7546lc.pZo = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(11727);
                    return 0;
                case 11:
                    c7546lc.type = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(11727);
                    return 0;
                case 12:
                    c7546lc.value = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(11727);
                    return 0;
                case 13:
                    c7546lc.count = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(11727);
                    return 0;
                case 14:
                    c7546lc.oZe = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(11727);
                    return 0;
                default:
                    AppMethodBeat.m2505o(11727);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(11727);
            return -1;
        }
    }
}
