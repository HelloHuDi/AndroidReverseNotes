package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class acx extends btd {
    public String Title;
    public LinkedList<String> wkF = new LinkedList();
    public String wkG;
    public LinkedList<String> wkH = new LinkedList();
    public LinkedList<String> wkI = new LinkedList();
    public LinkedList<acy> wkJ = new LinkedList();

    public acx() {
        AppMethodBeat.i(112423);
        AppMethodBeat.o(112423);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(112424);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(112424);
                throw bVar;
            } else if (this.Title == null) {
                bVar = new b("Not all required fields were included: Title");
                AppMethodBeat.o(112424);
                throw bVar;
            } else if (this.wkG == null) {
                bVar = new b("Not all required fields were included: JsonData");
                AppMethodBeat.o(112424);
                throw bVar;
            } else {
                if (this.BaseResponse != null) {
                    aVar.iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                if (this.Title != null) {
                    aVar.e(2, this.Title);
                }
                aVar.e(3, 1, this.wkF);
                if (this.wkG != null) {
                    aVar.e(4, this.wkG);
                }
                aVar.e(5, 1, this.wkH);
                aVar.e(6, 1, this.wkI);
                aVar.e(7, 8, this.wkJ);
                AppMethodBeat.o(112424);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.Title != null) {
                ix += e.a.a.b.b.a.f(2, this.Title);
            }
            ix += e.a.a.a.c(3, 1, this.wkF);
            if (this.wkG != null) {
                ix += e.a.a.b.b.a.f(4, this.wkG);
            }
            int c = ((ix + e.a.a.a.c(5, 1, this.wkH)) + e.a.a.a.c(6, 1, this.wkI)) + e.a.a.a.c(7, 8, this.wkJ);
            AppMethodBeat.o(112424);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wkF.clear();
            this.wkH.clear();
            this.wkI.clear();
            this.wkJ.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(112424);
                throw bVar;
            } else if (this.Title == null) {
                bVar = new b("Not all required fields were included: Title");
                AppMethodBeat.o(112424);
                throw bVar;
            } else if (this.wkG == null) {
                bVar = new b("Not all required fields were included: JsonData");
                AppMethodBeat.o(112424);
                throw bVar;
            } else {
                AppMethodBeat.o(112424);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            acx acx = (acx) objArr[1];
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
                        acx.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(112424);
                    return 0;
                case 2:
                    acx.Title = aVar3.BTU.readString();
                    AppMethodBeat.o(112424);
                    return 0;
                case 3:
                    acx.wkF.add(aVar3.BTU.readString());
                    AppMethodBeat.o(112424);
                    return 0;
                case 4:
                    acx.wkG = aVar3.BTU.readString();
                    AppMethodBeat.o(112424);
                    return 0;
                case 5:
                    acx.wkH.add(aVar3.BTU.readString());
                    AppMethodBeat.o(112424);
                    return 0;
                case 6:
                    acx.wkI.add(aVar3.BTU.readString());
                    AppMethodBeat.o(112424);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        acy acy = new acy();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = acy.populateBuilderWithField(aVar4, acy, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        acx.wkJ.add(acy);
                    }
                    AppMethodBeat.o(112424);
                    return 0;
                default:
                    AppMethodBeat.o(112424);
                    return -1;
            }
        } else {
            AppMethodBeat.o(112424);
            return -1;
        }
    }
}
