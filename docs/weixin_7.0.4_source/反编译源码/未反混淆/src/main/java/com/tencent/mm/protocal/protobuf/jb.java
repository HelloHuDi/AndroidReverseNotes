package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class jb extends bsr {
    public int offset;
    public String query;
    public long vKU;
    public long vKV;
    public int vKW;
    public long vKX;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(108891);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.ai(2, this.vKU);
            aVar.ai(3, this.vKV);
            if (this.query != null) {
                aVar.e(4, this.query);
            }
            aVar.iz(5, this.offset);
            aVar.iz(6, this.vKW);
            aVar.ai(7, this.vKX);
            AppMethodBeat.o(108891);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + e.a.a.b.b.a.o(2, this.vKU)) + e.a.a.b.b.a.o(3, this.vKV);
            if (this.query != null) {
                ix += e.a.a.b.b.a.f(4, this.query);
            }
            int bs = ((ix + e.a.a.b.b.a.bs(5, this.offset)) + e.a.a.b.b.a.bs(6, this.vKW)) + e.a.a.b.b.a.o(7, this.vKX);
            AppMethodBeat.o(108891);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(108891);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            jb jbVar = (jb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        hl hlVar = new hl();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        jbVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(108891);
                    return 0;
                case 2:
                    jbVar.vKU = aVar3.BTU.ve();
                    AppMethodBeat.o(108891);
                    return 0;
                case 3:
                    jbVar.vKV = aVar3.BTU.ve();
                    AppMethodBeat.o(108891);
                    return 0;
                case 4:
                    jbVar.query = aVar3.BTU.readString();
                    AppMethodBeat.o(108891);
                    return 0;
                case 5:
                    jbVar.offset = aVar3.BTU.vd();
                    AppMethodBeat.o(108891);
                    return 0;
                case 6:
                    jbVar.vKW = aVar3.BTU.vd();
                    AppMethodBeat.o(108891);
                    return 0;
                case 7:
                    jbVar.vKX = aVar3.BTU.ve();
                    AppMethodBeat.o(108891);
                    return 0;
                default:
                    AppMethodBeat.o(108891);
                    return -1;
            }
        } else {
            AppMethodBeat.o(108891);
            return -1;
        }
    }
}
