package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bwc */
public final class bwc extends btd {
    public String fKh;
    public int jCt;
    public String ndF;
    public String ndG;
    public int pcX;
    public int ptD;
    public long ptF;
    public String vFF;
    public String vRw;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28630);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(28630);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            if (this.fKh != null) {
                c6093a.mo13475e(2, this.fKh);
            }
            if (this.ndG != null) {
                c6093a.mo13475e(3, this.ndG);
            }
            if (this.ndF != null) {
                c6093a.mo13475e(4, this.ndF);
            }
            c6093a.mo13480iz(5, this.ptD);
            if (this.vFF != null) {
                c6093a.mo13475e(6, this.vFF);
            }
            c6093a.mo13480iz(7, this.pcX);
            c6093a.mo13480iz(8, this.jCt);
            c6093a.mo13472ai(9, this.ptF);
            if (this.vRw != null) {
                c6093a.mo13475e(10, this.vRw);
            }
            AppMethodBeat.m2505o(28630);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.fKh != null) {
                ix += C6091a.m9575f(2, this.fKh);
            }
            if (this.ndG != null) {
                ix += C6091a.m9575f(3, this.ndG);
            }
            if (this.ndF != null) {
                ix += C6091a.m9575f(4, this.ndF);
            }
            ix += C6091a.m9572bs(5, this.ptD);
            if (this.vFF != null) {
                ix += C6091a.m9575f(6, this.vFF);
            }
            ix = ((ix + C6091a.m9572bs(7, this.pcX)) + C6091a.m9572bs(8, this.jCt)) + C6091a.m9578o(9, this.ptF);
            if (this.vRw != null) {
                ix += C6091a.m9575f(10, this.vRw);
            }
            AppMethodBeat.m2505o(28630);
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
                AppMethodBeat.m2505o(28630);
                throw c6092b;
            }
            AppMethodBeat.m2505o(28630);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bwc bwc = (bwc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        BaseResponse baseResponse = new BaseResponse();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = baseResponse.populateBuilderWithField(c6086a3, baseResponse, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bwc.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(28630);
                    return 0;
                case 2:
                    bwc.fKh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28630);
                    return 0;
                case 3:
                    bwc.ndG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28630);
                    return 0;
                case 4:
                    bwc.ndF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28630);
                    return 0;
                case 5:
                    bwc.ptD = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28630);
                    return 0;
                case 6:
                    bwc.vFF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28630);
                    return 0;
                case 7:
                    bwc.pcX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28630);
                    return 0;
                case 8:
                    bwc.jCt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28630);
                    return 0;
                case 9:
                    bwc.ptF = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(28630);
                    return 0;
                case 10:
                    bwc.vRw = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28630);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28630);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28630);
            return -1;
        }
    }
}
