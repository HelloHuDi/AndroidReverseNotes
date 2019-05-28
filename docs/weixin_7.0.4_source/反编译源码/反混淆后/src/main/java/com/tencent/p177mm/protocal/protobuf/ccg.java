package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p696a.C6088a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ccg */
public final class ccg extends bsr {
    public String wZT;
    public long wZU;
    public SKBuiltinBuffer_t wZw;
    public int wZy;
    public LinkedList<Long> xbA = new LinkedList();
    public int xbB;
    public long xbw;
    public int xbx;
    public long xby;
    public int xbz;

    public ccg() {
        AppMethodBeat.m2504i(94616);
        AppMethodBeat.m2505o(94616);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(94617);
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.wZT != null) {
                c6093a.mo13475e(2, this.wZT);
            }
            c6093a.mo13472ai(3, this.wZU);
            c6093a.mo13472ai(4, this.xbw);
            c6093a.mo13480iz(5, this.xbx);
            c6093a.mo13472ai(6, this.xby);
            if (this.wZw != null) {
                c6093a.mo13479iy(7, this.wZw.computeSize());
                this.wZw.writeFields(c6093a);
            }
            c6093a.mo13480iz(8, this.wZy);
            c6093a.mo13480iz(11, this.xbz);
            c6093a.mo13477f(12, 3, this.xbA);
            c6093a.mo13480iz(13, this.xbB);
            AppMethodBeat.m2505o(94617);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wZT != null) {
                ix += C6091a.m9575f(2, this.wZT);
            }
            ix = (((ix + C6091a.m9578o(3, this.wZU)) + C6091a.m9578o(4, this.xbw)) + C6091a.m9572bs(5, this.xbx)) + C6091a.m9578o(6, this.xby);
            if (this.wZw != null) {
                ix += C6087a.m9557ix(7, this.wZw.computeSize());
            }
            int bs = (((ix + C6091a.m9572bs(8, this.wZy)) + C6091a.m9572bs(11, this.xbz)) + C6087a.m9553d(12, 3, this.xbA)) + C6091a.m9572bs(13, this.xbB);
            AppMethodBeat.m2505o(94617);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xbA.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(94617);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            ccg ccg = (ccg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
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
                        ccg.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(94617);
                    return 0;
                case 2:
                    ccg.wZT = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94617);
                    return 0;
                case 3:
                    ccg.wZU = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(94617);
                    return 0;
                case 4:
                    ccg.xbw = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(94617);
                    return 0;
                case 5:
                    ccg.xbx = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94617);
                    return 0;
                case 6:
                    ccg.xby = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(94617);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        ccg.wZw = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(94617);
                    return 0;
                case 8:
                    ccg.wZy = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94617);
                    return 0;
                case 11:
                    ccg.xbz = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94617);
                    return 0;
                case 12:
                    C6088a c6088a = new C6086a(c6086a2.BTU.emu().f1226wR, unknownTagHandler).BTU;
                    LinkedList linkedList = new LinkedList();
                    while (c6088a.bxm < c6088a.bufferSize) {
                        linkedList.add(Long.valueOf(c6088a.mo13459ve()));
                    }
                    ccg.xbA = linkedList;
                    AppMethodBeat.m2505o(94617);
                    return 0;
                case 13:
                    ccg.xbB = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94617);
                    return 0;
                default:
                    AppMethodBeat.m2505o(94617);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(94617);
            return -1;
        }
    }
}
