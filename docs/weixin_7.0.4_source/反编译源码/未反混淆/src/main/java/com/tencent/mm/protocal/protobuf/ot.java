package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ot extends bsr {
    public String kfT;
    public int nUf;
    public String nickname;
    public String pPH;
    public String pPI;
    public String pPZ;
    public String pPw;
    public String pQc;
    public String vVT;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56746);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.nUf);
            if (this.kfT != null) {
                aVar.e(3, this.kfT);
            }
            if (this.pPZ != null) {
                aVar.e(4, this.pPZ);
            }
            if (this.vVT != null) {
                aVar.e(5, this.vVT);
            }
            if (this.pPH != null) {
                aVar.e(6, this.pPH);
            }
            if (this.pPI != null) {
                aVar.e(7, this.pPI);
            }
            if (this.pQc != null) {
                aVar.e(8, this.pQc);
            }
            if (this.nickname != null) {
                aVar.e(9, this.nickname);
            }
            if (this.pPw != null) {
                aVar.e(10, this.pPw);
            }
            AppMethodBeat.o(56746);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.bs(2, this.nUf);
            if (this.kfT != null) {
                ix += e.a.a.b.b.a.f(3, this.kfT);
            }
            if (this.pPZ != null) {
                ix += e.a.a.b.b.a.f(4, this.pPZ);
            }
            if (this.vVT != null) {
                ix += e.a.a.b.b.a.f(5, this.vVT);
            }
            if (this.pPH != null) {
                ix += e.a.a.b.b.a.f(6, this.pPH);
            }
            if (this.pPI != null) {
                ix += e.a.a.b.b.a.f(7, this.pPI);
            }
            if (this.pQc != null) {
                ix += e.a.a.b.b.a.f(8, this.pQc);
            }
            if (this.nickname != null) {
                ix += e.a.a.b.b.a.f(9, this.nickname);
            }
            if (this.pPw != null) {
                ix += e.a.a.b.b.a.f(10, this.pPw);
            }
            AppMethodBeat.o(56746);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56746);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ot otVar = (ot) objArr[1];
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
                        otVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(56746);
                    return 0;
                case 2:
                    otVar.nUf = aVar3.BTU.vd();
                    AppMethodBeat.o(56746);
                    return 0;
                case 3:
                    otVar.kfT = aVar3.BTU.readString();
                    AppMethodBeat.o(56746);
                    return 0;
                case 4:
                    otVar.pPZ = aVar3.BTU.readString();
                    AppMethodBeat.o(56746);
                    return 0;
                case 5:
                    otVar.vVT = aVar3.BTU.readString();
                    AppMethodBeat.o(56746);
                    return 0;
                case 6:
                    otVar.pPH = aVar3.BTU.readString();
                    AppMethodBeat.o(56746);
                    return 0;
                case 7:
                    otVar.pPI = aVar3.BTU.readString();
                    AppMethodBeat.o(56746);
                    return 0;
                case 8:
                    otVar.pQc = aVar3.BTU.readString();
                    AppMethodBeat.o(56746);
                    return 0;
                case 9:
                    otVar.nickname = aVar3.BTU.readString();
                    AppMethodBeat.o(56746);
                    return 0;
                case 10:
                    otVar.pPw = aVar3.BTU.readString();
                    AppMethodBeat.o(56746);
                    return 0;
                default:
                    AppMethodBeat.o(56746);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56746);
            return -1;
        }
    }
}
