package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aqo extends btd {
    public int CellCount;
    public LinkedList<crt> CellList = new LinkedList();
    public String wuk;
    public String wum;
    public int wun;
    public String wuo;
    public String wup;
    public String wuq;

    public aqo() {
        AppMethodBeat.i(28505);
        AppMethodBeat.o(28505);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28506);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(28506);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.CellCount);
            aVar.e(3, 8, this.CellList);
            if (this.wum != null) {
                aVar.e(4, this.wum);
            }
            if (this.wuk != null) {
                aVar.e(5, this.wuk);
            }
            aVar.iz(6, this.wun);
            if (this.wuo != null) {
                aVar.e(7, this.wuo);
            }
            if (this.wup != null) {
                aVar.e(8, this.wup);
            }
            if (this.wuq != null) {
                aVar.e(9, this.wuq);
            }
            AppMethodBeat.o(28506);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + e.a.a.b.b.a.bs(2, this.CellCount)) + e.a.a.a.c(3, 8, this.CellList);
            if (this.wum != null) {
                ix += e.a.a.b.b.a.f(4, this.wum);
            }
            if (this.wuk != null) {
                ix += e.a.a.b.b.a.f(5, this.wuk);
            }
            ix += e.a.a.b.b.a.bs(6, this.wun);
            if (this.wuo != null) {
                ix += e.a.a.b.b.a.f(7, this.wuo);
            }
            if (this.wup != null) {
                ix += e.a.a.b.b.a.f(8, this.wup);
            }
            if (this.wuq != null) {
                ix += e.a.a.b.b.a.f(9, this.wuq);
            }
            AppMethodBeat.o(28506);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.CellList.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(28506);
                throw bVar;
            }
            AppMethodBeat.o(28506);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aqo aqo = (aqo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
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
                        aqo.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(28506);
                    return 0;
                case 2:
                    aqo.CellCount = aVar3.BTU.vd();
                    AppMethodBeat.o(28506);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        crt crt = new crt();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = crt.populateBuilderWithField(aVar4, crt, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        aqo.CellList.add(crt);
                    }
                    AppMethodBeat.o(28506);
                    return 0;
                case 4:
                    aqo.wum = aVar3.BTU.readString();
                    AppMethodBeat.o(28506);
                    return 0;
                case 5:
                    aqo.wuk = aVar3.BTU.readString();
                    AppMethodBeat.o(28506);
                    return 0;
                case 6:
                    aqo.wun = aVar3.BTU.vd();
                    AppMethodBeat.o(28506);
                    return 0;
                case 7:
                    aqo.wuo = aVar3.BTU.readString();
                    AppMethodBeat.o(28506);
                    return 0;
                case 8:
                    aqo.wup = aVar3.BTU.readString();
                    AppMethodBeat.o(28506);
                    return 0;
                case 9:
                    aqo.wuq = aVar3.BTU.readString();
                    AppMethodBeat.o(28506);
                    return 0;
                default:
                    AppMethodBeat.o(28506);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28506);
            return -1;
        }
    }
}
