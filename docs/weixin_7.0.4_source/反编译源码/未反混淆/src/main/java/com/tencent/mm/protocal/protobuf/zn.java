package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class zn extends btd {
    public zq weL;
    public zk weM;
    public zl weN;
    public String weO;
    public int weP;
    public int weQ;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28398);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(28398);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.weL != null) {
                aVar.iy(2, this.weL.computeSize());
                this.weL.writeFields(aVar);
            }
            if (this.weM != null) {
                aVar.iy(3, this.weM.computeSize());
                this.weM.writeFields(aVar);
            }
            if (this.weN != null) {
                aVar.iy(4, this.weN.computeSize());
                this.weN.writeFields(aVar);
            }
            if (this.weO != null) {
                aVar.e(5, this.weO);
            }
            aVar.iz(6, this.weP);
            aVar.iz(7, this.weQ);
            AppMethodBeat.o(28398);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.weL != null) {
                ix += e.a.a.a.ix(2, this.weL.computeSize());
            }
            if (this.weM != null) {
                ix += e.a.a.a.ix(3, this.weM.computeSize());
            }
            if (this.weN != null) {
                ix += e.a.a.a.ix(4, this.weN.computeSize());
            }
            if (this.weO != null) {
                ix += e.a.a.b.b.a.f(5, this.weO);
            }
            int bs = (ix + e.a.a.b.b.a.bs(6, this.weP)) + e.a.a.b.b.a.bs(7, this.weQ);
            AppMethodBeat.o(28398);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(28398);
                throw bVar;
            }
            AppMethodBeat.o(28398);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            zn znVar = (zn) objArr[1];
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
                        znVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(28398);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        zq zqVar = new zq();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = zqVar.populateBuilderWithField(aVar4, zqVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        znVar.weL = zqVar;
                    }
                    AppMethodBeat.o(28398);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        zk zkVar = new zk();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = zkVar.populateBuilderWithField(aVar4, zkVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        znVar.weM = zkVar;
                    }
                    AppMethodBeat.o(28398);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        zl zlVar = new zl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = zlVar.populateBuilderWithField(aVar4, zlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        znVar.weN = zlVar;
                    }
                    AppMethodBeat.o(28398);
                    return 0;
                case 5:
                    znVar.weO = aVar3.BTU.readString();
                    AppMethodBeat.o(28398);
                    return 0;
                case 6:
                    znVar.weP = aVar3.BTU.vd();
                    AppMethodBeat.o(28398);
                    return 0;
                case 7:
                    znVar.weQ = aVar3.BTU.vd();
                    AppMethodBeat.o(28398);
                    return 0;
                default:
                    AppMethodBeat.o(28398);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28398);
            return -1;
        }
    }
}
