package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class avz extends btd {
    public String guQ;
    public String vAN;
    public String vBa;
    public avi wzH;
    public String wzN;
    public String wzO;
    public String wzP;
    public int wzQ;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(96261);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(96261);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.wzH != null) {
                aVar.iy(2, this.wzH.computeSize());
                this.wzH.writeFields(aVar);
            }
            if (this.wzO != null) {
                aVar.e(3, this.wzO);
            }
            if (this.vBa != null) {
                aVar.e(4, this.vBa);
            }
            if (this.vAN != null) {
                aVar.e(5, this.vAN);
            }
            if (this.wzP != null) {
                aVar.e(6, this.wzP);
            }
            aVar.iz(7, this.wzQ);
            if (this.wzN != null) {
                aVar.e(8, this.wzN);
            }
            if (this.guQ != null) {
                aVar.e(9, this.guQ);
            }
            AppMethodBeat.o(96261);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wzH != null) {
                ix += e.a.a.a.ix(2, this.wzH.computeSize());
            }
            if (this.wzO != null) {
                ix += e.a.a.b.b.a.f(3, this.wzO);
            }
            if (this.vBa != null) {
                ix += e.a.a.b.b.a.f(4, this.vBa);
            }
            if (this.vAN != null) {
                ix += e.a.a.b.b.a.f(5, this.vAN);
            }
            if (this.wzP != null) {
                ix += e.a.a.b.b.a.f(6, this.wzP);
            }
            ix += e.a.a.b.b.a.bs(7, this.wzQ);
            if (this.wzN != null) {
                ix += e.a.a.b.b.a.f(8, this.wzN);
            }
            if (this.guQ != null) {
                ix += e.a.a.b.b.a.f(9, this.guQ);
            }
            AppMethodBeat.o(96261);
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
                AppMethodBeat.o(96261);
                throw bVar;
            }
            AppMethodBeat.o(96261);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            avz avz = (avz) objArr[1];
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
                        avz.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(96261);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        avi avi = new avi();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = avi.populateBuilderWithField(aVar4, avi, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        avz.wzH = avi;
                    }
                    AppMethodBeat.o(96261);
                    return 0;
                case 3:
                    avz.wzO = aVar3.BTU.readString();
                    AppMethodBeat.o(96261);
                    return 0;
                case 4:
                    avz.vBa = aVar3.BTU.readString();
                    AppMethodBeat.o(96261);
                    return 0;
                case 5:
                    avz.vAN = aVar3.BTU.readString();
                    AppMethodBeat.o(96261);
                    return 0;
                case 6:
                    avz.wzP = aVar3.BTU.readString();
                    AppMethodBeat.o(96261);
                    return 0;
                case 7:
                    avz.wzQ = aVar3.BTU.vd();
                    AppMethodBeat.o(96261);
                    return 0;
                case 8:
                    avz.wzN = aVar3.BTU.readString();
                    AppMethodBeat.o(96261);
                    return 0;
                case 9:
                    avz.guQ = aVar3.BTU.readString();
                    AppMethodBeat.o(96261);
                    return 0;
                default:
                    AppMethodBeat.o(96261);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96261);
            return -1;
        }
    }
}
