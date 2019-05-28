package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ry extends btd {
    public String Md5;
    public int Version;
    public String vZm;
    public int vZn;
    public LinkedList<chi> vZo = new LinkedList();
    public int vZp;

    public ry() {
        AppMethodBeat.i(14721);
        AppMethodBeat.o(14721);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(14722);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(14722);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.Version);
            if (this.vZm != null) {
                aVar.e(3, this.vZm);
            }
            if (this.Md5 != null) {
                aVar.e(4, this.Md5);
            }
            aVar.iz(5, this.vZn);
            aVar.e(6, 8, this.vZo);
            aVar.iz(7, this.vZp);
            AppMethodBeat.o(14722);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.bs(2, this.Version);
            if (this.vZm != null) {
                ix += e.a.a.b.b.a.f(3, this.vZm);
            }
            if (this.Md5 != null) {
                ix += e.a.a.b.b.a.f(4, this.Md5);
            }
            int bs = ((ix + e.a.a.b.b.a.bs(5, this.vZn)) + e.a.a.a.c(6, 8, this.vZo)) + e.a.a.b.b.a.bs(7, this.vZp);
            AppMethodBeat.o(14722);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vZo.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(14722);
                throw bVar;
            }
            AppMethodBeat.o(14722);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ry ryVar = (ry) objArr[1];
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
                        ryVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(14722);
                    return 0;
                case 2:
                    ryVar.Version = aVar3.BTU.vd();
                    AppMethodBeat.o(14722);
                    return 0;
                case 3:
                    ryVar.vZm = aVar3.BTU.readString();
                    AppMethodBeat.o(14722);
                    return 0;
                case 4:
                    ryVar.Md5 = aVar3.BTU.readString();
                    AppMethodBeat.o(14722);
                    return 0;
                case 5:
                    ryVar.vZn = aVar3.BTU.vd();
                    AppMethodBeat.o(14722);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        chi chi = new chi();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = chi.populateBuilderWithField(aVar4, chi, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ryVar.vZo.add(chi);
                    }
                    AppMethodBeat.o(14722);
                    return 0;
                case 7:
                    ryVar.vZp = aVar3.BTU.vd();
                    AppMethodBeat.o(14722);
                    return 0;
                default:
                    AppMethodBeat.o(14722);
                    return -1;
            }
        } else {
            AppMethodBeat.o(14722);
            return -1;
        }
    }
}
