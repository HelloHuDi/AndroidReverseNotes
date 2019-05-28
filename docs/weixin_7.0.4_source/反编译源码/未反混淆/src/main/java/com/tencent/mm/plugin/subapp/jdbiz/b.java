package com.tencent.mm.plugin.subapp.jdbiz;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.f.f.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.Map;

public final class b implements a {
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

    public static b cDj() {
        AppMethodBeat.i(25192);
        aw.ZK();
        String str = (String) c.Ry().get(327942, (Object) "");
        b bVar = new b();
        ab.i("MicroMsg.JdMsgContent", " create xml : ".concat(String.valueOf(str)));
        bVar.YH(str);
        AppMethodBeat.o(25192);
        return bVar;
    }

    public final void YH(String str) {
        AppMethodBeat.i(25193);
        init();
        this.cJh = str;
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(25193);
            return;
        }
        ab.i("MicroMsg.JdMsgContent", "feed xml %s", str);
        af(br.z(str, "sysmsg"));
        AppMethodBeat.o(25193);
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

    private void af(Map<String, String> map) {
        AppMethodBeat.i(25194);
        if (map == null) {
            AppMethodBeat.o(25194);
            return;
        }
        this.ssq = bo.bc((String) map.get(".sysmsg.biztype"), "");
        this.ssA = bo.bc((String) map.get(".sysmsg.alert"), "");
        this.ssr = bo.bc((String) map.get(".sysmsg.activityid"), "");
        this.startTime = bo.anl((String) map.get(".sysmsg.starttime"));
        this.fRS = bo.anl((String) map.get(".sysmsg.expiretime"));
        this.title = bo.bc((String) map.get(".sysmsg.content.title"), "");
        this.iconUrl = bo.bc((String) map.get(".sysmsg.content.icon"), "");
        this.jumpUrl = bo.bc((String) map.get(".sysmsg.content.jumpurl"), "");
        this.ssw = bo.anl((String) map.get(".sysmsg.content.urlstarttime"));
        this.ssx = bo.anl((String) map.get(".sysmsg.content.urlexpiretime"));
        this.ssu = bo.bc((String) map.get(".sysmsg.content.jdcelltitle"), "");
        this.ssv = bo.bc((String) map.get(".sysmsg.content.jdcellicon"), "");
        this.ssy = bo.anl((String) map.get(".sysmsg.content.titlestarttime"));
        this.ssz = bo.anl((String) map.get(".sysmsg.content.titleexpiretime"));
        this.sss = "1".equals(map.get(".sysmsg.content.findshowreddot"));
        this.sst = "1".equals(map.get(".sysmsg.content.jdcellshowred"));
        this.ssB = bo.bc((String) map.get(".sysmsg.content.alertviewtitle"), "");
        this.ssC = bo.bc((String) map.get(".sysmsg.content.alertviewconfirm"), "");
        this.ssD = bo.bc((String) map.get(".sysmsg.content.alertviewcancel"), "");
        AppMethodBeat.o(25194);
    }

    public final boolean isStart() {
        AppMethodBeat.i(25195);
        if (this.startTime < System.currentTimeMillis() / 1000) {
            AppMethodBeat.o(25195);
            return true;
        }
        AppMethodBeat.o(25195);
        return false;
    }

    public final boolean bxX() {
        AppMethodBeat.i(25196);
        if (this.fRS == 0 || this.fRS >= System.currentTimeMillis() / 1000) {
            AppMethodBeat.o(25196);
            return false;
        }
        AppMethodBeat.o(25196);
        return true;
    }

    public final boolean cDk() {
        AppMethodBeat.i(25197);
        if (this.ssy < System.currentTimeMillis() / 1000) {
            AppMethodBeat.o(25197);
            return true;
        }
        AppMethodBeat.o(25197);
        return false;
    }

    public final boolean cDl() {
        AppMethodBeat.i(25198);
        if (this.ssz == 0 || this.ssz >= System.currentTimeMillis() / 1000) {
            AppMethodBeat.o(25198);
            return false;
        }
        AppMethodBeat.o(25198);
        return true;
    }

    public final boolean a(b bVar) {
        AppMethodBeat.i(25199);
        if (bVar == null) {
            AppMethodBeat.o(25199);
            return true;
        } else if (bo.bc(this.ssr, "").equals(bo.bc(bVar.ssr, ""))) {
            AppMethodBeat.o(25199);
            return false;
        } else {
            AppMethodBeat.o(25199);
            return true;
        }
    }

    public final String SY() {
        AppMethodBeat.i(25200);
        String bc = bo.bc(this.cJh, "");
        AppMethodBeat.o(25200);
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
