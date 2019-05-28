package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.coi */
public final class coi extends btd {
    public int wem;
    public long wen;
    public int xlL;
    public int xlS;
    public cpr xlT;
    public int xlU;
    public int xlV;
    public int xlW;
    public int xlX;
    public SKBuiltinBuffer_t xlY;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(5226);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(5226);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.wem);
            c6093a.mo13472ai(3, this.wen);
            c6093a.mo13480iz(4, this.xlS);
            if (this.xlT != null) {
                c6093a.mo13479iy(5, this.xlT.computeSize());
                this.xlT.writeFields(c6093a);
            }
            c6093a.mo13480iz(6, this.xlL);
            c6093a.mo13480iz(7, this.xlU);
            c6093a.mo13480iz(8, this.xlV);
            c6093a.mo13480iz(9, this.xlW);
            c6093a.mo13480iz(10, this.xlX);
            if (this.xlY != null) {
                c6093a.mo13479iy(11, this.xlY.computeSize());
                this.xlY.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(5226);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = ((ix + C6091a.m9572bs(2, this.wem)) + C6091a.m9578o(3, this.wen)) + C6091a.m9572bs(4, this.xlS);
            if (this.xlT != null) {
                ix += C6087a.m9557ix(5, this.xlT.computeSize());
            }
            ix = ((((ix + C6091a.m9572bs(6, this.xlL)) + C6091a.m9572bs(7, this.xlU)) + C6091a.m9572bs(8, this.xlV)) + C6091a.m9572bs(9, this.xlW)) + C6091a.m9572bs(10, this.xlX);
            if (this.xlY != null) {
                ix += C6087a.m9557ix(11, this.xlY.computeSize());
            }
            AppMethodBeat.m2505o(5226);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(5226);
                throw c6092b;
            }
            AppMethodBeat.m2505o(5226);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            coi coi = (coi) objArr[1];
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
                        BaseResponse baseResponse = new BaseResponse();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = baseResponse.populateBuilderWithField(c6086a3, baseResponse, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        coi.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(5226);
                    return 0;
                case 2:
                    coi.wem = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5226);
                    return 0;
                case 3:
                    coi.wen = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(5226);
                    return 0;
                case 4:
                    coi.xlS = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5226);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cpr cpr = new cpr();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cpr.populateBuilderWithField(c6086a3, cpr, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        coi.xlT = cpr;
                    }
                    AppMethodBeat.m2505o(5226);
                    return 0;
                case 6:
                    coi.xlL = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5226);
                    return 0;
                case 7:
                    coi.xlU = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5226);
                    return 0;
                case 8:
                    coi.xlV = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5226);
                    return 0;
                case 9:
                    coi.xlW = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5226);
                    return 0;
                case 10:
                    coi.xlX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5226);
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
                        coi.xlY = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(5226);
                    return 0;
                default:
                    AppMethodBeat.m2505o(5226);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(5226);
            return -1;
        }
    }
}
