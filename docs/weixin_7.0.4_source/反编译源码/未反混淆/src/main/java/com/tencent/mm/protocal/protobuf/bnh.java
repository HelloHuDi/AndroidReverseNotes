package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bnh extends btd {
    public String kbV;
    public int kdT;
    public String kdU;
    public String pbn;
    public String pbo;
    public String wQf;
    public String wQg;
    public nc wQh;
    public String wQi;
    public String wQj;
    public cif wQk;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48931);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(48931);
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
            if (this.wQf != null) {
                aVar.e(4, this.wQf);
            }
            if (this.kbV != null) {
                aVar.e(5, this.kbV);
            }
            if (this.wQg != null) {
                aVar.e(6, this.wQg);
            }
            if (this.wQh != null) {
                aVar.iy(7, this.wQh.computeSize());
                this.wQh.writeFields(aVar);
            }
            if (this.wQi != null) {
                aVar.e(8, this.wQi);
            }
            if (this.pbo != null) {
                aVar.e(9, this.pbo);
            }
            if (this.pbn != null) {
                aVar.e(10, this.pbn);
            }
            if (this.wQj != null) {
                aVar.e(11, this.wQj);
            }
            if (this.wQk != null) {
                aVar.iy(12, this.wQk.computeSize());
                this.wQk.writeFields(aVar);
            }
            AppMethodBeat.o(48931);
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
            if (this.wQf != null) {
                ix += e.a.a.b.b.a.f(4, this.wQf);
            }
            if (this.kbV != null) {
                ix += e.a.a.b.b.a.f(5, this.kbV);
            }
            if (this.wQg != null) {
                ix += e.a.a.b.b.a.f(6, this.wQg);
            }
            if (this.wQh != null) {
                ix += e.a.a.a.ix(7, this.wQh.computeSize());
            }
            if (this.wQi != null) {
                ix += e.a.a.b.b.a.f(8, this.wQi);
            }
            if (this.pbo != null) {
                ix += e.a.a.b.b.a.f(9, this.pbo);
            }
            if (this.pbn != null) {
                ix += e.a.a.b.b.a.f(10, this.pbn);
            }
            if (this.wQj != null) {
                ix += e.a.a.b.b.a.f(11, this.wQj);
            }
            if (this.wQk != null) {
                ix += e.a.a.a.ix(12, this.wQk.computeSize());
            }
            AppMethodBeat.o(48931);
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
                AppMethodBeat.o(48931);
                throw bVar;
            }
            AppMethodBeat.o(48931);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bnh bnh = (bnh) objArr[1];
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
                        bnh.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(48931);
                    return 0;
                case 2:
                    bnh.kdT = aVar3.BTU.vd();
                    AppMethodBeat.o(48931);
                    return 0;
                case 3:
                    bnh.kdU = aVar3.BTU.readString();
                    AppMethodBeat.o(48931);
                    return 0;
                case 4:
                    bnh.wQf = aVar3.BTU.readString();
                    AppMethodBeat.o(48931);
                    return 0;
                case 5:
                    bnh.kbV = aVar3.BTU.readString();
                    AppMethodBeat.o(48931);
                    return 0;
                case 6:
                    bnh.wQg = aVar3.BTU.readString();
                    AppMethodBeat.o(48931);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        nc ncVar = new nc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ncVar.populateBuilderWithField(aVar4, ncVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bnh.wQh = ncVar;
                    }
                    AppMethodBeat.o(48931);
                    return 0;
                case 8:
                    bnh.wQi = aVar3.BTU.readString();
                    AppMethodBeat.o(48931);
                    return 0;
                case 9:
                    bnh.pbo = aVar3.BTU.readString();
                    AppMethodBeat.o(48931);
                    return 0;
                case 10:
                    bnh.pbn = aVar3.BTU.readString();
                    AppMethodBeat.o(48931);
                    return 0;
                case 11:
                    bnh.wQj = aVar3.BTU.readString();
                    AppMethodBeat.o(48931);
                    return 0;
                case 12:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cif cif = new cif();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cif.populateBuilderWithField(aVar4, cif, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bnh.wQk = cif;
                    }
                    AppMethodBeat.o(48931);
                    return 0;
                default:
                    AppMethodBeat.o(48931);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48931);
            return -1;
        }
    }
}
