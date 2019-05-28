package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;
import java.util.LinkedList;

public final class bsz extends a {
    public int FileSize;
    public String Url;
    public int wVf;
    public int wVg;
    public LinkedList<bzu> wVh = new LinkedList();
    public String wVi;
    public String wdO;
    public b wdt;

    public bsz() {
        AppMethodBeat.i(80164);
        AppMethodBeat.o(80164);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80165);
        e.a.a.b bVar;
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wdO == null) {
                bVar = new e.a.a.b("Not all required fields were included: MD5");
                AppMethodBeat.o(80165);
                throw bVar;
            } else if (this.Url == null) {
                bVar = new e.a.a.b("Not all required fields were included: Url");
                AppMethodBeat.o(80165);
                throw bVar;
            } else if (this.wVi == null) {
                bVar = new e.a.a.b("Not all required fields were included: OriginalMD5");
                AppMethodBeat.o(80165);
                throw bVar;
            } else {
                if (this.wdO != null) {
                    aVar.e(1, this.wdO);
                }
                aVar.iz(2, this.wVf);
                if (this.Url != null) {
                    aVar.e(3, this.Url);
                }
                aVar.iz(4, this.wVg);
                aVar.e(5, 8, this.wVh);
                if (this.wdt != null) {
                    aVar.c(6, this.wdt);
                }
                if (this.wVi != null) {
                    aVar.e(7, this.wVi);
                }
                aVar.iz(8, this.FileSize);
                AppMethodBeat.o(80165);
                return 0;
            }
        } else if (i == 1) {
            if (this.wdO != null) {
                f = e.a.a.b.b.a.f(1, this.wdO) + 0;
            } else {
                f = 0;
            }
            f += e.a.a.b.b.a.bs(2, this.wVf);
            if (this.Url != null) {
                f += e.a.a.b.b.a.f(3, this.Url);
            }
            f = (f + e.a.a.b.b.a.bs(4, this.wVg)) + e.a.a.a.c(5, 8, this.wVh);
            if (this.wdt != null) {
                f += e.a.a.b.b.a.b(6, this.wdt);
            }
            if (this.wVi != null) {
                f += e.a.a.b.b.a.f(7, this.wVi);
            }
            int bs = f + e.a.a.b.b.a.bs(8, this.FileSize);
            AppMethodBeat.o(80165);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wVh.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.wdO == null) {
                bVar = new e.a.a.b("Not all required fields were included: MD5");
                AppMethodBeat.o(80165);
                throw bVar;
            } else if (this.Url == null) {
                bVar = new e.a.a.b("Not all required fields were included: Url");
                AppMethodBeat.o(80165);
                throw bVar;
            } else if (this.wVi == null) {
                bVar = new e.a.a.b("Not all required fields were included: OriginalMD5");
                AppMethodBeat.o(80165);
                throw bVar;
            } else {
                AppMethodBeat.o(80165);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bsz bsz = (bsz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bsz.wdO = aVar3.BTU.readString();
                    AppMethodBeat.o(80165);
                    return 0;
                case 2:
                    bsz.wVf = aVar3.BTU.vd();
                    AppMethodBeat.o(80165);
                    return 0;
                case 3:
                    bsz.Url = aVar3.BTU.readString();
                    AppMethodBeat.o(80165);
                    return 0;
                case 4:
                    bsz.wVg = aVar3.BTU.vd();
                    AppMethodBeat.o(80165);
                    return 0;
                case 5:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bzu bzu = new bzu();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bzu.populateBuilderWithField(aVar4, bzu, a.getNextFieldNumber(aVar4))) {
                        }
                        bsz.wVh.add(bzu);
                    }
                    AppMethodBeat.o(80165);
                    return 0;
                case 6:
                    bsz.wdt = aVar3.BTU.emu();
                    AppMethodBeat.o(80165);
                    return 0;
                case 7:
                    bsz.wVi = aVar3.BTU.readString();
                    AppMethodBeat.o(80165);
                    return 0;
                case 8:
                    bsz.FileSize = aVar3.BTU.vd();
                    AppMethodBeat.o(80165);
                    return 0;
                default:
                    AppMethodBeat.o(80165);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80165);
            return -1;
        }
    }
}
