package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class ahz extends a {
    public int DesignerUin;
    public int OpCode;
    public int wdI;
    public SKBuiltinBuffer_t wok;
    public String wol;
    public int wom;
    public long won;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(62548);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.OpCode);
            aVar.iz(2, this.DesignerUin);
            if (this.wok != null) {
                aVar.iy(3, this.wok.computeSize());
                this.wok.writeFields(aVar);
            }
            aVar.iz(4, this.wdI);
            if (this.wol != null) {
                aVar.e(5, this.wol);
            }
            aVar.iz(6, this.wom);
            aVar.ai(7, this.won);
            AppMethodBeat.o(62548);
            return 0;
        } else if (i == 1) {
            bs = (e.a.a.b.b.a.bs(1, this.OpCode) + 0) + e.a.a.b.b.a.bs(2, this.DesignerUin);
            if (this.wok != null) {
                bs += e.a.a.a.ix(3, this.wok.computeSize());
            }
            bs += e.a.a.b.b.a.bs(4, this.wdI);
            if (this.wol != null) {
                bs += e.a.a.b.b.a.f(5, this.wol);
            }
            bs = (bs + e.a.a.b.b.a.bs(6, this.wom)) + e.a.a.b.b.a.o(7, this.won);
            AppMethodBeat.o(62548);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(62548);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ahz ahz = (ahz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ahz.OpCode = aVar3.BTU.vd();
                    AppMethodBeat.o(62548);
                    return 0;
                case 2:
                    ahz.DesignerUin = aVar3.BTU.vd();
                    AppMethodBeat.o(62548);
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
                        ahz.wok = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(62548);
                    return 0;
                case 4:
                    ahz.wdI = aVar3.BTU.vd();
                    AppMethodBeat.o(62548);
                    return 0;
                case 5:
                    ahz.wol = aVar3.BTU.readString();
                    AppMethodBeat.o(62548);
                    return 0;
                case 6:
                    ahz.wom = aVar3.BTU.vd();
                    AppMethodBeat.o(62548);
                    return 0;
                case 7:
                    ahz.won = aVar3.BTU.ve();
                    AppMethodBeat.o(62548);
                    return 0;
                default:
                    AppMethodBeat.o(62548);
                    return -1;
            }
        } else {
            AppMethodBeat.o(62548);
            return -1;
        }
    }
}
