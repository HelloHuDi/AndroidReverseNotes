package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aes extends btd {
    public gj mzh;
    public int vAO;
    public int vAS;
    public String vAT;
    public bzt vAU;
    public int vBc;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28416);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(28416);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.vAS);
            aVar.iz(3, this.vBc);
            if (this.vAT != null) {
                aVar.e(4, this.vAT);
            }
            if (this.vAU != null) {
                aVar.iy(5, this.vAU.computeSize());
                this.vAU.writeFields(aVar);
            }
            if (this.mzh != null) {
                aVar.iy(6, this.mzh.computeSize());
                this.mzh.writeFields(aVar);
            }
            aVar.iz(7, this.vAO);
            AppMethodBeat.o(28416);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + e.a.a.b.b.a.bs(2, this.vAS)) + e.a.a.b.b.a.bs(3, this.vBc);
            if (this.vAT != null) {
                ix += e.a.a.b.b.a.f(4, this.vAT);
            }
            if (this.vAU != null) {
                ix += e.a.a.a.ix(5, this.vAU.computeSize());
            }
            if (this.mzh != null) {
                ix += e.a.a.a.ix(6, this.mzh.computeSize());
            }
            int bs = ix + e.a.a.b.b.a.bs(7, this.vAO);
            AppMethodBeat.o(28416);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(28416);
                throw bVar;
            }
            AppMethodBeat.o(28416);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aes aes = (aes) objArr[1];
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
                        aes.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(28416);
                    return 0;
                case 2:
                    aes.vAS = aVar3.BTU.vd();
                    AppMethodBeat.o(28416);
                    return 0;
                case 3:
                    aes.vBc = aVar3.BTU.vd();
                    AppMethodBeat.o(28416);
                    return 0;
                case 4:
                    aes.vAT = aVar3.BTU.readString();
                    AppMethodBeat.o(28416);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bzt bzt = new bzt();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bzt.populateBuilderWithField(aVar4, bzt, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        aes.vAU = bzt;
                    }
                    AppMethodBeat.o(28416);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        gj gjVar = new gj();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = gjVar.populateBuilderWithField(aVar4, gjVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        aes.mzh = gjVar;
                    }
                    AppMethodBeat.o(28416);
                    return 0;
                case 7:
                    aes.vAO = aVar3.BTU.vd();
                    AppMethodBeat.o(28416);
                    return 0;
                default:
                    AppMethodBeat.o(28416);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28416);
            return -1;
        }
    }
}
