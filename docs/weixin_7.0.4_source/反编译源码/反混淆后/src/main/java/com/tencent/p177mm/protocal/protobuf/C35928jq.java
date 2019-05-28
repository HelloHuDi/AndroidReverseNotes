package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.jq */
public final class C35928jq extends bsr {
    public SKBuiltinBuffer_t vJT;
    public String vLJ;
    public int vLV;
    public String vLW;
    public String vLX;
    public String vLY;
    public int vLZ;
    public String vLx;
    public String vLy;
    public bts vMa;
    public SKBuiltinBuffer_t vMb;
    public int vMc;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(73695);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.vLV);
            if (this.vLJ != null) {
                c6093a.mo13475e(3, this.vLJ);
            }
            if (this.vLW != null) {
                c6093a.mo13475e(4, this.vLW);
            }
            if (this.vLX != null) {
                c6093a.mo13475e(5, this.vLX);
            }
            if (this.vLY != null) {
                c6093a.mo13475e(6, this.vLY);
            }
            c6093a.mo13480iz(7, this.vLZ);
            if (this.vMa != null) {
                c6093a.mo13479iy(8, this.vMa.computeSize());
                this.vMa.writeFields(c6093a);
            }
            if (this.vMb != null) {
                c6093a.mo13479iy(9, this.vMb.computeSize());
                this.vMb.writeFields(c6093a);
            }
            c6093a.mo13480iz(10, this.vMc);
            if (this.vLx != null) {
                c6093a.mo13475e(11, this.vLx);
            }
            if (this.vLy != null) {
                c6093a.mo13475e(12, this.vLy);
            }
            if (this.vJT != null) {
                c6093a.mo13479iy(13, this.vJT.computeSize());
                this.vJT.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(73695);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += C6091a.m9572bs(2, this.vLV);
            if (this.vLJ != null) {
                ix += C6091a.m9575f(3, this.vLJ);
            }
            if (this.vLW != null) {
                ix += C6091a.m9575f(4, this.vLW);
            }
            if (this.vLX != null) {
                ix += C6091a.m9575f(5, this.vLX);
            }
            if (this.vLY != null) {
                ix += C6091a.m9575f(6, this.vLY);
            }
            ix += C6091a.m9572bs(7, this.vLZ);
            if (this.vMa != null) {
                ix += C6087a.m9557ix(8, this.vMa.computeSize());
            }
            if (this.vMb != null) {
                ix += C6087a.m9557ix(9, this.vMb.computeSize());
            }
            ix += C6091a.m9572bs(10, this.vMc);
            if (this.vLx != null) {
                ix += C6091a.m9575f(11, this.vLx);
            }
            if (this.vLy != null) {
                ix += C6091a.m9575f(12, this.vLy);
            }
            if (this.vJT != null) {
                ix += C6087a.m9557ix(13, this.vJT.computeSize());
            }
            AppMethodBeat.m2505o(73695);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(73695);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C35928jq c35928jq = (C35928jq) objArr[1];
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
                        c35928jq.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(73695);
                    return 0;
                case 2:
                    c35928jq.vLV = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(73695);
                    return 0;
                case 3:
                    c35928jq.vLJ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73695);
                    return 0;
                case 4:
                    c35928jq.vLW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73695);
                    return 0;
                case 5:
                    c35928jq.vLX = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73695);
                    return 0;
                case 6:
                    c35928jq.vLY = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73695);
                    return 0;
                case 7:
                    c35928jq.vLZ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(73695);
                    return 0;
                case 8:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c35928jq.vMa = bts;
                    }
                    AppMethodBeat.m2505o(73695);
                    return 0;
                case 9:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c35928jq.vMb = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(73695);
                    return 0;
                case 10:
                    c35928jq.vMc = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(73695);
                    return 0;
                case 11:
                    c35928jq.vLx = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73695);
                    return 0;
                case 12:
                    c35928jq.vLy = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73695);
                    return 0;
                case 13:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c35928jq.vJT = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(73695);
                    return 0;
                default:
                    AppMethodBeat.m2505o(73695);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(73695);
            return -1;
        }
    }
}
