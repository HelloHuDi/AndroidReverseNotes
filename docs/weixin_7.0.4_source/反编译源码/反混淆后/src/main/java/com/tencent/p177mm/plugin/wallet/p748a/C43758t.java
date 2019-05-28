package com.tencent.p177mm.plugin.wallet.p748a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.wallet.a.t */
public final class C43758t extends C1331a {
    public String pcj;
    public String tmO;
    public String tmP;
    public String tmQ;
    public int tnJ;
    public int tnK;
    public long tnL;
    public String tnM;
    public String tnN;
    public String tnO;
    public double tnP;
    public double tnQ;
    public int tnR;
    public String tnS;
    public String tnT;
    public LinkedList<C1332b> tnU = new LinkedList();

    public C43758t() {
        AppMethodBeat.m2504i(56661);
        AppMethodBeat.m2505o(56661);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56662);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.tnJ);
            c6093a.mo13480iz(2, this.tnK);
            c6093a.mo13472ai(3, this.tnL);
            if (this.tnM != null) {
                c6093a.mo13475e(4, this.tnM);
            }
            if (this.tmO != null) {
                c6093a.mo13475e(5, this.tmO);
            }
            if (this.tnN != null) {
                c6093a.mo13475e(6, this.tnN);
            }
            if (this.tnO != null) {
                c6093a.mo13475e(7, this.tnO);
            }
            if (this.tmP != null) {
                c6093a.mo13475e(8, this.tmP);
            }
            if (this.tmQ != null) {
                c6093a.mo13475e(9, this.tmQ);
            }
            c6093a.mo13476f(10, this.tnP);
            c6093a.mo13476f(11, this.tnQ);
            c6093a.mo13480iz(12, this.tnR);
            if (this.tnS != null) {
                c6093a.mo13475e(13, this.tnS);
            }
            if (this.pcj != null) {
                c6093a.mo13475e(14, this.pcj);
            }
            if (this.tnT != null) {
                c6093a.mo13475e(16, this.tnT);
            }
            c6093a.mo13474e(17, 6, this.tnU);
            AppMethodBeat.m2505o(56662);
            return 0;
        } else if (i == 1) {
            bs = ((C6091a.m9572bs(1, this.tnJ) + 0) + C6091a.m9572bs(2, this.tnK)) + C6091a.m9578o(3, this.tnL);
            if (this.tnM != null) {
                bs += C6091a.m9575f(4, this.tnM);
            }
            if (this.tmO != null) {
                bs += C6091a.m9575f(5, this.tmO);
            }
            if (this.tnN != null) {
                bs += C6091a.m9575f(6, this.tnN);
            }
            if (this.tnO != null) {
                bs += C6091a.m9575f(7, this.tnO);
            }
            if (this.tmP != null) {
                bs += C6091a.m9575f(8, this.tmP);
            }
            if (this.tmQ != null) {
                bs += C6091a.m9575f(9, this.tmQ);
            }
            bs = ((bs + (C6091a.m9576fv(10) + 8)) + (C6091a.m9576fv(11) + 8)) + C6091a.m9572bs(12, this.tnR);
            if (this.tnS != null) {
                bs += C6091a.m9575f(13, this.tnS);
            }
            if (this.pcj != null) {
                bs += C6091a.m9575f(14, this.pcj);
            }
            if (this.tnT != null) {
                bs += C6091a.m9575f(16, this.tnT);
            }
            bs += C6087a.m9552c(17, 6, this.tnU);
            AppMethodBeat.m2505o(56662);
            return bs;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.tnU.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56662);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C43758t c43758t = (C43758t) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c43758t.tnJ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56662);
                    return 0;
                case 2:
                    c43758t.tnK = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56662);
                    return 0;
                case 3:
                    c43758t.tnL = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56662);
                    return 0;
                case 4:
                    c43758t.tnM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56662);
                    return 0;
                case 5:
                    c43758t.tmO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56662);
                    return 0;
                case 6:
                    c43758t.tnN = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56662);
                    return 0;
                case 7:
                    c43758t.tnO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56662);
                    return 0;
                case 8:
                    c43758t.tmP = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56662);
                    return 0;
                case 9:
                    c43758t.tmQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56662);
                    return 0;
                case 10:
                    c43758t.tnP = Double.longBitsToDouble(c6086a2.BTU.eib());
                    AppMethodBeat.m2505o(56662);
                    return 0;
                case 11:
                    c43758t.tnQ = Double.longBitsToDouble(c6086a2.BTU.eib());
                    AppMethodBeat.m2505o(56662);
                    return 0;
                case 12:
                    c43758t.tnR = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56662);
                    return 0;
                case 13:
                    c43758t.tnS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56662);
                    return 0;
                case 14:
                    c43758t.pcj = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56662);
                    return 0;
                case 16:
                    c43758t.tnT = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56662);
                    return 0;
                case 17:
                    c43758t.tnU.add(c6086a2.BTU.emu());
                    AppMethodBeat.m2505o(56662);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56662);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56662);
            return -1;
        }
    }
}
