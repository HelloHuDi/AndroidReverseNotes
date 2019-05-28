package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ake extends btd {
    public int wjY;
    public String wjZ;
    public String wka;
    public int wkb;
    public String wkc;
    public String wpF;
    public String wpG;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56815);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56815);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.wpF != null) {
                aVar.e(2, this.wpF);
            }
            aVar.iz(3, this.wjY);
            if (this.wjZ != null) {
                aVar.e(4, this.wjZ);
            }
            if (this.wka != null) {
                aVar.e(5, this.wka);
            }
            aVar.iz(6, this.wkb);
            if (this.wkc != null) {
                aVar.e(7, this.wkc);
            }
            if (this.wpG != null) {
                aVar.e(8, this.wpG);
            }
            AppMethodBeat.o(56815);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wpF != null) {
                ix += e.a.a.b.b.a.f(2, this.wpF);
            }
            ix += e.a.a.b.b.a.bs(3, this.wjY);
            if (this.wjZ != null) {
                ix += e.a.a.b.b.a.f(4, this.wjZ);
            }
            if (this.wka != null) {
                ix += e.a.a.b.b.a.f(5, this.wka);
            }
            ix += e.a.a.b.b.a.bs(6, this.wkb);
            if (this.wkc != null) {
                ix += e.a.a.b.b.a.f(7, this.wkc);
            }
            if (this.wpG != null) {
                ix += e.a.a.b.b.a.f(8, this.wpG);
            }
            AppMethodBeat.o(56815);
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
                AppMethodBeat.o(56815);
                throw bVar;
            }
            AppMethodBeat.o(56815);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ake ake = (ake) objArr[1];
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
                        ake.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(56815);
                    return 0;
                case 2:
                    ake.wpF = aVar3.BTU.readString();
                    AppMethodBeat.o(56815);
                    return 0;
                case 3:
                    ake.wjY = aVar3.BTU.vd();
                    AppMethodBeat.o(56815);
                    return 0;
                case 4:
                    ake.wjZ = aVar3.BTU.readString();
                    AppMethodBeat.o(56815);
                    return 0;
                case 5:
                    ake.wka = aVar3.BTU.readString();
                    AppMethodBeat.o(56815);
                    return 0;
                case 6:
                    ake.wkb = aVar3.BTU.vd();
                    AppMethodBeat.o(56815);
                    return 0;
                case 7:
                    ake.wkc = aVar3.BTU.readString();
                    AppMethodBeat.o(56815);
                    return 0;
                case 8:
                    ake.wpG = aVar3.BTU.readString();
                    AppMethodBeat.o(56815);
                    return 0;
                default:
                    AppMethodBeat.o(56815);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56815);
            return -1;
        }
    }
}
