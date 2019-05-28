package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.aah */
public final class aah extends bsr {
    public String csB;
    public int cvd;
    public int lSN;
    public float wfA;
    public int wfB;
    public String wfo;
    public long wfw;
    public String wfx;
    public String wfy;
    public int wfz;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(841);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.csB != null) {
                c6093a.mo13475e(2, this.csB);
            }
            c6093a.mo13472ai(3, this.wfw);
            if (this.wfo != null) {
                c6093a.mo13475e(4, this.wfo);
            }
            if (this.wfx != null) {
                c6093a.mo13475e(5, this.wfx);
            }
            if (this.wfy != null) {
                c6093a.mo13475e(6, this.wfy);
            }
            c6093a.mo13480iz(7, this.cvd);
            c6093a.mo13480iz(8, this.wfz);
            c6093a.mo13480iz(9, this.lSN);
            c6093a.mo13481r(10, this.wfA);
            c6093a.mo13480iz(11, this.wfB);
            AppMethodBeat.m2505o(841);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.csB != null) {
                ix += C6091a.m9575f(2, this.csB);
            }
            ix += C6091a.m9578o(3, this.wfw);
            if (this.wfo != null) {
                ix += C6091a.m9575f(4, this.wfo);
            }
            if (this.wfx != null) {
                ix += C6091a.m9575f(5, this.wfx);
            }
            if (this.wfy != null) {
                ix += C6091a.m9575f(6, this.wfy);
            }
            int bs = ((((ix + C6091a.m9572bs(7, this.cvd)) + C6091a.m9572bs(8, this.wfz)) + C6091a.m9572bs(9, this.lSN)) + (C6091a.m9576fv(10) + 4)) + C6091a.m9572bs(11, this.wfB);
            AppMethodBeat.m2505o(841);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(841);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            aah aah = (aah) objArr[1];
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
                        aah.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(841);
                    return 0;
                case 2:
                    aah.csB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(841);
                    return 0;
                case 3:
                    aah.wfw = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(841);
                    return 0;
                case 4:
                    aah.wfo = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(841);
                    return 0;
                case 5:
                    aah.wfx = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(841);
                    return 0;
                case 6:
                    aah.wfy = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(841);
                    return 0;
                case 7:
                    aah.cvd = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(841);
                    return 0;
                case 8:
                    aah.wfz = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(841);
                    return 0;
                case 9:
                    aah.lSN = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(841);
                    return 0;
                case 10:
                    aah.wfA = Float.intBitsToFloat(c6086a2.BTU.eia());
                    AppMethodBeat.m2505o(841);
                    return 0;
                case 11:
                    aah.wfB = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(841);
                    return 0;
                default:
                    AppMethodBeat.m2505o(841);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(841);
            return -1;
        }
    }
}
