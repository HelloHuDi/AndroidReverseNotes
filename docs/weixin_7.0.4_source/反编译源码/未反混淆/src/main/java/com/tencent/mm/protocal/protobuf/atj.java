package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class atj extends a {
    public int kbK;
    public String kdf;
    public int state;
    public int tob;
    public int vNm;
    public String vYh;
    public long wch;
    public String wpp;
    public String wxs;
    public bkc wxt;
    public int wxu;
    public int wxv;
    public String wxw;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48871);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wpp != null) {
                aVar.e(1, this.wpp);
            }
            if (this.vYh != null) {
                aVar.e(2, this.vYh);
            }
            aVar.ai(3, this.wch);
            aVar.iz(4, this.state);
            if (this.wxs != null) {
                aVar.e(5, this.wxs);
            }
            aVar.iz(6, this.tob);
            if (this.wxt != null) {
                aVar.iy(7, this.wxt.computeSize());
                this.wxt.writeFields(aVar);
            }
            aVar.iz(8, this.vNm);
            aVar.iz(9, this.kbK);
            aVar.iz(10, this.wxu);
            aVar.iz(11, this.wxv);
            if (this.wxw != null) {
                aVar.e(12, this.wxw);
            }
            if (this.kdf != null) {
                aVar.e(13, this.kdf);
            }
            AppMethodBeat.o(48871);
            return 0;
        } else if (i == 1) {
            if (this.wpp != null) {
                f = e.a.a.b.b.a.f(1, this.wpp) + 0;
            } else {
                f = 0;
            }
            if (this.vYh != null) {
                f += e.a.a.b.b.a.f(2, this.vYh);
            }
            f = (f + e.a.a.b.b.a.o(3, this.wch)) + e.a.a.b.b.a.bs(4, this.state);
            if (this.wxs != null) {
                f += e.a.a.b.b.a.f(5, this.wxs);
            }
            f += e.a.a.b.b.a.bs(6, this.tob);
            if (this.wxt != null) {
                f += e.a.a.a.ix(7, this.wxt.computeSize());
            }
            f = (((f + e.a.a.b.b.a.bs(8, this.vNm)) + e.a.a.b.b.a.bs(9, this.kbK)) + e.a.a.b.b.a.bs(10, this.wxu)) + e.a.a.b.b.a.bs(11, this.wxv);
            if (this.wxw != null) {
                f += e.a.a.b.b.a.f(12, this.wxw);
            }
            if (this.kdf != null) {
                f += e.a.a.b.b.a.f(13, this.kdf);
            }
            AppMethodBeat.o(48871);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48871);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            atj atj = (atj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    atj.wpp = aVar3.BTU.readString();
                    AppMethodBeat.o(48871);
                    return 0;
                case 2:
                    atj.vYh = aVar3.BTU.readString();
                    AppMethodBeat.o(48871);
                    return 0;
                case 3:
                    atj.wch = aVar3.BTU.ve();
                    AppMethodBeat.o(48871);
                    return 0;
                case 4:
                    atj.state = aVar3.BTU.vd();
                    AppMethodBeat.o(48871);
                    return 0;
                case 5:
                    atj.wxs = aVar3.BTU.readString();
                    AppMethodBeat.o(48871);
                    return 0;
                case 6:
                    atj.tob = aVar3.BTU.vd();
                    AppMethodBeat.o(48871);
                    return 0;
                case 7:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        bkc bkc = new bkc();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bkc.populateBuilderWithField(aVar4, bkc, a.getNextFieldNumber(aVar4))) {
                        }
                        atj.wxt = bkc;
                    }
                    AppMethodBeat.o(48871);
                    return 0;
                case 8:
                    atj.vNm = aVar3.BTU.vd();
                    AppMethodBeat.o(48871);
                    return 0;
                case 9:
                    atj.kbK = aVar3.BTU.vd();
                    AppMethodBeat.o(48871);
                    return 0;
                case 10:
                    atj.wxu = aVar3.BTU.vd();
                    AppMethodBeat.o(48871);
                    return 0;
                case 11:
                    atj.wxv = aVar3.BTU.vd();
                    AppMethodBeat.o(48871);
                    return 0;
                case 12:
                    atj.wxw = aVar3.BTU.readString();
                    AppMethodBeat.o(48871);
                    return 0;
                case 13:
                    atj.kdf = aVar3.BTU.readString();
                    AppMethodBeat.o(48871);
                    return 0;
                default:
                    AppMethodBeat.o(48871);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48871);
            return -1;
        }
    }
}
