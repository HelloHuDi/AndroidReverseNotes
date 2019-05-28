package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.aes */
public final class aes extends btd {
    public C23391gj mzh;
    public int vAO;
    public int vAS;
    public String vAT;
    public bzt vAU;
    public int vBc;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28416);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(28416);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.vAS);
            c6093a.mo13480iz(3, this.vBc);
            if (this.vAT != null) {
                c6093a.mo13475e(4, this.vAT);
            }
            if (this.vAU != null) {
                c6093a.mo13479iy(5, this.vAU.computeSize());
                this.vAU.writeFields(c6093a);
            }
            if (this.mzh != null) {
                c6093a.mo13479iy(6, this.mzh.computeSize());
                this.mzh.writeFields(c6093a);
            }
            c6093a.mo13480iz(7, this.vAO);
            AppMethodBeat.m2505o(28416);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + C6091a.m9572bs(2, this.vAS)) + C6091a.m9572bs(3, this.vBc);
            if (this.vAT != null) {
                ix += C6091a.m9575f(4, this.vAT);
            }
            if (this.vAU != null) {
                ix += C6087a.m9557ix(5, this.vAU.computeSize());
            }
            if (this.mzh != null) {
                ix += C6087a.m9557ix(6, this.mzh.computeSize());
            }
            int bs = ix + C6091a.m9572bs(7, this.vAO);
            AppMethodBeat.m2505o(28416);
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
                AppMethodBeat.m2505o(28416);
                throw c6092b;
            }
            AppMethodBeat.m2505o(28416);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            aes aes = (aes) objArr[1];
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
                        aes.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(28416);
                    return 0;
                case 2:
                    aes.vAS = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28416);
                    return 0;
                case 3:
                    aes.vBc = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28416);
                    return 0;
                case 4:
                    aes.vAT = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28416);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bzt bzt = new bzt();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bzt.populateBuilderWithField(c6086a3, bzt, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        aes.vAU = bzt;
                    }
                    AppMethodBeat.m2505o(28416);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C23391gj c23391gj = new C23391gj();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c23391gj.populateBuilderWithField(c6086a3, c23391gj, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        aes.mzh = c23391gj;
                    }
                    AppMethodBeat.m2505o(28416);
                    return 0;
                case 7:
                    aes.vAO = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28416);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28416);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28416);
            return -1;
        }
    }
}
