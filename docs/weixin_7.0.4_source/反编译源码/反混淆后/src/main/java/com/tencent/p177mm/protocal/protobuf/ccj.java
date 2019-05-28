package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ccj */
public final class ccj extends bsr {
    public String fKh;
    public int jCt;
    public String ptv;
    public int ptw;
    public int ptx;
    public String vEA;
    public SKBuiltinBuffer_t vJd;
    public int vZF;
    public int wFd;
    public int wFe;
    public int wGz;
    public civ wNQ;
    public String wdO;
    public int xbN;
    public int xbO;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(94620);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vJd == null) {
                c6092b = new C6092b("Not all required fields were included: Buffer");
                AppMethodBeat.m2505o(94620);
                throw c6092b;
            }
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.jCt);
            c6093a.mo13480iz(3, this.ptx);
            c6093a.mo13480iz(4, this.ptw);
            if (this.vJd != null) {
                c6093a.mo13479iy(5, this.vJd.computeSize());
                this.vJd.writeFields(c6093a);
            }
            if (this.ptv != null) {
                c6093a.mo13475e(6, this.ptv);
            }
            c6093a.mo13480iz(7, this.wFd);
            c6093a.mo13480iz(8, this.wFe);
            if (this.vEA != null) {
                c6093a.mo13475e(9, this.vEA);
            }
            c6093a.mo13480iz(10, this.xbN);
            c6093a.mo13480iz(11, this.vZF);
            if (this.wNQ != null) {
                c6093a.mo13479iy(12, this.wNQ.computeSize());
                this.wNQ.writeFields(c6093a);
            }
            if (this.fKh != null) {
                c6093a.mo13475e(13, this.fKh);
            }
            c6093a.mo13480iz(14, this.wGz);
            if (this.wdO != null) {
                c6093a.mo13475e(15, this.wdO);
            }
            c6093a.mo13480iz(16, this.xbO);
            AppMethodBeat.m2505o(94620);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = ((ix + C6091a.m9572bs(2, this.jCt)) + C6091a.m9572bs(3, this.ptx)) + C6091a.m9572bs(4, this.ptw);
            if (this.vJd != null) {
                ix += C6087a.m9557ix(5, this.vJd.computeSize());
            }
            if (this.ptv != null) {
                ix += C6091a.m9575f(6, this.ptv);
            }
            ix = (ix + C6091a.m9572bs(7, this.wFd)) + C6091a.m9572bs(8, this.wFe);
            if (this.vEA != null) {
                ix += C6091a.m9575f(9, this.vEA);
            }
            ix = (ix + C6091a.m9572bs(10, this.xbN)) + C6091a.m9572bs(11, this.vZF);
            if (this.wNQ != null) {
                ix += C6087a.m9557ix(12, this.wNQ.computeSize());
            }
            if (this.fKh != null) {
                ix += C6091a.m9575f(13, this.fKh);
            }
            ix += C6091a.m9572bs(14, this.wGz);
            if (this.wdO != null) {
                ix += C6091a.m9575f(15, this.wdO);
            }
            int bs = ix + C6091a.m9572bs(16, this.xbO);
            AppMethodBeat.m2505o(94620);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.vJd == null) {
                c6092b = new C6092b("Not all required fields were included: Buffer");
                AppMethodBeat.m2505o(94620);
                throw c6092b;
            }
            AppMethodBeat.m2505o(94620);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            ccj ccj = (ccj) objArr[1];
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
                        ccj.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(94620);
                    return 0;
                case 2:
                    ccj.jCt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94620);
                    return 0;
                case 3:
                    ccj.ptx = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94620);
                    return 0;
                case 4:
                    ccj.ptw = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94620);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        ccj.vJd = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(94620);
                    return 0;
                case 6:
                    ccj.ptv = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94620);
                    return 0;
                case 7:
                    ccj.wFd = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94620);
                    return 0;
                case 8:
                    ccj.wFe = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94620);
                    return 0;
                case 9:
                    ccj.vEA = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94620);
                    return 0;
                case 10:
                    ccj.xbN = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94620);
                    return 0;
                case 11:
                    ccj.vZF = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94620);
                    return 0;
                case 12:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        civ civ = new civ();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = civ.populateBuilderWithField(c6086a3, civ, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        ccj.wNQ = civ;
                    }
                    AppMethodBeat.m2505o(94620);
                    return 0;
                case 13:
                    ccj.fKh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94620);
                    return 0;
                case 14:
                    ccj.wGz = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94620);
                    return 0;
                case 15:
                    ccj.wdO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94620);
                    return 0;
                case 16:
                    ccj.xbO = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94620);
                    return 0;
                default:
                    AppMethodBeat.m2505o(94620);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(94620);
            return -1;
        }
    }
}
