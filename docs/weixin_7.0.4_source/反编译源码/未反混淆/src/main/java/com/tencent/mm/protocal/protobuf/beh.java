package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.d;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class beh extends btd {
    public String jBB;
    public int jBT;
    public int luF;
    public String luH;
    public String vAN;
    public String vCg;
    public int vCj;
    public String vCm;
    public String vCn;
    public int vCo;
    public String vCp;
    public String vHO;
    public bzr vHR;
    public int vHW;
    public ato vLK;
    public lm vLL;
    public bdu vLM;
    public mw vMl;
    public mw vMm;
    public mw vMn;
    public String wIh;
    public int wIi;
    public String wIj;
    public int wIk;
    public bkq wIl;
    public int wIm;
    public String wIn;
    public String wIo;
    public bvv wIp;
    public String wsL;
    public SKBuiltinBuffer_t wsO;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(58921);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(58921);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.luF);
            if (this.vAN != null) {
                aVar.e(3, this.vAN);
            }
            if (this.vCm != null) {
                aVar.e(4, this.vCm);
            }
            if (this.vCn != null) {
                aVar.e(5, this.vCn);
            }
            if (this.wIh != null) {
                aVar.e(6, this.wIh);
            }
            if (this.vCg != null) {
                aVar.e(7, this.vCg);
            }
            aVar.iz(8, this.vCo);
            aVar.iz(9, this.wIi);
            if (this.wIj != null) {
                aVar.e(10, this.wIj);
            }
            if (this.vLL != null) {
                aVar.iy(14, this.vLL.computeSize());
                this.vLL.writeFields(aVar);
            }
            if (this.vCp != null) {
                aVar.e(15, this.vCp);
            }
            if (this.jBB != null) {
                aVar.e(16, this.jBB);
            }
            aVar.iz(17, this.jBT);
            if (this.vLM != null) {
                aVar.iy(18, this.vLM.computeSize());
                this.vLM.writeFields(aVar);
            }
            aVar.iz(19, this.wIk);
            aVar.iz(20, this.vCj);
            if (this.vHO != null) {
                aVar.e(21, this.vHO);
            }
            if (this.wIl != null) {
                aVar.iy(22, this.wIl.computeSize());
                this.wIl.writeFields(aVar);
            }
            if (this.luH != null) {
                aVar.e(23, this.luH);
            }
            aVar.iz(24, this.wIm);
            if (this.vLK != null) {
                aVar.iy(25, this.vLK.computeSize());
                this.vLK.writeFields(aVar);
            }
            if (this.wIn != null) {
                aVar.e(26, this.wIn);
            }
            if (this.vMl != null) {
                aVar.iy(27, this.vMl.computeSize());
                this.vMl.writeFields(aVar);
            }
            if (this.wIo != null) {
                aVar.e(28, this.wIo);
            }
            if (this.wsL != null) {
                aVar.e(29, this.wsL);
            }
            if (this.wsO != null) {
                aVar.iy(30, this.wsO.computeSize());
                this.wsO.writeFields(aVar);
            }
            if (this.vHR != null) {
                aVar.iy(31, this.vHR.computeSize());
                this.vHR.writeFields(aVar);
            }
            if (this.vMm != null) {
                aVar.iy(32, this.vMm.computeSize());
                this.vMm.writeFields(aVar);
            }
            if (this.vMn != null) {
                aVar.iy(33, this.vMn.computeSize());
                this.vMn.writeFields(aVar);
            }
            if (this.wIp != null) {
                aVar.iy(34, this.wIp.computeSize());
                this.wIp.writeFields(aVar);
            }
            aVar.iz(35, this.vHW);
            AppMethodBeat.o(58921);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.bs(2, this.luF);
            if (this.vAN != null) {
                ix += e.a.a.b.b.a.f(3, this.vAN);
            }
            if (this.vCm != null) {
                ix += e.a.a.b.b.a.f(4, this.vCm);
            }
            if (this.vCn != null) {
                ix += e.a.a.b.b.a.f(5, this.vCn);
            }
            if (this.wIh != null) {
                ix += e.a.a.b.b.a.f(6, this.wIh);
            }
            if (this.vCg != null) {
                ix += e.a.a.b.b.a.f(7, this.vCg);
            }
            ix = (ix + e.a.a.b.b.a.bs(8, this.vCo)) + e.a.a.b.b.a.bs(9, this.wIi);
            if (this.wIj != null) {
                ix += e.a.a.b.b.a.f(10, this.wIj);
            }
            if (this.vLL != null) {
                ix += e.a.a.a.ix(14, this.vLL.computeSize());
            }
            if (this.vCp != null) {
                ix += e.a.a.b.b.a.f(15, this.vCp);
            }
            if (this.jBB != null) {
                ix += e.a.a.b.b.a.f(16, this.jBB);
            }
            ix += e.a.a.b.b.a.bs(17, this.jBT);
            if (this.vLM != null) {
                ix += e.a.a.a.ix(18, this.vLM.computeSize());
            }
            ix = (ix + e.a.a.b.b.a.bs(19, this.wIk)) + e.a.a.b.b.a.bs(20, this.vCj);
            if (this.vHO != null) {
                ix += e.a.a.b.b.a.f(21, this.vHO);
            }
            if (this.wIl != null) {
                ix += e.a.a.a.ix(22, this.wIl.computeSize());
            }
            if (this.luH != null) {
                ix += e.a.a.b.b.a.f(23, this.luH);
            }
            ix += e.a.a.b.b.a.bs(24, this.wIm);
            if (this.vLK != null) {
                ix += e.a.a.a.ix(25, this.vLK.computeSize());
            }
            if (this.wIn != null) {
                ix += e.a.a.b.b.a.f(26, this.wIn);
            }
            if (this.vMl != null) {
                ix += e.a.a.a.ix(27, this.vMl.computeSize());
            }
            if (this.wIo != null) {
                ix += e.a.a.b.b.a.f(28, this.wIo);
            }
            if (this.wsL != null) {
                ix += e.a.a.b.b.a.f(29, this.wsL);
            }
            if (this.wsO != null) {
                ix += e.a.a.a.ix(30, this.wsO.computeSize());
            }
            if (this.vHR != null) {
                ix += e.a.a.a.ix(31, this.vHR.computeSize());
            }
            if (this.vMm != null) {
                ix += e.a.a.a.ix(32, this.vMm.computeSize());
            }
            if (this.vMn != null) {
                ix += e.a.a.a.ix(33, this.vMn.computeSize());
            }
            if (this.wIp != null) {
                ix += e.a.a.a.ix(34, this.wIp.computeSize());
            }
            int bs = ix + e.a.a.b.b.a.bs(35, this.vHW);
            AppMethodBeat.o(58921);
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
                AppMethodBeat.o(58921);
                throw bVar;
            }
            AppMethodBeat.o(58921);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            beh beh = (beh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            mw mwVar;
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
                        beh.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(58921);
                    return 0;
                case 2:
                    beh.luF = aVar3.BTU.vd();
                    AppMethodBeat.o(58921);
                    return 0;
                case 3:
                    beh.vAN = aVar3.BTU.readString();
                    AppMethodBeat.o(58921);
                    return 0;
                case 4:
                    beh.vCm = aVar3.BTU.readString();
                    AppMethodBeat.o(58921);
                    return 0;
                case 5:
                    beh.vCn = aVar3.BTU.readString();
                    AppMethodBeat.o(58921);
                    return 0;
                case 6:
                    beh.wIh = aVar3.BTU.readString();
                    AppMethodBeat.o(58921);
                    return 0;
                case 7:
                    beh.vCg = aVar3.BTU.readString();
                    AppMethodBeat.o(58921);
                    return 0;
                case 8:
                    beh.vCo = aVar3.BTU.vd();
                    AppMethodBeat.o(58921);
                    return 0;
                case 9:
                    beh.wIi = aVar3.BTU.vd();
                    AppMethodBeat.o(58921);
                    return 0;
                case 10:
                    beh.wIj = aVar3.BTU.readString();
                    AppMethodBeat.o(58921);
                    return 0;
                case 14:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        lm lmVar = new lm();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = lmVar.populateBuilderWithField(aVar4, lmVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        beh.vLL = lmVar;
                    }
                    AppMethodBeat.o(58921);
                    return 0;
                case 15:
                    beh.vCp = aVar3.BTU.readString();
                    AppMethodBeat.o(58921);
                    return 0;
                case 16:
                    beh.jBB = aVar3.BTU.readString();
                    AppMethodBeat.o(58921);
                    return 0;
                case 17:
                    beh.jBT = aVar3.BTU.vd();
                    AppMethodBeat.o(58921);
                    return 0;
                case 18:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bdu bdu = new bdu();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bdu.populateBuilderWithField(aVar4, bdu, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        beh.vLM = bdu;
                    }
                    AppMethodBeat.o(58921);
                    return 0;
                case 19:
                    beh.wIk = aVar3.BTU.vd();
                    AppMethodBeat.o(58921);
                    return 0;
                case 20:
                    beh.vCj = aVar3.BTU.vd();
                    AppMethodBeat.o(58921);
                    return 0;
                case 21:
                    beh.vHO = aVar3.BTU.readString();
                    AppMethodBeat.o(58921);
                    return 0;
                case 22:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bkq bkq = new bkq();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bkq.populateBuilderWithField(aVar4, bkq, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        beh.wIl = bkq;
                    }
                    AppMethodBeat.o(58921);
                    return 0;
                case 23:
                    beh.luH = aVar3.BTU.readString();
                    AppMethodBeat.o(58921);
                    return 0;
                case 24:
                    beh.wIm = aVar3.BTU.vd();
                    AppMethodBeat.o(58921);
                    return 0;
                case 25:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ato ato = new ato();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ato.populateBuilderWithField(aVar4, ato, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        beh.vLK = ato;
                    }
                    AppMethodBeat.o(58921);
                    return 0;
                case 26:
                    beh.wIn = aVar3.BTU.readString();
                    AppMethodBeat.o(58921);
                    return 0;
                case 27:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        mwVar = new mw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = mwVar.populateBuilderWithField(aVar4, mwVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        beh.vMl = mwVar;
                    }
                    AppMethodBeat.o(58921);
                    return 0;
                case d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    beh.wIo = aVar3.BTU.readString();
                    AppMethodBeat.o(58921);
                    return 0;
                case 29:
                    beh.wsL = aVar3.BTU.readString();
                    AppMethodBeat.o(58921);
                    return 0;
                case 30:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        beh.wsO = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(58921);
                    return 0;
                case 31:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bzr bzr = new bzr();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bzr.populateBuilderWithField(aVar4, bzr, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        beh.vHR = bzr;
                    }
                    AppMethodBeat.o(58921);
                    return 0;
                case 32:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        mwVar = new mw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = mwVar.populateBuilderWithField(aVar4, mwVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        beh.vMm = mwVar;
                    }
                    AppMethodBeat.o(58921);
                    return 0;
                case 33:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        mwVar = new mw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = mwVar.populateBuilderWithField(aVar4, mwVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        beh.vMn = mwVar;
                    }
                    AppMethodBeat.o(58921);
                    return 0;
                case 34:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bvv bvv = new bvv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bvv.populateBuilderWithField(aVar4, bvv, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        beh.wIp = bvv;
                    }
                    AppMethodBeat.o(58921);
                    return 0;
                case 35:
                    beh.vHW = aVar3.BTU.vd();
                    AppMethodBeat.o(58921);
                    return 0;
                default:
                    AppMethodBeat.o(58921);
                    return -1;
            }
        } else {
            AppMethodBeat.o(58921);
            return -1;
        }
    }
}
