package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ari extends btd {
    public cwg vXT;
    public int wve;
    public LinkedList<cxi> wvk = new LinkedList();
    public cxi wvl;
    public String wvm;
    public int wvn;
    public String wvo;
    public String wvp;
    public String wvq;
    public String wvr;

    public ari() {
        AppMethodBeat.i(96244);
        AppMethodBeat.o(96244);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(96245);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(96245);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.vXT != null) {
                aVar.iy(2, this.vXT.computeSize());
                this.vXT.writeFields(aVar);
            }
            aVar.e(3, 8, this.wvk);
            if (this.wvl != null) {
                aVar.iy(4, this.wvl.computeSize());
                this.wvl.writeFields(aVar);
            }
            if (this.wvm != null) {
                aVar.e(5, this.wvm);
            }
            aVar.iz(6, this.wvn);
            if (this.wvo != null) {
                aVar.e(7, this.wvo);
            }
            if (this.wvp != null) {
                aVar.e(8, this.wvp);
            }
            if (this.wvq != null) {
                aVar.e(9, this.wvq);
            }
            if (this.wvr != null) {
                aVar.e(10, this.wvr);
            }
            aVar.iz(11, this.wve);
            AppMethodBeat.o(96245);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vXT != null) {
                ix += e.a.a.a.ix(2, this.vXT.computeSize());
            }
            ix += e.a.a.a.c(3, 8, this.wvk);
            if (this.wvl != null) {
                ix += e.a.a.a.ix(4, this.wvl.computeSize());
            }
            if (this.wvm != null) {
                ix += e.a.a.b.b.a.f(5, this.wvm);
            }
            ix += e.a.a.b.b.a.bs(6, this.wvn);
            if (this.wvo != null) {
                ix += e.a.a.b.b.a.f(7, this.wvo);
            }
            if (this.wvp != null) {
                ix += e.a.a.b.b.a.f(8, this.wvp);
            }
            if (this.wvq != null) {
                ix += e.a.a.b.b.a.f(9, this.wvq);
            }
            if (this.wvr != null) {
                ix += e.a.a.b.b.a.f(10, this.wvr);
            }
            int bs = ix + e.a.a.b.b.a.bs(11, this.wve);
            AppMethodBeat.o(96245);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wvk.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(96245);
                throw bVar;
            }
            AppMethodBeat.o(96245);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ari ari = (ari) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            cxi cxi;
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
                        ari.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(96245);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cwg cwg = new cwg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cwg.populateBuilderWithField(aVar4, cwg, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ari.vXT = cwg;
                    }
                    AppMethodBeat.o(96245);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cxi = new cxi();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cxi.populateBuilderWithField(aVar4, cxi, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ari.wvk.add(cxi);
                    }
                    AppMethodBeat.o(96245);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cxi = new cxi();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cxi.populateBuilderWithField(aVar4, cxi, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ari.wvl = cxi;
                    }
                    AppMethodBeat.o(96245);
                    return 0;
                case 5:
                    ari.wvm = aVar3.BTU.readString();
                    AppMethodBeat.o(96245);
                    return 0;
                case 6:
                    ari.wvn = aVar3.BTU.vd();
                    AppMethodBeat.o(96245);
                    return 0;
                case 7:
                    ari.wvo = aVar3.BTU.readString();
                    AppMethodBeat.o(96245);
                    return 0;
                case 8:
                    ari.wvp = aVar3.BTU.readString();
                    AppMethodBeat.o(96245);
                    return 0;
                case 9:
                    ari.wvq = aVar3.BTU.readString();
                    AppMethodBeat.o(96245);
                    return 0;
                case 10:
                    ari.wvr = aVar3.BTU.readString();
                    AppMethodBeat.o(96245);
                    return 0;
                case 11:
                    ari.wve = aVar3.BTU.vd();
                    AppMethodBeat.o(96245);
                    return 0;
                default:
                    AppMethodBeat.o(96245);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96245);
            return -1;
        }
    }
}
