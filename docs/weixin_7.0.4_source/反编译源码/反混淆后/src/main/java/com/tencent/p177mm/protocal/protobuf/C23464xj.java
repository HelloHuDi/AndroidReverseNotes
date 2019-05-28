package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.xj */
public final class C23464xj extends bsr {
    public String fKh;
    public String fKk;
    public String jBB;
    public int jCt;
    public long ptF;
    public int ptw;
    public int ptx;
    public int pty;
    public int vFE;
    public String wdi;
    public int wdj;
    public int wdk;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(135756);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.fKh != null) {
                c6093a.mo13475e(2, this.fKh);
            }
            c6093a.mo13480iz(3, this.vFE);
            if (this.fKk != null) {
                c6093a.mo13475e(4, this.fKk);
            }
            if (this.jBB != null) {
                c6093a.mo13475e(5, this.jBB);
            }
            c6093a.mo13480iz(6, this.ptw);
            c6093a.mo13480iz(7, this.ptx);
            c6093a.mo13480iz(8, this.pty);
            if (this.wdi != null) {
                c6093a.mo13475e(9, this.wdi);
            }
            c6093a.mo13480iz(10, this.wdj);
            c6093a.mo13480iz(11, this.jCt);
            c6093a.mo13480iz(12, this.wdk);
            c6093a.mo13472ai(13, this.ptF);
            AppMethodBeat.m2505o(135756);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.fKh != null) {
                ix += C6091a.m9575f(2, this.fKh);
            }
            ix += C6091a.m9572bs(3, this.vFE);
            if (this.fKk != null) {
                ix += C6091a.m9575f(4, this.fKk);
            }
            if (this.jBB != null) {
                ix += C6091a.m9575f(5, this.jBB);
            }
            ix = ((ix + C6091a.m9572bs(6, this.ptw)) + C6091a.m9572bs(7, this.ptx)) + C6091a.m9572bs(8, this.pty);
            if (this.wdi != null) {
                ix += C6091a.m9575f(9, this.wdi);
            }
            int bs = (((ix + C6091a.m9572bs(10, this.wdj)) + C6091a.m9572bs(11, this.jCt)) + C6091a.m9572bs(12, this.wdk)) + C6091a.m9578o(13, this.ptF);
            AppMethodBeat.m2505o(135756);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(135756);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C23464xj c23464xj = (C23464xj) objArr[1];
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
                        c23464xj.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(135756);
                    return 0;
                case 2:
                    c23464xj.fKh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(135756);
                    return 0;
                case 3:
                    c23464xj.vFE = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(135756);
                    return 0;
                case 4:
                    c23464xj.fKk = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(135756);
                    return 0;
                case 5:
                    c23464xj.jBB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(135756);
                    return 0;
                case 6:
                    c23464xj.ptw = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(135756);
                    return 0;
                case 7:
                    c23464xj.ptx = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(135756);
                    return 0;
                case 8:
                    c23464xj.pty = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(135756);
                    return 0;
                case 9:
                    c23464xj.wdi = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(135756);
                    return 0;
                case 10:
                    c23464xj.wdj = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(135756);
                    return 0;
                case 11:
                    c23464xj.jCt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(135756);
                    return 0;
                case 12:
                    c23464xj.wdk = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(135756);
                    return 0;
                case 13:
                    c23464xj.ptF = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(135756);
                    return 0;
                default:
                    AppMethodBeat.m2505o(135756);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(135756);
            return -1;
        }
    }
}
