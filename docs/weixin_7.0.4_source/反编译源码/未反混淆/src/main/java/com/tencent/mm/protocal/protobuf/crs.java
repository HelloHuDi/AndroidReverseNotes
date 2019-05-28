package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class crs extends a {
    public SKBuiltinBuffer_t xpk;
    public SKBuiltinBuffer_t xpl;
    public SKBuiltinBuffer_t xpm;
    public SKBuiltinBuffer_t xpn;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(123522);
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xpk != null) {
                aVar.iy(1, this.xpk.computeSize());
                this.xpk.writeFields(aVar);
            }
            if (this.xpl != null) {
                aVar.iy(2, this.xpl.computeSize());
                this.xpl.writeFields(aVar);
            }
            if (this.xpm != null) {
                aVar.iy(3, this.xpm.computeSize());
                this.xpm.writeFields(aVar);
            }
            if (this.xpn != null) {
                aVar.iy(4, this.xpn.computeSize());
                this.xpn.writeFields(aVar);
            }
            AppMethodBeat.o(123522);
            return 0;
        } else if (i == 1) {
            if (this.xpk != null) {
                ix = e.a.a.a.ix(1, this.xpk.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.xpl != null) {
                ix += e.a.a.a.ix(2, this.xpl.computeSize());
            }
            if (this.xpm != null) {
                ix += e.a.a.a.ix(3, this.xpm.computeSize());
            }
            if (this.xpn != null) {
                ix += e.a.a.a.ix(4, this.xpn.computeSize());
            }
            AppMethodBeat.o(123522);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(123522);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            crs crs = (crs) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        crs.xpk = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(123522);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        crs.xpl = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(123522);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        crs.xpm = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(123522);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        crs.xpn = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(123522);
                    return 0;
                default:
                    AppMethodBeat.o(123522);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123522);
            return -1;
        }
    }
}
