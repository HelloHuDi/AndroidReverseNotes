package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ab */
public final class C40500ab extends btd {
    public int OpCode;
    public String vAQ;
    public int vAR;
    public int vAS;
    public String vAT;
    public bzt vAU;
    public bqv vAV;
    public bzt vAW;
    public bns vAX;
    public acq vAY;
    public C23391gj vAZ;
    public String vBa;
    public String vBb;
    public int vBc;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28293);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(28293);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            if (this.vAQ != null) {
                c6093a.mo13475e(2, this.vAQ);
            }
            c6093a.mo13480iz(3, this.vAR);
            c6093a.mo13480iz(4, this.vAS);
            if (this.vAT != null) {
                c6093a.mo13475e(5, this.vAT);
            }
            if (this.vAU != null) {
                c6093a.mo13479iy(6, this.vAU.computeSize());
                this.vAU.writeFields(c6093a);
            }
            c6093a.mo13480iz(7, this.OpCode);
            if (this.vAV != null) {
                c6093a.mo13479iy(8, this.vAV.computeSize());
                this.vAV.writeFields(c6093a);
            }
            if (this.vAW != null) {
                c6093a.mo13479iy(9, this.vAW.computeSize());
                this.vAW.writeFields(c6093a);
            }
            if (this.vAX != null) {
                c6093a.mo13479iy(10, this.vAX.computeSize());
                this.vAX.writeFields(c6093a);
            }
            if (this.vAY != null) {
                c6093a.mo13479iy(11, this.vAY.computeSize());
                this.vAY.writeFields(c6093a);
            }
            if (this.vAZ != null) {
                c6093a.mo13479iy(12, this.vAZ.computeSize());
                this.vAZ.writeFields(c6093a);
            }
            if (this.vBa != null) {
                c6093a.mo13475e(13, this.vBa);
            }
            if (this.vBb != null) {
                c6093a.mo13475e(14, this.vBb);
            }
            c6093a.mo13480iz(15, this.vBc);
            AppMethodBeat.m2505o(28293);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vAQ != null) {
                ix += C6091a.m9575f(2, this.vAQ);
            }
            ix = (ix + C6091a.m9572bs(3, this.vAR)) + C6091a.m9572bs(4, this.vAS);
            if (this.vAT != null) {
                ix += C6091a.m9575f(5, this.vAT);
            }
            if (this.vAU != null) {
                ix += C6087a.m9557ix(6, this.vAU.computeSize());
            }
            ix += C6091a.m9572bs(7, this.OpCode);
            if (this.vAV != null) {
                ix += C6087a.m9557ix(8, this.vAV.computeSize());
            }
            if (this.vAW != null) {
                ix += C6087a.m9557ix(9, this.vAW.computeSize());
            }
            if (this.vAX != null) {
                ix += C6087a.m9557ix(10, this.vAX.computeSize());
            }
            if (this.vAY != null) {
                ix += C6087a.m9557ix(11, this.vAY.computeSize());
            }
            if (this.vAZ != null) {
                ix += C6087a.m9557ix(12, this.vAZ.computeSize());
            }
            if (this.vBa != null) {
                ix += C6091a.m9575f(13, this.vBa);
            }
            if (this.vBb != null) {
                ix += C6091a.m9575f(14, this.vBb);
            }
            int bs = ix + C6091a.m9572bs(15, this.vBc);
            AppMethodBeat.m2505o(28293);
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
                AppMethodBeat.m2505o(28293);
                throw c6092b;
            }
            AppMethodBeat.m2505o(28293);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C40500ab c40500ab = (C40500ab) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            bzt bzt;
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
                        c40500ab.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(28293);
                    return 0;
                case 2:
                    c40500ab.vAQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28293);
                    return 0;
                case 3:
                    c40500ab.vAR = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28293);
                    return 0;
                case 4:
                    c40500ab.vAS = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28293);
                    return 0;
                case 5:
                    c40500ab.vAT = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28293);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bzt = new bzt();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bzt.populateBuilderWithField(c6086a3, bzt, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c40500ab.vAU = bzt;
                    }
                    AppMethodBeat.m2505o(28293);
                    return 0;
                case 7:
                    c40500ab.OpCode = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28293);
                    return 0;
                case 8:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bqv bqv = new bqv();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bqv.populateBuilderWithField(c6086a3, bqv, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c40500ab.vAV = bqv;
                    }
                    AppMethodBeat.m2505o(28293);
                    return 0;
                case 9:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bzt = new bzt();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bzt.populateBuilderWithField(c6086a3, bzt, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c40500ab.vAW = bzt;
                    }
                    AppMethodBeat.m2505o(28293);
                    return 0;
                case 10:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bns bns = new bns();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bns.populateBuilderWithField(c6086a3, bns, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c40500ab.vAX = bns;
                    }
                    AppMethodBeat.m2505o(28293);
                    return 0;
                case 11:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        acq acq = new acq();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = acq.populateBuilderWithField(c6086a3, acq, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c40500ab.vAY = acq;
                    }
                    AppMethodBeat.m2505o(28293);
                    return 0;
                case 12:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C23391gj c23391gj = new C23391gj();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c23391gj.populateBuilderWithField(c6086a3, c23391gj, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c40500ab.vAZ = c23391gj;
                    }
                    AppMethodBeat.m2505o(28293);
                    return 0;
                case 13:
                    c40500ab.vBa = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28293);
                    return 0;
                case 14:
                    c40500ab.vBb = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28293);
                    return 0;
                case 15:
                    c40500ab.vBc = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28293);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28293);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28293);
            return -1;
        }
    }
}
