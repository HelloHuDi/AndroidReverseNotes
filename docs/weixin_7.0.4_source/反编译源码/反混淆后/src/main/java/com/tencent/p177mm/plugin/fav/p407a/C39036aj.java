package com.tencent.p177mm.plugin.fav.p407a;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.appbrand.jsapi.contact.JsApiChooseWeChatContact;
import com.tencent.p177mm.protocal.C44098aa;
import com.tencent.p177mm.protocal.protobuf.C40573tb;
import com.tencent.p177mm.protocal.protobuf.C46530cg;
import com.tencent.p177mm.protocal.protobuf.abm;
import com.tencent.p177mm.protocal.protobuf.abn;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.fav.a.aj */
public final class C39036aj extends C1207m implements C1918k {
    final C7472b ehh;
    C1202f ehi = null;
    private int fHJ = 1;
    private C20674a mgj = new C20674a();
    long mgk = -1;
    public boolean mgl = false;

    /* renamed from: com.tencent.mm.plugin.fav.a.aj$a */
    class C20674a {
        LinkedList<C40573tb> mgm;
        C7306ak mgn = new C7306ak("MicroMsg.Fav.NetSceneFavSync") {
            public final void handleMessage(Message message) {
                AppMethodBeat.m2504i(102734);
                if (C20674a.this.mgm == null || C20674a.this.mgm.isEmpty()) {
                    C39036aj c39036aj = C39036aj.this;
                    abm abm = (abm) c39036aj.ehh.fsG.fsP;
                    abn abn = (abn) c39036aj.ehh.fsH.fsP;
                    byte[] j = C44098aa.m79382j(abm.vTO.getBuffer().toByteArray(), abn.vTO.getBuffer().toByteArray());
                    if (j != null && j.length > 0) {
                        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavConfigStorage().mo15172aV(j);
                    }
                    abm.vTO = C1946aa.m4152ad(j);
                    if ((abm.vTN & abn.vQe) == 0) {
                        C4990ab.m7417i("MicroMsg.Fav.NetSceneFavSync", "processEnd, minUpdateTime:%d", Long.valueOf(c39036aj.mgk));
                        C1720g.m3536RP().mo5239Ry().set(8217, Integer.valueOf(1));
                        if (c39036aj.mgk > 0) {
                            LinkedList v = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23697v(c39036aj.mgk, -1);
                            if (v.size() > 0) {
                                if (v.size() > 40) {
                                    List subList = v.subList(0, 40);
                                    v = new LinkedList();
                                    v.addAll(subList);
                                }
                                c39036aj.mgl = true;
                                C4990ab.m7417i("MicroMsg.Fav.NetSceneFavSync", "processEnd, start batch get list size:%d", Integer.valueOf(v.size()));
                                if (!C1720g.m3540Rg().mo14541a(new C34125ah(v), 0)) {
                                    C4990ab.m7420w("MicroMsg.Fav.NetSceneFavSync", "do scene BatchGetFav fail");
                                    C34125ah.bve();
                                }
                            }
                        }
                        c39036aj.ehi.onSceneEnd(0, 0, "", c39036aj);
                        AppMethodBeat.m2505o(102734);
                        return;
                    }
                    C4990ab.m7417i("MicroMsg.Fav.NetSceneFavSync", "continue flag:%d", Integer.valueOf(abn.vQe));
                    c39036aj.mo4456a(c39036aj.ftf, c39036aj.ehi);
                    AppMethodBeat.m2505o(102734);
                    return;
                }
                C40573tb c40573tb = (C40573tb) C20674a.this.mgm.getFirst();
                C4990ab.m7410d("MicroMsg.Fav.NetSceneFavSync", "cmdId = " + c40573tb.wat);
                C20674a.this.mgm.removeFirst();
                switch (c40573tb.wat) {
                    case 200:
                        byte[] a = C1946aa.m4150a(c40573tb.wau);
                        if (a != null) {
                            C39036aj c39036aj2 = C39036aj.this;
                            try {
                                String str = "MicroMsg.Fav.NetSceneFavSync";
                                String str2 = "processAddItem bufSize=%d";
                                Object[] objArr = new Object[1];
                                objArr[0] = Integer.valueOf(a != null ? a.length : 0);
                                C4990ab.m7417i(str, str2, objArr);
                                C46530cg c46530cg = (C46530cg) new C46530cg().parseFrom(a);
                                if (c46530cg == null) {
                                    C4990ab.m7412e("MicroMsg.Fav.NetSceneFavSync", "klem processAddItem favitem null");
                                } else {
                                    C4990ab.m7417i("MicroMsg.Fav.NetSceneFavSync", "klem processAddItem id:%d, flag:%d, updateSeq:%d, updateTime:%d", Integer.valueOf(c46530cg.vEp), Integer.valueOf(c46530cg.vEq), Integer.valueOf(c46530cg.vEs), Integer.valueOf(c46530cg.vEr));
                                    if ((c46530cg.vEq & 1) != 0) {
                                        C39037b.m66366a(((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23694iF((long) c46530cg.vEp), false, null);
                                    } else {
                                        int i;
                                        if (c39036aj2.mgk < 0 || ((long) c46530cg.vEr) < c39036aj2.mgk) {
                                            c39036aj2.mgk = (long) c46530cg.vEr;
                                        }
                                        C27966g iF = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23694iF((long) c46530cg.vEp);
                                        if (iF == null) {
                                            iF = new C27966g();
                                            iF.field_updateTime = ((long) c46530cg.vEr) * 1000;
                                            i = 1;
                                        } else {
                                            i = 0;
                                        }
                                        iF.field_id = c46530cg.vEp;
                                        iF.field_updateSeq = c46530cg.vEs;
                                        if (iF.field_localSeq == c46530cg.vEs) {
                                            iF.field_updateTime = ((long) c46530cg.vEr) * 1000;
                                        }
                                        iF.field_flag = c46530cg.vEq;
                                        iF.field_type = c46530cg.jCt;
                                        if (i != 0) {
                                            iF.field_localId = System.currentTimeMillis();
                                            ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23700y(iF);
                                        } else {
                                            ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23678a(iF, "localId");
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                C4990ab.printErrStackTrace("MicroMsg.Fav.NetSceneFavSync", e, "", new Object[0]);
                            }
                            sendEmptyMessage(0);
                            break;
                        }
                        C4990ab.m7412e("MicroMsg.Fav.NetSceneFavSync", "docmd: no protobuf found.");
                        sendEmptyMessage(0);
                        AppMethodBeat.m2505o(102734);
                        return;
                }
                AppMethodBeat.m2505o(102734);
            }
        };

        C20674a() {
            AppMethodBeat.m2504i(102735);
            AppMethodBeat.m2505o(102735);
        }
    }

    public C39036aj() {
        AppMethodBeat.m2504i(102736);
        C4990ab.m7416i("MicroMsg.Fav.NetSceneFavSync", "NetSceneFavSync");
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new abm();
        c1196a.fsK = new abn();
        c1196a.uri = "/cgi-bin/micromsg-bin/favsync";
        c1196a.fsI = 400;
        c1196a.fsL = JsApiChooseWeChatContact.CTRL_INDEX;
        c1196a.fsM = 1000000195;
        c1196a.fsN = false;
        this.ehh = c1196a.acD();
        AppMethodBeat.m2505o(102736);
    }

    public C39036aj(int i) {
        AppMethodBeat.m2504i(102737);
        C4990ab.m7417i("MicroMsg.Fav.NetSceneFavSync", "NetSceneFavSync %d", Integer.valueOf(i));
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new abm();
        c1196a.fsK = new abn();
        c1196a.uri = "/cgi-bin/micromsg-bin/favsync";
        c1196a.fsI = 400;
        c1196a.fsL = JsApiChooseWeChatContact.CTRL_INDEX;
        c1196a.fsM = 1000000195;
        c1196a.fsN = false;
        this.ehh = c1196a.acD();
        this.fHJ = i;
        AppMethodBeat.m2505o(102737);
    }

    public final boolean acI() {
        return true;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(102738);
        this.ehi = c1202f;
        abm abm = (abm) this.ehh.fsG.fsP;
        abm.vTN = this.fHJ;
        byte[] buP = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavConfigStorage().buP();
        if (this.fHJ == 2) {
            buP = new byte[0];
        }
        abm.vTO = C1946aa.m4152ad(buP);
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(102738);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(102739);
        C4990ab.m7416i("MicroMsg.Fav.NetSceneFavSync", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (((C7604ae) C1720g.m3530M(C7604ae.class)).getSendService().ame()) {
            C4990ab.m7420w("MicroMsg.Fav.NetSceneFavSync", "sending item, skip sync onGYNetEnd");
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(102739);
        } else if (i2 == 0 && i3 == 0) {
            abn abn = (abn) ((C7472b) c1929q).fsH.fsP;
            LinkedList linkedList = abn.vTR.jBw;
            if (linkedList == null || linkedList.size() <= 0) {
                if (abn.vTO.getBuffer() != null) {
                    byte[] j = C44098aa.m79382j(((abm) ((C7472b) c1929q).fsG.fsP).vTO.getBuffer().toByteArray(), abn.vTO.getBuffer().toByteArray());
                    if (j != null && j.length > 0) {
                        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavConfigStorage().mo15172aV(j);
                    }
                } else {
                    C4990ab.m7412e("MicroMsg.Fav.NetSceneFavSync", "merge key should not be null");
                }
                C1720g.m3536RP().mo5239Ry().set(8217, Integer.valueOf(1));
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(102739);
                return;
            }
            C4990ab.m7416i("MicroMsg.Fav.NetSceneFavSync", "cmdList size:" + linkedList.size());
            if (this.fHJ != 2) {
                C20674a c20674a = this.mgj;
                c20674a.mgm = linkedList;
                if (c20674a.mgm != null && c20674a.mgm.size() > 0) {
                    C1720g.m3540Rg().mo14541a(new C34126ak(), 0);
                }
                c20674a.mgn.sendEmptyMessage(0);
                AppMethodBeat.m2505o(102739);
                return;
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(102739);
        } else {
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(102739);
        }
    }

    public final int acn() {
        return 50;
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        return C1206b.EOk;
    }

    public final int getType() {
        return 400;
    }
}
