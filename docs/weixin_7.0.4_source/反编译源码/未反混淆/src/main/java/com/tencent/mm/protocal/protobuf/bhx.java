package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bhx extends btd {
    public String pdA;
    public String type;
    public String wLb;
    public bia wLf;
    public LinkedList<bhx> wLg = new LinkedList();
    public int wLh;

    public bhx() {
        AppMethodBeat.i(90699);
        AppMethodBeat.o(90699);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(90700);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.wLf != null) {
                aVar.iy(2, this.wLf.computeSize());
                this.wLf.writeFields(aVar);
            }
            if (this.wLb != null) {
                aVar.e(3, this.wLb);
            }
            if (this.pdA != null) {
                aVar.e(4, this.pdA);
            }
            if (this.type != null) {
                aVar.e(5, this.type);
            }
            aVar.e(6, 8, this.wLg);
            aVar.iz(7, this.wLh);
            AppMethodBeat.o(90700);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wLf != null) {
                ix += e.a.a.a.ix(2, this.wLf.computeSize());
            }
            if (this.wLb != null) {
                ix += e.a.a.b.b.a.f(3, this.wLb);
            }
            if (this.pdA != null) {
                ix += e.a.a.b.b.a.f(4, this.pdA);
            }
            if (this.type != null) {
                ix += e.a.a.b.b.a.f(5, this.type);
            }
            int c = (ix + e.a.a.a.c(6, 8, this.wLg)) + e.a.a.b.b.a.bs(7, this.wLh);
            AppMethodBeat.o(90700);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wLg.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(90700);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bhx bhx = (bhx) objArr[1];
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
                        bhx.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(90700);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bia bia = new bia();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bia.populateBuilderWithField(aVar4, bia, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bhx.wLf = bia;
                    }
                    AppMethodBeat.o(90700);
                    return 0;
                case 3:
                    bhx.wLb = aVar3.BTU.readString();
                    AppMethodBeat.o(90700);
                    return 0;
                case 4:
                    bhx.pdA = aVar3.BTU.readString();
                    AppMethodBeat.o(90700);
                    return 0;
                case 5:
                    bhx.type = aVar3.BTU.readString();
                    AppMethodBeat.o(90700);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bhx bhx2 = new bhx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhx2.populateBuilderWithField(aVar4, bhx2, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bhx.wLg.add(bhx2);
                    }
                    AppMethodBeat.o(90700);
                    return 0;
                case 7:
                    bhx.wLh = aVar3.BTU.vd();
                    AppMethodBeat.o(90700);
                    return 0;
                default:
                    AppMethodBeat.o(90700);
                    return -1;
            }
        } else {
            AppMethodBeat.o(90700);
            return -1;
        }
    }
}
