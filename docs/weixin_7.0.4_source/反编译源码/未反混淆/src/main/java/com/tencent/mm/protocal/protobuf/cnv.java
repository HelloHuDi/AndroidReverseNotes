package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cnv extends a {
    public int type;
    public auj vQK;
    public ms vQN;
    public bln wKU;
    public ba wVH;
    public bto wYU;
    public cgv wbo;
    public cfy xlc;
    public bzy xld;
    public bdn xle;
    public bdw xlf;
    public ob xlg;
    public ui xlh;
    public hg xli;
    public ayp xlj;
    public asd xlk;
    public bht xll;
    public avd xlm;
    public ave xln;
    public cgd xlo;
    public tz xlp;
    public mt xlq;
    public cnx xlr;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48986);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.type);
            if (this.wbo != null) {
                aVar.iy(2, this.wbo.computeSize());
                this.wbo.writeFields(aVar);
            }
            if (this.wYU != null) {
                aVar.iy(3, this.wYU.computeSize());
                this.wYU.writeFields(aVar);
            }
            if (this.xlc != null) {
                aVar.iy(4, this.xlc.computeSize());
                this.xlc.writeFields(aVar);
            }
            if (this.xld != null) {
                aVar.iy(5, this.xld.computeSize());
                this.xld.writeFields(aVar);
            }
            if (this.xle != null) {
                aVar.iy(6, this.xle.computeSize());
                this.xle.writeFields(aVar);
            }
            if (this.xlf != null) {
                aVar.iy(7, this.xlf.computeSize());
                this.xlf.writeFields(aVar);
            }
            if (this.xlg != null) {
                aVar.iy(8, this.xlg.computeSize());
                this.xlg.writeFields(aVar);
            }
            if (this.xlh != null) {
                aVar.iy(9, this.xlh.computeSize());
                this.xlh.writeFields(aVar);
            }
            if (this.xli != null) {
                aVar.iy(10, this.xli.computeSize());
                this.xli.writeFields(aVar);
            }
            if (this.vQN != null) {
                aVar.iy(11, this.vQN.computeSize());
                this.vQN.writeFields(aVar);
            }
            if (this.vQK != null) {
                aVar.iy(12, this.vQK.computeSize());
                this.vQK.writeFields(aVar);
            }
            if (this.xlj != null) {
                aVar.iy(13, this.xlj.computeSize());
                this.xlj.writeFields(aVar);
            }
            if (this.xlk != null) {
                aVar.iy(14, this.xlk.computeSize());
                this.xlk.writeFields(aVar);
            }
            if (this.wKU != null) {
                aVar.iy(15, this.wKU.computeSize());
                this.wKU.writeFields(aVar);
            }
            if (this.xll != null) {
                aVar.iy(16, this.xll.computeSize());
                this.xll.writeFields(aVar);
            }
            if (this.xlm != null) {
                aVar.iy(17, this.xlm.computeSize());
                this.xlm.writeFields(aVar);
            }
            if (this.xln != null) {
                aVar.iy(18, this.xln.computeSize());
                this.xln.writeFields(aVar);
            }
            if (this.xlo != null) {
                aVar.iy(19, this.xlo.computeSize());
                this.xlo.writeFields(aVar);
            }
            if (this.xlp != null) {
                aVar.iy(20, this.xlp.computeSize());
                this.xlp.writeFields(aVar);
            }
            if (this.xlq != null) {
                aVar.iy(21, this.xlq.computeSize());
                this.xlq.writeFields(aVar);
            }
            if (this.wVH != null) {
                aVar.iy(22, this.wVH.computeSize());
                this.wVH.writeFields(aVar);
            }
            if (this.xlr != null) {
                aVar.iy(23, this.xlr.computeSize());
                this.xlr.writeFields(aVar);
            }
            AppMethodBeat.o(48986);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.type) + 0;
            if (this.wbo != null) {
                bs += e.a.a.a.ix(2, this.wbo.computeSize());
            }
            if (this.wYU != null) {
                bs += e.a.a.a.ix(3, this.wYU.computeSize());
            }
            if (this.xlc != null) {
                bs += e.a.a.a.ix(4, this.xlc.computeSize());
            }
            if (this.xld != null) {
                bs += e.a.a.a.ix(5, this.xld.computeSize());
            }
            if (this.xle != null) {
                bs += e.a.a.a.ix(6, this.xle.computeSize());
            }
            if (this.xlf != null) {
                bs += e.a.a.a.ix(7, this.xlf.computeSize());
            }
            if (this.xlg != null) {
                bs += e.a.a.a.ix(8, this.xlg.computeSize());
            }
            if (this.xlh != null) {
                bs += e.a.a.a.ix(9, this.xlh.computeSize());
            }
            if (this.xli != null) {
                bs += e.a.a.a.ix(10, this.xli.computeSize());
            }
            if (this.vQN != null) {
                bs += e.a.a.a.ix(11, this.vQN.computeSize());
            }
            if (this.vQK != null) {
                bs += e.a.a.a.ix(12, this.vQK.computeSize());
            }
            if (this.xlj != null) {
                bs += e.a.a.a.ix(13, this.xlj.computeSize());
            }
            if (this.xlk != null) {
                bs += e.a.a.a.ix(14, this.xlk.computeSize());
            }
            if (this.wKU != null) {
                bs += e.a.a.a.ix(15, this.wKU.computeSize());
            }
            if (this.xll != null) {
                bs += e.a.a.a.ix(16, this.xll.computeSize());
            }
            if (this.xlm != null) {
                bs += e.a.a.a.ix(17, this.xlm.computeSize());
            }
            if (this.xln != null) {
                bs += e.a.a.a.ix(18, this.xln.computeSize());
            }
            if (this.xlo != null) {
                bs += e.a.a.a.ix(19, this.xlo.computeSize());
            }
            if (this.xlp != null) {
                bs += e.a.a.a.ix(20, this.xlp.computeSize());
            }
            if (this.xlq != null) {
                bs += e.a.a.a.ix(21, this.xlq.computeSize());
            }
            if (this.wVH != null) {
                bs += e.a.a.a.ix(22, this.wVH.computeSize());
            }
            if (this.xlr != null) {
                bs += e.a.a.a.ix(23, this.xlr.computeSize());
            }
            AppMethodBeat.o(48986);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48986);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cnv cnv = (cnv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    cnv.type = aVar3.BTU.vd();
                    AppMethodBeat.o(48986);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgv cgv = new cgv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgv.populateBuilderWithField(aVar4, cgv, a.getNextFieldNumber(aVar4))) {
                        }
                        cnv.wbo = cgv;
                    }
                    AppMethodBeat.o(48986);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bto bto = new bto();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bto.populateBuilderWithField(aVar4, bto, a.getNextFieldNumber(aVar4))) {
                        }
                        cnv.wYU = bto;
                    }
                    AppMethodBeat.o(48986);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cfy cfy = new cfy();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cfy.populateBuilderWithField(aVar4, cfy, a.getNextFieldNumber(aVar4))) {
                        }
                        cnv.xlc = cfy;
                    }
                    AppMethodBeat.o(48986);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bzy bzy = new bzy();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bzy.populateBuilderWithField(aVar4, bzy, a.getNextFieldNumber(aVar4))) {
                        }
                        cnv.xld = bzy;
                    }
                    AppMethodBeat.o(48986);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bdn bdn = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bdn.populateBuilderWithField(aVar4, bdn, a.getNextFieldNumber(aVar4))) {
                        }
                        cnv.xle = bdn;
                    }
                    AppMethodBeat.o(48986);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bdw bdw = new bdw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bdw.populateBuilderWithField(aVar4, bdw, a.getNextFieldNumber(aVar4))) {
                        }
                        cnv.xlf = bdw;
                    }
                    AppMethodBeat.o(48986);
                    return 0;
                case 8:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ob obVar = new ob();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = obVar.populateBuilderWithField(aVar4, obVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cnv.xlg = obVar;
                    }
                    AppMethodBeat.o(48986);
                    return 0;
                case 9:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ui uiVar = new ui();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = uiVar.populateBuilderWithField(aVar4, uiVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cnv.xlh = uiVar;
                    }
                    AppMethodBeat.o(48986);
                    return 0;
                case 10:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        hg hgVar = new hg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hgVar.populateBuilderWithField(aVar4, hgVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cnv.xli = hgVar;
                    }
                    AppMethodBeat.o(48986);
                    return 0;
                case 11:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ms msVar = new ms();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = msVar.populateBuilderWithField(aVar4, msVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cnv.vQN = msVar;
                    }
                    AppMethodBeat.o(48986);
                    return 0;
                case 12:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        auj auj = new auj();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = auj.populateBuilderWithField(aVar4, auj, a.getNextFieldNumber(aVar4))) {
                        }
                        cnv.vQK = auj;
                    }
                    AppMethodBeat.o(48986);
                    return 0;
                case 13:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ayp ayp = new ayp();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ayp.populateBuilderWithField(aVar4, ayp, a.getNextFieldNumber(aVar4))) {
                        }
                        cnv.xlj = ayp;
                    }
                    AppMethodBeat.o(48986);
                    return 0;
                case 14:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        asd asd = new asd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = asd.populateBuilderWithField(aVar4, asd, a.getNextFieldNumber(aVar4))) {
                        }
                        cnv.xlk = asd;
                    }
                    AppMethodBeat.o(48986);
                    return 0;
                case 15:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bln bln = new bln();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bln.populateBuilderWithField(aVar4, bln, a.getNextFieldNumber(aVar4))) {
                        }
                        cnv.wKU = bln;
                    }
                    AppMethodBeat.o(48986);
                    return 0;
                case 16:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bht bht = new bht();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bht.populateBuilderWithField(aVar4, bht, a.getNextFieldNumber(aVar4))) {
                        }
                        cnv.xll = bht;
                    }
                    AppMethodBeat.o(48986);
                    return 0;
                case 17:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        avd avd = new avd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = avd.populateBuilderWithField(aVar4, avd, a.getNextFieldNumber(aVar4))) {
                        }
                        cnv.xlm = avd;
                    }
                    AppMethodBeat.o(48986);
                    return 0;
                case 18:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ave ave = new ave();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ave.populateBuilderWithField(aVar4, ave, a.getNextFieldNumber(aVar4))) {
                        }
                        cnv.xln = ave;
                    }
                    AppMethodBeat.o(48986);
                    return 0;
                case 19:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgd cgd = new cgd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgd.populateBuilderWithField(aVar4, cgd, a.getNextFieldNumber(aVar4))) {
                        }
                        cnv.xlo = cgd;
                    }
                    AppMethodBeat.o(48986);
                    return 0;
                case 20:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        tz tzVar = new tz();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = tzVar.populateBuilderWithField(aVar4, tzVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cnv.xlp = tzVar;
                    }
                    AppMethodBeat.o(48986);
                    return 0;
                case 21:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        mt mtVar = new mt();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = mtVar.populateBuilderWithField(aVar4, mtVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cnv.xlq = mtVar;
                    }
                    AppMethodBeat.o(48986);
                    return 0;
                case 22:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ba baVar = new ba();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = baVar.populateBuilderWithField(aVar4, baVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cnv.wVH = baVar;
                    }
                    AppMethodBeat.o(48986);
                    return 0;
                case 23:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cnx cnx = new cnx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cnx.populateBuilderWithField(aVar4, cnx, a.getNextFieldNumber(aVar4))) {
                        }
                        cnv.xlr = cnx;
                    }
                    AppMethodBeat.o(48986);
                    return 0;
                default:
                    AppMethodBeat.o(48986);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48986);
            return -1;
        }
    }
}
