package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bok */
public final class bok extends bsr {
    public long timestamp;
    public int vZt;
    public int vZu;
    public int wRk;
    public C1332b wRl;
    public C1332b wRm;
    public C1332b wRn;
    public int wRo;
    public C40525hi wmx;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48949);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.wmx != null) {
                c6093a.mo13479iy(2, this.wmx.computeSize());
                this.wmx.writeFields(c6093a);
            }
            c6093a.mo13480iz(3, this.wRk);
            if (this.wRl != null) {
                c6093a.mo13473c(4, this.wRl);
            }
            if (this.wRm != null) {
                c6093a.mo13473c(5, this.wRm);
            }
            if (this.wRn != null) {
                c6093a.mo13473c(6, this.wRn);
            }
            c6093a.mo13480iz(7, this.vZu);
            c6093a.mo13480iz(8, this.vZt);
            c6093a.mo13480iz(9, this.wRo);
            c6093a.mo13472ai(10, this.timestamp);
            AppMethodBeat.m2505o(48949);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wmx != null) {
                ix += C6087a.m9557ix(2, this.wmx.computeSize());
            }
            ix += C6091a.m9572bs(3, this.wRk);
            if (this.wRl != null) {
                ix += C6091a.m9571b(4, this.wRl);
            }
            if (this.wRm != null) {
                ix += C6091a.m9571b(5, this.wRm);
            }
            if (this.wRn != null) {
                ix += C6091a.m9571b(6, this.wRn);
            }
            int bs = (((ix + C6091a.m9572bs(7, this.vZu)) + C6091a.m9572bs(8, this.vZt)) + C6091a.m9572bs(9, this.wRo)) + C6091a.m9578o(10, this.timestamp);
            AppMethodBeat.m2505o(48949);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(48949);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bok bok = (bok) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
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
                        bok.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(48949);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C40525hi c40525hi = new C40525hi();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c40525hi.populateBuilderWithField(c6086a3, c40525hi, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bok.wmx = c40525hi;
                    }
                    AppMethodBeat.m2505o(48949);
                    return 0;
                case 3:
                    bok.wRk = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48949);
                    return 0;
                case 4:
                    bok.wRl = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(48949);
                    return 0;
                case 5:
                    bok.wRm = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(48949);
                    return 0;
                case 6:
                    bok.wRn = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(48949);
                    return 0;
                case 7:
                    bok.vZu = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48949);
                    return 0;
                case 8:
                    bok.vZt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48949);
                    return 0;
                case 9:
                    bok.wRo = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48949);
                    return 0;
                case 10:
                    bok.timestamp = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(48949);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48949);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48949);
            return -1;
        }
    }
}
