package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.o */
public final class C15369o extends btd {
    public String cJF;
    public int kCl = 268513600;
    public String kCm = "请求不成功，请稍候再试";
    public String nYX;
    public String pPw;
    public C40499a vAf;
    public String vAg;
    public String vzN;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56683);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(56683);
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
            if (this.nYX != null) {
                c6093a.mo13475e(4, this.nYX);
            }
            if (this.cJF != null) {
                c6093a.mo13475e(5, this.cJF);
            }
            if (this.pPw != null) {
                c6093a.mo13475e(7, this.pPw);
            }
            if (this.vzN != null) {
                c6093a.mo13475e(8, this.vzN);
            }
            if (this.vAf != null) {
                c6093a.mo13479iy(9, this.vAf.computeSize());
                this.vAf.writeFields(c6093a);
            }
            if (this.vAg != null) {
                c6093a.mo13475e(10, this.vAg);
            }
            AppMethodBeat.m2505o(56683);
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
            if (this.nYX != null) {
                ix += C6091a.m9575f(4, this.nYX);
            }
            if (this.cJF != null) {
                ix += C6091a.m9575f(5, this.cJF);
            }
            if (this.pPw != null) {
                ix += C6091a.m9575f(7, this.pPw);
            }
            if (this.vzN != null) {
                ix += C6091a.m9575f(8, this.vzN);
            }
            if (this.vAf != null) {
                ix += C6087a.m9557ix(9, this.vAf.computeSize());
            }
            if (this.vAg != null) {
                ix += C6091a.m9575f(10, this.vAg);
            }
            AppMethodBeat.m2505o(56683);
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
                AppMethodBeat.m2505o(56683);
                throw c6092b;
            }
            AppMethodBeat.m2505o(56683);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C15369o c15369o = (C15369o) objArr[1];
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
                        c15369o.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(56683);
                    return 0;
                case 2:
                    c15369o.kCl = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56683);
                    return 0;
                case 3:
                    c15369o.kCm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56683);
                    return 0;
                case 4:
                    c15369o.nYX = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56683);
                    return 0;
                case 5:
                    c15369o.cJF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56683);
                    return 0;
                case 7:
                    c15369o.pPw = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56683);
                    return 0;
                case 8:
                    c15369o.vzN = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56683);
                    return 0;
                case 9:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C40499a c40499a = new C40499a();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c40499a.populateBuilderWithField(c6086a3, c40499a, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c15369o.vAf = c40499a;
                    }
                    AppMethodBeat.m2505o(56683);
                    return 0;
                case 10:
                    c15369o.vAg = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56683);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56683);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56683);
            return -1;
        }
    }
}
