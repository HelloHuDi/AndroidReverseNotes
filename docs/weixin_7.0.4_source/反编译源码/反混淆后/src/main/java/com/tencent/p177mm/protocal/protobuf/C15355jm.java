package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.jm */
public final class C15355jm extends bsr {
    public int vIJ;
    public int vLk;
    public String vLl;
    public String vLm;
    public String vLn;
    public String vLo;
    public String vLp;
    public String vLq;
    public String vLr;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(73693);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.vIJ);
            c6093a.mo13480iz(3, this.vLk);
            if (this.vLl != null) {
                c6093a.mo13475e(4, this.vLl);
            }
            if (this.vLm != null) {
                c6093a.mo13475e(5, this.vLm);
            }
            if (this.vLn != null) {
                c6093a.mo13475e(6, this.vLn);
            }
            if (this.vLo != null) {
                c6093a.mo13475e(7, this.vLo);
            }
            if (this.vLp != null) {
                c6093a.mo13475e(8, this.vLp);
            }
            if (this.vLq != null) {
                c6093a.mo13475e(9, this.vLq);
            }
            if (this.vLr != null) {
                c6093a.mo13475e(10, this.vLr);
            }
            AppMethodBeat.m2505o(73693);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + C6091a.m9572bs(2, this.vIJ)) + C6091a.m9572bs(3, this.vLk);
            if (this.vLl != null) {
                ix += C6091a.m9575f(4, this.vLl);
            }
            if (this.vLm != null) {
                ix += C6091a.m9575f(5, this.vLm);
            }
            if (this.vLn != null) {
                ix += C6091a.m9575f(6, this.vLn);
            }
            if (this.vLo != null) {
                ix += C6091a.m9575f(7, this.vLo);
            }
            if (this.vLp != null) {
                ix += C6091a.m9575f(8, this.vLp);
            }
            if (this.vLq != null) {
                ix += C6091a.m9575f(9, this.vLq);
            }
            if (this.vLr != null) {
                ix += C6091a.m9575f(10, this.vLr);
            }
            AppMethodBeat.m2505o(73693);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(73693);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C15355jm c15355jm = (C15355jm) objArr[1];
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
                        c15355jm.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(73693);
                    return 0;
                case 2:
                    c15355jm.vIJ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(73693);
                    return 0;
                case 3:
                    c15355jm.vLk = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(73693);
                    return 0;
                case 4:
                    c15355jm.vLl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73693);
                    return 0;
                case 5:
                    c15355jm.vLm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73693);
                    return 0;
                case 6:
                    c15355jm.vLn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73693);
                    return 0;
                case 7:
                    c15355jm.vLo = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73693);
                    return 0;
                case 8:
                    c15355jm.vLp = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73693);
                    return 0;
                case 9:
                    c15355jm.vLq = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73693);
                    return 0;
                case 10:
                    c15355jm.vLr = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73693);
                    return 0;
                default:
                    AppMethodBeat.m2505o(73693);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(73693);
            return -1;
        }
    }
}
