package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class sg extends btd {
    public int jBT;
    public clu vZA;
    public bod vZB;
    public int vZC;
    public cof vZz;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28363);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(28363);
                throw bVar;
            } else if (this.vZz == null) {
                bVar = new b("Not all required fields were included: TransRes");
                AppMethodBeat.o(28363);
                throw bVar;
            } else if (this.vZA == null) {
                bVar = new b("Not all required fields were included: UploadCtx");
                AppMethodBeat.o(28363);
                throw bVar;
            } else if (this.vZB == null) {
                bVar = new b("Not all required fields were included: QueryCtx");
                AppMethodBeat.o(28363);
                throw bVar;
            } else {
                if (this.BaseResponse != null) {
                    aVar.iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                aVar.iz(2, this.jBT);
                if (this.vZz != null) {
                    aVar.iy(3, this.vZz.computeSize());
                    this.vZz.writeFields(aVar);
                }
                if (this.vZA != null) {
                    aVar.iy(4, this.vZA.computeSize());
                    this.vZA.writeFields(aVar);
                }
                if (this.vZB != null) {
                    aVar.iy(5, this.vZB.computeSize());
                    this.vZB.writeFields(aVar);
                }
                aVar.iz(6, this.vZC);
                AppMethodBeat.o(28363);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.bs(2, this.jBT);
            if (this.vZz != null) {
                ix += e.a.a.a.ix(3, this.vZz.computeSize());
            }
            if (this.vZA != null) {
                ix += e.a.a.a.ix(4, this.vZA.computeSize());
            }
            if (this.vZB != null) {
                ix += e.a.a.a.ix(5, this.vZB.computeSize());
            }
            int bs = ix + e.a.a.b.b.a.bs(6, this.vZC);
            AppMethodBeat.o(28363);
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
                AppMethodBeat.o(28363);
                throw bVar;
            } else if (this.vZz == null) {
                bVar = new b("Not all required fields were included: TransRes");
                AppMethodBeat.o(28363);
                throw bVar;
            } else if (this.vZA == null) {
                bVar = new b("Not all required fields were included: UploadCtx");
                AppMethodBeat.o(28363);
                throw bVar;
            } else if (this.vZB == null) {
                bVar = new b("Not all required fields were included: QueryCtx");
                AppMethodBeat.o(28363);
                throw bVar;
            } else {
                AppMethodBeat.o(28363);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            sg sgVar = (sg) objArr[1];
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
                        sgVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(28363);
                    return 0;
                case 2:
                    sgVar.jBT = aVar3.BTU.vd();
                    AppMethodBeat.o(28363);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cof cof = new cof();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cof.populateBuilderWithField(aVar4, cof, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        sgVar.vZz = cof;
                    }
                    AppMethodBeat.o(28363);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        clu clu = new clu();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = clu.populateBuilderWithField(aVar4, clu, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        sgVar.vZA = clu;
                    }
                    AppMethodBeat.o(28363);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bod bod = new bod();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bod.populateBuilderWithField(aVar4, bod, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        sgVar.vZB = bod;
                    }
                    AppMethodBeat.o(28363);
                    return 0;
                case 6:
                    sgVar.vZC = aVar3.BTU.vd();
                    AppMethodBeat.o(28363);
                    return 0;
                default:
                    AppMethodBeat.o(28363);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28363);
            return -1;
        }
    }
}
