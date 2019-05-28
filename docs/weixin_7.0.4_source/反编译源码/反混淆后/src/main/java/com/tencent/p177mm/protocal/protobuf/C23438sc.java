package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.sc */
public final class C23438sc extends btd {
    public int luT;
    public String luU;
    public String token;
    public bjk vYW;
    public chz vZv;
    public String vwr;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56763);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(56763);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.luT);
            if (this.luU != null) {
                c6093a.mo13475e(3, this.luU);
            }
            if (this.token != null) {
                c6093a.mo13475e(4, this.token);
            }
            if (this.vYW != null) {
                c6093a.mo13479iy(5, this.vYW.computeSize());
                this.vYW.writeFields(c6093a);
            }
            if (this.vwr != null) {
                c6093a.mo13475e(6, this.vwr);
            }
            if (this.vZv != null) {
                c6093a.mo13479iy(7, this.vZv.computeSize());
                this.vZv.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(56763);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += C6091a.m9572bs(2, this.luT);
            if (this.luU != null) {
                ix += C6091a.m9575f(3, this.luU);
            }
            if (this.token != null) {
                ix += C6091a.m9575f(4, this.token);
            }
            if (this.vYW != null) {
                ix += C6087a.m9557ix(5, this.vYW.computeSize());
            }
            if (this.vwr != null) {
                ix += C6091a.m9575f(6, this.vwr);
            }
            if (this.vZv != null) {
                ix += C6087a.m9557ix(7, this.vZv.computeSize());
            }
            AppMethodBeat.m2505o(56763);
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
                AppMethodBeat.m2505o(56763);
                throw c6092b;
            }
            AppMethodBeat.m2505o(56763);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C23438sc c23438sc = (C23438sc) objArr[1];
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
                        c23438sc.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(56763);
                    return 0;
                case 2:
                    c23438sc.luT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56763);
                    return 0;
                case 3:
                    c23438sc.luU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56763);
                    return 0;
                case 4:
                    c23438sc.token = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56763);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bjk bjk = new bjk();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bjk.populateBuilderWithField(c6086a3, bjk, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c23438sc.vYW = bjk;
                    }
                    AppMethodBeat.m2505o(56763);
                    return 0;
                case 6:
                    c23438sc.vwr = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56763);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        chz chz = new chz();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = chz.populateBuilderWithField(c6086a3, chz, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c23438sc.vZv = chz;
                    }
                    AppMethodBeat.m2505o(56763);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56763);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56763);
            return -1;
        }
    }
}
