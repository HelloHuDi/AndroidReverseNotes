package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class rl extends bsr {
    public int Scene;
    public String Title;
    public String fJU;
    public String fKh;
    public String vYH;
    public String vYI;
    public String vYJ;
    public String vYK;
    public String vYL;
    public String vYM;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(105144);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.fJU != null) {
                aVar.e(2, this.fJU);
            }
            if (this.Title != null) {
                aVar.e(3, this.Title);
            }
            if (this.vYH != null) {
                aVar.e(4, this.vYH);
            }
            if (this.vYI != null) {
                aVar.e(5, this.vYI);
            }
            if (this.vYJ != null) {
                aVar.e(6, this.vYJ);
            }
            if (this.vYK != null) {
                aVar.e(7, this.vYK);
            }
            if (this.vYL != null) {
                aVar.e(8, this.vYL);
            }
            if (this.fKh != null) {
                aVar.e(9, this.fKh);
            }
            aVar.iz(10, this.Scene);
            if (this.vYM != null) {
                aVar.e(11, this.vYM);
            }
            AppMethodBeat.o(105144);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.fJU != null) {
                ix += e.a.a.b.b.a.f(2, this.fJU);
            }
            if (this.Title != null) {
                ix += e.a.a.b.b.a.f(3, this.Title);
            }
            if (this.vYH != null) {
                ix += e.a.a.b.b.a.f(4, this.vYH);
            }
            if (this.vYI != null) {
                ix += e.a.a.b.b.a.f(5, this.vYI);
            }
            if (this.vYJ != null) {
                ix += e.a.a.b.b.a.f(6, this.vYJ);
            }
            if (this.vYK != null) {
                ix += e.a.a.b.b.a.f(7, this.vYK);
            }
            if (this.vYL != null) {
                ix += e.a.a.b.b.a.f(8, this.vYL);
            }
            if (this.fKh != null) {
                ix += e.a.a.b.b.a.f(9, this.fKh);
            }
            ix += e.a.a.b.b.a.bs(10, this.Scene);
            if (this.vYM != null) {
                ix += e.a.a.b.b.a.f(11, this.vYM);
            }
            AppMethodBeat.o(105144);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(105144);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            rl rlVar = (rl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        hl hlVar = new hl();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        rlVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(105144);
                    return 0;
                case 2:
                    rlVar.fJU = aVar3.BTU.readString();
                    AppMethodBeat.o(105144);
                    return 0;
                case 3:
                    rlVar.Title = aVar3.BTU.readString();
                    AppMethodBeat.o(105144);
                    return 0;
                case 4:
                    rlVar.vYH = aVar3.BTU.readString();
                    AppMethodBeat.o(105144);
                    return 0;
                case 5:
                    rlVar.vYI = aVar3.BTU.readString();
                    AppMethodBeat.o(105144);
                    return 0;
                case 6:
                    rlVar.vYJ = aVar3.BTU.readString();
                    AppMethodBeat.o(105144);
                    return 0;
                case 7:
                    rlVar.vYK = aVar3.BTU.readString();
                    AppMethodBeat.o(105144);
                    return 0;
                case 8:
                    rlVar.vYL = aVar3.BTU.readString();
                    AppMethodBeat.o(105144);
                    return 0;
                case 9:
                    rlVar.fKh = aVar3.BTU.readString();
                    AppMethodBeat.o(105144);
                    return 0;
                case 10:
                    rlVar.Scene = aVar3.BTU.vd();
                    AppMethodBeat.o(105144);
                    return 0;
                case 11:
                    rlVar.vYM = aVar3.BTU.readString();
                    AppMethodBeat.o(105144);
                    return 0;
                default:
                    AppMethodBeat.o(105144);
                    return -1;
            }
        } else {
            AppMethodBeat.o(105144);
            return -1;
        }
    }
}
