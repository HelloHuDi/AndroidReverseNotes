package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.btd;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ba extends btd {
    public e mZk;
    public String nbJ;
    public LinkedList<v> nbK = new LinkedList();
    public cf nbL;
    public bv nbM;
    public bs nbN;
    public cv nbO;
    public LinkedList<w> nbP = new LinkedList();
    public da nbQ;
    public bu nbR;
    public br nbS;

    public ba() {
        AppMethodBeat.i(111595);
        AppMethodBeat.o(111595);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111596);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(111596);
                throw bVar;
            } else if (this.mZk == null) {
                bVar = new b("Not all required fields were included: AppItem");
                AppMethodBeat.o(111596);
                throw bVar;
            } else if (this.nbJ == null) {
                bVar = new b("Not all required fields were included: BackGroundURL");
                AppMethodBeat.o(111596);
                throw bVar;
            } else {
                if (this.BaseResponse != null) {
                    aVar.iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                if (this.mZk != null) {
                    aVar.iy(2, this.mZk.computeSize());
                    this.mZk.writeFields(aVar);
                }
                if (this.nbJ != null) {
                    aVar.e(3, this.nbJ);
                }
                aVar.e(4, 8, this.nbK);
                if (this.nbL != null) {
                    aVar.iy(5, this.nbL.computeSize());
                    this.nbL.writeFields(aVar);
                }
                if (this.nbM != null) {
                    aVar.iy(7, this.nbM.computeSize());
                    this.nbM.writeFields(aVar);
                }
                if (this.nbN != null) {
                    aVar.iy(8, this.nbN.computeSize());
                    this.nbN.writeFields(aVar);
                }
                if (this.nbO != null) {
                    aVar.iy(9, this.nbO.computeSize());
                    this.nbO.writeFields(aVar);
                }
                aVar.e(10, 8, this.nbP);
                if (this.nbQ != null) {
                    aVar.iy(11, this.nbQ.computeSize());
                    this.nbQ.writeFields(aVar);
                }
                if (this.nbR != null) {
                    aVar.iy(12, this.nbR.computeSize());
                    this.nbR.writeFields(aVar);
                }
                if (this.nbS != null) {
                    aVar.iy(13, this.nbS.computeSize());
                    this.nbS.writeFields(aVar);
                }
                AppMethodBeat.o(111596);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.mZk != null) {
                ix += e.a.a.a.ix(2, this.mZk.computeSize());
            }
            if (this.nbJ != null) {
                ix += e.a.a.b.b.a.f(3, this.nbJ);
            }
            ix += e.a.a.a.c(4, 8, this.nbK);
            if (this.nbL != null) {
                ix += e.a.a.a.ix(5, this.nbL.computeSize());
            }
            if (this.nbM != null) {
                ix += e.a.a.a.ix(7, this.nbM.computeSize());
            }
            if (this.nbN != null) {
                ix += e.a.a.a.ix(8, this.nbN.computeSize());
            }
            if (this.nbO != null) {
                ix += e.a.a.a.ix(9, this.nbO.computeSize());
            }
            ix += e.a.a.a.c(10, 8, this.nbP);
            if (this.nbQ != null) {
                ix += e.a.a.a.ix(11, this.nbQ.computeSize());
            }
            if (this.nbR != null) {
                ix += e.a.a.a.ix(12, this.nbR.computeSize());
            }
            if (this.nbS != null) {
                ix += e.a.a.a.ix(13, this.nbS.computeSize());
            }
            AppMethodBeat.o(111596);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.nbK.clear();
            this.nbP.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(111596);
                throw bVar;
            } else if (this.mZk == null) {
                bVar = new b("Not all required fields were included: AppItem");
                AppMethodBeat.o(111596);
                throw bVar;
            } else if (this.nbJ == null) {
                bVar = new b("Not all required fields were included: BackGroundURL");
                AppMethodBeat.o(111596);
                throw bVar;
            } else {
                AppMethodBeat.o(111596);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ba baVar = (ba) objArr[1];
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
                        baVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(111596);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        e eVar = new e();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eVar.populateBuilderWithField(aVar4, eVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        baVar.mZk = eVar;
                    }
                    AppMethodBeat.o(111596);
                    return 0;
                case 3:
                    baVar.nbJ = aVar3.BTU.readString();
                    AppMethodBeat.o(111596);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        v vVar = new v();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = vVar.populateBuilderWithField(aVar4, vVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        baVar.nbK.add(vVar);
                    }
                    AppMethodBeat.o(111596);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cf cfVar = new cf();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cfVar.populateBuilderWithField(aVar4, cfVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        baVar.nbL = cfVar;
                    }
                    AppMethodBeat.o(111596);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bv bvVar = new bv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bvVar.populateBuilderWithField(aVar4, bvVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        baVar.nbM = bvVar;
                    }
                    AppMethodBeat.o(111596);
                    return 0;
                case 8:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bs bsVar = new bs();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bsVar.populateBuilderWithField(aVar4, bsVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        baVar.nbN = bsVar;
                    }
                    AppMethodBeat.o(111596);
                    return 0;
                case 9:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cv cvVar = new cv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cvVar.populateBuilderWithField(aVar4, cvVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        baVar.nbO = cvVar;
                    }
                    AppMethodBeat.o(111596);
                    return 0;
                case 10:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        w wVar = new w();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = wVar.populateBuilderWithField(aVar4, wVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        baVar.nbP.add(wVar);
                    }
                    AppMethodBeat.o(111596);
                    return 0;
                case 11:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        da daVar = new da();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = daVar.populateBuilderWithField(aVar4, daVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        baVar.nbQ = daVar;
                    }
                    AppMethodBeat.o(111596);
                    return 0;
                case 12:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bu buVar = new bu();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = buVar.populateBuilderWithField(aVar4, buVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        baVar.nbR = buVar;
                    }
                    AppMethodBeat.o(111596);
                    return 0;
                case 13:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        br brVar = new br();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = brVar.populateBuilderWithField(aVar4, brVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        baVar.nbS = brVar;
                    }
                    AppMethodBeat.o(111596);
                    return 0;
                default:
                    AppMethodBeat.o(111596);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111596);
            return -1;
        }
    }
}
