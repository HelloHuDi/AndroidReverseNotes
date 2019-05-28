package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bof extends btd {
    public int kCl;
    public String kCm;
    public String vHs;
    public LinkedList<cio> wRf = new LinkedList();
    public LinkedList<cio> wRg = new LinkedList();

    public bof() {
        AppMethodBeat.i(48945);
        AppMethodBeat.o(48945);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48946);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(48946);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.kCl);
            if (this.kCm != null) {
                aVar.e(3, this.kCm);
            }
            aVar.e(4, 8, this.wRf);
            aVar.e(5, 8, this.wRg);
            if (this.vHs != null) {
                aVar.e(6, this.vHs);
            }
            AppMethodBeat.o(48946);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.bs(2, this.kCl);
            if (this.kCm != null) {
                ix += e.a.a.b.b.a.f(3, this.kCm);
            }
            ix = (ix + e.a.a.a.c(4, 8, this.wRf)) + e.a.a.a.c(5, 8, this.wRg);
            if (this.vHs != null) {
                ix += e.a.a.b.b.a.f(6, this.vHs);
            }
            AppMethodBeat.o(48946);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wRf.clear();
            this.wRg.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(48946);
                throw bVar;
            }
            AppMethodBeat.o(48946);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bof bof = (bof) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            cio cio;
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
                        bof.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(48946);
                    return 0;
                case 2:
                    bof.kCl = aVar3.BTU.vd();
                    AppMethodBeat.o(48946);
                    return 0;
                case 3:
                    bof.kCm = aVar3.BTU.readString();
                    AppMethodBeat.o(48946);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cio = new cio();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cio.populateBuilderWithField(aVar4, cio, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bof.wRf.add(cio);
                    }
                    AppMethodBeat.o(48946);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cio = new cio();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cio.populateBuilderWithField(aVar4, cio, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bof.wRg.add(cio);
                    }
                    AppMethodBeat.o(48946);
                    return 0;
                case 6:
                    bof.vHs = aVar3.BTU.readString();
                    AppMethodBeat.o(48946);
                    return 0;
                default:
                    AppMethodBeat.o(48946);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48946);
            return -1;
        }
    }
}
