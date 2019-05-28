package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ahq extends btd {
    public String ID;
    public int Scene;
    public long jBP;
    public int jCt;
    public int vIN;
    public LinkedList<ua> vIO = new LinkedList();
    public String vIP;
    public String vIQ;
    public String vIR;
    public int vIV;
    public String vIW;
    public String vIX;
    public SKBuiltinBuffer_t vIn;
    public String wnV;

    public ahq() {
        AppMethodBeat.i(28423);
        AppMethodBeat.o(28423);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28424);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(28424);
                throw bVar;
            } else if (this.vIn == null) {
                bVar = new b("Not all required fields were included: Key");
                AppMethodBeat.o(28424);
                throw bVar;
            } else {
                if (this.BaseResponse != null) {
                    aVar.iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                if (this.ID != null) {
                    aVar.e(2, this.ID);
                }
                if (this.vIn != null) {
                    aVar.iy(3, this.vIn.computeSize());
                    this.vIn.writeFields(aVar);
                }
                if (this.vIW != null) {
                    aVar.e(4, this.vIW);
                }
                if (this.vIX != null) {
                    aVar.e(5, this.vIX);
                }
                aVar.iz(6, this.jCt);
                aVar.iz(7, this.vIN);
                aVar.e(8, 8, this.vIO);
                if (this.wnV != null) {
                    aVar.e(9, this.wnV);
                }
                if (this.vIP != null) {
                    aVar.e(10, this.vIP);
                }
                if (this.vIQ != null) {
                    aVar.e(11, this.vIQ);
                }
                aVar.iz(12, this.vIV);
                aVar.iz(13, this.Scene);
                aVar.ai(14, this.jBP);
                if (this.vIR != null) {
                    aVar.e(15, this.vIR);
                }
                AppMethodBeat.o(28424);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.ID != null) {
                ix += e.a.a.b.b.a.f(2, this.ID);
            }
            if (this.vIn != null) {
                ix += e.a.a.a.ix(3, this.vIn.computeSize());
            }
            if (this.vIW != null) {
                ix += e.a.a.b.b.a.f(4, this.vIW);
            }
            if (this.vIX != null) {
                ix += e.a.a.b.b.a.f(5, this.vIX);
            }
            ix = ((ix + e.a.a.b.b.a.bs(6, this.jCt)) + e.a.a.b.b.a.bs(7, this.vIN)) + e.a.a.a.c(8, 8, this.vIO);
            if (this.wnV != null) {
                ix += e.a.a.b.b.a.f(9, this.wnV);
            }
            if (this.vIP != null) {
                ix += e.a.a.b.b.a.f(10, this.vIP);
            }
            if (this.vIQ != null) {
                ix += e.a.a.b.b.a.f(11, this.vIQ);
            }
            ix = ((ix + e.a.a.b.b.a.bs(12, this.vIV)) + e.a.a.b.b.a.bs(13, this.Scene)) + e.a.a.b.b.a.o(14, this.jBP);
            if (this.vIR != null) {
                ix += e.a.a.b.b.a.f(15, this.vIR);
            }
            AppMethodBeat.o(28424);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vIO.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(28424);
                throw bVar;
            } else if (this.vIn == null) {
                bVar = new b("Not all required fields were included: Key");
                AppMethodBeat.o(28424);
                throw bVar;
            } else {
                AppMethodBeat.o(28424);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ahq ahq = (ahq) objArr[1];
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
                        ahq.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(28424);
                    return 0;
                case 2:
                    ahq.ID = aVar3.BTU.readString();
                    AppMethodBeat.o(28424);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ahq.vIn = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(28424);
                    return 0;
                case 4:
                    ahq.vIW = aVar3.BTU.readString();
                    AppMethodBeat.o(28424);
                    return 0;
                case 5:
                    ahq.vIX = aVar3.BTU.readString();
                    AppMethodBeat.o(28424);
                    return 0;
                case 6:
                    ahq.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(28424);
                    return 0;
                case 7:
                    ahq.vIN = aVar3.BTU.vd();
                    AppMethodBeat.o(28424);
                    return 0;
                case 8:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ua uaVar = new ua();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = uaVar.populateBuilderWithField(aVar4, uaVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ahq.vIO.add(uaVar);
                    }
                    AppMethodBeat.o(28424);
                    return 0;
                case 9:
                    ahq.wnV = aVar3.BTU.readString();
                    AppMethodBeat.o(28424);
                    return 0;
                case 10:
                    ahq.vIP = aVar3.BTU.readString();
                    AppMethodBeat.o(28424);
                    return 0;
                case 11:
                    ahq.vIQ = aVar3.BTU.readString();
                    AppMethodBeat.o(28424);
                    return 0;
                case 12:
                    ahq.vIV = aVar3.BTU.vd();
                    AppMethodBeat.o(28424);
                    return 0;
                case 13:
                    ahq.Scene = aVar3.BTU.vd();
                    AppMethodBeat.o(28424);
                    return 0;
                case 14:
                    ahq.jBP = aVar3.BTU.ve();
                    AppMethodBeat.o(28424);
                    return 0;
                case 15:
                    ahq.vIR = aVar3.BTU.readString();
                    AppMethodBeat.o(28424);
                    return 0;
                default:
                    AppMethodBeat.o(28424);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28424);
            return -1;
        }
    }
}
