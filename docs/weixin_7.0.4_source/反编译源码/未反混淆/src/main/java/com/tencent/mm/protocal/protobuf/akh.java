package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class akh extends bsr {
    public int Scene;
    public int vIJ;
    public axx wcn;
    public String wkD;
    public SKBuiltinBuffer_t wpP;
    public int wpQ;
    public int wpR;
    public LinkedList<bkh> wpS = new LinkedList();
    public int wpT;

    public akh() {
        AppMethodBeat.i(28445);
        AppMethodBeat.o(28445);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28446);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wcn == null) {
                bVar = new b("Not all required fields were included: Loc");
                AppMethodBeat.o(28446);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.vIJ);
            aVar.iz(3, this.Scene);
            if (this.wpP != null) {
                aVar.iy(4, this.wpP.computeSize());
                this.wpP.writeFields(aVar);
            }
            if (this.wcn != null) {
                aVar.iy(5, this.wcn.computeSize());
                this.wcn.writeFields(aVar);
            }
            if (this.wkD != null) {
                aVar.e(6, this.wkD);
            }
            aVar.iz(7, this.wpQ);
            aVar.iz(8, this.wpR);
            aVar.e(11, 8, this.wpS);
            aVar.iz(12, this.wpT);
            AppMethodBeat.o(28446);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + e.a.a.b.b.a.bs(2, this.vIJ)) + e.a.a.b.b.a.bs(3, this.Scene);
            if (this.wpP != null) {
                ix += e.a.a.a.ix(4, this.wpP.computeSize());
            }
            if (this.wcn != null) {
                ix += e.a.a.a.ix(5, this.wcn.computeSize());
            }
            if (this.wkD != null) {
                ix += e.a.a.b.b.a.f(6, this.wkD);
            }
            int bs = (((ix + e.a.a.b.b.a.bs(7, this.wpQ)) + e.a.a.b.b.a.bs(8, this.wpR)) + e.a.a.a.c(11, 8, this.wpS)) + e.a.a.b.b.a.bs(12, this.wpT);
            AppMethodBeat.o(28446);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wpS.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.wcn == null) {
                bVar = new b("Not all required fields were included: Loc");
                AppMethodBeat.o(28446);
                throw bVar;
            }
            AppMethodBeat.o(28446);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            akh akh = (akh) objArr[1];
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
                        hl hlVar = new hl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        akh.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(28446);
                    return 0;
                case 2:
                    akh.vIJ = aVar3.BTU.vd();
                    AppMethodBeat.o(28446);
                    return 0;
                case 3:
                    akh.Scene = aVar3.BTU.vd();
                    AppMethodBeat.o(28446);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        akh.wpP = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(28446);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        axx axx = new axx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = axx.populateBuilderWithField(aVar4, axx, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        akh.wcn = axx;
                    }
                    AppMethodBeat.o(28446);
                    return 0;
                case 6:
                    akh.wkD = aVar3.BTU.readString();
                    AppMethodBeat.o(28446);
                    return 0;
                case 7:
                    akh.wpQ = aVar3.BTU.vd();
                    AppMethodBeat.o(28446);
                    return 0;
                case 8:
                    akh.wpR = aVar3.BTU.vd();
                    AppMethodBeat.o(28446);
                    return 0;
                case 11:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bkh bkh = new bkh();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bkh.populateBuilderWithField(aVar4, bkh, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        akh.wpS.add(bkh);
                    }
                    AppMethodBeat.o(28446);
                    return 0;
                case 12:
                    akh.wpT = aVar3.BTU.vd();
                    AppMethodBeat.o(28446);
                    return 0;
                default:
                    AppMethodBeat.o(28446);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28446);
            return -1;
        }
    }
}
