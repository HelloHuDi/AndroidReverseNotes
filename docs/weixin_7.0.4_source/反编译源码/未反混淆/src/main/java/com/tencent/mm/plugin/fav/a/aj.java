package com.tencent.mm.plugin.fav.a;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChooseWeChatContact;
import com.tencent.mm.protocal.aa;
import com.tencent.mm.protocal.protobuf.abm;
import com.tencent.mm.protocal.protobuf.abn;
import com.tencent.mm.protocal.protobuf.cg;
import com.tencent.mm.protocal.protobuf.tb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.LinkedList;
import java.util.List;

public final class aj extends m implements k {
    final b ehh;
    f ehi = null;
    private int fHJ = 1;
    private a mgj = new a();
    long mgk = -1;
    public boolean mgl = false;

    class a {
        LinkedList<tb> mgm;
        ak mgn = new ak("MicroMsg.Fav.NetSceneFavSync") {
            public final void handleMessage(Message message) {
                AppMethodBeat.i(102734);
                if (a.this.mgm == null || a.this.mgm.isEmpty()) {
                    aj ajVar = aj.this;
                    abm abm = (abm) ajVar.ehh.fsG.fsP;
                    abn abn = (abn) ajVar.ehh.fsH.fsP;
                    byte[] j = aa.j(abm.vTO.getBuffer().toByteArray(), abn.vTO.getBuffer().toByteArray());
                    if (j != null && j.length > 0) {
                        ((ae) g.M(ae.class)).getFavConfigStorage().aV(j);
                    }
                    abm.vTO = com.tencent.mm.platformtools.aa.ad(j);
                    if ((abm.vTN & abn.vQe) == 0) {
                        ab.i("MicroMsg.Fav.NetSceneFavSync", "processEnd, minUpdateTime:%d", Long.valueOf(ajVar.mgk));
                        g.RP().Ry().set(8217, Integer.valueOf(1));
                        if (ajVar.mgk > 0) {
                            LinkedList v = ((ae) g.M(ae.class)).getFavItemInfoStorage().v(ajVar.mgk, -1);
                            if (v.size() > 0) {
                                if (v.size() > 40) {
                                    List subList = v.subList(0, 40);
                                    v = new LinkedList();
                                    v.addAll(subList);
                                }
                                ajVar.mgl = true;
                                ab.i("MicroMsg.Fav.NetSceneFavSync", "processEnd, start batch get list size:%d", Integer.valueOf(v.size()));
                                if (!g.Rg().a(new ah(v), 0)) {
                                    ab.w("MicroMsg.Fav.NetSceneFavSync", "do scene BatchGetFav fail");
                                    ah.bve();
                                }
                            }
                        }
                        ajVar.ehi.onSceneEnd(0, 0, "", ajVar);
                        AppMethodBeat.o(102734);
                        return;
                    }
                    ab.i("MicroMsg.Fav.NetSceneFavSync", "continue flag:%d", Integer.valueOf(abn.vQe));
                    ajVar.a(ajVar.ftf, ajVar.ehi);
                    AppMethodBeat.o(102734);
                    return;
                }
                tb tbVar = (tb) a.this.mgm.getFirst();
                ab.d("MicroMsg.Fav.NetSceneFavSync", "cmdId = " + tbVar.wat);
                a.this.mgm.removeFirst();
                switch (tbVar.wat) {
                    case 200:
                        byte[] a = com.tencent.mm.platformtools.aa.a(tbVar.wau);
                        if (a != null) {
                            aj ajVar2 = aj.this;
                            try {
                                String str = "MicroMsg.Fav.NetSceneFavSync";
                                String str2 = "processAddItem bufSize=%d";
                                Object[] objArr = new Object[1];
                                objArr[0] = Integer.valueOf(a != null ? a.length : 0);
                                ab.i(str, str2, objArr);
                                cg cgVar = (cg) new cg().parseFrom(a);
                                if (cgVar == null) {
                                    ab.e("MicroMsg.Fav.NetSceneFavSync", "klem processAddItem favitem null");
                                } else {
                                    ab.i("MicroMsg.Fav.NetSceneFavSync", "klem processAddItem id:%d, flag:%d, updateSeq:%d, updateTime:%d", Integer.valueOf(cgVar.vEp), Integer.valueOf(cgVar.vEq), Integer.valueOf(cgVar.vEs), Integer.valueOf(cgVar.vEr));
                                    if ((cgVar.vEq & 1) != 0) {
                                        b.a(((ae) g.M(ae.class)).getFavItemInfoStorage().iF((long) cgVar.vEp), false, null);
                                    } else {
                                        int i;
                                        if (ajVar2.mgk < 0 || ((long) cgVar.vEr) < ajVar2.mgk) {
                                            ajVar2.mgk = (long) cgVar.vEr;
                                        }
                                        g iF = ((ae) g.M(ae.class)).getFavItemInfoStorage().iF((long) cgVar.vEp);
                                        if (iF == null) {
                                            iF = new g();
                                            iF.field_updateTime = ((long) cgVar.vEr) * 1000;
                                            i = 1;
                                        } else {
                                            i = 0;
                                        }
                                        iF.field_id = cgVar.vEp;
                                        iF.field_updateSeq = cgVar.vEs;
                                        if (iF.field_localSeq == cgVar.vEs) {
                                            iF.field_updateTime = ((long) cgVar.vEr) * 1000;
                                        }
                                        iF.field_flag = cgVar.vEq;
                                        iF.field_type = cgVar.jCt;
                                        if (i != 0) {
                                            iF.field_localId = System.currentTimeMillis();
                                            ((ae) g.M(ae.class)).getFavItemInfoStorage().y(iF);
                                        } else {
                                            ((ae) g.M(ae.class)).getFavItemInfoStorage().a(iF, "localId");
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                ab.printErrStackTrace("MicroMsg.Fav.NetSceneFavSync", e, "", new Object[0]);
                            }
                            sendEmptyMessage(0);
                            break;
                        }
                        ab.e("MicroMsg.Fav.NetSceneFavSync", "docmd: no protobuf found.");
                        sendEmptyMessage(0);
                        AppMethodBeat.o(102734);
                        return;
                }
                AppMethodBeat.o(102734);
            }
        };

        a() {
            AppMethodBeat.i(102735);
            AppMethodBeat.o(102735);
        }
    }

    public aj() {
        AppMethodBeat.i(102736);
        ab.i("MicroMsg.Fav.NetSceneFavSync", "NetSceneFavSync");
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new abm();
        aVar.fsK = new abn();
        aVar.uri = "/cgi-bin/micromsg-bin/favsync";
        aVar.fsI = 400;
        aVar.fsL = JsApiChooseWeChatContact.CTRL_INDEX;
        aVar.fsM = 1000000195;
        aVar.fsN = false;
        this.ehh = aVar.acD();
        AppMethodBeat.o(102736);
    }

    public aj(int i) {
        AppMethodBeat.i(102737);
        ab.i("MicroMsg.Fav.NetSceneFavSync", "NetSceneFavSync %d", Integer.valueOf(i));
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new abm();
        aVar.fsK = new abn();
        aVar.uri = "/cgi-bin/micromsg-bin/favsync";
        aVar.fsI = 400;
        aVar.fsL = JsApiChooseWeChatContact.CTRL_INDEX;
        aVar.fsM = 1000000195;
        aVar.fsN = false;
        this.ehh = aVar.acD();
        this.fHJ = i;
        AppMethodBeat.o(102737);
    }

    public final boolean acI() {
        return true;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(102738);
        this.ehi = fVar;
        abm abm = (abm) this.ehh.fsG.fsP;
        abm.vTN = this.fHJ;
        byte[] buP = ((ae) g.M(ae.class)).getFavConfigStorage().buP();
        if (this.fHJ == 2) {
            buP = new byte[0];
        }
        abm.vTO = com.tencent.mm.platformtools.aa.ad(buP);
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(102738);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(102739);
        ab.i("MicroMsg.Fav.NetSceneFavSync", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (((ae) g.M(ae.class)).getSendService().ame()) {
            ab.w("MicroMsg.Fav.NetSceneFavSync", "sending item, skip sync onGYNetEnd");
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(102739);
        } else if (i2 == 0 && i3 == 0) {
            abn abn = (abn) ((b) qVar).fsH.fsP;
            LinkedList linkedList = abn.vTR.jBw;
            if (linkedList == null || linkedList.size() <= 0) {
                if (abn.vTO.getBuffer() != null) {
                    byte[] j = aa.j(((abm) ((b) qVar).fsG.fsP).vTO.getBuffer().toByteArray(), abn.vTO.getBuffer().toByteArray());
                    if (j != null && j.length > 0) {
                        ((ae) g.M(ae.class)).getFavConfigStorage().aV(j);
                    }
                } else {
                    ab.e("MicroMsg.Fav.NetSceneFavSync", "merge key should not be null");
                }
                g.RP().Ry().set(8217, Integer.valueOf(1));
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(102739);
                return;
            }
            ab.i("MicroMsg.Fav.NetSceneFavSync", "cmdList size:" + linkedList.size());
            if (this.fHJ != 2) {
                a aVar = this.mgj;
                aVar.mgm = linkedList;
                if (aVar.mgm != null && aVar.mgm.size() > 0) {
                    g.Rg().a(new ak(), 0);
                }
                aVar.mgn.sendEmptyMessage(0);
                AppMethodBeat.o(102739);
                return;
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(102739);
        } else {
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(102739);
        }
    }

    public final int acn() {
        return 50;
    }

    public final m.b b(q qVar) {
        return m.b.EOk;
    }

    public final int getType() {
        return 400;
    }
}
