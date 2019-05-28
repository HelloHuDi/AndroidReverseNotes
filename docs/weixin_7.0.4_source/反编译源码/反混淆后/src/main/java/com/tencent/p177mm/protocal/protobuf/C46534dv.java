package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.dv */
public final class C46534dv extends C1331a {
    public String fKh;
    public int jCt;
    public String ncM;
    public String ndF;
    public String ndG;
    public int pcX;
    public String vEG;
    public int vFE;
    public String vFF;
    public SKBuiltinBuffer_t vFG;
    public int vFH;
    public int vFI;
    public String vFJ;
    public String vFK;
    public String vFL;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28312);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.ndG != null) {
                c6093a.mo13475e(1, this.ndG);
            }
            if (this.fKh != null) {
                c6093a.mo13475e(2, this.fKh);
            }
            c6093a.mo13480iz(3, this.vFE);
            if (this.ndF != null) {
                c6093a.mo13475e(4, this.ndF);
            }
            c6093a.mo13480iz(5, this.jCt);
            if (this.ncM != null) {
                c6093a.mo13475e(6, this.ncM);
            }
            c6093a.mo13480iz(7, this.pcX);
            if (this.vFF != null) {
                c6093a.mo13475e(8, this.vFF);
            }
            if (this.vFG != null) {
                c6093a.mo13479iy(9, this.vFG.computeSize());
                this.vFG.writeFields(c6093a);
            }
            c6093a.mo13480iz(10, this.vFH);
            c6093a.mo13480iz(11, this.vFI);
            if (this.vEG != null) {
                c6093a.mo13475e(12, this.vEG);
            }
            if (this.vFJ != null) {
                c6093a.mo13475e(13, this.vFJ);
            }
            if (this.vFK != null) {
                c6093a.mo13475e(14, this.vFK);
            }
            if (this.vFL != null) {
                c6093a.mo13475e(15, this.vFL);
            }
            AppMethodBeat.m2505o(28312);
            return 0;
        } else if (i == 1) {
            if (this.ndG != null) {
                f = C6091a.m9575f(1, this.ndG) + 0;
            } else {
                f = 0;
            }
            if (this.fKh != null) {
                f += C6091a.m9575f(2, this.fKh);
            }
            f += C6091a.m9572bs(3, this.vFE);
            if (this.ndF != null) {
                f += C6091a.m9575f(4, this.ndF);
            }
            f += C6091a.m9572bs(5, this.jCt);
            if (this.ncM != null) {
                f += C6091a.m9575f(6, this.ncM);
            }
            f += C6091a.m9572bs(7, this.pcX);
            if (this.vFF != null) {
                f += C6091a.m9575f(8, this.vFF);
            }
            if (this.vFG != null) {
                f += C6087a.m9557ix(9, this.vFG.computeSize());
            }
            f = (f + C6091a.m9572bs(10, this.vFH)) + C6091a.m9572bs(11, this.vFI);
            if (this.vEG != null) {
                f += C6091a.m9575f(12, this.vEG);
            }
            if (this.vFJ != null) {
                f += C6091a.m9575f(13, this.vFJ);
            }
            if (this.vFK != null) {
                f += C6091a.m9575f(14, this.vFK);
            }
            if (this.vFL != null) {
                f += C6091a.m9575f(15, this.vFL);
            }
            AppMethodBeat.m2505o(28312);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(28312);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C46534dv c46534dv = (C46534dv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c46534dv.ndG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28312);
                    return 0;
                case 2:
                    c46534dv.fKh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28312);
                    return 0;
                case 3:
                    c46534dv.vFE = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28312);
                    return 0;
                case 4:
                    c46534dv.ndF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28312);
                    return 0;
                case 5:
                    c46534dv.jCt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28312);
                    return 0;
                case 6:
                    c46534dv.ncM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28312);
                    return 0;
                case 7:
                    c46534dv.pcX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28312);
                    return 0;
                case 8:
                    c46534dv.vFF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28312);
                    return 0;
                case 9:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c46534dv.vFG = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(28312);
                    return 0;
                case 10:
                    c46534dv.vFH = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28312);
                    return 0;
                case 11:
                    c46534dv.vFI = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28312);
                    return 0;
                case 12:
                    c46534dv.vEG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28312);
                    return 0;
                case 13:
                    c46534dv.vFJ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28312);
                    return 0;
                case 14:
                    c46534dv.vFK = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28312);
                    return 0;
                case 15:
                    c46534dv.vFL = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28312);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28312);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28312);
            return -1;
        }
    }
}
