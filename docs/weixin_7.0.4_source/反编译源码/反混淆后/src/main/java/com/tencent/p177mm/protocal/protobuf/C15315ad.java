package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ad */
public final class C15315ad extends btd {
    public int vAS;
    public String vAT;
    public bzt vAU;
    public bqv vAV;
    public int vBc;
    public C30229tw vBg;
    public boolean vBh;
    public int vBi;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28296);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(28296);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.vAS);
            if (this.vAT != null) {
                c6093a.mo13475e(3, this.vAT);
            }
            if (this.vAU != null) {
                c6093a.mo13479iy(4, this.vAU.computeSize());
                this.vAU.writeFields(c6093a);
            }
            if (this.vAV != null) {
                c6093a.mo13479iy(5, this.vAV.computeSize());
                this.vAV.writeFields(c6093a);
            }
            c6093a.mo13480iz(6, this.vBc);
            if (this.vBg != null) {
                c6093a.mo13479iy(7, this.vBg.computeSize());
                this.vBg.writeFields(c6093a);
            }
            c6093a.mo13471aO(8, this.vBh);
            c6093a.mo13480iz(9, this.vBi);
            AppMethodBeat.m2505o(28296);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += C6091a.m9572bs(2, this.vAS);
            if (this.vAT != null) {
                ix += C6091a.m9575f(3, this.vAT);
            }
            if (this.vAU != null) {
                ix += C6087a.m9557ix(4, this.vAU.computeSize());
            }
            if (this.vAV != null) {
                ix += C6087a.m9557ix(5, this.vAV.computeSize());
            }
            ix += C6091a.m9572bs(6, this.vBc);
            if (this.vBg != null) {
                ix += C6087a.m9557ix(7, this.vBg.computeSize());
            }
            int fv = (ix + (C6091a.m9576fv(8) + 1)) + C6091a.m9572bs(9, this.vBi);
            AppMethodBeat.m2505o(28296);
            return fv;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(28296);
                throw c6092b;
            }
            AppMethodBeat.m2505o(28296);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C15315ad c15315ad = (C15315ad) objArr[1];
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
                        c15315ad.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(28296);
                    return 0;
                case 2:
                    c15315ad.vAS = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28296);
                    return 0;
                case 3:
                    c15315ad.vAT = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28296);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bzt bzt = new bzt();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bzt.populateBuilderWithField(c6086a3, bzt, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c15315ad.vAU = bzt;
                    }
                    AppMethodBeat.m2505o(28296);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bqv bqv = new bqv();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bqv.populateBuilderWithField(c6086a3, bqv, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c15315ad.vAV = bqv;
                    }
                    AppMethodBeat.m2505o(28296);
                    return 0;
                case 6:
                    c15315ad.vBc = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28296);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C30229tw c30229tw = new C30229tw();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c30229tw.populateBuilderWithField(c6086a3, c30229tw, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c15315ad.vBg = c30229tw;
                    }
                    AppMethodBeat.m2505o(28296);
                    return 0;
                case 8:
                    c15315ad.vBh = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(28296);
                    return 0;
                case 9:
                    c15315ad.vBi = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28296);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28296);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28296);
            return -1;
        }
    }
}
