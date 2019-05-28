package com.tencent.mm.insane_statistic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.e;
import com.tencent.mm.g.a.np;
import com.tencent.mm.g.a.nq;
import com.tencent.mm.g.a.nr;
import com.tencent.mm.i.d;
import com.tencent.mm.model.n;
import com.tencent.mm.model.t;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.clk;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.net.URLEncoder;

public final class b implements com.tencent.mm.at.r.a {

    static class a {
        bi csG = null;
        long eFm;
        int eFn;
        e eFo;
        String eFp;
        boolean eFq = false;
        String eFr;
        int eFs = 0;
        d eFt;
        boolean eFu = false;
        c eFv = new c<nr>() {
            {
                AppMethodBeat.i(16175);
                this.xxI = nr.class.getName().hashCode();
                AppMethodBeat.o(16175);
            }

            private boolean a(nr nrVar) {
                AppMethodBeat.i(16176);
                if (nrVar.cJX.filePath.equals(a.this.eFr)) {
                    String encode;
                    String str = "";
                    try {
                        encode = URLEncoder.encode(nrVar.cJX.result, "UTF-8");
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.OnNetSceneUploadMsgImgEnd", e, "", new Object[0]);
                        encode = str;
                    }
                    if (a.this.eFu) {
                        ab.i("MicroMsg.OnNetSceneUploadMsgImgEnd", "androidSystemShareFixed(13717) , imgLocalId:%d, scene.hash:%d, %s, filePath:%s", Long.valueOf(a.this.eFm), Integer.valueOf(a.this.hashCode()), a.this.eFp + encode, nrVar.cJX.filePath);
                        h.pYm.X(13717, str);
                    }
                    if (a.this.eFs == 1) {
                        com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
                        clk clk = (clk) a.this.ehh.fsG.fsP;
                        dVar.l("20toUser", clk.vEC.wVI + ",");
                        dVar.l("21source", a.this.eFn + ",");
                        dVar.l("22qrUrl", encode + ",");
                        dVar.l("23md5", (a.this.eFt == null ? "" : a.this.eFt.field_filemd5) + ",");
                        dVar.l("24cdnFileId", (a.this.eFt == null ? "" : a.this.eFt.field_fileId) + ",");
                        dVar.l("25cdnAesKey", (a.this.eFt == null ? "" : a.this.eFt.field_aesKey) + ",");
                        encode = "";
                        if (a.this.csG.bAA()) {
                            com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(a.this.csG.field_content);
                            if (me != null) {
                                encode = me.appId;
                            }
                        }
                        dVar.l("26appip", encode + ",");
                        dVar.l("27toUsersCount", n.mA(clk.vEC.wVI) + ",");
                        dVar.l("28codeType", Integer.valueOf(nrVar.cJX.cvn));
                        ab.i("MicroMsg.OnNetSceneUploadMsgImgEnd", "report qrCodeImgChatting(13628): " + dVar.Fk());
                        o.y(13628, dVar.toString());
                    }
                    a.a(a.this);
                    AppMethodBeat.o(16176);
                } else {
                    AppMethodBeat.o(16176);
                }
                return false;
            }
        };
        c eFw = new c<nq>() {
            {
                AppMethodBeat.i(16178);
                this.xxI = nq.class.getName().hashCode();
                AppMethodBeat.o(16178);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(16179);
                if (((nq) bVar).cJW.filePath.equals(a.this.eFr)) {
                    if (a.this.eFu) {
                        ab.i("MicroMsg.OnNetSceneUploadMsgImgEnd", "androidSystemShareFixed(13717), imgLocalId:%d, scene.hash:%d, %s", Long.valueOf(a.this.eFm), Integer.valueOf(a.this.hashCode()), a.this.eFp);
                        h.pYm.X(13717, a.this.eFp);
                    }
                    a.a(a.this);
                    AppMethodBeat.o(16179);
                } else {
                    AppMethodBeat.o(16179);
                }
                return false;
            }
        };
        final com.tencent.mm.ai.b ehh;

        a(long j, bi biVar, com.tencent.mm.ai.b bVar, boolean z, int i) {
            AppMethodBeat.i(16180);
            this.eFm = j;
            this.csG = biVar;
            this.ehh = bVar;
            this.eFn = i;
            this.eFu = z;
            AppMethodBeat.o(16180);
        }

        static /* synthetic */ void a(a aVar) {
            AppMethodBeat.i(16181);
            com.tencent.mm.sdk.b.a.xxA.d(aVar.eFv);
            com.tencent.mm.sdk.b.a.xxA.d(aVar.eFw);
            AppMethodBeat.o(16181);
        }
    }

    public final void a(long j, bi biVar, com.tencent.mm.ai.b bVar, int i, boolean z, d dVar) {
        AppMethodBeat.i(16182);
        a aVar = new a(j, biVar, bVar, z, i);
        com.tencent.mm.storage.c ll = com.tencent.mm.model.c.c.abi().ll("100131");
        if (ll.isValid()) {
            aVar.eFs = ah.getInt((String) ll.dru().get("needUploadData"), 1);
        }
        if (aVar.eFq || (!aVar.eFu && aVar.eFs == 0)) {
            AppMethodBeat.o(16182);
            return;
        }
        int i2;
        aVar.eFt = dVar;
        aVar.eFq = true;
        String str = ((clk) aVar.ehh.fsG.fsP).vEC.wVI;
        Object obj = (bo.isNullOrNil(str) || !t.kH(str)) ? null : 1;
        StringBuilder stringBuilder = new StringBuilder("2,");
        if (obj != null) {
            i2 = 2;
        } else {
            i2 = 1;
        }
        aVar.eFp = stringBuilder.append(i2).append(",,").toString();
        if (aVar.eFo == null) {
            aVar.eFo = com.tencent.mm.at.o.ahl().b(Long.valueOf(aVar.eFm));
        }
        e eVar = aVar.eFo;
        if (eVar != null) {
            np npVar = new np();
            com.tencent.mm.sdk.b.a.xxA.c(aVar.eFv);
            com.tencent.mm.sdk.b.a.xxA.c(aVar.eFw);
            aVar.eFr = com.tencent.mm.at.o.ahl().q(eVar.fDz, "", "");
            npVar.cJU.filePath = aVar.eFr;
            com.tencent.mm.sdk.b.a.xxA.m(npVar);
        }
        AppMethodBeat.o(16182);
    }
}
