package com.tencent.p177mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C6300p;
import com.tencent.p177mm.p230g.p231a.C37807uo;
import com.tencent.p177mm.plugin.wallet_core.p1313d.C43791d;
import com.tencent.p177mm.plugin.wallet_core.p749c.C43786d;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.Date;

/* renamed from: com.tencent.mm.plugin.wallet_core.model.x */
public final class C35483x extends C4884c<C37807uo> implements C1202f {
    private C37807uo tCr;
    private String tCs;

    public C35483x() {
        AppMethodBeat.m2504i(46900);
        this.tCs = null;
        this.xxI = C37807uo.class.getName().hashCode();
        AppMethodBeat.m2505o(46900);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        AppMethodBeat.m2504i(46903);
        this.tCr = (C37807uo) c4883b;
        this.tCs = this.tCr.cQJ.cQL;
        long longValue = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_BULLETIN_GET_TIME_LONG, Long.valueOf(0))).longValue();
        long time = new Date().getTime();
        long longValue2 = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_BULLETIN_UPDATE_INTERVAL_LONG, Long.valueOf(600000))).longValue();
        if (longValue2 <= 0) {
            longValue2 = 600000;
        }
        if (time - longValue > longValue2 || C5046bo.isNullOrNil(this.tCs)) {
            C4990ab.m7416i("MicroMsg.WalletGetBulletinEventListener", "data is out of date,do NetSceneGetBannerInfo for update");
            C1207m c43786d = new C43786d();
            C1720g.m3537RQ();
            C6300p c6300p = C1720g.m3535RO().eJo;
            c6300p.mo14539a(385, (C1202f) this);
            c6300p.mo14541a(c43786d, 0);
        } else if (C5046bo.isNullOrNil(this.tCs)) {
            C4990ab.m7412e("MicroMsg.WalletGetBulletinEventListener", "mScene is null");
            this.tCr.callback.run();
            this.tCr = null;
        } else {
            C4990ab.m7416i("MicroMsg.WalletGetBulletinEventListener", "get bulletin data from db");
            cPR();
        }
        AppMethodBeat.m2505o(46903);
        return true;
    }

    private void cPR() {
        AppMethodBeat.m2504i(46901);
        C43791d cPM = C14241r.cPM();
        C14265u c14265u = new C14265u();
        c14265u.field_bulletin_scene = this.tCs;
        if (cPM.mo10102b((C4925c) c14265u, new String[0])) {
            this.tCr.cQK.cQM = c14265u.field_bulletin_scene;
            this.tCr.cQK.content = c14265u.field_bulletin_content;
            this.tCr.cQK.url = c14265u.field_bulletin_url;
        } else {
            C4990ab.m7416i("MicroMsg.WalletGetBulletinEventListener", "not bulletin data ");
        }
        this.tCr.callback.run();
        this.tCr = null;
        AppMethodBeat.m2505o(46901);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(46902);
        C4990ab.m7416i("MicroMsg.WalletGetBulletinEventListener", "NetSceneGetBannerInfo resp,errType = " + i + ";errCode=" + i2);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(385, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_BULLETIN_GET_TIME_LONG, Long.valueOf(new Date().getTime()));
        cPR();
        AppMethodBeat.m2505o(46902);
    }
}
