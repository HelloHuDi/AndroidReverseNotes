package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bsr;
import com.tencent.mm.protocal.protobuf.hl;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bn extends bsr {
    public String guW;
    public String nbs;
    public int ncn;
    public int nco;
    public int ncv;
    public int ncw;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111616);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.nbs == null) {
                bVar = new b("Not all required fields were included: Lang");
                AppMethodBeat.o(111616);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.ncn);
            aVar.iz(3, this.nco);
            if (this.nbs != null) {
                aVar.e(4, this.nbs);
            }
            aVar.iz(5, this.ncv);
            aVar.iz(6, this.ncw);
            if (this.guW != null) {
                aVar.e(7, this.guW);
            }
            AppMethodBeat.o(111616);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + e.a.a.b.b.a.bs(2, this.ncn)) + e.a.a.b.b.a.bs(3, this.nco);
            if (this.nbs != null) {
                ix += e.a.a.b.b.a.f(4, this.nbs);
            }
            ix = (ix + e.a.a.b.b.a.bs(5, this.ncv)) + e.a.a.b.b.a.bs(6, this.ncw);
            if (this.guW != null) {
                ix += e.a.a.b.b.a.f(7, this.guW);
            }
            AppMethodBeat.o(111616);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.nbs == null) {
                bVar = new b("Not all required fields were included: Lang");
                AppMethodBeat.o(111616);
                throw bVar;
            }
            AppMethodBeat.o(111616);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bn bnVar = (bn) objArr[1];
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
                        bnVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(111616);
                    return 0;
                case 2:
                    bnVar.ncn = aVar3.BTU.vd();
                    AppMethodBeat.o(111616);
                    return 0;
                case 3:
                    bnVar.nco = aVar3.BTU.vd();
                    AppMethodBeat.o(111616);
                    return 0;
                case 4:
                    bnVar.nbs = aVar3.BTU.readString();
                    AppMethodBeat.o(111616);
                    return 0;
                case 5:
                    bnVar.ncv = aVar3.BTU.vd();
                    AppMethodBeat.o(111616);
                    return 0;
                case 6:
                    bnVar.ncw = aVar3.BTU.vd();
                    AppMethodBeat.o(111616);
                    return 0;
                case 7:
                    bnVar.guW = aVar3.BTU.readString();
                    AppMethodBeat.o(111616);
                    return 0;
                default:
                    AppMethodBeat.o(111616);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111616);
            return -1;
        }
    }
}
