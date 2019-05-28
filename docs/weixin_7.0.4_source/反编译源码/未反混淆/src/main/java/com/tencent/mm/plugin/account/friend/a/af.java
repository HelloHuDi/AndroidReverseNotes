package com.tencent.mm.plugin.account.friend.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.aru;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.ayk;
import com.tencent.mm.protocal.protobuf.ayl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public final class af extends m implements k {
    private final b ehh;
    private f ehi;
    private String gtl;
    private HashMap<String, n> gto = new HashMap();
    private ArrayList<n> gwi;
    private int gwj;
    private int gwk;
    private int gwl;
    private int gwm;

    public af(ArrayList<n> arrayList, int i, HashMap<String, n> hashMap, String str) {
        AppMethodBeat.i(108465);
        a aVar = new a();
        aVar.fsJ = new ayk();
        aVar.fsK = new ayl();
        aVar.uri = "/cgi-bin/micromsg-bin/listgooglecontact";
        aVar.fsI = com.tencent.mm.plugin.appbrand.jsapi.p.f.CTRL_INDEX;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        this.gwi = arrayList;
        this.gwj = i;
        this.gwk = 0;
        this.gwm = 1;
        this.gto = hashMap;
        this.gtl = str;
        AppMethodBeat.o(108465);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(108466);
        ab.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "doScene");
        this.ehi = fVar;
        ayk ayk = (ayk) this.ehh.fsG.fsP;
        if (this.gwi != null) {
            LinkedList linkedList = new LinkedList();
            this.gwl = this.gwi.size();
            int i = this.gwk;
            while (true) {
                int i2 = i;
                if (i2 >= this.gwl || i2 >= this.gwk + 500) {
                    ayk.jBw = linkedList;
                    ayk.jBv = linkedList.size();
                } else {
                    arv arv = new arv();
                    arv.vLf = ((n) this.gwi.get(i2)).field_googlegmail;
                    linkedList.add(arv);
                    i = i2 + 1;
                }
            }
            ayk.jBw = linkedList;
            ayk.jBv = linkedList.size();
            if (this.gwk + 500 > this.gwl) {
                this.gwm = 0;
            } else {
                this.gwm = 1;
            }
            ayk.vQe = this.gwm;
            ayk.wCm = this.gwj;
            ab.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "doscene mTotalSize:%d, mStarIndex:%d, mContinueFlag:%d", Integer.valueOf(this.gwl), Integer.valueOf(this.gwk), Integer.valueOf(this.gwm));
        }
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(108466);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(108467);
        ab.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "NetId:%d, ErrType:%d, ErrCode:%d, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            a(aqi());
            if (this.gwm == 1) {
                this.gwk += 500;
                if (a(this.ftf, this.ehi) < 0) {
                    ab.e("MicroMsg.GoogleContact.NetSceneListGoogleContact", "doScene again failed");
                    this.ehi.onSceneEnd(3, -1, "", this);
                }
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(108467);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(108467);
    }

    public final ayl aqi() {
        return (ayl) this.ehh.fsH.fsP;
    }

    private synchronized void a(ayl ayl) {
        AppMethodBeat.i(108468);
        ab.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "handleListGoogleContactCGIResponse Count:%d", Integer.valueOf(ayl.jBv));
        if (ayl.jBw != null && ayl.jBw.size() > 0) {
            int size = ayl.jBw.size();
            ArrayList arrayList = new ArrayList();
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < size; i++) {
                int i2;
                aru aru = (aru) ayl.jBw.get(i);
                if (TextUtils.isEmpty(aru.jBB)) {
                    i2 = 1;
                } else {
                    ad aoO = ((j) g.K(j.class)).XM().aoO(aru.jBB);
                    i2 = (aoO == null || !com.tencent.mm.n.a.jh(aoO.field_type)) ? 0 : 2;
                }
                if (this.gto != null && this.gto.containsKey(aru.vLf)) {
                    n nVar = (n) this.gto.get(aru.vLf);
                    nVar.field_username = aru.jBB;
                    nVar.field_nickname = aru.jCH;
                    nVar.field_usernamepy = com.tencent.mm.platformtools.g.vp(aru.jCH);
                    nVar.field_nicknameqp = com.tencent.mm.platformtools.g.vo(aru.jCH);
                    nVar.field_ret = aru.Ret;
                    nVar.field_small_url = aru.wvM;
                    nVar.field_big_url = aru.wvL;
                    nVar.field_status = i2;
                    nVar.field_googlecgistatus = 2;
                    if (i2 == 2 || i2 == 0) {
                        nVar.field_contecttype = "weixin".concat(String.valueOf(i));
                    } else {
                        nVar.field_contecttype = "google";
                    }
                    nVar.field_googlenamepy = com.tencent.mm.platformtools.g.vp(nVar.field_googlename);
                    arrayList.add(nVar);
                    String str = nVar.field_googleid;
                    String str2 = nVar.field_googlephotourl;
                    String str3 = this.gtl;
                    if (!(TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3))) {
                        str = str + "@google";
                        h qo = o.act().qo(str);
                        if (qo == null) {
                            qo = new h();
                        }
                        qo.username = str;
                        qo.dtR = 3;
                        qo.frW = com.tencent.mm.ah.b.at(str2, str3);
                        qo.frV = com.tencent.mm.ah.b.at(str2, str3);
                        qo.cB(true);
                        qo.bJt = 31;
                        o.act().b(qo);
                    }
                    com.tencent.mm.storage.g.a aVar = new com.tencent.mm.storage.g.a();
                    aVar.field_userName = aru.jBB;
                    aVar.field_scene = 58;
                    aVar.field_ticket = aru.wlF;
                    linkedList.add(aVar);
                }
            }
            ((o) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).j(arrayList);
            com.tencent.mm.plugin.c.a.ask().Yn().en(linkedList);
        }
        AppMethodBeat.o(108468);
    }

    public final int getType() {
        return com.tencent.mm.plugin.appbrand.jsapi.p.f.CTRL_INDEX;
    }

    public final int acn() {
        return 20;
    }

    public final m.b b(q qVar) {
        return m.b.EOk;
    }
}
