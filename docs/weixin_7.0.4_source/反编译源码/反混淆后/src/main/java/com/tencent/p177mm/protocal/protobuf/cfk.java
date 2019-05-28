package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cfk */
public final class cfk extends btd {
    public int vIc;
    public C46543fz wXh;
    public String wcg;
    public C46544gd xeO;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(96298);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(96298);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            if (this.wXh != null) {
                c6093a.mo13479iy(2, this.wXh.computeSize());
                this.wXh.writeFields(c6093a);
            }
            c6093a.mo13480iz(3, this.vIc);
            if (this.xeO != null) {
                c6093a.mo13479iy(4, this.xeO.computeSize());
                this.xeO.writeFields(c6093a);
            }
            if (this.wcg != null) {
                c6093a.mo13475e(5, this.wcg);
            }
            AppMethodBeat.m2505o(96298);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wXh != null) {
                ix += C6087a.m9557ix(2, this.wXh.computeSize());
            }
            ix += C6091a.m9572bs(3, this.vIc);
            if (this.xeO != null) {
                ix += C6087a.m9557ix(4, this.xeO.computeSize());
            }
            if (this.wcg != null) {
                ix += C6091a.m9575f(5, this.wcg);
            }
            AppMethodBeat.m2505o(96298);
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
                AppMethodBeat.m2505o(96298);
                throw c6092b;
            }
            AppMethodBeat.m2505o(96298);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cfk cfk = (cfk) objArr[1];
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
                        cfk.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(96298);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C46543fz c46543fz = new C46543fz();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c46543fz.populateBuilderWithField(c6086a3, c46543fz, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cfk.wXh = c46543fz;
                    }
                    AppMethodBeat.m2505o(96298);
                    return 0;
                case 3:
                    cfk.vIc = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(96298);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C46544gd c46544gd = new C46544gd();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c46544gd.populateBuilderWithField(c6086a3, c46544gd, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cfk.xeO = c46544gd;
                    }
                    AppMethodBeat.m2505o(96298);
                    return 0;
                case 5:
                    cfk.wcg = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96298);
                    return 0;
                default:
                    AppMethodBeat.m2505o(96298);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(96298);
            return -1;
        }
    }
}
