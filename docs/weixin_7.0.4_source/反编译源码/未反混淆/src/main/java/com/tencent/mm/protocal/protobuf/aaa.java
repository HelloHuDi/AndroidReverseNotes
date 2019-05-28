package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aaa extends btd {
    public int kCl;
    public String kCm;
    public String lvz;
    public String nSX;
    public String nUr;
    public String nUs;
    public int wfi;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56787);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56787);
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
            if (this.nSX != null) {
                aVar.e(4, this.nSX);
            }
            if (this.lvz != null) {
                aVar.e(5, this.lvz);
            }
            aVar.iz(6, this.wfi);
            if (this.nUs != null) {
                aVar.e(7, this.nUs);
            }
            if (this.nUr != null) {
                aVar.e(8, this.nUr);
            }
            AppMethodBeat.o(56787);
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
            if (this.nSX != null) {
                ix += e.a.a.b.b.a.f(4, this.nSX);
            }
            if (this.lvz != null) {
                ix += e.a.a.b.b.a.f(5, this.lvz);
            }
            ix += e.a.a.b.b.a.bs(6, this.wfi);
            if (this.nUs != null) {
                ix += e.a.a.b.b.a.f(7, this.nUs);
            }
            if (this.nUr != null) {
                ix += e.a.a.b.b.a.f(8, this.nUr);
            }
            AppMethodBeat.o(56787);
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
                AppMethodBeat.o(56787);
                throw bVar;
            }
            AppMethodBeat.o(56787);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aaa aaa = (aaa) objArr[1];
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
                        aaa.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(56787);
                    return 0;
                case 2:
                    aaa.kCl = aVar3.BTU.vd();
                    AppMethodBeat.o(56787);
                    return 0;
                case 3:
                    aaa.kCm = aVar3.BTU.readString();
                    AppMethodBeat.o(56787);
                    return 0;
                case 4:
                    aaa.nSX = aVar3.BTU.readString();
                    AppMethodBeat.o(56787);
                    return 0;
                case 5:
                    aaa.lvz = aVar3.BTU.readString();
                    AppMethodBeat.o(56787);
                    return 0;
                case 6:
                    aaa.wfi = aVar3.BTU.vd();
                    AppMethodBeat.o(56787);
                    return 0;
                case 7:
                    aaa.nUs = aVar3.BTU.readString();
                    AppMethodBeat.o(56787);
                    return 0;
                case 8:
                    aaa.nUr = aVar3.BTU.readString();
                    AppMethodBeat.o(56787);
                    return 0;
                default:
                    AppMethodBeat.o(56787);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56787);
            return -1;
        }
    }
}
