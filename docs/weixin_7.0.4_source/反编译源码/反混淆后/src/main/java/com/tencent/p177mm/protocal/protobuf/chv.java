package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.chv */
public final class chv extends C1331a {
    public String ctj;
    public boolean eif;
    public String hlm;
    public int offset;
    public int scene;
    public LinkedList<C23447tn> tZG = new LinkedList();
    public String xgC;
    public String xgD;
    public String xgE;
    public String xgF;
    public long xgG;
    public chw xgH;
    public bzs xgI;
    public boolean xgJ;
    public LinkedList<chw> xgK = new LinkedList();
    public int xgL;
    public int xgM;
    public String xgN;
    public int xgO;
    public boolean xgP;
    public String xgj;

    public chv() {
        AppMethodBeat.m2504i(55708);
        AppMethodBeat.m2505o(55708);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(55709);
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.xgC != null) {
                c6093a.mo13475e(1, this.xgC);
            }
            if (this.xgD != null) {
                c6093a.mo13475e(2, this.xgD);
            }
            if (this.xgE != null) {
                c6093a.mo13475e(3, this.xgE);
            }
            if (this.xgF != null) {
                c6093a.mo13475e(4, this.xgF);
            }
            c6093a.mo13472ai(5, this.xgG);
            c6093a.mo13480iz(6, this.scene);
            if (this.hlm != null) {
                c6093a.mo13475e(7, this.hlm);
            }
            if (this.ctj != null) {
                c6093a.mo13475e(8, this.ctj);
            }
            if (this.xgH != null) {
                c6093a.mo13479iy(9, this.xgH.computeSize());
                this.xgH.writeFields(c6093a);
            }
            if (this.xgI != null) {
                c6093a.mo13479iy(10, this.xgI.computeSize());
                this.xgI.writeFields(c6093a);
            }
            c6093a.mo13474e(11, 8, this.tZG);
            if (this.xgj != null) {
                c6093a.mo13475e(12, this.xgj);
            }
            c6093a.mo13480iz(13, this.offset);
            c6093a.mo13471aO(14, this.xgJ);
            c6093a.mo13474e(15, 8, this.xgK);
            c6093a.mo13480iz(16, this.xgL);
            c6093a.mo13480iz(17, this.xgM);
            c6093a.mo13471aO(18, this.eif);
            if (this.xgN != null) {
                c6093a.mo13475e(19, this.xgN);
            }
            c6093a.mo13480iz(20, this.xgO);
            c6093a.mo13471aO(21, this.xgP);
            AppMethodBeat.m2505o(55709);
            return 0;
        } else if (i == 1) {
            if (this.xgC != null) {
                f = C6091a.m9575f(1, this.xgC) + 0;
            } else {
                f = 0;
            }
            if (this.xgD != null) {
                f += C6091a.m9575f(2, this.xgD);
            }
            if (this.xgE != null) {
                f += C6091a.m9575f(3, this.xgE);
            }
            if (this.xgF != null) {
                f += C6091a.m9575f(4, this.xgF);
            }
            f = (f + C6091a.m9578o(5, this.xgG)) + C6091a.m9572bs(6, this.scene);
            if (this.hlm != null) {
                f += C6091a.m9575f(7, this.hlm);
            }
            if (this.ctj != null) {
                f += C6091a.m9575f(8, this.ctj);
            }
            if (this.xgH != null) {
                f += C6087a.m9557ix(9, this.xgH.computeSize());
            }
            if (this.xgI != null) {
                f += C6087a.m9557ix(10, this.xgI.computeSize());
            }
            f += C6087a.m9552c(11, 8, this.tZG);
            if (this.xgj != null) {
                f += C6091a.m9575f(12, this.xgj);
            }
            f = (((((f + C6091a.m9572bs(13, this.offset)) + (C6091a.m9576fv(14) + 1)) + C6087a.m9552c(15, 8, this.xgK)) + C6091a.m9572bs(16, this.xgL)) + C6091a.m9572bs(17, this.xgM)) + (C6091a.m9576fv(18) + 1);
            if (this.xgN != null) {
                f += C6091a.m9575f(19, this.xgN);
            }
            int bs = (f + C6091a.m9572bs(20, this.xgO)) + (C6091a.m9576fv(21) + 1);
            AppMethodBeat.m2505o(55709);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.tZG.clear();
            this.xgK.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(55709);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            chv chv = (chv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            chw chw;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    chv.xgC = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55709);
                    return 0;
                case 2:
                    chv.xgD = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55709);
                    return 0;
                case 3:
                    chv.xgE = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55709);
                    return 0;
                case 4:
                    chv.xgF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55709);
                    return 0;
                case 5:
                    chv.xgG = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(55709);
                    return 0;
                case 6:
                    chv.scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(55709);
                    return 0;
                case 7:
                    chv.hlm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55709);
                    return 0;
                case 8:
                    chv.ctj = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55709);
                    return 0;
                case 9:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        chw = new chw();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = chw.populateBuilderWithField(c6086a3, chw, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        chv.xgH = chw;
                    }
                    AppMethodBeat.m2505o(55709);
                    return 0;
                case 10:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bzs bzs = new bzs();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bzs.populateBuilderWithField(c6086a3, bzs, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        chv.xgI = bzs;
                    }
                    AppMethodBeat.m2505o(55709);
                    return 0;
                case 11:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C23447tn c23447tn = new C23447tn();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c23447tn.populateBuilderWithField(c6086a3, c23447tn, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        chv.tZG.add(c23447tn);
                    }
                    AppMethodBeat.m2505o(55709);
                    return 0;
                case 12:
                    chv.xgj = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55709);
                    return 0;
                case 13:
                    chv.offset = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(55709);
                    return 0;
                case 14:
                    chv.xgJ = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(55709);
                    return 0;
                case 15:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        chw = new chw();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = chw.populateBuilderWithField(c6086a3, chw, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        chv.xgK.add(chw);
                    }
                    AppMethodBeat.m2505o(55709);
                    return 0;
                case 16:
                    chv.xgL = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(55709);
                    return 0;
                case 17:
                    chv.xgM = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(55709);
                    return 0;
                case 18:
                    chv.eif = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(55709);
                    return 0;
                case 19:
                    chv.xgN = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55709);
                    return 0;
                case 20:
                    chv.xgO = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(55709);
                    return 0;
                case 21:
                    chv.xgP = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(55709);
                    return 0;
                default:
                    AppMethodBeat.m2505o(55709);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(55709);
            return -1;
        }
    }
}
