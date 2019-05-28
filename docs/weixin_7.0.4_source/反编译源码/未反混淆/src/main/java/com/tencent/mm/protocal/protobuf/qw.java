package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class qw extends btd {
    public cwg vXT;
    public boolean vXU;
    public String vXV;
    public String vXW;
    public boolean vXX;
    public String vXY;
    public String vXZ;
    public String vYa;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(96212);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(96212);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.vXT != null) {
                aVar.iy(2, this.vXT.computeSize());
                this.vXT.writeFields(aVar);
            }
            aVar.aO(3, this.vXU);
            if (this.vXV != null) {
                aVar.e(4, this.vXV);
            }
            if (this.vXW != null) {
                aVar.e(5, this.vXW);
            }
            aVar.aO(6, this.vXX);
            if (this.vXY != null) {
                aVar.e(7, this.vXY);
            }
            if (this.vXZ != null) {
                aVar.e(8, this.vXZ);
            }
            if (this.vYa != null) {
                aVar.e(9, this.vYa);
            }
            AppMethodBeat.o(96212);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vXT != null) {
                ix += e.a.a.a.ix(2, this.vXT.computeSize());
            }
            ix += e.a.a.b.b.a.fv(3) + 1;
            if (this.vXV != null) {
                ix += e.a.a.b.b.a.f(4, this.vXV);
            }
            if (this.vXW != null) {
                ix += e.a.a.b.b.a.f(5, this.vXW);
            }
            ix += e.a.a.b.b.a.fv(6) + 1;
            if (this.vXY != null) {
                ix += e.a.a.b.b.a.f(7, this.vXY);
            }
            if (this.vXZ != null) {
                ix += e.a.a.b.b.a.f(8, this.vXZ);
            }
            if (this.vYa != null) {
                ix += e.a.a.b.b.a.f(9, this.vYa);
            }
            AppMethodBeat.o(96212);
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
                AppMethodBeat.o(96212);
                throw bVar;
            }
            AppMethodBeat.o(96212);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            qw qwVar = (qw) objArr[1];
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
                        qwVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(96212);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cwg cwg = new cwg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cwg.populateBuilderWithField(aVar4, cwg, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        qwVar.vXT = cwg;
                    }
                    AppMethodBeat.o(96212);
                    return 0;
                case 3:
                    qwVar.vXU = aVar3.BTU.ehX();
                    AppMethodBeat.o(96212);
                    return 0;
                case 4:
                    qwVar.vXV = aVar3.BTU.readString();
                    AppMethodBeat.o(96212);
                    return 0;
                case 5:
                    qwVar.vXW = aVar3.BTU.readString();
                    AppMethodBeat.o(96212);
                    return 0;
                case 6:
                    qwVar.vXX = aVar3.BTU.ehX();
                    AppMethodBeat.o(96212);
                    return 0;
                case 7:
                    qwVar.vXY = aVar3.BTU.readString();
                    AppMethodBeat.o(96212);
                    return 0;
                case 8:
                    qwVar.vXZ = aVar3.BTU.readString();
                    AppMethodBeat.o(96212);
                    return 0;
                case 9:
                    qwVar.vYa = aVar3.BTU.readString();
                    AppMethodBeat.o(96212);
                    return 0;
                default:
                    AppMethodBeat.o(96212);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96212);
            return -1;
        }
    }
}
