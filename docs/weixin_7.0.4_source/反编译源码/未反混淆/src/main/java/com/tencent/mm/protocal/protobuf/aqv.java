package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aqv extends bsr {
    public int Scene;
    public String jBB;
    public SKBuiltinBuffer_t vHP;
    public SKBuiltinBuffer_t wlr;
    public String wuI;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28515);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vHP == null) {
                bVar = new b("Not all required fields were included: A2Key");
                AppMethodBeat.o(28515);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.vHP != null) {
                aVar.iy(2, this.vHP.computeSize());
                this.vHP.writeFields(aVar);
            }
            if (this.jBB != null) {
                aVar.e(3, this.jBB);
            }
            aVar.iz(4, this.Scene);
            if (this.wuI != null) {
                aVar.e(5, this.wuI);
            }
            if (this.wlr != null) {
                aVar.iy(6, this.wlr.computeSize());
                this.wlr.writeFields(aVar);
            }
            AppMethodBeat.o(28515);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vHP != null) {
                ix += e.a.a.a.ix(2, this.vHP.computeSize());
            }
            if (this.jBB != null) {
                ix += e.a.a.b.b.a.f(3, this.jBB);
            }
            ix += e.a.a.b.b.a.bs(4, this.Scene);
            if (this.wuI != null) {
                ix += e.a.a.b.b.a.f(5, this.wuI);
            }
            if (this.wlr != null) {
                ix += e.a.a.a.ix(6, this.wlr.computeSize());
            }
            AppMethodBeat.o(28515);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.vHP == null) {
                bVar = new b("Not all required fields were included: A2Key");
                AppMethodBeat.o(28515);
                throw bVar;
            }
            AppMethodBeat.o(28515);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aqv aqv = (aqv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
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
                        aqv.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(28515);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        aqv.vHP = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(28515);
                    return 0;
                case 3:
                    aqv.jBB = aVar3.BTU.readString();
                    AppMethodBeat.o(28515);
                    return 0;
                case 4:
                    aqv.Scene = aVar3.BTU.vd();
                    AppMethodBeat.o(28515);
                    return 0;
                case 5:
                    aqv.wuI = aVar3.BTU.readString();
                    AppMethodBeat.o(28515);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        aqv.wlr = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(28515);
                    return 0;
                default:
                    AppMethodBeat.o(28515);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28515);
            return -1;
        }
    }
}
