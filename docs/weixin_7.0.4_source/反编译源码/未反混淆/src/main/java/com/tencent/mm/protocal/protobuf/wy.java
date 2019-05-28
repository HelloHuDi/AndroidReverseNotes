package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class wy extends a {
    public String desc;
    public String detail;
    public String title;
    public String url;
    public LinkedList<String> wcS = new LinkedList();
    public String wcT;

    public wy() {
        AppMethodBeat.i(89061);
        AppMethodBeat.o(89061);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(89062);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.url != null) {
                aVar.e(2, this.url);
            }
            if (this.desc != null) {
                aVar.e(3, this.desc);
            }
            aVar.e(4, 1, this.wcS);
            if (this.detail != null) {
                aVar.e(5, this.detail);
            }
            if (this.wcT != null) {
                aVar.e(6, this.wcT);
            }
            AppMethodBeat.o(89062);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                f = e.a.a.b.b.a.f(1, this.title) + 0;
            } else {
                f = 0;
            }
            if (this.url != null) {
                f += e.a.a.b.b.a.f(2, this.url);
            }
            if (this.desc != null) {
                f += e.a.a.b.b.a.f(3, this.desc);
            }
            f += e.a.a.a.c(4, 1, this.wcS);
            if (this.detail != null) {
                f += e.a.a.b.b.a.f(5, this.detail);
            }
            if (this.wcT != null) {
                f += e.a.a.b.b.a.f(6, this.wcT);
            }
            AppMethodBeat.o(89062);
            return f;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.wcS.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(89062);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            wy wyVar = (wy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    wyVar.title = aVar3.BTU.readString();
                    AppMethodBeat.o(89062);
                    return 0;
                case 2:
                    wyVar.url = aVar3.BTU.readString();
                    AppMethodBeat.o(89062);
                    return 0;
                case 3:
                    wyVar.desc = aVar3.BTU.readString();
                    AppMethodBeat.o(89062);
                    return 0;
                case 4:
                    wyVar.wcS.add(aVar3.BTU.readString());
                    AppMethodBeat.o(89062);
                    return 0;
                case 5:
                    wyVar.detail = aVar3.BTU.readString();
                    AppMethodBeat.o(89062);
                    return 0;
                case 6:
                    wyVar.wcT = aVar3.BTU.readString();
                    AppMethodBeat.o(89062);
                    return 0;
                default:
                    AppMethodBeat.o(89062);
                    return -1;
            }
        } else {
            AppMethodBeat.o(89062);
            return -1;
        }
    }
}
