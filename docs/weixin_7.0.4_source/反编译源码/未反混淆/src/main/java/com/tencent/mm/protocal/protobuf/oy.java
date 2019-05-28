package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class oy extends btd {
    public int kCl;
    public int pPV;
    public String pPW;
    public String pPX;
    public String twd;
    public String url;
    public LinkedList<bbc> vVY = new LinkedList();
    public bbc vVZ;
    public String vWa;
    public boolean vWb;
    public String vWc;
    public int vWd;
    public bbj vWe;
    public bpt vWf;

    public oy() {
        AppMethodBeat.i(56752);
        AppMethodBeat.o(56752);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56753);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56753);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.url != null) {
                aVar.e(2, this.url);
            }
            aVar.e(3, 8, this.vVY);
            if (this.vVZ != null) {
                aVar.iy(4, this.vVZ.computeSize());
                this.vVZ.writeFields(aVar);
            }
            if (this.twd != null) {
                aVar.e(5, this.twd);
            }
            if (this.vWa != null) {
                aVar.e(6, this.vWa);
            }
            aVar.aO(7, this.vWb);
            aVar.iz(8, this.pPV);
            if (this.vWc != null) {
                aVar.e(9, this.vWc);
            }
            if (this.pPW != null) {
                aVar.e(10, this.pPW);
            }
            if (this.pPX != null) {
                aVar.e(11, this.pPX);
            }
            aVar.iz(12, this.vWd);
            if (this.vWe != null) {
                aVar.iy(13, this.vWe.computeSize());
                this.vWe.writeFields(aVar);
            }
            if (this.vWf != null) {
                aVar.iy(14, this.vWf.computeSize());
                this.vWf.writeFields(aVar);
            }
            aVar.iz(15, this.kCl);
            AppMethodBeat.o(56753);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.url != null) {
                ix += e.a.a.b.b.a.f(2, this.url);
            }
            ix += e.a.a.a.c(3, 8, this.vVY);
            if (this.vVZ != null) {
                ix += e.a.a.a.ix(4, this.vVZ.computeSize());
            }
            if (this.twd != null) {
                ix += e.a.a.b.b.a.f(5, this.twd);
            }
            if (this.vWa != null) {
                ix += e.a.a.b.b.a.f(6, this.vWa);
            }
            ix = (ix + (e.a.a.b.b.a.fv(7) + 1)) + e.a.a.b.b.a.bs(8, this.pPV);
            if (this.vWc != null) {
                ix += e.a.a.b.b.a.f(9, this.vWc);
            }
            if (this.pPW != null) {
                ix += e.a.a.b.b.a.f(10, this.pPW);
            }
            if (this.pPX != null) {
                ix += e.a.a.b.b.a.f(11, this.pPX);
            }
            ix += e.a.a.b.b.a.bs(12, this.vWd);
            if (this.vWe != null) {
                ix += e.a.a.a.ix(13, this.vWe.computeSize());
            }
            if (this.vWf != null) {
                ix += e.a.a.a.ix(14, this.vWf.computeSize());
            }
            int bs = ix + e.a.a.b.b.a.bs(15, this.kCl);
            AppMethodBeat.o(56753);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vVY.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56753);
                throw bVar;
            }
            AppMethodBeat.o(56753);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            oy oyVar = (oy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            bbc bbc;
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
                        oyVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(56753);
                    return 0;
                case 2:
                    oyVar.url = aVar3.BTU.readString();
                    AppMethodBeat.o(56753);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bbc = new bbc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bbc.populateBuilderWithField(aVar4, bbc, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        oyVar.vVY.add(bbc);
                    }
                    AppMethodBeat.o(56753);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bbc = new bbc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bbc.populateBuilderWithField(aVar4, bbc, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        oyVar.vVZ = bbc;
                    }
                    AppMethodBeat.o(56753);
                    return 0;
                case 5:
                    oyVar.twd = aVar3.BTU.readString();
                    AppMethodBeat.o(56753);
                    return 0;
                case 6:
                    oyVar.vWa = aVar3.BTU.readString();
                    AppMethodBeat.o(56753);
                    return 0;
                case 7:
                    oyVar.vWb = aVar3.BTU.ehX();
                    AppMethodBeat.o(56753);
                    return 0;
                case 8:
                    oyVar.pPV = aVar3.BTU.vd();
                    AppMethodBeat.o(56753);
                    return 0;
                case 9:
                    oyVar.vWc = aVar3.BTU.readString();
                    AppMethodBeat.o(56753);
                    return 0;
                case 10:
                    oyVar.pPW = aVar3.BTU.readString();
                    AppMethodBeat.o(56753);
                    return 0;
                case 11:
                    oyVar.pPX = aVar3.BTU.readString();
                    AppMethodBeat.o(56753);
                    return 0;
                case 12:
                    oyVar.vWd = aVar3.BTU.vd();
                    AppMethodBeat.o(56753);
                    return 0;
                case 13:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bbj bbj = new bbj();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bbj.populateBuilderWithField(aVar4, bbj, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        oyVar.vWe = bbj;
                    }
                    AppMethodBeat.o(56753);
                    return 0;
                case 14:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bpt bpt = new bpt();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bpt.populateBuilderWithField(aVar4, bpt, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        oyVar.vWf = bpt;
                    }
                    AppMethodBeat.o(56753);
                    return 0;
                case 15:
                    oyVar.kCl = aVar3.BTU.vd();
                    AppMethodBeat.o(56753);
                    return 0;
                default:
                    AppMethodBeat.o(56753);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56753);
            return -1;
        }
    }
}
