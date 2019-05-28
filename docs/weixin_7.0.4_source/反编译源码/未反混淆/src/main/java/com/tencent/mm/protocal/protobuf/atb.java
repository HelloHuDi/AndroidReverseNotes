package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class atb extends a {
    public int cuu;
    public String materialId;
    public String wwP;
    public atc wwQ;
    public String wwR;
    public int wwS;
    public int wwT;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56843);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wwP != null) {
                aVar.e(1, this.wwP);
            }
            aVar.iz(2, this.cuu);
            if (this.materialId != null) {
                aVar.e(3, this.materialId);
            }
            if (this.wwQ != null) {
                aVar.iy(4, this.wwQ.computeSize());
                this.wwQ.writeFields(aVar);
            }
            if (this.wwR != null) {
                aVar.e(5, this.wwR);
            }
            aVar.iz(6, this.wwS);
            aVar.iz(7, this.wwT);
            AppMethodBeat.o(56843);
            return 0;
        } else if (i == 1) {
            if (this.wwP != null) {
                f = e.a.a.b.b.a.f(1, this.wwP) + 0;
            } else {
                f = 0;
            }
            f += e.a.a.b.b.a.bs(2, this.cuu);
            if (this.materialId != null) {
                f += e.a.a.b.b.a.f(3, this.materialId);
            }
            if (this.wwQ != null) {
                f += e.a.a.a.ix(4, this.wwQ.computeSize());
            }
            if (this.wwR != null) {
                f += e.a.a.b.b.a.f(5, this.wwR);
            }
            int bs = (f + e.a.a.b.b.a.bs(6, this.wwS)) + e.a.a.b.b.a.bs(7, this.wwT);
            AppMethodBeat.o(56843);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56843);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            atb atb = (atb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    atb.wwP = aVar3.BTU.readString();
                    AppMethodBeat.o(56843);
                    return 0;
                case 2:
                    atb.cuu = aVar3.BTU.vd();
                    AppMethodBeat.o(56843);
                    return 0;
                case 3:
                    atb.materialId = aVar3.BTU.readString();
                    AppMethodBeat.o(56843);
                    return 0;
                case 4:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        atc atc = new atc();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = atc.populateBuilderWithField(aVar4, atc, a.getNextFieldNumber(aVar4))) {
                        }
                        atb.wwQ = atc;
                    }
                    AppMethodBeat.o(56843);
                    return 0;
                case 5:
                    atb.wwR = aVar3.BTU.readString();
                    AppMethodBeat.o(56843);
                    return 0;
                case 6:
                    atb.wwS = aVar3.BTU.vd();
                    AppMethodBeat.o(56843);
                    return 0;
                case 7:
                    atb.wwT = aVar3.BTU.vd();
                    AppMethodBeat.o(56843);
                    return 0;
                default:
                    AppMethodBeat.o(56843);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56843);
            return -1;
        }
    }
}
