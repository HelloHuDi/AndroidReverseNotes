package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.blq */
public final class blq extends C1331a {
    public String Name;
    public String PriceType;
    public int Scene;
    public String ThumbUrl;
    public int jBv;
    public int jCt;
    public int wOD;
    public LinkedList<axa> wOE = new LinkedList();
    public int wOF;
    public String wOG;
    public String wOH;
    public int wOI;
    public String wOJ;
    public int wOK;
    public LinkedList<C44188xd> wOL = new LinkedList();
    public String wrm;

    public blq() {
        AppMethodBeat.m2504i(56933);
        AppMethodBeat.m2505o(56933);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56934);
        int bs;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.wOD);
            c6093a.mo13474e(2, 8, this.wOE);
            c6093a.mo13480iz(3, this.jBv);
            c6093a.mo13480iz(4, this.wOF);
            if (this.PriceType != null) {
                c6093a.mo13475e(5, this.PriceType);
            }
            if (this.wrm != null) {
                c6093a.mo13475e(6, this.wrm);
            }
            if (this.wOG != null) {
                c6093a.mo13475e(7, this.wOG);
            }
            if (this.wOH != null) {
                c6093a.mo13475e(8, this.wOH);
            }
            c6093a.mo13480iz(9, this.jCt);
            if (this.Name != null) {
                c6093a.mo13475e(10, this.Name);
            }
            if (this.ThumbUrl != null) {
                c6093a.mo13475e(11, this.ThumbUrl);
            }
            c6093a.mo13480iz(12, this.wOI);
            c6093a.mo13480iz(13, this.Scene);
            if (this.wOJ != null) {
                c6093a.mo13475e(14, this.wOJ);
            }
            c6093a.mo13480iz(15, this.wOK);
            c6093a.mo13474e(16, 8, this.wOL);
            AppMethodBeat.m2505o(56934);
            return 0;
        } else if (i == 1) {
            bs = (((C6091a.m9572bs(1, this.wOD) + 0) + C6087a.m9552c(2, 8, this.wOE)) + C6091a.m9572bs(3, this.jBv)) + C6091a.m9572bs(4, this.wOF);
            if (this.PriceType != null) {
                bs += C6091a.m9575f(5, this.PriceType);
            }
            if (this.wrm != null) {
                bs += C6091a.m9575f(6, this.wrm);
            }
            if (this.wOG != null) {
                bs += C6091a.m9575f(7, this.wOG);
            }
            if (this.wOH != null) {
                bs += C6091a.m9575f(8, this.wOH);
            }
            bs += C6091a.m9572bs(9, this.jCt);
            if (this.Name != null) {
                bs += C6091a.m9575f(10, this.Name);
            }
            if (this.ThumbUrl != null) {
                bs += C6091a.m9575f(11, this.ThumbUrl);
            }
            bs = (bs + C6091a.m9572bs(12, this.wOI)) + C6091a.m9572bs(13, this.Scene);
            if (this.wOJ != null) {
                bs += C6091a.m9575f(14, this.wOJ);
            }
            bs = (bs + C6091a.m9572bs(15, this.wOK)) + C6087a.m9552c(16, 8, this.wOL);
            AppMethodBeat.m2505o(56934);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wOE.clear();
            this.wOL.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56934);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            blq blq = (blq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    blq.wOD = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56934);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        axa axa = new axa();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = axa.populateBuilderWithField(c6086a3, axa, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        blq.wOE.add(axa);
                    }
                    AppMethodBeat.m2505o(56934);
                    return 0;
                case 3:
                    blq.jBv = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56934);
                    return 0;
                case 4:
                    blq.wOF = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56934);
                    return 0;
                case 5:
                    blq.PriceType = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56934);
                    return 0;
                case 6:
                    blq.wrm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56934);
                    return 0;
                case 7:
                    blq.wOG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56934);
                    return 0;
                case 8:
                    blq.wOH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56934);
                    return 0;
                case 9:
                    blq.jCt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56934);
                    return 0;
                case 10:
                    blq.Name = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56934);
                    return 0;
                case 11:
                    blq.ThumbUrl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56934);
                    return 0;
                case 12:
                    blq.wOI = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56934);
                    return 0;
                case 13:
                    blq.Scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56934);
                    return 0;
                case 14:
                    blq.wOJ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56934);
                    return 0;
                case 15:
                    blq.wOK = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56934);
                    return 0;
                case 16:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C44188xd c44188xd = new C44188xd();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c44188xd.populateBuilderWithField(c6086a3, c44188xd, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        blq.wOL.add(c44188xd);
                    }
                    AppMethodBeat.m2505o(56934);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56934);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56934);
            return -1;
        }
    }
}
