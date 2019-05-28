package com.tencent.mm.af;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public class m extends a {
    public String cMg;
    public String cMh;
    public String dJv;
    public LinkedList<p> fjr = new LinkedList();
    public int fjs;
    public String name;
    public int type;

    public m() {
        AppMethodBeat.i(105477);
        AppMethodBeat.o(105477);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(105478);
        int bs;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.type);
            if (this.name != null) {
                aVar.e(2, this.name);
            }
            if (this.cMg != null) {
                aVar.e(3, this.cMg);
            }
            if (this.cMh != null) {
                aVar.e(4, this.cMh);
            }
            if (this.dJv != null) {
                aVar.e(5, this.dJv);
            }
            aVar.e(6, 8, this.fjr);
            aVar.iz(7, this.fjs);
            AppMethodBeat.o(105478);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.type) + 0;
            if (this.name != null) {
                bs += e.a.a.b.b.a.f(2, this.name);
            }
            if (this.cMg != null) {
                bs += e.a.a.b.b.a.f(3, this.cMg);
            }
            if (this.cMh != null) {
                bs += e.a.a.b.b.a.f(4, this.cMh);
            }
            if (this.dJv != null) {
                bs += e.a.a.b.b.a.f(5, this.dJv);
            }
            bs = (bs + e.a.a.a.c(6, 8, this.fjr)) + e.a.a.b.b.a.bs(7, this.fjs);
            AppMethodBeat.o(105478);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.fjr.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(105478);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            m mVar = (m) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    mVar.type = aVar3.BTU.vd();
                    AppMethodBeat.o(105478);
                    return 0;
                case 2:
                    mVar.name = aVar3.BTU.readString();
                    AppMethodBeat.o(105478);
                    return 0;
                case 3:
                    mVar.cMg = aVar3.BTU.readString();
                    AppMethodBeat.o(105478);
                    return 0;
                case 4:
                    mVar.cMh = aVar3.BTU.readString();
                    AppMethodBeat.o(105478);
                    return 0;
                case 5:
                    mVar.dJv = aVar3.BTU.readString();
                    AppMethodBeat.o(105478);
                    return 0;
                case 6:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        p pVar = new p();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = pVar.populateBuilderWithField(aVar4, pVar, a.getNextFieldNumber(aVar4))) {
                        }
                        mVar.fjr.add(pVar);
                    }
                    AppMethodBeat.o(105478);
                    return 0;
                case 7:
                    mVar.fjs = aVar3.BTU.vd();
                    AppMethodBeat.o(105478);
                    return 0;
                default:
                    AppMethodBeat.o(105478);
                    return -1;
            }
        } else {
            AppMethodBeat.o(105478);
            return -1;
        }
    }
}
