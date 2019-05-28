package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class auv extends a {
    public String jBB;
    public int luF;
    public String vLe;
    public String wbw;
    public bts wyX;
    public int wyY;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(73722);
        b bVar;
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wyX == null) {
                bVar = new b("Not all required fields were included: NickName");
                AppMethodBeat.o(73722);
                throw bVar;
            }
            aVar.iz(1, this.luF);
            if (this.wyX != null) {
                aVar.iy(2, this.wyX.computeSize());
                this.wyX.writeFields(aVar);
            }
            if (this.vLe != null) {
                aVar.e(3, this.vLe);
            }
            if (this.wbw != null) {
                aVar.e(4, this.wbw);
            }
            if (this.jBB != null) {
                aVar.e(5, this.jBB);
            }
            aVar.iz(6, this.wyY);
            AppMethodBeat.o(73722);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.luF) + 0;
            if (this.wyX != null) {
                bs += e.a.a.a.ix(2, this.wyX.computeSize());
            }
            if (this.vLe != null) {
                bs += e.a.a.b.b.a.f(3, this.vLe);
            }
            if (this.wbw != null) {
                bs += e.a.a.b.b.a.f(4, this.wbw);
            }
            if (this.jBB != null) {
                bs += e.a.a.b.b.a.f(5, this.jBB);
            }
            bs += e.a.a.b.b.a.bs(6, this.wyY);
            AppMethodBeat.o(73722);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.wyX == null) {
                bVar = new b("Not all required fields were included: NickName");
                AppMethodBeat.o(73722);
                throw bVar;
            }
            AppMethodBeat.o(73722);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            auv auv = (auv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    auv.luF = aVar3.BTU.vd();
                    AppMethodBeat.o(73722);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        bts bts = new bts();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        auv.wyX = bts;
                    }
                    AppMethodBeat.o(73722);
                    return 0;
                case 3:
                    auv.vLe = aVar3.BTU.readString();
                    AppMethodBeat.o(73722);
                    return 0;
                case 4:
                    auv.wbw = aVar3.BTU.readString();
                    AppMethodBeat.o(73722);
                    return 0;
                case 5:
                    auv.jBB = aVar3.BTU.readString();
                    AppMethodBeat.o(73722);
                    return 0;
                case 6:
                    auv.wyY = aVar3.BTU.vd();
                    AppMethodBeat.o(73722);
                    return 0;
                default:
                    AppMethodBeat.o(73722);
                    return -1;
            }
        } else {
            AppMethodBeat.o(73722);
            return -1;
        }
    }
}
