package com.tencent.p177mm.plugin.subapp.jdbiz;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.pluginsdk.p1079f.C44044f.C14833a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.subapp.jdbiz.b */
public final class C22336b implements C14833a {
    public String cJh = "";
    public long fRS = 0;
    public String iconUrl = "";
    public String jumpUrl = "";
    public String ssA = "";
    public String ssB = "";
    public String ssC = "";
    public String ssD = "";
    public String ssq = "";
    public String ssr = "";
    public boolean sss = false;
    public boolean sst = false;
    public String ssu = "";
    public String ssv = "";
    public long ssw;
    public long ssx;
    public long ssy;
    public long ssz;
    public long startTime;
    public String title = "";

    public static C22336b cDj() {
        AppMethodBeat.m2504i(25192);
        C9638aw.m17190ZK();
        String str = (String) C18628c.m29072Ry().get(327942, (Object) "");
        C22336b c22336b = new C22336b();
        C4990ab.m7416i("MicroMsg.JdMsgContent", " create xml : ".concat(String.valueOf(str)));
        c22336b.mo37878YH(str);
        AppMethodBeat.m2505o(25192);
        return c22336b;
    }

    /* renamed from: YH */
    public final void mo37878YH(String str) {
        AppMethodBeat.m2504i(25193);
        init();
        this.cJh = str;
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(25193);
            return;
        }
        C4990ab.m7417i("MicroMsg.JdMsgContent", "feed xml %s", str);
        m34035af(C5049br.m7595z(str, "sysmsg"));
        AppMethodBeat.m2505o(25193);
    }

    private void init() {
        this.ssq = "";
        this.ssr = "";
        this.fRS = 0;
        this.ssu = "";
        this.sss = false;
        this.sst = false;
        this.ssB = "";
        this.ssC = "";
        this.ssD = "";
        this.ssA = "";
        this.jumpUrl = "";
        this.cJh = "";
    }

    /* renamed from: af */
    private void m34035af(Map<String, String> map) {
        AppMethodBeat.m2504i(25194);
        if (map == null) {
            AppMethodBeat.m2505o(25194);
            return;
        }
        this.ssq = C5046bo.m7532bc((String) map.get(".sysmsg.biztype"), "");
        this.ssA = C5046bo.m7532bc((String) map.get(".sysmsg.alert"), "");
        this.ssr = C5046bo.m7532bc((String) map.get(".sysmsg.activityid"), "");
        this.startTime = C5046bo.anl((String) map.get(".sysmsg.starttime"));
        this.fRS = C5046bo.anl((String) map.get(".sysmsg.expiretime"));
        this.title = C5046bo.m7532bc((String) map.get(".sysmsg.content.title"), "");
        this.iconUrl = C5046bo.m7532bc((String) map.get(".sysmsg.content.icon"), "");
        this.jumpUrl = C5046bo.m7532bc((String) map.get(".sysmsg.content.jumpurl"), "");
        this.ssw = C5046bo.anl((String) map.get(".sysmsg.content.urlstarttime"));
        this.ssx = C5046bo.anl((String) map.get(".sysmsg.content.urlexpiretime"));
        this.ssu = C5046bo.m7532bc((String) map.get(".sysmsg.content.jdcelltitle"), "");
        this.ssv = C5046bo.m7532bc((String) map.get(".sysmsg.content.jdcellicon"), "");
        this.ssy = C5046bo.anl((String) map.get(".sysmsg.content.titlestarttime"));
        this.ssz = C5046bo.anl((String) map.get(".sysmsg.content.titleexpiretime"));
        this.sss = "1".equals(map.get(".sysmsg.content.findshowreddot"));
        this.sst = "1".equals(map.get(".sysmsg.content.jdcellshowred"));
        this.ssB = C5046bo.m7532bc((String) map.get(".sysmsg.content.alertviewtitle"), "");
        this.ssC = C5046bo.m7532bc((String) map.get(".sysmsg.content.alertviewconfirm"), "");
        this.ssD = C5046bo.m7532bc((String) map.get(".sysmsg.content.alertviewcancel"), "");
        AppMethodBeat.m2505o(25194);
    }

    public final boolean isStart() {
        AppMethodBeat.m2504i(25195);
        if (this.startTime < System.currentTimeMillis() / 1000) {
            AppMethodBeat.m2505o(25195);
            return true;
        }
        AppMethodBeat.m2505o(25195);
        return false;
    }

    public final boolean bxX() {
        AppMethodBeat.m2504i(25196);
        if (this.fRS == 0 || this.fRS >= System.currentTimeMillis() / 1000) {
            AppMethodBeat.m2505o(25196);
            return false;
        }
        AppMethodBeat.m2505o(25196);
        return true;
    }

    public final boolean cDk() {
        AppMethodBeat.m2504i(25197);
        if (this.ssy < System.currentTimeMillis() / 1000) {
            AppMethodBeat.m2505o(25197);
            return true;
        }
        AppMethodBeat.m2505o(25197);
        return false;
    }

    public final boolean cDl() {
        AppMethodBeat.m2504i(25198);
        if (this.ssz == 0 || this.ssz >= System.currentTimeMillis() / 1000) {
            AppMethodBeat.m2505o(25198);
            return false;
        }
        AppMethodBeat.m2505o(25198);
        return true;
    }

    /* renamed from: a */
    public final boolean mo37879a(C22336b c22336b) {
        AppMethodBeat.m2504i(25199);
        if (c22336b == null) {
            AppMethodBeat.m2505o(25199);
            return true;
        } else if (C5046bo.m7532bc(this.ssr, "").equals(C5046bo.m7532bc(c22336b.ssr, ""))) {
            AppMethodBeat.m2505o(25199);
            return false;
        } else {
            AppMethodBeat.m2505o(25199);
            return true;
        }
    }

    /* renamed from: SY */
    public final String mo37877SY() {
        AppMethodBeat.m2504i(25200);
        String bc = C5046bo.m7532bc(this.cJh, "");
        AppMethodBeat.m2505o(25200);
        return bc;
    }

    public final String cDm() {
        return this.ssr;
    }

    public final String cDn() {
        return this.ssu;
    }

    public final boolean cDo() {
        return this.sst;
    }

    public final String cDp() {
        return this.ssq;
    }

    public final String cDq() {
        return this.jumpUrl;
    }
}
