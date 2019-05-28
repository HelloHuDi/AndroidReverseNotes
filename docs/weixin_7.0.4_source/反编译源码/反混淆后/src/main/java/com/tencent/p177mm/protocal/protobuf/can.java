package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.can */
public final class can extends C1331a {
    public int jCt;
    public String ncM;
    public int pcX;
    public int vFH;
    public brf vFa;
    public String wPm;
    public String wZD;
    public String wZE;
    public int wZF;
    public int wZG;
    public int wZH;
    public long wZI;
    public long wZJ;
    public SKBuiltinBuffer_t wZK;
    public int wZL;
    public String wel;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(94563);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wPm != null) {
                c6093a.mo13475e(1, this.wPm);
            }
            if (this.wel != null) {
                c6093a.mo13475e(2, this.wel);
            }
            if (this.wZD != null) {
                c6093a.mo13475e(3, this.wZD);
            }
            if (this.wZE != null) {
                c6093a.mo13475e(4, this.wZE);
            }
            c6093a.mo13480iz(5, this.jCt);
            c6093a.mo13480iz(6, this.vFH);
            c6093a.mo13480iz(7, this.pcX);
            if (this.ncM != null) {
                c6093a.mo13475e(8, this.ncM);
            }
            c6093a.mo13480iz(9, this.wZF);
            c6093a.mo13480iz(10, this.wZG);
            c6093a.mo13480iz(11, this.wZH);
            c6093a.mo13472ai(12, this.wZI);
            c6093a.mo13472ai(13, this.wZJ);
            if (this.wZK != null) {
                c6093a.mo13479iy(14, this.wZK.computeSize());
                this.wZK.writeFields(c6093a);
            }
            c6093a.mo13480iz(15, this.wZL);
            if (this.vFa != null) {
                c6093a.mo13479iy(16, this.vFa.computeSize());
                this.vFa.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(94563);
            return 0;
        } else if (i == 1) {
            if (this.wPm != null) {
                f = C6091a.m9575f(1, this.wPm) + 0;
            } else {
                f = 0;
            }
            if (this.wel != null) {
                f += C6091a.m9575f(2, this.wel);
            }
            if (this.wZD != null) {
                f += C6091a.m9575f(3, this.wZD);
            }
            if (this.wZE != null) {
                f += C6091a.m9575f(4, this.wZE);
            }
            f = ((f + C6091a.m9572bs(5, this.jCt)) + C6091a.m9572bs(6, this.vFH)) + C6091a.m9572bs(7, this.pcX);
            if (this.ncM != null) {
                f += C6091a.m9575f(8, this.ncM);
            }
            f = ((((f + C6091a.m9572bs(9, this.wZF)) + C6091a.m9572bs(10, this.wZG)) + C6091a.m9572bs(11, this.wZH)) + C6091a.m9578o(12, this.wZI)) + C6091a.m9578o(13, this.wZJ);
            if (this.wZK != null) {
                f += C6087a.m9557ix(14, this.wZK.computeSize());
            }
            f += C6091a.m9572bs(15, this.wZL);
            if (this.vFa != null) {
                f += C6087a.m9557ix(16, this.vFa.computeSize());
            }
            AppMethodBeat.m2505o(94563);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(94563);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            can can = (can) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    can.wPm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94563);
                    return 0;
                case 2:
                    can.wel = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94563);
                    return 0;
                case 3:
                    can.wZD = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94563);
                    return 0;
                case 4:
                    can.wZE = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94563);
                    return 0;
                case 5:
                    can.jCt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94563);
                    return 0;
                case 6:
                    can.vFH = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94563);
                    return 0;
                case 7:
                    can.pcX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94563);
                    return 0;
                case 8:
                    can.ncM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94563);
                    return 0;
                case 9:
                    can.wZF = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94563);
                    return 0;
                case 10:
                    can.wZG = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94563);
                    return 0;
                case 11:
                    can.wZH = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94563);
                    return 0;
                case 12:
                    can.wZI = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(94563);
                    return 0;
                case 13:
                    can.wZJ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(94563);
                    return 0;
                case 14:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        can.wZK = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(94563);
                    return 0;
                case 15:
                    can.wZL = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94563);
                    return 0;
                case 16:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        brf brf = new brf();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = brf.populateBuilderWithField(c6086a3, brf, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        can.vFa = brf;
                    }
                    AppMethodBeat.m2505o(94563);
                    return 0;
                default:
                    AppMethodBeat.m2505o(94563);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(94563);
            return -1;
        }
    }
}
