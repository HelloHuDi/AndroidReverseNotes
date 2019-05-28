package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.ad */
public final class C12110ad extends C1331a {
    public String fKh;
    public String mZL;
    public int mZN;
    public int mZQ;
    public String mZj;
    public C39192ca naA;
    public C20955dn naB;
    public C20951cj naC;
    public C28190ck naD;
    public C28183aw naE;
    public C12117cs naF;
    public C39186as naG;
    public C43172o naH;
    public C20954cn naI;
    public C34274cy naJ;
    public C43171n naK;
    public C43171n naL;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(111567);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.mZQ);
            c6093a.mo13480iz(2, this.mZN);
            if (this.mZL != null) {
                c6093a.mo13475e(3, this.mZL);
            }
            if (this.fKh != null) {
                c6093a.mo13475e(4, this.fKh);
            }
            if (this.mZj != null) {
                c6093a.mo13475e(17, this.mZj);
            }
            if (this.naA != null) {
                c6093a.mo13479iy(5, this.naA.computeSize());
                this.naA.writeFields(c6093a);
            }
            if (this.naB != null) {
                c6093a.mo13479iy(6, this.naB.computeSize());
                this.naB.writeFields(c6093a);
            }
            if (this.naC != null) {
                c6093a.mo13479iy(7, this.naC.computeSize());
                this.naC.writeFields(c6093a);
            }
            if (this.naD != null) {
                c6093a.mo13479iy(8, this.naD.computeSize());
                this.naD.writeFields(c6093a);
            }
            if (this.naE != null) {
                c6093a.mo13479iy(9, this.naE.computeSize());
                this.naE.writeFields(c6093a);
            }
            if (this.naF != null) {
                c6093a.mo13479iy(10, this.naF.computeSize());
                this.naF.writeFields(c6093a);
            }
            if (this.naG != null) {
                c6093a.mo13479iy(11, this.naG.computeSize());
                this.naG.writeFields(c6093a);
            }
            if (this.naH != null) {
                c6093a.mo13479iy(12, this.naH.computeSize());
                this.naH.writeFields(c6093a);
            }
            if (this.naI != null) {
                c6093a.mo13479iy(13, this.naI.computeSize());
                this.naI.writeFields(c6093a);
            }
            if (this.naJ != null) {
                c6093a.mo13479iy(14, this.naJ.computeSize());
                this.naJ.writeFields(c6093a);
            }
            if (this.naK != null) {
                c6093a.mo13479iy(15, this.naK.computeSize());
                this.naK.writeFields(c6093a);
            }
            if (this.naL != null) {
                c6093a.mo13479iy(16, this.naL.computeSize());
                this.naL.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(111567);
            return 0;
        } else if (i == 1) {
            bs = (C6091a.m9572bs(1, this.mZQ) + 0) + C6091a.m9572bs(2, this.mZN);
            if (this.mZL != null) {
                bs += C6091a.m9575f(3, this.mZL);
            }
            if (this.fKh != null) {
                bs += C6091a.m9575f(4, this.fKh);
            }
            if (this.mZj != null) {
                bs += C6091a.m9575f(17, this.mZj);
            }
            if (this.naA != null) {
                bs += C6087a.m9557ix(5, this.naA.computeSize());
            }
            if (this.naB != null) {
                bs += C6087a.m9557ix(6, this.naB.computeSize());
            }
            if (this.naC != null) {
                bs += C6087a.m9557ix(7, this.naC.computeSize());
            }
            if (this.naD != null) {
                bs += C6087a.m9557ix(8, this.naD.computeSize());
            }
            if (this.naE != null) {
                bs += C6087a.m9557ix(9, this.naE.computeSize());
            }
            if (this.naF != null) {
                bs += C6087a.m9557ix(10, this.naF.computeSize());
            }
            if (this.naG != null) {
                bs += C6087a.m9557ix(11, this.naG.computeSize());
            }
            if (this.naH != null) {
                bs += C6087a.m9557ix(12, this.naH.computeSize());
            }
            if (this.naI != null) {
                bs += C6087a.m9557ix(13, this.naI.computeSize());
            }
            if (this.naJ != null) {
                bs += C6087a.m9557ix(14, this.naJ.computeSize());
            }
            if (this.naK != null) {
                bs += C6087a.m9557ix(15, this.naK.computeSize());
            }
            if (this.naL != null) {
                bs += C6087a.m9557ix(16, this.naL.computeSize());
            }
            AppMethodBeat.m2505o(111567);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(111567);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C12110ad c12110ad = (C12110ad) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            C43171n c43171n;
            switch (intValue) {
                case 1:
                    c12110ad.mZQ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(111567);
                    return 0;
                case 2:
                    c12110ad.mZN = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(111567);
                    return 0;
                case 3:
                    c12110ad.mZL = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111567);
                    return 0;
                case 4:
                    c12110ad.fKh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111567);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C39192ca c39192ca = new C39192ca();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c39192ca.populateBuilderWithField(c6086a3, c39192ca, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c12110ad.naA = c39192ca;
                    }
                    AppMethodBeat.m2505o(111567);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C20955dn c20955dn = new C20955dn();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c20955dn.populateBuilderWithField(c6086a3, c20955dn, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c12110ad.naB = c20955dn;
                    }
                    AppMethodBeat.m2505o(111567);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C20951cj c20951cj = new C20951cj();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c20951cj.populateBuilderWithField(c6086a3, c20951cj, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c12110ad.naC = c20951cj;
                    }
                    AppMethodBeat.m2505o(111567);
                    return 0;
                case 8:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C28190ck c28190ck = new C28190ck();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c28190ck.populateBuilderWithField(c6086a3, c28190ck, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c12110ad.naD = c28190ck;
                    }
                    AppMethodBeat.m2505o(111567);
                    return 0;
                case 9:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C28183aw c28183aw = new C28183aw();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c28183aw.populateBuilderWithField(c6086a3, c28183aw, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c12110ad.naE = c28183aw;
                    }
                    AppMethodBeat.m2505o(111567);
                    return 0;
                case 10:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C12117cs c12117cs = new C12117cs();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c12117cs.populateBuilderWithField(c6086a3, c12117cs, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c12110ad.naF = c12117cs;
                    }
                    AppMethodBeat.m2505o(111567);
                    return 0;
                case 11:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C39186as c39186as = new C39186as();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c39186as.populateBuilderWithField(c6086a3, c39186as, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c12110ad.naG = c39186as;
                    }
                    AppMethodBeat.m2505o(111567);
                    return 0;
                case 12:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C43172o c43172o = new C43172o();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c43172o.populateBuilderWithField(c6086a3, c43172o, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c12110ad.naH = c43172o;
                    }
                    AppMethodBeat.m2505o(111567);
                    return 0;
                case 13:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C20954cn c20954cn = new C20954cn();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c20954cn.populateBuilderWithField(c6086a3, c20954cn, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c12110ad.naI = c20954cn;
                    }
                    AppMethodBeat.m2505o(111567);
                    return 0;
                case 14:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C34274cy c34274cy = new C34274cy();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c34274cy.populateBuilderWithField(c6086a3, c34274cy, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c12110ad.naJ = c34274cy;
                    }
                    AppMethodBeat.m2505o(111567);
                    return 0;
                case 15:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c43171n = new C43171n();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c43171n.populateBuilderWithField(c6086a3, c43171n, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c12110ad.naK = c43171n;
                    }
                    AppMethodBeat.m2505o(111567);
                    return 0;
                case 16:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c43171n = new C43171n();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c43171n.populateBuilderWithField(c6086a3, c43171n, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c12110ad.naL = c43171n;
                    }
                    AppMethodBeat.m2505o(111567);
                    return 0;
                case 17:
                    c12110ad.mZj = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111567);
                    return 0;
                default:
                    AppMethodBeat.m2505o(111567);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(111567);
            return -1;
        }
    }
}
