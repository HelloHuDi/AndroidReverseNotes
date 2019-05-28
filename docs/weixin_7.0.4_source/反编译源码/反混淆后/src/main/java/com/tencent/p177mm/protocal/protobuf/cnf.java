package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cnf */
public final class cnf extends C1331a {
    public String pXM;
    public int vGB;
    public String wVn;
    public String wlF;
    public String wlx;
    public String xkE;
    public int xkF;
    public String xkG;
    public String xkH;
    public int xkI;
    public String xkJ;
    public int xkK;
    public SKBuiltinBuffer_t xkL;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(80207);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.pXM != null) {
                c6093a.mo13475e(1, this.pXM);
            }
            if (this.xkE != null) {
                c6093a.mo13475e(2, this.xkE);
            }
            if (this.wlF != null) {
                c6093a.mo13475e(3, this.wlF);
            }
            c6093a.mo13480iz(4, this.xkF);
            if (this.wVn != null) {
                c6093a.mo13475e(5, this.wVn);
            }
            if (this.xkG != null) {
                c6093a.mo13475e(6, this.xkG);
            }
            if (this.xkH != null) {
                c6093a.mo13475e(7, this.xkH);
            }
            c6093a.mo13480iz(8, this.xkI);
            if (this.xkJ != null) {
                c6093a.mo13475e(9, this.xkJ);
            }
            c6093a.mo13480iz(10, this.xkK);
            if (this.xkL != null) {
                c6093a.mo13479iy(11, this.xkL.computeSize());
                this.xkL.writeFields(c6093a);
            }
            if (this.wlx != null) {
                c6093a.mo13475e(12, this.wlx);
            }
            c6093a.mo13480iz(13, this.vGB);
            AppMethodBeat.m2505o(80207);
            return 0;
        } else if (i == 1) {
            if (this.pXM != null) {
                f = C6091a.m9575f(1, this.pXM) + 0;
            } else {
                f = 0;
            }
            if (this.xkE != null) {
                f += C6091a.m9575f(2, this.xkE);
            }
            if (this.wlF != null) {
                f += C6091a.m9575f(3, this.wlF);
            }
            f += C6091a.m9572bs(4, this.xkF);
            if (this.wVn != null) {
                f += C6091a.m9575f(5, this.wVn);
            }
            if (this.xkG != null) {
                f += C6091a.m9575f(6, this.xkG);
            }
            if (this.xkH != null) {
                f += C6091a.m9575f(7, this.xkH);
            }
            f += C6091a.m9572bs(8, this.xkI);
            if (this.xkJ != null) {
                f += C6091a.m9575f(9, this.xkJ);
            }
            f += C6091a.m9572bs(10, this.xkK);
            if (this.xkL != null) {
                f += C6087a.m9557ix(11, this.xkL.computeSize());
            }
            if (this.wlx != null) {
                f += C6091a.m9575f(12, this.wlx);
            }
            int bs = f + C6091a.m9572bs(13, this.vGB);
            AppMethodBeat.m2505o(80207);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(80207);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cnf cnf = (cnf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cnf.pXM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80207);
                    return 0;
                case 2:
                    cnf.xkE = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80207);
                    return 0;
                case 3:
                    cnf.wlF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80207);
                    return 0;
                case 4:
                    cnf.xkF = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80207);
                    return 0;
                case 5:
                    cnf.wVn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80207);
                    return 0;
                case 6:
                    cnf.xkG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80207);
                    return 0;
                case 7:
                    cnf.xkH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80207);
                    return 0;
                case 8:
                    cnf.xkI = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80207);
                    return 0;
                case 9:
                    cnf.xkJ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80207);
                    return 0;
                case 10:
                    cnf.xkK = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80207);
                    return 0;
                case 11:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cnf.xkL = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(80207);
                    return 0;
                case 12:
                    cnf.wlx = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80207);
                    return 0;
                case 13:
                    cnf.vGB = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80207);
                    return 0;
                default:
                    AppMethodBeat.m2505o(80207);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(80207);
            return -1;
        }
    }
}
