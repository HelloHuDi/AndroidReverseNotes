package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ayr */
public final class ayr extends bsr {
    public int vOq;
    public String vQg;
    public C1332b wCA;
    public int wCu;
    public int wCv = 2;
    public double wCw;
    public double wCx;
    public String wCy;
    public C1332b wCz;
    public String wol;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(124321);
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
            if (this.wCy != null) {
                c6093a.mo13475e(9, this.wCy);
            }
            if (this.wCz != null) {
                c6093a.mo13473c(11, this.wCz);
            }
            if (this.wCA != null) {
                c6093a.mo13473c(12, this.wCA);
            }
            AppMethodBeat.m2505o(124321);
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
            ix = ((ix + C6091a.m9572bs(6, this.wCv)) + (C6091a.m9576fv(7) + 8)) + (C6091a.m9576fv(8) + 8);
            if (this.wCy != null) {
                ix += C6091a.m9575f(9, this.wCy);
            }
            if (this.wCz != null) {
                ix += C6091a.m9571b(11, this.wCz);
            }
            if (this.wCA != null) {
                ix += C6091a.m9571b(12, this.wCA);
            }
            AppMethodBeat.m2505o(124321);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(124321);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            ayr ayr = (ayr) objArr[1];
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
                        ayr.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(124321);
                    return 0;
                case 2:
                    ayr.wol = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124321);
                    return 0;
                case 3:
                    ayr.vOq = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124321);
                    return 0;
                case 4:
                    ayr.wCu = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124321);
                    return 0;
                case 5:
                    ayr.vQg = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124321);
                    return 0;
                case 6:
                    ayr.wCv = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124321);
                    return 0;
                case 7:
                    ayr.wCw = Double.longBitsToDouble(c6086a2.BTU.eib());
                    AppMethodBeat.m2505o(124321);
                    return 0;
                case 8:
                    ayr.wCx = Double.longBitsToDouble(c6086a2.BTU.eib());
                    AppMethodBeat.m2505o(124321);
                    return 0;
                case 9:
                    ayr.wCy = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124321);
                    return 0;
                case 11:
                    ayr.wCz = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(124321);
                    return 0;
                case 12:
                    ayr.wCA = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(124321);
                    return 0;
                default:
                    AppMethodBeat.m2505o(124321);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(124321);
            return -1;
        }
    }
}
