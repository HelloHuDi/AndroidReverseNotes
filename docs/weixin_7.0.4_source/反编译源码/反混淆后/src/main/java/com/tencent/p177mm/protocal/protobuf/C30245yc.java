package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.yc */
public final class C30245yc extends C1331a {
    public int jCt;
    public String ndF;
    public int ptw;
    public int ptx;
    public String vEG;
    public String wdO;
    public SKBuiltinBuffer_t wdP;
    public String wdQ;
    public String wdR;
    public String wdS;
    public int wdT;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(53871);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wdP == null) {
                c6092b = new C6092b("Not all required fields were included: EmojiBuffer");
                AppMethodBeat.m2505o(53871);
                throw c6092b;
            }
            if (this.wdO != null) {
                c6093a.mo13475e(1, this.wdO);
            }
            c6093a.mo13480iz(2, this.ptx);
            c6093a.mo13480iz(3, this.ptw);
            if (this.wdP != null) {
                c6093a.mo13479iy(4, this.wdP.computeSize());
                this.wdP.writeFields(c6093a);
            }
            c6093a.mo13480iz(5, this.jCt);
            if (this.ndF != null) {
                c6093a.mo13475e(6, this.ndF);
            }
            if (this.wdQ != null) {
                c6093a.mo13475e(7, this.wdQ);
            }
            if (this.wdR != null) {
                c6093a.mo13475e(8, this.wdR);
            }
            if (this.wdS != null) {
                c6093a.mo13475e(9, this.wdS);
            }
            if (this.vEG != null) {
                c6093a.mo13475e(10, this.vEG);
            }
            c6093a.mo13480iz(11, this.wdT);
            AppMethodBeat.m2505o(53871);
            return 0;
        } else if (i == 1) {
            if (this.wdO != null) {
                f = C6091a.m9575f(1, this.wdO) + 0;
            } else {
                f = 0;
            }
            f = (f + C6091a.m9572bs(2, this.ptx)) + C6091a.m9572bs(3, this.ptw);
            if (this.wdP != null) {
                f += C6087a.m9557ix(4, this.wdP.computeSize());
            }
            f += C6091a.m9572bs(5, this.jCt);
            if (this.ndF != null) {
                f += C6091a.m9575f(6, this.ndF);
            }
            if (this.wdQ != null) {
                f += C6091a.m9575f(7, this.wdQ);
            }
            if (this.wdR != null) {
                f += C6091a.m9575f(8, this.wdR);
            }
            if (this.wdS != null) {
                f += C6091a.m9575f(9, this.wdS);
            }
            if (this.vEG != null) {
                f += C6091a.m9575f(10, this.vEG);
            }
            int bs = f + C6091a.m9572bs(11, this.wdT);
            AppMethodBeat.m2505o(53871);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.wdP == null) {
                c6092b = new C6092b("Not all required fields were included: EmojiBuffer");
                AppMethodBeat.m2505o(53871);
                throw c6092b;
            }
            AppMethodBeat.m2505o(53871);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C30245yc c30245yc = (C30245yc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c30245yc.wdO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(53871);
                    return 0;
                case 2:
                    c30245yc.ptx = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(53871);
                    return 0;
                case 3:
                    c30245yc.ptw = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(53871);
                    return 0;
                case 4:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c30245yc.wdP = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(53871);
                    return 0;
                case 5:
                    c30245yc.jCt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(53871);
                    return 0;
                case 6:
                    c30245yc.ndF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(53871);
                    return 0;
                case 7:
                    c30245yc.wdQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(53871);
                    return 0;
                case 8:
                    c30245yc.wdR = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(53871);
                    return 0;
                case 9:
                    c30245yc.wdS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(53871);
                    return 0;
                case 10:
                    c30245yc.vEG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(53871);
                    return 0;
                case 11:
                    c30245yc.wdT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(53871);
                    return 0;
                default:
                    AppMethodBeat.m2505o(53871);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(53871);
            return -1;
        }
    }
}
