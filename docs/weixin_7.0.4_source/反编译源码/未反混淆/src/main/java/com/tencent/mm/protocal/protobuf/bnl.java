package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bnl extends btd {
    public int kdT;
    public String kdU;
    public LinkedList<bir> vAD = new LinkedList();
    public long vYi;
    public long vYj;
    public bdh wQl;
    public atj wci;
    public chl woi;
    public mu wpq;
    public btn wxm;

    public bnl() {
        AppMethodBeat.i(48935);
        AppMethodBeat.o(48935);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48936);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(48936);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.kdT);
            if (this.kdU != null) {
                aVar.e(3, this.kdU);
            }
            if (this.wci != null) {
                aVar.iy(4, this.wci.computeSize());
                this.wci.writeFields(aVar);
            }
            aVar.e(5, 8, this.vAD);
            aVar.ai(6, this.vYi);
            aVar.ai(7, this.vYj);
            if (this.wxm != null) {
                aVar.iy(8, this.wxm.computeSize());
                this.wxm.writeFields(aVar);
            }
            if (this.wpq != null) {
                aVar.iy(9, this.wpq.computeSize());
                this.wpq.writeFields(aVar);
            }
            if (this.woi != null) {
                aVar.iy(10, this.woi.computeSize());
                this.woi.writeFields(aVar);
            }
            if (this.wQl != null) {
                aVar.iy(11, this.wQl.computeSize());
                this.wQl.writeFields(aVar);
            }
            AppMethodBeat.o(48936);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.bs(2, this.kdT);
            if (this.kdU != null) {
                ix += e.a.a.b.b.a.f(3, this.kdU);
            }
            if (this.wci != null) {
                ix += e.a.a.a.ix(4, this.wci.computeSize());
            }
            ix = ((ix + e.a.a.a.c(5, 8, this.vAD)) + e.a.a.b.b.a.o(6, this.vYi)) + e.a.a.b.b.a.o(7, this.vYj);
            if (this.wxm != null) {
                ix += e.a.a.a.ix(8, this.wxm.computeSize());
            }
            if (this.wpq != null) {
                ix += e.a.a.a.ix(9, this.wpq.computeSize());
            }
            if (this.woi != null) {
                ix += e.a.a.a.ix(10, this.woi.computeSize());
            }
            if (this.wQl != null) {
                ix += e.a.a.a.ix(11, this.wQl.computeSize());
            }
            AppMethodBeat.o(48936);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vAD.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(48936);
                throw bVar;
            }
            AppMethodBeat.o(48936);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bnl bnl = (bnl) objArr[1];
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
                        bnl.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(48936);
                    return 0;
                case 2:
                    bnl.kdT = aVar3.BTU.vd();
                    AppMethodBeat.o(48936);
                    return 0;
                case 3:
                    bnl.kdU = aVar3.BTU.readString();
                    AppMethodBeat.o(48936);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        atj atj = new atj();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = atj.populateBuilderWithField(aVar4, atj, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bnl.wci = atj;
                    }
                    AppMethodBeat.o(48936);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bir bir = new bir();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bir.populateBuilderWithField(aVar4, bir, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bnl.vAD.add(bir);
                    }
                    AppMethodBeat.o(48936);
                    return 0;
                case 6:
                    bnl.vYi = aVar3.BTU.ve();
                    AppMethodBeat.o(48936);
                    return 0;
                case 7:
                    bnl.vYj = aVar3.BTU.ve();
                    AppMethodBeat.o(48936);
                    return 0;
                case 8:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        btn btn = new btn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = btn.populateBuilderWithField(aVar4, btn, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bnl.wxm = btn;
                    }
                    AppMethodBeat.o(48936);
                    return 0;
                case 9:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        mu muVar = new mu();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = muVar.populateBuilderWithField(aVar4, muVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bnl.wpq = muVar;
                    }
                    AppMethodBeat.o(48936);
                    return 0;
                case 10:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        chl chl = new chl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = chl.populateBuilderWithField(aVar4, chl, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bnl.woi = chl;
                    }
                    AppMethodBeat.o(48936);
                    return 0;
                case 11:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bdh bdh = new bdh();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bdh.populateBuilderWithField(aVar4, bdh, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bnl.wQl = bdh;
                    }
                    AppMethodBeat.o(48936);
                    return 0;
                default:
                    AppMethodBeat.o(48936);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48936);
            return -1;
        }
    }
}
