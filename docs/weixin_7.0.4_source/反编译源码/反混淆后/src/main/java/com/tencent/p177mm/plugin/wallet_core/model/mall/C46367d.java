package com.tencent.p177mm.plugin.wallet_core.model.mall;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.wallet_core.model.mall.d */
public final class C46367d {
    private static C46367d tDF = null;
    private Map<String, MallNews> tDE = new HashMap();

    public static C46367d cQX() {
        AppMethodBeat.m2504i(47035);
        if (tDF == null) {
            tDF = new C46367d();
        }
        C46367d c46367d = tDF;
        AppMethodBeat.m2505o(47035);
        return c46367d;
    }

    private C46367d() {
        AppMethodBeat.m2504i(47036);
        mo74577Kh();
        AppMethodBeat.m2505o(47036);
    }

    /* renamed from: Kh */
    public final void mo74577Kh() {
        AppMethodBeat.m2504i(47037);
        this.tDE.clear();
        C1720g.m3537RQ();
        String str = (String) C1720g.m3536RP().mo5239Ry().get(270341, (Object) "");
        C4990ab.m7410d("MicroMsg.MallNewsManagerNewVersion", "data : ".concat(String.valueOf(str)));
        for (String str2 : C5046bo.m7508P(str2.split(";"))) {
            MallNews acJ = C46367d.acJ(str2);
            if (acJ != null) {
                this.tDE.put(acJ.fsT, acJ);
            }
        }
        AppMethodBeat.m2505o(47037);
    }

    /* renamed from: b */
    public final void mo74580b(MallNews mallNews) {
        AppMethodBeat.m2504i(47038);
        if (mallNews == null) {
            C4990ab.m7420w("MicroMsg.MallNewsManagerNewVersion", "null obj");
            AppMethodBeat.m2505o(47038);
            return;
        }
        mallNews.tDB = "<sysmsg><mallactivitynew><functionid>" + mallNews.fsT + "</functionid><activityid>" + mallNews.ssr + "</activityid><type>" + mallNews.type + "</type><showflag>" + mallNews.tDt + "</showflag><newsTipFlag>" + mallNews.tDu + "</newsTipFlag></mallactivitynew></sysmsg>;";
        this.tDE.put(mallNews.fsT, mallNews);
        bZX();
        AppMethodBeat.m2505o(47038);
    }

    private boolean bZX() {
        AppMethodBeat.m2504i(47039);
        C4990ab.m7410d("MicroMsg.MallNewsManagerNewVersion", "notifyNewsMap.size : " + this.tDE.size());
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : this.tDE.keySet()) {
            if (!C5046bo.isNullOrNil(str)) {
                MallNews mallNews = (MallNews) this.tDE.get(str);
                stringBuffer.append(mallNews.tDB.replace("</mallactivitynew></sysmsg>;", "").replaceAll("<activityid>([^<]*)</activityid>", "").replaceAll("<type>([^<]*)</type>", "").replaceAll("<showflag>([^<]*)</showflag>", "").replaceAll("<newsTipFlag>([^<]*)</newsTipFlag>", "") + "<activityid>" + mallNews.ssr + "</activityid><type>" + mallNews.type + "</type><showflag>" + mallNews.tDt + "</showflag><newsTipFlag>" + mallNews.tDu + "</newsTipFlag></mallactivitynew></sysmsg>;");
            }
        }
        C4990ab.m7410d("MicroMsg.MallNewsManagerNewVersion", "save data  : " + stringBuffer.toString());
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(270341, stringBuffer.toString());
        AppMethodBeat.m2505o(47039);
        return true;
    }

    public final MallNews acK(String str) {
        AppMethodBeat.m2504i(47040);
        MallNews mallNews = (MallNews) this.tDE.get(str);
        AppMethodBeat.m2505o(47040);
        return mallNews;
    }

    public final MallNews acI(String str) {
        AppMethodBeat.m2504i(47041);
        C4990ab.m7410d("MicroMsg.MallNewsManagerNewVersion", "removeNewsInIndexUI : ".concat(String.valueOf(str)));
        if (C5046bo.isNullOrNil(str) || !this.tDE.containsKey(str)) {
            AppMethodBeat.m2505o(47041);
            return null;
        }
        MallNews mallNews = (MallNews) this.tDE.get(str);
        if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(mallNews.tDt)) {
            mallNews.tDt = "1";
            bZX();
        }
        AppMethodBeat.m2505o(47041);
        return mallNews;
    }

    private static MallNews acJ(String str) {
        AppMethodBeat.m2504i(47042);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(47042);
            return null;
        }
        Map z = C5049br.m7595z(str, "sysmsg");
        if (z == null) {
            AppMethodBeat.m2505o(47042);
            return null;
        }
        try {
            MallNews mallNews = new MallNews((String) z.get(".sysmsg.mallactivitynew.functionid"));
            mallNews.ssr = (String) z.get(".sysmsg.mallactivitynew.activityid");
            mallNews.type = (String) z.get(".sysmsg.mallactivitynew.type");
            mallNews.showType = C5046bo.getInt((String) z.get(".sysmsg.mallactivitynew.showtype"), 0);
            if (z.containsKey(".sysmsg.mallactivitynew.showflag")) {
                mallNews.tDt = (String) z.get(".sysmsg.mallactivitynew.showflag");
            } else {
                mallNews.tDt = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            if (z.containsKey(".sysmsg.mallactivitynew.newsTipFlag")) {
                mallNews.tDu = (String) z.get(".sysmsg.mallactivitynew.newsTipFlag");
            } else {
                mallNews.tDu = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            mallNews.tDB = str;
            if (C5046bo.isNullOrNil(mallNews.fsT)) {
                AppMethodBeat.m2505o(47042);
                return null;
            }
            AppMethodBeat.m2505o(47042);
            return mallNews;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.MallNewsManagerNewVersion", "cmdid error");
            AppMethodBeat.m2505o(47042);
            return null;
        }
    }
}
