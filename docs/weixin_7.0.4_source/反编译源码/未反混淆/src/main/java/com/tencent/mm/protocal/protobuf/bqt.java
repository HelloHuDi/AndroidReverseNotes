package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bqt extends bsr {
    public int jCt;
    public int nbj;
    public cmj wTf;
    public cie wTg;
    public String weu;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(113789);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wTf == null) {
                bVar = new b("Not all required fields were included: UserPosition");
                AppMethodBeat.o(113789);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.weu != null) {
                aVar.e(2, this.weu);
            }
            aVar.iz(3, this.jCt);
            if (this.wTf != null) {
                aVar.iy(4, this.wTf.computeSize());
                this.wTf.writeFields(aVar);
            }
            aVar.iz(5, this.nbj);
            if (this.wTg != null) {
                aVar.iy(6, this.wTg.computeSize());
                this.wTg.writeFields(aVar);
            }
            AppMethodBeat.o(113789);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.weu != null) {
                ix += e.a.a.b.b.a.f(2, this.weu);
            }
            ix += e.a.a.b.b.a.bs(3, this.jCt);
            if (this.wTf != null) {
                ix += e.a.a.a.ix(4, this.wTf.computeSize());
            }
            ix += e.a.a.b.b.a.bs(5, this.nbj);
            if (this.wTg != null) {
                ix += e.a.a.a.ix(6, this.wTg.computeSize());
            }
            AppMethodBeat.o(113789);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.wTf == null) {
                bVar = new b("Not all required fields were included: UserPosition");
                AppMethodBeat.o(113789);
                throw bVar;
            }
            AppMethodBeat.o(113789);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bqt bqt = (bqt) objArr[1];
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
                        hl hlVar = new hl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bqt.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(113789);
                    return 0;
                case 2:
                    bqt.weu = aVar3.BTU.readString();
                    AppMethodBeat.o(113789);
                    return 0;
                case 3:
                    bqt.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(113789);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cmj cmj = new cmj();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cmj.populateBuilderWithField(aVar4, cmj, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bqt.wTf = cmj;
                    }
                    AppMethodBeat.o(113789);
                    return 0;
                case 5:
                    bqt.nbj = aVar3.BTU.vd();
                    AppMethodBeat.o(113789);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cie cie = new cie();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cie.populateBuilderWithField(aVar4, cie, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bqt.wTg = cie;
                    }
                    AppMethodBeat.o(113789);
                    return 0;
                default:
                    AppMethodBeat.o(113789);
                    return -1;
            }
        } else {
            AppMethodBeat.o(113789);
            return -1;
        }
    }
}
