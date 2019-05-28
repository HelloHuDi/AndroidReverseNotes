package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public class avx extends btd {
    public String ncH;
    public String vDm;
    public LinkedList<buj> wlE = new LinkedList();
    public avi wzH;
    public String wzJ;
    public String wzK;
    public String wzL;

    public avx() {
        AppMethodBeat.i(96257);
        AppMethodBeat.o(96257);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(96258);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(96258);
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
            aVar.e(3, 8, this.wlE);
            if (this.ncH != null) {
                aVar.e(4, this.ncH);
            }
            if (this.vDm != null) {
                aVar.e(5, this.vDm);
            }
            if (this.wzJ != null) {
                aVar.e(6, this.wzJ);
            }
            if (this.wzK != null) {
                aVar.e(7, this.wzK);
            }
            if (this.wzL != null) {
                aVar.e(8, this.wzL);
            }
            AppMethodBeat.o(96258);
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
            ix += e.a.a.a.c(3, 8, this.wlE);
            if (this.ncH != null) {
                ix += e.a.a.b.b.a.f(4, this.ncH);
            }
            if (this.vDm != null) {
                ix += e.a.a.b.b.a.f(5, this.vDm);
            }
            if (this.wzJ != null) {
                ix += e.a.a.b.b.a.f(6, this.wzJ);
            }
            if (this.wzK != null) {
                ix += e.a.a.b.b.a.f(7, this.wzK);
            }
            if (this.wzL != null) {
                ix += e.a.a.b.b.a.f(8, this.wzL);
            }
            AppMethodBeat.o(96258);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wlE.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(96258);
                throw bVar;
            }
            AppMethodBeat.o(96258);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            avx avx = (avx) objArr[1];
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
                        avx.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(96258);
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
                        avx.wzH = avi;
                    }
                    AppMethodBeat.o(96258);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        buj buj = new buj();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = buj.populateBuilderWithField(aVar4, buj, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        avx.wlE.add(buj);
                    }
                    AppMethodBeat.o(96258);
                    return 0;
                case 4:
                    avx.ncH = aVar3.BTU.readString();
                    AppMethodBeat.o(96258);
                    return 0;
                case 5:
                    avx.vDm = aVar3.BTU.readString();
                    AppMethodBeat.o(96258);
                    return 0;
                case 6:
                    avx.wzJ = aVar3.BTU.readString();
                    AppMethodBeat.o(96258);
                    return 0;
                case 7:
                    avx.wzK = aVar3.BTU.readString();
                    AppMethodBeat.o(96258);
                    return 0;
                case 8:
                    avx.wzL = aVar3.BTU.readString();
                    AppMethodBeat.o(96258);
                    return 0;
                default:
                    AppMethodBeat.o(96258);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96258);
            return -1;
        }
    }
}
