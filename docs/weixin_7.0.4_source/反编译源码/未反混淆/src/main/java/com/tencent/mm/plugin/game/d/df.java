package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.btd;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class df extends btd {
    public String Title;
    public String mZR;
    public boolean mZy;
    public k ndD;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111672);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(111672);
                throw bVar;
            } else if (this.Title == null) {
                bVar = new b("Not all required fields were included: Title");
                AppMethodBeat.o(111672);
                throw bVar;
            } else if (this.mZR == null) {
                bVar = new b("Not all required fields were included: Message");
                AppMethodBeat.o(111672);
                throw bVar;
            } else {
                if (this.BaseResponse != null) {
                    aVar.iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                aVar.aO(2, this.mZy);
                if (this.Title != null) {
                    aVar.e(3, this.Title);
                }
                if (this.mZR != null) {
                    aVar.e(4, this.mZR);
                }
                if (this.ndD != null) {
                    aVar.iy(5, this.ndD.computeSize());
                    this.ndD.writeFields(aVar);
                }
                AppMethodBeat.o(111672);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.fv(2) + 1;
            if (this.Title != null) {
                ix += e.a.a.b.b.a.f(3, this.Title);
            }
            if (this.mZR != null) {
                ix += e.a.a.b.b.a.f(4, this.mZR);
            }
            if (this.ndD != null) {
                ix += e.a.a.a.ix(5, this.ndD.computeSize());
            }
            AppMethodBeat.o(111672);
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
                AppMethodBeat.o(111672);
                throw bVar;
            } else if (this.Title == null) {
                bVar = new b("Not all required fields were included: Title");
                AppMethodBeat.o(111672);
                throw bVar;
            } else if (this.mZR == null) {
                bVar = new b("Not all required fields were included: Message");
                AppMethodBeat.o(111672);
                throw bVar;
            } else {
                AppMethodBeat.o(111672);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            df dfVar = (df) objArr[1];
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
                        dfVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(111672);
                    return 0;
                case 2:
                    dfVar.mZy = aVar3.BTU.ehX();
                    AppMethodBeat.o(111672);
                    return 0;
                case 3:
                    dfVar.Title = aVar3.BTU.readString();
                    AppMethodBeat.o(111672);
                    return 0;
                case 4:
                    dfVar.mZR = aVar3.BTU.readString();
                    AppMethodBeat.o(111672);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        k kVar = new k();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = kVar.populateBuilderWithField(aVar4, kVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        dfVar.ndD = kVar;
                    }
                    AppMethodBeat.o(111672);
                    return 0;
                default:
                    AppMethodBeat.o(111672);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111672);
            return -1;
        }
    }
}
