package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ajv extends bsr {
    public String mvO;
    public String mvP;
    public String mvQ;
    public String vAN;
    public xa vBe;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28439);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.mvO != null) {
                aVar.e(2, this.mvO);
            }
            if (this.mvP != null) {
                aVar.e(3, this.mvP);
            }
            if (this.mvQ != null) {
                aVar.e(4, this.mvQ);
            }
            if (this.vAN != null) {
                aVar.e(5, this.vAN);
            }
            if (this.vBe != null) {
                aVar.iy(6, this.vBe.computeSize());
                this.vBe.writeFields(aVar);
            }
            AppMethodBeat.o(28439);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.mvO != null) {
                ix += e.a.a.b.b.a.f(2, this.mvO);
            }
            if (this.mvP != null) {
                ix += e.a.a.b.b.a.f(3, this.mvP);
            }
            if (this.mvQ != null) {
                ix += e.a.a.b.b.a.f(4, this.mvQ);
            }
            if (this.vAN != null) {
                ix += e.a.a.b.b.a.f(5, this.vAN);
            }
            if (this.vBe != null) {
                ix += e.a.a.a.ix(6, this.vBe.computeSize());
            }
            AppMethodBeat.o(28439);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28439);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ajv ajv = (ajv) objArr[1];
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
                        ajv.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(28439);
                    return 0;
                case 2:
                    ajv.mvO = aVar3.BTU.readString();
                    AppMethodBeat.o(28439);
                    return 0;
                case 3:
                    ajv.mvP = aVar3.BTU.readString();
                    AppMethodBeat.o(28439);
                    return 0;
                case 4:
                    ajv.mvQ = aVar3.BTU.readString();
                    AppMethodBeat.o(28439);
                    return 0;
                case 5:
                    ajv.vAN = aVar3.BTU.readString();
                    AppMethodBeat.o(28439);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        xa xaVar = new xa();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = xaVar.populateBuilderWithField(aVar4, xaVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ajv.vBe = xaVar;
                    }
                    AppMethodBeat.o(28439);
                    return 0;
                default:
                    AppMethodBeat.o(28439);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28439);
            return -1;
        }
    }
}
