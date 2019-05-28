package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class up extends bsr {
    public int Scene;
    public int ehB;
    public LinkedList<bay> vEh = new LinkedList();
    public bts wcc;
    public SKBuiltinBuffer_t wcd;

    public up() {
        AppMethodBeat.i(5568);
        AppMethodBeat.o(5568);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(5569);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wcc == null) {
                bVar = new b("Not all required fields were included: Topic");
                AppMethodBeat.o(5569);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.wcc != null) {
                aVar.iy(2, this.wcc.computeSize());
                this.wcc.writeFields(aVar);
            }
            aVar.iz(3, this.ehB);
            aVar.e(4, 8, this.vEh);
            aVar.iz(5, this.Scene);
            if (this.wcd != null) {
                aVar.iy(6, this.wcd.computeSize());
                this.wcd.writeFields(aVar);
            }
            AppMethodBeat.o(5569);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wcc != null) {
                ix += e.a.a.a.ix(2, this.wcc.computeSize());
            }
            ix = ((ix + e.a.a.b.b.a.bs(3, this.ehB)) + e.a.a.a.c(4, 8, this.vEh)) + e.a.a.b.b.a.bs(5, this.Scene);
            if (this.wcd != null) {
                ix += e.a.a.a.ix(6, this.wcd.computeSize());
            }
            AppMethodBeat.o(5569);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vEh.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.wcc == null) {
                bVar = new b("Not all required fields were included: Topic");
                AppMethodBeat.o(5569);
                throw bVar;
            }
            AppMethodBeat.o(5569);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            up upVar = (up) objArr[1];
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
                        upVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(5569);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        upVar.wcc = bts;
                    }
                    AppMethodBeat.o(5569);
                    return 0;
                case 3:
                    upVar.ehB = aVar3.BTU.vd();
                    AppMethodBeat.o(5569);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bay bay = new bay();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bay.populateBuilderWithField(aVar4, bay, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        upVar.vEh.add(bay);
                    }
                    AppMethodBeat.o(5569);
                    return 0;
                case 5:
                    upVar.Scene = aVar3.BTU.vd();
                    AppMethodBeat.o(5569);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        upVar.wcd = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(5569);
                    return 0;
                default:
                    AppMethodBeat.o(5569);
                    return -1;
            }
        } else {
            AppMethodBeat.o(5569);
            return -1;
        }
    }
}
