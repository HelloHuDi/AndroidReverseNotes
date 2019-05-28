package com.tencent.p177mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.plugin.game.p428f.C20964d;
import com.tencent.p177mm.plugin.game.p731d.C45998e;
import com.tencent.p177mm.plugin.game.p731d.C7505bo;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.game.model.y */
public final class C46013y extends C39216x {
    private int mType = 0;
    public C7505bo mXH;
    public LinkedList<C20992c> mXI;
    private int mXJ = 0;

    public C46013y(C1331a c1331a, int i, int i2) {
        AppMethodBeat.m2504i(111359);
        if (c1331a == null) {
            this.mXH = new C7505bo();
            AppMethodBeat.m2505o(111359);
            return;
        }
        this.mXH = (C7505bo) c1331a;
        this.mType = i;
        this.mXJ = i2;
        LinkedList linkedList = new LinkedList();
        if (this.mXH.ncx != null) {
            int i3 = this.mXJ + 1;
            Iterator it = this.mXH.ncx.iterator();
            int i4 = i3;
            while (it.hasNext()) {
                C20992c a = C39216x.m66823a((C45998e) it.next());
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
        C20964d.m32220ac(this.mXI);
        AppMethodBeat.m2505o(111359);
    }
}
