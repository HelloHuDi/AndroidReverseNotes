package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class iq extends a {
    public int Ret;
    public String jBF;
    public String vKF;
    public String vKK;
    public bbv vKL;
    public asq vKM;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(10159);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.Ret);
            if (this.vKK != null) {
                aVar.e(2, this.vKK);
            }
            if (this.vKL != null) {
                aVar.iy(3, this.vKL.computeSize());
                this.vKL.writeFields(aVar);
            }
            if (this.vKF != null) {
                aVar.e(4, this.vKF);
            }
            if (this.jBF != null) {
                aVar.e(5, this.jBF);
            }
            if (this.vKM != null) {
                aVar.iy(6, this.vKM.computeSize());
                this.vKM.writeFields(aVar);
            }
            AppMethodBeat.o(10159);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.Ret) + 0;
            if (this.vKK != null) {
                bs += e.a.a.b.b.a.f(2, this.vKK);
            }
            if (this.vKL != null) {
                bs += e.a.a.a.ix(3, this.vKL.computeSize());
            }
            if (this.vKF != null) {
                bs += e.a.a.b.b.a.f(4, this.vKF);
            }
            if (this.jBF != null) {
                bs += e.a.a.b.b.a.f(5, this.jBF);
            }
            if (this.vKM != null) {
                bs += e.a.a.a.ix(6, this.vKM.computeSize());
            }
            AppMethodBeat.o(10159);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(10159);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            iq iqVar = (iq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    iqVar.Ret = aVar3.BTU.vd();
                    AppMethodBeat.o(10159);
                    return 0;
                case 2:
                    iqVar.vKK = aVar3.BTU.readString();
                    AppMethodBeat.o(10159);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bbv bbv = new bbv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bbv.populateBuilderWithField(aVar4, bbv, a.getNextFieldNumber(aVar4))) {
                        }
                        iqVar.vKL = bbv;
                    }
                    AppMethodBeat.o(10159);
                    return 0;
                case 4:
                    iqVar.vKF = aVar3.BTU.readString();
                    AppMethodBeat.o(10159);
                    return 0;
                case 5:
                    iqVar.jBF = aVar3.BTU.readString();
                    AppMethodBeat.o(10159);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        asq asq = new asq();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = asq.populateBuilderWithField(aVar4, asq, a.getNextFieldNumber(aVar4))) {
                        }
                        iqVar.vKM = asq;
                    }
                    AppMethodBeat.o(10159);
                    return 0;
                default:
                    AppMethodBeat.o(10159);
                    return -1;
            }
        } else {
            AppMethodBeat.o(10159);
            return -1;
        }
    }
}
