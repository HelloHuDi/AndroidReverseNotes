package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.b;
import com.tencent.mm.plugin.game.d.aq;
import com.tencent.mm.plugin.game.d.ar;
import com.tencent.mm.plugin.game.d.at;
import com.tencent.mm.plugin.game.d.bk;
import com.tencent.mm.plugin.game.d.cd;
import com.tencent.mm.plugin.game.f.d;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.ad;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class af extends x {
    public bk mYh;
    private boolean mYi;
    public LinkedList<c> mYj;
    public HashMap<String, Integer> mYk;

    public af(a aVar) {
        AppMethodBeat.i(111384);
        this.mYk = new HashMap();
        if (aVar == null) {
            this.mYh = new bk();
            AppMethodBeat.o(111384);
            return;
        }
        this.mYh = (bk) aVar;
        this.mYi = true;
        Kh();
        AppMethodBeat.o(111384);
    }

    public af(byte[] bArr) {
        AppMethodBeat.i(111385);
        this.mYk = new HashMap();
        this.mYh = new bk();
        if (bArr == null || bArr.length == 0) {
            AppMethodBeat.o(111385);
            return;
        }
        try {
            this.mYh.parseFrom(bArr);
        } catch (IOException e) {
            ab.e("MicroMsg.GamePBDataOverSea", "Parsing Failed: %s", e.getMessage());
        }
        this.mYi = false;
        Kh();
        AppMethodBeat.o(111385);
    }

    private void Kh() {
        AppMethodBeat.i(111386);
        this.mYj = bEQ();
        if (this.mYi) {
            d.ac(this.mYj);
            bER();
            ((b) g.K(b.class)).bCV().init(ah.getContext());
        }
        AppMethodBeat.o(111386);
    }

    private LinkedList<c> bEQ() {
        AppMethodBeat.i(111387);
        LinkedList<c> linkedList = new LinkedList();
        if (this.mYh.nck == null || this.mYh.nck.mZK == null) {
            AppMethodBeat.o(111387);
            return linkedList;
        }
        Iterator it = this.mYh.nck.mZK.iterator();
        int i = 1;
        while (it.hasNext()) {
            aq aqVar = (aq) it.next();
            if (aqVar.mZk != null) {
                c a = x.a(aqVar.mZk);
                if (a != null) {
                    if (aqVar.mZk.mZE == null) {
                        a.mVB = com.tencent.mm.plugin.game.e.a.kY(aqVar.mZL);
                    } else if (aqVar.mZk.mZE.Name == null || aqVar.mZk.mZE.ncT == null) {
                        a.mVB = com.tencent.mm.plugin.game.e.a.kY(aqVar.mZL);
                    } else {
                        a.mVx = aqVar.mZk.mZE.Name;
                        a.mVy = aqVar.mZk.mZE.ncT;
                        a.mVB = com.tencent.mm.plugin.game.e.a.T(aqVar.mZL, "label", a.mVx);
                    }
                    if (aqVar.nbg != null) {
                        Iterator it2 = aqVar.nbg.iterator();
                        while (it2.hasNext()) {
                            ar arVar = (ar) it2.next();
                            if (arVar != null) {
                                if (arVar.nbh == null || arVar.nbh.size() == 0) {
                                    a.mVs.add("");
                                } else {
                                    StringBuilder stringBuilder = new StringBuilder();
                                    int i2 = 0;
                                    while (true) {
                                        int i3 = i2;
                                        if (i3 >= arVar.nbh.size()) {
                                            break;
                                        }
                                        ad aoO = ((j) g.K(j.class)).XM().aoO((String) arVar.nbh.get(i3));
                                        if (aoO == null || aoO.ewQ == 0) {
                                            stringBuilder.append((String) arVar.nbh.get(i3));
                                        } else {
                                            stringBuilder.append(aoO.Oj());
                                        }
                                        if (i3 < arVar.nbh.size() - 1) {
                                            stringBuilder.append("、");
                                        }
                                        i2 = i3 + 1;
                                    }
                                    stringBuilder.append(" ");
                                    a.mVs.add(stringBuilder.toString());
                                }
                                a.mVs.add(arVar.naq);
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
        AppMethodBeat.o(111387);
        return linkedList;
    }

    private void bER() {
        AppMethodBeat.i(111388);
        this.mYk = new HashMap();
        if (this.mYh.ncl == null || this.mYh.ncl.ncP == null) {
            AppMethodBeat.o(111388);
            return;
        }
        Iterator it = this.mYh.ncl.ncP.iterator();
        while (it.hasNext()) {
            cd cdVar = (cd) it.next();
            c a = x.a(cdVar.mZk);
            if (a != null) {
                this.mYk.put(a.field_appId, Integer.valueOf(a.versionCode));
                f aiJ = com.tencent.mm.plugin.s.a.bYJ().aiJ(a.field_appId);
                if (aiJ != null) {
                    aiJ.ij(cdVar.ncR);
                    if (!com.tencent.mm.plugin.s.a.bYJ().a(aiJ, new String[0])) {
                        ab.e("MicroMsg.GamePBDataOverSea", "Store rank info failed, AppID: %s", aiJ.field_appId);
                    }
                }
            }
        }
        AppMethodBeat.o(111388);
    }

    public final at bES() {
        return this.mYh != null ? this.mYh.nci : null;
    }
}
