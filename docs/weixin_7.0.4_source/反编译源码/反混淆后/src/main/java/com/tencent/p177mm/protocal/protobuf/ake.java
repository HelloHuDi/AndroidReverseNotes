package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ake */
public final class ake extends btd {
    public int wjY;
    public String wjZ;
    public String wka;
    public int wkb;
    public String wkc;
    public String wpF;
    public String wpG;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56815);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(56815);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            if (this.wpF != null) {
                c6093a.mo13475e(2, this.wpF);
            }
            c6093a.mo13480iz(3, this.wjY);
            if (this.wjZ != null) {
                c6093a.mo13475e(4, this.wjZ);
            }
            if (this.wka != null) {
                c6093a.mo13475e(5, this.wka);
            }
            c6093a.mo13480iz(6, this.wkb);
            if (this.wkc != null) {
                c6093a.mo13475e(7, this.wkc);
            }
            if (this.wpG != null) {
                c6093a.mo13475e(8, this.wpG);
            }
            AppMethodBeat.m2505o(56815);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wpF != null) {
                ix += C6091a.m9575f(2, this.wpF);
            }
            ix += C6091a.m9572bs(3, this.wjY);
            if (this.wjZ != null) {
                ix += C6091a.m9575f(4, this.wjZ);
            }
            if (this.wka != null) {
                ix += C6091a.m9575f(5, this.wka);
            }
            ix += C6091a.m9572bs(6, this.wkb);
            if (this.wkc != null) {
                ix += C6091a.m9575f(7, this.wkc);
            }
            if (this.wpG != null) {
                ix += C6091a.m9575f(8, this.wpG);
            }
            AppMethodBeat.m2505o(56815);
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
                AppMethodBeat.m2505o(56815);
                throw c6092b;
            }
            AppMethodBeat.m2505o(56815);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            ake ake = (ake) objArr[1];
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
                        ake.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(56815);
                    return 0;
                case 2:
                    ake.wpF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56815);
                    return 0;
                case 3:
                    ake.wjY = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56815);
                    return 0;
                case 4:
                    ake.wjZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56815);
                    return 0;
                case 5:
                    ake.wka = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56815);
                    return 0;
                case 6:
                    ake.wkb = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56815);
                    return 0;
                case 7:
                    ake.wkc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56815);
                    return 0;
                case 8:
                    ake.wpG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56815);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56815);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56815);
            return -1;
        }
    }
}
