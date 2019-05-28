package com.tencent.p177mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.plugin.game.p1268a.C43156b;
import com.tencent.p177mm.plugin.game.p1485e.C34276a;
import com.tencent.p177mm.plugin.game.p428f.C20964d;
import com.tencent.p177mm.plugin.game.p731d.C28189cd;
import com.tencent.p177mm.plugin.game.p731d.C39185aq;
import com.tencent.p177mm.plugin.game.p731d.C39187at;
import com.tencent.p177mm.plugin.game.p731d.C39189bk;
import com.tencent.p177mm.plugin.game.p731d.C45989ar;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.p500s.C34832a;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.storage.C7616ad;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.game.model.af */
public final class C41286af extends C39216x {
    public C39189bk mYh;
    private boolean mYi;
    public LinkedList<C20992c> mYj;
    public HashMap<String, Integer> mYk;

    public C41286af(C1331a c1331a) {
        AppMethodBeat.m2504i(111384);
        this.mYk = new HashMap();
        if (c1331a == null) {
            this.mYh = new C39189bk();
            AppMethodBeat.m2505o(111384);
            return;
        }
        this.mYh = (C39189bk) c1331a;
        this.mYi = true;
        m71916Kh();
        AppMethodBeat.m2505o(111384);
    }

    public C41286af(byte[] bArr) {
        AppMethodBeat.m2504i(111385);
        this.mYk = new HashMap();
        this.mYh = new C39189bk();
        if (bArr == null || bArr.length == 0) {
            AppMethodBeat.m2505o(111385);
            return;
        }
        try {
            this.mYh.parseFrom(bArr);
        } catch (IOException e) {
            C4990ab.m7413e("MicroMsg.GamePBDataOverSea", "Parsing Failed: %s", e.getMessage());
        }
        this.mYi = false;
        m71916Kh();
        AppMethodBeat.m2505o(111385);
    }

    /* renamed from: Kh */
    private void m71916Kh() {
        AppMethodBeat.m2504i(111386);
        this.mYj = bEQ();
        if (this.mYi) {
            C20964d.m32220ac(this.mYj);
            bER();
            ((C43156b) C1720g.m3528K(C43156b.class)).bCV().init(C4996ah.getContext());
        }
        AppMethodBeat.m2505o(111386);
    }

    private LinkedList<C20992c> bEQ() {
        AppMethodBeat.m2504i(111387);
        LinkedList<C20992c> linkedList = new LinkedList();
        if (this.mYh.nck == null || this.mYh.nck.mZK == null) {
            AppMethodBeat.m2505o(111387);
            return linkedList;
        }
        Iterator it = this.mYh.nck.mZK.iterator();
        int i = 1;
        while (it.hasNext()) {
            C39185aq c39185aq = (C39185aq) it.next();
            if (c39185aq.mZk != null) {
                C20992c a = C39216x.m66823a(c39185aq.mZk);
                if (a != null) {
                    if (c39185aq.mZk.mZE == null) {
                        a.mVB = C34276a.m56208kY(c39185aq.mZL);
                    } else if (c39185aq.mZk.mZE.Name == null || c39185aq.mZk.mZE.ncT == null) {
                        a.mVB = C34276a.m56208kY(c39185aq.mZL);
                    } else {
                        a.mVx = c39185aq.mZk.mZE.Name;
                        a.mVy = c39185aq.mZk.mZE.ncT;
                        a.mVB = C34276a.m56203T(c39185aq.mZL, "label", a.mVx);
                    }
                    if (c39185aq.nbg != null) {
                        Iterator it2 = c39185aq.nbg.iterator();
                        while (it2.hasNext()) {
                            C45989ar c45989ar = (C45989ar) it2.next();
                            if (c45989ar != null) {
                                if (c45989ar.nbh == null || c45989ar.nbh.size() == 0) {
                                    a.mVs.add("");
                                } else {
                                    StringBuilder stringBuilder = new StringBuilder();
                                    int i2 = 0;
                                    while (true) {
                                        int i3 = i2;
                                        if (i3 >= c45989ar.nbh.size()) {
                                            break;
                                        }
                                        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO((String) c45989ar.nbh.get(i3));
                                        if (aoO == null || aoO.ewQ == 0) {
                                            stringBuilder.append((String) c45989ar.nbh.get(i3));
                                        } else {
                                            stringBuilder.append(aoO.mo16707Oj());
                                        }
                                        if (i3 < c45989ar.nbh.size() - 1) {
                                            stringBuilder.append("、");
                                        }
                                        i2 = i3 + 1;
                                    }
                                    stringBuilder.append(" ");
                                    a.mVs.add(stringBuilder.toString());
                                }
                                a.mVs.add(c45989ar.naq);
                            }
                        }
                    }
                    a.scene = 10;
                    a.cKG = 1004;
                    int i4 = i + 1;
                    a.position = i;
                    linkedList.add(a);
                    i = i4;
                }
            }
        }
        AppMethodBeat.m2505o(111387);
        return linkedList;
    }

    private void bER() {
        AppMethodBeat.m2504i(111388);
        this.mYk = new HashMap();
        if (this.mYh.ncl == null || this.mYh.ncl.ncP == null) {
            AppMethodBeat.m2505o(111388);
            return;
        }
        Iterator it = this.mYh.ncl.ncP.iterator();
        while (it.hasNext()) {
            C28189cd c28189cd = (C28189cd) it.next();
            C20992c a = C39216x.m66823a(c28189cd.mZk);
            if (a != null) {
                this.mYk.put(a.field_appId, Integer.valueOf(a.versionCode));
                C40439f aiJ = C34832a.bYJ().aiJ(a.field_appId);
                if (aiJ != null) {
                    aiJ.mo44078ij(c28189cd.ncR);
                    if (!C34832a.bYJ().mo56566a(aiJ, new String[0])) {
                        C4990ab.m7413e("MicroMsg.GamePBDataOverSea", "Store rank info failed, AppID: %s", aiJ.field_appId);
                    }
                }
            }
        }
        AppMethodBeat.m2505o(111388);
    }

    public final C39187at bES() {
        return this.mYh != null ? this.mYh.nci : null;
    }
}
