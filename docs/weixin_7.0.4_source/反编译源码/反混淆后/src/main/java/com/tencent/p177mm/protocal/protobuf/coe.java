package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.coe */
public final class coe extends bsr {
    public int Scene;
    public int fJT;
    public SKBuiltinBuffer_t ptz;
    public int vOq;
    public int vPb;
    public bts wUI;
    public String xiM;
    public int xiO;
    public int xlE;
    public LinkedList<bts> xlF = new LinkedList();
    public int xlG;

    public coe() {
        AppMethodBeat.m2504i(116818);
        AppMethodBeat.m2505o(116818);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(116819);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.ptz == null) {
                c6092b = new C6092b("Not all required fields were included: Data");
                AppMethodBeat.m2505o(116819);
                throw c6092b;
            }
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.ptz != null) {
                c6093a.mo13479iy(2, this.ptz.computeSize());
                this.ptz.writeFields(c6093a);
            }
            c6093a.mo13480iz(3, this.vOq);
            if (this.xiM != null) {
                c6093a.mo13475e(4, this.xiM);
            }
            c6093a.mo13480iz(5, this.fJT);
            c6093a.mo13480iz(6, this.xiO);
            c6093a.mo13480iz(7, this.vPb);
            c6093a.mo13480iz(8, this.xlE);
            c6093a.mo13474e(9, 8, this.xlF);
            if (this.wUI != null) {
                c6093a.mo13479iy(10, this.wUI.computeSize());
                this.wUI.writeFields(c6093a);
            }
            c6093a.mo13480iz(11, this.xlG);
            c6093a.mo13480iz(12, this.Scene);
            AppMethodBeat.m2505o(116819);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.ptz != null) {
                ix += C6087a.m9557ix(2, this.ptz.computeSize());
            }
            ix += C6091a.m9572bs(3, this.vOq);
            if (this.xiM != null) {
                ix += C6091a.m9575f(4, this.xiM);
            }
            ix = ((((ix + C6091a.m9572bs(5, this.fJT)) + C6091a.m9572bs(6, this.xiO)) + C6091a.m9572bs(7, this.vPb)) + C6091a.m9572bs(8, this.xlE)) + C6087a.m9552c(9, 8, this.xlF);
            if (this.wUI != null) {
                ix += C6087a.m9557ix(10, this.wUI.computeSize());
            }
            int bs = (ix + C6091a.m9572bs(11, this.xlG)) + C6091a.m9572bs(12, this.Scene);
            AppMethodBeat.m2505o(116819);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xlF.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.ptz == null) {
                c6092b = new C6092b("Not all required fields were included: Data");
                AppMethodBeat.m2505o(116819);
                throw c6092b;
            }
            AppMethodBeat.m2505o(116819);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            coe coe = (coe) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            bts bts;
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
                        coe.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(116819);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        coe.ptz = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(116819);
                    return 0;
                case 3:
                    coe.vOq = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(116819);
                    return 0;
                case 4:
                    coe.xiM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(116819);
                    return 0;
                case 5:
                    coe.fJT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(116819);
                    return 0;
                case 6:
                    coe.xiO = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(116819);
                    return 0;
                case 7:
                    coe.vPb = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(116819);
                    return 0;
                case 8:
                    coe.xlE = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(116819);
                    return 0;
                case 9:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        coe.xlF.add(bts);
                    }
                    AppMethodBeat.m2505o(116819);
                    return 0;
                case 10:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        coe.wUI = bts;
                    }
                    AppMethodBeat.m2505o(116819);
                    return 0;
                case 11:
                    coe.xlG = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(116819);
                    return 0;
                case 12:
                    coe.Scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(116819);
                    return 0;
                default:
                    AppMethodBeat.m2505o(116819);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(116819);
            return -1;
        }
    }
}
