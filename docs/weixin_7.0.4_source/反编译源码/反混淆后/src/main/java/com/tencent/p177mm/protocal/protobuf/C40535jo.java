package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.jo */
public final class C40535jo extends bsr {
    public String jBB;
    public String luQ;
    public String vHS;
    public int vIJ;
    public String vIj;
    public int vLA;
    public int vLB;
    public int vLC;
    public String vLD;
    public SKBuiltinBuffer_t vLE;
    public SKBuiltinBuffer_t vLF;
    public String vLG;
    public String vLs;
    public String vLt;
    public int vLu;
    public String vLv;
    public int vLw;
    public String vLx;
    public String vLy;
    public SKBuiltinBuffer_t vLz;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(123506);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.jBB != null) {
                c6093a.mo13475e(2, this.jBB);
            }
            if (this.vLs != null) {
                c6093a.mo13475e(3, this.vLs);
            }
            c6093a.mo13480iz(4, this.vIJ);
            if (this.vLt != null) {
                c6093a.mo13475e(5, this.vLt);
            }
            c6093a.mo13480iz(6, this.vLu);
            if (this.vLv != null) {
                c6093a.mo13475e(7, this.vLv);
            }
            if (this.vHS != null) {
                c6093a.mo13475e(8, this.vHS);
            }
            c6093a.mo13480iz(9, this.vLw);
            if (this.vLx != null) {
                c6093a.mo13475e(10, this.vLx);
            }
            if (this.vLy != null) {
                c6093a.mo13475e(11, this.vLy);
            }
            if (this.vLz != null) {
                c6093a.mo13479iy(12, this.vLz.computeSize());
                this.vLz.writeFields(c6093a);
            }
            if (this.luQ != null) {
                c6093a.mo13475e(13, this.luQ);
            }
            c6093a.mo13480iz(14, this.vLA);
            c6093a.mo13480iz(15, this.vLB);
            if (this.vIj != null) {
                c6093a.mo13475e(16, this.vIj);
            }
            c6093a.mo13480iz(17, this.vLC);
            if (this.vLD != null) {
                c6093a.mo13475e(18, this.vLD);
            }
            if (this.vLE != null) {
                c6093a.mo13479iy(19, this.vLE.computeSize());
                this.vLE.writeFields(c6093a);
            }
            if (this.vLF != null) {
                c6093a.mo13479iy(20, this.vLF.computeSize());
                this.vLF.writeFields(c6093a);
            }
            if (this.vLG != null) {
                c6093a.mo13475e(21, this.vLG);
            }
            AppMethodBeat.m2505o(123506);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.jBB != null) {
                ix += C6091a.m9575f(2, this.jBB);
            }
            if (this.vLs != null) {
                ix += C6091a.m9575f(3, this.vLs);
            }
            ix += C6091a.m9572bs(4, this.vIJ);
            if (this.vLt != null) {
                ix += C6091a.m9575f(5, this.vLt);
            }
            ix += C6091a.m9572bs(6, this.vLu);
            if (this.vLv != null) {
                ix += C6091a.m9575f(7, this.vLv);
            }
            if (this.vHS != null) {
                ix += C6091a.m9575f(8, this.vHS);
            }
            ix += C6091a.m9572bs(9, this.vLw);
            if (this.vLx != null) {
                ix += C6091a.m9575f(10, this.vLx);
            }
            if (this.vLy != null) {
                ix += C6091a.m9575f(11, this.vLy);
            }
            if (this.vLz != null) {
                ix += C6087a.m9557ix(12, this.vLz.computeSize());
            }
            if (this.luQ != null) {
                ix += C6091a.m9575f(13, this.luQ);
            }
            ix = (ix + C6091a.m9572bs(14, this.vLA)) + C6091a.m9572bs(15, this.vLB);
            if (this.vIj != null) {
                ix += C6091a.m9575f(16, this.vIj);
            }
            ix += C6091a.m9572bs(17, this.vLC);
            if (this.vLD != null) {
                ix += C6091a.m9575f(18, this.vLD);
            }
            if (this.vLE != null) {
                ix += C6087a.m9557ix(19, this.vLE.computeSize());
            }
            if (this.vLF != null) {
                ix += C6087a.m9557ix(20, this.vLF.computeSize());
            }
            if (this.vLG != null) {
                ix += C6091a.m9575f(21, this.vLG);
            }
            AppMethodBeat.m2505o(123506);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(123506);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C40535jo c40535jo = (C40535jo) objArr[1];
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
                        c40535jo.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(123506);
                    return 0;
                case 2:
                    c40535jo.jBB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(123506);
                    return 0;
                case 3:
                    c40535jo.vLs = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(123506);
                    return 0;
                case 4:
                    c40535jo.vIJ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(123506);
                    return 0;
                case 5:
                    c40535jo.vLt = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(123506);
                    return 0;
                case 6:
                    c40535jo.vLu = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(123506);
                    return 0;
                case 7:
                    c40535jo.vLv = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(123506);
                    return 0;
                case 8:
                    c40535jo.vHS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(123506);
                    return 0;
                case 9:
                    c40535jo.vLw = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(123506);
                    return 0;
                case 10:
                    c40535jo.vLx = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(123506);
                    return 0;
                case 11:
                    c40535jo.vLy = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(123506);
                    return 0;
                case 12:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c40535jo.vLz = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(123506);
                    return 0;
                case 13:
                    c40535jo.luQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(123506);
                    return 0;
                case 14:
                    c40535jo.vLA = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(123506);
                    return 0;
                case 15:
                    c40535jo.vLB = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(123506);
                    return 0;
                case 16:
                    c40535jo.vIj = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(123506);
                    return 0;
                case 17:
                    c40535jo.vLC = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(123506);
                    return 0;
                case 18:
                    c40535jo.vLD = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(123506);
                    return 0;
                case 19:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c40535jo.vLE = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(123506);
                    return 0;
                case 20:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c40535jo.vLF = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(123506);
                    return 0;
                case 21:
                    c40535jo.vLG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(123506);
                    return 0;
                default:
                    AppMethodBeat.m2505o(123506);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(123506);
            return -1;
        }
    }
}
