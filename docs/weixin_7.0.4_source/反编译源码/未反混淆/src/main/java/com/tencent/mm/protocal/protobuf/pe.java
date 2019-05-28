package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class pe extends btd {
    public String desc;
    public String jMS;
    public int kCl;
    public String kCm;
    public String kdE;
    public String pOy;
    public String twd;
    public bpt vWf;
    public boolean vWq;
    public String vWr;
    public int vWs;
    public LinkedList<Integer> vWt = new LinkedList();
    public String vWu;
    public int vWv;
    public int vWw;

    public pe() {
        AppMethodBeat.i(48795);
        AppMethodBeat.o(48795);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48796);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(48796);
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
            aVar.aO(4, this.vWq);
            if (this.pOy != null) {
                aVar.e(5, this.pOy);
            }
            if (this.vWr != null) {
                aVar.e(6, this.vWr);
            }
            if (this.jMS != null) {
                aVar.e(7, this.jMS);
            }
            aVar.iz(8, this.vWs);
            if (this.desc != null) {
                aVar.e(9, this.desc);
            }
            if (this.twd != null) {
                aVar.e(10, this.twd);
            }
            aVar.e(11, 2, this.vWt);
            if (this.vWu != null) {
                aVar.e(12, this.vWu);
            }
            if (this.kdE != null) {
                aVar.e(13, this.kdE);
            }
            aVar.iz(14, this.vWv);
            aVar.iz(15, this.vWw);
            if (this.vWf != null) {
                aVar.iy(16, this.vWf.computeSize());
                this.vWf.writeFields(aVar);
            }
            AppMethodBeat.o(48796);
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
            ix += e.a.a.b.b.a.fv(4) + 1;
            if (this.pOy != null) {
                ix += e.a.a.b.b.a.f(5, this.pOy);
            }
            if (this.vWr != null) {
                ix += e.a.a.b.b.a.f(6, this.vWr);
            }
            if (this.jMS != null) {
                ix += e.a.a.b.b.a.f(7, this.jMS);
            }
            ix += e.a.a.b.b.a.bs(8, this.vWs);
            if (this.desc != null) {
                ix += e.a.a.b.b.a.f(9, this.desc);
            }
            if (this.twd != null) {
                ix += e.a.a.b.b.a.f(10, this.twd);
            }
            ix += e.a.a.a.c(11, 2, this.vWt);
            if (this.vWu != null) {
                ix += e.a.a.b.b.a.f(12, this.vWu);
            }
            if (this.kdE != null) {
                ix += e.a.a.b.b.a.f(13, this.kdE);
            }
            ix = (ix + e.a.a.b.b.a.bs(14, this.vWv)) + e.a.a.b.b.a.bs(15, this.vWw);
            if (this.vWf != null) {
                ix += e.a.a.a.ix(16, this.vWf.computeSize());
            }
            AppMethodBeat.o(48796);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vWt.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(48796);
                throw bVar;
            }
            AppMethodBeat.o(48796);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            pe peVar = (pe) objArr[1];
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
                        peVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(48796);
                    return 0;
                case 2:
                    peVar.kCl = aVar3.BTU.vd();
                    AppMethodBeat.o(48796);
                    return 0;
                case 3:
                    peVar.kCm = aVar3.BTU.readString();
                    AppMethodBeat.o(48796);
                    return 0;
                case 4:
                    peVar.vWq = aVar3.BTU.ehX();
                    AppMethodBeat.o(48796);
                    return 0;
                case 5:
                    peVar.pOy = aVar3.BTU.readString();
                    AppMethodBeat.o(48796);
                    return 0;
                case 6:
                    peVar.vWr = aVar3.BTU.readString();
                    AppMethodBeat.o(48796);
                    return 0;
                case 7:
                    peVar.jMS = aVar3.BTU.readString();
                    AppMethodBeat.o(48796);
                    return 0;
                case 8:
                    peVar.vWs = aVar3.BTU.vd();
                    AppMethodBeat.o(48796);
                    return 0;
                case 9:
                    peVar.desc = aVar3.BTU.readString();
                    AppMethodBeat.o(48796);
                    return 0;
                case 10:
                    peVar.twd = aVar3.BTU.readString();
                    AppMethodBeat.o(48796);
                    return 0;
                case 11:
                    peVar.vWt.add(Integer.valueOf(aVar3.BTU.vd()));
                    AppMethodBeat.o(48796);
                    return 0;
                case 12:
                    peVar.vWu = aVar3.BTU.readString();
                    AppMethodBeat.o(48796);
                    return 0;
                case 13:
                    peVar.kdE = aVar3.BTU.readString();
                    AppMethodBeat.o(48796);
                    return 0;
                case 14:
                    peVar.vWv = aVar3.BTU.vd();
                    AppMethodBeat.o(48796);
                    return 0;
                case 15:
                    peVar.vWw = aVar3.BTU.vd();
                    AppMethodBeat.o(48796);
                    return 0;
                case 16:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bpt bpt = new bpt();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bpt.populateBuilderWithField(aVar4, bpt, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        peVar.vWf = bpt;
                    }
                    AppMethodBeat.o(48796);
                    return 0;
                default:
                    AppMethodBeat.o(48796);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48796);
            return -1;
        }
    }
}
