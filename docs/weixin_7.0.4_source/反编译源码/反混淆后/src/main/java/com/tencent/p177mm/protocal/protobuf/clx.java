package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.clx */
public final class clx extends bsr {
    public int fJT;
    public String ndF;
    public String ndG;
    public int ptD;
    public long ptF;
    public SKBuiltinBuffer_t ptz;
    public String vEG;
    public String vFF;
    public int vOq;
    public int wEz;
    public int wdW;
    public int wdn;
    public int wdp;
    public int wdq;
    public int xjF;
    public int xjG;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(116811);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.ptz == null) {
                c6092b = new C6092b("Not all required fields were included: Data");
                AppMethodBeat.m2505o(116811);
                throw c6092b;
            }
            if (this.ndG != null) {
                c6093a.mo13475e(1, this.ndG);
            }
            if (this.ndF != null) {
                c6093a.mo13475e(2, this.ndF);
            }
            c6093a.mo13480iz(3, this.vOq);
            c6093a.mo13480iz(4, this.wdn);
            if (this.vFF != null) {
                c6093a.mo13475e(5, this.vFF);
            }
            c6093a.mo13480iz(6, this.ptD);
            c6093a.mo13480iz(7, this.wdp);
            if (this.ptz != null) {
                c6093a.mo13479iy(8, this.ptz.computeSize());
                this.ptz.writeFields(c6093a);
            }
            c6093a.mo13480iz(9, this.fJT);
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(10, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            c6093a.mo13480iz(11, this.wdq);
            if (this.vEG != null) {
                c6093a.mo13475e(12, this.vEG);
            }
            c6093a.mo13480iz(13, this.wEz);
            c6093a.mo13480iz(14, this.xjF);
            c6093a.mo13480iz(15, this.xjG);
            c6093a.mo13472ai(16, this.ptF);
            c6093a.mo13480iz(17, this.wdW);
            AppMethodBeat.m2505o(116811);
            return 0;
        } else if (i == 1) {
            if (this.ndG != null) {
                f = C6091a.m9575f(1, this.ndG) + 0;
            } else {
                f = 0;
            }
            if (this.ndF != null) {
                f += C6091a.m9575f(2, this.ndF);
            }
            f = (f + C6091a.m9572bs(3, this.vOq)) + C6091a.m9572bs(4, this.wdn);
            if (this.vFF != null) {
                f += C6091a.m9575f(5, this.vFF);
            }
            f = (f + C6091a.m9572bs(6, this.ptD)) + C6091a.m9572bs(7, this.wdp);
            if (this.ptz != null) {
                f += C6087a.m9557ix(8, this.ptz.computeSize());
            }
            f += C6091a.m9572bs(9, this.fJT);
            if (this.BaseRequest != null) {
                f += C6087a.m9557ix(10, this.BaseRequest.computeSize());
            }
            f += C6091a.m9572bs(11, this.wdq);
            if (this.vEG != null) {
                f += C6091a.m9575f(12, this.vEG);
            }
            int bs = ((((f + C6091a.m9572bs(13, this.wEz)) + C6091a.m9572bs(14, this.xjF)) + C6091a.m9572bs(15, this.xjG)) + C6091a.m9578o(16, this.ptF)) + C6091a.m9572bs(17, this.wdW);
            AppMethodBeat.m2505o(116811);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.ptz == null) {
                c6092b = new C6092b("Not all required fields were included: Data");
                AppMethodBeat.m2505o(116811);
                throw c6092b;
            }
            AppMethodBeat.m2505o(116811);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            clx clx = (clx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    clx.ndG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(116811);
                    return 0;
                case 2:
                    clx.ndF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(116811);
                    return 0;
                case 3:
                    clx.vOq = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(116811);
                    return 0;
                case 4:
                    clx.wdn = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(116811);
                    return 0;
                case 5:
                    clx.vFF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(116811);
                    return 0;
                case 6:
                    clx.ptD = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(116811);
                    return 0;
                case 7:
                    clx.wdp = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(116811);
                    return 0;
                case 8:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        clx.ptz = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(116811);
                    return 0;
                case 9:
                    clx.fJT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(116811);
                    return 0;
                case 10:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7267hl c7267hl = new C7267hl();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7267hl.populateBuilderWithField(c6086a3, c7267hl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        clx.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(116811);
                    return 0;
                case 11:
                    clx.wdq = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(116811);
                    return 0;
                case 12:
                    clx.vEG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(116811);
                    return 0;
                case 13:
                    clx.wEz = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(116811);
                    return 0;
                case 14:
                    clx.xjF = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(116811);
                    return 0;
                case 15:
                    clx.xjG = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(116811);
                    return 0;
                case 16:
                    clx.ptF = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(116811);
                    return 0;
                case 17:
                    clx.wdW = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(116811);
                    return 0;
                default:
                    AppMethodBeat.m2505o(116811);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(116811);
            return -1;
        }
    }
}
