package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cla extends bsr {
    public String jBB;
    public int ptw;
    public int ptx;
    public SKBuiltinBuffer_t ptz;
    public int wpi;
    public String xiK;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80201);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.ptz == null) {
                bVar = new b("Not all required fields were included: Data");
                AppMethodBeat.o(80201);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.ptw);
            aVar.iz(3, this.ptx);
            aVar.iz(4, this.wpi);
            if (this.ptz != null) {
                aVar.iy(5, this.ptz.computeSize());
                this.ptz.writeFields(aVar);
            }
            if (this.xiK != null) {
                aVar.e(6, this.xiK);
            }
            if (this.jBB != null) {
                aVar.e(7, this.jBB);
            }
            AppMethodBeat.o(80201);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = ((ix + e.a.a.b.b.a.bs(2, this.ptw)) + e.a.a.b.b.a.bs(3, this.ptx)) + e.a.a.b.b.a.bs(4, this.wpi);
            if (this.ptz != null) {
                ix += e.a.a.a.ix(5, this.ptz.computeSize());
            }
            if (this.xiK != null) {
                ix += e.a.a.b.b.a.f(6, this.xiK);
            }
            if (this.jBB != null) {
                ix += e.a.a.b.b.a.f(7, this.jBB);
            }
            AppMethodBeat.o(80201);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.ptz == null) {
                bVar = new b("Not all required fields were included: Data");
                AppMethodBeat.o(80201);
                throw bVar;
            }
            AppMethodBeat.o(80201);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cla cla = (cla) objArr[1];
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
                        hl hlVar = new hl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cla.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(80201);
                    return 0;
                case 2:
                    cla.ptw = aVar3.BTU.vd();
                    AppMethodBeat.o(80201);
                    return 0;
                case 3:
                    cla.ptx = aVar3.BTU.vd();
                    AppMethodBeat.o(80201);
                    return 0;
                case 4:
                    cla.wpi = aVar3.BTU.vd();
                    AppMethodBeat.o(80201);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cla.ptz = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(80201);
                    return 0;
                case 6:
                    cla.xiK = aVar3.BTU.readString();
                    AppMethodBeat.o(80201);
                    return 0;
                case 7:
                    cla.jBB = aVar3.BTU.readString();
                    AppMethodBeat.o(80201);
                    return 0;
                default:
                    AppMethodBeat.o(80201);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80201);
            return -1;
        }
    }
}
