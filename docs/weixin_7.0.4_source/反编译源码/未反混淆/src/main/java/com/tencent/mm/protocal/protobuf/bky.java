package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bky extends btd {
    public String content;
    public String kdE;
    public boolean kep;
    public int status;
    public String vBF;
    public String vBG;
    public String wNR;
    public String wNS;
    public String wNT;
    public String wNU;
    public String wNV;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(89122);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.vBF != null) {
                aVar.e(2, this.vBF);
            }
            if (this.vBG != null) {
                aVar.e(3, this.vBG);
            }
            aVar.iz(4, this.status);
            if (this.content != null) {
                aVar.e(5, this.content);
            }
            if (this.kdE != null) {
                aVar.e(6, this.kdE);
            }
            if (this.wNR != null) {
                aVar.e(7, this.wNR);
            }
            aVar.aO(8, this.kep);
            if (this.wNS != null) {
                aVar.e(9, this.wNS);
            }
            if (this.wNT != null) {
                aVar.e(10, this.wNT);
            }
            if (this.wNU != null) {
                aVar.e(11, this.wNU);
            }
            if (this.wNV != null) {
                aVar.e(12, this.wNV);
            }
            AppMethodBeat.o(89122);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vBF != null) {
                ix += e.a.a.b.b.a.f(2, this.vBF);
            }
            if (this.vBG != null) {
                ix += e.a.a.b.b.a.f(3, this.vBG);
            }
            ix += e.a.a.b.b.a.bs(4, this.status);
            if (this.content != null) {
                ix += e.a.a.b.b.a.f(5, this.content);
            }
            if (this.kdE != null) {
                ix += e.a.a.b.b.a.f(6, this.kdE);
            }
            if (this.wNR != null) {
                ix += e.a.a.b.b.a.f(7, this.wNR);
            }
            ix += e.a.a.b.b.a.fv(8) + 1;
            if (this.wNS != null) {
                ix += e.a.a.b.b.a.f(9, this.wNS);
            }
            if (this.wNT != null) {
                ix += e.a.a.b.b.a.f(10, this.wNT);
            }
            if (this.wNU != null) {
                ix += e.a.a.b.b.a.f(11, this.wNU);
            }
            if (this.wNV != null) {
                ix += e.a.a.b.b.a.f(12, this.wNV);
            }
            AppMethodBeat.o(89122);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(89122);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bky bky = (bky) objArr[1];
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
                        bky.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(89122);
                    return 0;
                case 2:
                    bky.vBF = aVar3.BTU.readString();
                    AppMethodBeat.o(89122);
                    return 0;
                case 3:
                    bky.vBG = aVar3.BTU.readString();
                    AppMethodBeat.o(89122);
                    return 0;
                case 4:
                    bky.status = aVar3.BTU.vd();
                    AppMethodBeat.o(89122);
                    return 0;
                case 5:
                    bky.content = aVar3.BTU.readString();
                    AppMethodBeat.o(89122);
                    return 0;
                case 6:
                    bky.kdE = aVar3.BTU.readString();
                    AppMethodBeat.o(89122);
                    return 0;
                case 7:
                    bky.wNR = aVar3.BTU.readString();
                    AppMethodBeat.o(89122);
                    return 0;
                case 8:
                    bky.kep = aVar3.BTU.ehX();
                    AppMethodBeat.o(89122);
                    return 0;
                case 9:
                    bky.wNS = aVar3.BTU.readString();
                    AppMethodBeat.o(89122);
                    return 0;
                case 10:
                    bky.wNT = aVar3.BTU.readString();
                    AppMethodBeat.o(89122);
                    return 0;
                case 11:
                    bky.wNU = aVar3.BTU.readString();
                    AppMethodBeat.o(89122);
                    return 0;
                case 12:
                    bky.wNV = aVar3.BTU.readString();
                    AppMethodBeat.o(89122);
                    return 0;
                default:
                    AppMethodBeat.o(89122);
                    return -1;
            }
        } else {
            AppMethodBeat.o(89122);
            return -1;
        }
    }
}
