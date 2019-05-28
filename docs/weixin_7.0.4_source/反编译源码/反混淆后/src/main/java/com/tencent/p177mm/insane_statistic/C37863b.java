package com.tencent.p177mm.insane_statistic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.modelsns.C32831d;
import com.tencent.p177mm.modelstat.C18698o;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p190at.C25822e;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.C32295r.C25829a;
import com.tencent.p177mm.p230g.p231a.C18346nr;
import com.tencent.p177mm.p230g.p231a.C37774nq;
import com.tencent.p177mm.p230g.p231a.C45347np;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.clk;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5141c;
import com.tencent.p177mm.storage.C7620bi;
import java.net.URLEncoder;

/* renamed from: com.tencent.mm.insane_statistic.b */
public final class C37863b implements C25829a {

    /* renamed from: com.tencent.mm.insane_statistic.b$a */
    static class C18498a {
        C7620bi csG = null;
        long eFm;
        int eFn;
        C25822e eFo;
        String eFp;
        boolean eFq = false;
        String eFr;
        int eFs = 0;
        C9545d eFt;
        boolean eFu = false;
        C4884c eFv = new C185001();
        C4884c eFw = new C184992();
        final C7472b ehh;

        /* renamed from: com.tencent.mm.insane_statistic.b$a$2 */
        class C184992 extends C4884c<C37774nq> {
            C184992() {
                AppMethodBeat.m2504i(16178);
                this.xxI = C37774nq.class.getName().hashCode();
                AppMethodBeat.m2505o(16178);
            }

            /* renamed from: a */
            public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
                AppMethodBeat.m2504i(16179);
                if (((C37774nq) c4883b).cJW.filePath.equals(C18498a.this.eFr)) {
                    if (C18498a.this.eFu) {
                        C4990ab.m7417i("MicroMsg.OnNetSceneUploadMsgImgEnd", "androidSystemShareFixed(13717), imgLocalId:%d, scene.hash:%d, %s", Long.valueOf(C18498a.this.eFm), Integer.valueOf(C18498a.this.hashCode()), C18498a.this.eFp);
                        C7060h.pYm.mo8374X(13717, C18498a.this.eFp);
                    }
                    C18498a.m28799a(C18498a.this);
                    AppMethodBeat.m2505o(16179);
                } else {
                    AppMethodBeat.m2505o(16179);
                }
                return false;
            }
        }

        /* renamed from: com.tencent.mm.insane_statistic.b$a$1 */
        class C185001 extends C4884c<C18346nr> {
            C185001() {
                AppMethodBeat.m2504i(16175);
                this.xxI = C18346nr.class.getName().hashCode();
                AppMethodBeat.m2505o(16175);
            }

            /* renamed from: a */
            private boolean m28801a(C18346nr c18346nr) {
                AppMethodBeat.m2504i(16176);
                if (c18346nr.cJX.filePath.equals(C18498a.this.eFr)) {
                    String encode;
                    String str = "";
                    try {
                        encode = URLEncoder.encode(c18346nr.cJX.result, "UTF-8");
                    } catch (Exception e) {
                        C4990ab.printErrStackTrace("MicroMsg.OnNetSceneUploadMsgImgEnd", e, "", new Object[0]);
                        encode = str;
                    }
                    if (C18498a.this.eFu) {
                        C4990ab.m7417i("MicroMsg.OnNetSceneUploadMsgImgEnd", "androidSystemShareFixed(13717) , imgLocalId:%d, scene.hash:%d, %s, filePath:%s", Long.valueOf(C18498a.this.eFm), Integer.valueOf(C18498a.this.hashCode()), C18498a.this.eFp + encode, c18346nr.cJX.filePath);
                        C7060h.pYm.mo8374X(13717, str);
                    }
                    if (C18498a.this.eFs == 1) {
                        C32831d c32831d = new C32831d();
                        clk clk = (clk) C18498a.this.ehh.fsG.fsP;
                        c32831d.mo53400l("20toUser", clk.vEC.wVI + ",");
                        c32831d.mo53400l("21source", C18498a.this.eFn + ",");
                        c32831d.mo53400l("22qrUrl", encode + ",");
                        c32831d.mo53400l("23md5", (C18498a.this.eFt == null ? "" : C18498a.this.eFt.field_filemd5) + ",");
                        c32831d.mo53400l("24cdnFileId", (C18498a.this.eFt == null ? "" : C18498a.this.eFt.field_fileId) + ",");
                        c32831d.mo53400l("25cdnAesKey", (C18498a.this.eFt == null ? "" : C18498a.this.eFt.field_aesKey) + ",");
                        encode = "";
                        if (C18498a.this.csG.bAA()) {
                            C8910b me = C8910b.m16064me(C18498a.this.csG.field_content);
                            if (me != null) {
                                encode = me.appId;
                            }
                        }
                        c32831d.mo53400l("26appip", encode + ",");
                        c32831d.mo53400l("27toUsersCount", C37921n.m64060mA(clk.vEC.wVI) + ",");
                        c32831d.mo53400l("28codeType", Integer.valueOf(c18346nr.cJX.cvn));
                        C4990ab.m7416i("MicroMsg.OnNetSceneUploadMsgImgEnd", "report qrCodeImgChatting(13628): " + c32831d.mo53398Fk());
                        C18698o.m29233y(13628, c32831d.toString());
                    }
                    C18498a.m28799a(C18498a.this);
                    AppMethodBeat.m2505o(16176);
                } else {
                    AppMethodBeat.m2505o(16176);
                }
                return false;
            }
        }

        C18498a(long j, C7620bi c7620bi, C7472b c7472b, boolean z, int i) {
            AppMethodBeat.m2504i(16180);
            this.eFm = j;
            this.csG = c7620bi;
            this.ehh = c7472b;
            this.eFn = i;
            this.eFu = z;
            AppMethodBeat.m2505o(16180);
        }

        /* renamed from: a */
        static /* synthetic */ void m28799a(C18498a c18498a) {
            AppMethodBeat.m2504i(16181);
            C4879a.xxA.mo10053d(c18498a.eFv);
            C4879a.xxA.mo10053d(c18498a.eFw);
            AppMethodBeat.m2505o(16181);
        }
    }

    /* renamed from: a */
    public final void mo43816a(long j, C7620bi c7620bi, C7472b c7472b, int i, boolean z, C9545d c9545d) {
        AppMethodBeat.m2504i(16182);
        C18498a c18498a = new C18498a(j, c7620bi, c7472b, z, i);
        C5141c ll = C18624c.abi().mo17131ll("100131");
        if (ll.isValid()) {
            c18498a.eFs = C42252ah.getInt((String) ll.dru().get("needUploadData"), 1);
        }
        if (c18498a.eFq || (!c18498a.eFu && c18498a.eFs == 0)) {
            AppMethodBeat.m2505o(16182);
            return;
        }
        int i2;
        c18498a.eFt = c9545d;
        c18498a.eFq = true;
        String str = ((clk) c18498a.ehh.fsG.fsP).vEC.wVI;
        Object obj = (C5046bo.isNullOrNil(str) || !C1855t.m3896kH(str)) ? null : 1;
        StringBuilder stringBuilder = new StringBuilder("2,");
        if (obj != null) {
            i2 = 2;
        } else {
            i2 = 1;
        }
        c18498a.eFp = stringBuilder.append(i2).append(",,").toString();
        if (c18498a.eFo == null) {
            c18498a.eFo = C32291o.ahl().mo73105b(Long.valueOf(c18498a.eFm));
        }
        C25822e c25822e = c18498a.eFo;
        if (c25822e != null) {
            C45347np c45347np = new C45347np();
            C4879a.xxA.mo10052c(c18498a.eFv);
            C4879a.xxA.mo10052c(c18498a.eFw);
            c18498a.eFr = C32291o.ahl().mo73118q(c25822e.fDz, "", "");
            c45347np.cJU.filePath = c18498a.eFr;
            C4879a.xxA.mo10055m(c45347np);
        }
        AppMethodBeat.m2505o(16182);
    }
}
