package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class coe extends bsr {
    public int Scene;
    public int fJT;
    public SKBuiltinBuffer_t ptz;
    public int vOq;
    public int vPb;
    public bts wUI;
    public String xiM;
    public int xiO;
    public int xlE;
    public LinkedList<bts> xlF = new LinkedList();
    public int xlG;

    public coe() {
        AppMethodBeat.i(116818);
        AppMethodBeat.o(116818);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(116819);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.ptz == null) {
                bVar = new b("Not all required fields were included: Data");
                AppMethodBeat.o(116819);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.ptz != null) {
                aVar.iy(2, this.ptz.computeSize());
                this.ptz.writeFields(aVar);
            }
            aVar.iz(3, this.vOq);
            if (this.xiM != null) {
                aVar.e(4, this.xiM);
            }
            aVar.iz(5, this.fJT);
            aVar.iz(6, this.xiO);
            aVar.iz(7, this.vPb);
            aVar.iz(8, this.xlE);
            aVar.e(9, 8, this.xlF);
            if (this.wUI != null) {
                aVar.iy(10, this.wUI.computeSize());
                this.wUI.writeFields(aVar);
            }
            aVar.iz(11, this.xlG);
            aVar.iz(12, this.Scene);
            AppMethodBeat.o(116819);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.ptz != null) {
                ix += e.a.a.a.ix(2, this.ptz.computeSize());
            }
            ix += e.a.a.b.b.a.bs(3, this.vOq);
            if (this.xiM != null) {
                ix += e.a.a.b.b.a.f(4, this.xiM);
            }
            ix = ((((ix + e.a.a.b.b.a.bs(5, this.fJT)) + e.a.a.b.b.a.bs(6, this.xiO)) + e.a.a.b.b.a.bs(7, this.vPb)) + e.a.a.b.b.a.bs(8, this.xlE)) + e.a.a.a.c(9, 8, this.xlF);
            if (this.wUI != null) {
                ix += e.a.a.a.ix(10, this.wUI.computeSize());
            }
            int bs = (ix + e.a.a.b.b.a.bs(11, this.xlG)) + e.a.a.b.b.a.bs(12, this.Scene);
            AppMethodBeat.o(116819);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xlF.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.ptz == null) {
                bVar = new b("Not all required fields were included: Data");
                AppMethodBeat.o(116819);
                throw bVar;
            }
            AppMethodBeat.o(116819);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            coe coe = (coe) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            bts bts;
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
                        coe.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(116819);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        coe.ptz = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(116819);
                    return 0;
                case 3:
                    coe.vOq = aVar3.BTU.vd();
                    AppMethodBeat.o(116819);
                    return 0;
                case 4:
                    coe.xiM = aVar3.BTU.readString();
                    AppMethodBeat.o(116819);
                    return 0;
                case 5:
                    coe.fJT = aVar3.BTU.vd();
                    AppMethodBeat.o(116819);
                    return 0;
                case 6:
                    coe.xiO = aVar3.BTU.vd();
                    AppMethodBeat.o(116819);
                    return 0;
                case 7:
                    coe.vPb = aVar3.BTU.vd();
                    AppMethodBeat.o(116819);
                    return 0;
                case 8:
                    coe.xlE = aVar3.BTU.vd();
                    AppMethodBeat.o(116819);
                    return 0;
                case 9:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        coe.xlF.add(bts);
                    }
                    AppMethodBeat.o(116819);
                    return 0;
                case 10:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        coe.wUI = bts;
                    }
                    AppMethodBeat.o(116819);
                    return 0;
                case 11:
                    coe.xlG = aVar3.BTU.vd();
                    AppMethodBeat.o(116819);
                    return 0;
                case 12:
                    coe.Scene = aVar3.BTU.vd();
                    AppMethodBeat.o(116819);
                    return 0;
                default:
                    AppMethodBeat.o(116819);
                    return -1;
            }
        } else {
            AppMethodBeat.o(116819);
            return -1;
        }
    }
}
