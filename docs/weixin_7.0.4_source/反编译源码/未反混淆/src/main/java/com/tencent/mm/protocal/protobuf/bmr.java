package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bmr extends bsr {
    public long appid;
    public int cuy;
    public int platform;
    public int scene;
    public long vNx;
    public String wMv;
    public int wPC;
    public long wPD;
    public int wPE;
    public long wPF;
    public long wPG;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(11794);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.wPC);
            aVar.ai(3, this.wPD);
            aVar.ai(4, this.appid);
            aVar.ai(5, this.vNx);
            aVar.iz(6, this.wPE);
            aVar.iz(7, this.scene);
            aVar.iz(8, this.cuy);
            aVar.ai(9, this.wPF);
            aVar.ai(10, this.wPG);
            aVar.iz(11, this.platform);
            if (this.wMv != null) {
                aVar.e(12, this.wMv);
            }
            AppMethodBeat.o(11794);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (((((((((ix + e.a.a.b.b.a.bs(2, this.wPC)) + e.a.a.b.b.a.o(3, this.wPD)) + e.a.a.b.b.a.o(4, this.appid)) + e.a.a.b.b.a.o(5, this.vNx)) + e.a.a.b.b.a.bs(6, this.wPE)) + e.a.a.b.b.a.bs(7, this.scene)) + e.a.a.b.b.a.bs(8, this.cuy)) + e.a.a.b.b.a.o(9, this.wPF)) + e.a.a.b.b.a.o(10, this.wPG)) + e.a.a.b.b.a.bs(11, this.platform);
            if (this.wMv != null) {
                ix += e.a.a.b.b.a.f(12, this.wMv);
            }
            AppMethodBeat.o(11794);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(11794);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bmr bmr = (bmr) objArr[1];
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
                        bmr.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(11794);
                    return 0;
                case 2:
                    bmr.wPC = aVar3.BTU.vd();
                    AppMethodBeat.o(11794);
                    return 0;
                case 3:
                    bmr.wPD = aVar3.BTU.ve();
                    AppMethodBeat.o(11794);
                    return 0;
                case 4:
                    bmr.appid = aVar3.BTU.ve();
                    AppMethodBeat.o(11794);
                    return 0;
                case 5:
                    bmr.vNx = aVar3.BTU.ve();
                    AppMethodBeat.o(11794);
                    return 0;
                case 6:
                    bmr.wPE = aVar3.BTU.vd();
                    AppMethodBeat.o(11794);
                    return 0;
                case 7:
                    bmr.scene = aVar3.BTU.vd();
                    AppMethodBeat.o(11794);
                    return 0;
                case 8:
                    bmr.cuy = aVar3.BTU.vd();
                    AppMethodBeat.o(11794);
                    return 0;
                case 9:
                    bmr.wPF = aVar3.BTU.ve();
                    AppMethodBeat.o(11794);
                    return 0;
                case 10:
                    bmr.wPG = aVar3.BTU.ve();
                    AppMethodBeat.o(11794);
                    return 0;
                case 11:
                    bmr.platform = aVar3.BTU.vd();
                    AppMethodBeat.o(11794);
                    return 0;
                case 12:
                    bmr.wMv = aVar3.BTU.readString();
                    AppMethodBeat.o(11794);
                    return 0;
                default:
                    AppMethodBeat.o(11794);
                    return -1;
            }
        } else {
            AppMethodBeat.o(11794);
            return -1;
        }
    }
}
