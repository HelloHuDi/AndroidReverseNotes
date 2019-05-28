package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cvd */
public final class cvd extends C1331a {
    public int Scene;
    public int jCt;
    public int vOq;
    public String vQg;
    public int wCv = 2;
    public String wCy;
    public int wDH;
    public axy wDI;
    public String wIF;
    public String wSi;
    public int wUr;
    public String wkD;
    public int xfr;
    public LinkedList<String> xgp = new LinkedList();
    public LinkedList<C23447tn> xqa = new LinkedList();
    public int xrc;
    public String xrd;
    public int xre;
    public int xrf;

    public cvd() {
        AppMethodBeat.m2504i(124379);
        AppMethodBeat.m2505o(124379);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(124380);
        int bs;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.vOq);
            c6093a.mo13480iz(2, this.wDH);
            c6093a.mo13480iz(3, this.wUr);
            if (this.wkD != null) {
                c6093a.mo13475e(4, this.wkD);
            }
            if (this.wDI != null) {
                c6093a.mo13479iy(5, this.wDI.computeSize());
                this.wDI.writeFields(c6093a);
            }
            c6093a.mo13480iz(6, this.Scene);
            if (this.vQg != null) {
                c6093a.mo13475e(7, this.vQg);
            }
            c6093a.mo13480iz(8, this.xrc);
            c6093a.mo13480iz(9, this.wCv);
            c6093a.mo13474e(10, 8, this.xqa);
            if (this.wCy != null) {
                c6093a.mo13475e(11, this.wCy);
            }
            if (this.wIF != null) {
                c6093a.mo13475e(12, this.wIF);
            }
            c6093a.mo13480iz(13, this.xfr);
            if (this.xrd != null) {
                c6093a.mo13475e(14, this.xrd);
            }
            if (this.wSi != null) {
                c6093a.mo13475e(15, this.wSi);
            }
            c6093a.mo13474e(16, 1, this.xgp);
            c6093a.mo13480iz(17, this.xre);
            c6093a.mo13480iz(18, this.jCt);
            c6093a.mo13480iz(19, this.xrf);
            AppMethodBeat.m2505o(124380);
            return 0;
        } else if (i == 1) {
            bs = ((C6091a.m9572bs(1, this.vOq) + 0) + C6091a.m9572bs(2, this.wDH)) + C6091a.m9572bs(3, this.wUr);
            if (this.wkD != null) {
                bs += C6091a.m9575f(4, this.wkD);
            }
            if (this.wDI != null) {
                bs += C6087a.m9557ix(5, this.wDI.computeSize());
            }
            bs += C6091a.m9572bs(6, this.Scene);
            if (this.vQg != null) {
                bs += C6091a.m9575f(7, this.vQg);
            }
            bs = ((bs + C6091a.m9572bs(8, this.xrc)) + C6091a.m9572bs(9, this.wCv)) + C6087a.m9552c(10, 8, this.xqa);
            if (this.wCy != null) {
                bs += C6091a.m9575f(11, this.wCy);
            }
            if (this.wIF != null) {
                bs += C6091a.m9575f(12, this.wIF);
            }
            bs += C6091a.m9572bs(13, this.xfr);
            if (this.xrd != null) {
                bs += C6091a.m9575f(14, this.xrd);
            }
            if (this.wSi != null) {
                bs += C6091a.m9575f(15, this.wSi);
            }
            bs = (((bs + C6087a.m9552c(16, 1, this.xgp)) + C6091a.m9572bs(17, this.xre)) + C6091a.m9572bs(18, this.jCt)) + C6091a.m9572bs(19, this.xrf);
            AppMethodBeat.m2505o(124380);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xqa.clear();
            this.xgp.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(124380);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cvd cvd = (cvd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    cvd.vOq = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124380);
                    return 0;
                case 2:
                    cvd.wDH = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124380);
                    return 0;
                case 3:
                    cvd.wUr = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124380);
                    return 0;
                case 4:
                    cvd.wkD = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124380);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        axy axy = new axy();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = axy.populateBuilderWithField(c6086a3, axy, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cvd.wDI = axy;
                    }
                    AppMethodBeat.m2505o(124380);
                    return 0;
                case 6:
                    cvd.Scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124380);
                    return 0;
                case 7:
                    cvd.vQg = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124380);
                    return 0;
                case 8:
                    cvd.xrc = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124380);
                    return 0;
                case 9:
                    cvd.wCv = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124380);
                    return 0;
                case 10:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C23447tn c23447tn = new C23447tn();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c23447tn.populateBuilderWithField(c6086a3, c23447tn, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cvd.xqa.add(c23447tn);
                    }
                    AppMethodBeat.m2505o(124380);
                    return 0;
                case 11:
                    cvd.wCy = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124380);
                    return 0;
                case 12:
                    cvd.wIF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124380);
                    return 0;
                case 13:
                    cvd.xfr = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124380);
                    return 0;
                case 14:
                    cvd.xrd = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124380);
                    return 0;
                case 15:
                    cvd.wSi = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124380);
                    return 0;
                case 16:
                    cvd.xgp.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(124380);
                    return 0;
                case 17:
                    cvd.xre = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124380);
                    return 0;
                case 18:
                    cvd.jCt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124380);
                    return 0;
                case 19:
                    cvd.xrf = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124380);
                    return 0;
                default:
                    AppMethodBeat.m2505o(124380);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(124380);
            return -1;
        }
    }
}
