package com.tencent.p177mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.plugin.game.p1268a.C45983c;
import com.tencent.p177mm.plugin.game.p428f.C20964d;
import com.tencent.p177mm.plugin.game.p433ui.GameLibraryCategoriesView.C21021a;
import com.tencent.p177mm.plugin.game.p731d.C39190bm;
import com.tencent.p177mm.plugin.game.p731d.C45992c;
import com.tencent.p177mm.plugin.game.p731d.C45994cr;
import com.tencent.p177mm.plugin.game.p731d.C45995dc;
import com.tencent.p177mm.plugin.game.p731d.C45999l;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.soter.core.biometric.FaceManager;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.game.model.ae */
public final class C46007ae extends C39216x {
    private int mXJ;
    public C39190bm mYe;
    public LinkedList<C20992c> mYf;
    public LinkedList<C20992c> mYg;

    public C46007ae(C1331a c1331a, boolean z, int i) {
        AppMethodBeat.m2504i(111378);
        this.mXJ = 0;
        if (c1331a == null) {
            this.mYe = new C39190bm();
            AppMethodBeat.m2505o(111378);
            return;
        }
        this.mYe = (C39190bm) c1331a;
        this.mXJ = i;
        this.mYf = bEM();
        this.mYg = bEN();
        if (z) {
            ((C45983c) C1720g.m3528K(C45983c.class)).bCZ().mo54826b("pb_library", c1331a);
        }
        C20964d.m32220ac(this.mYf);
        C20964d.m32220ac(this.mYg);
        AppMethodBeat.m2505o(111378);
    }

    public C46007ae(byte[] bArr) {
        AppMethodBeat.m2504i(111379);
        this.mXJ = 0;
        this.mYe = new C39190bm();
        if (bArr == null || bArr.length == 0) {
            AppMethodBeat.m2505o(111379);
            return;
        }
        try {
            this.mYe.parseFrom(bArr);
        } catch (IOException e) {
            C4990ab.m7413e("MicroMsg.GamePBDataLibrary", "Parsing Failed: %s", e.getMessage());
        }
        this.mYf = bEM();
        this.mYg = bEN();
        C20964d.m32220ac(this.mYf);
        C20964d.m32220ac(this.mYg);
        AppMethodBeat.m2505o(111379);
    }

    private LinkedList<C20992c> bEM() {
        AppMethodBeat.m2504i(111380);
        LinkedList<C20992c> linkedList = new LinkedList();
        if (this.mYe.ncr == null || this.mYe.ncr.ncV == null || this.mYe.ncr.ncV.ndk == null) {
            AppMethodBeat.m2505o(111380);
            return linkedList;
        }
        Iterator it = this.mYe.ncr.ncV.ndk.iterator();
        int i = 1;
        while (it.hasNext()) {
            C45994cr c45994cr = (C45994cr) it.next();
            C20992c a = C39216x.m66823a(c45994cr.mZk);
            if (a != null) {
                a.mVu = c45994cr.mZk.mZz;
                a.scene = 11;
                a.cKG = FaceManager.FACE_ACQUIRED_DARK;
                int i2 = i + 1;
                a.position = i;
                linkedList.add(a);
                i = i2;
            }
        }
        AppMethodBeat.m2505o(111380);
        return linkedList;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    private LinkedList<C20992c> bEN() {
        AppMethodBeat.m2504i(111381);
        LinkedList<C20992c> linkedList = new LinkedList();
        if (this.mYe.ncs == null) {
            AppMethodBeat.m2505o(111381);
            return linkedList;
        }
        int i = this.mXJ + 1;
        int i2 = (this.mXJ / 15) + 901;
        Iterator it = this.mYe.ncs.iterator();
        while (true) {
            int i3 = i2;
            if (it.hasNext()) {
                C45992c c45992c = (C45992c) it.next();
                C20992c c20992c = null;
                switch (c45992c.jCt) {
                    case 1:
                        c20992c = C39216x.m66823a(c45992c.mZk);
                        if (c20992c != null) {
                            int i4 = i + 1;
                            c20992c.position = i;
                            i2 = i3;
                            i = i4;
                            break;
                        }
                    case 2:
                        if (c45992c.mZn != null) {
                            c20992c = C39216x.m66823a(c45992c.mZn.mZk);
                            if (c20992c != null) {
                                c20992c.type = 1;
                                c20992c.mVm = c45992c.mZn.mZm;
                                c20992c.mVn = c45992c.mZn.mZl;
                                i2 = i3 + 1;
                                c20992c.position = i3;
                                break;
                            }
                        }
                    default:
                        i2 = i3;
                        break;
                }
                if (c20992c != null) {
                    c20992c.scene = 11;
                    c20992c.cKG = FaceManager.FACE_ACQUIRED_HACKER;
                    linkedList.add(c20992c);
                }
            } else {
                AppMethodBeat.m2505o(111381);
                return linkedList;
            }
        }
    }

    public final HashMap<Integer, String> bEO() {
        AppMethodBeat.m2504i(111382);
        HashMap<Integer, String> linkedHashMap = new LinkedHashMap();
        if (this.mYe.ncr == null || this.mYe.ncr.ncY == null) {
            AppMethodBeat.m2505o(111382);
            return linkedHashMap;
        }
        Iterator it = this.mYe.ncr.ncY.iterator();
        while (it.hasNext()) {
            C45995dc c45995dc = (C45995dc) it.next();
            int i = c45995dc.ncp;
            linkedHashMap.put(Integer.valueOf(i), c45995dc.Name);
        }
        AppMethodBeat.m2505o(111382);
        return linkedHashMap;
    }

    public final LinkedList<C21021a> bEP() {
        AppMethodBeat.m2504i(111383);
        if (this.mYe.ncr == null || this.mYe.ncr.ncW == null) {
            AppMethodBeat.m2505o(111383);
            return null;
        }
        int i = 0;
        LinkedList<C21021a> linkedList = new LinkedList();
        Iterator it = this.mYe.ncr.ncW.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                C45999l c45999l = (C45999l) it.next();
                C21021a c21021a = new C21021a();
                c21021a.njM = c45999l.mZU;
                c21021a.njN = c45999l.Name;
                c21021a.njO = c45999l.mZm;
                c21021a.haO = c45999l.mZs;
                i = i2 + 1;
                c21021a.position = i;
                linkedList.add(c21021a);
            } else {
                AppMethodBeat.m2505o(111383);
                return linkedList;
            }
        }
    }
}
