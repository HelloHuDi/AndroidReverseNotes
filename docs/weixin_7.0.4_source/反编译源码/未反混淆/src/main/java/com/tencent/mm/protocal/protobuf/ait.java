package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ait extends bsr {
    public String kKO;
    public String person_id;
    public int scene;
    public String vYl;
    public String woJ;
    public int woM;
    public String woN;
    public String woO;
    public biv woh;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(849);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.person_id != null) {
                aVar.e(2, this.person_id);
            }
            if (this.woJ != null) {
                aVar.e(3, this.woJ);
            }
            aVar.iz(4, this.woM);
            if (this.woN != null) {
                aVar.e(5, this.woN);
            }
            if (this.woO != null) {
                aVar.e(6, this.woO);
            }
            aVar.iz(7, this.scene);
            if (this.vYl != null) {
                aVar.e(8, this.vYl);
            }
            if (this.kKO != null) {
                aVar.e(9, this.kKO);
            }
            if (this.woh != null) {
                aVar.iy(10, this.woh.computeSize());
                this.woh.writeFields(aVar);
            }
            AppMethodBeat.o(849);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.person_id != null) {
                ix += e.a.a.b.b.a.f(2, this.person_id);
            }
            if (this.woJ != null) {
                ix += e.a.a.b.b.a.f(3, this.woJ);
            }
            ix += e.a.a.b.b.a.bs(4, this.woM);
            if (this.woN != null) {
                ix += e.a.a.b.b.a.f(5, this.woN);
            }
            if (this.woO != null) {
                ix += e.a.a.b.b.a.f(6, this.woO);
            }
            ix += e.a.a.b.b.a.bs(7, this.scene);
            if (this.vYl != null) {
                ix += e.a.a.b.b.a.f(8, this.vYl);
            }
            if (this.kKO != null) {
                ix += e.a.a.b.b.a.f(9, this.kKO);
            }
            if (this.woh != null) {
                ix += e.a.a.a.ix(10, this.woh.computeSize());
            }
            AppMethodBeat.o(849);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(849);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ait ait = (ait) objArr[1];
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
                        ait.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(849);
                    return 0;
                case 2:
                    ait.person_id = aVar3.BTU.readString();
                    AppMethodBeat.o(849);
                    return 0;
                case 3:
                    ait.woJ = aVar3.BTU.readString();
                    AppMethodBeat.o(849);
                    return 0;
                case 4:
                    ait.woM = aVar3.BTU.vd();
                    AppMethodBeat.o(849);
                    return 0;
                case 5:
                    ait.woN = aVar3.BTU.readString();
                    AppMethodBeat.o(849);
                    return 0;
                case 6:
                    ait.woO = aVar3.BTU.readString();
                    AppMethodBeat.o(849);
                    return 0;
                case 7:
                    ait.scene = aVar3.BTU.vd();
                    AppMethodBeat.o(849);
                    return 0;
                case 8:
                    ait.vYl = aVar3.BTU.readString();
                    AppMethodBeat.o(849);
                    return 0;
                case 9:
                    ait.kKO = aVar3.BTU.readString();
                    AppMethodBeat.o(849);
                    return 0;
                case 10:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        biv biv = new biv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = biv.populateBuilderWithField(aVar4, biv, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ait.woh = biv;
                    }
                    AppMethodBeat.o(849);
                    return 0;
                default:
                    AppMethodBeat.o(849);
                    return -1;
            }
        } else {
            AppMethodBeat.o(849);
            return -1;
        }
    }
}
