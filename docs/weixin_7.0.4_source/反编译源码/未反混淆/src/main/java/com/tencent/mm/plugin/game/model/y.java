package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.plugin.game.d.bo;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.f.d;
import java.util.Iterator;
import java.util.LinkedList;

public final class y extends x {
    private int mType = 0;
    public bo mXH;
    public LinkedList<c> mXI;
    private int mXJ = 0;

    public y(a aVar, int i, int i2) {
        AppMethodBeat.i(111359);
        if (aVar == null) {
            this.mXH = new bo();
            AppMethodBeat.o(111359);
            return;
        }
        this.mXH = (bo) aVar;
        this.mType = i;
        this.mXJ = i2;
        LinkedList linkedList = new LinkedList();
        if (this.mXH.ncx != null) {
            int i3 = this.mXJ + 1;
            Iterator it = this.mXH.ncx.iterator();
            int i4 = i3;
            while (it.hasNext()) {
                c a = x.a((e) it.next());
                if (a != null) {
                    switch (this.mType) {
                        case 1:
                            a.scene = 16;
                            a.cKG = 1601;
                            i3 = i4 + 1;
                            a.position = i4;
                            break;
                        case 2:
                            a.scene = 15;
                            a.cKG = 1501;
                            i3 = i4 + 1;
                            a.position = i4;
                            break;
                        default:
                            i3 = i4;
                            break;
                    }
                    linkedList.add(a);
                    i4 = i3;
                }
            }
        }
        this.mXI = linkedList;
        d.ac(this.mXI);
        AppMethodBeat.o(111359);
    }
}
