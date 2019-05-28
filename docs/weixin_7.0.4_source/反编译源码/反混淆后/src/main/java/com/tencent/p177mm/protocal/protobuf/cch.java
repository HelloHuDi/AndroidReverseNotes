package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cch */
public final class cch extends btd {
    public LinkedList<cbf> vKB = new LinkedList();
    public int wGG;
    public String wZT;
    public int wZX;
    public int wZY;
    public cbw wZZ;
    public SKBuiltinBuffer_t wZw;
    public int xbC;
    public int xbD;
    public LinkedList<C46531cy> xbE = new LinkedList();
    public int xbF;
    public LinkedList<bpx> xbG = new LinkedList();
    public int xbH;
    public LinkedList<C15392vd> xbI = new LinkedList();

    public cch() {
        AppMethodBeat.m2504i(94618);
        AppMethodBeat.m2505o(94618);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(94619);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(94619);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            if (this.wZT != null) {
                c6093a.mo13475e(2, this.wZT);
            }
            c6093a.mo13480iz(3, this.wGG);
            c6093a.mo13474e(4, 8, this.vKB);
            c6093a.mo13480iz(5, this.xbC);
            c6093a.mo13480iz(6, this.wZX);
            c6093a.mo13480iz(7, this.wZY);
            if (this.wZZ != null) {
                c6093a.mo13479iy(8, this.wZZ.computeSize());
                this.wZZ.writeFields(c6093a);
            }
            c6093a.mo13480iz(9, this.xbD);
            c6093a.mo13474e(10, 8, this.xbE);
            if (this.wZw != null) {
                c6093a.mo13479iy(11, this.wZw.computeSize());
                this.wZw.writeFields(c6093a);
            }
            c6093a.mo13480iz(12, this.xbF);
            c6093a.mo13474e(13, 8, this.xbG);
            c6093a.mo13480iz(14, this.xbH);
            c6093a.mo13474e(15, 8, this.xbI);
            AppMethodBeat.m2505o(94619);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wZT != null) {
                ix += C6091a.m9575f(2, this.wZT);
            }
            ix = ((((ix + C6091a.m9572bs(3, this.wGG)) + C6087a.m9552c(4, 8, this.vKB)) + C6091a.m9572bs(5, this.xbC)) + C6091a.m9572bs(6, this.wZX)) + C6091a.m9572bs(7, this.wZY);
            if (this.wZZ != null) {
                ix += C6087a.m9557ix(8, this.wZZ.computeSize());
            }
            ix = (ix + C6091a.m9572bs(9, this.xbD)) + C6087a.m9552c(10, 8, this.xbE);
            if (this.wZw != null) {
                ix += C6087a.m9557ix(11, this.wZw.computeSize());
            }
            int bs = (((ix + C6091a.m9572bs(12, this.xbF)) + C6087a.m9552c(13, 8, this.xbG)) + C6091a.m9572bs(14, this.xbH)) + C6087a.m9552c(15, 8, this.xbI);
            AppMethodBeat.m2505o(94619);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vKB.clear();
            this.xbE.clear();
            this.xbG.clear();
            this.xbI.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(94619);
                throw c6092b;
            }
            AppMethodBeat.m2505o(94619);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cch cch = (cch) objArr[1];
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
                        BaseResponse baseResponse = new BaseResponse();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = baseResponse.populateBuilderWithField(c6086a3, baseResponse, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cch.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(94619);
                    return 0;
                case 2:
                    cch.wZT = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94619);
                    return 0;
                case 3:
                    cch.wGG = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94619);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cbf cbf = new cbf();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cbf.populateBuilderWithField(c6086a3, cbf, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cch.vKB.add(cbf);
                    }
                    AppMethodBeat.m2505o(94619);
                    return 0;
                case 5:
                    cch.xbC = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94619);
                    return 0;
                case 6:
                    cch.wZX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94619);
                    return 0;
                case 7:
                    cch.wZY = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94619);
                    return 0;
                case 8:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cbw cbw = new cbw();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cbw.populateBuilderWithField(c6086a3, cbw, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cch.wZZ = cbw;
                    }
                    AppMethodBeat.m2505o(94619);
                    return 0;
                case 9:
                    cch.xbD = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94619);
                    return 0;
                case 10:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C46531cy c46531cy = new C46531cy();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c46531cy.populateBuilderWithField(c6086a3, c46531cy, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cch.xbE.add(c46531cy);
                    }
                    AppMethodBeat.m2505o(94619);
                    return 0;
                case 11:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cch.wZw = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(94619);
                    return 0;
                case 12:
                    cch.xbF = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94619);
                    return 0;
                case 13:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bpx bpx = new bpx();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bpx.populateBuilderWithField(c6086a3, bpx, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cch.xbG.add(bpx);
                    }
                    AppMethodBeat.m2505o(94619);
                    return 0;
                case 14:
                    cch.xbH = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94619);
                    return 0;
                case 15:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C15392vd c15392vd = new C15392vd();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c15392vd.populateBuilderWithField(c6086a3, c15392vd, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cch.xbI.add(c15392vd);
                    }
                    AppMethodBeat.m2505o(94619);
                    return 0;
                default:
                    AppMethodBeat.m2505o(94619);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(94619);
            return -1;
        }
    }
}
