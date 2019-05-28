package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cnv */
public final class cnv extends C1331a {
    public int type;
    public auj vQK;
    public C46566ms vQN;
    public bln wKU;
    public C23370ba wVH;
    public bto wYU;
    public cgv wbo;
    public cfy xlc;
    public bzy xld;
    public bdn xle;
    public bdw xlf;
    public C23420ob xlg;
    public C15387ui xlh;
    public C7265hg xli;
    public ayp xlj;
    public asd xlk;
    public bht xll;
    public avd xlm;
    public ave xln;
    public cgd xlo;
    public C46588tz xlp;
    public C40547mt xlq;
    public cnx xlr;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48986);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.type);
            if (this.wbo != null) {
                c6093a.mo13479iy(2, this.wbo.computeSize());
                this.wbo.writeFields(c6093a);
            }
            if (this.wYU != null) {
                c6093a.mo13479iy(3, this.wYU.computeSize());
                this.wYU.writeFields(c6093a);
            }
            if (this.xlc != null) {
                c6093a.mo13479iy(4, this.xlc.computeSize());
                this.xlc.writeFields(c6093a);
            }
            if (this.xld != null) {
                c6093a.mo13479iy(5, this.xld.computeSize());
                this.xld.writeFields(c6093a);
            }
            if (this.xle != null) {
                c6093a.mo13479iy(6, this.xle.computeSize());
                this.xle.writeFields(c6093a);
            }
            if (this.xlf != null) {
                c6093a.mo13479iy(7, this.xlf.computeSize());
                this.xlf.writeFields(c6093a);
            }
            if (this.xlg != null) {
                c6093a.mo13479iy(8, this.xlg.computeSize());
                this.xlg.writeFields(c6093a);
            }
            if (this.xlh != null) {
                c6093a.mo13479iy(9, this.xlh.computeSize());
                this.xlh.writeFields(c6093a);
            }
            if (this.xli != null) {
                c6093a.mo13479iy(10, this.xli.computeSize());
                this.xli.writeFields(c6093a);
            }
            if (this.vQN != null) {
                c6093a.mo13479iy(11, this.vQN.computeSize());
                this.vQN.writeFields(c6093a);
            }
            if (this.vQK != null) {
                c6093a.mo13479iy(12, this.vQK.computeSize());
                this.vQK.writeFields(c6093a);
            }
            if (this.xlj != null) {
                c6093a.mo13479iy(13, this.xlj.computeSize());
                this.xlj.writeFields(c6093a);
            }
            if (this.xlk != null) {
                c6093a.mo13479iy(14, this.xlk.computeSize());
                this.xlk.writeFields(c6093a);
            }
            if (this.wKU != null) {
                c6093a.mo13479iy(15, this.wKU.computeSize());
                this.wKU.writeFields(c6093a);
            }
            if (this.xll != null) {
                c6093a.mo13479iy(16, this.xll.computeSize());
                this.xll.writeFields(c6093a);
            }
            if (this.xlm != null) {
                c6093a.mo13479iy(17, this.xlm.computeSize());
                this.xlm.writeFields(c6093a);
            }
            if (this.xln != null) {
                c6093a.mo13479iy(18, this.xln.computeSize());
                this.xln.writeFields(c6093a);
            }
            if (this.xlo != null) {
                c6093a.mo13479iy(19, this.xlo.computeSize());
                this.xlo.writeFields(c6093a);
            }
            if (this.xlp != null) {
                c6093a.mo13479iy(20, this.xlp.computeSize());
                this.xlp.writeFields(c6093a);
            }
            if (this.xlq != null) {
                c6093a.mo13479iy(21, this.xlq.computeSize());
                this.xlq.writeFields(c6093a);
            }
            if (this.wVH != null) {
                c6093a.mo13479iy(22, this.wVH.computeSize());
                this.wVH.writeFields(c6093a);
            }
            if (this.xlr != null) {
                c6093a.mo13479iy(23, this.xlr.computeSize());
                this.xlr.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(48986);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.type) + 0;
            if (this.wbo != null) {
                bs += C6087a.m9557ix(2, this.wbo.computeSize());
            }
            if (this.wYU != null) {
                bs += C6087a.m9557ix(3, this.wYU.computeSize());
            }
            if (this.xlc != null) {
                bs += C6087a.m9557ix(4, this.xlc.computeSize());
            }
            if (this.xld != null) {
                bs += C6087a.m9557ix(5, this.xld.computeSize());
            }
            if (this.xle != null) {
                bs += C6087a.m9557ix(6, this.xle.computeSize());
            }
            if (this.xlf != null) {
                bs += C6087a.m9557ix(7, this.xlf.computeSize());
            }
            if (this.xlg != null) {
                bs += C6087a.m9557ix(8, this.xlg.computeSize());
            }
            if (this.xlh != null) {
                bs += C6087a.m9557ix(9, this.xlh.computeSize());
            }
            if (this.xli != null) {
                bs += C6087a.m9557ix(10, this.xli.computeSize());
            }
            if (this.vQN != null) {
                bs += C6087a.m9557ix(11, this.vQN.computeSize());
            }
            if (this.vQK != null) {
                bs += C6087a.m9557ix(12, this.vQK.computeSize());
            }
            if (this.xlj != null) {
                bs += C6087a.m9557ix(13, this.xlj.computeSize());
            }
            if (this.xlk != null) {
                bs += C6087a.m9557ix(14, this.xlk.computeSize());
            }
            if (this.wKU != null) {
                bs += C6087a.m9557ix(15, this.wKU.computeSize());
            }
            if (this.xll != null) {
                bs += C6087a.m9557ix(16, this.xll.computeSize());
            }
            if (this.xlm != null) {
                bs += C6087a.m9557ix(17, this.xlm.computeSize());
            }
            if (this.xln != null) {
                bs += C6087a.m9557ix(18, this.xln.computeSize());
            }
            if (this.xlo != null) {
                bs += C6087a.m9557ix(19, this.xlo.computeSize());
            }
            if (this.xlp != null) {
                bs += C6087a.m9557ix(20, this.xlp.computeSize());
            }
            if (this.xlq != null) {
                bs += C6087a.m9557ix(21, this.xlq.computeSize());
            }
            if (this.wVH != null) {
                bs += C6087a.m9557ix(22, this.wVH.computeSize());
            }
            if (this.xlr != null) {
                bs += C6087a.m9557ix(23, this.xlr.computeSize());
            }
            AppMethodBeat.m2505o(48986);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(48986);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cnv cnv = (cnv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    cnv.type = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48986);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgv cgv = new cgv();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgv.populateBuilderWithField(c6086a3, cgv, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cnv.wbo = cgv;
                    }
                    AppMethodBeat.m2505o(48986);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bto bto = new bto();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bto.populateBuilderWithField(c6086a3, bto, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cnv.wYU = bto;
                    }
                    AppMethodBeat.m2505o(48986);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cfy cfy = new cfy();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cfy.populateBuilderWithField(c6086a3, cfy, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cnv.xlc = cfy;
                    }
                    AppMethodBeat.m2505o(48986);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bzy bzy = new bzy();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bzy.populateBuilderWithField(c6086a3, bzy, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cnv.xld = bzy;
                    }
                    AppMethodBeat.m2505o(48986);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bdn bdn = new bdn();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bdn.populateBuilderWithField(c6086a3, bdn, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cnv.xle = bdn;
                    }
                    AppMethodBeat.m2505o(48986);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bdw bdw = new bdw();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bdw.populateBuilderWithField(c6086a3, bdw, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cnv.xlf = bdw;
                    }
                    AppMethodBeat.m2505o(48986);
                    return 0;
                case 8:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C23420ob c23420ob = new C23420ob();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c23420ob.populateBuilderWithField(c6086a3, c23420ob, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cnv.xlg = c23420ob;
                    }
                    AppMethodBeat.m2505o(48986);
                    return 0;
                case 9:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C15387ui c15387ui = new C15387ui();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c15387ui.populateBuilderWithField(c6086a3, c15387ui, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cnv.xlh = c15387ui;
                    }
                    AppMethodBeat.m2505o(48986);
                    return 0;
                case 10:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7265hg c7265hg = new C7265hg();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7265hg.populateBuilderWithField(c6086a3, c7265hg, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cnv.xli = c7265hg;
                    }
                    AppMethodBeat.m2505o(48986);
                    return 0;
                case 11:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C46566ms c46566ms = new C46566ms();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c46566ms.populateBuilderWithField(c6086a3, c46566ms, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cnv.vQN = c46566ms;
                    }
                    AppMethodBeat.m2505o(48986);
                    return 0;
                case 12:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        auj auj = new auj();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = auj.populateBuilderWithField(c6086a3, auj, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cnv.vQK = auj;
                    }
                    AppMethodBeat.m2505o(48986);
                    return 0;
                case 13:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ayp ayp = new ayp();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = ayp.populateBuilderWithField(c6086a3, ayp, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cnv.xlj = ayp;
                    }
                    AppMethodBeat.m2505o(48986);
                    return 0;
                case 14:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        asd asd = new asd();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = asd.populateBuilderWithField(c6086a3, asd, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cnv.xlk = asd;
                    }
                    AppMethodBeat.m2505o(48986);
                    return 0;
                case 15:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bln bln = new bln();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bln.populateBuilderWithField(c6086a3, bln, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cnv.wKU = bln;
                    }
                    AppMethodBeat.m2505o(48986);
                    return 0;
                case 16:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bht bht = new bht();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bht.populateBuilderWithField(c6086a3, bht, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cnv.xll = bht;
                    }
                    AppMethodBeat.m2505o(48986);
                    return 0;
                case 17:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        avd avd = new avd();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = avd.populateBuilderWithField(c6086a3, avd, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cnv.xlm = avd;
                    }
                    AppMethodBeat.m2505o(48986);
                    return 0;
                case 18:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ave ave = new ave();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = ave.populateBuilderWithField(c6086a3, ave, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cnv.xln = ave;
                    }
                    AppMethodBeat.m2505o(48986);
                    return 0;
                case 19:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgd cgd = new cgd();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgd.populateBuilderWithField(c6086a3, cgd, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cnv.xlo = cgd;
                    }
                    AppMethodBeat.m2505o(48986);
                    return 0;
                case 20:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C46588tz c46588tz = new C46588tz();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c46588tz.populateBuilderWithField(c6086a3, c46588tz, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cnv.xlp = c46588tz;
                    }
                    AppMethodBeat.m2505o(48986);
                    return 0;
                case 21:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C40547mt c40547mt = new C40547mt();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c40547mt.populateBuilderWithField(c6086a3, c40547mt, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cnv.xlq = c40547mt;
                    }
                    AppMethodBeat.m2505o(48986);
                    return 0;
                case 22:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C23370ba c23370ba = new C23370ba();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c23370ba.populateBuilderWithField(c6086a3, c23370ba, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cnv.wVH = c23370ba;
                    }
                    AppMethodBeat.m2505o(48986);
                    return 0;
                case 23:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cnx cnx = new cnx();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cnx.populateBuilderWithField(c6086a3, cnx, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cnv.xlr = cnx;
                    }
                    AppMethodBeat.m2505o(48986);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48986);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48986);
            return -1;
        }
    }
}
