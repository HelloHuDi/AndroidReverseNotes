package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.kz */
public final class C7545kz extends btd {
    public int fJT;
    public int jCt;
    public int vOn;
    public int vOr;
    public String vOt;
    public float vOu;
    public float vOv;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(11724);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(11724);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.vOn);
            c6093a.mo13480iz(3, this.jCt);
            if (this.vOt != null) {
                c6093a.mo13475e(4, this.vOt);
            }
            c6093a.mo13480iz(5, this.fJT);
            c6093a.mo13480iz(6, this.vOr);
            c6093a.mo13481r(7, this.vOu);
            c6093a.mo13481r(8, this.vOv);
            AppMethodBeat.m2505o(11724);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + C6091a.m9572bs(2, this.vOn)) + C6091a.m9572bs(3, this.jCt);
            if (this.vOt != null) {
                ix += C6091a.m9575f(4, this.vOt);
            }
            int bs = (((ix + C6091a.m9572bs(5, this.fJT)) + C6091a.m9572bs(6, this.vOr)) + (C6091a.m9576fv(7) + 4)) + (C6091a.m9576fv(8) + 4);
            AppMethodBeat.m2505o(11724);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(11724);
                throw c6092b;
            }
            AppMethodBeat.m2505o(11724);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C7545kz c7545kz = (C7545kz) objArr[1];
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
                        c7545kz.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(11724);
                    return 0;
                case 2:
                    c7545kz.vOn = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(11724);
                    return 0;
                case 3:
                    c7545kz.jCt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(11724);
                    return 0;
                case 4:
                    c7545kz.vOt = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(11724);
                    return 0;
                case 5:
                    c7545kz.fJT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(11724);
                    return 0;
                case 6:
                    c7545kz.vOr = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(11724);
                    return 0;
                case 7:
                    c7545kz.vOu = Float.intBitsToFloat(c6086a2.BTU.eia());
                    AppMethodBeat.m2505o(11724);
                    return 0;
                case 8:
                    c7545kz.vOv = Float.intBitsToFloat(c6086a2.BTU.eia());
                    AppMethodBeat.m2505o(11724);
                    return 0;
                default:
                    AppMethodBeat.m2505o(11724);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(11724);
            return -1;
        }
    }
}
