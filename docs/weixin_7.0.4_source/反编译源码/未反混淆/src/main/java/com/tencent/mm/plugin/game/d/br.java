package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class br extends a {
    public String desc;
    public LinkedList<bz> kfL = new LinkedList();
    public String summary;
    public String title;
    public String url;

    public br() {
        AppMethodBeat.i(111622);
        AppMethodBeat.o(111622);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111623);
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.summary != null) {
                aVar.e(1, this.summary);
            }
            if (this.desc != null) {
                aVar.e(2, this.desc);
            }
            aVar.e(3, 8, this.kfL);
            if (this.url != null) {
                aVar.e(4, this.url);
            }
            if (this.title != null) {
                aVar.e(5, this.title);
            }
            AppMethodBeat.o(111623);
            return 0;
        } else if (i == 1) {
            if (this.summary != null) {
                f = e.a.a.b.b.a.f(1, this.summary) + 0;
            } else {
                f = 0;
            }
            if (this.desc != null) {
                f += e.a.a.b.b.a.f(2, this.desc);
            }
            f += e.a.a.a.c(3, 8, this.kfL);
            if (this.url != null) {
                f += e.a.a.b.b.a.f(4, this.url);
            }
            if (this.title != null) {
                f += e.a.a.b.b.a.f(5, this.title);
            }
            AppMethodBeat.o(111623);
            return f;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.kfL.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(111623);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            br brVar = (br) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    brVar.summary = aVar3.BTU.readString();
                    AppMethodBeat.o(111623);
                    return 0;
                case 2:
                    brVar.desc = aVar3.BTU.readString();
                    AppMethodBeat.o(111623);
                    return 0;
                case 3:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bz bzVar = new bz();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bzVar.populateBuilderWithField(aVar4, bzVar, a.getNextFieldNumber(aVar4))) {
                        }
                        brVar.kfL.add(bzVar);
                    }
                    AppMethodBeat.o(111623);
                    return 0;
                case 4:
                    brVar.url = aVar3.BTU.readString();
                    AppMethodBeat.o(111623);
                    return 0;
                case 5:
                    brVar.title = aVar3.BTU.readString();
                    AppMethodBeat.o(111623);
                    return 0;
                default:
                    AppMethodBeat.o(111623);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111623);
            return -1;
        }
    }
}
