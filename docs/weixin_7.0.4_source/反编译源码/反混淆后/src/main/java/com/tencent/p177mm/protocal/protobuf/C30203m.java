package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.m */
public final class C30203m extends btd {
    public int kCl = 268513600;
    public String kCm = "请求不成功，请稍候再试";
    public String kCx;
    public String kCy;
    public int vAa;
    public int vAb;
    public long vAc;
    public long vAd;
    public int vzZ;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56681);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(56681);
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
            c6093a.mo13480iz(4, this.vzZ);
            c6093a.mo13480iz(5, this.vAa);
            c6093a.mo13480iz(6, this.vAb);
            c6093a.mo13472ai(7, this.vAc);
            c6093a.mo13472ai(8, this.vAd);
            if (this.kCx != null) {
                c6093a.mo13475e(9, this.kCx);
            }
            if (this.kCy != null) {
                c6093a.mo13475e(10, this.kCy);
            }
            AppMethodBeat.m2505o(56681);
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
            ix = ((((ix + C6091a.m9572bs(4, this.vzZ)) + C6091a.m9572bs(5, this.vAa)) + C6091a.m9572bs(6, this.vAb)) + C6091a.m9578o(7, this.vAc)) + C6091a.m9578o(8, this.vAd);
            if (this.kCx != null) {
                ix += C6091a.m9575f(9, this.kCx);
            }
            if (this.kCy != null) {
                ix += C6091a.m9575f(10, this.kCy);
            }
            AppMethodBeat.m2505o(56681);
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
                AppMethodBeat.m2505o(56681);
                throw c6092b;
            }
            AppMethodBeat.m2505o(56681);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C30203m c30203m = (C30203m) objArr[1];
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
                        c30203m.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(56681);
                    return 0;
                case 2:
                    c30203m.kCl = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56681);
                    return 0;
                case 3:
                    c30203m.kCm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56681);
                    return 0;
                case 4:
                    c30203m.vzZ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56681);
                    return 0;
                case 5:
                    c30203m.vAa = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56681);
                    return 0;
                case 6:
                    c30203m.vAb = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56681);
                    return 0;
                case 7:
                    c30203m.vAc = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56681);
                    return 0;
                case 8:
                    c30203m.vAd = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56681);
                    return 0;
                case 9:
                    c30203m.kCx = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56681);
                    return 0;
                case 10:
                    c30203m.kCy = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56681);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56681);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56681);
            return -1;
        }
    }
}
