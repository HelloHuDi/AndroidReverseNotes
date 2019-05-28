package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class qm extends bsr {
    public String fMd;
    public String ndF;
    public String ndG;
    public int vHo;
    public String vRw;
    public long vXv;
    public String vXw;
    public String vXx;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28353);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.ndG != null) {
                aVar.e(2, this.ndG);
            }
            if (this.ndF != null) {
                aVar.e(3, this.ndF);
            }
            aVar.ai(4, this.vXv);
            if (this.vRw != null) {
                aVar.e(5, this.vRw);
            }
            if (this.vXw != null) {
                aVar.e(6, this.vXw);
            }
            aVar.iz(7, this.vHo);
            if (this.vXx != null) {
                aVar.e(8, this.vXx);
            }
            if (this.fMd != null) {
                aVar.e(9, this.fMd);
            }
            AppMethodBeat.o(28353);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.ndG != null) {
                ix += e.a.a.b.b.a.f(2, this.ndG);
            }
            if (this.ndF != null) {
                ix += e.a.a.b.b.a.f(3, this.ndF);
            }
            ix += e.a.a.b.b.a.o(4, this.vXv);
            if (this.vRw != null) {
                ix += e.a.a.b.b.a.f(5, this.vRw);
            }
            if (this.vXw != null) {
                ix += e.a.a.b.b.a.f(6, this.vXw);
            }
            ix += e.a.a.b.b.a.bs(7, this.vHo);
            if (this.vXx != null) {
                ix += e.a.a.b.b.a.f(8, this.vXx);
            }
            if (this.fMd != null) {
                ix += e.a.a.b.b.a.f(9, this.fMd);
            }
            AppMethodBeat.o(28353);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28353);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            qm qmVar = (qm) objArr[1];
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
                        qmVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(28353);
                    return 0;
                case 2:
                    qmVar.ndG = aVar3.BTU.readString();
                    AppMethodBeat.o(28353);
                    return 0;
                case 3:
                    qmVar.ndF = aVar3.BTU.readString();
                    AppMethodBeat.o(28353);
                    return 0;
                case 4:
                    qmVar.vXv = aVar3.BTU.ve();
                    AppMethodBeat.o(28353);
                    return 0;
                case 5:
                    qmVar.vRw = aVar3.BTU.readString();
                    AppMethodBeat.o(28353);
                    return 0;
                case 6:
                    qmVar.vXw = aVar3.BTU.readString();
                    AppMethodBeat.o(28353);
                    return 0;
                case 7:
                    qmVar.vHo = aVar3.BTU.vd();
                    AppMethodBeat.o(28353);
                    return 0;
                case 8:
                    qmVar.vXx = aVar3.BTU.readString();
                    AppMethodBeat.o(28353);
                    return 0;
                case 9:
                    qmVar.fMd = aVar3.BTU.readString();
                    AppMethodBeat.o(28353);
                    return 0;
                default:
                    AppMethodBeat.o(28353);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28353);
            return -1;
        }
    }
}
