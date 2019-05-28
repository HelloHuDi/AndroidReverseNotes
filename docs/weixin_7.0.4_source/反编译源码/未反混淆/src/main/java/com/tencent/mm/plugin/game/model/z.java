package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.plugin.game.d.ba;
import com.tencent.mm.plugin.game.d.bt;
import com.tencent.mm.plugin.game.d.bw;
import com.tencent.mm.plugin.game.d.bz;
import com.tencent.mm.plugin.game.d.cl;
import com.tencent.mm.plugin.game.f.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class z extends x {
    public ba mXK;
    private boolean mXL;
    public c mXM;
    public aa mXN;

    public static class a {
        public String desc;
        public String title;
        public String url;
    }

    public static class b {
        public String cIY;
        public String desc;
        public String title;
        public String url;
    }

    public z(com.tencent.mm.bt.a aVar) {
        AppMethodBeat.i(111360);
        if (aVar == null) {
            this.mXK = new ba();
            AppMethodBeat.o(111360);
            return;
        }
        this.mXK = (ba) aVar;
        this.mXL = false;
        Kh();
        AppMethodBeat.o(111360);
    }

    public z(byte[] bArr) {
        AppMethodBeat.i(111361);
        this.mXK = new ba();
        if (bArr == null || bArr.length == 0) {
            AppMethodBeat.o(111361);
            return;
        }
        try {
            this.mXK.parseFrom(bArr);
        } catch (IOException e) {
            ab.e("MicroMsg.GamePBDataDetail", "Parsing Failed: %s", e.getMessage());
        }
        this.mXL = true;
        Kh();
        AppMethodBeat.o(111361);
    }

    private void Kh() {
        AppMethodBeat.i(111362);
        this.mXM = bEy();
        if (this.mXL) {
            this.mXN = new aa(this.mXM.field_appId);
        } else {
            this.mXN = new aa(this.mXM.field_appId, this.mXK.nbO != null ? this.mXK.nbO.ndo : null);
        }
        if (!this.mXL) {
            d.a(this.mXM);
            ((c) g.K(c.class)).bCZ().b(this.mXM.field_appId, this.mXK);
        }
        AppMethodBeat.o(111362);
    }

    private c bEy() {
        AppMethodBeat.i(111363);
        c a = x.a(this.mXK.mZk);
        if (a != null) {
            a.scene = 12;
            a.cKG = 1201;
        }
        AppMethodBeat.o(111363);
        return a;
    }

    public final String bEz() {
        if (this.mXK.nbS != null) {
            return this.mXK.nbS.title;
        }
        if (this.mXK.nbN != null) {
            return this.mXK.nbN.Title;
        }
        return null;
    }

    public final LinkedList<b> bEA() {
        AppMethodBeat.i(111364);
        LinkedList<b> linkedList;
        Iterator it;
        b bVar;
        if (this.mXK.nbS != null && this.mXK.nbS.kfL != null) {
            linkedList = new LinkedList();
            it = this.mXK.nbS.kfL.iterator();
            while (it.hasNext()) {
                bz bzVar = (bz) it.next();
                bVar = new b();
                bVar.cIY = bzVar.cIY;
                bVar.desc = bzVar.desc;
                linkedList.add(bVar);
            }
            AppMethodBeat.o(111364);
            return linkedList;
        } else if (this.mXK.nbN == null || this.mXK.nbN.ncz == null) {
            AppMethodBeat.o(111364);
            return null;
        } else {
            linkedList = new LinkedList();
            it = this.mXK.nbN.ncz.iterator();
            while (it.hasNext()) {
                bt btVar = (bt) it.next();
                bVar = new b();
                bVar.cIY = btVar.ncC;
                bVar.title = btVar.Title;
                bVar.desc = btVar.naq;
                bVar.url = btVar.mZm;
                linkedList.add(bVar);
            }
            AppMethodBeat.o(111364);
            return linkedList;
        }
    }

    public final int bEB() {
        if (this.mXK.nbS != null) {
            return 2;
        }
        return 1;
    }

    public final LinkedList<com.tencent.mm.plugin.game.ui.GameMediaList.a> bEC() {
        AppMethodBeat.i(111365);
        LinkedList<com.tencent.mm.plugin.game.ui.GameMediaList.a> linkedList = new LinkedList();
        if (this.mXK.nbL == null || this.mXK.nbL.ncS == null) {
            AppMethodBeat.o(111365);
            return linkedList;
        }
        Iterator it = this.mXK.nbL.ncS.iterator();
        while (it.hasNext()) {
            cl clVar = (cl) it.next();
            com.tencent.mm.plugin.game.ui.GameMediaList.a aVar = new com.tencent.mm.plugin.game.ui.GameMediaList.a();
            aVar.type = clVar.nda;
            aVar.nkG = clVar.ndb;
            aVar.url = clVar.ndc;
            linkedList.add(aVar);
        }
        AppMethodBeat.o(111365);
        return linkedList;
    }

    public final String bED() {
        if (this.mXK.nbL == null || this.mXK.nbL.Title == null) {
            return null;
        }
        return this.mXK.nbL.Title;
    }

    public final String bEE() {
        if (this.mXK.nbL == null || this.mXK.nbL.naq == null) {
            return null;
        }
        return this.mXK.nbL.naq;
    }

    public final String bEF() {
        if (this.mXK.nbM == null) {
            return null;
        }
        return this.mXK.nbM.Title;
    }

    public final LinkedList<bw> bEG() {
        if (this.mXK.nbM == null) {
            return null;
        }
        return this.mXK.nbM.ncE;
    }
}
