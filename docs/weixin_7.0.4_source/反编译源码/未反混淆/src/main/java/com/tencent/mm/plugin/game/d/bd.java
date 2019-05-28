package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bsr;
import com.tencent.mm.protocal.protobuf.hl;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bd extends bsr {
    public String guW;
    public LinkedList<String> nbX = new LinkedList();
    public t nbY;
    public int nbZ;
    public String nbs;
    public int nbt;
    public boolean nca;

    public bd() {
        AppMethodBeat.i(111600);
        AppMethodBeat.o(111600);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111601);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.nbs == null) {
                bVar = new b("Not all required fields were included: Lang");
                AppMethodBeat.o(111601);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.nbs != null) {
                aVar.e(2, this.nbs);
            }
            aVar.e(3, 1, this.nbX);
            if (this.guW != null) {
                aVar.e(4, this.guW);
            }
            if (this.nbY != null) {
                aVar.iy(5, this.nbY.computeSize());
                this.nbY.writeFields(aVar);
            }
            aVar.iz(6, this.nbZ);
            aVar.aO(7, this.nca);
            aVar.iz(8, this.nbt);
            AppMethodBeat.o(111601);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.nbs != null) {
                ix += e.a.a.b.b.a.f(2, this.nbs);
            }
            ix += e.a.a.a.c(3, 1, this.nbX);
            if (this.guW != null) {
                ix += e.a.a.b.b.a.f(4, this.guW);
            }
            if (this.nbY != null) {
                ix += e.a.a.a.ix(5, this.nbY.computeSize());
            }
            int bs = ((ix + e.a.a.b.b.a.bs(6, this.nbZ)) + (e.a.a.b.b.a.fv(7) + 1)) + e.a.a.b.b.a.bs(8, this.nbt);
            AppMethodBeat.o(111601);
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
                AppMethodBeat.o(111601);
                throw bVar;
            }
            AppMethodBeat.o(111601);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bd bdVar = (bd) objArr[1];
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
                        bdVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(111601);
                    return 0;
                case 2:
                    bdVar.nbs = aVar3.BTU.readString();
                    AppMethodBeat.o(111601);
                    return 0;
                case 3:
                    bdVar.nbX.add(aVar3.BTU.readString());
                    AppMethodBeat.o(111601);
                    return 0;
                case 4:
                    bdVar.guW = aVar3.BTU.readString();
                    AppMethodBeat.o(111601);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        t tVar = new t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = tVar.populateBuilderWithField(aVar4, tVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bdVar.nbY = tVar;
                    }
                    AppMethodBeat.o(111601);
                    return 0;
                case 6:
                    bdVar.nbZ = aVar3.BTU.vd();
                    AppMethodBeat.o(111601);
                    return 0;
                case 7:
                    bdVar.nca = aVar3.BTU.ehX();
                    AppMethodBeat.o(111601);
                    return 0;
                case 8:
                    bdVar.nbt = aVar3.BTU.vd();
                    AppMethodBeat.o(111601);
                    return 0;
                default:
                    AppMethodBeat.o(111601);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111601);
            return -1;
        }
    }
}
