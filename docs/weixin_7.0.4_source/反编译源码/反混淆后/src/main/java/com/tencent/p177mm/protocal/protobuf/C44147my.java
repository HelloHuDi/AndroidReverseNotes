package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.my */
public final class C44147my extends bsr {
    public int Scene;
    public String fKh;
    public String ndF;
    public String ndG;
    public String vCs;
    public String vCt;
    public String vCu;
    public String vEG;
    public int vFH;
    public String vRl;
    public int vRm;
    public int vRn;
    public SKBuiltinBuffer_t vRo;
    public float vRp;
    public float vRq;
    public String vRr;
    public int vRs;
    public int vRt;
    public int vRu;
    public int vRv;
    public String vRw;
    public int vRx;
    public int vRy;
    public int vRz;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(80031);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vRl != null) {
                c6093a.mo13475e(1, this.vRl);
            }
            if (this.ndG != null) {
                c6093a.mo13475e(2, this.ndG);
            }
            if (this.ndF != null) {
                c6093a.mo13475e(3, this.ndF);
            }
            c6093a.mo13480iz(4, this.vRm);
            c6093a.mo13480iz(5, this.vRn);
            if (this.vEG != null) {
                c6093a.mo13475e(6, this.vEG);
            }
            if (this.vRo != null) {
                c6093a.mo13479iy(7, this.vRo.computeSize());
                this.vRo.writeFields(c6093a);
            }
            c6093a.mo13480iz(8, this.Scene);
            c6093a.mo13481r(9, this.vRp);
            c6093a.mo13481r(10, this.vRq);
            if (this.vRr != null) {
                c6093a.mo13475e(11, this.vRr);
            }
            c6093a.mo13480iz(12, this.vRs);
            c6093a.mo13480iz(13, this.vRt);
            c6093a.mo13480iz(14, this.vRu);
            c6093a.mo13480iz(15, this.vRv);
            if (this.vRw != null) {
                c6093a.mo13475e(16, this.vRw);
            }
            c6093a.mo13480iz(17, this.vRx);
            c6093a.mo13480iz(18, this.vRy);
            c6093a.mo13480iz(19, this.vRz);
            c6093a.mo13480iz(20, this.vFH);
            if (this.fKh != null) {
                c6093a.mo13475e(21, this.fKh);
            }
            if (this.vCu != null) {
                c6093a.mo13475e(22, this.vCu);
            }
            if (this.vCt != null) {
                c6093a.mo13475e(23, this.vCt);
            }
            if (this.vCs != null) {
                c6093a.mo13475e(24, this.vCs);
            }
            AppMethodBeat.m2505o(80031);
            return 0;
        } else if (i == 1) {
            if (this.vRl != null) {
                f = C6091a.m9575f(1, this.vRl) + 0;
            } else {
                f = 0;
            }
            if (this.ndG != null) {
                f += C6091a.m9575f(2, this.ndG);
            }
            if (this.ndF != null) {
                f += C6091a.m9575f(3, this.ndF);
            }
            f = (f + C6091a.m9572bs(4, this.vRm)) + C6091a.m9572bs(5, this.vRn);
            if (this.vEG != null) {
                f += C6091a.m9575f(6, this.vEG);
            }
            if (this.vRo != null) {
                f += C6087a.m9557ix(7, this.vRo.computeSize());
            }
            f = ((f + C6091a.m9572bs(8, this.Scene)) + (C6091a.m9576fv(9) + 4)) + (C6091a.m9576fv(10) + 4);
            if (this.vRr != null) {
                f += C6091a.m9575f(11, this.vRr);
            }
            f = (((f + C6091a.m9572bs(12, this.vRs)) + C6091a.m9572bs(13, this.vRt)) + C6091a.m9572bs(14, this.vRu)) + C6091a.m9572bs(15, this.vRv);
            if (this.vRw != null) {
                f += C6091a.m9575f(16, this.vRw);
            }
            f = (((f + C6091a.m9572bs(17, this.vRx)) + C6091a.m9572bs(18, this.vRy)) + C6091a.m9572bs(19, this.vRz)) + C6091a.m9572bs(20, this.vFH);
            if (this.fKh != null) {
                f += C6091a.m9575f(21, this.fKh);
            }
            if (this.vCu != null) {
                f += C6091a.m9575f(22, this.vCu);
            }
            if (this.vCt != null) {
                f += C6091a.m9575f(23, this.vCt);
            }
            if (this.vCs != null) {
                f += C6091a.m9575f(24, this.vCs);
            }
            AppMethodBeat.m2505o(80031);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(80031);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C44147my c44147my = (C44147my) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c44147my.vRl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80031);
                    return 0;
                case 2:
                    c44147my.ndG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80031);
                    return 0;
                case 3:
                    c44147my.ndF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80031);
                    return 0;
                case 4:
                    c44147my.vRm = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80031);
                    return 0;
                case 5:
                    c44147my.vRn = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80031);
                    return 0;
                case 6:
                    c44147my.vEG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80031);
                    return 0;
                case 7:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c44147my.vRo = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(80031);
                    return 0;
                case 8:
                    c44147my.Scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80031);
                    return 0;
                case 9:
                    c44147my.vRp = Float.intBitsToFloat(c6086a2.BTU.eia());
                    AppMethodBeat.m2505o(80031);
                    return 0;
                case 10:
                    c44147my.vRq = Float.intBitsToFloat(c6086a2.BTU.eia());
                    AppMethodBeat.m2505o(80031);
                    return 0;
                case 11:
                    c44147my.vRr = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80031);
                    return 0;
                case 12:
                    c44147my.vRs = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80031);
                    return 0;
                case 13:
                    c44147my.vRt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80031);
                    return 0;
                case 14:
                    c44147my.vRu = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80031);
                    return 0;
                case 15:
                    c44147my.vRv = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80031);
                    return 0;
                case 16:
                    c44147my.vRw = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80031);
                    return 0;
                case 17:
                    c44147my.vRx = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80031);
                    return 0;
                case 18:
                    c44147my.vRy = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80031);
                    return 0;
                case 19:
                    c44147my.vRz = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80031);
                    return 0;
                case 20:
                    c44147my.vFH = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80031);
                    return 0;
                case 21:
                    c44147my.fKh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80031);
                    return 0;
                case 22:
                    c44147my.vCu = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80031);
                    return 0;
                case 23:
                    c44147my.vCt = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80031);
                    return 0;
                case 24:
                    c44147my.vCs = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80031);
                    return 0;
                default:
                    AppMethodBeat.m2505o(80031);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(80031);
            return -1;
        }
    }
}
