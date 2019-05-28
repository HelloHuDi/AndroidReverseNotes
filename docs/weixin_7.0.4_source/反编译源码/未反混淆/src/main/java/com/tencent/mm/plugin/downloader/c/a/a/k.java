package com.tencent.mm.plugin.downloader.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.btd;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class k extends btd {
    public int kKC;
    public String kKD;
    public d kKy;
    public int kdT;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(35520);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(35520);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.kKy != null) {
                aVar.iy(2, this.kKy.computeSize());
                this.kKy.writeFields(aVar);
            }
            aVar.iz(3, this.kdT);
            aVar.iz(4, this.kKC);
            if (this.kKD != null) {
                aVar.e(5, this.kKD);
            }
            AppMethodBeat.o(35520);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.kKy != null) {
                ix += e.a.a.a.ix(2, this.kKy.computeSize());
            }
            ix = (ix + e.a.a.b.b.a.bs(3, this.kdT)) + e.a.a.b.b.a.bs(4, this.kKC);
            if (this.kKD != null) {
                ix += e.a.a.b.b.a.f(5, this.kKD);
            }
            AppMethodBeat.o(35520);
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
                AppMethodBeat.o(35520);
                throw bVar;
            }
            AppMethodBeat.o(35520);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            k kVar = (k) objArr[1];
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
                        kVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(35520);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        d dVar = new d();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dVar.populateBuilderWithField(aVar4, dVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        kVar.kKy = dVar;
                    }
                    AppMethodBeat.o(35520);
                    return 0;
                case 3:
                    kVar.kdT = aVar3.BTU.vd();
                    AppMethodBeat.o(35520);
                    return 0;
                case 4:
                    kVar.kKC = aVar3.BTU.vd();
                    AppMethodBeat.o(35520);
                    return 0;
                case 5:
                    kVar.kKD = aVar3.BTU.readString();
                    AppMethodBeat.o(35520);
                    return 0;
                default:
                    AppMethodBeat.o(35520);
                    return -1;
            }
        } else {
            AppMethodBeat.o(35520);
            return -1;
        }
    }
}
