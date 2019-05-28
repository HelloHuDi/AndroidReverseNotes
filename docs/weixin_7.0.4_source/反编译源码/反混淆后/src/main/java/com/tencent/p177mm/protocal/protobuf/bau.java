package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.view.C31128d;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bau */
public final class bau extends C1331a {
    public String Desc;
    /* renamed from: Id */
    public String f17915Id;
    public String Title;
    public String Url;
    public int cNE;
    public int cuu;
    public String cvZ;
    public int jCt;
    public boolean qFG;
    public int rEd;
    public String rik;
    public int wEG;
    public String wEH;
    public int wEI;
    public int wEJ;
    public baw wEK;
    public String wEL;
    public int wEM;
    public int wEN;
    public String wEO;
    public String wEP;
    public String wEQ;
    public String wER;
    public String wES;
    public int wET;
    public long wEU;
    public String wEV;
    public String wEW;
    public int wEX;
    public String wEY;
    public String wEZ;
    public int wFa;
    public String wFb;
    public String wFc;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(94539);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.f17915Id != null) {
                c6093a.mo13475e(1, this.f17915Id);
            }
            c6093a.mo13480iz(2, this.jCt);
            if (this.Desc != null) {
                c6093a.mo13475e(3, this.Desc);
            }
            if (this.Url != null) {
                c6093a.mo13475e(4, this.Url);
            }
            c6093a.mo13480iz(5, this.wEG);
            if (this.wEH != null) {
                c6093a.mo13475e(6, this.wEH);
            }
            c6093a.mo13480iz(7, this.wEI);
            c6093a.mo13480iz(8, this.wEJ);
            if (this.Title != null) {
                c6093a.mo13475e(9, this.Title);
            }
            if (this.wEK != null) {
                c6093a.mo13479iy(10, this.wEK.computeSize());
                this.wEK.writeFields(c6093a);
            }
            if (this.wEL != null) {
                c6093a.mo13475e(11, this.wEL);
            }
            c6093a.mo13480iz(12, this.wEM);
            c6093a.mo13480iz(13, this.cNE);
            c6093a.mo13480iz(14, this.wEN);
            if (this.rik != null) {
                c6093a.mo13475e(15, this.rik);
            }
            c6093a.mo13480iz(16, this.cuu);
            if (this.cvZ != null) {
                c6093a.mo13475e(17, this.cvZ);
            }
            if (this.wEO != null) {
                c6093a.mo13475e(18, this.wEO);
            }
            if (this.wEP != null) {
                c6093a.mo13475e(19, this.wEP);
            }
            if (this.wEQ != null) {
                c6093a.mo13475e(20, this.wEQ);
            }
            c6093a.mo13480iz(21, this.rEd);
            if (this.wER != null) {
                c6093a.mo13475e(22, this.wER);
            }
            if (this.wES != null) {
                c6093a.mo13475e(23, this.wES);
            }
            c6093a.mo13480iz(24, this.wET);
            c6093a.mo13472ai(25, this.wEU);
            if (this.wEV != null) {
                c6093a.mo13475e(26, this.wEV);
            }
            if (this.wEW != null) {
                c6093a.mo13475e(27, this.wEW);
            }
            c6093a.mo13480iz(28, this.wEX);
            if (this.wEY != null) {
                c6093a.mo13475e(29, this.wEY);
            }
            if (this.wEZ != null) {
                c6093a.mo13475e(30, this.wEZ);
            }
            c6093a.mo13480iz(31, this.wFa);
            if (this.wFb != null) {
                c6093a.mo13475e(32, this.wFb);
            }
            if (this.wFc != null) {
                c6093a.mo13475e(33, this.wFc);
            }
            c6093a.mo13471aO(34, this.qFG);
            AppMethodBeat.m2505o(94539);
            return 0;
        } else if (i == 1) {
            if (this.f17915Id != null) {
                f = C6091a.m9575f(1, this.f17915Id) + 0;
            } else {
                f = 0;
            }
            f += C6091a.m9572bs(2, this.jCt);
            if (this.Desc != null) {
                f += C6091a.m9575f(3, this.Desc);
            }
            if (this.Url != null) {
                f += C6091a.m9575f(4, this.Url);
            }
            f += C6091a.m9572bs(5, this.wEG);
            if (this.wEH != null) {
                f += C6091a.m9575f(6, this.wEH);
            }
            f = (f + C6091a.m9572bs(7, this.wEI)) + C6091a.m9572bs(8, this.wEJ);
            if (this.Title != null) {
                f += C6091a.m9575f(9, this.Title);
            }
            if (this.wEK != null) {
                f += C6087a.m9557ix(10, this.wEK.computeSize());
            }
            if (this.wEL != null) {
                f += C6091a.m9575f(11, this.wEL);
            }
            f = ((f + C6091a.m9572bs(12, this.wEM)) + C6091a.m9572bs(13, this.cNE)) + C6091a.m9572bs(14, this.wEN);
            if (this.rik != null) {
                f += C6091a.m9575f(15, this.rik);
            }
            f += C6091a.m9572bs(16, this.cuu);
            if (this.cvZ != null) {
                f += C6091a.m9575f(17, this.cvZ);
            }
            if (this.wEO != null) {
                f += C6091a.m9575f(18, this.wEO);
            }
            if (this.wEP != null) {
                f += C6091a.m9575f(19, this.wEP);
            }
            if (this.wEQ != null) {
                f += C6091a.m9575f(20, this.wEQ);
            }
            f += C6091a.m9572bs(21, this.rEd);
            if (this.wER != null) {
                f += C6091a.m9575f(22, this.wER);
            }
            if (this.wES != null) {
                f += C6091a.m9575f(23, this.wES);
            }
            f = (f + C6091a.m9572bs(24, this.wET)) + C6091a.m9578o(25, this.wEU);
            if (this.wEV != null) {
                f += C6091a.m9575f(26, this.wEV);
            }
            if (this.wEW != null) {
                f += C6091a.m9575f(27, this.wEW);
            }
            f += C6091a.m9572bs(28, this.wEX);
            if (this.wEY != null) {
                f += C6091a.m9575f(29, this.wEY);
            }
            if (this.wEZ != null) {
                f += C6091a.m9575f(30, this.wEZ);
            }
            f += C6091a.m9572bs(31, this.wFa);
            if (this.wFb != null) {
                f += C6091a.m9575f(32, this.wFb);
            }
            if (this.wFc != null) {
                f += C6091a.m9575f(33, this.wFc);
            }
            int fv = f + (C6091a.m9576fv(34) + 1);
            AppMethodBeat.m2505o(94539);
            return fv;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(94539);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bau bau = (bau) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bau.f17915Id = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94539);
                    return 0;
                case 2:
                    bau.jCt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94539);
                    return 0;
                case 3:
                    bau.Desc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94539);
                    return 0;
                case 4:
                    bau.Url = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94539);
                    return 0;
                case 5:
                    bau.wEG = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94539);
                    return 0;
                case 6:
                    bau.wEH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94539);
                    return 0;
                case 7:
                    bau.wEI = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94539);
                    return 0;
                case 8:
                    bau.wEJ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94539);
                    return 0;
                case 9:
                    bau.Title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94539);
                    return 0;
                case 10:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        baw baw = new baw();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = baw.populateBuilderWithField(c6086a3, baw, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bau.wEK = baw;
                    }
                    AppMethodBeat.m2505o(94539);
                    return 0;
                case 11:
                    bau.wEL = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94539);
                    return 0;
                case 12:
                    bau.wEM = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94539);
                    return 0;
                case 13:
                    bau.cNE = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94539);
                    return 0;
                case 14:
                    bau.wEN = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94539);
                    return 0;
                case 15:
                    bau.rik = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94539);
                    return 0;
                case 16:
                    bau.cuu = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94539);
                    return 0;
                case 17:
                    bau.cvZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94539);
                    return 0;
                case 18:
                    bau.wEO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94539);
                    return 0;
                case 19:
                    bau.wEP = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94539);
                    return 0;
                case 20:
                    bau.wEQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94539);
                    return 0;
                case 21:
                    bau.rEd = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94539);
                    return 0;
                case 22:
                    bau.wER = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94539);
                    return 0;
                case 23:
                    bau.wES = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94539);
                    return 0;
                case 24:
                    bau.wET = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94539);
                    return 0;
                case 25:
                    bau.wEU = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(94539);
                    return 0;
                case 26:
                    bau.wEV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94539);
                    return 0;
                case 27:
                    bau.wEW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94539);
                    return 0;
                case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    bau.wEX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94539);
                    return 0;
                case 29:
                    bau.wEY = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94539);
                    return 0;
                case 30:
                    bau.wEZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94539);
                    return 0;
                case 31:
                    bau.wFa = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94539);
                    return 0;
                case 32:
                    bau.wFb = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94539);
                    return 0;
                case 33:
                    bau.wFc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94539);
                    return 0;
                case 34:
                    bau.qFG = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(94539);
                    return 0;
                default:
                    AppMethodBeat.m2505o(94539);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(94539);
            return -1;
        }
    }
}
