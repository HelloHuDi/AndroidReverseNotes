package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bsr;
import com.tencent.mm.protocal.protobuf.hl;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bl extends bsr {
    public String guW;
    public LinkedList<String> nbX = new LinkedList();
    public String nbs;
    public int ncn;
    public int nco;
    public int ncp;
    public boolean ncq;

    public bl() {
        AppMethodBeat.i(111612);
        AppMethodBeat.o(111612);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111613);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.nbs == null) {
                bVar = new b("Not all required fields were included: Lang");
                AppMethodBeat.o(111613);
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
            aVar.e(5, 1, this.nbX);
            if (this.guW != null) {
                aVar.e(6, this.guW);
            }
            aVar.iz(7, this.ncp);
            aVar.aO(8, this.ncq);
            AppMethodBeat.o(111613);
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
            ix += e.a.a.a.c(5, 1, this.nbX);
            if (this.guW != null) {
                ix += e.a.a.b.b.a.f(6, this.guW);
            }
            int bs = (ix + e.a.a.b.b.a.bs(7, this.ncp)) + (e.a.a.b.b.a.fv(8) + 1);
            AppMethodBeat.o(111613);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.nbX.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.nbs == null) {
                bVar = new b("Not all required fields were included: Lang");
                AppMethodBeat.o(111613);
                throw bVar;
            }
            AppMethodBeat.o(111613);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bl blVar = (bl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        hl hlVar = new hl();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        blVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(111613);
                    return 0;
                case 2:
                    blVar.ncn = aVar3.BTU.vd();
                    AppMethodBeat.o(111613);
                    return 0;
                case 3:
                    blVar.nco = aVar3.BTU.vd();
                    AppMethodBeat.o(111613);
                    return 0;
                case 4:
                    blVar.nbs = aVar3.BTU.readString();
                    AppMethodBeat.o(111613);
                    return 0;
                case 5:
                    blVar.nbX.add(aVar3.BTU.readString());
                    AppMethodBeat.o(111613);
                    return 0;
                case 6:
                    blVar.guW = aVar3.BTU.readString();
                    AppMethodBeat.o(111613);
                    return 0;
                case 7:
                    blVar.ncp = aVar3.BTU.vd();
                    AppMethodBeat.o(111613);
                    return 0;
                case 8:
                    blVar.ncq = aVar3.BTU.ehX();
                    AppMethodBeat.o(111613);
                    return 0;
                default:
                    AppMethodBeat.o(111613);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111613);
            return -1;
        }
    }
}
