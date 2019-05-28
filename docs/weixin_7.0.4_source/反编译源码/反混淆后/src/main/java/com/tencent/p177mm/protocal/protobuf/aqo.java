package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.aqo */
public final class aqo extends btd {
    public int CellCount;
    public LinkedList<crt> CellList = new LinkedList();
    public String wuk;
    public String wum;
    public int wun;
    public String wuo;
    public String wup;
    public String wuq;

    public aqo() {
        AppMethodBeat.m2504i(28505);
        AppMethodBeat.m2505o(28505);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28506);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(28506);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.CellCount);
            c6093a.mo13474e(3, 8, this.CellList);
            if (this.wum != null) {
                c6093a.mo13475e(4, this.wum);
            }
            if (this.wuk != null) {
                c6093a.mo13475e(5, this.wuk);
            }
            c6093a.mo13480iz(6, this.wun);
            if (this.wuo != null) {
                c6093a.mo13475e(7, this.wuo);
            }
            if (this.wup != null) {
                c6093a.mo13475e(8, this.wup);
            }
            if (this.wuq != null) {
                c6093a.mo13475e(9, this.wuq);
            }
            AppMethodBeat.m2505o(28506);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + C6091a.m9572bs(2, this.CellCount)) + C6087a.m9552c(3, 8, this.CellList);
            if (this.wum != null) {
                ix += C6091a.m9575f(4, this.wum);
            }
            if (this.wuk != null) {
                ix += C6091a.m9575f(5, this.wuk);
            }
            ix += C6091a.m9572bs(6, this.wun);
            if (this.wuo != null) {
                ix += C6091a.m9575f(7, this.wuo);
            }
            if (this.wup != null) {
                ix += C6091a.m9575f(8, this.wup);
            }
            if (this.wuq != null) {
                ix += C6091a.m9575f(9, this.wuq);
            }
            AppMethodBeat.m2505o(28506);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.CellList.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(28506);
                throw c6092b;
            }
            AppMethodBeat.m2505o(28506);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            aqo aqo = (aqo) objArr[1];
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
                        aqo.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(28506);
                    return 0;
                case 2:
                    aqo.CellCount = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28506);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        crt crt = new crt();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = crt.populateBuilderWithField(c6086a3, crt, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        aqo.CellList.add(crt);
                    }
                    AppMethodBeat.m2505o(28506);
                    return 0;
                case 4:
                    aqo.wum = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28506);
                    return 0;
                case 5:
                    aqo.wuk = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28506);
                    return 0;
                case 6:
                    aqo.wun = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28506);
                    return 0;
                case 7:
                    aqo.wuo = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28506);
                    return 0;
                case 8:
                    aqo.wup = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28506);
                    return 0;
                case 9:
                    aqo.wuq = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28506);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28506);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28506);
            return -1;
        }
    }
}
