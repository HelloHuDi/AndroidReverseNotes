package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class abw extends a {
    public String vWF;
    public long wji;
    public long wjj;
    public long wjk;
    public String wjl;
    public long wjm;
    public String wjn;
    public String wjo;
    public String wjp;
    public String wjq;
    public String wjr;
    public String wjs;
    public int wjt;
    public String wju;
    public int wjv;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56792);
        int o;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.ai(1, this.wji);
            aVar.ai(2, this.wjj);
            aVar.ai(3, this.wjk);
            if (this.wjl != null) {
                aVar.e(4, this.wjl);
            }
            aVar.ai(5, this.wjm);
            if (this.wjn != null) {
                aVar.e(6, this.wjn);
            }
            if (this.wjo != null) {
                aVar.e(7, this.wjo);
            }
            if (this.wjp != null) {
                aVar.e(8, this.wjp);
            }
            if (this.wjq != null) {
                aVar.e(9, this.wjq);
            }
            if (this.wjr != null) {
                aVar.e(10, this.wjr);
            }
            if (this.wjs != null) {
                aVar.e(11, this.wjs);
            }
            aVar.iz(12, this.wjt);
            if (this.wju != null) {
                aVar.e(13, this.wju);
            }
            aVar.iz(14, this.wjv);
            if (this.vWF != null) {
                aVar.e(15, this.vWF);
            }
            AppMethodBeat.o(56792);
            return 0;
        } else if (i == 1) {
            o = ((e.a.a.b.b.a.o(1, this.wji) + 0) + e.a.a.b.b.a.o(2, this.wjj)) + e.a.a.b.b.a.o(3, this.wjk);
            if (this.wjl != null) {
                o += e.a.a.b.b.a.f(4, this.wjl);
            }
            o += e.a.a.b.b.a.o(5, this.wjm);
            if (this.wjn != null) {
                o += e.a.a.b.b.a.f(6, this.wjn);
            }
            if (this.wjo != null) {
                o += e.a.a.b.b.a.f(7, this.wjo);
            }
            if (this.wjp != null) {
                o += e.a.a.b.b.a.f(8, this.wjp);
            }
            if (this.wjq != null) {
                o += e.a.a.b.b.a.f(9, this.wjq);
            }
            if (this.wjr != null) {
                o += e.a.a.b.b.a.f(10, this.wjr);
            }
            if (this.wjs != null) {
                o += e.a.a.b.b.a.f(11, this.wjs);
            }
            o += e.a.a.b.b.a.bs(12, this.wjt);
            if (this.wju != null) {
                o += e.a.a.b.b.a.f(13, this.wju);
            }
            o += e.a.a.b.b.a.bs(14, this.wjv);
            if (this.vWF != null) {
                o += e.a.a.b.b.a.f(15, this.vWF);
            }
            AppMethodBeat.o(56792);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (o = a.getNextFieldNumber(aVar2); o > 0; o = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, o)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56792);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            abw abw = (abw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    abw.wji = aVar3.BTU.ve();
                    AppMethodBeat.o(56792);
                    return 0;
                case 2:
                    abw.wjj = aVar3.BTU.ve();
                    AppMethodBeat.o(56792);
                    return 0;
                case 3:
                    abw.wjk = aVar3.BTU.ve();
                    AppMethodBeat.o(56792);
                    return 0;
                case 4:
                    abw.wjl = aVar3.BTU.readString();
                    AppMethodBeat.o(56792);
                    return 0;
                case 5:
                    abw.wjm = aVar3.BTU.ve();
                    AppMethodBeat.o(56792);
                    return 0;
                case 6:
                    abw.wjn = aVar3.BTU.readString();
                    AppMethodBeat.o(56792);
                    return 0;
                case 7:
                    abw.wjo = aVar3.BTU.readString();
                    AppMethodBeat.o(56792);
                    return 0;
                case 8:
                    abw.wjp = aVar3.BTU.readString();
                    AppMethodBeat.o(56792);
                    return 0;
                case 9:
                    abw.wjq = aVar3.BTU.readString();
                    AppMethodBeat.o(56792);
                    return 0;
                case 10:
                    abw.wjr = aVar3.BTU.readString();
                    AppMethodBeat.o(56792);
                    return 0;
                case 11:
                    abw.wjs = aVar3.BTU.readString();
                    AppMethodBeat.o(56792);
                    return 0;
                case 12:
                    abw.wjt = aVar3.BTU.vd();
                    AppMethodBeat.o(56792);
                    return 0;
                case 13:
                    abw.wju = aVar3.BTU.readString();
                    AppMethodBeat.o(56792);
                    return 0;
                case 14:
                    abw.wjv = aVar3.BTU.vd();
                    AppMethodBeat.o(56792);
                    return 0;
                case 15:
                    abw.vWF = aVar3.BTU.readString();
                    AppMethodBeat.o(56792);
                    return 0;
                default:
                    AppMethodBeat.o(56792);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56792);
            return -1;
        }
    }
}
