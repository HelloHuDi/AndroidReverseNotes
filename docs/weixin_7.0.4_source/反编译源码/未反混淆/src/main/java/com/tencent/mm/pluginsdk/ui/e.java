package com.tencent.mm.pluginsdk.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.smtt.sdk.WebView;
import java.util.Map;

public final class e {
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

    public e(String str) {
        AppMethodBeat.i(105839);
        String str2 = "chatbg";
        Map z = br.z(str, str2);
        if (z == null) {
            ab.e("MicroMsg.ChatBgAttr", "parse chatbgattr failed, values is null");
            AppMethodBeat.o(105839);
            return;
        }
        String concat = ".".concat(String.valueOf(str2));
        try {
            this.version = bo.h(Integer.valueOf((String) z.get(concat + ".$version")));
            this.vgW = (int) bo.a(Long.valueOf(Long.parseLong((String) z.get(concat + ".$time_color"), 16)), -7829368);
            this.vgX = bo.e(Boolean.valueOf((String) z.get(concat + ".$time_show_shadow_color")));
            this.vgY = (int) bo.a(Long.valueOf(Long.parseLong((String) z.get(concat + ".$time_shadow_color"), 16)), 0);
            this.vgZ = bo.e(Boolean.valueOf((String) z.get(concat + ".$time_show_background")));
            this.vha = bo.e(Boolean.valueOf((String) z.get(concat + ".$time_light_background")));
            this.vhb = (int) bo.a(Long.valueOf(Long.parseLong((String) z.get(concat + ".$voice_second_color"), 16)), -16777216);
            this.vhc = bo.e(Boolean.valueOf((String) z.get(concat + ".$voice_second_show_shadow_color")));
            this.vhd = (int) bo.a(Long.valueOf(Long.parseLong((String) z.get(concat + ".$voice_second_shadow_color"), 16)), 0);
            this.vhe = bo.e(Boolean.valueOf((String) z.get(concat + ".$voice_second_show_background")));
            AppMethodBeat.o(105839);
        } catch (Exception e) {
            ab.e("MicroMsg.ChatBgAttr", "parse chatbgattr failed");
            ab.printErrStackTrace("MicroMsg.ChatBgAttr", e, "", new Object[0]);
            AppMethodBeat.o(105839);
        }
    }
}
