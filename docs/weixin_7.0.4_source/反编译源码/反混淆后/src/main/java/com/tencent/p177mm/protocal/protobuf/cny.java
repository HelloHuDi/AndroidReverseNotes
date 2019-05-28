package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cny */
public final class cny extends bsr {
    public int fJT;
    public String jBB;
    public SKBuiltinBuffer_t ptz;
    public int vHo;
    public int vHr;
    public int vOq;
    public String xiM;
    public int xiN;
    public int xiO;
    public int xlv;
    public int xlw;
    public LinkedList<bts> xlx = new LinkedList();
    public LinkedList<SKBuiltinBuffer_t> xly = new LinkedList();

    public cny() {
        AppMethodBeat.m2504i(116813);
        AppMethodBeat.m2505o(116813);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(116814);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.ptz == null) {
                c6092b = new C6092b("Not all required fields were included: Data");
                AppMethodBeat.m2505o(116814);
                throw c6092b;
            }
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.jBB != null) {
                c6093a.mo13475e(2, this.jBB);
            }
            if (this.ptz != null) {
                c6093a.mo13479iy(3, this.ptz.computeSize());
                this.ptz.writeFields(c6093a);
            }
            c6093a.mo13480iz(4, this.vOq);
            if (this.xiM != null) {
                c6093a.mo13475e(5, this.xiM);
            }
            c6093a.mo13480iz(6, this.fJT);
            c6093a.mo13480iz(7, this.xiN);
            c6093a.mo13480iz(8, this.vHr);
            c6093a.mo13480iz(9, this.xiO);
            c6093a.mo13480iz(10, this.vHo);
            c6093a.mo13480iz(11, this.xlv);
            c6093a.mo13480iz(12, this.xlw);
            c6093a.mo13474e(13, 8, this.xlx);
            c6093a.mo13474e(14, 8, this.xly);
            AppMethodBeat.m2505o(116814);
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
            if (this.ptz != null) {
                ix += C6087a.m9557ix(3, this.ptz.computeSize());
            }
            ix += C6091a.m9572bs(4, this.vOq);
            if (this.xiM != null) {
                ix += C6091a.m9575f(5, this.xiM);
            }
            int bs = ((((((((ix + C6091a.m9572bs(6, this.fJT)) + C6091a.m9572bs(7, this.xiN)) + C6091a.m9572bs(8, this.vHr)) + C6091a.m9572bs(9, this.xiO)) + C6091a.m9572bs(10, this.vHo)) + C6091a.m9572bs(11, this.xlv)) + C6091a.m9572bs(12, this.xlw)) + C6087a.m9552c(13, 8, this.xlx)) + C6087a.m9552c(14, 8, this.xly);
            AppMethodBeat.m2505o(116814);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xlx.clear();
            this.xly.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.ptz == null) {
                c6092b = new C6092b("Not all required fields were included: Data");
                AppMethodBeat.m2505o(116814);
                throw c6092b;
            }
            AppMethodBeat.m2505o(116814);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cny cny = (cny) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
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
                        cny.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(116814);
                    return 0;
                case 2:
                    cny.jBB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(116814);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cny.ptz = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(116814);
                    return 0;
                case 4:
                    cny.vOq = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(116814);
                    return 0;
                case 5:
                    cny.xiM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(116814);
                    return 0;
                case 6:
                    cny.fJT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(116814);
                    return 0;
                case 7:
                    cny.xiN = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(116814);
                    return 0;
                case 8:
                    cny.vHr = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(116814);
                    return 0;
                case 9:
                    cny.xiO = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(116814);
                    return 0;
                case 10:
                    cny.vHo = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(116814);
                    return 0;
                case 11:
                    cny.xlv = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(116814);
                    return 0;
                case 12:
                    cny.xlw = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(116814);
                    return 0;
                case 13:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cny.xlx.add(bts);
                    }
                    AppMethodBeat.m2505o(116814);
                    return 0;
                case 14:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cny.xly.add(sKBuiltinBuffer_t);
                    }
                    AppMethodBeat.m2505o(116814);
                    return 0;
                default:
                    AppMethodBeat.m2505o(116814);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(116814);
            return -1;
        }
    }
}
