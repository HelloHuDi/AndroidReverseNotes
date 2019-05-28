package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class dh extends a {
    public String IconUrl;
    public String Title;
    public String mZL;
    public String mZj;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111674);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.IconUrl != null) {
                aVar.e(1, this.IconUrl);
            }
            if (this.Title != null) {
                aVar.e(2, this.Title);
            }
            if (this.mZj != null) {
                aVar.e(3, this.mZj);
            }
            if (this.mZL != null) {
                aVar.e(4, this.mZL);
            }
            AppMethodBeat.o(111674);
            return 0;
        } else if (i == 1) {
            if (this.IconUrl != null) {
                f = e.a.a.b.b.a.f(1, this.IconUrl) + 0;
            } else {
                f = 0;
            }
            if (this.Title != null) {
                f += e.a.a.b.b.a.f(2, this.Title);
            }
            if (this.mZj != null) {
                f += e.a.a.b.b.a.f(3, this.mZj);
            }
            if (this.mZL != null) {
                f += e.a.a.b.b.a.f(4, this.mZL);
            }
            AppMethodBeat.o(111674);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(111674);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            dh dhVar = (dh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dhVar.IconUrl = aVar3.BTU.readString();
                    AppMethodBeat.o(111674);
                    return 0;
                case 2:
                    dhVar.Title = aVar3.BTU.readString();
                    AppMethodBeat.o(111674);
                    return 0;
                case 3:
                    dhVar.mZj = aVar3.BTU.readString();
                    AppMethodBeat.o(111674);
                    return 0;
                case 4:
                    dhVar.mZL = aVar3.BTU.readString();
                    AppMethodBeat.o(111674);
                    return 0;
                default:
                    AppMethodBeat.o(111674);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111674);
            return -1;
        }
    }
}
