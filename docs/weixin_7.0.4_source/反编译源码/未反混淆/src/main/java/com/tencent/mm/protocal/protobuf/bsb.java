package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bsb extends bsr {
    public LinkedList<String> EmotionList = new LinkedList();
    public int jCt;
    public brw wUe;
    public bsl wUf;
    public String wdK;

    public bsb() {
        AppMethodBeat.i(65417);
        AppMethodBeat.o(65417);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(65418);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.jCt);
            if (this.wUe != null) {
                aVar.iy(3, this.wUe.computeSize());
                this.wUe.writeFields(aVar);
            }
            if (this.wUf != null) {
                aVar.iy(4, this.wUf.computeSize());
                this.wUf.writeFields(aVar);
            }
            if (this.wdK != null) {
                aVar.e(5, this.wdK);
            }
            aVar.e(6, 1, this.EmotionList);
            AppMethodBeat.o(65418);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.bs(2, this.jCt);
            if (this.wUe != null) {
                ix += e.a.a.a.ix(3, this.wUe.computeSize());
            }
            if (this.wUf != null) {
                ix += e.a.a.a.ix(4, this.wUf.computeSize());
            }
            if (this.wdK != null) {
                ix += e.a.a.b.b.a.f(5, this.wdK);
            }
            int c = ix + e.a.a.a.c(6, 1, this.EmotionList);
            AppMethodBeat.o(65418);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.EmotionList.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(65418);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bsb bsb = (bsb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        hl hlVar = new hl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bsb.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(65418);
                    return 0;
                case 2:
                    bsb.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(65418);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        brw brw = new brw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = brw.populateBuilderWithField(aVar4, brw, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bsb.wUe = brw;
                    }
                    AppMethodBeat.o(65418);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bsl bsl = new bsl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bsl.populateBuilderWithField(aVar4, bsl, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bsb.wUf = bsl;
                    }
                    AppMethodBeat.o(65418);
                    return 0;
                case 5:
                    bsb.wdK = aVar3.BTU.readString();
                    AppMethodBeat.o(65418);
                    return 0;
                case 6:
                    bsb.EmotionList.add(aVar3.BTU.readString());
                    AppMethodBeat.o(65418);
                    return 0;
                default:
                    AppMethodBeat.o(65418);
                    return -1;
            }
        } else {
            AppMethodBeat.o(65418);
            return -1;
        }
    }
}
