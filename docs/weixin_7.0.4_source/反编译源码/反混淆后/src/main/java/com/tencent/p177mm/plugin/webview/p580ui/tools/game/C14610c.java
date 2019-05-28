package com.tencent.p177mm.plugin.webview.p580ui.tools.game;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C9367gu;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.c */
public class C14610c {
    long mStartTime = 0;
    long neL = 0;
    long neM = 0;
    private long uDn = 0;
    Bundle uDo;
    public C14611a uDp = new C14611a();

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.c$a */
    public class C14611a {
        public final void dbY() {
            C14610c.this.uDo = null;
            C14610c.this.mStartTime = 0;
            C14610c.this.neL = 0;
            C14610c.this.mStartTime = 0;
            C14610c.this.neM = 0;
        }

        public final void dbZ() {
            AppMethodBeat.m2504i(8681);
            C14610c.this.mStartTime = System.currentTimeMillis();
            C14610c.this.neM = System.currentTimeMillis();
            AppMethodBeat.m2505o(8681);
        }

        /* renamed from: ao */
        public final void mo26864ao(Bundle bundle) {
            AppMethodBeat.m2504i(8682);
            C14610c.this.uDo = bundle;
            C4990ab.m7416i("MicroMsg.GamePageTimeReport", "setGamePageReportData");
            if (bundle != null && bundle.getBoolean("game_page_report_time_begin")) {
                C14610c.this.neL = 0;
                C14610c.this.mStartTime = System.currentTimeMillis();
                C14610c.this.neM = System.currentTimeMillis();
            }
            AppMethodBeat.m2505o(8682);
        }

        public final void onResume() {
            AppMethodBeat.m2504i(8683);
            if (C14610c.this.neM != 0) {
                C14610c.this.neM = System.currentTimeMillis();
            }
            AppMethodBeat.m2505o(8683);
        }

        public final void onPause() {
            AppMethodBeat.m2504i(8684);
            if (C14610c.this.neM != 0) {
                C14610c.this.neL += System.currentTimeMillis() - C14610c.this.neM;
            }
            AppMethodBeat.m2505o(8684);
        }
    }

    public C14610c() {
        AppMethodBeat.m2504i(8685);
        AppMethodBeat.m2505o(8685);
    }

    /* renamed from: an */
    public static void m22840an(Bundle bundle) {
        AppMethodBeat.m2504i(8686);
        if (bundle == null) {
            AppMethodBeat.m2505o(8686);
            return;
        }
        Set<String> keySet = bundle.keySet();
        if (keySet == null) {
            AppMethodBeat.m2505o(8686);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : keySet) {
                jSONObject.put(str, bundle.get(str));
            }
            C9367gu c9367gu = new C9367gu();
            c9367gu.cBw.f2862Cn = 4;
            c9367gu.cBw.cBy = jSONObject.toString();
            C4879a.xxA.mo10055m(c9367gu);
            AppMethodBeat.m2505o(8686);
        } catch (JSONException e) {
            AppMethodBeat.m2505o(8686);
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: I */
    public void mo9702I(Bundle bundle) {
    }

    private String age(String str) {
        AppMethodBeat.m2504i(8687);
        Matcher matcher = Pattern.compile("\\(.*?\\)").matcher(str);
        while (matcher.find()) {
            try {
                String nullAsNil = C5046bo.nullAsNil(matcher.group());
                String replace = nullAsNil.replace("(", "").replace(")", "").replace(" ", "");
                CharSequence replace2;
                String[] split;
                if (replace.contains("__ALLSTAYTIME__")) {
                    replace2 = replace.replace("__ALLSTAYTIME__", String.valueOf(this.uDn / 1000));
                    split = replace2.split("\\+");
                    if (split.length == 2) {
                        replace2 = String.valueOf(C5046bo.anl(split[0]) + C5046bo.anl(split[1]));
                    }
                    str = str.replace(nullAsNil, replace2);
                } else if (nullAsNil.contains("__FOREGROUNDTIME__")) {
                    replace2 = replace.replace("__FOREGROUNDTIME__", String.valueOf(this.neL / 1000));
                    split = replace2.split("\\+");
                    if (split.length == 2) {
                        replace2 = String.valueOf(C5046bo.anl(split[0]) + C5046bo.anl(split[1]));
                    }
                    str = str.replace(nullAsNil, replace2);
                }
            } catch (NumberFormatException e) {
                C4990ab.m7417i("MicroMsg.GamePageTimeReport", "matchTimeMark, err:%s", e.getMessage());
                AppMethodBeat.m2505o(8687);
                return null;
            }
        }
        AppMethodBeat.m2505o(8687);
        return str;
    }

    /* renamed from: a */
    public static /* synthetic */ void m22839a(C14610c c14610c) {
        AppMethodBeat.m2504i(8688);
        if (c14610c.mStartTime != 0) {
            c14610c.uDn = System.currentTimeMillis() - c14610c.mStartTime;
            C4990ab.m7417i("MicroMsg.GamePageTimeReport", "visit page(%s), stayTime:%sms, foregroundTime:%sms", Integer.valueOf(c14610c.hashCode()), Long.valueOf(c14610c.uDn), Long.valueOf(c14610c.neL));
            if (c14610c.uDo == null) {
                C4990ab.m7416i("MicroMsg.GamePageTimeReport", "report game page time fail. ReportData is null");
                AppMethodBeat.m2505o(8688);
                return;
            }
            String string = c14610c.uDo.getString("game_page_report_format_data");
            String string2 = c14610c.uDo.getString("game_page_report_tabs_format_data");
            if (!C5046bo.isNullOrNil(string)) {
                c14610c.uDo.putString("game_page_report_format_data", string.replace("__ALLSTAYTIME__", String.valueOf(c14610c.uDn / 1000)).replace("__FOREGROUNDTIME__", String.valueOf(c14610c.neL / 1000)));
                C4990ab.m7417i("MicroMsg.GamePageTimeReport", "visit page(%s), after replace time, reportFormatData:%s", Integer.valueOf(c14610c.hashCode()), string);
            } else if (C5046bo.isNullOrNil(string2)) {
                AppMethodBeat.m2505o(8688);
                return;
            } else {
                string = c14610c.age(string2);
                if (!C5046bo.isNullOrNil(string)) {
                    c14610c.uDo.putString("game_page_report_tabs_format_data", string);
                    C4990ab.m7417i("MicroMsg.GamePageTimeReport", "visit page(%s), after replace time, reportTabsFormatdata:%s", Integer.valueOf(c14610c.hashCode()), string);
                }
            }
            if (C4996ah.bqo()) {
                C14610c.m22840an(c14610c.uDo);
            } else {
                c14610c.mo9702I(c14610c.uDo);
            }
            c14610c.uDo = null;
        }
        AppMethodBeat.m2505o(8688);
    }
}
