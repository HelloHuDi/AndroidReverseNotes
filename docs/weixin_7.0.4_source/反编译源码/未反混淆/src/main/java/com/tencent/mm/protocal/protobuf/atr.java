package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class atr extends a {
    public int wxH;
    public atu wxI;
    public att wxJ;
    public ats wxK;
    public atq wxL;
    public atv wxM;
    public atw wxN;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28524);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.wxH);
            if (this.wxI != null) {
                aVar.iy(2, this.wxI.computeSize());
                this.wxI.writeFields(aVar);
            }
            if (this.wxJ != null) {
                aVar.iy(3, this.wxJ.computeSize());
                this.wxJ.writeFields(aVar);
            }
            if (this.wxK != null) {
                aVar.iy(4, this.wxK.computeSize());
                this.wxK.writeFields(aVar);
            }
            if (this.wxL != null) {
                aVar.iy(5, this.wxL.computeSize());
                this.wxL.writeFields(aVar);
            }
            if (this.wxM != null) {
                aVar.iy(6, this.wxM.computeSize());
                this.wxM.writeFields(aVar);
            }
            if (this.wxN != null) {
                aVar.iy(7, this.wxN.computeSize());
                this.wxN.writeFields(aVar);
            }
            AppMethodBeat.o(28524);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.wxH) + 0;
            if (this.wxI != null) {
                bs += e.a.a.a.ix(2, this.wxI.computeSize());
            }
            if (this.wxJ != null) {
                bs += e.a.a.a.ix(3, this.wxJ.computeSize());
            }
            if (this.wxK != null) {
                bs += e.a.a.a.ix(4, this.wxK.computeSize());
            }
            if (this.wxL != null) {
                bs += e.a.a.a.ix(5, this.wxL.computeSize());
            }
            if (this.wxM != null) {
                bs += e.a.a.a.ix(6, this.wxM.computeSize());
            }
            if (this.wxN != null) {
                bs += e.a.a.a.ix(7, this.wxN.computeSize());
            }
            AppMethodBeat.o(28524);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28524);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            atr atr = (atr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    atr.wxH = aVar3.BTU.vd();
                    AppMethodBeat.o(28524);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        atu atu = new atu();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = atu.populateBuilderWithField(aVar4, atu, a.getNextFieldNumber(aVar4))) {
                        }
                        atr.wxI = atu;
                    }
                    AppMethodBeat.o(28524);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        att att = new att();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = att.populateBuilderWithField(aVar4, att, a.getNextFieldNumber(aVar4))) {
                        }
                        atr.wxJ = att;
                    }
                    AppMethodBeat.o(28524);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ats ats = new ats();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ats.populateBuilderWithField(aVar4, ats, a.getNextFieldNumber(aVar4))) {
                        }
                        atr.wxK = ats;
                    }
                    AppMethodBeat.o(28524);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        atq atq = new atq();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = atq.populateBuilderWithField(aVar4, atq, a.getNextFieldNumber(aVar4))) {
                        }
                        atr.wxL = atq;
                    }
                    AppMethodBeat.o(28524);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        atv atv = new atv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = atv.populateBuilderWithField(aVar4, atv, a.getNextFieldNumber(aVar4))) {
                        }
                        atr.wxM = atv;
                    }
                    AppMethodBeat.o(28524);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        atw atw = new atw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = atw.populateBuilderWithField(aVar4, atw, a.getNextFieldNumber(aVar4))) {
                        }
                        atr.wxN = atw;
                    }
                    AppMethodBeat.o(28524);
                    return 0;
                default:
                    AppMethodBeat.o(28524);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28524);
            return -1;
        }
    }
}
