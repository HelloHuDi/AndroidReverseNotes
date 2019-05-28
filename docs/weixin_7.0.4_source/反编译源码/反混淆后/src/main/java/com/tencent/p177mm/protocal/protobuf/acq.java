package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.acq */
public final class acq extends C1331a {
    public String jBB;
    public String jCH;
    public String mZW;
    public int vAO;
    public String vEn;
    public String vLo;
    public String vYQ;
    public String wkr;
    public String wks;
    public String wkt;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28414);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vEn != null) {
                c6093a.mo13475e(1, this.vEn);
            }
            if (this.jCH != null) {
                c6093a.mo13475e(2, this.jCH);
            }
            if (this.jBB != null) {
                c6093a.mo13475e(3, this.jBB);
            }
            if (this.mZW != null) {
                c6093a.mo13475e(4, this.mZW);
            }
            if (this.wkr != null) {
                c6093a.mo13475e(5, this.wkr);
            }
            if (this.wks != null) {
                c6093a.mo13475e(6, this.wks);
            }
            if (this.vLo != null) {
                c6093a.mo13475e(7, this.vLo);
            }
            if (this.vYQ != null) {
                c6093a.mo13475e(8, this.vYQ);
            }
            if (this.wkt != null) {
                c6093a.mo13475e(9, this.wkt);
            }
            c6093a.mo13480iz(10, this.vAO);
            AppMethodBeat.m2505o(28414);
            return 0;
        } else if (i == 1) {
            if (this.vEn != null) {
                f = C6091a.m9575f(1, this.vEn) + 0;
            } else {
                f = 0;
            }
            if (this.jCH != null) {
                f += C6091a.m9575f(2, this.jCH);
            }
            if (this.jBB != null) {
                f += C6091a.m9575f(3, this.jBB);
            }
            if (this.mZW != null) {
                f += C6091a.m9575f(4, this.mZW);
            }
            if (this.wkr != null) {
                f += C6091a.m9575f(5, this.wkr);
            }
            if (this.wks != null) {
                f += C6091a.m9575f(6, this.wks);
            }
            if (this.vLo != null) {
                f += C6091a.m9575f(7, this.vLo);
            }
            if (this.vYQ != null) {
                f += C6091a.m9575f(8, this.vYQ);
            }
            if (this.wkt != null) {
                f += C6091a.m9575f(9, this.wkt);
            }
            int bs = f + C6091a.m9572bs(10, this.vAO);
            AppMethodBeat.m2505o(28414);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(28414);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            acq acq = (acq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    acq.vEn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28414);
                    return 0;
                case 2:
                    acq.jCH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28414);
                    return 0;
                case 3:
                    acq.jBB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28414);
                    return 0;
                case 4:
                    acq.mZW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28414);
                    return 0;
                case 5:
                    acq.wkr = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28414);
                    return 0;
                case 6:
                    acq.wks = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28414);
                    return 0;
                case 7:
                    acq.vLo = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28414);
                    return 0;
                case 8:
                    acq.vYQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28414);
                    return 0;
                case 9:
                    acq.wkt = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28414);
                    return 0;
                case 10:
                    acq.vAO = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28414);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28414);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28414);
            return -1;
        }
    }
}
