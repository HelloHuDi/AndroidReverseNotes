package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class buy extends a {
    public int ReqType;
    public SKBuiltinBuffer_t wok;
    public String wol;
    public long won;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(62579);
        b bVar;
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wol == null) {
                bVar = new b("Not all required fields were included: KeyWord");
                AppMethodBeat.o(62579);
                throw bVar;
            }
            aVar.iz(1, this.ReqType);
            if (this.wol != null) {
                aVar.e(2, this.wol);
            }
            if (this.wok != null) {
                aVar.iy(3, this.wok.computeSize());
                this.wok.writeFields(aVar);
            }
            aVar.ai(4, this.won);
            AppMethodBeat.o(62579);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.ReqType) + 0;
            if (this.wol != null) {
                bs += e.a.a.b.b.a.f(2, this.wol);
            }
            if (this.wok != null) {
                bs += e.a.a.a.ix(3, this.wok.computeSize());
            }
            bs += e.a.a.b.b.a.o(4, this.won);
            AppMethodBeat.o(62579);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.wol == null) {
                bVar = new b("Not all required fields were included: KeyWord");
                AppMethodBeat.o(62579);
                throw bVar;
            }
            AppMethodBeat.o(62579);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            buy buy = (buy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    buy.ReqType = aVar3.BTU.vd();
                    AppMethodBeat.o(62579);
                    return 0;
                case 2:
                    buy.wol = aVar3.BTU.readString();
                    AppMethodBeat.o(62579);
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
                        buy.wok = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(62579);
                    return 0;
                case 4:
                    buy.won = aVar3.BTU.ve();
                    AppMethodBeat.o(62579);
                    return 0;
                default:
                    AppMethodBeat.o(62579);
                    return -1;
            }
        } else {
            AppMethodBeat.o(62579);
            return -1;
        }
    }
}
