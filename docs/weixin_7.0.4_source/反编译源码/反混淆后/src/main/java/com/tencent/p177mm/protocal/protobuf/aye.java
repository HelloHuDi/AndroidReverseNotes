package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.aye */
public final class aye extends bsr {
    public int OpCode;
    public String fLc;
    public float vRp;
    public float vRq;
    public int wCj;
    public int wCk;
    public int wfG;
    public String wfH;
    public String wfI;
    public int wfJ;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(55530);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.OpCode);
            c6093a.mo13481r(3, this.vRp);
            c6093a.mo13481r(4, this.vRq);
            c6093a.mo13480iz(5, this.wfG);
            if (this.wfH != null) {
                c6093a.mo13475e(6, this.wfH);
            }
            if (this.wfI != null) {
                c6093a.mo13475e(7, this.wfI);
            }
            c6093a.mo13480iz(8, this.wfJ);
            if (this.fLc != null) {
                c6093a.mo13475e(9, this.fLc);
            }
            c6093a.mo13480iz(10, this.wCj);
            c6093a.mo13480iz(11, this.wCk);
            AppMethodBeat.m2505o(55530);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (((ix + C6091a.m9572bs(2, this.OpCode)) + (C6091a.m9576fv(3) + 4)) + (C6091a.m9576fv(4) + 4)) + C6091a.m9572bs(5, this.wfG);
            if (this.wfH != null) {
                ix += C6091a.m9575f(6, this.wfH);
            }
            if (this.wfI != null) {
                ix += C6091a.m9575f(7, this.wfI);
            }
            ix += C6091a.m9572bs(8, this.wfJ);
            if (this.fLc != null) {
                ix += C6091a.m9575f(9, this.fLc);
            }
            int bs = (ix + C6091a.m9572bs(10, this.wCj)) + C6091a.m9572bs(11, this.wCk);
            AppMethodBeat.m2505o(55530);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(55530);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            aye aye = (aye) objArr[1];
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
                        aye.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(55530);
                    return 0;
                case 2:
                    aye.OpCode = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(55530);
                    return 0;
                case 3:
                    aye.vRp = Float.intBitsToFloat(c6086a2.BTU.eia());
                    AppMethodBeat.m2505o(55530);
                    return 0;
                case 4:
                    aye.vRq = Float.intBitsToFloat(c6086a2.BTU.eia());
                    AppMethodBeat.m2505o(55530);
                    return 0;
                case 5:
                    aye.wfG = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(55530);
                    return 0;
                case 6:
                    aye.wfH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55530);
                    return 0;
                case 7:
                    aye.wfI = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55530);
                    return 0;
                case 8:
                    aye.wfJ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(55530);
                    return 0;
                case 9:
                    aye.fLc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55530);
                    return 0;
                case 10:
                    aye.wCj = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(55530);
                    return 0;
                case 11:
                    aye.wCk = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(55530);
                    return 0;
                default:
                    AppMethodBeat.m2505o(55530);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(55530);
            return -1;
        }
    }
}
