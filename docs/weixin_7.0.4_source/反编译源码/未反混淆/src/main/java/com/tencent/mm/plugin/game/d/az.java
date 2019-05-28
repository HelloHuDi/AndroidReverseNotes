package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bsr;
import com.tencent.mm.protocal.protobuf.hl;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class az extends bsr {
    public String guW;
    public String mZr;
    public boolean nbG;
    public boolean nbH;
    public boolean nbI;
    public String nbs;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111594);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.nbs == null) {
                bVar = new b("Not all required fields were included: Lang");
                AppMethodBeat.o(111594);
                throw bVar;
            } else if (this.mZr == null) {
                bVar = new b("Not all required fields were included: AppID");
                AppMethodBeat.o(111594);
                throw bVar;
            } else {
                if (this.BaseRequest != null) {
                    aVar.iy(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                if (this.nbs != null) {
                    aVar.e(2, this.nbs);
                }
                if (this.mZr != null) {
                    aVar.e(3, this.mZr);
                }
                aVar.aO(4, this.nbG);
                if (this.guW != null) {
                    aVar.e(5, this.guW);
                }
                aVar.aO(6, this.nbH);
                aVar.aO(7, this.nbI);
                AppMethodBeat.o(111594);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.nbs != null) {
                ix += e.a.a.b.b.a.f(2, this.nbs);
            }
            if (this.mZr != null) {
                ix += e.a.a.b.b.a.f(3, this.mZr);
            }
            ix += e.a.a.b.b.a.fv(4) + 1;
            if (this.guW != null) {
                ix += e.a.a.b.b.a.f(5, this.guW);
            }
            int fv = (ix + (e.a.a.b.b.a.fv(6) + 1)) + (e.a.a.b.b.a.fv(7) + 1);
            AppMethodBeat.o(111594);
            return fv;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.nbs == null) {
                bVar = new b("Not all required fields were included: Lang");
                AppMethodBeat.o(111594);
                throw bVar;
            } else if (this.mZr == null) {
                bVar = new b("Not all required fields were included: AppID");
                AppMethodBeat.o(111594);
                throw bVar;
            } else {
                AppMethodBeat.o(111594);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            az azVar = (az) objArr[1];
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
                        azVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(111594);
                    return 0;
                case 2:
                    azVar.nbs = aVar3.BTU.readString();
                    AppMethodBeat.o(111594);
                    return 0;
                case 3:
                    azVar.mZr = aVar3.BTU.readString();
                    AppMethodBeat.o(111594);
                    return 0;
                case 4:
                    azVar.nbG = aVar3.BTU.ehX();
                    AppMethodBeat.o(111594);
                    return 0;
                case 5:
                    azVar.guW = aVar3.BTU.readString();
                    AppMethodBeat.o(111594);
                    return 0;
                case 6:
                    azVar.nbH = aVar3.BTU.ehX();
                    AppMethodBeat.o(111594);
                    return 0;
                case 7:
                    azVar.nbI = aVar3.BTU.ehX();
                    AppMethodBeat.o(111594);
                    return 0;
                default:
                    AppMethodBeat.o(111594);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111594);
            return -1;
        }
    }
}
