package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bio extends btd {
    public int luT;
    public String luU;
    public String wLZ;
    public String wlb;
    public String wlc;
    public csj wlh;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56877);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56877);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.wlc != null) {
                aVar.e(2, this.wlc);
            }
            aVar.iz(3, this.luT);
            if (this.luU != null) {
                aVar.e(4, this.luU);
            }
            if (this.wlb != null) {
                aVar.e(5, this.wlb);
            }
            if (this.wLZ != null) {
                aVar.e(6, this.wLZ);
            }
            if (this.wlh != null) {
                aVar.iy(7, this.wlh.computeSize());
                this.wlh.writeFields(aVar);
            }
            AppMethodBeat.o(56877);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wlc != null) {
                ix += e.a.a.b.b.a.f(2, this.wlc);
            }
            ix += e.a.a.b.b.a.bs(3, this.luT);
            if (this.luU != null) {
                ix += e.a.a.b.b.a.f(4, this.luU);
            }
            if (this.wlb != null) {
                ix += e.a.a.b.b.a.f(5, this.wlb);
            }
            if (this.wLZ != null) {
                ix += e.a.a.b.b.a.f(6, this.wLZ);
            }
            if (this.wlh != null) {
                ix += e.a.a.a.ix(7, this.wlh.computeSize());
            }
            AppMethodBeat.o(56877);
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
                AppMethodBeat.o(56877);
                throw bVar;
            }
            AppMethodBeat.o(56877);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bio bio = (bio) objArr[1];
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
                        bio.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(56877);
                    return 0;
                case 2:
                    bio.wlc = aVar3.BTU.readString();
                    AppMethodBeat.o(56877);
                    return 0;
                case 3:
                    bio.luT = aVar3.BTU.vd();
                    AppMethodBeat.o(56877);
                    return 0;
                case 4:
                    bio.luU = aVar3.BTU.readString();
                    AppMethodBeat.o(56877);
                    return 0;
                case 5:
                    bio.wlb = aVar3.BTU.readString();
                    AppMethodBeat.o(56877);
                    return 0;
                case 6:
                    bio.wLZ = aVar3.BTU.readString();
                    AppMethodBeat.o(56877);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        csj csj = new csj();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = csj.populateBuilderWithField(aVar4, csj, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bio.wlh = csj;
                    }
                    AppMethodBeat.o(56877);
                    return 0;
                default:
                    AppMethodBeat.o(56877);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56877);
            return -1;
        }
    }
}
