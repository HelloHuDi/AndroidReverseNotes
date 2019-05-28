package com.tencent.p177mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.plugin.game.p1268a.C45983c;
import com.tencent.p177mm.plugin.game.p428f.C20964d;
import com.tencent.p177mm.plugin.game.p433ui.GameMediaList.C28253a;
import com.tencent.p177mm.plugin.game.p731d.C20952cl;
import com.tencent.p177mm.plugin.game.p731d.C28188bz;
import com.tencent.p177mm.plugin.game.p731d.C34266ba;
import com.tencent.p177mm.plugin.game.p731d.C34268bt;
import com.tencent.p177mm.plugin.game.p731d.C34270bw;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.game.model.z */
public final class C41287z extends C39216x {
    public C34266ba mXK;
    private boolean mXL;
    public C20992c mXM;
    public C28219aa mXN;

    /* renamed from: com.tencent.mm.plugin.game.model.z$a */
    public static class C39217a {
        public String desc;
        public String title;
        public String url;
    }

    /* renamed from: com.tencent.mm.plugin.game.model.z$b */
    public static class C41288b {
        public String cIY;
        public String desc;
        public String title;
        public String url;
    }

    public C41287z(C1331a c1331a) {
        AppMethodBeat.m2504i(111360);
        if (c1331a == null) {
            this.mXK = new C34266ba();
            AppMethodBeat.m2505o(111360);
            return;
        }
        this.mXK = (C34266ba) c1331a;
        this.mXL = false;
        m71917Kh();
        AppMethodBeat.m2505o(111360);
    }

    public C41287z(byte[] bArr) {
        AppMethodBeat.m2504i(111361);
        this.mXK = new C34266ba();
        if (bArr == null || bArr.length == 0) {
            AppMethodBeat.m2505o(111361);
            return;
        }
        try {
            this.mXK.parseFrom(bArr);
        } catch (IOException e) {
            C4990ab.m7413e("MicroMsg.GamePBDataDetail", "Parsing Failed: %s", e.getMessage());
        }
        this.mXL = true;
        m71917Kh();
        AppMethodBeat.m2505o(111361);
    }

    /* renamed from: Kh */
    private void m71917Kh() {
        AppMethodBeat.m2504i(111362);
        this.mXM = bEy();
        if (this.mXL) {
            this.mXN = new C28219aa(this.mXM.field_appId);
        } else {
            this.mXN = new C28219aa(this.mXM.field_appId, this.mXK.nbO != null ? this.mXK.nbO.ndo : null);
        }
        if (!this.mXL) {
            C20964d.m32218a(this.mXM);
            ((C45983c) C1720g.m3528K(C45983c.class)).bCZ().mo54826b(this.mXM.field_appId, this.mXK);
        }
        AppMethodBeat.m2505o(111362);
    }

    private C20992c bEy() {
        AppMethodBeat.m2504i(111363);
        C20992c a = C39216x.m66823a(this.mXK.mZk);
        if (a != null) {
            a.scene = 12;
            a.cKG = 1201;
        }
        AppMethodBeat.m2505o(111363);
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

    public final LinkedList<C41288b> bEA() {
        AppMethodBeat.m2504i(111364);
        LinkedList<C41288b> linkedList;
        Iterator it;
        C41288b c41288b;
        if (this.mXK.nbS != null && this.mXK.nbS.kfL != null) {
            linkedList = new LinkedList();
            it = this.mXK.nbS.kfL.iterator();
            while (it.hasNext()) {
                C28188bz c28188bz = (C28188bz) it.next();
                c41288b = new C41288b();
                c41288b.cIY = c28188bz.cIY;
                c41288b.desc = c28188bz.desc;
                linkedList.add(c41288b);
            }
            AppMethodBeat.m2505o(111364);
            return linkedList;
        } else if (this.mXK.nbN == null || this.mXK.nbN.ncz == null) {
            AppMethodBeat.m2505o(111364);
            return null;
        } else {
            linkedList = new LinkedList();
            it = this.mXK.nbN.ncz.iterator();
            while (it.hasNext()) {
                C34268bt c34268bt = (C34268bt) it.next();
                c41288b = new C41288b();
                c41288b.cIY = c34268bt.ncC;
                c41288b.title = c34268bt.Title;
                c41288b.desc = c34268bt.naq;
                c41288b.url = c34268bt.mZm;
                linkedList.add(c41288b);
            }
            AppMethodBeat.m2505o(111364);
            return linkedList;
        }
    }

    public final int bEB() {
        if (this.mXK.nbS != null) {
            return 2;
        }
        return 1;
    }

    public final LinkedList<C28253a> bEC() {
        AppMethodBeat.m2504i(111365);
        LinkedList<C28253a> linkedList = new LinkedList();
        if (this.mXK.nbL == null || this.mXK.nbL.ncS == null) {
            AppMethodBeat.m2505o(111365);
            return linkedList;
        }
        Iterator it = this.mXK.nbL.ncS.iterator();
        while (it.hasNext()) {
            C20952cl c20952cl = (C20952cl) it.next();
            C28253a c28253a = new C28253a();
            c28253a.type = c20952cl.nda;
            c28253a.nkG = c20952cl.ndb;
            c28253a.url = c20952cl.ndc;
            linkedList.add(c28253a);
        }
        AppMethodBeat.m2505o(111365);
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

    public final LinkedList<C34270bw> bEG() {
        if (this.mXK.nbM == null) {
            return null;
        }
        return this.mXK.nbM.ncE;
    }
}
