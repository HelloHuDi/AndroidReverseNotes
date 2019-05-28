package com.tencent.p177mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p304e.C2275g;
import com.tencent.view.C31128d;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.luckymoney.model.k */
public final class C12428k extends C1331a {
    public int cRT;
    public int cRU;
    public int cRV;
    public long cSh;
    public int kCd;
    public String nSX;
    public String nSd;
    public int nUh;
    public String nUi;
    public String nUj;
    public String nUk;
    public String nWO;
    public String nWP;
    public String nWQ;
    public String nWR;
    public String nWS;
    public String nWT;
    public long nWU;
    public long nWV;
    public long nWW;
    public String nWX;
    public int nWY;
    public int nWZ;
    public int nXa;
    public String nXb;
    public int nXc;
    public C46060e nXd;
    public LinkedList<C43255as> nXe = new LinkedList();
    public C43255as nXf;
    public String nXg;
    public String nXh;
    public int nXi;
    public LinkedList<C39323w> nXj = new LinkedList();
    public String nXk;
    public String nXl;
    public int nXm;
    public String nXn;
    public String nXo;
    public int resourceId;

    public C12428k() {
        AppMethodBeat.m2504i(56610);
        AppMethodBeat.m2505o(56610);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56611);
        int bs;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.cRT);
            c6093a.mo13480iz(2, this.cRU);
            if (this.nWO != null) {
                c6093a.mo13475e(3, this.nWO);
            }
            if (this.nWP != null) {
                c6093a.mo13475e(4, this.nWP);
            }
            if (this.nSd != null) {
                c6093a.mo13475e(5, this.nSd);
            }
            if (this.nWQ != null) {
                c6093a.mo13475e(6, this.nWQ);
            }
            if (this.nWR != null) {
                c6093a.mo13475e(7, this.nWR);
            }
            if (this.nSX != null) {
                c6093a.mo13475e(8, this.nSX);
            }
            if (this.nWS != null) {
                c6093a.mo13475e(9, this.nWS);
            }
            if (this.nWT != null) {
                c6093a.mo13475e(10, this.nWT);
            }
            c6093a.mo13472ai(11, this.cSh);
            c6093a.mo13472ai(12, this.nWU);
            c6093a.mo13472ai(13, this.nWV);
            c6093a.mo13480iz(14, this.kCd);
            c6093a.mo13472ai(15, this.nWW);
            if (this.nWX != null) {
                c6093a.mo13475e(16, this.nWX);
            }
            c6093a.mo13480iz(17, this.nWY);
            c6093a.mo13480iz(18, this.nWZ);
            c6093a.mo13480iz(19, this.nXa);
            if (this.nXb != null) {
                c6093a.mo13475e(20, this.nXb);
            }
            c6093a.mo13480iz(21, this.cRV);
            c6093a.mo13480iz(22, this.nXc);
            if (this.nXd != null) {
                c6093a.mo13479iy(23, this.nXd.computeSize());
                this.nXd.writeFields(c6093a);
            }
            c6093a.mo13480iz(24, this.nUh);
            if (this.nUj != null) {
                c6093a.mo13475e(25, this.nUj);
            }
            c6093a.mo13474e(26, 8, this.nXe);
            if (this.nXf != null) {
                c6093a.mo13479iy(27, this.nXf.computeSize());
                this.nXf.writeFields(c6093a);
            }
            if (this.nXg != null) {
                c6093a.mo13475e(28, this.nXg);
            }
            if (this.nXh != null) {
                c6093a.mo13475e(29, this.nXh);
            }
            c6093a.mo13480iz(30, this.nXi);
            c6093a.mo13480iz(31, this.resourceId);
            if (this.nUk != null) {
                c6093a.mo13475e(32, this.nUk);
            }
            c6093a.mo13474e(33, 8, this.nXj);
            if (this.nUi != null) {
                c6093a.mo13475e(34, this.nUi);
            }
            if (this.nXk != null) {
                c6093a.mo13475e(35, this.nXk);
            }
            if (this.nXl != null) {
                c6093a.mo13475e(36, this.nXl);
            }
            c6093a.mo13480iz(37, this.nXm);
            if (this.nXn != null) {
                c6093a.mo13475e(38, this.nXn);
            }
            if (this.nXo != null) {
                c6093a.mo13475e(39, this.nXo);
            }
            AppMethodBeat.m2505o(56611);
            return 0;
        } else if (i == 1) {
            bs = (C6091a.m9572bs(1, this.cRT) + 0) + C6091a.m9572bs(2, this.cRU);
            if (this.nWO != null) {
                bs += C6091a.m9575f(3, this.nWO);
            }
            if (this.nWP != null) {
                bs += C6091a.m9575f(4, this.nWP);
            }
            if (this.nSd != null) {
                bs += C6091a.m9575f(5, this.nSd);
            }
            if (this.nWQ != null) {
                bs += C6091a.m9575f(6, this.nWQ);
            }
            if (this.nWR != null) {
                bs += C6091a.m9575f(7, this.nWR);
            }
            if (this.nSX != null) {
                bs += C6091a.m9575f(8, this.nSX);
            }
            if (this.nWS != null) {
                bs += C6091a.m9575f(9, this.nWS);
            }
            if (this.nWT != null) {
                bs += C6091a.m9575f(10, this.nWT);
            }
            bs = ((((bs + C6091a.m9578o(11, this.cSh)) + C6091a.m9578o(12, this.nWU)) + C6091a.m9578o(13, this.nWV)) + C6091a.m9572bs(14, this.kCd)) + C6091a.m9578o(15, this.nWW);
            if (this.nWX != null) {
                bs += C6091a.m9575f(16, this.nWX);
            }
            bs = ((bs + C6091a.m9572bs(17, this.nWY)) + C6091a.m9572bs(18, this.nWZ)) + C6091a.m9572bs(19, this.nXa);
            if (this.nXb != null) {
                bs += C6091a.m9575f(20, this.nXb);
            }
            bs = (bs + C6091a.m9572bs(21, this.cRV)) + C6091a.m9572bs(22, this.nXc);
            if (this.nXd != null) {
                bs += C6087a.m9557ix(23, this.nXd.computeSize());
            }
            bs += C6091a.m9572bs(24, this.nUh);
            if (this.nUj != null) {
                bs += C6091a.m9575f(25, this.nUj);
            }
            bs += C6087a.m9552c(26, 8, this.nXe);
            if (this.nXf != null) {
                bs += C6087a.m9557ix(27, this.nXf.computeSize());
            }
            if (this.nXg != null) {
                bs += C6091a.m9575f(28, this.nXg);
            }
            if (this.nXh != null) {
                bs += C6091a.m9575f(29, this.nXh);
            }
            bs = (bs + C6091a.m9572bs(30, this.nXi)) + C6091a.m9572bs(31, this.resourceId);
            if (this.nUk != null) {
                bs += C6091a.m9575f(32, this.nUk);
            }
            bs += C6087a.m9552c(33, 8, this.nXj);
            if (this.nUi != null) {
                bs += C6091a.m9575f(34, this.nUi);
            }
            if (this.nXk != null) {
                bs += C6091a.m9575f(35, this.nXk);
            }
            if (this.nXl != null) {
                bs += C6091a.m9575f(36, this.nXl);
            }
            bs += C6091a.m9572bs(37, this.nXm);
            if (this.nXn != null) {
                bs += C6091a.m9575f(38, this.nXn);
            }
            if (this.nXo != null) {
                bs += C6091a.m9575f(39, this.nXo);
            }
            AppMethodBeat.m2505o(56611);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.nXe.clear();
            this.nXj.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56611);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C12428k c12428k = (C12428k) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            C43255as c43255as;
            switch (intValue) {
                case 1:
                    c12428k.cRT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56611);
                    return 0;
                case 2:
                    c12428k.cRU = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56611);
                    return 0;
                case 3:
                    c12428k.nWO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56611);
                    return 0;
                case 4:
                    c12428k.nWP = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56611);
                    return 0;
                case 5:
                    c12428k.nSd = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56611);
                    return 0;
                case 6:
                    c12428k.nWQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56611);
                    return 0;
                case 7:
                    c12428k.nWR = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56611);
                    return 0;
                case 8:
                    c12428k.nSX = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56611);
                    return 0;
                case 9:
                    c12428k.nWS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56611);
                    return 0;
                case 10:
                    c12428k.nWT = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56611);
                    return 0;
                case 11:
                    c12428k.cSh = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56611);
                    return 0;
                case 12:
                    c12428k.nWU = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56611);
                    return 0;
                case 13:
                    c12428k.nWV = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56611);
                    return 0;
                case 14:
                    c12428k.kCd = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56611);
                    return 0;
                case 15:
                    c12428k.nWW = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56611);
                    return 0;
                case 16:
                    c12428k.nWX = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56611);
                    return 0;
                case 17:
                    c12428k.nWY = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56611);
                    return 0;
                case 18:
                    c12428k.nWZ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56611);
                    return 0;
                case 19:
                    c12428k.nXa = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56611);
                    return 0;
                case 20:
                    c12428k.nXb = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56611);
                    return 0;
                case 21:
                    c12428k.cRV = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56611);
                    return 0;
                case 22:
                    c12428k.nXc = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56611);
                    return 0;
                case 23:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C46060e c46060e = new C46060e();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c46060e.populateBuilderWithField(c6086a3, c46060e, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c12428k.nXd = c46060e;
                    }
                    AppMethodBeat.m2505o(56611);
                    return 0;
                case 24:
                    c12428k.nUh = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56611);
                    return 0;
                case 25:
                    c12428k.nUj = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56611);
                    return 0;
                case 26:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c43255as = new C43255as();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c43255as.populateBuilderWithField(c6086a3, c43255as, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c12428k.nXe.add(c43255as);
                    }
                    AppMethodBeat.m2505o(56611);
                    return 0;
                case 27:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c43255as = new C43255as();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c43255as.populateBuilderWithField(c6086a3, c43255as, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c12428k.nXf = c43255as;
                    }
                    AppMethodBeat.m2505o(56611);
                    return 0;
                case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    c12428k.nXg = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56611);
                    return 0;
                case 29:
                    c12428k.nXh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56611);
                    return 0;
                case 30:
                    c12428k.nXi = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56611);
                    return 0;
                case 31:
                    c12428k.resourceId = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56611);
                    return 0;
                case 32:
                    c12428k.nUk = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56611);
                    return 0;
                case 33:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C39323w c39323w = new C39323w();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c39323w.populateBuilderWithField(c6086a3, c39323w, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c12428k.nXj.add(c39323w);
                    }
                    AppMethodBeat.m2505o(56611);
                    return 0;
                case 34:
                    c12428k.nUi = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56611);
                    return 0;
                case 35:
                    c12428k.nXk = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56611);
                    return 0;
                case 36:
                    c12428k.nXl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56611);
                    return 0;
                case C2275g.CTRL_INDEX /*37*/:
                    c12428k.nXm = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56611);
                    return 0;
                case 38:
                    c12428k.nXn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56611);
                    return 0;
                case 39:
                    c12428k.nXo = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56611);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56611);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56611);
            return -1;
        }
    }
}
