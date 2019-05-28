package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.btd;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ay extends btd {
    public dd nbA;
    public m nbB;
    public dp nbC;
    public s nbD;
    public do nbE;
    public r nbF;
    public boolean nbv;
    public ak nbw;
    public String nbx;
    public ac nby;
    public f nbz;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(117000);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(117000);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aO(2, this.nbv);
            if (this.nbw != null) {
                aVar.iy(3, this.nbw.computeSize());
                this.nbw.writeFields(aVar);
            }
            if (this.nbx != null) {
                aVar.e(4, this.nbx);
            }
            if (this.nby != null) {
                aVar.iy(6, this.nby.computeSize());
                this.nby.writeFields(aVar);
            }
            if (this.nbz != null) {
                aVar.iy(7, this.nbz.computeSize());
                this.nbz.writeFields(aVar);
            }
            if (this.nbA != null) {
                aVar.iy(8, this.nbA.computeSize());
                this.nbA.writeFields(aVar);
            }
            if (this.nbB != null) {
                aVar.iy(11, this.nbB.computeSize());
                this.nbB.writeFields(aVar);
            }
            if (this.nbC != null) {
                aVar.iy(12, this.nbC.computeSize());
                this.nbC.writeFields(aVar);
            }
            if (this.nbD != null) {
                aVar.iy(13, this.nbD.computeSize());
                this.nbD.writeFields(aVar);
            }
            if (this.nbE != null) {
                aVar.iy(14, this.nbE.computeSize());
                this.nbE.writeFields(aVar);
            }
            if (this.nbF != null) {
                aVar.iy(15, this.nbF.computeSize());
                this.nbF.writeFields(aVar);
            }
            AppMethodBeat.o(117000);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.fv(2) + 1;
            if (this.nbw != null) {
                ix += e.a.a.a.ix(3, this.nbw.computeSize());
            }
            if (this.nbx != null) {
                ix += e.a.a.b.b.a.f(4, this.nbx);
            }
            if (this.nby != null) {
                ix += e.a.a.a.ix(6, this.nby.computeSize());
            }
            if (this.nbz != null) {
                ix += e.a.a.a.ix(7, this.nbz.computeSize());
            }
            if (this.nbA != null) {
                ix += e.a.a.a.ix(8, this.nbA.computeSize());
            }
            if (this.nbB != null) {
                ix += e.a.a.a.ix(11, this.nbB.computeSize());
            }
            if (this.nbC != null) {
                ix += e.a.a.a.ix(12, this.nbC.computeSize());
            }
            if (this.nbD != null) {
                ix += e.a.a.a.ix(13, this.nbD.computeSize());
            }
            if (this.nbE != null) {
                ix += e.a.a.a.ix(14, this.nbE.computeSize());
            }
            if (this.nbF != null) {
                ix += e.a.a.a.ix(15, this.nbF.computeSize());
            }
            AppMethodBeat.o(117000);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(117000);
                throw bVar;
            }
            AppMethodBeat.o(117000);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ay ayVar = (ay) objArr[1];
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
                        BaseResponse baseResponse = new BaseResponse();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = baseResponse.populateBuilderWithField(aVar4, baseResponse, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ayVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(117000);
                    return 0;
                case 2:
                    ayVar.nbv = aVar3.BTU.ehX();
                    AppMethodBeat.o(117000);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ak akVar = new ak();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = akVar.populateBuilderWithField(aVar4, akVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ayVar.nbw = akVar;
                    }
                    AppMethodBeat.o(117000);
                    return 0;
                case 4:
                    ayVar.nbx = aVar3.BTU.readString();
                    AppMethodBeat.o(117000);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ac acVar = new ac();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = acVar.populateBuilderWithField(aVar4, acVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ayVar.nby = acVar;
                    }
                    AppMethodBeat.o(117000);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        f fVar = new f();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fVar.populateBuilderWithField(aVar4, fVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ayVar.nbz = fVar;
                    }
                    AppMethodBeat.o(117000);
                    return 0;
                case 8:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        dd ddVar = new dd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ddVar.populateBuilderWithField(aVar4, ddVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ayVar.nbA = ddVar;
                    }
                    AppMethodBeat.o(117000);
                    return 0;
                case 11:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        m mVar = new m();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = mVar.populateBuilderWithField(aVar4, mVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ayVar.nbB = mVar;
                    }
                    AppMethodBeat.o(117000);
                    return 0;
                case 12:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        dp dpVar = new dp();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dpVar.populateBuilderWithField(aVar4, dpVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ayVar.nbC = dpVar;
                    }
                    AppMethodBeat.o(117000);
                    return 0;
                case 13:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        s sVar = new s();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sVar.populateBuilderWithField(aVar4, sVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ayVar.nbD = sVar;
                    }
                    AppMethodBeat.o(117000);
                    return 0;
                case 14:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        do doVar = new do();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = doVar.populateBuilderWithField(aVar4, doVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ayVar.nbE = doVar;
                    }
                    AppMethodBeat.o(117000);
                    return 0;
                case 15:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        r rVar = new r();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = rVar.populateBuilderWithField(aVar4, rVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ayVar.nbF = rVar;
                    }
                    AppMethodBeat.o(117000);
                    return 0;
                default:
                    AppMethodBeat.o(117000);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117000);
            return -1;
        }
    }
}
