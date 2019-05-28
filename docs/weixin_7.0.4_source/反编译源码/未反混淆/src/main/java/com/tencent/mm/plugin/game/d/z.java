package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.b;
import com.tencent.mm.protocal.protobuf.bsr;
import com.tencent.mm.protocal.protobuf.hl;
import e.a.a.c.a;
import java.util.LinkedList;

public final class z extends bsr {
    public String mZr;
    public String nat;
    public b nau;
    public b nav;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111564);
        e.a.a.b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mZr == null) {
                bVar = new e.a.a.b("Not all required fields were included: AppID");
                AppMethodBeat.o(111564);
                throw bVar;
            } else if (this.nat == null) {
                bVar = new e.a.a.b("Not all required fields were included: GroupID");
                AppMethodBeat.o(111564);
                throw bVar;
            } else {
                if (this.BaseRequest != null) {
                    aVar.iy(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                if (this.mZr != null) {
                    aVar.e(2, this.mZr);
                }
                if (this.nat != null) {
                    aVar.e(3, this.nat);
                }
                if (this.nau != null) {
                    aVar.c(4, this.nau);
                }
                if (this.nav != null) {
                    aVar.c(5, this.nav);
                }
                AppMethodBeat.o(111564);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.mZr != null) {
                ix += e.a.a.b.b.a.f(2, this.mZr);
            }
            if (this.nat != null) {
                ix += e.a.a.b.b.a.f(3, this.nat);
            }
            if (this.nau != null) {
                ix += e.a.a.b.b.a.b(4, this.nau);
            }
            if (this.nav != null) {
                ix += e.a.a.b.b.a.b(5, this.nav);
            }
            AppMethodBeat.o(111564);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.mZr == null) {
                bVar = new e.a.a.b("Not all required fields were included: AppID");
                AppMethodBeat.o(111564);
                throw bVar;
            } else if (this.nat == null) {
                bVar = new e.a.a.b("Not all required fields were included: GroupID");
                AppMethodBeat.o(111564);
                throw bVar;
            } else {
                AppMethodBeat.o(111564);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            z zVar = (z) objArr[1];
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
                        zVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(111564);
                    return 0;
                case 2:
                    zVar.mZr = aVar3.BTU.readString();
                    AppMethodBeat.o(111564);
                    return 0;
                case 3:
                    zVar.nat = aVar3.BTU.readString();
                    AppMethodBeat.o(111564);
                    return 0;
                case 4:
                    zVar.nau = aVar3.BTU.emu();
                    AppMethodBeat.o(111564);
                    return 0;
                case 5:
                    zVar.nav = aVar3.BTU.emu();
                    AppMethodBeat.o(111564);
                    return 0;
                default:
                    AppMethodBeat.o(111564);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111564);
            return -1;
        }
    }
}
