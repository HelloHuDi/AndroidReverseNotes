package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ajj extends bsr {
    public String jBB;
    public int ptw;
    public int ptx;
    public int wpf;
    public int wpg;
    public String wph;
    public int wpi;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80073);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.jBB != null) {
                aVar.e(2, this.jBB);
            }
            aVar.iz(3, this.wpf);
            aVar.iz(4, this.wpg);
            if (this.wph != null) {
                aVar.e(5, this.wph);
            }
            aVar.iz(6, this.ptw);
            aVar.iz(7, this.ptx);
            aVar.iz(8, this.wpi);
            AppMethodBeat.o(80073);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.jBB != null) {
                ix += e.a.a.b.b.a.f(2, this.jBB);
            }
            ix = (ix + e.a.a.b.b.a.bs(3, this.wpf)) + e.a.a.b.b.a.bs(4, this.wpg);
            if (this.wph != null) {
                ix += e.a.a.b.b.a.f(5, this.wph);
            }
            int bs = ((ix + e.a.a.b.b.a.bs(6, this.ptw)) + e.a.a.b.b.a.bs(7, this.ptx)) + e.a.a.b.b.a.bs(8, this.wpi);
            AppMethodBeat.o(80073);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(80073);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ajj ajj = (ajj) objArr[1];
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
                        ajj.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(80073);
                    return 0;
                case 2:
                    ajj.jBB = aVar3.BTU.readString();
                    AppMethodBeat.o(80073);
                    return 0;
                case 3:
                    ajj.wpf = aVar3.BTU.vd();
                    AppMethodBeat.o(80073);
                    return 0;
                case 4:
                    ajj.wpg = aVar3.BTU.vd();
                    AppMethodBeat.o(80073);
                    return 0;
                case 5:
                    ajj.wph = aVar3.BTU.readString();
                    AppMethodBeat.o(80073);
                    return 0;
                case 6:
                    ajj.ptw = aVar3.BTU.vd();
                    AppMethodBeat.o(80073);
                    return 0;
                case 7:
                    ajj.ptx = aVar3.BTU.vd();
                    AppMethodBeat.o(80073);
                    return 0;
                case 8:
                    ajj.wpi = aVar3.BTU.vd();
                    AppMethodBeat.o(80073);
                    return 0;
                default:
                    AppMethodBeat.o(80073);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80073);
            return -1;
        }
    }
}
