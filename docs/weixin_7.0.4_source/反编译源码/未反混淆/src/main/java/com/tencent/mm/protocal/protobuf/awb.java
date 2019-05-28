package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class awb extends btd {
    public String guQ;
    public String ncH;
    public String vAN;
    public String vBa;
    public String vDm;
    public LinkedList<buj> wlE = new LinkedList();
    public avi wzH;
    public String wzN;
    public String wzO;
    public String wzP;
    public int wzQ;

    public awb() {
        AppMethodBeat.i(96264);
        AppMethodBeat.o(96264);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(96265);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(96265);
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
            aVar.e(4, 8, this.wlE);
            if (this.ncH != null) {
                aVar.e(5, this.ncH);
            }
            if (this.vDm != null) {
                aVar.e(6, this.vDm);
            }
            if (this.vBa != null) {
                aVar.e(7, this.vBa);
            }
            if (this.vAN != null) {
                aVar.e(8, this.vAN);
            }
            if (this.wzP != null) {
                aVar.e(9, this.wzP);
            }
            aVar.iz(10, this.wzQ);
            if (this.wzN != null) {
                aVar.e(11, this.wzN);
            }
            if (this.guQ != null) {
                aVar.e(12, this.guQ);
            }
            AppMethodBeat.o(96265);
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
            ix += e.a.a.a.c(4, 8, this.wlE);
            if (this.ncH != null) {
                ix += e.a.a.b.b.a.f(5, this.ncH);
            }
            if (this.vDm != null) {
                ix += e.a.a.b.b.a.f(6, this.vDm);
            }
            if (this.vBa != null) {
                ix += e.a.a.b.b.a.f(7, this.vBa);
            }
            if (this.vAN != null) {
                ix += e.a.a.b.b.a.f(8, this.vAN);
            }
            if (this.wzP != null) {
                ix += e.a.a.b.b.a.f(9, this.wzP);
            }
            ix += e.a.a.b.b.a.bs(10, this.wzQ);
            if (this.wzN != null) {
                ix += e.a.a.b.b.a.f(11, this.wzN);
            }
            if (this.guQ != null) {
                ix += e.a.a.b.b.a.f(12, this.guQ);
            }
            AppMethodBeat.o(96265);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wlE.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(96265);
                throw bVar;
            }
            AppMethodBeat.o(96265);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            awb awb = (awb) objArr[1];
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
                        awb.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(96265);
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
                        awb.wzH = avi;
                    }
                    AppMethodBeat.o(96265);
                    return 0;
                case 3:
                    awb.wzO = aVar3.BTU.readString();
                    AppMethodBeat.o(96265);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        buj buj = new buj();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = buj.populateBuilderWithField(aVar4, buj, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        awb.wlE.add(buj);
                    }
                    AppMethodBeat.o(96265);
                    return 0;
                case 5:
                    awb.ncH = aVar3.BTU.readString();
                    AppMethodBeat.o(96265);
                    return 0;
                case 6:
                    awb.vDm = aVar3.BTU.readString();
                    AppMethodBeat.o(96265);
                    return 0;
                case 7:
                    awb.vBa = aVar3.BTU.readString();
                    AppMethodBeat.o(96265);
                    return 0;
                case 8:
                    awb.vAN = aVar3.BTU.readString();
                    AppMethodBeat.o(96265);
                    return 0;
                case 9:
                    awb.wzP = aVar3.BTU.readString();
                    AppMethodBeat.o(96265);
                    return 0;
                case 10:
                    awb.wzQ = aVar3.BTU.vd();
                    AppMethodBeat.o(96265);
                    return 0;
                case 11:
                    awb.wzN = aVar3.BTU.readString();
                    AppMethodBeat.o(96265);
                    return 0;
                case 12:
                    awb.guQ = aVar3.BTU.readString();
                    AppMethodBeat.o(96265);
                    return 0;
                default:
                    AppMethodBeat.o(96265);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96265);
            return -1;
        }
    }
}
