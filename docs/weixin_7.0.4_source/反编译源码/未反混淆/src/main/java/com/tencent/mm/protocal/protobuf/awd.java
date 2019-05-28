package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class awd extends btd {
    public b jBi;
    public String ncH;
    public String vDm;
    public avi wzH;
    public String wzJ;
    public String wzK;
    public String wzL;
    public buj wzS;
    public va wzT;
    public boolean wzU;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(96267);
        e.a.a.b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new e.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(96267);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.wzH != null) {
                aVar.iy(2, this.wzH.computeSize());
                this.wzH.writeFields(aVar);
            }
            if (this.jBi != null) {
                aVar.c(3, this.jBi);
            }
            if (this.wzS != null) {
                aVar.iy(4, this.wzS.computeSize());
                this.wzS.writeFields(aVar);
            }
            if (this.ncH != null) {
                aVar.e(5, this.ncH);
            }
            if (this.vDm != null) {
                aVar.e(6, this.vDm);
            }
            if (this.wzT != null) {
                aVar.iy(7, this.wzT.computeSize());
                this.wzT.writeFields(aVar);
            }
            aVar.aO(8, this.wzU);
            if (this.wzJ != null) {
                aVar.e(9, this.wzJ);
            }
            if (this.wzK != null) {
                aVar.e(10, this.wzK);
            }
            if (this.wzL != null) {
                aVar.e(11, this.wzL);
            }
            AppMethodBeat.o(96267);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wzH != null) {
                ix += e.a.a.a.ix(2, this.wzH.computeSize());
            }
            if (this.jBi != null) {
                ix += e.a.a.b.b.a.b(3, this.jBi);
            }
            if (this.wzS != null) {
                ix += e.a.a.a.ix(4, this.wzS.computeSize());
            }
            if (this.ncH != null) {
                ix += e.a.a.b.b.a.f(5, this.ncH);
            }
            if (this.vDm != null) {
                ix += e.a.a.b.b.a.f(6, this.vDm);
            }
            if (this.wzT != null) {
                ix += e.a.a.a.ix(7, this.wzT.computeSize());
            }
            ix += e.a.a.b.b.a.fv(8) + 1;
            if (this.wzJ != null) {
                ix += e.a.a.b.b.a.f(9, this.wzJ);
            }
            if (this.wzK != null) {
                ix += e.a.a.b.b.a.f(10, this.wzK);
            }
            if (this.wzL != null) {
                ix += e.a.a.b.b.a.f(11, this.wzL);
            }
            AppMethodBeat.o(96267);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new e.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(96267);
                throw bVar;
            }
            AppMethodBeat.o(96267);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            awd awd = (awd) objArr[1];
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
                        awd.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(96267);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        avi avi = new avi();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = avi.populateBuilderWithField(aVar4, avi, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        awd.wzH = avi;
                    }
                    AppMethodBeat.o(96267);
                    return 0;
                case 3:
                    awd.jBi = aVar3.BTU.emu();
                    AppMethodBeat.o(96267);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        buj buj = new buj();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = buj.populateBuilderWithField(aVar4, buj, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        awd.wzS = buj;
                    }
                    AppMethodBeat.o(96267);
                    return 0;
                case 5:
                    awd.ncH = aVar3.BTU.readString();
                    AppMethodBeat.o(96267);
                    return 0;
                case 6:
                    awd.vDm = aVar3.BTU.readString();
                    AppMethodBeat.o(96267);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        va vaVar = new va();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = vaVar.populateBuilderWithField(aVar4, vaVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        awd.wzT = vaVar;
                    }
                    AppMethodBeat.o(96267);
                    return 0;
                case 8:
                    awd.wzU = aVar3.BTU.ehX();
                    AppMethodBeat.o(96267);
                    return 0;
                case 9:
                    awd.wzJ = aVar3.BTU.readString();
                    AppMethodBeat.o(96267);
                    return 0;
                case 10:
                    awd.wzK = aVar3.BTU.readString();
                    AppMethodBeat.o(96267);
                    return 0;
                case 11:
                    awd.wzL = aVar3.BTU.readString();
                    AppMethodBeat.o(96267);
                    return 0;
                default:
                    AppMethodBeat.o(96267);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96267);
            return -1;
        }
    }
}
