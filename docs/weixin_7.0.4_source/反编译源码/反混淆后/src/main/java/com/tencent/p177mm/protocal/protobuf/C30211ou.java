package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ou */
public final class C30211ou extends btd {
    public int kCl;
    public String kCm;
    public String kCn;
    public String vVU;
    public LinkedList<C30254zr> vVV = new LinkedList();

    public C30211ou() {
        AppMethodBeat.m2504i(56747);
        AppMethodBeat.m2505o(56747);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56748);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(56748);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.kCl);
            if (this.kCm != null) {
                c6093a.mo13475e(3, this.kCm);
            }
            if (this.vVU != null) {
                c6093a.mo13475e(4, this.vVU);
            }
            if (this.kCn != null) {
                c6093a.mo13475e(5, this.kCn);
            }
            c6093a.mo13474e(6, 8, this.vVV);
            AppMethodBeat.m2505o(56748);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += C6091a.m9572bs(2, this.kCl);
            if (this.kCm != null) {
                ix += C6091a.m9575f(3, this.kCm);
            }
            if (this.vVU != null) {
                ix += C6091a.m9575f(4, this.vVU);
            }
            if (this.kCn != null) {
                ix += C6091a.m9575f(5, this.kCn);
            }
            int c = ix + C6087a.m9552c(6, 8, this.vVV);
            AppMethodBeat.m2505o(56748);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vVV.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(56748);
                throw c6092b;
            }
            AppMethodBeat.m2505o(56748);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C30211ou c30211ou = (C30211ou) objArr[1];
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
                        c30211ou.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(56748);
                    return 0;
                case 2:
                    c30211ou.kCl = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56748);
                    return 0;
                case 3:
                    c30211ou.kCm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56748);
                    return 0;
                case 4:
                    c30211ou.vVU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56748);
                    return 0;
                case 5:
                    c30211ou.kCn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56748);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C30254zr c30254zr = new C30254zr();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c30254zr.populateBuilderWithField(c6086a3, c30254zr, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c30211ou.vVV.add(c30254zr);
                    }
                    AppMethodBeat.m2505o(56748);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56748);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56748);
            return -1;
        }
    }
}
