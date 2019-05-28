package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bzg extends bsr {
    public int Scene;
    public int jBv;
    public LinkedList<Integer> vKh = new LinkedList();
    public String wYk;

    public bzg() {
        AppMethodBeat.i(51433);
        AppMethodBeat.o(51433);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(51434);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.wYk != null) {
                aVar.e(2, this.wYk);
            }
            aVar.iz(3, this.Scene);
            aVar.iz(4, this.jBv);
            aVar.f(5, 2, this.vKh);
            AppMethodBeat.o(51434);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wYk != null) {
                ix += e.a.a.b.b.a.f(2, this.wYk);
            }
            int bs = ((ix + e.a.a.b.b.a.bs(3, this.Scene)) + e.a.a.b.b.a.bs(4, this.jBv)) + e.a.a.a.d(5, 2, this.vKh);
            AppMethodBeat.o(51434);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vKh.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(51434);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bzg bzg = (bzg) objArr[1];
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
                        bzg.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(51434);
                    return 0;
                case 2:
                    bzg.wYk = aVar3.BTU.readString();
                    AppMethodBeat.o(51434);
                    return 0;
                case 3:
                    bzg.Scene = aVar3.BTU.vd();
                    AppMethodBeat.o(51434);
                    return 0;
                case 4:
                    bzg.jBv = aVar3.BTU.vd();
                    AppMethodBeat.o(51434);
                    return 0;
                case 5:
                    bzg.vKh = new e.a.a.a.a(aVar3.BTU.emu().wR, unknownTagHandler).BTU.emt();
                    AppMethodBeat.o(51434);
                    return 0;
                default:
                    AppMethodBeat.o(51434);
                    return -1;
            }
        } else {
            AppMethodBeat.o(51434);
            return -1;
        }
    }
}
