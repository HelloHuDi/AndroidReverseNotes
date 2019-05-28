package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cev extends bsr {
    public String ptv;
    public SKBuiltinBuffer_t vIl;
    public SKBuiltinBuffer_t xen;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56541);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.xen == null) {
                bVar = new b("Not all required fields were included: ObjDesc");
                AppMethodBeat.o(56541);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.xen != null) {
                aVar.iy(2, this.xen.computeSize());
                this.xen.writeFields(aVar);
            }
            if (this.ptv != null) {
                aVar.e(3, this.ptv);
            }
            if (this.vIl != null) {
                aVar.iy(4, this.vIl.computeSize());
                this.vIl.writeFields(aVar);
            }
            AppMethodBeat.o(56541);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.xen != null) {
                ix += e.a.a.a.ix(2, this.xen.computeSize());
            }
            if (this.ptv != null) {
                ix += e.a.a.b.b.a.f(3, this.ptv);
            }
            if (this.vIl != null) {
                ix += e.a.a.a.ix(4, this.vIl.computeSize());
            }
            AppMethodBeat.o(56541);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.xen == null) {
                bVar = new b("Not all required fields were included: ObjDesc");
                AppMethodBeat.o(56541);
                throw bVar;
            }
            AppMethodBeat.o(56541);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cev cev = (cev) objArr[1];
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
                        cev.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(56541);
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
                        cev.xen = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(56541);
                    return 0;
                case 3:
                    cev.ptv = aVar3.BTU.readString();
                    AppMethodBeat.o(56541);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cev.vIl = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(56541);
                    return 0;
                default:
                    AppMethodBeat.o(56541);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56541);
            return -1;
        }
    }
}
