package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class asu extends a {
    public int jCt;
    public int pcX;
    public SKBuiltinBuffer_t vJd;
    public long wwE;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28520);
        b bVar;
        int o;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vJd == null) {
                bVar = new b("Not all required fields were included: Buffer");
                AppMethodBeat.o(28520);
                throw bVar;
            }
            aVar.ai(1, this.wwE);
            aVar.iz(2, this.pcX);
            if (this.vJd != null) {
                aVar.iy(3, this.vJd.computeSize());
                this.vJd.writeFields(aVar);
            }
            aVar.iz(4, this.jCt);
            AppMethodBeat.o(28520);
            return 0;
        } else if (i == 1) {
            o = (e.a.a.b.b.a.o(1, this.wwE) + 0) + e.a.a.b.b.a.bs(2, this.pcX);
            if (this.vJd != null) {
                o += e.a.a.a.ix(3, this.vJd.computeSize());
            }
            o += e.a.a.b.b.a.bs(4, this.jCt);
            AppMethodBeat.o(28520);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (o = a.getNextFieldNumber(aVar2); o > 0; o = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, o)) {
                    aVar2.ems();
                }
            }
            if (this.vJd == null) {
                bVar = new b("Not all required fields were included: Buffer");
                AppMethodBeat.o(28520);
                throw bVar;
            }
            AppMethodBeat.o(28520);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            asu asu = (asu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    asu.wwE = aVar3.BTU.ve();
                    AppMethodBeat.o(28520);
                    return 0;
                case 2:
                    asu.pcX = aVar3.BTU.vd();
                    AppMethodBeat.o(28520);
                    return 0;
                case 3:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        asu.vJd = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(28520);
                    return 0;
                case 4:
                    asu.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(28520);
                    return 0;
                default:
                    AppMethodBeat.o(28520);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28520);
            return -1;
        }
    }
}
