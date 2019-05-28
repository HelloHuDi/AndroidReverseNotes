package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.uh */
public final class C15386uh extends btd {
    public String vNb;
    public bos vNh;
    public int wbR;
    public acr wbS;
    public C44135kk wbT;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(11742);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(11742);
                throw c6092b;
            } else if (this.vNh == null) {
                c6092b = new C6092b("Not all required fields were included: qy_base_resp");
                AppMethodBeat.m2505o(11742);
                throw c6092b;
            } else {
                if (this.BaseResponse != null) {
                    c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(c6093a);
                }
                if (this.vNh != null) {
                    c6093a.mo13479iy(2, this.vNh.computeSize());
                    this.vNh.writeFields(c6093a);
                }
                if (this.vNb != null) {
                    c6093a.mo13475e(3, this.vNb);
                }
                c6093a.mo13480iz(4, this.wbR);
                if (this.wbS != null) {
                    c6093a.mo13479iy(5, this.wbS.computeSize());
                    this.wbS.writeFields(c6093a);
                }
                if (this.wbT != null) {
                    c6093a.mo13479iy(6, this.wbT.computeSize());
                    this.wbT.writeFields(c6093a);
                }
                AppMethodBeat.m2505o(11742);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vNh != null) {
                ix += C6087a.m9557ix(2, this.vNh.computeSize());
            }
            if (this.vNb != null) {
                ix += C6091a.m9575f(3, this.vNb);
            }
            ix += C6091a.m9572bs(4, this.wbR);
            if (this.wbS != null) {
                ix += C6087a.m9557ix(5, this.wbS.computeSize());
            }
            if (this.wbT != null) {
                ix += C6087a.m9557ix(6, this.wbT.computeSize());
            }
            AppMethodBeat.m2505o(11742);
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
                AppMethodBeat.m2505o(11742);
                throw c6092b;
            } else if (this.vNh == null) {
                c6092b = new C6092b("Not all required fields were included: qy_base_resp");
                AppMethodBeat.m2505o(11742);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(11742);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C15386uh c15386uh = (C15386uh) objArr[1];
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
                        c15386uh.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(11742);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bos bos = new bos();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bos.populateBuilderWithField(c6086a3, bos, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c15386uh.vNh = bos;
                    }
                    AppMethodBeat.m2505o(11742);
                    return 0;
                case 3:
                    c15386uh.vNb = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(11742);
                    return 0;
                case 4:
                    c15386uh.wbR = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(11742);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        acr acr = new acr();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = acr.populateBuilderWithField(c6086a3, acr, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c15386uh.wbS = acr;
                    }
                    AppMethodBeat.m2505o(11742);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C44135kk c44135kk = new C44135kk();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c44135kk.populateBuilderWithField(c6086a3, c44135kk, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c15386uh.wbT = c44135kk;
                    }
                    AppMethodBeat.m2505o(11742);
                    return 0;
                default:
                    AppMethodBeat.m2505o(11742);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(11742);
            return -1;
        }
    }
}
