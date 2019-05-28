package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.x */
public final class C7559x extends btd {
    public int kCl = 268513600;
    public String kCm = "请求不成功，请稍候再试";
    public int vAA;
    public int vAB;
    public String vAC;
    public LinkedList<C46558k> vAD = new LinkedList();
    public String vAE;
    public String vAz;

    public C7559x() {
        AppMethodBeat.m2504i(56693);
        AppMethodBeat.m2505o(56693);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56694);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(56694);
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
            c6093a.mo13474e(4, 8, this.vAD);
            if (this.vAE != null) {
                c6093a.mo13475e(5, this.vAE);
            }
            if (this.vAz != null) {
                c6093a.mo13475e(6, this.vAz);
            }
            c6093a.mo13480iz(7, this.vAA);
            c6093a.mo13480iz(8, this.vAB);
            if (this.vAC != null) {
                c6093a.mo13475e(9, this.vAC);
            }
            AppMethodBeat.m2505o(56694);
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
            ix += C6087a.m9552c(4, 8, this.vAD);
            if (this.vAE != null) {
                ix += C6091a.m9575f(5, this.vAE);
            }
            if (this.vAz != null) {
                ix += C6091a.m9575f(6, this.vAz);
            }
            ix = (ix + C6091a.m9572bs(7, this.vAA)) + C6091a.m9572bs(8, this.vAB);
            if (this.vAC != null) {
                ix += C6091a.m9575f(9, this.vAC);
            }
            AppMethodBeat.m2505o(56694);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vAD.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(56694);
                throw c6092b;
            }
            AppMethodBeat.m2505o(56694);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C7559x c7559x = (C7559x) objArr[1];
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
                        c7559x.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(56694);
                    return 0;
                case 2:
                    c7559x.kCl = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56694);
                    return 0;
                case 3:
                    c7559x.kCm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56694);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C46558k c46558k = new C46558k();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c46558k.populateBuilderWithField(c6086a3, c46558k, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c7559x.vAD.add(c46558k);
                    }
                    AppMethodBeat.m2505o(56694);
                    return 0;
                case 5:
                    c7559x.vAE = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56694);
                    return 0;
                case 6:
                    c7559x.vAz = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56694);
                    return 0;
                case 7:
                    c7559x.vAA = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56694);
                    return 0;
                case 8:
                    c7559x.vAB = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56694);
                    return 0;
                case 9:
                    c7559x.vAC = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56694);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56694);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56694);
            return -1;
        }
    }
}
