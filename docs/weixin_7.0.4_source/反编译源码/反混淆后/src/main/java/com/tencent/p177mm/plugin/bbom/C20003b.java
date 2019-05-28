package com.tencent.p177mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1829bf.C1828b;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C26415ao.C9635b.C9636a;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelcontrol.C37938c;
import com.tencent.p177mm.p1374bi.C41789d;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p190at.C25820b;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p230g.p231a.C6497je;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C3467a;
import com.tencent.p177mm.plugin.priority.p1407a.p1408a.C43370a;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7570bf;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

/* renamed from: com.tencent.mm.plugin.bbom.b */
public final class C20003b implements C3467a {
    /* renamed from: a */
    public final void mo7926a(C1197a c1197a, C7620bi c7620bi, final String str, String str2, boolean z) {
        AppMethodBeat.m2504i(18232);
        final C7254cm c7254cm = c1197a.eAB;
        final C1828b oE = C1829bf.m3758oE(c7254cm.vEG);
        if (oE != null) {
            c7620bi.mo14792jA(oE.fmu);
            c7620bi.mo14798jy(oE.fmt);
            C4990ab.m7417i("MicroMsg.BaseMsgCallbackImpl", "bizClientMsgId = %s", oE.fmt);
            if (!(oE.fmx == null || oE.scene != 1 || c7254cm.nao == Downloads.MIN_WAIT_FOR_NETWORK)) {
                C9638aw.m17190ZK();
                C7616ad aoO = C18628c.m29078XM().aoO(str);
                if (aoO == null || ((int) aoO.ewQ) <= 0) {
                    C26417a.flu.mo20966a(str, null, new C9636a() {
                        /* renamed from: o */
                        public final void mo6218o(String str, boolean z) {
                            AppMethodBeat.m2504i(18231);
                            C9638aw.m17190ZK();
                            C20003b.m30923a(c7254cm, oE, C18628c.m29078XM().aoO(str));
                            AppMethodBeat.m2505o(18231);
                        }
                    });
                    AppMethodBeat.m2505o(18232);
                    return;
                }
                C20003b.m30923a(c7254cm, oE, aoO);
            }
        }
        AppMethodBeat.m2505o(18232);
    }

    /* renamed from: b */
    public final void mo7927b(C1197a c1197a, C7620bi c7620bi, String str, String str2, boolean z) {
        AppMethodBeat.m2504i(18233);
        if (C43370a.bZu()) {
            int i = (C1855t.m3912mY(str) && C1855t.m3928nN(str)) ? 1 : 0;
            int i2;
            if (!C1855t.m3896kH(str) || C1855t.m3927nM(str)) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            if (!z && c7620bi.drE() && i == 0 && i2 == 0) {
                C37938c.afC();
                if (C37938c.m64122u(c7620bi)) {
                    C25820b ahn = C32291o.ahn();
                    long j = c7620bi.field_msgId;
                    C37938c.afC();
                    if (C37938c.afD()) {
                        synchronized (ahn.fCV) {
                            try {
                                if (ahn.fCV.size() >= 100) {
                                    ahn.fCV.remove(0);
                                }
                                ahn.fCV.push(Long.valueOf(j));
                            } catch (Throwable th) {
                                while (true) {
                                    AppMethodBeat.m2505o(18233);
                                }
                            }
                        }
                        ahn.fCZ = System.currentTimeMillis();
                        C4990ab.m7417i("MicroMsg.AutoGetBigImgLogic", "add %d", Long.valueOf(j));
                        ahn.start();
                    }
                }
            }
        }
        AppMethodBeat.m2505o(18233);
    }

    /* renamed from: a */
    static void m30923a(C7254cm c7254cm, C1828b c1828b, C7616ad c7616ad) {
        int i;
        AppMethodBeat.m2504i(18234);
        String a = C1946aa.m4148a(c7254cm.vEB);
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(73729, Integer.valueOf(1));
        String str = c7616ad.field_nickname;
        C7570bf c7570bf = new C7570bf();
        c7570bf.field_content = C1946aa.m4148a(c7254cm.vED);
        c7570bf.field_createtime = C5046bo.anT();
        c7570bf.field_imgpath = "";
        c7570bf.field_sayhicontent = c7254cm.nao == 3 ? C4996ah.getContext().getString(C25738R.string.d5e) : C1946aa.m4148a(c7254cm.vED);
        c7570bf.field_sayhiuser = a;
        c7570bf.field_scene = 18;
        if (c7254cm.jBT > 3) {
            i = c7254cm.jBT;
        } else {
            i = 3;
        }
        c7570bf.field_status = i;
        c7570bf.field_svrid = c7254cm.ptF;
        c7570bf.field_talker = str;
        c7570bf.field_type = c7254cm.nao;
        c7570bf.field_isSend = 0;
        c7570bf.field_sayhiencryptuser = a;
        c7570bf.field_ticket = c1828b.fmx;
        C41789d.akQ().mo56738a(c7570bf);
        C6497je c6497je = new C6497je();
        c6497je.cEq.cEr = a;
        C4879a.xxA.mo10055m(c6497je);
        AppMethodBeat.m2505o(18234);
    }
}
