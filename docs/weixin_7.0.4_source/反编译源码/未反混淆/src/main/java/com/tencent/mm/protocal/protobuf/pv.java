package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class pv extends btd {
    public String desc;
    public int kCl;
    public String kCm;
    public String pOy;
    public String vWr;
    public int vWs;
    public LinkedList<Integer> vWt = new LinkedList();
    public int vWw;

    public pv() {
        AppMethodBeat.i(48808);
        AppMethodBeat.o(48808);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48809);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(48809);
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
            if (this.pOy != null) {
                aVar.e(4, this.pOy);
            }
            if (this.vWr != null) {
                aVar.e(5, this.vWr);
            }
            aVar.iz(6, this.vWs);
            aVar.e(7, 2, this.vWt);
            if (this.desc != null) {
                aVar.e(8, this.desc);
            }
            aVar.iz(9, this.vWw);
            AppMethodBeat.o(48809);
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
            if (this.pOy != null) {
                ix += e.a.a.b.b.a.f(4, this.pOy);
            }
            if (this.vWr != null) {
                ix += e.a.a.b.b.a.f(5, this.vWr);
            }
            ix = (ix + e.a.a.b.b.a.bs(6, this.vWs)) + e.a.a.a.c(7, 2, this.vWt);
            if (this.desc != null) {
                ix += e.a.a.b.b.a.f(8, this.desc);
            }
            int bs = ix + e.a.a.b.b.a.bs(9, this.vWw);
            AppMethodBeat.o(48809);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vWt.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(48809);
                throw bVar;
            }
            AppMethodBeat.o(48809);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            pv pvVar = (pv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        BaseResponse baseResponse = new BaseResponse();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = baseResponse.populateBuilderWithField(aVar4, baseResponse, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        pvVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(48809);
                    return 0;
                case 2:
                    pvVar.kCl = aVar3.BTU.vd();
                    AppMethodBeat.o(48809);
                    return 0;
                case 3:
                    pvVar.kCm = aVar3.BTU.readString();
                    AppMethodBeat.o(48809);
                    return 0;
                case 4:
                    pvVar.pOy = aVar3.BTU.readString();
                    AppMethodBeat.o(48809);
                    return 0;
                case 5:
                    pvVar.vWr = aVar3.BTU.readString();
                    AppMethodBeat.o(48809);
                    return 0;
                case 6:
                    pvVar.vWs = aVar3.BTU.vd();
                    AppMethodBeat.o(48809);
                    return 0;
                case 7:
                    pvVar.vWt.add(Integer.valueOf(aVar3.BTU.vd()));
                    AppMethodBeat.o(48809);
                    return 0;
                case 8:
                    pvVar.desc = aVar3.BTU.readString();
                    AppMethodBeat.o(48809);
                    return 0;
                case 9:
                    pvVar.vWw = aVar3.BTU.vd();
                    AppMethodBeat.o(48809);
                    return 0;
                default:
                    AppMethodBeat.o(48809);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48809);
            return -1;
        }
    }
}
