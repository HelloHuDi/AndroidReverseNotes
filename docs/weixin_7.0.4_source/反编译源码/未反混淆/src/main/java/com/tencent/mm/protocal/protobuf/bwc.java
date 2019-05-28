package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bwc extends btd {
    public String fKh;
    public int jCt;
    public String ndF;
    public String ndG;
    public int pcX;
    public int ptD;
    public long ptF;
    public String vFF;
    public String vRw;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28630);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(28630);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.fKh != null) {
                aVar.e(2, this.fKh);
            }
            if (this.ndG != null) {
                aVar.e(3, this.ndG);
            }
            if (this.ndF != null) {
                aVar.e(4, this.ndF);
            }
            aVar.iz(5, this.ptD);
            if (this.vFF != null) {
                aVar.e(6, this.vFF);
            }
            aVar.iz(7, this.pcX);
            aVar.iz(8, this.jCt);
            aVar.ai(9, this.ptF);
            if (this.vRw != null) {
                aVar.e(10, this.vRw);
            }
            AppMethodBeat.o(28630);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.fKh != null) {
                ix += e.a.a.b.b.a.f(2, this.fKh);
            }
            if (this.ndG != null) {
                ix += e.a.a.b.b.a.f(3, this.ndG);
            }
            if (this.ndF != null) {
                ix += e.a.a.b.b.a.f(4, this.ndF);
            }
            ix += e.a.a.b.b.a.bs(5, this.ptD);
            if (this.vFF != null) {
                ix += e.a.a.b.b.a.f(6, this.vFF);
            }
            ix = ((ix + e.a.a.b.b.a.bs(7, this.pcX)) + e.a.a.b.b.a.bs(8, this.jCt)) + e.a.a.b.b.a.o(9, this.ptF);
            if (this.vRw != null) {
                ix += e.a.a.b.b.a.f(10, this.vRw);
            }
            AppMethodBeat.o(28630);
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
                AppMethodBeat.o(28630);
                throw bVar;
            }
            AppMethodBeat.o(28630);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bwc bwc = (bwc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        BaseResponse baseResponse = new BaseResponse();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = baseResponse.populateBuilderWithField(aVar4, baseResponse, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bwc.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(28630);
                    return 0;
                case 2:
                    bwc.fKh = aVar3.BTU.readString();
                    AppMethodBeat.o(28630);
                    return 0;
                case 3:
                    bwc.ndG = aVar3.BTU.readString();
                    AppMethodBeat.o(28630);
                    return 0;
                case 4:
                    bwc.ndF = aVar3.BTU.readString();
                    AppMethodBeat.o(28630);
                    return 0;
                case 5:
                    bwc.ptD = aVar3.BTU.vd();
                    AppMethodBeat.o(28630);
                    return 0;
                case 6:
                    bwc.vFF = aVar3.BTU.readString();
                    AppMethodBeat.o(28630);
                    return 0;
                case 7:
                    bwc.pcX = aVar3.BTU.vd();
                    AppMethodBeat.o(28630);
                    return 0;
                case 8:
                    bwc.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(28630);
                    return 0;
                case 9:
                    bwc.ptF = aVar3.BTU.ve();
                    AppMethodBeat.o(28630);
                    return 0;
                case 10:
                    bwc.vRw = aVar3.BTU.readString();
                    AppMethodBeat.o(28630);
                    return 0;
                default:
                    AppMethodBeat.o(28630);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28630);
            return -1;
        }
    }
}
