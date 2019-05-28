package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class yc extends a {
    public int jCt;
    public String ndF;
    public int ptw;
    public int ptx;
    public String vEG;
    public String wdO;
    public SKBuiltinBuffer_t wdP;
    public String wdQ;
    public String wdR;
    public String wdS;
    public int wdT;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(53871);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wdP == null) {
                bVar = new b("Not all required fields were included: EmojiBuffer");
                AppMethodBeat.o(53871);
                throw bVar;
            }
            if (this.wdO != null) {
                aVar.e(1, this.wdO);
            }
            aVar.iz(2, this.ptx);
            aVar.iz(3, this.ptw);
            if (this.wdP != null) {
                aVar.iy(4, this.wdP.computeSize());
                this.wdP.writeFields(aVar);
            }
            aVar.iz(5, this.jCt);
            if (this.ndF != null) {
                aVar.e(6, this.ndF);
            }
            if (this.wdQ != null) {
                aVar.e(7, this.wdQ);
            }
            if (this.wdR != null) {
                aVar.e(8, this.wdR);
            }
            if (this.wdS != null) {
                aVar.e(9, this.wdS);
            }
            if (this.vEG != null) {
                aVar.e(10, this.vEG);
            }
            aVar.iz(11, this.wdT);
            AppMethodBeat.o(53871);
            return 0;
        } else if (i == 1) {
            if (this.wdO != null) {
                f = e.a.a.b.b.a.f(1, this.wdO) + 0;
            } else {
                f = 0;
            }
            f = (f + e.a.a.b.b.a.bs(2, this.ptx)) + e.a.a.b.b.a.bs(3, this.ptw);
            if (this.wdP != null) {
                f += e.a.a.a.ix(4, this.wdP.computeSize());
            }
            f += e.a.a.b.b.a.bs(5, this.jCt);
            if (this.ndF != null) {
                f += e.a.a.b.b.a.f(6, this.ndF);
            }
            if (this.wdQ != null) {
                f += e.a.a.b.b.a.f(7, this.wdQ);
            }
            if (this.wdR != null) {
                f += e.a.a.b.b.a.f(8, this.wdR);
            }
            if (this.wdS != null) {
                f += e.a.a.b.b.a.f(9, this.wdS);
            }
            if (this.vEG != null) {
                f += e.a.a.b.b.a.f(10, this.vEG);
            }
            int bs = f + e.a.a.b.b.a.bs(11, this.wdT);
            AppMethodBeat.o(53871);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.wdP == null) {
                bVar = new b("Not all required fields were included: EmojiBuffer");
                AppMethodBeat.o(53871);
                throw bVar;
            }
            AppMethodBeat.o(53871);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            yc ycVar = (yc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ycVar.wdO = aVar3.BTU.readString();
                    AppMethodBeat.o(53871);
                    return 0;
                case 2:
                    ycVar.ptx = aVar3.BTU.vd();
                    AppMethodBeat.o(53871);
                    return 0;
                case 3:
                    ycVar.ptw = aVar3.BTU.vd();
                    AppMethodBeat.o(53871);
                    return 0;
                case 4:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        ycVar.wdP = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(53871);
                    return 0;
                case 5:
                    ycVar.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(53871);
                    return 0;
                case 6:
                    ycVar.ndF = aVar3.BTU.readString();
                    AppMethodBeat.o(53871);
                    return 0;
                case 7:
                    ycVar.wdQ = aVar3.BTU.readString();
                    AppMethodBeat.o(53871);
                    return 0;
                case 8:
                    ycVar.wdR = aVar3.BTU.readString();
                    AppMethodBeat.o(53871);
                    return 0;
                case 9:
                    ycVar.wdS = aVar3.BTU.readString();
                    AppMethodBeat.o(53871);
                    return 0;
                case 10:
                    ycVar.vEG = aVar3.BTU.readString();
                    AppMethodBeat.o(53871);
                    return 0;
                case 11:
                    ycVar.wdT = aVar3.BTU.vd();
                    AppMethodBeat.o(53871);
                    return 0;
                default:
                    AppMethodBeat.o(53871);
                    return -1;
            }
        } else {
            AppMethodBeat.o(53871);
            return -1;
        }
    }
}
