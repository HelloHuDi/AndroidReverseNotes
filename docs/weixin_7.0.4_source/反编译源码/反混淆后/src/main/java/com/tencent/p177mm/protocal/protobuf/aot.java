package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.aot */
public final class aot extends btd {
    public LinkedList<C44103bg> ncU = new LinkedList();
    public LinkedList<aro> ncz = new LinkedList();
    public int wsR;
    public LinkedList<bpe> wsS = new LinkedList();
    public int wsT;
    public int wsU;
    public int wsV;
    public arn wsW;

    public aot() {
        AppMethodBeat.m2504i(80099);
        AppMethodBeat.m2505o(80099);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(80100);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(80100);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.wsR);
            c6093a.mo13474e(3, 8, this.wsS);
            c6093a.mo13480iz(4, this.wsT);
            c6093a.mo13480iz(5, this.wsU);
            c6093a.mo13474e(6, 8, this.ncU);
            c6093a.mo13480iz(7, this.wsV);
            c6093a.mo13474e(8, 8, this.ncz);
            if (this.wsW != null) {
                c6093a.mo13479iy(9, this.wsW.computeSize());
                this.wsW.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(80100);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = ((((((ix + C6091a.m9572bs(2, this.wsR)) + C6087a.m9552c(3, 8, this.wsS)) + C6091a.m9572bs(4, this.wsT)) + C6091a.m9572bs(5, this.wsU)) + C6087a.m9552c(6, 8, this.ncU)) + C6091a.m9572bs(7, this.wsV)) + C6087a.m9552c(8, 8, this.ncz);
            if (this.wsW != null) {
                ix += C6087a.m9557ix(9, this.wsW.computeSize());
            }
            AppMethodBeat.m2505o(80100);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wsS.clear();
            this.ncU.clear();
            this.ncz.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(80100);
                throw c6092b;
            }
            AppMethodBeat.m2505o(80100);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            aot aot = (aot) objArr[1];
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
                        aot.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(80100);
                    return 0;
                case 2:
                    aot.wsR = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80100);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bpe bpe = new bpe();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bpe.populateBuilderWithField(c6086a3, bpe, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        aot.wsS.add(bpe);
                    }
                    AppMethodBeat.m2505o(80100);
                    return 0;
                case 4:
                    aot.wsT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80100);
                    return 0;
                case 5:
                    aot.wsU = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80100);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C44103bg c44103bg = new C44103bg();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c44103bg.populateBuilderWithField(c6086a3, c44103bg, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        aot.ncU.add(c44103bg);
                    }
                    AppMethodBeat.m2505o(80100);
                    return 0;
                case 7:
                    aot.wsV = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80100);
                    return 0;
                case 8:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        aro aro = new aro();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = aro.populateBuilderWithField(c6086a3, aro, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        aot.ncz.add(aro);
                    }
                    AppMethodBeat.m2505o(80100);
                    return 0;
                case 9:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        arn arn = new arn();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = arn.populateBuilderWithField(c6086a3, arn, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        aot.wsW = arn;
                    }
                    AppMethodBeat.m2505o(80100);
                    return 0;
                default:
                    AppMethodBeat.m2505o(80100);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(80100);
            return -1;
        }
    }
}
