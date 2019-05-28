package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class mn extends a {
    public int jCt;
    public ml vQA;
    public mg vQv;
    public mf vQw;
    public long vQx;
    public mm vQy;
    public mp vQz;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(124300);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.jCt);
            if (this.vQv != null) {
                aVar.iy(2, this.vQv.computeSize());
                this.vQv.writeFields(aVar);
            }
            if (this.vQw != null) {
                aVar.iy(3, this.vQw.computeSize());
                this.vQw.writeFields(aVar);
            }
            aVar.ai(4, this.vQx);
            if (this.vQy != null) {
                aVar.iy(5, this.vQy.computeSize());
                this.vQy.writeFields(aVar);
            }
            if (this.vQz != null) {
                aVar.iy(6, this.vQz.computeSize());
                this.vQz.writeFields(aVar);
            }
            if (this.vQA != null) {
                aVar.iy(7, this.vQA.computeSize());
                this.vQA.writeFields(aVar);
            }
            AppMethodBeat.o(124300);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.jCt) + 0;
            if (this.vQv != null) {
                bs += e.a.a.a.ix(2, this.vQv.computeSize());
            }
            if (this.vQw != null) {
                bs += e.a.a.a.ix(3, this.vQw.computeSize());
            }
            bs += e.a.a.b.b.a.o(4, this.vQx);
            if (this.vQy != null) {
                bs += e.a.a.a.ix(5, this.vQy.computeSize());
            }
            if (this.vQz != null) {
                bs += e.a.a.a.ix(6, this.vQz.computeSize());
            }
            if (this.vQA != null) {
                bs += e.a.a.a.ix(7, this.vQA.computeSize());
            }
            AppMethodBeat.o(124300);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(124300);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            mn mnVar = (mn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    mnVar.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(124300);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        mg mgVar = new mg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = mgVar.populateBuilderWithField(aVar4, mgVar, a.getNextFieldNumber(aVar4))) {
                        }
                        mnVar.vQv = mgVar;
                    }
                    AppMethodBeat.o(124300);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        mf mfVar = new mf();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = mfVar.populateBuilderWithField(aVar4, mfVar, a.getNextFieldNumber(aVar4))) {
                        }
                        mnVar.vQw = mfVar;
                    }
                    AppMethodBeat.o(124300);
                    return 0;
                case 4:
                    mnVar.vQx = aVar3.BTU.ve();
                    AppMethodBeat.o(124300);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        mm mmVar = new mm();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = mmVar.populateBuilderWithField(aVar4, mmVar, a.getNextFieldNumber(aVar4))) {
                        }
                        mnVar.vQy = mmVar;
                    }
                    AppMethodBeat.o(124300);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        mp mpVar = new mp();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = mpVar.populateBuilderWithField(aVar4, mpVar, a.getNextFieldNumber(aVar4))) {
                        }
                        mnVar.vQz = mpVar;
                    }
                    AppMethodBeat.o(124300);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ml mlVar = new ml();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = mlVar.populateBuilderWithField(aVar4, mlVar, a.getNextFieldNumber(aVar4))) {
                        }
                        mnVar.vQA = mlVar;
                    }
                    AppMethodBeat.o(124300);
                    return 0;
                default:
                    AppMethodBeat.o(124300);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124300);
            return -1;
        }
    }
}
