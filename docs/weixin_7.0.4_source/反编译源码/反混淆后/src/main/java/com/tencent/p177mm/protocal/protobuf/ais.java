package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ais */
public final class ais extends btd {
    public int kdT;
    public String kdU;
    public String person_id;
    public String vYl;
    public String woJ;
    public float woK;
    public String woL;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(848);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(848);
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
            if (this.person_id != null) {
                c6093a.mo13475e(4, this.person_id);
            }
            if (this.woJ != null) {
                c6093a.mo13475e(5, this.woJ);
            }
            c6093a.mo13481r(6, this.woK);
            if (this.vYl != null) {
                c6093a.mo13475e(7, this.vYl);
            }
            if (this.woL != null) {
                c6093a.mo13475e(8, this.woL);
            }
            AppMethodBeat.m2505o(848);
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
            if (this.person_id != null) {
                ix += C6091a.m9575f(4, this.person_id);
            }
            if (this.woJ != null) {
                ix += C6091a.m9575f(5, this.woJ);
            }
            ix += C6091a.m9576fv(6) + 4;
            if (this.vYl != null) {
                ix += C6091a.m9575f(7, this.vYl);
            }
            if (this.woL != null) {
                ix += C6091a.m9575f(8, this.woL);
            }
            AppMethodBeat.m2505o(848);
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
                AppMethodBeat.m2505o(848);
                throw c6092b;
            }
            AppMethodBeat.m2505o(848);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            ais ais = (ais) objArr[1];
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
                        ais.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(848);
                    return 0;
                case 2:
                    ais.kdT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(848);
                    return 0;
                case 3:
                    ais.kdU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(848);
                    return 0;
                case 4:
                    ais.person_id = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(848);
                    return 0;
                case 5:
                    ais.woJ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(848);
                    return 0;
                case 6:
                    ais.woK = Float.intBitsToFloat(c6086a2.BTU.eia());
                    AppMethodBeat.m2505o(848);
                    return 0;
                case 7:
                    ais.vYl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(848);
                    return 0;
                case 8:
                    ais.woL = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(848);
                    return 0;
                default:
                    AppMethodBeat.m2505o(848);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(848);
            return -1;
        }
    }
}
