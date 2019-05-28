package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aks extends btd {
    public int kKI;
    public int kdT;
    public String kdU;
    public int wqk;
    public nv wql;
    public nw wqm;
    public nt wqn;
    public nu wqo;
    public String wqp;
    public int wqq;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(89096);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(89096);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.kdT);
            if (this.kdU != null) {
                aVar.e(3, this.kdU);
            }
            aVar.iz(4, this.kKI);
            aVar.iz(5, this.wqk);
            if (this.wql != null) {
                aVar.iy(6, this.wql.computeSize());
                this.wql.writeFields(aVar);
            }
            if (this.wqm != null) {
                aVar.iy(7, this.wqm.computeSize());
                this.wqm.writeFields(aVar);
            }
            if (this.wqn != null) {
                aVar.iy(8, this.wqn.computeSize());
                this.wqn.writeFields(aVar);
            }
            if (this.wqo != null) {
                aVar.iy(9, this.wqo.computeSize());
                this.wqo.writeFields(aVar);
            }
            if (this.wqp != null) {
                aVar.e(10, this.wqp);
            }
            aVar.iz(11, this.wqq);
            AppMethodBeat.o(89096);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.bs(2, this.kdT);
            if (this.kdU != null) {
                ix += e.a.a.b.b.a.f(3, this.kdU);
            }
            ix = (ix + e.a.a.b.b.a.bs(4, this.kKI)) + e.a.a.b.b.a.bs(5, this.wqk);
            if (this.wql != null) {
                ix += e.a.a.a.ix(6, this.wql.computeSize());
            }
            if (this.wqm != null) {
                ix += e.a.a.a.ix(7, this.wqm.computeSize());
            }
            if (this.wqn != null) {
                ix += e.a.a.a.ix(8, this.wqn.computeSize());
            }
            if (this.wqo != null) {
                ix += e.a.a.a.ix(9, this.wqo.computeSize());
            }
            if (this.wqp != null) {
                ix += e.a.a.b.b.a.f(10, this.wqp);
            }
            int bs = ix + e.a.a.b.b.a.bs(11, this.wqq);
            AppMethodBeat.o(89096);
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
                AppMethodBeat.o(89096);
                throw bVar;
            }
            AppMethodBeat.o(89096);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aks aks = (aks) objArr[1];
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
                        aks.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(89096);
                    return 0;
                case 2:
                    aks.kdT = aVar3.BTU.vd();
                    AppMethodBeat.o(89096);
                    return 0;
                case 3:
                    aks.kdU = aVar3.BTU.readString();
                    AppMethodBeat.o(89096);
                    return 0;
                case 4:
                    aks.kKI = aVar3.BTU.vd();
                    AppMethodBeat.o(89096);
                    return 0;
                case 5:
                    aks.wqk = aVar3.BTU.vd();
                    AppMethodBeat.o(89096);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        nv nvVar = new nv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = nvVar.populateBuilderWithField(aVar4, nvVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        aks.wql = nvVar;
                    }
                    AppMethodBeat.o(89096);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        nw nwVar = new nw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = nwVar.populateBuilderWithField(aVar4, nwVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        aks.wqm = nwVar;
                    }
                    AppMethodBeat.o(89096);
                    return 0;
                case 8:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        nt ntVar = new nt();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ntVar.populateBuilderWithField(aVar4, ntVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        aks.wqn = ntVar;
                    }
                    AppMethodBeat.o(89096);
                    return 0;
                case 9:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        nu nuVar = new nu();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = nuVar.populateBuilderWithField(aVar4, nuVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        aks.wqo = nuVar;
                    }
                    AppMethodBeat.o(89096);
                    return 0;
                case 10:
                    aks.wqp = aVar3.BTU.readString();
                    AppMethodBeat.o(89096);
                    return 0;
                case 11:
                    aks.wqq = aVar3.BTU.vd();
                    AppMethodBeat.o(89096);
                    return 0;
                default:
                    AppMethodBeat.o(89096);
                    return -1;
            }
        } else {
            AppMethodBeat.o(89096);
            return -1;
        }
    }
}
