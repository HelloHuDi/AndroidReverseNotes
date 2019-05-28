package com.tencent.p177mm.pluginsdk.p597ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.smtt.sdk.WebView;
import java.util.Map;

/* renamed from: com.tencent.mm.pluginsdk.ui.e */
public final class C14945e {
    private int version = 0;
    public int vgW = -7829368;
    public boolean vgX = false;
    public int vgY = -1593835521;
    public boolean vgZ = false;
    public boolean vha = false;
    private int vhb = WebView.NIGHT_MODE_COLOR;
    public boolean vhc = false;
    public int vhd = 0;
    public boolean vhe = false;

    public C14945e(String str) {
        AppMethodBeat.m2504i(105839);
        String str2 = "chatbg";
        Map z = C5049br.m7595z(str, str2);
        if (z == null) {
            C4990ab.m7412e("MicroMsg.ChatBgAttr", "parse chatbgattr failed, values is null");
            AppMethodBeat.m2505o(105839);
            return;
        }
        String concat = ".".concat(String.valueOf(str2));
        try {
            this.version = C5046bo.m7567h(Integer.valueOf((String) z.get(concat + ".$version")));
            this.vgW = (int) C5046bo.m7514a(Long.valueOf(Long.parseLong((String) z.get(concat + ".$time_color"), 16)), -7829368);
            this.vgX = C5046bo.m7546e(Boolean.valueOf((String) z.get(concat + ".$time_show_shadow_color")));
            this.vgY = (int) C5046bo.m7514a(Long.valueOf(Long.parseLong((String) z.get(concat + ".$time_shadow_color"), 16)), 0);
            this.vgZ = C5046bo.m7546e(Boolean.valueOf((String) z.get(concat + ".$time_show_background")));
            this.vha = C5046bo.m7546e(Boolean.valueOf((String) z.get(concat + ".$time_light_background")));
            this.vhb = (int) C5046bo.m7514a(Long.valueOf(Long.parseLong((String) z.get(concat + ".$voice_second_color"), 16)), -16777216);
            this.vhc = C5046bo.m7546e(Boolean.valueOf((String) z.get(concat + ".$voice_second_show_shadow_color")));
            this.vhd = (int) C5046bo.m7514a(Long.valueOf(Long.parseLong((String) z.get(concat + ".$voice_second_shadow_color"), 16)), 0);
            this.vhe = C5046bo.m7546e(Boolean.valueOf((String) z.get(concat + ".$voice_second_show_background")));
            AppMethodBeat.m2505o(105839);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.ChatBgAttr", "parse chatbgattr failed");
            C4990ab.printErrStackTrace("MicroMsg.ChatBgAttr", e, "", new Object[0]);
            AppMethodBeat.m2505o(105839);
        }
    }
}
