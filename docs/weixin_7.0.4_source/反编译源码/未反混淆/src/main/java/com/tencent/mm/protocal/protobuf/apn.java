package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public class apn extends btd {
    public int vIc;
    public LinkedList<String> wtA = new LinkedList();
    public String wty;
    public String wtz;

    public apn() {
        AppMethodBeat.i(102379);
        AppMethodBeat.o(102379);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(102380);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(102380);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.wty != null) {
                aVar.e(2, this.wty);
            }
            aVar.iz(3, this.vIc);
            if (this.wtz != null) {
                aVar.e(4, this.wtz);
            }
            aVar.e(5, 1, this.wtA);
            AppMethodBeat.o(102380);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wty != null) {
                ix += e.a.a.b.b.a.f(2, this.wty);
            }
            ix += e.a.a.b.b.a.bs(3, this.vIc);
            if (this.wtz != null) {
                ix += e.a.a.b.b.a.f(4, this.wtz);
            }
            int c = ix + e.a.a.a.c(5, 1, this.wtA);
            AppMethodBeat.o(102380);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wtA.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(102380);
                throw bVar;
            }
            AppMethodBeat.o(102380);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            apn apn = (apn) objArr[1];
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
                        apn.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(102380);
                    return 0;
                case 2:
                    apn.wty = aVar3.BTU.readString();
                    AppMethodBeat.o(102380);
                    return 0;
                case 3:
                    apn.vIc = aVar3.BTU.vd();
                    AppMethodBeat.o(102380);
                    return 0;
                case 4:
                    apn.wtz = aVar3.BTU.readString();
                    AppMethodBeat.o(102380);
                    return 0;
                case 5:
                    apn.wtA.add(aVar3.BTU.readString());
                    AppMethodBeat.o(102380);
                    return 0;
                default:
                    AppMethodBeat.o(102380);
                    return -1;
            }
        } else {
            AppMethodBeat.o(102380);
            return -1;
        }
    }
}
