package com.tencent.mm.plugin.wallet_core.model.mall;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.HashMap;
import java.util.Map;

public final class d {
    private static d tDF = null;
    private Map<String, MallNews> tDE = new HashMap();

    public static d cQX() {
        AppMethodBeat.i(47035);
        if (tDF == null) {
            tDF = new d();
        }
        d dVar = tDF;
        AppMethodBeat.o(47035);
        return dVar;
    }

    private d() {
        AppMethodBeat.i(47036);
        Kh();
        AppMethodBeat.o(47036);
    }

    public final void Kh() {
        AppMethodBeat.i(47037);
        this.tDE.clear();
        g.RQ();
        String str = (String) g.RP().Ry().get(270341, (Object) "");
        ab.d("MicroMsg.MallNewsManagerNewVersion", "data : ".concat(String.valueOf(str)));
        for (String str2 : bo.P(str2.split(";"))) {
            MallNews acJ = acJ(str2);
            if (acJ != null) {
                this.tDE.put(acJ.fsT, acJ);
            }
        }
        AppMethodBeat.o(47037);
    }

    public final void b(MallNews mallNews) {
        AppMethodBeat.i(47038);
        if (mallNews == null) {
            ab.w("MicroMsg.MallNewsManagerNewVersion", "null obj");
            AppMethodBeat.o(47038);
            return;
        }
        mallNews.tDB = "<sysmsg><mallactivitynew><functionid>" + mallNews.fsT + "</functionid><activityid>" + mallNews.ssr + "</activityid><type>" + mallNews.type + "</type><showflag>" + mallNews.tDt + "</showflag><newsTipFlag>" + mallNews.tDu + "</newsTipFlag></mallactivitynew></sysmsg>;";
        this.tDE.put(mallNews.fsT, mallNews);
        bZX();
        AppMethodBeat.o(47038);
    }

    private boolean bZX() {
        AppMethodBeat.i(47039);
        ab.d("MicroMsg.MallNewsManagerNewVersion", "notifyNewsMap.size : " + this.tDE.size());
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : this.tDE.keySet()) {
            if (!bo.isNullOrNil(str)) {
                MallNews mallNews = (MallNews) this.tDE.get(str);
                stringBuffer.append(mallNews.tDB.replace("</mallactivitynew></sysmsg>;", "").replaceAll("<activityid>([^<]*)</activityid>", "").replaceAll("<type>([^<]*)</type>", "").replaceAll("<showflag>([^<]*)</showflag>", "").replaceAll("<newsTipFlag>([^<]*)</newsTipFlag>", "") + "<activityid>" + mallNews.ssr + "</activityid><type>" + mallNews.type + "</type><showflag>" + mallNews.tDt + "</showflag><newsTipFlag>" + mallNews.tDu + "</newsTipFlag></mallactivitynew></sysmsg>;");
            }
        }
        ab.d("MicroMsg.MallNewsManagerNewVersion", "save data  : " + stringBuffer.toString());
        g.RQ();
        g.RP().Ry().set(270341, stringBuffer.toString());
        AppMethodBeat.o(47039);
        return true;
    }

    public final MallNews acK(String str) {
        AppMethodBeat.i(47040);
        MallNews mallNews = (MallNews) this.tDE.get(str);
        AppMethodBeat.o(47040);
        return mallNews;
    }

    public final MallNews acI(String str) {
        AppMethodBeat.i(47041);
        ab.d("MicroMsg.MallNewsManagerNewVersion", "removeNewsInIndexUI : ".concat(String.valueOf(str)));
        if (bo.isNullOrNil(str) || !this.tDE.containsKey(str)) {
            AppMethodBeat.o(47041);
            return null;
        }
        MallNews mallNews = (MallNews) this.tDE.get(str);
        if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(mallNews.tDt)) {
            mallNews.tDt = "1";
            bZX();
        }
        AppMethodBeat.o(47041);
        return mallNews;
    }

    private static MallNews acJ(String str) {
        AppMethodBeat.i(47042);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(47042);
            return null;
        }
        Map z = br.z(str, "sysmsg");
        if (z == null) {
            AppMethodBeat.o(47042);
            return null;
        }
        try {
            MallNews mallNews = new MallNews((String) z.get(".sysmsg.mallactivitynew.functionid"));
            mallNews.ssr = (String) z.get(".sysmsg.mallactivitynew.activityid");
            mallNews.type = (String) z.get(".sysmsg.mallactivitynew.type");
            mallNews.showType = bo.getInt((String) z.get(".sysmsg.mallactivitynew.showtype"), 0);
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
            if (bo.isNullOrNil(mallNews.fsT)) {
                AppMethodBeat.o(47042);
                return null;
            }
            AppMethodBeat.o(47042);
            return mallNews;
        } catch (Exception e) {
            ab.e("MicroMsg.MallNewsManagerNewVersion", "cmdid error");
            AppMethodBeat.o(47042);
            return null;
        }
    }
}
