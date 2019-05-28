package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class bdv extends a {
    public ato vLK;
    public lm vLL;
    public bdu vLM;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(58916);
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vLK != null) {
                aVar.iy(1, this.vLK.computeSize());
                this.vLK.writeFields(aVar);
            }
            if (this.vLM != null) {
                aVar.iy(2, this.vLM.computeSize());
                this.vLM.writeFields(aVar);
            }
            if (this.vLL != null) {
                aVar.iy(3, this.vLL.computeSize());
                this.vLL.writeFields(aVar);
            }
            AppMethodBeat.o(58916);
            return 0;
        } else if (i == 1) {
            if (this.vLK != null) {
                ix = e.a.a.a.ix(1, this.vLK.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vLM != null) {
                ix += e.a.a.a.ix(2, this.vLM.computeSize());
            }
            if (this.vLL != null) {
                ix += e.a.a.a.ix(3, this.vLL.computeSize());
            }
            AppMethodBeat.o(58916);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(58916);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bdv bdv = (bdv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ato ato = new ato();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ato.populateBuilderWithField(aVar4, ato, a.getNextFieldNumber(aVar4))) {
                        }
                        bdv.vLK = ato;
                    }
                    AppMethodBeat.o(58916);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bdu bdu = new bdu();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bdu.populateBuilderWithField(aVar4, bdu, a.getNextFieldNumber(aVar4))) {
                        }
                        bdv.vLM = bdu;
                    }
                    AppMethodBeat.o(58916);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        lm lmVar = new lm();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = lmVar.populateBuilderWithField(aVar4, lmVar, a.getNextFieldNumber(aVar4))) {
                        }
                        bdv.vLL = lmVar;
                    }
                    AppMethodBeat.o(58916);
                    return 0;
                default:
                    AppMethodBeat.o(58916);
                    return -1;
            }
        } else {
            AppMethodBeat.o(58916);
            return -1;
        }
    }
}
