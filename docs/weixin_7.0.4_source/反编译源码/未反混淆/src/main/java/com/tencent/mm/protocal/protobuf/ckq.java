package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ckq extends bsr {
    public String fKh;
    public String jBB;
    public int jCt;
    public int ptw;
    public int ptx;
    public int pty;
    public SKBuiltinBuffer_t ptz;
    public int vFE;
    public String wdO;
    public String xit;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28687);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.ptz == null) {
                bVar = new b("Not all required fields were included: Data");
                AppMethodBeat.o(28687);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.fKh != null) {
                aVar.e(2, this.fKh);
            }
            aVar.iz(3, this.vFE);
            if (this.xit != null) {
                aVar.e(4, this.xit);
            }
            if (this.jBB != null) {
                aVar.e(5, this.jBB);
            }
            aVar.iz(6, this.ptw);
            aVar.iz(7, this.ptx);
            aVar.iz(8, this.pty);
            if (this.ptz != null) {
                aVar.iy(9, this.ptz.computeSize());
                this.ptz.writeFields(aVar);
            }
            aVar.iz(10, this.jCt);
            if (this.wdO != null) {
                aVar.e(11, this.wdO);
            }
            AppMethodBeat.o(28687);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.fKh != null) {
                ix += e.a.a.b.b.a.f(2, this.fKh);
            }
            ix += e.a.a.b.b.a.bs(3, this.vFE);
            if (this.xit != null) {
                ix += e.a.a.b.b.a.f(4, this.xit);
            }
            if (this.jBB != null) {
                ix += e.a.a.b.b.a.f(5, this.jBB);
            }
            ix = ((ix + e.a.a.b.b.a.bs(6, this.ptw)) + e.a.a.b.b.a.bs(7, this.ptx)) + e.a.a.b.b.a.bs(8, this.pty);
            if (this.ptz != null) {
                ix += e.a.a.a.ix(9, this.ptz.computeSize());
            }
            ix += e.a.a.b.b.a.bs(10, this.jCt);
            if (this.wdO != null) {
                ix += e.a.a.b.b.a.f(11, this.wdO);
            }
            AppMethodBeat.o(28687);
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
                AppMethodBeat.o(28687);
                throw bVar;
            }
            AppMethodBeat.o(28687);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ckq ckq = (ckq) objArr[1];
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
                        ckq.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(28687);
                    return 0;
                case 2:
                    ckq.fKh = aVar3.BTU.readString();
                    AppMethodBeat.o(28687);
                    return 0;
                case 3:
                    ckq.vFE = aVar3.BTU.vd();
                    AppMethodBeat.o(28687);
                    return 0;
                case 4:
                    ckq.xit = aVar3.BTU.readString();
                    AppMethodBeat.o(28687);
                    return 0;
                case 5:
                    ckq.jBB = aVar3.BTU.readString();
                    AppMethodBeat.o(28687);
                    return 0;
                case 6:
                    ckq.ptw = aVar3.BTU.vd();
                    AppMethodBeat.o(28687);
                    return 0;
                case 7:
                    ckq.ptx = aVar3.BTU.vd();
                    AppMethodBeat.o(28687);
                    return 0;
                case 8:
                    ckq.pty = aVar3.BTU.vd();
                    AppMethodBeat.o(28687);
                    return 0;
                case 9:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ckq.ptz = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(28687);
                    return 0;
                case 10:
                    ckq.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(28687);
                    return 0;
                case 11:
                    ckq.wdO = aVar3.BTU.readString();
                    AppMethodBeat.o(28687);
                    return 0;
                default:
                    AppMethodBeat.o(28687);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28687);
            return -1;
        }
    }
}
