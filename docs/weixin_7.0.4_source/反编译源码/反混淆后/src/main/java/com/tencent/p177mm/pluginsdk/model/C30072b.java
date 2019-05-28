package com.tencent.p177mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1829bf.C1828b;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p1374bi.C41789d;
import com.tencent.p177mm.p183ai.C1201e;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C1201e.C1198b;
import com.tencent.p177mm.p183ai.C1201e.C1199c;
import com.tencent.p177mm.p230g.p231a.C6497je;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7570bf;

/* renamed from: com.tencent.mm.pluginsdk.model.b */
public final class C30072b implements C1201e {
    /* renamed from: b */
    public final C1198b mo4453b(C1197a c1197a) {
        AppMethodBeat.m2504i(27234);
        C7254cm c7254cm = c1197a.eAB;
        if (c7254cm == null || c7254cm.nao != 47) {
            C4990ab.m7414f("MicroMsg.EmojiExtension", "parseEmojiMsg failed, invalid cmdAM");
            AppMethodBeat.m2505o(27234);
        } else {
            String a = C1946aa.m4148a(c7254cm.vEB);
            String a2 = C1946aa.m4148a(c7254cm.vEC);
            C9638aw.m17190ZK();
            if (!((String) C18628c.m29072Ry().get(2, null)).equals(a)) {
                a2 = a;
            }
            ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35623a(a2, C1946aa.m4148a(c7254cm.vED), c7254cm.ptF, c7254cm.vEG, c1197a);
            C1828b oE = C1829bf.m3758oE(c7254cm.vEG);
            if (oE != null) {
                C4990ab.m7417i("MicroMsg.EmojiExtension", "bizClientMsgId = %s", oE.fmt);
                if (oE.fmx != null && oE.scene == 1) {
                    a2 = C1946aa.m4148a(c7254cm.vEB);
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(73729, Integer.valueOf(1));
                    C7570bf c7570bf = new C7570bf();
                    c7570bf.field_content = C4996ah.getContext().getString(C25738R.string.d5d);
                    c7570bf.field_createtime = C5046bo.anT();
                    c7570bf.field_imgpath = "";
                    c7570bf.field_sayhicontent = c7570bf.field_content;
                    c7570bf.field_sayhiuser = a2;
                    c7570bf.field_scene = 18;
                    c7570bf.field_status = c7254cm.jBT > 3 ? c7254cm.jBT : 3;
                    c7570bf.field_svrid = c7254cm.ptF;
                    c7570bf.field_talker = a2;
                    c7570bf.field_type = c7254cm.nao;
                    c7570bf.field_isSend = 0;
                    c7570bf.field_sayhiencryptuser = a2;
                    c7570bf.field_ticket = oE.fmx;
                    C41789d.akQ().mo56738a(c7570bf);
                    C6497je c6497je = new C6497je();
                    c6497je.cEq.cEr = a2;
                    C4879a.xxA.mo10055m(c6497je);
                }
            }
            AppMethodBeat.m2505o(27234);
        }
        return null;
    }

    /* renamed from: a */
    public final void mo4452a(C1199c c1199c) {
    }
}
