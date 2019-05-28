package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bst extends btd {
    public int kCl;
    public String kCm;
    public String nYX;
    public String nuL;
    public String pMe;
    public String pMf;
    public String vPX;
    public dc wUQ;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48956);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(48956);
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
            if (this.nYX != null) {
                aVar.e(4, this.nYX);
            }
            if (this.vPX != null) {
                aVar.e(5, this.vPX);
            }
            if (this.pMe != null) {
                aVar.e(6, this.pMe);
            }
            if (this.pMf != null) {
                aVar.e(7, this.pMf);
            }
            if (this.nuL != null) {
                aVar.e(8, this.nuL);
            }
            if (this.wUQ != null) {
                aVar.iy(9, this.wUQ.computeSize());
                this.wUQ.writeFields(aVar);
            }
            AppMethodBeat.o(48956);
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
            if (this.nYX != null) {
                ix += e.a.a.b.b.a.f(4, this.nYX);
            }
            if (this.vPX != null) {
                ix += e.a.a.b.b.a.f(5, this.vPX);
            }
            if (this.pMe != null) {
                ix += e.a.a.b.b.a.f(6, this.pMe);
            }
            if (this.pMf != null) {
                ix += e.a.a.b.b.a.f(7, this.pMf);
            }
            if (this.nuL != null) {
                ix += e.a.a.b.b.a.f(8, this.nuL);
            }
            if (this.wUQ != null) {
                ix += e.a.a.a.ix(9, this.wUQ.computeSize());
            }
            AppMethodBeat.o(48956);
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
                AppMethodBeat.o(48956);
                throw bVar;
            }
            AppMethodBeat.o(48956);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bst bst = (bst) objArr[1];
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
                        bst.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(48956);
                    return 0;
                case 2:
                    bst.kCl = aVar3.BTU.vd();
                    AppMethodBeat.o(48956);
                    return 0;
                case 3:
                    bst.kCm = aVar3.BTU.readString();
                    AppMethodBeat.o(48956);
                    return 0;
                case 4:
                    bst.nYX = aVar3.BTU.readString();
                    AppMethodBeat.o(48956);
                    return 0;
                case 5:
                    bst.vPX = aVar3.BTU.readString();
                    AppMethodBeat.o(48956);
                    return 0;
                case 6:
                    bst.pMe = aVar3.BTU.readString();
                    AppMethodBeat.o(48956);
                    return 0;
                case 7:
                    bst.pMf = aVar3.BTU.readString();
                    AppMethodBeat.o(48956);
                    return 0;
                case 8:
                    bst.nuL = aVar3.BTU.readString();
                    AppMethodBeat.o(48956);
                    return 0;
                case 9:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        dc dcVar = new dc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dcVar.populateBuilderWithField(aVar4, dcVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bst.wUQ = dcVar;
                    }
                    AppMethodBeat.o(48956);
                    return 0;
                default:
                    AppMethodBeat.o(48956);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48956);
            return -1;
        }
    }
}
