package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cas extends btd {
    public String vEA;
    public LinkedList<cbf> vKB = new LinkedList();
    public int wGG;
    public String wZT;
    public int wZX;
    public int wZY;
    public cbw wZZ;

    public cas() {
        AppMethodBeat.i(94568);
        AppMethodBeat.o(94568);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94569);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(94569);
                throw bVar;
            } else if (this.wZZ == null) {
                bVar = new b("Not all required fields were included: ServerConfig");
                AppMethodBeat.o(94569);
                throw bVar;
            } else {
                if (this.BaseResponse != null) {
                    aVar.iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                if (this.wZT != null) {
                    aVar.e(2, this.wZT);
                }
                aVar.iz(3, this.wGG);
                aVar.e(4, 8, this.vKB);
                aVar.iz(5, this.wZX);
                if (this.vEA != null) {
                    aVar.e(6, this.vEA);
                }
                aVar.iz(7, this.wZY);
                if (this.wZZ != null) {
                    aVar.iy(8, this.wZZ.computeSize());
                    this.wZZ.writeFields(aVar);
                }
                AppMethodBeat.o(94569);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wZT != null) {
                ix += e.a.a.b.b.a.f(2, this.wZT);
            }
            ix = ((ix + e.a.a.b.b.a.bs(3, this.wGG)) + e.a.a.a.c(4, 8, this.vKB)) + e.a.a.b.b.a.bs(5, this.wZX);
            if (this.vEA != null) {
                ix += e.a.a.b.b.a.f(6, this.vEA);
            }
            ix += e.a.a.b.b.a.bs(7, this.wZY);
            if (this.wZZ != null) {
                ix += e.a.a.a.ix(8, this.wZZ.computeSize());
            }
            AppMethodBeat.o(94569);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vKB.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(94569);
                throw bVar;
            } else if (this.wZZ == null) {
                bVar = new b("Not all required fields were included: ServerConfig");
                AppMethodBeat.o(94569);
                throw bVar;
            } else {
                AppMethodBeat.o(94569);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cas cas = (cas) objArr[1];
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
                        cas.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(94569);
                    return 0;
                case 2:
                    cas.wZT = aVar3.BTU.readString();
                    AppMethodBeat.o(94569);
                    return 0;
                case 3:
                    cas.wGG = aVar3.BTU.vd();
                    AppMethodBeat.o(94569);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cbf cbf = new cbf();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cbf.populateBuilderWithField(aVar4, cbf, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cas.vKB.add(cbf);
                    }
                    AppMethodBeat.o(94569);
                    return 0;
                case 5:
                    cas.wZX = aVar3.BTU.vd();
                    AppMethodBeat.o(94569);
                    return 0;
                case 6:
                    cas.vEA = aVar3.BTU.readString();
                    AppMethodBeat.o(94569);
                    return 0;
                case 7:
                    cas.wZY = aVar3.BTU.vd();
                    AppMethodBeat.o(94569);
                    return 0;
                case 8:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cbw cbw = new cbw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cbw.populateBuilderWithField(aVar4, cbw, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cas.wZZ = cbw;
                    }
                    AppMethodBeat.o(94569);
                    return 0;
                default:
                    AppMethodBeat.o(94569);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94569);
            return -1;
        }
    }
}
