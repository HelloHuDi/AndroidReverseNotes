package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.d;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class adp extends btd {
    public String SSID;
    public String Title;
    public String jBB;
    public String ncM;
    public String nzz;
    public String vAI;
    public int vAS;
    public avn wlA;
    public adl wlB;
    public String wlC;
    public int wlD;
    public LinkedList<le> wlE = new LinkedList();
    public String wlF;
    public vc wlG;
    public SKBuiltinBuffer_t wlH;
    public int wlI;
    public LinkedList<atp> wlJ = new LinkedList();
    public String wlK;
    public String wlL;
    public SKBuiltinBuffer_t wlw;
    public String wly;
    public String wlz;

    public adp() {
        AppMethodBeat.i(80055);
        AppMethodBeat.o(80055);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80056);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(80056);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.wly != null) {
                aVar.e(2, this.wly);
            }
            if (this.wlz != null) {
                aVar.e(3, this.wlz);
            }
            aVar.iz(4, this.vAS);
            if (this.Title != null) {
                aVar.e(5, this.Title);
            }
            if (this.ncM != null) {
                aVar.e(6, this.ncM);
            }
            if (this.wlA != null) {
                aVar.iy(7, this.wlA.computeSize());
                this.wlA.writeFields(aVar);
            }
            if (this.wlB != null) {
                aVar.iy(8, this.wlB.computeSize());
                this.wlB.writeFields(aVar);
            }
            if (this.jBB != null) {
                aVar.e(9, this.jBB);
            }
            if (this.wlC != null) {
                aVar.e(15, this.wlC);
            }
            aVar.iz(16, this.wlD);
            aVar.e(17, 8, this.wlE);
            if (this.wlF != null) {
                aVar.e(18, this.wlF);
            }
            if (this.SSID != null) {
                aVar.e(20, this.SSID);
            }
            if (this.vAI != null) {
                aVar.e(21, this.vAI);
            }
            if (this.wlG != null) {
                aVar.iy(22, this.wlG.computeSize());
                this.wlG.writeFields(aVar);
            }
            if (this.wlH != null) {
                aVar.iy(23, this.wlH.computeSize());
                this.wlH.writeFields(aVar);
            }
            aVar.iz(24, this.wlI);
            aVar.e(25, 8, this.wlJ);
            if (this.nzz != null) {
                aVar.e(26, this.nzz);
            }
            if (this.wlK != null) {
                aVar.e(27, this.wlK);
            }
            if (this.wlw != null) {
                aVar.iy(28, this.wlw.computeSize());
                this.wlw.writeFields(aVar);
            }
            if (this.wlL != null) {
                aVar.e(29, this.wlL);
            }
            AppMethodBeat.o(80056);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wly != null) {
                ix += e.a.a.b.b.a.f(2, this.wly);
            }
            if (this.wlz != null) {
                ix += e.a.a.b.b.a.f(3, this.wlz);
            }
            ix += e.a.a.b.b.a.bs(4, this.vAS);
            if (this.Title != null) {
                ix += e.a.a.b.b.a.f(5, this.Title);
            }
            if (this.ncM != null) {
                ix += e.a.a.b.b.a.f(6, this.ncM);
            }
            if (this.wlA != null) {
                ix += e.a.a.a.ix(7, this.wlA.computeSize());
            }
            if (this.wlB != null) {
                ix += e.a.a.a.ix(8, this.wlB.computeSize());
            }
            if (this.jBB != null) {
                ix += e.a.a.b.b.a.f(9, this.jBB);
            }
            if (this.wlC != null) {
                ix += e.a.a.b.b.a.f(15, this.wlC);
            }
            ix = (ix + e.a.a.b.b.a.bs(16, this.wlD)) + e.a.a.a.c(17, 8, this.wlE);
            if (this.wlF != null) {
                ix += e.a.a.b.b.a.f(18, this.wlF);
            }
            if (this.SSID != null) {
                ix += e.a.a.b.b.a.f(20, this.SSID);
            }
            if (this.vAI != null) {
                ix += e.a.a.b.b.a.f(21, this.vAI);
            }
            if (this.wlG != null) {
                ix += e.a.a.a.ix(22, this.wlG.computeSize());
            }
            if (this.wlH != null) {
                ix += e.a.a.a.ix(23, this.wlH.computeSize());
            }
            ix = (ix + e.a.a.b.b.a.bs(24, this.wlI)) + e.a.a.a.c(25, 8, this.wlJ);
            if (this.nzz != null) {
                ix += e.a.a.b.b.a.f(26, this.nzz);
            }
            if (this.wlK != null) {
                ix += e.a.a.b.b.a.f(27, this.wlK);
            }
            if (this.wlw != null) {
                ix += e.a.a.a.ix(28, this.wlw.computeSize());
            }
            if (this.wlL != null) {
                ix += e.a.a.b.b.a.f(29, this.wlL);
            }
            AppMethodBeat.o(80056);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wlE.clear();
            this.wlJ.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(80056);
                throw bVar;
            }
            AppMethodBeat.o(80056);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            adp adp = (adp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
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
                        adp.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(80056);
                    return 0;
                case 2:
                    adp.wly = aVar3.BTU.readString();
                    AppMethodBeat.o(80056);
                    return 0;
                case 3:
                    adp.wlz = aVar3.BTU.readString();
                    AppMethodBeat.o(80056);
                    return 0;
                case 4:
                    adp.vAS = aVar3.BTU.vd();
                    AppMethodBeat.o(80056);
                    return 0;
                case 5:
                    adp.Title = aVar3.BTU.readString();
                    AppMethodBeat.o(80056);
                    return 0;
                case 6:
                    adp.ncM = aVar3.BTU.readString();
                    AppMethodBeat.o(80056);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        avn avn = new avn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = avn.populateBuilderWithField(aVar4, avn, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        adp.wlA = avn;
                    }
                    AppMethodBeat.o(80056);
                    return 0;
                case 8:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        adl adl = new adl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = adl.populateBuilderWithField(aVar4, adl, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        adp.wlB = adl;
                    }
                    AppMethodBeat.o(80056);
                    return 0;
                case 9:
                    adp.jBB = aVar3.BTU.readString();
                    AppMethodBeat.o(80056);
                    return 0;
                case 15:
                    adp.wlC = aVar3.BTU.readString();
                    AppMethodBeat.o(80056);
                    return 0;
                case 16:
                    adp.wlD = aVar3.BTU.vd();
                    AppMethodBeat.o(80056);
                    return 0;
                case 17:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        le leVar = new le();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = leVar.populateBuilderWithField(aVar4, leVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        adp.wlE.add(leVar);
                    }
                    AppMethodBeat.o(80056);
                    return 0;
                case 18:
                    adp.wlF = aVar3.BTU.readString();
                    AppMethodBeat.o(80056);
                    return 0;
                case 20:
                    adp.SSID = aVar3.BTU.readString();
                    AppMethodBeat.o(80056);
                    return 0;
                case 21:
                    adp.vAI = aVar3.BTU.readString();
                    AppMethodBeat.o(80056);
                    return 0;
                case 22:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        vc vcVar = new vc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = vcVar.populateBuilderWithField(aVar4, vcVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        adp.wlG = vcVar;
                    }
                    AppMethodBeat.o(80056);
                    return 0;
                case 23:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        adp.wlH = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(80056);
                    return 0;
                case 24:
                    adp.wlI = aVar3.BTU.vd();
                    AppMethodBeat.o(80056);
                    return 0;
                case 25:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        atp atp = new atp();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = atp.populateBuilderWithField(aVar4, atp, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        adp.wlJ.add(atp);
                    }
                    AppMethodBeat.o(80056);
                    return 0;
                case 26:
                    adp.nzz = aVar3.BTU.readString();
                    AppMethodBeat.o(80056);
                    return 0;
                case 27:
                    adp.wlK = aVar3.BTU.readString();
                    AppMethodBeat.o(80056);
                    return 0;
                case d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        adp.wlw = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(80056);
                    return 0;
                case 29:
                    adp.wlL = aVar3.BTU.readString();
                    AppMethodBeat.o(80056);
                    return 0;
                default:
                    AppMethodBeat.o(80056);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80056);
            return -1;
        }
    }
}
