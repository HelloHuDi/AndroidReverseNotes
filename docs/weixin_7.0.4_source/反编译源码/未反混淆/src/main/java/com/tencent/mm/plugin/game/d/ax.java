package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bsr;
import com.tencent.mm.protocal.protobuf.hl;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ax extends bsr {
    public String guW;
    public String nbs;
    public int nbt;
    public d nbu;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(116999);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.nbs == null) {
                bVar = new b("Not all required fields were included: Lang");
                AppMethodBeat.o(116999);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.nbs != null) {
                aVar.e(2, this.nbs);
            }
            if (this.guW != null) {
                aVar.e(3, this.guW);
            }
            aVar.iz(4, this.nbt);
            if (this.nbu != null) {
                aVar.iy(5, this.nbu.computeSize());
                this.nbu.writeFields(aVar);
            }
            AppMethodBeat.o(116999);
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
            if (this.guW != null) {
                ix += e.a.a.b.b.a.f(3, this.guW);
            }
            ix += e.a.a.b.b.a.bs(4, this.nbt);
            if (this.nbu != null) {
                ix += e.a.a.a.ix(5, this.nbu.computeSize());
            }
            AppMethodBeat.o(116999);
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
                AppMethodBeat.o(116999);
                throw bVar;
            }
            AppMethodBeat.o(116999);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ax axVar = (ax) objArr[1];
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
                        axVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(116999);
                    return 0;
                case 2:
                    axVar.nbs = aVar3.BTU.readString();
                    AppMethodBeat.o(116999);
                    return 0;
                case 3:
                    axVar.guW = aVar3.BTU.readString();
                    AppMethodBeat.o(116999);
                    return 0;
                case 4:
                    axVar.nbt = aVar3.BTU.vd();
                    AppMethodBeat.o(116999);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        d dVar = new d();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dVar.populateBuilderWithField(aVar4, dVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        axVar.nbu = dVar;
                    }
                    AppMethodBeat.o(116999);
                    return 0;
                default:
                    AppMethodBeat.o(116999);
                    return -1;
            }
        } else {
            AppMethodBeat.o(116999);
            return -1;
        }
    }
}
