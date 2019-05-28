package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bfi */
public final class bfi extends btd {
    public int kdT;
    public String kdU;
    public String tgu;
    public azb wJa;
    public int wJb;
    public int wJc;
    public int wJd;
    public LinkedList<C44191xg> wJe = new LinkedList();
    public LinkedList<bqr> wJf = new LinkedList();
    public LinkedList<C7263hc> wJg = new LinkedList();

    public bfi() {
        AppMethodBeat.m2504i(56869);
        AppMethodBeat.m2505o(56869);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56870);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(56870);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.kdT);
            if (this.kdU != null) {
                c6093a.mo13475e(3, this.kdU);
            }
            c6093a.mo13480iz(4, this.wJb);
            c6093a.mo13480iz(5, this.wJc);
            c6093a.mo13480iz(6, this.wJd);
            c6093a.mo13474e(8, 8, this.wJe);
            if (this.wJa != null) {
                c6093a.mo13479iy(9, this.wJa.computeSize());
                this.wJa.writeFields(c6093a);
            }
            c6093a.mo13474e(10, 8, this.wJf);
            c6093a.mo13474e(11, 8, this.wJg);
            if (this.tgu != null) {
                c6093a.mo13475e(100, this.tgu);
            }
            AppMethodBeat.m2505o(56870);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += C6091a.m9572bs(2, this.kdT);
            if (this.kdU != null) {
                ix += C6091a.m9575f(3, this.kdU);
            }
            ix = (((ix + C6091a.m9572bs(4, this.wJb)) + C6091a.m9572bs(5, this.wJc)) + C6091a.m9572bs(6, this.wJd)) + C6087a.m9552c(8, 8, this.wJe);
            if (this.wJa != null) {
                ix += C6087a.m9557ix(9, this.wJa.computeSize());
            }
            ix = (ix + C6087a.m9552c(10, 8, this.wJf)) + C6087a.m9552c(11, 8, this.wJg);
            if (this.tgu != null) {
                ix += C6091a.m9575f(100, this.tgu);
            }
            AppMethodBeat.m2505o(56870);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wJe.clear();
            this.wJf.clear();
            this.wJg.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(56870);
                throw c6092b;
            }
            AppMethodBeat.m2505o(56870);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bfi bfi = (bfi) objArr[1];
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
                        bfi.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(56870);
                    return 0;
                case 2:
                    bfi.kdT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56870);
                    return 0;
                case 3:
                    bfi.kdU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56870);
                    return 0;
                case 4:
                    bfi.wJb = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56870);
                    return 0;
                case 5:
                    bfi.wJc = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56870);
                    return 0;
                case 6:
                    bfi.wJd = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56870);
                    return 0;
                case 8:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C44191xg c44191xg = new C44191xg();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c44191xg.populateBuilderWithField(c6086a3, c44191xg, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bfi.wJe.add(c44191xg);
                    }
                    AppMethodBeat.m2505o(56870);
                    return 0;
                case 9:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        azb azb = new azb();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = azb.populateBuilderWithField(c6086a3, azb, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bfi.wJa = azb;
                    }
                    AppMethodBeat.m2505o(56870);
                    return 0;
                case 10:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bqr bqr = new bqr();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bqr.populateBuilderWithField(c6086a3, bqr, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bfi.wJf.add(bqr);
                    }
                    AppMethodBeat.m2505o(56870);
                    return 0;
                case 11:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7263hc c7263hc = new C7263hc();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7263hc.populateBuilderWithField(c6086a3, c7263hc, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bfi.wJg.add(c7263hc);
                    }
                    AppMethodBeat.m2505o(56870);
                    return 0;
                case 100:
                    bfi.tgu = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56870);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56870);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56870);
            return -1;
        }
    }
}
