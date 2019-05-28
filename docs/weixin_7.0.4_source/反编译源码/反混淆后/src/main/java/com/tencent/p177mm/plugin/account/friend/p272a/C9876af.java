package com.tencent.p177mm.plugin.account.friend.p272a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p182ah.C17880h;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.platformtools.C9790g;
import com.tencent.p177mm.plugin.account.p765a.p766a.C7599a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p313p.C27059f;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.p930c.C20118a;
import com.tencent.p177mm.protocal.protobuf.aru;
import com.tencent.p177mm.protocal.protobuf.arv;
import com.tencent.p177mm.protocal.protobuf.ayk;
import com.tencent.p177mm.protocal.protobuf.ayl;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C36003g.C15441a;
import com.tencent.p177mm.storage.C7616ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.account.friend.a.af */
public final class C9876af extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;
    private String gtl;
    private HashMap<String, C45498n> gto = new HashMap();
    private ArrayList<C45498n> gwi;
    private int gwj;
    private int gwk;
    private int gwl;
    private int gwm;

    public C9876af(ArrayList<C45498n> arrayList, int i, HashMap<String, C45498n> hashMap, String str) {
        AppMethodBeat.m2504i(108465);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new ayk();
        c1196a.fsK = new ayl();
        c1196a.uri = "/cgi-bin/micromsg-bin/listgooglecontact";
        c1196a.fsI = C27059f.CTRL_INDEX;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        this.gwi = arrayList;
        this.gwj = i;
        this.gwk = 0;
        this.gwm = 1;
        this.gto = hashMap;
        this.gtl = str;
        AppMethodBeat.m2505o(108465);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(108466);
        C4990ab.m7416i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "doScene");
        this.ehi = c1202f;
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
                    arv.vLf = ((C45498n) this.gwi.get(i2)).field_googlegmail;
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
            C4990ab.m7417i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "doscene mTotalSize:%d, mStarIndex:%d, mContinueFlag:%d", Integer.valueOf(this.gwl), Integer.valueOf(this.gwk), Integer.valueOf(this.gwm));
        }
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(108466);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(108467);
        C4990ab.m7417i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "NetId:%d, ErrType:%d, ErrCode:%d, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            m17508a(aqi());
            if (this.gwm == 1) {
                this.gwk += 500;
                if (mo4456a(this.ftf, this.ehi) < 0) {
                    C4990ab.m7412e("MicroMsg.GoogleContact.NetSceneListGoogleContact", "doScene again failed");
                    this.ehi.onSceneEnd(3, -1, "", this);
                }
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(108467);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(108467);
    }

    public final ayl aqi() {
        return (ayl) this.ehh.fsH.fsP;
    }

    /* renamed from: a */
    private synchronized void m17508a(ayl ayl) {
        AppMethodBeat.m2504i(108468);
        C4990ab.m7417i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "handleListGoogleContactCGIResponse Count:%d", Integer.valueOf(ayl.jBv));
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
                    C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(aru.jBB);
                    i2 = (aoO == null || !C7486a.m12942jh(aoO.field_type)) ? 0 : 2;
                }
                if (this.gto != null && this.gto.containsKey(aru.vLf)) {
                    C45498n c45498n = (C45498n) this.gto.get(aru.vLf);
                    c45498n.field_username = aru.jBB;
                    c45498n.field_nickname = aru.jCH;
                    c45498n.field_usernamepy = C9790g.m17433vp(aru.jCH);
                    c45498n.field_nicknameqp = C9790g.m17432vo(aru.jCH);
                    c45498n.field_ret = aru.Ret;
                    c45498n.field_small_url = aru.wvM;
                    c45498n.field_big_url = aru.wvL;
                    c45498n.field_status = i2;
                    c45498n.field_googlecgistatus = 2;
                    if (i2 == 2 || i2 == 0) {
                        c45498n.field_contecttype = "weixin".concat(String.valueOf(i));
                    } else {
                        c45498n.field_contecttype = "google";
                    }
                    c45498n.field_googlenamepy = C9790g.m17433vp(c45498n.field_googlename);
                    arrayList.add(c45498n);
                    String str = c45498n.field_googleid;
                    String str2 = c45498n.field_googlephotourl;
                    String str3 = this.gtl;
                    if (!(TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3))) {
                        str = str + "@google";
                        C17880h qo = C17884o.act().mo33392qo(str);
                        if (qo == null) {
                            qo = new C17880h();
                        }
                        qo.username = str;
                        qo.dtR = 3;
                        qo.frW = C41730b.m73492at(str2, str3);
                        qo.frV = C41730b.m73492at(str2, str3);
                        qo.mo33385cB(true);
                        qo.bJt = 31;
                        C17884o.act().mo33391b(qo);
                    }
                    C15441a c15441a = new C15441a();
                    c15441a.field_userName = aru.jBB;
                    c15441a.field_scene = 58;
                    c15441a.field_ticket = aru.wlF;
                    linkedList.add(c15441a);
                }
            }
            ((C38036o) ((C7599a) C1720g.m3530M(C7599a.class)).getGoogleFriendStorage()).mo60784j(arrayList);
            C20118a.ask().mo35364Yn().mo56746en(linkedList);
        }
        AppMethodBeat.m2505o(108468);
    }

    public final int getType() {
        return C27059f.CTRL_INDEX;
    }

    public final int acn() {
        return 20;
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        return C1206b.EOk;
    }
}
