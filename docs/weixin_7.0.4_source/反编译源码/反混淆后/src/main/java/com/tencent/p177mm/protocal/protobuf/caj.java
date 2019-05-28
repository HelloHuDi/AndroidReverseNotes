package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.caj */
public final class caj extends bsr {
    public int Scene;
    public int vFH;
    public brf vFa;
    public long vQE;
    public SKBuiltinBuffer_t wZw;
    public SKBuiltinBuffer_t wZx;
    public int wZy;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(94559);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            c6093a.mo13472ai(2, this.vQE);
            c6093a.mo13480iz(3, this.Scene);
            if (this.wZw != null) {
                c6093a.mo13479iy(4, this.wZw.computeSize());
                this.wZw.writeFields(c6093a);
            }
            c6093a.mo13480iz(5, this.vFH);
            if (this.wZx != null) {
                c6093a.mo13479iy(6, this.wZx.computeSize());
                this.wZx.writeFields(c6093a);
            }
            c6093a.mo13480iz(7, this.wZy);
            if (this.vFa != null) {
                c6093a.mo13479iy(8, this.vFa.computeSize());
                this.vFa.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(94559);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + C6091a.m9578o(2, this.vQE)) + C6091a.m9572bs(3, this.Scene);
            if (this.wZw != null) {
                ix += C6087a.m9557ix(4, this.wZw.computeSize());
            }
            ix += C6091a.m9572bs(5, this.vFH);
            if (this.wZx != null) {
                ix += C6087a.m9557ix(6, this.wZx.computeSize());
            }
            ix += C6091a.m9572bs(7, this.wZy);
            if (this.vFa != null) {
                ix += C6087a.m9557ix(8, this.vFa.computeSize());
            }
            AppMethodBeat.m2505o(94559);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(94559);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            caj caj = (caj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
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
                        caj.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(94559);
                    return 0;
                case 2:
                    caj.vQE = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(94559);
                    return 0;
                case 3:
                    caj.Scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94559);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        caj.wZw = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(94559);
                    return 0;
                case 5:
                    caj.vFH = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94559);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        caj.wZx = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(94559);
                    return 0;
                case 7:
                    caj.wZy = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94559);
                    return 0;
                case 8:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        brf brf = new brf();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = brf.populateBuilderWithField(c6086a3, brf, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        caj.vFa = brf;
                    }
                    AppMethodBeat.m2505o(94559);
                    return 0;
                default:
                    AppMethodBeat.m2505o(94559);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(94559);
            return -1;
        }
    }
}
