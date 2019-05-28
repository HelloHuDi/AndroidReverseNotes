package com.tencent.mm.plugin.webview.ui.tools.game;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class c {
    long mStartTime = 0;
    long neL = 0;
    long neM = 0;
    private long uDn = 0;
    Bundle uDo;
    public a uDp = new a();

    public class a {
        public final void dbY() {
            c.this.uDo = null;
            c.this.mStartTime = 0;
            c.this.neL = 0;
            c.this.mStartTime = 0;
            c.this.neM = 0;
        }

        public final void dbZ() {
            AppMethodBeat.i(8681);
            c.this.mStartTime = System.currentTimeMillis();
            c.this.neM = System.currentTimeMillis();
            AppMethodBeat.o(8681);
        }

        public final void ao(Bundle bundle) {
            AppMethodBeat.i(8682);
            c.this.uDo = bundle;
            ab.i("MicroMsg.GamePageTimeReport", "setGamePageReportData");
            if (bundle != null && bundle.getBoolean("game_page_report_time_begin")) {
                c.this.neL = 0;
                c.this.mStartTime = System.currentTimeMillis();
                c.this.neM = System.currentTimeMillis();
            }
            AppMethodBeat.o(8682);
        }

        public final void onResume() {
            AppMethodBeat.i(8683);
            if (c.this.neM != 0) {
                c.this.neM = System.currentTimeMillis();
            }
            AppMethodBeat.o(8683);
        }

        public final void onPause() {
            AppMethodBeat.i(8684);
            if (c.this.neM != 0) {
                c.this.neL += System.currentTimeMillis() - c.this.neM;
            }
            AppMethodBeat.o(8684);
        }
    }

    public c() {
        AppMethodBeat.i(8685);
        AppMethodBeat.o(8685);
    }

    public static void an(Bundle bundle) {
        AppMethodBeat.i(8686);
        if (bundle == null) {
            AppMethodBeat.o(8686);
            return;
        }
        Set<String> keySet = bundle.keySet();
        if (keySet == null) {
            AppMethodBeat.o(8686);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : keySet) {
                jSONObject.put(str, bundle.get(str));
            }
            gu guVar = new gu();
            guVar.cBw.Cn = 4;
            guVar.cBw.cBy = jSONObject.toString();
            com.tencent.mm.sdk.b.a.xxA.m(guVar);
            AppMethodBeat.o(8686);
        } catch (JSONException e) {
            AppMethodBeat.o(8686);
        }
    }

    /* Access modifiers changed, original: protected */
    public void I(Bundle bundle) {
    }

    private String age(String str) {
        AppMethodBeat.i(8687);
        Matcher matcher = Pattern.compile("\\(.*?\\)").matcher(str);
        while (matcher.find()) {
            try {
                String nullAsNil = bo.nullAsNil(matcher.group());
                String replace = nullAsNil.replace("(", "").replace(")", "").replace(" ", "");
                CharSequence replace2;
                String[] split;
                if (replace.contains("__ALLSTAYTIME__")) {
                    replace2 = replace.replace("__ALLSTAYTIME__", String.valueOf(this.uDn / 1000));
                    split = replace2.split("\\+");
                    if (split.length == 2) {
                        replace2 = String.valueOf(bo.anl(split[0]) + bo.anl(split[1]));
                    }
                    str = str.replace(nullAsNil, replace2);
                } else if (nullAsNil.contains("__FOREGROUNDTIME__")) {
                    replace2 = replace.replace("__FOREGROUNDTIME__", String.valueOf(this.neL / 1000));
                    split = replace2.split("\\+");
                    if (split.length == 2) {
                        replace2 = String.valueOf(bo.anl(split[0]) + bo.anl(split[1]));
                    }
                    str = str.replace(nullAsNil, replace2);
                }
            } catch (NumberFormatException e) {
                ab.i("MicroMsg.GamePageTimeReport", "matchTimeMark, err:%s", e.getMessage());
                AppMethodBeat.o(8687);
                return null;
            }
        }
        AppMethodBeat.o(8687);
        return str;
    }

    public static /* synthetic */ void a(c cVar) {
        AppMethodBeat.i(8688);
        if (cVar.mStartTime != 0) {
            cVar.uDn = System.currentTimeMillis() - cVar.mStartTime;
            ab.i("MicroMsg.GamePageTimeReport", "visit page(%s), stayTime:%sms, foregroundTime:%sms", Integer.valueOf(cVar.hashCode()), Long.valueOf(cVar.uDn), Long.valueOf(cVar.neL));
            if (cVar.uDo == null) {
                ab.i("MicroMsg.GamePageTimeReport", "report game page time fail. ReportData is null");
                AppMethodBeat.o(8688);
                return;
            }
            String string = cVar.uDo.getString("game_page_report_format_data");
            String string2 = cVar.uDo.getString("game_page_report_tabs_format_data");
            if (!bo.isNullOrNil(string)) {
                cVar.uDo.putString("game_page_report_format_data", string.replace("__ALLSTAYTIME__", String.valueOf(cVar.uDn / 1000)).replace("__FOREGROUNDTIME__", String.valueOf(cVar.neL / 1000)));
                ab.i("MicroMsg.GamePageTimeReport", "visit page(%s), after replace time, reportFormatData:%s", Integer.valueOf(cVar.hashCode()), string);
            } else if (bo.isNullOrNil(string2)) {
                AppMethodBeat.o(8688);
                return;
            } else {
                string = cVar.age(string2);
                if (!bo.isNullOrNil(string)) {
                    cVar.uDo.putString("game_page_report_tabs_format_data", string);
                    ab.i("MicroMsg.GamePageTimeReport", "visit page(%s), after replace time, reportTabsFormatdata:%s", Integer.valueOf(cVar.hashCode()), string);
                }
            }
            if (ah.bqo()) {
                an(cVar.uDo);
            } else {
                cVar.I(cVar.uDo);
            }
            cVar.uDo = null;
        }
        AppMethodBeat.o(8688);
    }
}
