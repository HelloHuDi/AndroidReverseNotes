package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bax */
public final class bax extends C1331a {
    public String Desc;
    public int aPA;
    public String csB;
    public String cvZ;
    public int cyN;
    public int eRu;
    public String token;
    public String videoPath;
    public int wEJ;
    public bar wFA;
    public int wFB;
    public LinkedList<bar> wFC = new LinkedList();
    public int wFD;
    public String wFE;
    public String wFF;
    public String wFG;
    public baa wFH;
    public int wFI;
    public String wFc;
    public int wFd;
    public int wFe;
    public int wFm;
    public String wFn;

    public bax() {
        AppMethodBeat.m2504i(94543);
        AppMethodBeat.m2505o(94543);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(94544);
        int bs;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.wFd);
            c6093a.mo13480iz(2, this.wFe);
            c6093a.mo13480iz(3, this.wEJ);
            if (this.wFA != null) {
                c6093a.mo13479iy(4, this.wFA.computeSize());
                this.wFA.writeFields(c6093a);
            }
            c6093a.mo13480iz(5, this.wFB);
            c6093a.mo13474e(6, 8, this.wFC);
            c6093a.mo13480iz(7, this.eRu);
            c6093a.mo13480iz(8, this.wFD);
            if (this.Desc != null) {
                c6093a.mo13475e(9, this.Desc);
            }
            if (this.wFE != null) {
                c6093a.mo13475e(10, this.wFE);
            }
            if (this.token != null) {
                c6093a.mo13475e(11, this.token);
            }
            if (this.wFn != null) {
                c6093a.mo13475e(12, this.wFn);
            }
            c6093a.mo13480iz(13, this.wFm);
            if (this.videoPath != null) {
                c6093a.mo13475e(14, this.videoPath);
            }
            if (this.wFF != null) {
                c6093a.mo13475e(15, this.wFF);
            }
            if (this.wFG != null) {
                c6093a.mo13475e(16, this.wFG);
            }
            if (this.cvZ != null) {
                c6093a.mo13475e(17, this.cvZ);
            }
            if (this.csB != null) {
                c6093a.mo13475e(18, this.csB);
            }
            c6093a.mo13480iz(19, this.aPA);
            c6093a.mo13480iz(20, this.cyN);
            if (this.wFc != null) {
                c6093a.mo13475e(21, this.wFc);
            }
            if (this.wFH != null) {
                c6093a.mo13479iy(22, this.wFH.computeSize());
                this.wFH.writeFields(c6093a);
            }
            c6093a.mo13480iz(23, this.wFI);
            AppMethodBeat.m2505o(94544);
            return 0;
        } else if (i == 1) {
            bs = ((C6091a.m9572bs(1, this.wFd) + 0) + C6091a.m9572bs(2, this.wFe)) + C6091a.m9572bs(3, this.wEJ);
            if (this.wFA != null) {
                bs += C6087a.m9557ix(4, this.wFA.computeSize());
            }
            bs = (((bs + C6091a.m9572bs(5, this.wFB)) + C6087a.m9552c(6, 8, this.wFC)) + C6091a.m9572bs(7, this.eRu)) + C6091a.m9572bs(8, this.wFD);
            if (this.Desc != null) {
                bs += C6091a.m9575f(9, this.Desc);
            }
            if (this.wFE != null) {
                bs += C6091a.m9575f(10, this.wFE);
            }
            if (this.token != null) {
                bs += C6091a.m9575f(11, this.token);
            }
            if (this.wFn != null) {
                bs += C6091a.m9575f(12, this.wFn);
            }
            bs += C6091a.m9572bs(13, this.wFm);
            if (this.videoPath != null) {
                bs += C6091a.m9575f(14, this.videoPath);
            }
            if (this.wFF != null) {
                bs += C6091a.m9575f(15, this.wFF);
            }
            if (this.wFG != null) {
                bs += C6091a.m9575f(16, this.wFG);
            }
            if (this.cvZ != null) {
                bs += C6091a.m9575f(17, this.cvZ);
            }
            if (this.csB != null) {
                bs += C6091a.m9575f(18, this.csB);
            }
            bs = (bs + C6091a.m9572bs(19, this.aPA)) + C6091a.m9572bs(20, this.cyN);
            if (this.wFc != null) {
                bs += C6091a.m9575f(21, this.wFc);
            }
            if (this.wFH != null) {
                bs += C6087a.m9557ix(22, this.wFH.computeSize());
            }
            bs += C6091a.m9572bs(23, this.wFI);
            AppMethodBeat.m2505o(94544);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wFC.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(94544);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bax bax = (bax) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            bar bar;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    bax.wFd = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94544);
                    return 0;
                case 2:
                    bax.wFe = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94544);
                    return 0;
                case 3:
                    bax.wEJ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94544);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bar = new bar();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bar.populateBuilderWithField(c6086a3, bar, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bax.wFA = bar;
                    }
                    AppMethodBeat.m2505o(94544);
                    return 0;
                case 5:
                    bax.wFB = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94544);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bar = new bar();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bar.populateBuilderWithField(c6086a3, bar, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bax.wFC.add(bar);
                    }
                    AppMethodBeat.m2505o(94544);
                    return 0;
                case 7:
                    bax.eRu = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94544);
                    return 0;
                case 8:
                    bax.wFD = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94544);
                    return 0;
                case 9:
                    bax.Desc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94544);
                    return 0;
                case 10:
                    bax.wFE = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94544);
                    return 0;
                case 11:
                    bax.token = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94544);
                    return 0;
                case 12:
                    bax.wFn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94544);
                    return 0;
                case 13:
                    bax.wFm = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94544);
                    return 0;
                case 14:
                    bax.videoPath = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94544);
                    return 0;
                case 15:
                    bax.wFF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94544);
                    return 0;
                case 16:
                    bax.wFG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94544);
                    return 0;
                case 17:
                    bax.cvZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94544);
                    return 0;
                case 18:
                    bax.csB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94544);
                    return 0;
                case 19:
                    bax.aPA = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94544);
                    return 0;
                case 20:
                    bax.cyN = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94544);
                    return 0;
                case 21:
                    bax.wFc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94544);
                    return 0;
                case 22:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        baa baa = new baa();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = baa.populateBuilderWithField(c6086a3, baa, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bax.wFH = baa;
                    }
                    AppMethodBeat.m2505o(94544);
                    return 0;
                case 23:
                    bax.wFI = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94544);
                    return 0;
                default:
                    AppMethodBeat.m2505o(94544);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(94544);
            return -1;
        }
    }
}
